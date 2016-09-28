package com.mfino.transactionapi.handlers.subscriber.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.ServiceCharge;
import com.mfino.domain.ServiceChargeTransactionLog;
import com.mfino.domain.SubscriberMdn;
import com.mfino.domain.Transaction;
import com.mfino.domain.TransactionsLog;
import com.mfino.exceptions.InvalidChargeDefinitionException;
import com.mfino.exceptions.InvalidServiceException;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMChangePin;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.i18n.MessageText;
import com.mfino.result.Result;
import com.mfino.result.XMLResult;
import com.mfino.service.MfinoUtilService;
import com.mfino.service.SubscriberMdnService;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionChargingService;
import com.mfino.service.TransactionLogService;
import com.mfino.transactionapi.handlers.subscriber.ChangePinHandler;
import com.mfino.transactionapi.result.xmlresulttypes.subscriber.ChangePinXMLResult;
import com.mfino.transactionapi.service.TransactionApiValidationService;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.util.ConfigurationUtil;
import com.mfino.util.MfinoUtil;

/*
 * @author Karthik Gurram
 */
@Service("ChangePinHandlerImpl")
public class ChangePinHandlerImpl extends FIXMessageHandler implements ChangePinHandler{
	private static Logger	log	= LoggerFactory.getLogger(ChangePinHandlerImpl.class);

	@Autowired
	@Qualifier("MfinoUtilServiceImpl")
	private MfinoUtilService mfinoUtilService;
	
	@Autowired
	@Qualifier("TransactionApiValidationServiceImpl")
	private TransactionApiValidationService transactionApiValidationService;
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService;

	@Autowired
	@Qualifier("TransactionChargingServiceImpl")
	private TransactionChargingService transactionChargingService ;
	
	@Autowired
	@Qualifier("SubscriberMdnServiceImpl")
	private SubscriberMdnService subscriberMdnService;


	@Autowired
	@Qualifier("TransactionLogServiceImpl")
	private TransactionLogService transactionLogService;
	
	public Result handle(TransactionDetails transDetails) {
		
		CMChangePin changePin = new CMChangePin();
		ChannelCode cc = transDetails.getCc();
		
		changePin.setSourceMDN(transDetails.getSourceMDN());
		changePin.setOldPin(transDetails.getSourcePIN());
		changePin.setNewPin(transDetails.getNewPIN());
		changePin.setConfirmPin(transDetails.getConfirmPIN());
		changePin.setChannelCode(cc.getChannelcode());
		changePin.setTransactionIdentifier(transDetails.getTransactionIdentifier());
		
		log.info("Handling Subscriber ResetPin webapi request");
		XMLResult result = new ChangePinXMLResult();

		TransactionsLog transactionLog = transactionLogService.saveTransactionsLog(CmFinoFIX.MessageType_ChangePin, changePin.DumpFields());
		changePin.setTransactionID(transactionLog.getID());

		result.setSourceMessage(changePin);
		result.setTransactionTime(transactionLog.getTransactionTime());
		result.setTransactionID(transactionLog.getID());
		

		SubscriberMdn sourceMDN = subscriberMdnService.getByMDN(changePin.getSourceMDN());
		Integer validationResult = transactionApiValidationService.validateSubscriberAsSource(sourceMDN);
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			log.error("Subscriber with mdn : "+changePin.getSourceMDN()+" has failed validations");
			result.setNotificationCode(validationResult);
			return result;

		}
		

