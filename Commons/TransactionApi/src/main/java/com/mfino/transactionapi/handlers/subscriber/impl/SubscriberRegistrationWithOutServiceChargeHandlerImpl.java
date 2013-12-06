package com.mfino.transactionapi.handlers.subscriber.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.Notification;
import com.mfino.domain.Partner;
import com.mfino.domain.Pocket;
import com.mfino.domain.ServiceCharge;
import com.mfino.domain.ServiceChargeTransactionLog;
import com.mfino.domain.Subscriber;
import com.mfino.domain.SubscriberMDN;
import com.mfino.domain.Transaction;
import com.mfino.domain.TransactionsLog;
import com.mfino.exceptions.InvalidChargeDefinitionException;
import com.mfino.exceptions.InvalidServiceException;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMSubscriberRegistration;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.hibernate.Timestamp;
import com.mfino.i18n.MessageText;
import com.mfino.mailer.NotificationWrapper;
import com.mfino.result.Result;
import com.mfino.result.XMLResult;
import com.mfino.service.NotificationMessageParserService;
import com.mfino.service.NotificationService;
import com.mfino.service.PartnerService;
import com.mfino.service.SMSService;
import com.mfino.service.SubscriberMdnService;
import com.mfino.service.SubscriberService;
import com.mfino.service.SubscriberServiceExtended;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionChargingService;
import com.mfino.service.TransactionLogService;
import com.mfino.transactionapi.handlers.subscriber.SubscriberRegistrationWithOutServiceChargeHandler;
import com.mfino.transactionapi.result.xmlresulttypes.subscriber.RegistrationXMLResult;
import com.mfino.transactionapi.service.TransactionApiValidationService;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.util.MfinoUtil;

/*
 *
 * @author Bala Sunku
 */
@Service("SubscriberRegistrationWithOutServiceChargeHandlerImpl")
public class SubscriberRegistrationWithOutServiceChargeHandlerImpl extends FIXMessageHandler implements SubscriberRegistrationWithOutServiceChargeHandler{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	private CMSubscriberRegistration subscriberRegistration;

	@Autowired
	@Qualifier("TransactionApiValidationServiceImpl")
	private TransactionApiValidationService transactionApiValidationService;
	
	@Autowired
	@Qualifier("NotificationServiceImpl")
	private NotificationService notificationService;
	
	@Autowired
	@Qualifier("PartnerServiceImpl")
	private PartnerService partnerService;
	
	@Autowired
	@Qualifier("SubscriberMdnServiceImpl")
	private SubscriberMdnService subscriberMdnService;
	
	@Autowired
	@Qualifier("SubscriberServiceExtendedImpl")
	private SubscriberServiceExtended subscriberServiceExtended;
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService ;

	@Autowired
	@Qualifier("TransactionChargingServiceImpl")
	private TransactionChargingService transactionChargingService ;

	@Autowired
	@Qualifier("TransactionLogServiceImpl")
	private TransactionLogService transactionLogService;
	
	@Autowired
	@Qualifier("SubscriberServiceImpl")
	private SubscriberService subscriberService;
	
	@Autowired
	@Qualifier("NotificationMessageParserServiceImpl")
	private NotificationMessageParserService notificationMessageParserService;
	
	@Autowired
	@Qualifier("SMSServiceImpl")
	private SMSService smsService;
	
