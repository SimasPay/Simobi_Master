package com.mfino.transactionapi.service.impl;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mfino.constants.ServiceAndTransactionConstants;
import com.mfino.constants.SystemParameterKeys;
import com.mfino.dao.DAOFactory;
import com.mfino.dao.PartnerDAO;
import com.mfino.dao.PocketDAO;
import com.mfino.domain.AgentCashinTxnLog;
import com.mfino.domain.ChannelCode;
import com.mfino.domain.Partner;
import com.mfino.domain.PartnerServices;
import com.mfino.domain.Pocket;
import com.mfino.domain.SubscriberMdn;
import com.mfino.domain.TransactionResponse;
import com.mfino.exceptions.InvalidServiceException;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMJSError;
import com.mfino.handlers.FIXMessageHandler;
import com.mfino.i18n.MessageText;
import com.mfino.result.XMLResult;
import com.mfino.service.SystemParametersService;
import com.mfino.service.TransactionChargingService;
import com.mfino.transactionapi.handlers.TransactionRequestHandler;
import com.mfino.transactionapi.service.AgentCashInService;
import com.mfino.transactionapi.vo.TransactionDetails;
import com.mfino.validators.PartnerValidator;

@Service("AgentCashInServiceImpl")
public class AgentCashInServiceImpl extends FIXMessageHandler implements AgentCashInService{
	
	private static Logger log = LoggerFactory.getLogger(AgentCashInServiceImpl.class);

	@Autowired
	@Qualifier("TransactionChargingServiceImpl")
	private TransactionChargingService transactionChargingService ;
	
	@Autowired
    @Qualifier("TransactionRequestHandlerImpl")
	private TransactionRequestHandler transactionRequestHandler;

	@Autowired
	@Qualifier("SystemParametersServiceImpl")
	private SystemParametersService systemParametersService;

