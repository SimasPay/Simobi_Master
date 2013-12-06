/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mfino.transactionapi.handlers.mobileshopping.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.Partner;
import com.mfino.domain.PartnerServices;
import com.mfino.domain.Pocket;
import com.mfino.domain.ServiceCharge;
import com.mfino.domain.ServiceChargeTransactionLog;
import com.mfino.domain.SubscriberMDN;
import com.mfino.domain.Transaction;
import com.mfino.domain.TransactionResponse;
import com.mfino.domain.TransactionsLog;
import com.mfino.exceptions.InvalidChargeDefinitionException;
import com.mfino.exceptions.InvalidServiceException;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMPurchaseInquiry;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.result.Result;
import com.mfino.result.XMLResult;
import com.mfino.service.PartnerService;
import com.mfino.service.PocketService;
import com.mfino.service.SubscriberMdnService;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionChargingService;
import com.mfino.service.TransactionLogService;
import com.mfino.transactionapi.handlers.mobileshopping.PurchaseInquiryHandler;
import com.mfino.transactionapi.result.xmlresulttypes.money.TransferInquiryXMLResult;
import com.mfino.transactionapi.service.TransactionApiValidationService;
import com.mfino.transactionapi.vo.TransactionDetails;

/**
 *
 * @author Srinu
 */
@Service("PurchaseInquiryHandlerImpl")
public class PurchaseInquiryHandlerImpl extends FIXMessageHandler implements PurchaseInquiryHandler{

	private static Logger log = LoggerFactory.getLogger(PurchaseInquiryHandlerImpl.class);

	@Autowired
	@Qualifier("TransactionApiValidationServiceImpl")
	private TransactionApiValidationService transactionApiValidationService;

	@Autowired
	@Qualifier("TransactionChargingServiceImpl")
	private TransactionChargingService transactionChargingService ;

	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService ;

	@Autowired
	@Qualifier("PartnerServiceImpl")
	private PartnerService partnerService;
	
	@Autowired
	@Qualifier("SubscriberMdnServiceImpl")
	private SubscriberMdnService subscriberMdnService;

	@Autowired
	@Qualifier("PocketServiceImpl")
	private PocketService pocketService;

	@Autowired
	@Qualifier("TransactionLogServiceImpl")
	private TransactionLogService transactionLogService;
	
	public Result handle(TransactionDetails transactionDetails)
	{
		log.info("Extracting data from transactionDetails in PurchaseInquiryHandlerImpl from sourceMDN: "+transactionDetails.getSourceMDN()
				+"to"+transactionDetails.getDestMDN());
		CMPurchaseInquiry purchaseInquiry = new CMPurchaseInquiry();
		ChannelCode cc = transactionDetails.getCc();
		purchaseInquiry.setSourceMDN(transactionDetails.getSourceMDN());
		purchaseInquiry.setPartnerCode(transactionDetails.getPartnerCode());
		purchaseInquiry.setPin(transactionDetails.getSourcePIN());
		purchaseInquiry.setAmount(transactionDetails.getAmount());
		purchaseInquiry.setSourceApplication(cc.getChannelSourceApplication());
		purchaseInquiry.setChannelCode(cc.getChannelCode());
		purchaseInquiry.setServletPath(CmFinoFIX.ServletPath_Subscribers);
		purchaseInquiry.setSourceMessage(transactionDetails.getSourceMessage());
		purchaseInquiry.setDescription(transactionDetails.getDescription());
		String billNo = transactionDetails.getBillNum();
		purchaseInquiry.setTransactionIdentifier(transactionDetails.getTransactionIdentifier());
		log.info("Handling Subscriber purchase Inquiry webapi request ::From "+purchaseInquiry.getSourceMDN()+
				"for Amount: "+purchaseInquiry.getAmount());
		XMLResult result = new TransferInquiryXMLResult();

		TransactionsLog transactionsLog = transactionLogService.saveTransactionsLog(CmFinoFIX.MessageType_PurchaseInquiry, purchaseInquiry.DumpFields());
		purchaseInquiry.setTransactionID(transactionsLog.getID());
		result.setTransactionID(transactionsLog.getID());
		result.setSourceMessage(purchaseInquiry);
		result.setTransactionTime(transactionsLog.getTransactionTime());

		SubscriberMDN srcSubscriberMDN = subscriberMdnService.getByMDN(purchaseInquiry.getSourceMDN());

		Integer validationResult = transactionApiValidationService.validateSubscriberAsSource(srcSubscriberMDN);
		if(!CmFinoFIX.ResponseCode_Success.equals(validationResult)){
			log.error("Source subscriber with mdn : "+purchaseInquiry.getSourceMDN()+" has failed validations");
			result.setNotificationCode(validationResult);
			return result;
		}
		
		Pocket srcSubscriberPocket = pocketService.getDefaultPocket(srcSubscriberMDN, transactionDetails.getSourcePocketCode());
		validationResult = transactionApiValidationService.validateSourcePocket(srcSubscriberPocket);
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			log.error("Source pocket with id "+(srcSubscriberPocket!=null? srcSubscriberPocket.getID():null)+" has failed validations");
			result.setNotificationCode(validationResult);
			return result;
		}
		
		List<Pocket> pocketList = new ArrayList<Pocket>();
		pocketList.add(srcSubscriberPocket);
		result.setPocketList(pocketList);