	public Result handle(TransactionDetails txnDetails) {
		subscriberRegistration = new CMSubscriberRegistration();
		ChannelCode cc = txnDetails.getCc();		
		subscriberRegistration.setSourceMDN(txnDetails.getSourceMDN());
		subscriberRegistration.setMDN(subscriberService.normalizeMDN(txnDetails.getDestMDN()));
		subscriberRegistration.setFirstName(txnDetails.getFirstName());
		subscriberRegistration.setLastName(txnDetails.getLastName());
		subscriberRegistration.setMothersMaidenName(txnDetails.getMothersMaidenName());
		subscriberRegistration.setApplicationID(txnDetails.getApplicationId());
		subscriberRegistration.setDateOfBirth(new Timestamp(txnDetails.getDateOfBirth()));
		subscriberRegistration.setKYCLevel(Long.parseLong(txnDetails.getAccountType()));
		subscriberRegistration.setChannelCode(cc.getChannelCode());
		subscriberRegistration.setSourceApplication(cc.getChannelSourceApplication());
		subscriberRegistration.setPin(txnDetails.getSourcePIN());
		subscriberRegistration.setTransactionIdentifier(txnDetails.getTransactionIdentifier());
		
		TransactionsLog transactionsLog = null;
		log.info("Handling subscriber services Registration webapi request");
		XMLResult result = new RegistrationXMLResult();

		transactionsLog = transactionLogService.saveTransactionsLog(CmFinoFIX.MessageType_SubscriberRegistration,subscriberRegistration.DumpFields());
		result.setSourceMessage(subscriberRegistration);
		result.setDestinationMDN(subscriberRegistration.getMDN());
		result.setTransactionTime(transactionsLog.getTransactionTime());
		result.setTransactionID(transactionsLog.getID());
		subscriberRegistration.setTransactionID(transactionsLog.getID());

		result.setActivityStatus(false);
		
		SubscriberMDN agentMDN = subscriberMdnService.getByMDN(subscriberRegistration.getSourceMDN());
		Integer validationResult = transactionApiValidationService.validateAgentMDN(agentMDN);
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			validationResult = processValidationResultForAgent(validationResult); // Gets the corresponding Agent Notification message
			result.setNotificationCode(validationResult);
			return result;
		}
		
