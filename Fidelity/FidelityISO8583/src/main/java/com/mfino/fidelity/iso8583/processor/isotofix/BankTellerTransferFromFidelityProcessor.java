package com.mfino.fidelity.iso8583.processor.isotofix;

import org.jpos.iso.ISOMsg;

import com.mfino.fidelity.iso8583.GetConstantCodes;
import com.mfino.fidelity.iso8583.processor.FidelityISOtoFixProcessor;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMBankTellerMoneyTransferFromBank;
import com.mfino.fix.CmFinoFIX.CMBankTellerMoneyTransferToBank;
import com.mfino.iso8583.definitions.exceptions.InvalidIsoElementException;
import com.mfino.util.DateTimeUtil;
import com.mfino.util.UniqueNumberGen;

public class BankTellerTransferFromFidelityProcessor implements FidelityISOtoFixProcessor
{
	@Override
	public CFIXMsg process(ISOMsg isoMsg, CFIXMsg request) throws InvalidIsoElementException 
	{
		CMBankTellerMoneyTransferToBank toBank = (CMBankTellerMoneyTransferToBank)request;
		CMBankTellerMoneyTransferFromBank fromBank = new CMBankTellerMoneyTransferFromBank();
				
		fromBank.copy(toBank);
		fromBank.setServiceChargeTransactionLogID(toBank.getServiceChargeTransactionLogID());	
		fromBank.setIsInDirectCashIn(toBank.getIsInDirectCashIn());		
		if(isoMsg.hasField(38))
			fromBank.setAIR(isoMsg.getString(38));
		if(isoMsg.hasField(39)){
			String respcode = isoMsg.getString(39);
			fromBank.setResponseCode(GetConstantCodes.SUCCESS.equalsIgnoreCase(respcode)?CmFinoFIX.ISO8583_ResponseCode_Success:respcode);
		}
		fromBank.header().setSendingTime(DateTimeUtil.getLocalTime());
		fromBank.header().setMsgSeqNum(UniqueNumberGen.getNextNum());
		
	    return fromBank;
	}
}
