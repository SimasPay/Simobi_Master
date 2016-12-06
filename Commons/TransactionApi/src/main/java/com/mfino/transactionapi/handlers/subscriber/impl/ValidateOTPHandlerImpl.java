package com.mfino.transactionapi.handlers.subscriber.impl;


import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.constants.SystemParameterKeys;
import com.mfino.dao.DAOFactory;
import com.mfino.dao.MdnOtpDAO;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.MdnOtp;
import com.mfino.domain.SubscriberMdn;
import com.mfino.domain.TransactionLog;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMValidateOTP;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.result.XMLResult;
import com.mfino.service.SubscriberMdnService;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionLogService;
import com.mfino.transactionapi.handlers.subscriber.ValidateOTPHandler;
import com.mfino.transactionapi.result.xmlresulttypes.subscriber.ValidateOtpXMLResult;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.util.MfinoUtil;

/**
 * 
 * @author Amar
 *
 */
@Service("ValidateOTPHandlerImpl")
public class ValidateOTPHandlerImpl extends FIXMessageHandler implements ValidateOTPHandler{
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("TransactionLogServiceImpl")
	private TransactionLogService transactionLogService;
	
	@Autowired
	@Qualifier("SubscriberMdnServiceImpl")
	private SubscriberMdnService subscriberMdnService;
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService;
	
	public XMLResult handle(TransactionDetails txnDetails) {
		
		CMValidateOTP validateOTP= new CMValidateOTP();
		ChannelCode cc = txnDetails.getCc();
		
		validateOTP.setMDN(txnDetails.getSourceMDN());
		validateOTP.setOTP(txnDetails.getActivationOTP());
		validateOTP.setChannelCode(cc.getChannelcode());
		validateOTP.setSourceApplication((int)cc.getChannelsourceapplication());
		validateOTP.setTransactionIdentifier(txnDetails.getTransactionIdentifier());

		TransactionLog transactionsLog = null;
		log.info("Handling ValidateOTP webapi request");
		XMLResult result = new ValidateOtpXMLResult();

		transactionsLog = transactionLogService.saveTransactionsLog(CmFinoFIX.MessageType_ValidateOTP,validateOTP.DumpFields());
		result.setSourceMessage(validateOTP);
		result.setDestinationMDN(validateOTP.getMDN());
		result.setTransactionTime(transactionsLog.getTransactiontime());
		result.setTransactionID(transactionsLog.getId().longValue());
		validateOTP.setTransactionID(transactionsLog.getId().longValue());
		result.setActivityStatus(false);

		MdnOtpDAO mdnOtpDao = DAOFactory.getInstance().getMdnOtpDAO();
		MdnOtp mdnOtp = null;
		
		if(null != txnDetails.getIdNumber()) {
			
			Long idNumber = new Long(txnDetails.getIdNumber());
			mdnOtp = mdnOtpDao.getByMDNAndId(validateOTP.getMDN(),idNumber);
			
		} else {
			
			List<MdnOtp> mdnList = mdnOtpDao.getByMdn(validateOTP.getMDN());
			
			if(null != mdnList) {
				
				mdnOtp = mdnList.get(0);
			}
		}
		
		if (mdnOtp != null) {
			
			String receivedOTP = validateOTP.getOTP();
			String receivedOTPDigest = MfinoUtil.calculateDigestPin(validateOTP.getMDN(), receivedOTP);

			if(CmFinoFIX.OTPStatus_FailedOrExpired.equals(mdnOtp.getStatus())) {
				result.setNotificationCode(CmFinoFIX.NotificationCode_OTPExpired);
				log.info("OTP validation failed for MDN " + validateOTP.getMDN());
			}
			else if (mdnOtp.getOtpexpirationtime().after(new Date()) ) {
				
				if(mdnOtp.getOtp().equals(receivedOTPDigest)) {
					
					mdnOtp.setStatus(CmFinoFIX.OTPStatus_Validated);
					mdnOtpDao.save(mdnOtp);
					result.setNotificationCode(CmFinoFIX.NotificationCode_OTPValidationSuccessful);
					SubscriberMdn subscriberMDN = subscriberMdnService.getNotRetiredSubscriberMDN(validateOTP.getMDN());
					
					if(subscriberMDN!=null){
						
						result.setUnRegistered(false);
					
					} else{
						
						result.setUnRegistered(true);
					}
					
					log.info("OTP validation successful for MDN " + validateOTP.getMDN());
					
				} else {
					
					int currentOtpTrials = mdnOtp.getOtpretrycount().intValue()+1;
					mdnOtp.setOtpretrycount((long)currentOtpTrials);
					int remainingTrials = getNumberOfRemainingTrials(currentOtpTrials);
					result.setNumberOfTriesLeft(remainingTrials);
					result.setNotificationCode(CmFinoFIX.NotificationCode_OTPInvalid);
					if(remainingTrials < 0){
						mdnOtp.setStatus(CmFinoFIX.OTPStatus_FailedOrExpired);
						result.setNotificationCode(CmFinoFIX.NotificationCode_OTPExpired);
						log.info("OTP expired for MDN " + validateOTP.getMDN());					
					}
					mdnOtpDao.save(mdnOtp);
					log.info("Invalid OTP for MDN " + validateOTP.getMDN());					
				}
				
			} else{
				
				mdnOtp.setStatus(CmFinoFIX.OTPStatus_FailedOrExpired);
				mdnOtpDao.save(mdnOtp);
				result.setActivityStatus(false);
				result.setNotificationCode(CmFinoFIX.NotificationCode_OTPExpired);
				log.info("OTP validation failed for MDN " + validateOTP.getMDN());
			}
			
		} else {
			
			result.setNotificationCode(CmFinoFIX.NotificationCode_MDNNotFound);
			log.info("MDN " +  validateOTP.getMDN() + "doesn't exist");
		}
		
		return result;
	}

	private int getNumberOfRemainingTrials(int currentOtpTrials) {
		
		int maxOtpTrials = systemParametersService.getInteger(SystemParameterKeys.MAX_OTP_TRAILS);
		return (maxOtpTrials-currentOtpTrials);
	}
}