		Partner destMerchant = partnerService.getPartnerByPartnerCode(purchaseInquiry.getPartnerCode());
		validationResult = transactionApiValidationService.validateMerchantByPartnerType(destMerchant);
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			log.error("Destination Agent has failed validations");
			result.setPartnerCode(purchaseInquiry.getPartnerCode());
			validationResult = processValidationResultForDestinationAgent(validationResult); // Gets the corresponding Agent Notification message
			result.setNotificationCode(validationResult);
			return result;
		}
		SubscriberMDN destMerchantMDN = destMerchant.getSubscriber().getSubscriberMDNFromSubscriberID().iterator().next();

		// add service charge to amount

		log.info("creating the serviceCharge object....");
		ServiceCharge sc=new ServiceCharge();
		sc.setChannelCodeId(cc.getID());
		sc.setDestMDN(destMerchantMDN.getMDN());
		sc.setServiceName(ServiceAndTransactionConstants.SERVICE_SHOPPING);//change to service
		sc.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_PURCHASE);
		sc.setSourceMDN(srcSubscriberMDN.getMDN());
		sc.setTransactionAmount(purchaseInquiry.getAmount());
		sc.setMfsBillerCode(purchaseInquiry.getPartnerCode());
		sc.setTransactionLogId(purchaseInquiry.getTransactionID());
		sc.setInvoiceNo(billNo);
		sc.setTransactionIdentifier(purchaseInquiry.getTransactionIdentifier());
		sc.setDescription(purchaseInquiry.getDescription());

		Pocket destMerchantPocket;
		try {
			long servicePartnerId = transactionChargingService.getServiceProviderId(null);
			long serviceId = transactionChargingService.getServiceId(sc.getServiceName());
			PartnerServices partnerServices = transactionChargingService.getPartnerService(destMerchant.getID(), servicePartnerId, serviceId);
			if (partnerServices == null) {
				log.error("PartnerService obtained null ");
				result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNOTAvailableForAgent);
				return result;
			}
			destMerchantPocket = partnerServices.getPocketByDestPocketID();
			validationResult = transactionApiValidationService.validateDestinationPocket(destMerchantPocket);
			if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
				log.error("Destination pocket with id "+(destMerchantPocket!=null? destMerchantPocket.getID():null)+" has failed validations");
				result.setNotificationCode(validationResult);
				return result;
			}
		} catch (InvalidServiceException e) {
			log.error("Exception occured in getting Source Pocket",e);
			result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNotAvailable);
			return result;
		}
		if(srcSubscriberPocket.getPocketTemplate().getType().equals(CmFinoFIX.PocketType_BankAccount)||destMerchantPocket.getPocketTemplate().getType().equals(CmFinoFIX.PocketType_BankAccount))
		{
			if(!systemParametersService.getBankServiceStatus())
			{
				log.info("The bank service is down as set in the system parameter");
				result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNotAvailable);
				return result;
			}
		}
		Transaction transaction=null;
		try{
			transaction =transactionChargingService.getCharge(sc);
			purchaseInquiry.setAmount(transaction.getAmountToCredit());
			purchaseInquiry.setCharges(transaction.getAmountTowardsCharges());
		} catch (InvalidServiceException e) {
			log.error("Exception occured in getting charges",e);
			result.setNotificationCode(CmFinoFIX.NotificationCode_ServiceNotAvailable);//change to service not found
			return result;
		} catch (InvalidChargeDefinitionException e) {
			log.error(e.getMessage());
			result.setNotificationCode(CmFinoFIX.NotificationCode_InvalidChargeDefinitionException);
			return result;
		}
		ServiceChargeTransactionLog sctl = transaction.getServiceChargeTransactionLog();

		purchaseInquiry.setServiceChargeTransactionLogID(sctl.getID());
		purchaseInquiry.setDestMDN(destMerchantMDN.getMDN());
		purchaseInquiry.setCharges(transaction.getAmountTowardsCharges());
		purchaseInquiry.setChannelCode(cc.getChannelCode());
		purchaseInquiry.setSourcePocketID(srcSubscriberPocket.getID());
		purchaseInquiry.setDestPocketID(destMerchantPocket.getID());
		purchaseInquiry.setSourceApplication(cc.getChannelSourceApplication());

		log.info("sending the purchaseInquiry request to backend for processing");
		CFIXMsg response = super.process(purchaseInquiry);

		// Saves the Transaction Id returned from Back End		
		TransactionResponse transactionResponse = checkBackEndResponse(response);
		log.info("Got the response from backend .The notification code is : "+transactionResponse.getCode()+" and the result: "+transactionResponse.isResult());

		if (transactionResponse.getTransactionId() !=null) {
			sctl.setTransactionID(transactionResponse.getTransactionId());
			purchaseInquiry.setTransactionID(transactionResponse.getTransactionId());
			result.setTransactionID(transactionResponse.getTransactionId());
			transactionChargingService.saveServiceTransactionLog(sctl);
		}

		transactionChargingService.updateTransactionStatus(transactionResponse, sctl);
		
		result.setSctlID(sctl.getID());
		result.setMultixResponse(response);
		result.setDebitAmount(transaction.getAmountToDebit());
		result.setCreditAmount(transaction.getAmountToCredit());
		result.setServiceCharge(transaction.getAmountTowardsCharges());
		addCompanyANDLanguageToResult(srcSubscriberMDN,result);
		result.setParentTransactionID(transactionResponse.getTransactionId());
		result.setTransferID(transactionResponse.getTransferId());
		result.setCode(transactionResponse.getCode());
		result.setMessage(transactionResponse.getMessage());		
		return result;
	}
}
