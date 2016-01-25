package com.mfino.bsm.ppob.iso8583.processor.fixtoiso;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;

import com.mfino.bsm.ppob.iso8583.utils.DateTimeFormatter;
import com.mfino.bsm.ppob.iso8583.utils.StringUtilities;
import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMInterBankMoneyTransferToBank;
import com.mfino.hibernate.Timestamp;
import com.mfino.iso8583.definitions.exceptions.AllElementsNotAvailableException;
import com.mfino.util.DateTimeUtil;

/**
 * 
 * @author Amar
 *
 */
public class InterBankMoneyTransferToBankProcessor extends BankRequestProcessor {
	public static final String	MTI	= "0200";
	public InterBankMoneyTransferToBankProcessor() {
		try {
			isoMsg.setMTI(MTI);
		} catch (ISOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ISOMsg process(CFIXMsg fixmsg) throws AllElementsNotAvailableException {
		CMInterBankMoneyTransferToBank msg = (CMInterBankMoneyTransferToBank) fixmsg;
		Timestamp ts = msg.getTransferTime();//changed to show transfer time as to show same thing in reversal. This is GMT Time
		Timestamp localTS = DateTimeUtil.getLocalTime();
		// use the MDN of the global account
		String mdn = msg.getSourceMDNToUseForBank();

		if (mdn == null) {
			mdn = msg.getSourceMDN();
		}

		try {
			isoMsg.set(2, msg.getMPan());			
			String processingCode = null;
			String sourceAccountType = "00";
			String destAccountType = "00";
			if (CmFinoFIX.BankAccountType_Saving.toString().equals(msg.getSourceBankAccountType()))
				sourceAccountType = constantFieldsMap.get("SAVINGS_ACCOUNT");
			else if (CmFinoFIX.BankAccountType_Checking.toString().equals(msg.getSourceBankAccountType()))
				sourceAccountType = constantFieldsMap.get("CHECKING_ACCOUNT");			
			
			if (CmFinoFIX.BankAccountType_Saving.toString().equals(msg.getDestinationBankAccountType()))
				destAccountType = constantFieldsMap.get("SAVINGS_ACCOUNT");
			else if (CmFinoFIX.BankAccountType_Checking.toString().equals(msg.getDestinationBankAccountType()))
				destAccountType = constantFieldsMap.get("CHECKING_ACCOUNT");
			
			processingCode = "49" + sourceAccountType + destAccountType;
			isoMsg.set(3, processingCode);
			long amount = msg.getAmount().longValue()*(100);
			isoMsg.set(4,StringUtilities.leftPadWithCharacter(amount + "", constantFieldsMap.get("4").length(), "0"));
			isoMsg.set(7, DateTimeFormatter.getMMDDHHMMSS(ts)); // 7
			Long transactionID = msg.getTransactionID();
			transactionID = transactionID % 1000000;
			isoMsg.set(11, StringUtilities.leftPadWithCharacter(transactionID.toString(), 6, "0"));// 11
			isoMsg.set(12, DateTimeFormatter.getHHMMSS(localTS)); // 12
			isoMsg.set(13, DateTimeFormatter.getMMDD(localTS)); // 13
			isoMsg.set(15, DateTimeFormatter.getMMDD(ts)); // 15
			isoMsg.set(18, constantFieldsMap.get("DE18")); // 18
			isoMsg.set(22, constantFieldsMap.get("22")); // 18
			isoMsg.set(25, constantFieldsMap.get("25")); // 18
			isoMsg.set(26, constantFieldsMap.get("26")); // 18
			isoMsg.set(27, CmFinoFIX.ISO8583_AuthorizationIdentificationResponseLength_Sinarmas.toString()); // 27
			isoMsg.set(32, constantFieldsMap.get("32"));// 32 source bank code (bsim ibt)
			isoMsg.set(33, constantFieldsMap.get("33"));// 33 source bank code (bsim ibt)
			isoMsg.set(37, StringUtilities.leftPadWithCharacter(msg.getTransactionID().toString(), 12, "0"));
			isoMsg.set(41, constantFieldsMap.get("41"));
			isoMsg.set(42, StringUtilities.rightPadWithCharacter(msg.getSourceMDN(), 15, " "));
			isoMsg.set(43, constantFieldsMap.get("43"));
			isoMsg.set(47, msg.getTransactionID().toString());
			isoMsg.set(48, msg.getAdditionalInfo());
			isoMsg.set(49, constantFieldsMap.get("49"));
			isoMsg.set(63, constructDE63(msg));
			isoMsg.set(100, constantFieldsMap.get("100"));
			isoMsg.set(102,msg.getSourceCardPAN());
			isoMsg.set(103,msg.getDestCardPAN());
//			if(msg.getLanguage().equals(0))
//				isoMsg.set(121,constantFieldsMap.get("english"));
//			else
//				isoMsg.set(121,constantFieldsMap.get("bahasa"));
			isoMsg.set(127, msg.getDestBankCode());
		}
		catch (ISOException ex) {
			log.error("MoneyTransferToBankProcessor process ", ex);
		}catch (Exception e) {
			log.error("MoneyTransferToBankProcessor process ", e);
		}
		return isoMsg;
	}
	
	private String constructDE63(CMInterBankMoneyTransferToBank request) {
		String de63 = constantFieldsMap.get("63");
		String strServiceCharge = "C" + StringUtilities.leftPadWithCharacter(request.getServiceChargeDE63(),8,"0");
		de63 = StringUtilities.replaceNthBlock(de63, 'C', 12,strServiceCharge,9);
		return de63;
	}	
}
