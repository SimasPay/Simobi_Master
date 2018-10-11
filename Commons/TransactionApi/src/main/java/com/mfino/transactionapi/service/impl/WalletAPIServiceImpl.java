package com.mfino.transactionapi.service.impl;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.exceptions.InvalidDataException;
import com.mfino.fix.CmFinoFIX;
import com.mfino.hibernate.Timestamp;
import com.mfino.result.XMLResult;
import com.mfino.service.SubscriberService;
import com.mfino.service.SystemParametersService;
import com.mfino.transactionapi.handlers.money.InterBankTransferHandler;
import com.mfino.transactionapi.handlers.money.InterBankTransferInquiryHandler;
import com.mfino.transactionapi.handlers.money.MoneyTransferHandler;
import com.mfino.transactionapi.handlers.money.TransferInquiryHandler;
import com.mfino.transactionapi.handlers.money.TransferToUangkuHandler;
import com.mfino.transactionapi.handlers.money.TransferToUangkuInquiryHandler;
import com.mfino.transactionapi.handlers.payment.BillPayConfirmHandler;
import com.mfino.transactionapi.handlers.payment.BillPayInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.AgentToAgentTransferConfirmHandler;
import com.mfino.transactionapi.handlers.wallet.AgentToAgentTransferInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.CheckBalanceHandler;
import com.mfino.transactionapi.handlers.wallet.EmoneyTrxnHistoryHandler;
import com.mfino.transactionapi.handlers.wallet.FundAllocationConfirmHandler;
import com.mfino.transactionapi.handlers.wallet.FundAllocationInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.FundWithdrawalConfirmHandler;
import com.mfino.transactionapi.handlers.wallet.FundWithdrawalInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.ResendMFAOTPHandler;
import com.mfino.transactionapi.handlers.wallet.ResendMFAOTPNoPINHandler;
import com.mfino.transactionapi.handlers.wallet.SubscriberCashOutAtATMConfirmHandler;
import com.mfino.transactionapi.handlers.wallet.SubscriberCashOutAtATMInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.SubscriberCashOutConfirmHandler;
import com.mfino.transactionapi.handlers.wallet.SubscriberCashOutInquiryHandler;
import com.mfino.transactionapi.handlers.wallet.impl.SubscriberDonationConfirmHandlerImpl;
import com.mfino.transactionapi.handlers.wallet.impl.SubscriberDonationInquiryHandlerImpl;
import com.mfino.transactionapi.service.BaseAPIService;
import com.mfino.transactionapi.service.TransactionRequestValidationService;
import com.mfino.transactionapi.service.WalletAPIService;
import com.mfino.transactionapi.vo.TransactionDetails;
/**
 * All Wallet transactions, should be handled through this service.
 * EMoney Check Balance
 * EMoney Transaction History
 * EMoney Transfer
 * Cash Out
 * Agent to Agent Transfer (Emoney)
 * 
 * 
 * @author Bala Sunku
 *
 */
@Service("WalletAPIServiceImpl")
public class WalletAPIServiceImpl extends BaseAPIService implements WalletAPIService{
	private static Logger	log	= LoggerFactory.getLogger(WalletAPIServiceImpl.class);
	
	@Autowired
	@Qualifier("CheckBalanceHandlerImpl")
	private CheckBalanceHandler checkBalanceHandler;
	
	@Autowired
	@Qualifier("EmoneyTrxnHistoryHandlerImpl")
	private EmoneyTrxnHistoryHandler emoneyTrxnHistoryHandler;
	
	@Autowired
	@Qualifier("AgentToAgentTransferInquiryHandlerImpl")
	private AgentToAgentTransferInquiryHandler agentToAgentTransferInquiryHandler;
	
	@Autowired
	@Qualifier("AgentToAgentTransferConfirmHandlerImpl")
	private AgentToAgentTransferConfirmHandler agentToAgentTransferConfirmHandler;
	
	@Autowired
	@Qualifier("FundAllocationInquiryHandlerImpl")
	private FundAllocationInquiryHandler fundAllocationInquiryHandler;
	
	@Autowired
	@Qualifier("FundAllocationConfirmHandlerImpl")
	private FundAllocationConfirmHandler fundAllocationConfirmHandler;
	
