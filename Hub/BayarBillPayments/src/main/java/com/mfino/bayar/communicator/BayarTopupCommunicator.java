package com.mfino.bayar.communicator;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.mfino.bayar.service.BayarWebServiceResponse;
import com.mfino.billpayments.beans.BillPayResponse;
import com.mfino.domain.BillPayments;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMBase;
import com.mfino.fix.CmFinoFIX.CMBillPay;
import com.mfino.mce.core.MCEMessage;
import com.mfino.util.DateTimeUtil;
import com.mfino.util.UniqueNumberGen;

/**
 * @author Vishal
 *
 */
public class BayarTopupCommunicator extends BayarHttpCommunicator {
	
	@Override
	public Object createBayarHttpRequest(MCEMessage mceMessage) {
		log.info("BayarTopupCommunicator :: createBayarHttpRequest mceMessage="+mceMessage);
		
		List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
		
		CMBillPay request = (CMBillPay)mceMessage.getRequest();
		Long sctlId = request.getServiceChargeTransactionLogID();
		
		BillPayments billPayments = billPaymentsService.getBillPaymentsRecord(sctlId);
		
		requestParams.add(new BasicNameValuePair("product_code", billPayments.getInfo1()));
		requestParams.add(new BasicNameValuePair("bill_number", request.getInvoiceNumber()));
		requestParams.add(new BasicNameValuePair("voucher_denomination", billPayments.getNominalamount().toBigInteger().toString()));
		requestParams.add(new BasicNameValuePair("reference_id", request.getServiceChargeTransactionLogID().toString()));
		
		return requestParams;
	}

	@Override
	public CFIXMsg constructReplyMessage(Object response, CFIXMsg requestFixMessage) {
		
		BayarWebServiceResponse wsResponseElement = (BayarWebServiceResponse)response;
		BillPayResponse billPayResponse = new BillPayResponse();
		BillPayments billPayments = null;
		
		log.info("BayarTopupCommunicator :: constructReplyMessage wsResponseElement="+wsResponseElement+" requestFixMessage="+requestFixMessage);
		Long sctlId = ((CMBase) requestFixMessage).getServiceChargeTransactionLogID();
		billPayments = billPaymentsService.getBillPaymentsRecord(sctlId);
		billPayResponse.setServiceChargeTransactionLogID(((CMBase) requestFixMessage).getServiceChargeTransactionLogID());
		if(wsResponseElement.getTransactionId() != null){
			billPayResponse.setInTxnId(wsResponseElement.getTransactionId().toString());
		}
		
		if(wsResponseElement != null && wsResponseElement.getStatus() != null && wsResponseElement.getStatus().intValue() == 0){
			billPayResponse.setResponse(CmFinoFIX.ResponseCode_Success);
			billPayResponse.setResult(CmFinoFIX.ResponseCode_Success);			

			if(wsResponseElement.getVoucherNo() != null)
				billPayments.setBilldata(wsResponseElement.getVoucherNo());
			log.info("HubBillPayReversalCommunicator :: constructReplyMessage Status="+wsResponseElement.getStatus());
			
		}else{	
			billPayResponse.setResponse(CmFinoFIX.ResponseCode_Failure);
			billPayResponse.setResult(CmFinoFIX.ResponseCode_Failure);
		}

		if(wsResponseElement.getStatus() != null && wsResponseElement.getStatus().equals(SERVICE_TIME_OUT_FROM_BAYAR)){
			billPayResponse.setResponse(SERVICE_TIME_OUT_FROM_BAYAR);
			billPayResponse.setResult(SERVICE_TIME_OUT_FROM_BAYAR);
			billPayResponse.setInResponseCode(SERVICE_TIME_OUT);
		}
		
		if(wsResponseElement.getStatus() != null)
			billPayResponse.setInResponseCode(wsResponseElement.getStatus().toString());
		if(wsResponseElement.getMessage() != null){
			billPayments.setOperatormessage(wsResponseElement.getMessage()); // Storing return message in OperatorMessage column of bill_payments
			billPayResponse.setOperatorMessage(wsResponseElement.getMessage());
		}
		billPaymentsService.saveBillPayment(billPayments);
		
		billPayResponse.header().setSendingTime(DateTimeUtil.getLocalTime());
		billPayResponse.header().setMsgSeqNum(UniqueNumberGen.getNextNum());
		return billPayResponse;
	}
	
	@Override
	public String getMethodName(MCEMessage mceMessage) {
		return constantFieldsMap.get("topup");
	}

	@Override
	public MCEMessage constructResponseMessage(MCEMessage mceMceMessage) {
		
		return null;
	}
}
