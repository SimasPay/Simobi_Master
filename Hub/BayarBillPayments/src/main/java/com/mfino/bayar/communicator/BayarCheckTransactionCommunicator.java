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
import com.mfino.mce.core.MCEMessage;
import com.mfino.util.DateTimeUtil;
import com.mfino.util.UniqueNumberGen;

/**
 * @author Vishal
 *
 */
public class BayarCheckTransactionCommunicator extends BayarHttpCommunicator {

	private String intTrxnID;
	
	@Override
	public Object createBayarHttpRequest(MCEMessage mceMessage) {
		log.info("BayarCheckTransactionCommunicator :: createBayarHttpRequest mceMessage="+mceMessage);
		
		List<NameValuePair> requestParams = new ArrayList<NameValuePair>();
		
 		CMBase requestFix = (CMBase)mceMessage.getRequest();
		Long sctlId = requestFix.getServiceChargeTransactionLogID();		
		
		BillPayments billPayments = billPaymentsService.getBillPaymentsRecord(sctlId);
		if( billPayments != null && billPayments.getINTxnId() != null)
			intTrxnID = billPayments.getINTxnId();
		
		requestParams.add(new BasicNameValuePair("transaction_id", intTrxnID));
		
		return requestParams;
	}

	@Override
	public CFIXMsg constructReplyMessage(Object response, CFIXMsg requestFixMessage) {
		
		BayarWebServiceResponse wsResponseElement = (BayarWebServiceResponse)response;
		BillPayResponse billPayResponse = new BillPayResponse();
		BillPayments billPayments = null;
		
		log.info("BayarCheckTransactionCommunicator :: constructReplyMessage wsResponseElement="+wsResponseElement+" requestFixMessage="+requestFixMessage);
		
		Long sctlId = ((CMBase) requestFixMessage).getServiceChargeTransactionLogID();
		billPayments = billPaymentsService.getBillPaymentsRecord(sctlId);
		
		if(wsResponseElement != null && wsResponseElement.getStatus() != null && wsResponseElement.getStatus().intValue() == 0){

			billPayResponse.setResponse(CmFinoFIX.ResponseCode_Success);
			//billPayResponse.setResult(CmFinoFIX.ResponseCode_Success);
			billPayResponse.setInTxnId(wsResponseElement.getTransactionId().toString());
			billPayResponse.setServiceChargeTransactionLogID(sctlId);
			
			if(wsResponseElement.getTrxnStatus() != null)	{
				billPayments.setINResponseCode(wsResponseElement.getTrxnStatus());
				billPayResponse.setInResponseCode(wsResponseElement.getTrxnStatus());
			}
			if(wsResponseElement.getVoucherToken() != null)	{			
				billPayments.setInfo3(wsResponseElement.getVoucherToken());//In case of PLN prepaid Token
				billPayResponse.setRechargePin(wsResponseElement.getVoucherToken());
			}
			if(wsResponseElement.getVoucherNo() != null)
				billPayments.setBillData(wsResponseElement.getVoucherNo());

			log.info("BayarCheckTransactionCommunicator :: constructReplyMessage Status="+wsResponseElement.getStatus());
		}else{	
			billPayResponse.setResponse(CmFinoFIX.ResponseCode_Failure);
			//billPayResponse.setResult(CmFinoFIX.ResponseCode_Failure);
		}

		if(wsResponseElement.getTrxnStatus() != null)
			billPayResponse.setResult(new Integer(wsResponseElement.getTrxnStatus()));
		if(wsResponseElement.getMessage() != null)
			billPayments.setOperatorMessage(wsResponseElement.getMessage()); // Storing return message in OperatorMessage column of bill_payments
		billPaymentsService.saveBillPayment(billPayments);
		
		billPayResponse.header().setSendingTime(DateTimeUtil.getLocalTime());
		billPayResponse.header().setMsgSeqNum(UniqueNumberGen.getNextNum());
		return billPayResponse;
	}
	
	@Override
	public String getMethodName(MCEMessage mceMessage) {
		
		return constantFieldsMap.get("check_transaction");
	}

	@Override
	public MCEMessage constructResponseMessage(MCEMessage mceMceMessage) {
		
		return null;
	}
}