	@Autowired
	@Qualifier("SubscriberCashOutAtATMInquiryHandlerImpl")
	private SubscriberCashOutAtATMInquiryHandler subscriberCashOutAtATMInquiryHandler;
	
	@Autowired
	@Qualifier("SubscriberCashOutAtATMConfirmHandlerImpl")
	private SubscriberCashOutAtATMConfirmHandler subscriberCashOutAtATMConfirmHandler;
	
	@Autowired
	@Qualifier("SubscriberCashOutInquiryHandlerImpl")
	private SubscriberCashOutInquiryHandler subscriberCashOutInquiryHandler;
	
	@Autowired
	@Qualifier("SubscriberCashOutConfirmHandlerImpl")
	private SubscriberCashOutConfirmHandler subscriberCashOutConfirmHandler;
	
	@Autowired
	@Qualifier("FundWithdrawalInquiryHandlerImpl")
	private FundWithdrawalInquiryHandler fundWithdrawalInquiryHandler;
	
	@Autowired
	@Qualifier("FundWithdrawalConfirmHandlerImpl")
	private FundWithdrawalConfirmHandler fundWithdrawalConfirmHandler;

	@Autowired
	@Qualifier("TransferInquiryHandlerImpl")
	private TransferInquiryHandler transferInquiryHandler;
	
	@Autowired
	@Qualifier("MoneyTransferHandlerImpl")
	private MoneyTransferHandler moneyTransferHandler;
	
	@Autowired
	@Qualifier("BillPayInquiryHandlerImpl")
	private BillPayInquiryHandler billPayInquiryHandler;

	@Autowired
	@Qualifier("BillPayConfirmHandlerImpl")
	private BillPayConfirmHandler billPayConfirmHandler;
	
    @Autowired
    @Qualifier("SubscriberServiceImpl")
    private SubscriberService subscriberService;
	
	@Autowired
	@Qualifier("TransactionRequestValidationServiceImpl")
	private TransactionRequestValidationService transactionRequestValidationService;
	
	@Autowired
	@Qualifier("InterBankTransferInquiryHandlerImpl")
	private InterBankTransferInquiryHandler interBankTransferInquiryHandler;
	
	@Autowired
	@Qualifier("InterBankTransferHandlerImpl")
	private InterBankTransferHandler interBankTransferHandler;
	
	@Autowired
	@Qualifier("TransferToUangkuInquiryHandlerImpl")
	private TransferToUangkuInquiryHandler transferToUangkuInquiryHandler;
	
	@Autowired
	@Qualifier("TransferToUangkuHandlerImpl")
	private TransferToUangkuHandler transferToUangkuHandler;
	
	@Autowired
	@Qualifier("SubscriberDonationInquiryHandlerImpl")
	private SubscriberDonationInquiryHandlerImpl donationInquiryHandler;
	
	@Autowired
	@Qualifier("SubscriberDonationConfirmHandlerImpl")
	private SubscriberDonationConfirmHandlerImpl donationConfirmHandler;	
	
	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService ;
	
	@Autowired
	@Qualifier("ResendMFAOTPHandlerImpl")
	private ResendMFAOTPHandler resendMFAOTPHandler;
	
	@Autowired
	@Qualifier("ResendMFAOTPNoPINHandlerImpl")
	private ResendMFAOTPNoPINHandler resendMFAOTPNoPINHandler;
	
	private static final String MAX_NO_OF_RECORDS = "15000";

