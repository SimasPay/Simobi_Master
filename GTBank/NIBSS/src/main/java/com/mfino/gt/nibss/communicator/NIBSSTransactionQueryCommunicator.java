package com.mfino.gt.nibss.communicator;

import static com.mfino.gt.nibss.util.NIBSSCashOutConstants.NIBSS_RESPONSE_SUCCESSFUL;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.mfino.billpayments.beans.BillPayResponse;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMBase;
import com.mfino.gt.nibss.util.NIBSSCashOutResponse;
import com.mfino.gt.nibss.util.NIBSSCashOutResponseParser;
import com.mfino.mce.core.MCEMessage;
import com.mfino.mce.core.util.MCEUtil;

/**
 * @author Bala Sunku
 *
 */
public class NIBSSTransactionQueryCommunicator extends NIBSSCommunicator {

	@Override
	public List<Object> getParameterList(MCEMessage mceMessage) {
		log.info("NIBSSTransactionQueryCommunicator :: getParameterList()");
		List<Object> parameterList = new ArrayList<Object>();
		
		CMBase cmBase = (CMBase)mceMessage.getRequest();
		Long sctlId = cmBase.getServiceChargeTransactionLogID();
		
		parameterList.add(sctlId.toString());
		return parameterList;
	}

	@Override
	public MCEMessage constructReplyMessage(List<Object> response, MCEMessage requestMceMessage) {
		Object wsResponseElement = response.get(0);
		log.info("NIBSSTransactionQueryCommunicator :: constructReplyMessage response="+wsResponseElement);
		
		MCEMessage responseMceMessage = new MCEMessage();
		
		CMBase requestFix = (CMBase)requestMceMessage.getRequest();
		
		BillPayResponse billPayResponse = new BillPayResponse();
		billPayResponse.setServiceChargeTransactionLogID(requestFix.getServiceChargeTransactionLogID());

		if(wsResponseElement.equals(MCEUtil.SERVICE_TIME_OUT)){
			billPayResponse.setInResponseCode(MCEUtil.SERVICE_TIME_OUT);
		}
		else if(wsResponseElement.equals(MCEUtil.SERVICE_UNAVAILABLE)){
			billPayResponse.setInResponseCode(MCEUtil.SERVICE_UNAVAILABLE);
			billPayResponse.setResponse(-1);
			billPayResponse.setResult(-1);			
		} 
		else
		{
			NIBSSCashOutResponse nibssCashOutResponse = NIBSSCashOutResponseParser.getNIBSSCashOutResponse((String)wsResponseElement);
			String inResponse = nibssCashOutResponse.getResponseCode() +  
					(StringUtils.isNotBlank(nibssCashOutResponse.getError()) ? ":" + nibssCashOutResponse.getError() : StringUtils.EMPTY);
			if (StringUtils.isNotBlank(inResponse) && inResponse.length() > 255) {
				inResponse = inResponse.substring(0,255);
			}			
			
			billPayResponse.setInResponseCode(inResponse);
			
			if (NIBSS_RESPONSE_SUCCESSFUL.equals(nibssCashOutResponse.getResponseCode())) {
				billPayResponse.setResponse(CmFinoFIX.ResponseCode_Success);
				billPayResponse.setResult(CmFinoFIX.ResponseCode_Success);
				billPayResponse.setInTxnId(nibssCashOutResponse.getSessionId());
			}
			else {
				billPayResponse.setResponse(CmFinoFIX.ResponseCode_Failure);
				billPayResponse.setResult(CmFinoFIX.ResponseCode_Failure);
			}
		}
		
		responseMceMessage.setRequest(requestMceMessage.getRequest());
		responseMceMessage.setResponse(billPayResponse);
		return responseMceMessage;
	}

	@Override
	public String getMessageName(MCEMessage mceMessage) {
		return "MM_TransactionQuery";
	}
}
