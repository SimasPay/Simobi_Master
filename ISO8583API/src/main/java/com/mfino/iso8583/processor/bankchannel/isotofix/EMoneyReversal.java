package com.mfino.iso8583.processor.bankchannel.isotofix;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;

import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX.CMBankChannelEMoneyPaymentReversal;
import com.mfino.iso8583.processor.bankchannel.IVirtualHostRequestProcessor;
import com.mfino.iso8583.processor.bankchannel.isomessages.UMGVHISOMessage;

public class EMoneyReversal extends BankChannelRequestProcessor implements IVirtualHostRequestProcessor {

	@Override
	public CFIXMsg process(UMGVHISOMessage isoMsg) throws Exception {
		CMBankChannelEMoneyPaymentReversal request = new CMBankChannelEMoneyPaymentReversal();

		Integer merchantPrefixCode = null;
		request.setPaymentTransactionData(isoMsg.getOriginalPaymentTransactionData());
		request.setAmount(new BigDecimal(isoMsg.getTransactionAmount().substring(0, 16).trim()));
		if (!StringUtils.isBlank(isoMsg.getAccountIdentification2())) {
			merchantPrefixCode = Integer.parseInt(isoMsg.getAccountIdentification2().substring(0, 4).trim());
			request.setMerchantPrefixCode(merchantPrefixCode);
		}
		request.setBankCode(Integer.parseInt(isoMsg.getForwardInstitutionIdentificationCode()));

		if (merchantPrefixCode > 0) {
			return forwardEmoneyTransferBankChannelRequest(isoMsg, request);
		}
		else {
			//FIXME forward response
			return null;//FORWARDResponse 13
		}
	}

}