	public XMLResult handleRequest(TransactionDetails transactionDetails) throws InvalidDataException {
		log.info("@kris: WalletApiService transactionDetails"+transactionDetails);
		XMLResult xmlResult = null;

		String transactionName = transactionDetails.getTransactionName();
		String destMDN = transactionDetails.getDestMDN();
		String normalizedMDN=subscriberService.normalizeMDN(destMDN);
		
		transactionDetails.setDestMDN(normalizedMDN);
		String sourceMessage = transactionDetails.getSourceMessage();
		log.info("@kris: transactionName:"+transactionName);
		log.info("@kris: destMDN:"+destMDN);
		log.info("@kris: normalizedMDN:"+normalizedMDN);
		log.info("@kris: sourceMessage:"+sourceMessage);
		
		if (ServiceAndTransactionConstants.TRANSACTION_CHECKBALANCE.equals(transactionName)) {
		
			transactionRequestValidationService.validateCheckBalanceDetails(transactionDetails);
			transactionDetails.setServiceName(ServiceAndTransactionConstants.SERVICE_WALLET);
			xmlResult = (XMLResult) checkBalanceHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_HISTORY.equals(transactionName)) {

			transactionRequestValidationService.validateTransactionHistoryDetails(transactionDetails);			
			xmlResult = (XMLResult) emoneyTrxnHistoryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_HISTORY_DETAILED_STATEMENT.equals(transactionName)) {

			transactionRequestValidationService.validateTransactionHistoryDetailedStmtDetails(transactionDetails);
			xmlResult = (XMLResult) emoneyTrxnHistoryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_EMAIL_HISTORY_AS_PDF.equals(transactionName)) {

			transactionRequestValidationService.validateEmailTxnHistoryAsPDFDetails(transactionDetails);	
			transactionDetails.setNumRecords(MAX_NO_OF_RECORDS);
			xmlResult = (XMLResult) emoneyTrxnHistoryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_DOWNLOAD_HISTORY_AS_PDF.equals(transactionName)) {

			transactionRequestValidationService.validateDownloadTxnHistoryAsPDFDetails(transactionDetails);	
			transactionDetails.setNumRecords(MAX_NO_OF_RECORDS);
			xmlResult = (XMLResult) emoneyTrxnHistoryHandler.handle(transactionDetails);
		}		
		else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER_INQUIRY.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateTransferInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_MOBILE_TRANSFER);
			}
			xmlResult = (XMLResult) transferInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateTransferConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) moneyTransferHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_CASHOUT_INQUIRY.equalsIgnoreCase(transactionName)) {
			if (StringUtils.isBlank(sourceMessage)) {
				transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_CASH_OUT);
			}
			transactionRequestValidationService.validateCashOutInquiryDetails(transactionDetails);
			xmlResult = (XMLResult) subscriberCashOutInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_CASHOUT.equalsIgnoreCase(transactionName)) {
			transactionRequestValidationService.validateCashOutConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) subscriberCashOutConfirmHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_CASHOUT_AT_ATM_INQUIRY.equalsIgnoreCase(transactionName)) {
			
			transactionRequestValidationService.validateCashOutAtATMInquiryDetails(transactionDetails);			
			if (StringUtils.isBlank(sourceMessage)) {
				transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_WITHDRAW_FROM_ATM);
			}
			xmlResult = (XMLResult) subscriberCashOutAtATMInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_CASHOUT_AT_ATM.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateCashOutAtATMConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) subscriberCashOutAtATMConfirmHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_INTER_EMONEY_TRANSFER_INQUIRY.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateInterEmoneyTransferInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_INTER_EMONEY_TRANSFER);
			}
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_INTER_EMONEY_TRANSFER);
			xmlResult = (XMLResult) billPayInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_INTER_EMONEY_TRANSFER.equalsIgnoreCase(transactionName)) {
		
			transactionRequestValidationService.validateInterEmoneyTransferConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) billPayConfirmHandler.handle(transactionDetails);
		}		
		
		else if (ServiceAndTransactionConstants.TRANSACTION_AGENT_AGENT_TRANSFER_INQUIRY.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateAgentToAgentTransferInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_AGENT_AGENT_TRANSFER;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			xmlResult = (XMLResult) agentToAgentTransferInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_AGENT_TO_AGENT_TRANSFER.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validatAgentToAgentTransferConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) agentToAgentTransferConfirmHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_FUND_ALLOCATION_INQUIRY.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateFundAllocationInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_FUND_ALLOCATION;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			xmlResult = (XMLResult) fundAllocationInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_FUND_ALLOCATION.equalsIgnoreCase(transactionName)) {

			transactionRequestValidationService.validateFundAllocationConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) fundAllocationConfirmHandler.handle(transactionDetails);
		}	
		else if (ServiceAndTransactionConstants.TRANSACTION_FUND_WITHDRAWAL_INQUIRY.equalsIgnoreCase(transactionName)) {
			
			transactionRequestValidationService.validateFundWithdrawalInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_FUND_WITHDRAWAL;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			String onBehalfOfMDN = transactionDetails.getOnBehalfOfMDN();
			transactionDetails.setOnBehalfOfMDN(subscriberService.normalizeMDN(onBehalfOfMDN));
			xmlResult= (XMLResult) fundWithdrawalInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_FUND_WITHDRAWAL.equalsIgnoreCase(transactionName)) {
			
			transactionRequestValidationService.validateFundWithdrawalConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) fundWithdrawalConfirmHandler.handle(transactionDetails);
		
		} else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU_INQUIRY.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateTransferToUangkuInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_TRANSFER_TO_UANGKU;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU);
			
			xmlResult = (XMLResult) transferToUangkuInquiryHandler.handle(transactionDetails);
			
		} else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateTransferToUangkuConfirmDetails(transactionDetails);
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU);
			
			xmlResult = (XMLResult) transferToUangkuHandler.handle(transactionDetails);
			
		} else if (ServiceAndTransactionConstants.TRANSACTION_INTERBANK_TRANSFER_INQUIRY.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateInterBankTransferInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_INTERBANK_TRANSFER;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_INTERBANK_TRANSFER);
			xmlResult = (XMLResult) interBankTransferInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_INTERBANK_TRANSFER.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateInterBankTransferConfirmDetails(transactionDetails);
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_INTERBANK_TRANSFER);
			xmlResult = (XMLResult) interBankTransferHandler.handle(transactionDetails);			
		}		
		else if (ServiceAndTransactionConstants.TRANSACTION_DONATION_INQUIRY.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateDonationInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_DONATION;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			xmlResult = (XMLResult) donationInquiryHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_DONATION.equalsIgnoreCase(transactionName)){

			transactionRequestValidationService.validateDonationConfirmDetails(transactionDetails);
			xmlResult = (XMLResult) donationConfirmHandler.handle(transactionDetails);			
		
		}else if (ServiceAndTransactionConstants.TRANSACTION_RESEND_MFAOTP.equals(transactionName)) {
		
			transactionRequestValidationService.validateResendMFAOTPDetails(transactionDetails);
			transactionDetails.setServiceName(ServiceAndTransactionConstants.SERVICE_WALLET);
			
			xmlResult = (XMLResult) resendMFAOTPHandler.handle(transactionDetails);
		}else if (ServiceAndTransactionConstants.TRANSACTION_RESEND_MFAOTP_NOPIN.equals(transactionName)) {
		
			transactionRequestValidationService.validateResendMFAOTPNotPINDetails(transactionDetails);
			transactionDetails.setServiceName(ServiceAndTransactionConstants.SERVICE_WALLET);
			
			xmlResult = (XMLResult) resendMFAOTPNoPINHandler.handle(transactionDetails);
		}
		else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU_INQUIRY.equalsIgnoreCase(transactionName)){
			transactionRequestValidationService.validateTransferToUangkuInquiryDetails(transactionDetails);
			if (StringUtils.isBlank(sourceMessage)) {
				sourceMessage = ServiceAndTransactionConstants.MESSAGE_TRANSFER_TO_UANGKU;
				transactionDetails.setSourceMessage(sourceMessage);
			}
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU);
			xmlResult = (XMLResult) transferToUangkuInquiryHandler.handle(transactionDetails);
		} 
		else if (ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU.equalsIgnoreCase(transactionName)){
			transactionRequestValidationService.validateTransferToUangkuConfirmDetails(transactionDetails);
			transactionDetails.setTransactionTypeName(ServiceAndTransactionConstants.TRANSACTION_TRANSFER_TO_UANGKU);
			xmlResult = (XMLResult) transferToUangkuHandler.handle(transactionDetails);
		}		
		else
		{
			xmlResult = new XMLResult();
			Integer language = systemParametersService.getInteger(SystemParameterKeys.DEFAULT_LANGUAGE_OF_SUBSCRIBER);
			xmlResult.setLanguage(language);
			xmlResult.setTransactionTime(new Timestamp());
			xmlResult.setNotificationCode(CmFinoFIX.NotificationCode_TransactionNotAvailable);
		}
		return xmlResult;
	}
	
}
