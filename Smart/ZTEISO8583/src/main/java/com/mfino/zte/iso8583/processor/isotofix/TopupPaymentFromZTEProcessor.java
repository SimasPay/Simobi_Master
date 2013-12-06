package com.mfino.zte.iso8583.processor.isotofix;

import org.jpos.iso.ISOMsg;

import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX;
import com.mfino.fix.CmFinoFIX.CMCommodityTransferFromOperator;
import com.mfino.fix.CmFinoFIX.CMCommodityTransferToOperator;
import com.mfino.util.DateTimeUtil;
import com.mfino.util.UniqueNumberGen;
import com.mfino.zte.iso8583.processor.ZTEISOtoFixProcessor;

public class TopupPaymentFromZTEProcessor implements ZTEISOtoFixProcessor {

	@Override
	public CFIXMsg process(ISOMsg isoMsg, CFIXMsg request) {
		CMCommodityTransferToOperator toOperator = (CMCommodityTransferToOperator) request;
		CMCommodityTransferFromOperator fromOperator = new CMCommodityTransferFromOperator();
		fromOperator.copy(toOperator);
		fromOperator.setResponseCode(Integer.parseInt(isoMsg.getString(39)));

		if (!CmFinoFIX.ISO8583_Mobile_Operator_Response_Code_Success.equals(fromOperator.getResponseCode())) {
			fromOperator.setRejectReason(isoMsg.getString(39));
			return fromOperator;
		}
		// fromOperator.header().setMsgSeqNum(null);
		String responseData = isoMsg.getString(62);
		String windowPeriod  = "20100101";
//		if(responseData.length() >= 33)
//			windowPeriod = responseData.substr(25, 8);
//		DebugPrint(0, "The TOPUP RESPONSE WINDOW PERIOD is %s\n", windowPeriod.c_str());
//		std::string voucherSerialNumber = "000000000000";
//		if(responseData.length() >= 45)
//			voucherSerialNumber = responseData.substr(33, 12);
//		DebugPrint(0, "The TOPUP RESPONSE VOUCHER NUMBER is %s\n", voucherSerialNumber.c_str());
//			response.SetPaymentVoucherPeriodYYYYMMDDValue(atol(windowPeriod.c_str()));

		if((null != responseData) &&(responseData.length()>=33))
			windowPeriod = responseData.substring(25,33);
		
		String voucherSerialNumber = "000000000000";
		
		if((null != responseData) && (responseData.length()>=45)){
			voucherSerialNumber  = responseData.substring(33,45);
		}
		
		fromOperator.setPaymentVoucherPeriodYYYYMMDD(Long.parseLong(windowPeriod));
		
		fromOperator.header().setSendingTime(DateTimeUtil.getLocalTime());
		fromOperator.header().setMsgSeqNum(UniqueNumberGen.getNextNum());
		
		return fromOperator;
	}

}
