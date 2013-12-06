package com.mfino.dbcopytool.reportdb.domain;

// Generated 05-Apr-2012 00:05:38 by Hibernate Tools 3.1.0.beta4

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.Session;

import com.mfino.dbcopytool.persistence.ReportDbHibernateUtil;

/**
 * CommodityTransfer generated by hbm2java
 */

public class SubscriberBasedCT extends TableRow implements java.io.Serializable {

	// Fields
	private String commodityIdTransactionMDN;
	private String commodityTransferId;
	private String transactionId;
	private Date commodityTransferCreateTime;
	private String createYear;
	private String createMonthName;
	private String createDayofMonth;
	private String createWeekDay;
	private String uicategory;
	private String uicategoryName;
	private String transferStatus;
	private String transferFailureReason;
	private String transferFailureReasonName;
	private String sourcePocketId;
	private String destPocketId;
	private BigDecimal amount;
	private BigDecimal charges;
	private BigDecimal taxAmount;
	private String transactionChargeId;
	private Boolean isPartOfSharedUpChain;
	private String sourceSubscriberId;
	private String sourcePocketType;
	private String sourceMessage;
	private String destSubscriberId;
	private String destPocketType;
	private String sourceMdn;
	private String destMdn;
	private BigDecimal sourcePocketBalance;
	private BigDecimal destPocketBalance;
	private String subscriberMDN;
	private String csraction;
	private Date csractionTime;
	private String csruserId;
	private String csruserName;
	private String notificationCode;
	private String sctlID;
	private Date commodityTransferUpdateTime;
	private String updateYear;
	private String updateMonthName;
	private String updateDayofMonth;
	private String updateWeekDay;
	private String bankRRN;
	private String bankSTAN;
	private String currency;
	private String operatorRRN;
	private String operatorSTAN;
	private String bankCode;

	// Constructors

	/** default constructor */
	public SubscriberBasedCT() {
	}

	/** minimal constructor */
	public SubscriberBasedCT(String commodityTransferId) {
		this.commodityTransferId = commodityTransferId;
	}

	/** full constructor */
	public SubscriberBasedCT(String commodityTransferId, String transactionId,
			Date commodityTransferCreateTime, String year, String month,
			String dayOfMonth, String weekDay, String uicategory,
			String uicategoryName, String transferStatus,
			String transferFailureReason, String transferFailureReasonName,
			String sourcePocketId, String destPocketId, BigDecimal amount,
			BigDecimal charges, BigDecimal taxAmount,
			String transactionChargeId, Boolean isPartOfSharedUpChain,
			String sourceSubscriberId, String sourcePocketType,
			String sourceMessage, String destSubscriberId,
			String destPocketType, String sourceMdn, String destMdn,
			String csraction, Date csractionTime, String csruserId,
			String csruserName, String notificationCode) {
		this.commodityTransferId = commodityTransferId;
		this.transactionId = transactionId;
		this.commodityTransferCreateTime = commodityTransferCreateTime;
		this.createYear = year;
		this.createMonthName = month;
		this.createDayofMonth = dayOfMonth;
		this.createWeekDay = weekDay;
		this.uicategory = uicategory;
		this.uicategoryName = uicategoryName;
		this.transferStatus = transferStatus;
		this.transferFailureReason = transferFailureReason;
		this.transferFailureReasonName = transferFailureReasonName;
		this.sourcePocketId = sourcePocketId;
		this.destPocketId = destPocketId;
		this.amount = amount;
		this.charges = charges;
		this.taxAmount = taxAmount;
		this.transactionChargeId = transactionChargeId;
		this.isPartOfSharedUpChain = isPartOfSharedUpChain;
		this.sourceSubscriberId = sourceSubscriberId;
		this.sourcePocketType = sourcePocketType;
		this.sourceMessage = sourceMessage;
		this.destSubscriberId = destSubscriberId;
		this.destPocketType = destPocketType;
		this.sourceMdn = sourceMdn;
		this.destMdn = destMdn;
		this.csraction = csraction;
		this.csractionTime = csractionTime;
		this.csruserId = csruserId;
		this.csruserName = csruserName;
		this.notificationCode = notificationCode;
	}

