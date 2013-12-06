package com.mfino.transactionapi.handlers.subscriber.impl;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mfino.dao.DAOFactory;
import com.mfino.dao.MdnOtpDAO;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.MdnOtp;
import com.mfino.domain.SubscriberMDN;
import com.mfino.domain.TransactionsLog;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMValidateOTP;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.result.XMLResult;
import com.mfino.service.SubscriberMdnService;
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
	
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	public XMLResult handle(TransactionDetails txnDetails) {
		CMValidateOTP validateOTP= new CMValidateOTP();
		ChannelCode cc = txnDetails.getCc();
		
		validateOTP.setMDN(txnDetails.getSourceMDN());
		validateOTP.setOTP(txnDetails.getActivationOTP());
		validateOTP.setChannelCode(cc.getChannelCode());
		validateOTP.setSourceApplication(cc.getChannelSourceApplication());
		validateOTP.setTransactionIdentifier(txnDetails.getTransactionIdentifier());

		TransactionsLog transactionsLog = null;
		log.info("Handling ValidateOTP webapi request");
		XMLResult result = new ValidateOtpXMLResult();

		transactionsLog = transactionLogService.saveTransactionsLog(CmFinoFIX.MessageType_GenerateOTP,validateOTP.DumpFields());
		result.setSourceMessage(validateOTP);
		result.setDestinationMDN(validateOTP.getMDN());
		result.setTransactionTime(transactionsLog.getTransactionTime());
		result.setTransactionID(transactionsLog.getID());
		validateOTP.setTransactionID(transactionsLog.getID());
		//addCompanyANDLanguageToResult(result);
		result.setActivityStatus(false);

		MdnOtpDAO mdnOtpDao = DAOFactory.getInstance().getMdnOtpDAO();
		Long idNumber = new Long(txnDetails.getIdNumber());
		MdnOtp mdnOtp = mdnOtpDao.getByMDNAndId(validateOTP.getMDN(),idNumber);
		if (mdnOtp != null)
		{
			String receivedOTP = validateOTP.getOTP();
			String receivedOTPDigest = MfinoUtil.calculateDigestPin(validateOTP.getMDN(), receivedOTP);

			if (mdnOtp.getOTPExpirationTime().after(new Date()) ) {
				if(mdnOtp.getOTP().equals(receivedOTPDigest))
				{
					mdnOtp.setStatus(CmFinoFIX.OTPStatus_Validated);
					mdnOtpDao.save(mdnOtp);
					result.setNotificationCode(CmFinoFIX.NotificationCode_OTPValidationSuccessful);
					SubscriberMDN subscriberMDN = subscriberMdnService.getNotRetiredSubscriberMDN(validateOTP.getMDN());
					if(subscriberMDN!=null){
						result.setUnRegistered(false);
					}
					else{
						result.setUnRegistered(true);
					}
					log.info("OTP validation successful for MDN " + validateOTP.getMDN());
				}
				else
				{
					mdnOtp.setStatus(CmFinoFIX.OTPStatus_FailedOrExpired);
					mdnOtpDao.save(mdnOtp);
					result.setNotificationCode(CmFinoFIX.NotificationCode_OTPInvalid);
					log.info("OTP expired for MDN " + validateOTP.getMDN());					
				}
			}
			else
			{
				mdnOtp.setStatus(CmFinoFIX.OTPStatus_FailedOrExpired);
				mdnOtpDao.save(mdnOtp);
				result.setActivityStatus(false);
				result.setNotificationCode(CmFinoFIX.NotificationCode_OTPExpired);
				log.info("OTP validation failed for MDN " + validateOTP.getMDN());
			}
		}
		else
		{
			result.setNotificationCode(CmFinoFIX.NotificationCode_MDNNotFound);
			log.info("MDN " +  validateOTP.getMDN() + "doesn't exist");
		}
		return result;
	}
}
