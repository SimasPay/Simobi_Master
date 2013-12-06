package com.mfino.billpayments.bsim;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfino.billpayments.beans.BillPayResponse;
import com.mfino.billpayments.service.BillPaymentsBaseServiceImpl;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMBase;
import com.mfino.fix.CmFinoFIX.CMBillInquiry;
import com.mfino.fix.CmFinoFIX.CMGetMDNBillDebtsFromOperator;
import com.mfino.fix.CmFinoFIX.CMGetMDNBillDebtsToOperator;
import com.mfino.mce.core.MCEMessage;
import com.mfino.mce.core.util.BackendResponse;
import com.mfino.mce.core.util.NotificationCodes;
import com.mfino.service.impl.SubscriberServiceImpl;
import com.mfino.util.MfinoUtil;

/**
 * 
 * @author Maruthi
 *
 */
public class BillInquiryProcessor extends BillPaymentsBaseServiceImpl implements bsimProcessor {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Override
	public MCEMessage constructRequestMessage(MCEMessage mceMessage){
		log.info("BillInquiryProcessor :: constructRequestMessage() BEGIN mceMessage="+mceMessage);
		
		
		MCEMessage replyMessage = new MCEMessage(); 
		CMBillInquiry requestFix = (CMBillInquiry)mceMessage.getRequest();
		
		CMGetMDNBillDebtsToOperator toOperator = new CMGetMDNBillDebtsToOperator();
		toOperator.setSourceMDN(requestFix.getSourceMDN());
		SubscriberServiceImpl subscriberServiceImpl = new SubscriberServiceImpl();
		toOperator.setDestMDN(subscriberServiceImpl.normalizeMDN(requestFix.getInvoiceNumber()));
		toOperator.setTransactionID(requestFix.getTransactionID());//FIXME is it transferid or transactionid
		toOperator.setSourceApplication(requestFix.getSourceApplication());
		toOperator.setServiceChargeTransactionLogID(requestFix.getServiceChargeTransactionLogID());
		toOperator.setParentTransactionID(requestFix.getTransactionID());
		toOperator.setOperatorCode(CmFinoFIX.OperatorCodeForRouting_CBOSS);//routing code for bsim
		
		replyMessage.setRequest(mceMessage.getRequest());
		replyMessage.setResponse(toOperator);
		replyMessage.setDestinationQueue("jms:bsimBillInquiryResponseQueue?disableReplyTo=true");
		log.info("BillInquiryProcessor :: constructRequestMessage() END");
		
		
		return replyMessage;
	}
	
	@Override
	public MCEMessage constructReplyMessage(MCEMessage mceMceMessage) {
		
		log.info("BillInquiryProcessor :: constructReplyMessage() BEGIN mceMessage="+mceMceMessage);
		MCEMessage responseMceMessage = new MCEMessage();
		
		CMBase requestFix = (CMBase)mceMceMessage.getRequest();
		CMGetMDNBillDebtsFromOperator response  = (CMGetMDNBillDebtsFromOperator) mceMceMessage.getResponse();
		log.info("bsimBillPayInquiry Response for BillInquiry = "+response.getResponseCode());
		
		BackendResponse billResponse = new BillPayResponse();
		billResponse.setServiceChargeTransactionLogID(requestFix.getServiceChargeTransactionLogID());
		billResponse.setParentTransactionID(response.getParentTransactionID());
		billResponse.setTransactionID(response.getTransactionID());
		billResponse.setPaymentInquiryDetails(response.getPaymentInquiryDetails());
		
		if(response.getTotalBillDebts()!=null)
		billResponse.setAmount(response.getTotalBillDebts());
		
		billResponse.setResult(response.getResponseCode());
		billResponse.setInternalErrorCode(getInternalErrorCode(response.getResponseCode()));
		responseMceMessage.setRequest(mceMceMessage.getRequest());
		responseMceMessage.setResponse(billResponse);
		
		log.info("BillInquiryProcessor :: constructReplyMessage() END");
		return responseMceMessage;
	}

	private Integer getInternalErrorCode(Integer responseCode) {
		if(responseCode.equals(CmFinoFIX.ResponseCode_Success)){
			return NotificationCodes.BillDetails.getInternalErrorCode();
		}
		return NotificationCodes.GetBillDetailsFailed.getInternalErrorCode();
	}
	
	
	
}
