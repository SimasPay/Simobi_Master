package com.mfino.iso8583.processor.mobileoperator.fixtoiso;

import static com.mfino.fix.CmFinoFIX.ISO8583_Mobile_Operator_ProcessingCode_Postpaid_Payment;
import static com.mfino.fix.CmFinoFIX.ISO8583_Sinarmas_CurrencyCode_IDR;
import static com.mfino.fix.CmFinoFIX.*;

import org.apache.commons.lang.StringUtils;

import com.mfino.fix.CFIXMsg;
import com.mfino.fix.CmFinoFIX.CMCommodityTransferReversalToOperator;
import com.mfino.hibernate.Timestamp;
import com.mfino.iso8583.IFIXtoISOProcessor;
import com.mfino.iso8583.WrapperISOMessage;
import com.mfino.iso8583.WrapperISOMessageFactory;
import com.mfino.iso8583.processor.mobileoperator.MobileOperatorISOMessage;
import com.mfino.util.DateTimeUtil;
import com.mfino.util.MfinoUtil;
import com.solab.iso8583.IsoType;
import com.solab.iso8583.IsoValue;

public class PostpaidBillPayment implements IFIXtoISOProcessor{
	@Override
    public WrapperISOMessage process(CFIXMsg fixmsg) throws Exception {

		MobileOperatorISOMessage isoMsg = (MobileOperatorISOMessage) WrapperISOMessageFactory.newWrapperISOMessage(0x200,
		        ISO8583_Variant_Mobile_Operator_Gateway_Interface);
		if(fixmsg instanceof CMCommodityTransferToOperator) {
			
			CMCommodityTransferToOperator request = (CMCommodityTransferToOperator)fixmsg;
			
			isoMsg.setProcessingCode(Integer.parseInt(ISO8583_Mobile_Operator_ProcessingCode_Postpaid_Payment));
			isoMsg.setTransactionAmount(request.getAmount().toString());
			Timestamp ts = DateTimeUtil.getLocalTime();
			isoMsg.setTransmissionTime(ts);
			if(!StringUtils.isBlank(request.getISO8583_SystemTraceAuditNumber()))
				isoMsg.setSTAN(Long.parseLong(request.getISO8583_SystemTraceAuditNumber()));
			else
				isoMsg.setSTAN(request.getTransactionID()%1000000);
			isoMsg.setLocalTransactionTime(ts);
			isoMsg.setLocalTransactionDate(ts);
			isoMsg.setSettlementDate(ts);
			if(!StringUtils.isBlank( request.getISO8583_MerchantType()))
				isoMsg.setMerchantType(Integer.parseInt(request.getISO8583_MerchantType()));
			else
				isoMsg.setMerchantType(Integer.parseInt(MfinoUtil.GetMerchantTypeBySourceApplication(request.getSourceApplication())));
			if(request.getISO8583_AcquiringInstIdCode()!=null)			
				isoMsg.setAcquiringInstitutionIdentificationCode(request.getISO8583_AcquiringInstIdCode().toString());
			else
				isoMsg.setAcquiringInstitutionIdentificationCode(ISO8583_AcquiringInstIdCode_mFino_To_Smart.toString());
			
			if(!StringUtils.isBlank(request.getISO8583_RetrievalReferenceNum()))
				isoMsg.setRRN(request.getISO8583_RetrievalReferenceNum());
			else
				isoMsg.setRRN(request.getTransactionID().toString());
			isoMsg.setCardAcceptorNameLocation("SMS SMART");
			if(!StringUtils.isBlank(request.getProductIndicatorCode()))
				isoMsg.setProductIndicator(request.getProductIndicatorCode());
			else
				isoMsg.setProductIndicator("5200");
			isoMsg.setTransactionCurrencyCode(ISO8583_Sinarmas_CurrencyCode_IDR);
			isoMsg.setTransactionRequestData(WrapperISOMessage.padOnRight(request.getDestMDN(), ' ', 13));
		}
		else {
			throw new Exception("Not an instance of CMCommodityTransferReversalToOperator");
		}
		return isoMsg;
    }

}