	public CMJSError processAgentCashIn(AgentCashinTxnLog actl){
		CmFinoFIX.CMJSError errorMsg = new CmFinoFIX.CMJSError();
		
		log.info("Validating the agentCashIn transaction details" );
		errorMsg = validateAgentCashInTransaction(actl,errorMsg);
		if(CmFinoFIX.ErrorCode_Generic.equals(errorMsg.getErrorCode())){
			log.error("Agent cash-in failed : " +errorMsg.getErrorDescription());
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			errorMsg.setErrorDescription("Agent cash-in failed : " +errorMsg.getErrorDescription());
			return errorMsg;
		}
		actl.setAgentcashintrxnstatus(CmFinoFIX.AgentCashInTrxnStatus_Processing.longValue());
		
		log.info("Setting the transaction details");
		TransactionDetails transactionDetails = new TransactionDetails();
		transactionDetails.setSourceMDN(actl.getSourcemdn());
		transactionDetails.setSourcePocketId(actl.getSourcepocketid().toString());
		transactionDetails.setDestMDN(actl.getDestmdn());
		transactionDetails.setDestPocketId(actl.getDestpocketid().toString());
		transactionDetails.setAmount(actl.getAmount());
		transactionDetails.setSourceMessage(ServiceAndTransactionConstants.MESSAGE_CASH_IN_TO_AGENT);
		transactionDetails.setServiceName(ServiceAndTransactionConstants.SERVICE_AGENT);
		transactionDetails.setSourcePIN("dummy");
		
		ChannelCode cc = DAOFactory.getInstance().getChannelCodeDao().getByChannelSourceApplication(CmFinoFIX.SourceApplication_Web);
				
		transactionDetails.setChannelCode(cc.getId().toString());
		transactionDetails.setTransactionName(ServiceAndTransactionConstants.TRANSACTION_CASH_IN_TO_AGENT_INQUIRY);
		transactionDetails.setDestPocketCode(ServiceAndTransactionConstants.EMONEY_POCKET_CODE);
		
		Partner agent = DAOFactory.getInstance().getPartnerDAO().getById(actl.getDestpartnerid().longValue()); 
		
		log.info("transfered the cash-in to agent inquiry request to Transaction Request Handler");
		XMLResult result = transactionRequestHandler.process(transactionDetails);
		
		log.info("Setting sctlID in agentCashIn table");
		actl.setSctlid(new BigDecimal(result.getSctlID()));
		
		log.info("Checking backend response of inquiry");
		TransactionResponse transactionResponse = checkBackEndResponse(result.getMultixResponse());
		
		//checking is inquiry is successful
		if(transactionResponse!=null && StringUtils.isNotBlank(transactionResponse.getCode())){
			log.info("Got the Agent Cashin Inquiry response.");
			if (CmFinoFIX.NotificationCode_BankAccountToBankAccountConfirmationPrompt.toString().equals(transactionResponse.getCode())) {
				
				transactionDetails.setTransactionName(ServiceAndTransactionConstants.TRANSACTION_CASH_IN_TO_AGENT);
				transactionDetails.setTransferId(result.getTransferID());
				transactionDetails.setParentTxnId(new Long(result.getParentTransactionID()));
				transactionDetails.setConfirmString(CmFinoFIX.Boolean_True.toString());
				log.info("transfered the cash-in to agent confirm request to Transaction Request Handler");
				result = transactionRequestHandler.process(transactionDetails);
				log.info("Checking backend response of confirm");
			    transactionResponse = checkBackEndResponse(result.getMultixResponse());
			    
			    //confirmation fails
				if (transactionResponse == null || !transactionResponse.isResult()) {
					log.error("Transaction ID:"+result.getSctlID()+". Cash-in to agent confirmation failed for agent with trade name: " + agent.getTradename()+
							". Failure message: "+result.getMessage());
					errorMsg.setErrorDescription(MessageText._("Transaction ID:"+result.getSctlID()+". Failed to cash-in to agent " + agent.getTradename()+
							". Failure reason code: "+result.getCode()));
					failTheAgentCashInTrxn(actl, "Transaction ID:"+result.getSctlID()+". Failed to cash-in to agent " + agent.getTradename()+
							". Failure reason code: "+result.getCode());
					errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
					return errorMsg;
				}
				
			}
			else{
				//Inquiry failed due to notification code not of confirmation
				log.error("Transaction ID:"+result.getSctlID()+" Cash-in to agent Inquiry Failed for agent with trade name " + agent.getTradename()+". Failure message: "+result.getMessage());
				errorMsg.setErrorDescription(MessageText._("Transaction ID:"+result.getSctlID()+". Failed to cash-in to agent " + agent.getTradename()+". Failure reason code: "+result.getCode()));
				failTheAgentCashInTrxn(actl, "Transaction ID:"+result.getSctlID()+". Failed to cash-in to agent " + agent.getTradename()+". Failure reason code: "+result.getCode());
				errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
				return errorMsg;
			}
		}
		else{
			//No Inquiry response
			log.error("Cash-in to agent Inquiry, Failed for agent with trade name " + agent.getTradename()+". Failure code: "+result.getNotificationCode());
			errorMsg.setErrorDescription(MessageText._("Cash-in to agent Inquiry, Failed for agent with trade name " + agent.getTradename()+". Failure code: "+result.getNotificationCode()));
			failTheAgentCashInTrxn(actl, "Cash-in to agent Inquiry, Failed for agent with trade name " + agent.getTradename()+". Failure code: "+result.getNotificationCode());
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		
		actl.setAgentcashintrxnstatus(CmFinoFIX.AgentCashInTrxnStatus_Completed.longValue());
		errorMsg.setErrorDescription(MessageText._("Transaction ID:"+result.getSctlID()+". Successfully Cashed-in " + agent.getTradename()+ " wallet with amount "+result.getCreditAmount()
																				+"and service charge: "+result.getServiceCharge()));
		errorMsg.setErrorCode(CmFinoFIX.ErrorCode_NoError);
		return errorMsg;

	}
	
	private CMJSError validateAgentCashInTransaction(AgentCashinTxnLog actl, CMJSError errorMsg) {
		//Getting Destination
		PartnerDAO partnerDAO =DAOFactory.getInstance().getPartnerDAO();
		PocketDAO pocketDAO =DAOFactory.getInstance().getPocketDAO();
		Partner agent = partnerDAO.getById(actl.getDestpartnerid().longValue()); 
		PartnerValidator partnerValidator = new PartnerValidator();
		partnerValidator.setPartner(agent);
		//validating destination agent
		log.info("validating destination agent");
		Integer validationResult= partnerValidator.validate();
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			log.error("Agent/Partner is not active");
			errorMsg.setErrorDescription(MessageText._("Agent/Partner is not active"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		SubscriberMdn agentmdn=agent.getSubscriber().getSubscriberMdns().iterator().next();
		

		PartnerServices agentService = null;
		Pocket agentPocket =null;
		try {
			agentService = transactionChargingService.getPartnerService(agent.getId().longValue(), transactionChargingService.getServiceProviderId(null), transactionChargingService.getServiceId(ServiceAndTransactionConstants.SERVICE_AGENT));
			if(agentService==null){
				log.error("Valid agent service not found. Cash-in to agent is not possible");
				errorMsg.setErrorDescription(MessageText._("Valid agent service not found. Cash-in to agent is not possible"));
				errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
				return errorMsg;
			}
			//getting destination pocket
			agentPocket = agentService.getPocketBySourcepocket();
			log.info("validating destination agent pocket ");
			if(agentPocket==null){
				log.error("Valid agent emoney pocket not found");
				errorMsg.setErrorDescription(MessageText._("Valid agent emoney pocket not found"));
				errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
				return errorMsg;
			}
			if(!CmFinoFIX.PocketStatus_Active.equals(agentPocket.getStatus())){
				log.error("Agent emoney pocket is not active");
				errorMsg.setErrorDescription(MessageText._("Agent emoney pocket is not active"));
				errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
				return errorMsg;
			}
			if(CmFinoFIX.PocketType_BankAccount.equals(agentPocket.getPocketTemplate().getType())){
				log.error("Agent service has bank pocket as outgoing pocket. Cash-in to agent cannot be done");
				errorMsg.setErrorDescription(MessageText._("Agent service has bank pocket as outgoing pocket. Cash-in to agent cannot be done"));
				errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
				return errorMsg;
			}
		} catch (InvalidServiceException e) {
			log.error("Service Not Avialable",e);
			errorMsg.setErrorDescription(MessageText._("Service Not Avialable"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		
		//getting the non-transactionable collector pocketID for funding
		log.info("getting the funding pocket id from system parameters");
		Long sourcePocketID = systemParametersService.getLong(SystemParameterKeys.FUNDING_POCKET_FOR_AGENT);
		if(sourcePocketID==null){
			log.error("System parameter funding.pocket.for.agent is null" );
			errorMsg.setErrorDescription(MessageText._("System parameter funding.pocket.for.agent is null"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		
		//getting the partner for non-transactionable collector pocket 
		log.info("getting the funding pocket");
		Pocket srcPocket= pocketDAO.getById(sourcePocketID);
		if(srcPocket==null){
			log.error("Funding pocket for cash-in to agent not found");
			errorMsg.setErrorDescription(MessageText._("Funding pocket for cash-in to agent not found "));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		if(!CmFinoFIX.PocketStatus_Active.equals(srcPocket.getStatus())){
			log.error("Funding pocket for cash-in to agent not active");
			errorMsg.setErrorDescription(MessageText._("Funding pocket for cash-in to agent not active"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}	

		//getting the funding partner MDN
		SubscriberMdn sourceMDN = srcPocket.getSubscriberMdn();
		if(sourceMDN == null){
			log.error("sourcePocket has SubscriberMDN as null" );
			errorMsg.setErrorDescription(MessageText._("SourcePocket has SubscriberMDN as null"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}

		//Getting source partner
		 Partner srcpartner = partnerDAO.getPartnerBySubscriber(sourceMDN.getSubscriber());
		 partnerValidator.setIsAgent(false);
		 partnerValidator.setPartner(srcpartner);
		 log.info("validating source partner having the funding pocket");
		 validationResult = partnerValidator.validate();
		if (!validationResult.equals(CmFinoFIX.ResponseCode_Success)) {
			log.error("Source partner for cash-in to agent validation failed");
			errorMsg.setErrorDescription(MessageText._("Source partner for cash-in to agent validation failed"));
			errorMsg.setErrorCode(CmFinoFIX.ErrorCode_Generic);
			return errorMsg;
		}
		
		
		actl.setSourcemdn(sourceMDN.getMdn());
		actl.setSourcepocketid(new BigDecimal(sourcePocketID));
		actl.setDestpartnerid(agent.getId());
		actl.setDestmdn(agentmdn.getMdn());
		actl.setDestpocketid(agentPocket.getId());
		return errorMsg;

		
	}

	public void failTheAgentCashInTrxn(AgentCashinTxnLog actl,String statusReason){
		actl.setAgentcashintrxnstatus(CmFinoFIX.AgentCashInTrxnStatus_Failed.longValue());
		actl.setAgentcashintrxnstatusreason(statusReason);
	}

}
