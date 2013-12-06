package com.mfino.bsim.iso8583.processor.isotofix.networkmanagement;

import org.jpos.iso.ISOMsg;

import com.mfino.bsim.iso8583.processor.BSIMISOtoFixProcessor;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX.CMSignOnFromBank;
import com.mfino.iso8583.definitions.exceptions.InvalidIsoElementException;

public class SignOn implements BSIMISOtoFixProcessor {

	protected CFIXMsg response;
	
	@Override
	public CFIXMsg process(ISOMsg isoMsg, CFIXMsg request) throws InvalidIsoElementException {

		CMSignOnFromBank fromBank = new CMSignOnFromBank();
		return fromBank;
	}
}