	@Override
	public void initialiseRow(Object[] m) {
		int i = -1;
		this.commodityTransferId = m[++i] != null ? m[i].toString() : "";
		this.transactionId = m[++i] != null ? m[i].toString() : "";
		this.commodityTransferCreateTime = (Date) m[++i];
		this.uicategory = m[++i] != null ? m[i].toString() : "";
		this.uicategoryName = m[++i] != null ? m[i].toString() : "";
		this.transferStatus = m[++i] != null ? m[i].toString() : "";
		this.transferFailureReason = m[++i] != null ? m[i].toString() : "";
		this.transferFailureReasonName = m[++i] != null ? m[i].toString() : "";
		this.sourcePocketId = m[++i] != null ? m[i].toString() : "";
		this.destPocketId = m[++i] != null ? m[i].toString() : "";
		this.amount = (BigDecimal) m[++i];
		this.charges = (BigDecimal) m[++i];
		this.taxAmount = (BigDecimal) m[++i];
		this.transactionChargeId = m[++i] != null ? m[i].toString() : "";
		this.isPartOfSharedUpChain = (Boolean) m[++i];
		this.sourceSubscriberId = m[++i] != null ? m[i].toString() : "";
		this.sourcePocketType = m[++i] != null ? m[i].toString() : "";
		this.sourceMessage = m[++i] != null ? m[i].toString() : "";
		this.destSubscriberId = m[++i] != null ? m[i].toString() : "";
		this.destPocketType = m[++i] != null ? m[i].toString() : "";
		this.sourceMdn = m[++i] != null ? m[i].toString() : "";
		this.destMdn = m[++i] != null ? m[i].toString() : "";
		this.subscriberMDN = m[++i] != null ? m[i].toString() : "";
		this.sourcePocketBalance = (BigDecimal) m[++i];
		this.destPocketBalance =(BigDecimal) m[++i];
		this.csraction = m[++i] != null ? m[i].toString() : "";
		this.csractionTime = (Date) m[++i];
		this.csruserId = m[++i] != null ? m[i].toString() : "";
		this.csruserName = m[++i] != null ? m[i].toString() : "";
		this.notificationCode = m[++i] != null ? m[i].toString() : "";
		this.sctlID = m[++i] != null ? m[i].toString() : "";
		this.commodityTransferUpdateTime = (Date) m[++i];
		this.bankRRN = m[++i] != null ? m[i].toString() : "";
		this.bankSTAN = m[++i] != null ? m[i].toString() : "";
		this.currency = m[++i] != null ? m[i].toString() : "";
		this.operatorRRN = m[++i] != null ? m[i].toString() : "";;
		this.operatorSTAN = m[++i] != null ? m[i].toString() : "";
		this.bankCode = m[++i] != null ? m[i].toString() : "";
		transfromRow();
	}

	@Override
	public void transfromRow() {
		Date d = this.commodityTransferCreateTime;
		this.createYear = new SimpleDateFormat("yyyy").format(d);
		this.createMonthName = new SimpleDateFormat("MMMM").format(d);
		this.createDayofMonth = new SimpleDateFormat("dd").format(d);
		this.createWeekDay = new SimpleDateFormat("EEEE").format(d);
		d = this.commodityTransferUpdateTime;
		this.updateYear = new SimpleDateFormat("yyyy").format(d);
		this.updateMonthName = new SimpleDateFormat("MMMM").format(d);
		this.updateDayofMonth = new SimpleDateFormat("dd").format(d);
		this.updateWeekDay = new SimpleDateFormat("EEEE").format(d);
		
		convertTransferStatusToText();
		convertCsractionToText();
		
		this.commodityIdTransactionMDN = this.commodityTransferId+this.subscriberMDN;
	}
	
	private void convertTransferStatusToText(){
		if(this.transferStatus.equalsIgnoreCase("0")){
			this.transferStatus="Initialized";
		}else if(this.transferStatus.equalsIgnoreCase("1")){
			this.transferStatus="Completed";
		}else if(this.transferStatus.equalsIgnoreCase("2")){
			this.transferStatus="Failed";
		}else if(this.transferStatus.equalsIgnoreCase("3")){
			this.transferStatus="TransferInquirySentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("4")){
			this.transferStatus="ConfirmationPromptSentToSubscriber";
		}else if(this.transferStatus.equalsIgnoreCase("5")){
			this.transferStatus="TopupSentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("6")){
			this.transferStatus="TopupFromBankAccountSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("7")){
			this.transferStatus="MobileAgentTopupSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("8")){
			this.transferStatus="ShareLoadSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("9")){
			this.transferStatus="MoneyTransaferSentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("10")){
			this.transferStatus="BankChannelTopupSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("11")){
			this.transferStatus="BankChannelPaymentSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("12")){
			this.transferStatus="CreditCardTopupSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("13")){
			this.transferStatus="CreditCardPaymentSentToOperator";
		}else if(this.transferStatus.equalsIgnoreCase("14")){
			this.transferStatus="SMSSentToSubscriber";
		}else if(this.transferStatus.equalsIgnoreCase("15")){
			this.transferStatus="BillPaymentInquirySentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("16")){
			this.transferStatus="BillPaymentSentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("17")){
			this.transferStatus="BillPaymentTopupSentToBank";
		}else if(this.transferStatus.equalsIgnoreCase("18")){
			this.transferStatus="RequestSentToIntegrationAPI";
		}else if(this.transferStatus.equalsIgnoreCase("19")){
			this.transferStatus="ResponseReceivedFromIntegrationAPI";
		}else if(this.transferStatus.equalsIgnoreCase("20")){
			this.transferStatus="IntegrationServiceUnavailable";
		}else if(this.transferStatus.equalsIgnoreCase("21")){
			this.transferStatus="Pending";
		}
	}

