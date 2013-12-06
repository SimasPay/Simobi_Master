/*package com.mfino.bsim.iso8583.processor.fixtoiso;

import java.io.IOException;
import java.math.BigDecimal;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.mfino.bsim.iso8583.utils.DateTimeFormatter;
import com.mfino.bsim.iso8583.utils.StringUtilities;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMBillPaymentBankRequest;
import com.mfino.fix.CmFinoFIX.CMBillPaymentInquiryToBank;
import com.mfino.fix.CmFinoFIX.CMBillPaymentReversalToBank;
import com.mfino.fix.CmFinoFIX.CMBillPaymentToBank;
import com.mfino.fix.CmFinoFIX.CMMoneyTransferToBank;
import com.mfino.hibernate.Timestamp;
import com.mfino.util.DateTimeUtil;

public class BillPaymentReprint extends BankRequestProcessor{
	
	public BillPaymentReprint() {
		try{
			isoMsg.setMTI("0200");
		}
		catch (ISOException e) {
			e.printStackTrace();
		}
	}
	public ISOMsg process(CFIXMsg fixmsg){
		CMBillPaymentReprint request = (CMBillPaymentReprint)fixmsg;
		Timestamp ts = DateTimeUtil.getLocalTime();
		Long transactionID = request.getTransactionID();
		try
		{   
			isoMsg.set(2,request.getSourceCardPAN());
			isoMsg.set(3,CmFinoFIX.ISO8583_ProcessingCode_XLink_Payment2);
			BigDecimal amount = request.getAmount();
			isoMsg.set(4,amount.longValue() + "");
			isoMsg.set(7,DateTimeFormatter.getMMDDHHMMSS(ts));
			isoMsg.set(11,StringUtilities.leftPadWithCharacter(transactionID.toString(), 6, "0"));
			isoMsg.set(12,DateTimeFormatter.getHHMMSS(ts));
			isoMsg.set(13,DateTimeFormatter.getMMDD(ts));
		    isoMsg.set(15,DateTimeFormatter.getMMDD(ts));
			isoMsg.set(18,CmFinoFIX.ISO8583_MerchantType_Delivery_Channel_For_Mobile_Phone);
		    isoMsg.set(27, CmFinoFIX.ISO8583_AuthorizationIdentificationResponseLength_Sinarmas.toString());
			isoMsg.set(32,constantFieldsMap.get(32));
			isoMsg.set(33,CmFinoFIX.ISO8583_ForwardingInstitutionIdentificationCode_Smart_To_Sinarmas.toString());
			isoMsg.set(34,request.getSourceCardPAN());
			isoMsg.set(37, StringUtilities.rightPadWithCharacter(request.getTransactionID().toString(), 12, " "));
			isoMsg.set(41, constantFieldsMap.get("41"));
			isoMsg.set(42, StringUtilities.rightPadWithCharacter(request.getSourceMDN(), 15, " "));
			isoMsg.set(43, StringUtilities.rightPadWithCharacter("SMS SMART", 40, " "));
			isoMsg.set(49, constantFieldsMap.get("49"));
			isoMsg.set(60,request.getPaymentTransactionData());
			isoMsg.set(98,request.getProductIndicatorCode());
			isoMsg.set(102,request.getSourceCardPAN());
			}
		catch (ISOException ex) {
			log.error("BillPaymentsToBankProcessor :: process ", ex);
		}
		return isoMsg;
		
	}
}
*/