		if (!changePin.getNewPin().equals(changePin.getConfirmPin())) {
			result.setNotificationCode(CmFinoFIX.NotificationCode_ChangeEPINFailedInvalidConfirmPIN);
			return result;
		}
		/**
		 * no need of these validations when using HSM hashed pin since pin would be 
		 * generated from the hash and it bound be correct length
		 */ 
		if(!ConfigurationUtil.getuseHashedPIN())
		{
		if (changePin.getNewPin().length() != systemParametersService.getPinLength()) {
			result.setNotificationCode(CmFinoFIX.NotificationCode_ChangeEPINFailedInvalidPINLength);
			return result;
		}
		if (!StringUtils.isNumeric(changePin.getNewPin())) {
			result.setNotificationCode(CmFinoFIX.NotificationCode_OnlyNumericPinAllowed);
			return result;
		}

		log.info("checking for new pin strength for subscribermdn "+changePin.getSourceMDN() );
		if(!MfinoUtil.isPinStrongEnough(changePin.getNewPin())){
		   log.info("The pin is not strong enough for subscribermdn "+changePin.getSourceMDN() );
		   result.setNotificationCode(CmFinoFIX.NotificationCode_PinNotStrongEnough);
		   return result;
		}
		log.info("Pin passed strength conditions");
		}
		else
		{
			log.info("Since hashed pin is enabled, pin length and pin strength checks are not performed");
		}
		
		if (changePin.getOldPin().equals(changePin.getNewPin())) {
			result.setNotificationCode(CmFinoFIX.NotificationCode_ChangeEPINFailedIndenticalCurrentPINEntered);
			return result;
		}
		validationResult = transactionApiValidationService.validatePin(sourceMDN, changePin.getOldPin());
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			result.setNotificationCode(validationResult);
			result.setNumberOfTriesLeft((int)(systemParametersService.getInteger(SystemParameterKeys.MAX_WRONGPIN_COUNT)-sourceMDN.getWrongpincount()));
			return result;
		}


		Transaction transactionDetails = null;
		ServiceCharge sc = new ServiceCharge();
		sc.setSourceMDN(changePin.getSourceMDN());
		sc.setDestMDN(null);
		sc.setChannelCodeId(StringUtils.isNotBlank(changePin.getChannelCode()) ? Long.valueOf(changePin.getChannelCode()) : null);
		sc.setServiceName(ServiceAndTransactionConstants.SERVICE_ACCOUNT);
		sc.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_CHANGEPIN);
		sc.setTransactionAmount(BigDecimal.ZERO);
		sc.setTransactionLogId(changePin.getTransactionID());
		sc.setTransactionIdentifier(changePin.getTransactionIdentifier());

		try{
			transactionDetails =transactionChargingService.getCharge(sc);
		}catch (InvalidServiceException e) {
			log.error("Exception occured in getting charges",e);
			result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNotAvailable);
			return result;
		} catch (InvalidChargeDefinitionException e) {
			log.error(e.getMessage());
			result.setNotificationCode(CmFinoFIX.NotificationCode_InvalidChargeDefinitionException);
			return result;
		}
		ServiceChargeTransactionLog sctl = transactionDetails.getServiceChargeTransactionLog();
		result.setSctlID(sctl.getID());
		try {

			//String calcPIN = MfinoUtil.calculateDigestPin(changePin.getSourceMDN(), changePin.getNewPin());
			String calcPIN = mfinoUtilService.modifyPINForStoring(changePin.getSourceMDN(), changePin.getNewPin());
			sourceMDN.setDigestedpin(calcPIN);
			String authToken = MfinoUtil.calculateAuthorizationToken(changePin.getSourceMDN(), changePin.getNewPin());
			sourceMDN.setAuthorizationtoken(authToken);
			subscriberMdnService.saveSubscriberMDN(sourceMDN);
		}
		catch (Exception ex) {
			log.error("Exception occured while updating the new pin", ex);
			result.setNotificationCode(CmFinoFIX.NotificationCode_Failure);
			if (sctl != null) {
				transactionChargingService.failTheTransaction(sctl, MessageText._("Change Pin transaction Falied"));
			}
			return result;
		}
		if (sctl != null) {
			sctl.setCalculatedCharge(BigDecimal.ZERO);
			transactionChargingService.completeTheTransaction(sctl);
		}
		result.setNotificationCode(CmFinoFIX.NotificationCode_ChangePINCompleted);
		return result;

	}
}