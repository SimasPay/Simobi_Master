package com.mfino.gt.iso8583.processor.isotofix.networkmanagement;

import org.jpos.iso.ISOMsg;

import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX.CMEchoTestResponseFromBank;
import com.mfino.gt.iso8583.processor.IGTBankISOtoFixProcessor;
import com.mfino.iso8583.definitions.exceptions.InvalidIsoElementException;

public class EchoTestResponse implements IGTBankISOtoFixProcessor {

	protected CFIXMsg response;
	
	@Override
	public CFIXMsg process(ISOMsg isoMsg, CFIXMsg request) throws InvalidIsoElementException {
		
		CMEchoTestResponseFromBank fromBank = new CMEchoTestResponseFromBank();
		if(isoMsg.hasField(39))
			fromBank.setResponseCode(isoMsg.getString(39));
		return fromBank;
	}
}