		validationResult = transactionApiValidationService.validatePin(agentMDN, subscriberRegistration.getPin());
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			validationResult = processValidationResultForAgent(validationResult); // Gets the corresponding Agent Notification message
			result.setNotificationCode(validationResult);
			result.setNumberOfTriesLeft(systemParametersService.getInteger(SystemParameterKeys.MAX_WRONGPIN_COUNT)-agentMDN.getWrongPINCount());
			return result;
		}

		// Check whether the agent has the Service or not.

		Transaction transactionDetails = null;
		ServiceCharge sc = new ServiceCharge();
		sc.setSourceMDN(subscriberRegistration.getSourceMDN());
		sc.setDestMDN(subscriberRegistration.getMDN());
		sc.setChannelCodeId(cc.getID());
		sc.setServiceName(ServiceAndTransactionConstants.SERVICE_AGENT);
		sc.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_SUBSCRIBERREGISTRATION);
		sc.setTransactionAmount(BigDecimal.ZERO);
		sc.setTransactionLogId(transactionsLog.getID());
		sc.setTransactionIdentifier(subscriberRegistration.getTransactionIdentifier());

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
		subscriberRegistration.setServiceChargeTransactionLogID(sctl.getID());
		try{
			if (!transactionChargingService.checksPartnerService(sc)) {
				log.info("Service Not Registered for the Agent");
				result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNOTAvailableForAgent);
				transactionChargingService.failTheTransaction(sctl, MessageText._("Service Not Registered for the Agent"));
				return result;
			}
		}catch (InvalidServiceException e) {
			log.error("Exception occured in getting charges",e);
			result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNotAvailable);
			transactionChargingService.failTheTransaction(sctl, MessageText._("Service Not Avialable"));
			return result;
		}

		Subscriber subscriber = new Subscriber();
		SubscriberMDN subscriberMDN = new SubscriberMDN();
		Pocket epocket = new Pocket();
		Integer OTPLength = systemParametersService.getOTPLength();
		String oneTimePin = MfinoUtil.generateOTP(OTPLength);
		Partner partner = partnerService.getPartner(agentMDN);
		subscriber.setRegisteringPartnerID(partner.getID());
		Integer regResponse = subscriberServiceExtended.registerSubscriber(subscriber, subscriberMDN, subscriberRegistration,
				epocket,oneTimePin,partner);
		if (!regResponse.equals(CmFinoFIX.ResponseCode_Success)) {
			Notification notification = notificationService.getByNoticationCode(regResponse);
			String notificationName = null;
			if(notification != null){
				notificationName = notification.getCodeName();
			}else{
				log.error("Could not find the failure notification code: "+regResponse);
			}
			result.setActivityStatus(false);
			result.setNotificationCode(regResponse);
			transactionChargingService.failTheTransaction(sctl, MessageText._("Subscriber Registration failed. Notification Code: "+regResponse+" NotificationName: "+notificationName));
			sendSMS(subscriberRegistration, oneTimePin, false);
		}else{
			result.setActivityStatus(true);
			result.setNotificationCode(CmFinoFIX.NotificationCode_SubscriberRegistrationSuccessfulToAgent);
			if (sctl != null) {
				// Calculate the Commission and generates the logs for the same
				sc.setSctlId(sctl.getID());
				try{
					transactionDetails =transactionChargingService.getCharge(sc);
				} catch (InvalidChargeDefinitionException e) {
					log.error(e.getMessage());
				} catch (Exception e) {
					log.error("Exception occured in getting charges for Registration",e);
				}
//				sctl.setCalculatedCharge(BigDecimal.ZERO);
				transactionChargingService.confirmTheTransaction(sctl);
			}
			sendSMS(subscriberRegistration, oneTimePin, true);
		}

		result.setSctlID(sctl.getID());
		return result;

	}

	private void sendSMS(CMSubscriberRegistration subscriberRegistration, String oneTimePin, boolean registartionStatus) {

		smsService.setSctlId(subscriberRegistration.getServiceChargeTransactionLogID());
		NotificationWrapper notificationWrapper=new NotificationWrapper();
		SubscriberMDN subMDN = subscriberMdnService.getByMDN(subscriberRegistration.getSourceMDN());
		if(subMDN != null)
		{
			notificationWrapper.setFirstName(subMDN.getSubscriber().getFirstName());
			notificationWrapper.setLastName(subMDN.getSubscriber().getLastName());
		}
		if(registartionStatus){
			notificationWrapper.setCode(CmFinoFIX.NotificationCode_SubscriberRegistrationSuccessfulToSubscriber);
			notificationWrapper.setOneTimePin(oneTimePin);
			notificationWrapper.setDestMDN(subscriberRegistration.getMDN());
			smsService.setDestinationMDN(subscriberRegistration.getMDN());
			notificationWrapper.setNotificationMethod(CmFinoFIX.NotificationMethod_SMS);
			smsService.setMessage(notificationMessageParserService.buildMessage(notificationWrapper,true));
			smsService.send();

			notificationWrapper.setCode(CmFinoFIX.NotificationCode_SubscriberRegistrationSuccessfulToAgent);
			notificationWrapper.setDestMDN(subscriberRegistration.getMDN());
			smsService.setDestinationMDN(subscriberRegistration.getSourceMDN());
			notificationWrapper.setNotificationMethod(CmFinoFIX.NotificationMethod_SMS);
			smsService.setMessage(notificationMessageParserService.buildMessage(notificationWrapper,true));
			smsService.send();
		}else{
			notificationWrapper.setCode(CmFinoFIX.NotificationCode_SubscriberRegistrationfailedToAgent);
			notificationWrapper.setDestMDN(subscriberRegistration.getMDN());
			smsService.setDestinationMDN(subscriberRegistration.getSourceMDN());
			notificationWrapper.setNotificationMethod(CmFinoFIX.NotificationMethod_SMS);
			smsService.setMessage(notificationMessageParserService.buildMessage(notificationWrapper,true));
			smsService.send();
		}
	}
}