	private void convertCsractionToText(){
		if(this.transferStatus.equalsIgnoreCase("")){
			this.csraction="";
		}else if(this.csraction.equalsIgnoreCase("1")){
			this.csraction="Cancel";
		}else if(this.transferStatus.equalsIgnoreCase("2")){
			this.csraction="Completed";
		}
	}
	
	@Override
	public void insertRow() {
		Session session = ReportDbHibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(this);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void printRow() {
		System.out.println(this.commodityTransferId + "," + this.transactionId
				+ "," + this.commodityTransferCreateTime + "," + this.createYear
				+ "," + this.createMonthName + "," + this.createDayofMonth + "," + this.createWeekDay
				+ "," + this.uicategory + "," + this.uicategoryName + ","
				+ this.transferStatus + "," + this.transferFailureReason + ","
				+ this.sourcePocketId + "," + this.destPocketId + ","
				+ this.amount + "," + this.charges + "," + this.taxAmount + ","
				+ this.transactionChargeId + "," + this.isPartOfSharedUpChain
				+ "," + this.sourceSubscriberId + "," + this.sourcePocketType
				+ "," + this.sourceMessage + "," + this.destSubscriberId + ","
				+ this.destPocketType + "," + this.sourceMdn + ","
				+ this.destMdn + "," + this.csraction + ","
				+ this.csractionTime + "," + this.csruserId + ","
				+ this.csruserName + "," + this.notificationCode);
	}

	// Property accessors

	public String getCommodityTransferId() {
		return this.commodityTransferId;
	}

	public void setCommodityTransferId(String commodityTransferId) {
		this.commodityTransferId = commodityTransferId;
	}

	public String getTransactionId() {
		return this.transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getCommodityTransferCreateTime() {
		return this.commodityTransferCreateTime;
	}

	public void setCommodityTransferCreateTime(Date commodityTransferCreateTime) {
		this.commodityTransferCreateTime = commodityTransferCreateTime;
	}

	public String getUicategory() {
		return this.uicategory;
	}

	public void setUicategory(String uicategory) {
		this.uicategory = uicategory;
	}

	public String getUicategoryName() {
		return this.uicategoryName;
	}

	public void setUicategoryName(String uicategoryName) {
		this.uicategoryName = uicategoryName;
	}

	public String getTransferStatus() {
		return this.transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getTransferFailureReason() {
		return this.transferFailureReason;
	}

	public void setTransferFailureReason(String transferFailureReason) {
		this.transferFailureReason = transferFailureReason;
	}

	public String getTransferFailureReasonName() {
		return this.transferFailureReasonName;
	}

	public void setTransferFailureReasonName(String transferFailureReasonName) {
		this.transferFailureReasonName = transferFailureReasonName;
	}

	public String getSourcePocketId() {
		return this.sourcePocketId;
	}

	public void setSourcePocketId(String sourcePocketId) {
		this.sourcePocketId = sourcePocketId;
	}

	public String getDestPocketId() {
		return this.destPocketId;
	}

	public void setDestPocketId(String destPocketId) {
		this.destPocketId = destPocketId;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getCharges() {
		return this.charges;
	}

	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}

	public BigDecimal getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTransactionChargeId() {
		return this.transactionChargeId;
	}

	public void setTransactionChargeId(String transactionChargeId) {
		this.transactionChargeId = transactionChargeId;
	}

	public Boolean getIsPartOfSharedUpChain() {
		return this.isPartOfSharedUpChain;
	}

	public void setIsPartOfSharedUpChain(Boolean isPartOfSharedUpChain) {
		this.isPartOfSharedUpChain = isPartOfSharedUpChain;
	}

	public String getSourceSubscriberId() {
		return this.sourceSubscriberId;
	}

	public void setSourceSubscriberId(String sourceSubscriberId) {
		this.sourceSubscriberId = sourceSubscriberId;
	}

	public String getSourcePocketType() {
		return this.sourcePocketType;
	}

	public void setSourcePocketType(String sourcePocketType) {
		this.sourcePocketType = sourcePocketType;
	}

	public String getSourceMessage() {
		return this.sourceMessage;
	}

	public void setSourceMessage(String sourceMessage) {
		this.sourceMessage = sourceMessage;
	}

	public String getDestSubscriberId() {
		return this.destSubscriberId;
	}

	public void setDestSubscriberId(String destSubscriberId) {
		this.destSubscriberId = destSubscriberId;
	}

	public String getDestPocketType() {
		return this.destPocketType;
	}

	public void setDestPocketType(String destPocketType) {
		this.destPocketType = destPocketType;
	}

	public String getSourceMdn() {
		return this.sourceMdn;
	}

	public void setSourceMdn(String sourceMdn) {
		this.sourceMdn = sourceMdn;
	}

	public String getDestMdn() {
		return this.destMdn;
	}

	public void setDestMdn(String destMdn) {
		this.destMdn = destMdn;
	}

	public String getCsraction() {
		return this.csraction;
	}

	public void setCsraction(String csraction) {
		this.csraction = csraction;
	}

	public Date getCsractionTime() {
		return this.csractionTime;
	}

	public void setCsractionTime(Date csractionTime) {
		this.csractionTime = csractionTime;
	}

	public String getCsruserId() {
		return this.csruserId;
	}

	public void setCsruserId(String csruserId) {
		this.csruserId = csruserId;
	}

	public String getCsruserName() {
		return this.csruserName;
	}

	public void setCsruserName(String csruserName) {
		this.csruserName = csruserName;
	}

	public String getNotificationCode() {
		return this.notificationCode;
	}

	public void setNotificationCode(String notificationCode) {
		this.notificationCode = notificationCode;
	}

	public String getSctlID() {
		return sctlID;
	}

	public void setSctlID(String sctlID) {
		this.sctlID = sctlID;
	}
	
	public Date getCommodityTransferUpdateTime() {
		return commodityTransferUpdateTime ;
	}

	public void setCommodityTransferUpdateTime(Date commodityTransferUpdateTime ) {
		this.commodityTransferUpdateTime = commodityTransferUpdateTime ;
	}
	
	public String getCreateMonthName() {
		return createMonthName;
	}

	public void setCreateMonthName(String createMonthName) {
		this.createMonthName = createMonthName;
	}

	public String getCreateDayofMonth() {
		return createDayofMonth;
	}

	public void setCreateDayofMonth(String createDayofMonth) {
		this.createDayofMonth = createDayofMonth;
	}

	public String getCreateWeekDay() {
		return createWeekDay;
	}

	public void setCreateWeekDay(String createWeekDay) {
		this.createWeekDay = createWeekDay;
	}

	public String getUpdateYear() {
		return updateYear;
	}

	public void setUpdateYear(String updateYear) {
		this.updateYear = updateYear;
	}

	public String getUpdateMonthName() {
		return updateMonthName;
	}

	public void setUpdateMonthName(String updateMonthName) {
		this.updateMonthName = updateMonthName;
	}

	public String getUpdateDayofMonth() {
		return updateDayofMonth;
	}

	public void setUpdateDayofMonth(String updateDayofMonth) {
		this.updateDayofMonth = updateDayofMonth;
	}

	public String getUpdateWeekDay() {
		return updateWeekDay;
	}

	public void setUpdateWeekDay(String updateWeekDay) {
		this.updateWeekDay = updateWeekDay;
	}
	
	public String getCreateYear() {
		return createYear;
	}

	public void setCreateYear(String createYear) {
		this.createYear = createYear;
	}
	
	public String getBankRRN() {
		return bankRRN;
	}

	public void setBankRRN(String bankRRN) {
		this.bankRRN = bankRRN;
	}

	public String getBankSTAN() {
		return bankSTAN;
	}
	
	public void setBankSTAN(String bankSTAN) {
		this.bankSTAN = bankSTAN;
	}
	
	public String getSubscriberMDN() {
		return subscriberMDN;
	}

	public void setSubscriberMDN(String subscriberMDN) {
		this.subscriberMDN = subscriberMDN;
	}

	public String getCommodityIdTransactionMDN() {
		return commodityIdTransactionMDN;
	}

	public void setCommodityIdTransactionMDN(String commodityIdTransactionMDN) {
		this.commodityIdTransactionMDN = commodityIdTransactionMDN;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getOperatorRRN() {
		return operatorRRN;
	}

	public void setOperatorRRN(String operatorRRN) {
		this.operatorRRN = operatorRRN;
	}

	public String getOperatorSTAN() {
		return operatorSTAN;
	}

	public void setOperatorSTAN(String operatorSTAN) {
		this.operatorSTAN = operatorSTAN;
	}
	
	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}
	public BigDecimal getSourcePocketBalance() {
		return sourcePocketBalance;
	}

	public void setSourcePocketBalance(BigDecimal sourcePocketBalance) {
		this.sourcePocketBalance = sourcePocketBalance;
	}

	public BigDecimal getDestPocketBalance() {
		return destPocketBalance;
	}

	public void setDestPocketBalance(BigDecimal destPocketBalance) {
		this.destPocketBalance = destPocketBalance;
	}

	

}
