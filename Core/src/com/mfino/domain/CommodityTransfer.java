package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.lang.reflect.Method;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mfino.hibernate.Timestamp;
import com.mfino.service.CoreServiceFactory;
import com.mfino.service.HibernateService;

/**
 * CommodityTransfer generated by hbm2java
 */
@Entity
@Table(name = "COMMODITY_TRANSFER", uniqueConstraints = @UniqueConstraint(columnNames = {
		"BULKUPLOADID", "BULKUPLOADLINENUMBER" }))
public class CommodityTransfer extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FieldName_TransferStatus = "transferstatus";
	public static final String FieldName_TransferFailureReason = "transferfailurereason";
	public static final String FieldName_StartTime = "starttime";
	public static final String FieldName_EndTime = "endtime";
	public static final String FieldName_TransferAmount = "amount";
	public static final String FieldName_TransactionsLogByTransactionID = "transactionLog";
	public static final String FieldName_DestMDNID = "destmdnid";
	public static final String FieldName_SourceApplication = "sourceapplication";
	public static final String FieldName_TransactionUICategory = "uicategory";
	public static final String FieldName_BankCodeForRouting = "bankcode";
	public static final String FieldName_BankResponseCode = "bankresponsecode";
	public static final String FieldName_OperatorResponseCode = "operatorresponsecode";
	public static final String FieldName_SourceMDN = "sourcemdn";
	public static final String FieldName_DestMDN = "destmdn";
	public static final String FieldName_ISO8583_AcquiringInstIdCode = "iso8583Acquiringinstidcode";
	public static final String FieldName_SourceReferenceID = "sourcereferenceid";
	public static final String FieldName_ISO8583_SystemTraceAuditNumber = "iso8583Systemtraceauditnumber";
	public static final String FieldName_OperatorAuthorizationCode = "operatorauthorizationcode";
	public static final String FieldName_BankAuthorizationCode = "bankauthorizationcode";
	public static final String FieldName_BankReversalAuthorizationCode = "bankreversalauthorizationcode";
	public static final String FieldName_DestPocketID = "destpocketid";
	public static final String FieldName_BulkUploadID = "bulkuploadid";
	public static final String FieldName_CSRAction = "csraction";
	public static final String FieldName_BulkUploadLineNumber = "bulkuploadlinenumber";
	public static final String FieldName_Commodity = "commodity";
	public static final String FieldName_MsgType = "msgtype";
	public static final String FieldName_Company = "company";
	public static final String FieldName_BankRetrievalReferenceNumber = "bankretrievalreferencenumber";
	public static final String FieldName_SourceMessage = "sourcemessage";
	public static final String FieldName_PocketBySourcePocketID = "pocket";

	public static final String FieldName_SourcePocketID = "pocket";

	public static final String FieldName_CSRActionTime = "csractiontime";
	public static final String FieldName_NotificationCode = "notificationcode";
	
	private SubscriberMdn subscriberMdn;
	private TransactionLog transactionLog;
	private CreditCardTransaction creditCardTransaction;
	private LetterOfPurchase letterOfPurchase;
	private Subscriber subscriber;
	private MfinoServiceProvider mfinoServiceProvider;
	private Company company;
	private DistributionChainLvl distributionChainLvl;
	private Pocket pocket;
	private Integer msgtype;
	private Integer uicategory;
	private Integer transferstatus;
	private Integer transferfailurereason;
	private Integer notificationcode;
	private Timestamp starttime;
	private Timestamp endtime;
	private Integer expirationtimeout;
	private String sourceip;
	private String sourcereferenceid;
	private String sourceterminalid;
	private String sourcemdn;
	private Integer levelpermissions;
	private String sourcesubscribername;
	private Integer sourcepocketallowance;
	private Integer sourcepockettype;
	private BigDecimal sourcepocketbalance;
	private String sourcecardpan;
	private String sourcemessage;
	private String destmdn;
	private Long destmdnid;
	private Long destsubscriberid;
	private String destsubscribername;
	private Integer destpocketallowance;
	private Integer destpockettype;
	private Long destpocketid;
	private BigDecimal destpocketbalance;
	private String destbankaccountname;
	private String destcardpan;
	private Integer billingtype;
	private BigDecimal amount;
	private BigDecimal charges;
	private BigDecimal taxamount;
	private Integer commodity;
	private String buckettype;
	private Integer sourceapplication;
	private String servletpath;
	private String currency;
	private Integer bankcode;
	private Integer operatorcode;
	private Timestamp operatorresponsetime;
	private Integer operatorresponsecode;
	private String operatorrejectreason;
	private String operatorerrortext;
	private String operatorauthorizationcode;
	private Timestamp operatorreversalresponsetime;
	private Integer operatorreversalresponsecode;
	private String operatorreversalrejectreason;
	private String operatorreversalerrortext;
	private Integer operatorreversalcount;
	private Timestamp operatorlastreversaltime;
	private Long topupperiod;
	private String bankretrievalreferencenumber;
	private String banksystemtraceauditnumber;
	private Timestamp bankresponsetime;
	private Integer bankresponsecode;
	private String bankrejectreason;
	private String bankerrortext;
	private String bankauthorizationcode;
	private Timestamp bankreversalresponsetime;
	private Integer bankreversalresponsecode;
	private String bankreversalrejectreason;
	private String bankreversalerrortext;
	private String bankreversalauthorizationcode;
	private Integer reversalcount;
	private Timestamp lastreversaltime;
	private Integer csraction;
	private Timestamp csractiontime;
	private Long csruserid;
	private String csrusername;
	private String csrcomment;
	private String iso8583Processingcode;
	private String iso8583Primaryaccountnumber;
	private String iso8583Systemtraceauditnumber;
	private String iso8583Localtxntimehhmmss;
	private String iso8583Merchanttype;
	private Integer iso8583Acquiringinstidcode;
	private String iso8583Retrievalreferencenum;
	private String iso8583Cardacceptoridcode;
	private String iso8583Variant;
	private String iso8583Responsecode;
	private Long bulkuploadid;
	private Integer bulkuploadlinenumber;
	private String copytopermanenterror;
	private String webclientip;
	private String operatorrrn;
	private String operatorstan;
	private String productindicatorcode;
	private Long units;
	private Long denomination;
	private Long transactionchargeid;
	private Boolean ispartofsharedupchain;
	private Long id;
	private Boolean isCreditInMFSLedger;
	
	private Long sctlId;

	private String generatedTxnDescription;
	
	public CommodityTransfer() {
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCEMDNID", nullable = false)
	public SubscriberMdn getSubscriberMdn() {
		return this.subscriberMdn;
	}

	public void setSubscriberMdn(SubscriberMdn subscriberMdn) {
		this.subscriberMdn = subscriberMdn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTIONID", nullable = false)
	public TransactionLog getTransactionLog() {
		return this.transactionLog;
	}

	public void setTransactionLog(TransactionLog transactionLog) {
		this.transactionLog = transactionLog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREDITCARDTRANSACTIONID")
	public CreditCardTransaction getCreditCardTransaction() {
		return this.creditCardTransaction;
	}

	public void setCreditCardTransaction(
			CreditCardTransaction creditCardTransaction) {
		this.creditCardTransaction = creditCardTransaction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOPID")
	public LetterOfPurchase getLetterOfPurchase() {
		return this.letterOfPurchase;
	}

	public void setLetterOfPurchase(LetterOfPurchase letterOfPurchase) {
		this.letterOfPurchase = letterOfPurchase;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCESUBSCRIBERID", nullable = false)
	public Subscriber getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSPID", nullable = false)
	public MfinoServiceProvider getMfinoServiceProvider() {
		return this.mfinoServiceProvider;
	}

	public void setMfinoServiceProvider(
			MfinoServiceProvider mfinoServiceProvider) {
		this.mfinoServiceProvider = mfinoServiceProvider;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANYID", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DCTLEVELID")
	public DistributionChainLvl getDistributionChainLvl() {
		return this.distributionChainLvl;
	}

	public void setDistributionChainLvl(
			DistributionChainLvl distributionChainLvl) {
		this.distributionChainLvl = distributionChainLvl;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCEPOCKETID", nullable = false)
	public Pocket getPocket() {
		return this.pocket;
	}

	public void setPocket(Pocket pocket) {
		this.pocket = pocket;
	}

	
	@Column(name = "MSGTYPE", nullable = false, precision = 10, scale = 0)
	public Integer getMsgtype() {
		return this.msgtype;
	}

	public void setMsgtype(Integer msgtype) {
		this.msgtype = msgtype;
	}

	@Column(name = "UICATEGORY", precision = 10, scale = 0)
	public Integer getUicategory() {
		return this.uicategory;
	}

	public void setUicategory(Integer uicategory) {
		this.uicategory = uicategory;
	}

	@Column(name = "TRANSFERSTATUS", nullable = false, precision = 10, scale = 0)
	public Integer getTransferstatus() {
		return this.transferstatus;
	}

	public void setTransferstatus(Integer transferstatus) {
		this.transferstatus = transferstatus;
	}

	@Column(name = "TRANSFERFAILUREREASON", precision = 10, scale = 0)
	public Integer getTransferfailurereason() {
		return this.transferfailurereason;
	}

	public void setTransferfailurereason(Integer transferfailurereason) {
		this.transferfailurereason = transferfailurereason;
	}

	@Column(name = "NOTIFICATIONCODE", precision = 10, scale = 0)
	public Integer getNotificationcode() {
		return this.notificationcode;
	}

	public void setNotificationcode(Integer notificationcode) {
		this.notificationcode = notificationcode;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "STARTTIME", nullable = false)
	public Timestamp getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "ENDTIME")
	public Timestamp getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	@Column(name = "EXPIRATIONTIMEOUT", nullable = false, precision = 10, scale = 0)
	public Integer getExpirationtimeout() {
		return this.expirationtimeout;
	}

	public void setExpirationtimeout(Integer expirationtimeout) {
		this.expirationtimeout = expirationtimeout;
	}

	@Column(name = "SOURCEIP", length = 1020)
	public String getSourceip() {
		return this.sourceip;
	}

	public void setSourceip(String sourceip) {
		this.sourceip = sourceip;
	}

	@Column(name = "SOURCEREFERENCEID", length = 1020)
	public String getSourcereferenceid() {
		return this.sourcereferenceid;
	}

	public void setSourcereferenceid(String sourcereferenceid) {
		this.sourcereferenceid = sourcereferenceid;
	}

	@Column(name = "SOURCETERMINALID", length = 1020)
	public String getSourceterminalid() {
		return this.sourceterminalid;
	}

	public void setSourceterminalid(String sourceterminalid) {
		this.sourceterminalid = sourceterminalid;
	}

	@Column(name = "SOURCEMDN", nullable = false, length = 1020)
	public String getSourcemdn() {
		return this.sourcemdn;
	}

	public void setSourcemdn(String sourcemdn) {
		this.sourcemdn = sourcemdn;
	}

	@Column(name = "LEVELPERMISSIONS", precision = 10, scale = 0)
	public Integer getLevelpermissions() {
		return this.levelpermissions;
	}

	public void setLevelpermissions(Integer levelpermissions) {
		this.levelpermissions = levelpermissions;
	}

	@Column(name = "SOURCESUBSCRIBERNAME", length = 1020)
	public String getSourcesubscribername() {
		return this.sourcesubscribername;
	}

	public void setSourcesubscribername(String sourcesubscribername) {
		this.sourcesubscribername = sourcesubscribername;
	}

	@Column(name = "SOURCEPOCKETALLOWANCE", precision = 10, scale = 0)
	public Integer getSourcepocketallowance() {
		return this.sourcepocketallowance;
	}

	public void setSourcepocketallowance(Integer sourcepocketallowance) {
		this.sourcepocketallowance = sourcepocketallowance;
	}

	@Column(name = "SOURCEPOCKETTYPE", nullable = false, precision = 10, scale = 0)
	public Integer getSourcepockettype() {
		return this.sourcepockettype;
	}

	public void setSourcepockettype(Integer sourcepockettype) {
		this.sourcepockettype = sourcepockettype;
	}
 
	@Type(type = "encryptedBigDecimal")
	@Column(name = "SOURCEPOCKETBALANCE", length = 1020)
	public BigDecimal getSourcepocketbalance() {
		return this.sourcepocketbalance;
	}

	public void setSourcepocketbalance(BigDecimal sourcepocketbalance) {
		this.sourcepocketbalance = sourcepocketbalance;
	}

	@Type(type = "uniqueencryptedString")
	@Column(name = "SOURCECARDPAN", length = 1020)
	public String getSourcecardpan() {
		return this.sourcecardpan;
	}

	public void setSourcecardpan(String sourcecardpan) {
		this.sourcecardpan = sourcecardpan;
	}

	@Column(name = "SOURCEMESSAGE", length = 1020)
	public String getSourcemessage() {
		return this.sourcemessage;
	}

	public void setSourcemessage(String sourcemessage) {
		this.sourcemessage = sourcemessage;
	}

	@Column(name = "DESTMDN", length = 1020)
	public String getDestmdn() {
		return this.destmdn;
	}

	public void setDestmdn(String destmdn) {
		this.destmdn = destmdn;
	}

	@Column(name = "DESTMDNID", scale = 0)
	public Long getDestmdnid() {
		return this.destmdnid;
	}

	public void setDestmdnid(Long destmdnid) {
		this.destmdnid = destmdnid;
	}

	@Column(name = "DESTSUBSCRIBERID", scale = 0)
	public Long getDestsubscriberid() {
		return this.destsubscriberid;
	}

	public void setDestsubscriberid(Long destsubscriberid) {
		this.destsubscriberid = destsubscriberid;
	}

	@Column(name = "DESTSUBSCRIBERNAME", length = 1020)
	public String getDestsubscribername() {
		return this.destsubscribername;
	}

	public void setDestsubscribername(String destsubscribername) {
		this.destsubscribername = destsubscribername;
	}

	@Column(name = "DESTPOCKETALLOWANCE", precision = 10, scale = 0)
	public Integer getDestpocketallowance() {
		return this.destpocketallowance;
	}

	public void setDestpocketallowance(Integer destpocketallowance) {
		this.destpocketallowance = destpocketallowance;
	}

	@Column(name = "DESTPOCKETTYPE", precision = 10, scale = 0)
	public Integer getDestpockettype() {
		return this.destpockettype;
	}

	public void setDestpockettype(Integer destpockettype) {
		this.destpockettype = destpockettype;
	}

	@Column(name = "DESTPOCKETID", scale = 0)
	public Long getDestpocketid() {
		return this.destpocketid;
	}

	public void setDestpocketid(Long destpocketid) {
		this.destpocketid = destpocketid;
	}
    
	@Type(type = "encryptedBigDecimal")
	@Column(name = "DESTPOCKETBALANCE", length = 1020)
	public BigDecimal getDestpocketbalance() {
		return this.destpocketbalance;
	}

	public void setDestpocketbalance(BigDecimal destpocketbalance) {
		this.destpocketbalance = destpocketbalance;
	}

	@Column(name = "DESTBANKACCOUNTNAME", length = 1020)
	public String getDestbankaccountname() {
		return this.destbankaccountname;
	}

	public void setDestbankaccountname(String destbankaccountname) {
		this.destbankaccountname = destbankaccountname;
	}

	@Type(type = "uniqueencryptedString")
	@Column(name = "DESTCARDPAN", length = 1020)
	public String getDestcardpan() {
		return this.destcardpan;
	}

	public void setDestcardpan(String destcardpan) {
		this.destcardpan = destcardpan;
	}

	@Column(name = "BILLINGTYPE", precision = 10, scale = 0)
	public Integer getBillingtype() {
		return this.billingtype;
	}

	public void setBillingtype(Integer billingtype) {
		this.billingtype = billingtype;
	}

	@Column(name = "AMOUNT", nullable = false, precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "CHARGES", nullable = false, precision = 25, scale = 4)
	public BigDecimal getCharges() {
		return this.charges;
	}

	public void setCharges(BigDecimal charges) {
		this.charges = charges;
	}

	@Column(name = "TAXAMOUNT", precision = 25, scale = 4)
	public BigDecimal getTaxamount() {
		return this.taxamount;
	}

	public void setTaxamount(BigDecimal taxamount) {
		this.taxamount = taxamount;
	}

	@Column(name = "COMMODITY", nullable = false, precision = 10, scale = 0)
	public Integer getCommodity() {
		return this.commodity;
	}

	public void setCommodity(Integer commodity) {
		this.commodity = commodity;
	}

	@Column(name = "BUCKETTYPE", length = 1020)
	public String getBuckettype() {
		return this.buckettype;
	}

	public void setBuckettype(String buckettype) {
		this.buckettype = buckettype;
	}

	@Column(name = "SOURCEAPPLICATION", nullable = false, precision = 10, scale = 0)
	public Integer getSourceapplication() {
		return this.sourceapplication;
	}

	public void setSourceapplication(Integer sourceapplication) {
		this.sourceapplication = sourceapplication;
	}

	@Column(name = "SERVLETPATH", length = 1020)
	public String getServletpath() {
		return this.servletpath;
	}

	public void setServletpath(String servletpath) {
		this.servletpath = servletpath;
	}

	@Column(name = "CURRENCY", nullable = false, length = 1020)
	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name = "BANKCODE", precision = 10, scale = 0)
	public Integer getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(Integer bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "OPERATORCODE", precision = 10, scale = 0)
	public Integer getOperatorcode() {
		return this.operatorcode;
	}

	public void setOperatorcode(Integer operatorcode) {
		this.operatorcode = operatorcode;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "OPERATORRESPONSETIME")
	public Timestamp getOperatorresponsetime() {
		return this.operatorresponsetime;
	}

	public void setOperatorresponsetime(Timestamp operatorresponsetime) {
		this.operatorresponsetime = operatorresponsetime;
	}

	@Column(name = "OPERATORRESPONSECODE", precision = 10, scale = 0)
	public Integer getOperatorresponsecode() {
		return this.operatorresponsecode;
	}

	public void setOperatorresponsecode(Integer operatorresponsecode) {
		this.operatorresponsecode = operatorresponsecode;
	}

	@Column(name = "OPERATORREJECTREASON", length = 1020)
	public String getOperatorrejectreason() {
		return this.operatorrejectreason;
	}

	public void setOperatorrejectreason(String operatorrejectreason) {
		this.operatorrejectreason = operatorrejectreason;
	}

	@Column(name = "OPERATORERRORTEXT", length = 1020)
	public String getOperatorerrortext() {
		return this.operatorerrortext;
	}

	public void setOperatorerrortext(String operatorerrortext) {
		this.operatorerrortext = operatorerrortext;
	}

	@Column(name = "OPERATORAUTHORIZATIONCODE", length = 1020)
	public String getOperatorauthorizationcode() {
		return this.operatorauthorizationcode;
	}

	public void setOperatorauthorizationcode(String operatorauthorizationcode) {
		this.operatorauthorizationcode = operatorauthorizationcode;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "OPERATORREVERSALRESPONSETIME")
	public Timestamp getOperatorreversalresponsetime() {
		return this.operatorreversalresponsetime;
	}

	public void setOperatorreversalresponsetime(
			Timestamp operatorreversalresponsetime) {
		this.operatorreversalresponsetime = operatorreversalresponsetime;
	}

	@Column(name = "OPERATORREVERSALRESPONSECODE", precision = 10, scale = 0)
	public Integer getOperatorreversalresponsecode() {
		return this.operatorreversalresponsecode;
	}

	public void setOperatorreversalresponsecode(
			Integer operatorreversalresponsecode) {
		this.operatorreversalresponsecode = operatorreversalresponsecode;
	}

	@Column(name = "OPERATORREVERSALREJECTREASON", length = 1020)
	public String getOperatorreversalrejectreason() {
		return this.operatorreversalrejectreason;
	}

	public void setOperatorreversalrejectreason(
			String operatorreversalrejectreason) {
		this.operatorreversalrejectreason = operatorreversalrejectreason;
	}

	@Column(name = "OPERATORREVERSALERRORTEXT", length = 1020)
	public String getOperatorreversalerrortext() {
		return this.operatorreversalerrortext;
	}

	public void setOperatorreversalerrortext(String operatorreversalerrortext) {
		this.operatorreversalerrortext = operatorreversalerrortext;
	}

	@Column(name = "OPERATORREVERSALCOUNT", precision = 10, scale = 0)
	public Integer getOperatorreversalcount() {
		return this.operatorreversalcount;
	}

	public void setOperatorreversalcount(Integer operatorreversalcount) {
		this.operatorreversalcount = operatorreversalcount;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "OPERATORLASTREVERSALTIME")
	public Timestamp getOperatorlastreversaltime() {
		return this.operatorlastreversaltime;
	}

	public void setOperatorlastreversaltime(
			Timestamp operatorlastreversaltime) {
		this.operatorlastreversaltime = operatorlastreversaltime;
	}

	@Column(name = "TOPUPPERIOD", scale = 0)
	public Long getTopupperiod() {
		return this.topupperiod;
	}

	public void setTopupperiod(Long topupperiod) {
		this.topupperiod = topupperiod;
	}

	@Column(name = "BANKRETRIEVALREFERENCENUMBER", length = 1020)
	public String getBankretrievalreferencenumber() {
		return this.bankretrievalreferencenumber;
	}

	public void setBankretrievalreferencenumber(
			String bankretrievalreferencenumber) {
		this.bankretrievalreferencenumber = bankretrievalreferencenumber;
	}

	@Column(name = "BANKSYSTEMTRACEAUDITNUMBER", length = 1020)
	public String getBanksystemtraceauditnumber() {
		return this.banksystemtraceauditnumber;
	}

	public void setBanksystemtraceauditnumber(String banksystemtraceauditnumber) {
		this.banksystemtraceauditnumber = banksystemtraceauditnumber;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "BANKRESPONSETIME")
	public Timestamp getBankresponsetime() {
		return this.bankresponsetime;
	}

	public void setBankresponsetime(Timestamp bankresponsetime) {
		this.bankresponsetime = bankresponsetime;
	}

	@Column(name = "BANKRESPONSECODE", precision = 10, scale = 0)
	public Integer getBankresponsecode() {
		return this.bankresponsecode;
	}

	public void setBankresponsecode(Integer bankresponsecode) {
		this.bankresponsecode = bankresponsecode;
	}

	@Column(name = "BANKREJECTREASON", length = 1020)
	public String getBankrejectreason() {
		return this.bankrejectreason;
	}

	public void setBankrejectreason(String bankrejectreason) {
		this.bankrejectreason = bankrejectreason;
	}

	@Column(name = "BANKERRORTEXT", length = 1020)
	public String getBankerrortext() {
		return this.bankerrortext;
	}

	public void setBankerrortext(String bankerrortext) {
		this.bankerrortext = bankerrortext;
	}

	@Column(name = "BANKAUTHORIZATIONCODE", length = 1020)
	public String getBankauthorizationcode() {
		return this.bankauthorizationcode;
	}

	public void setBankauthorizationcode(String bankauthorizationcode) {
		this.bankauthorizationcode = bankauthorizationcode;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "BANKREVERSALRESPONSETIME")
	public Timestamp getBankreversalresponsetime() {
		return this.bankreversalresponsetime;
	}

	public void setBankreversalresponsetime(
			Timestamp bankreversalresponsetime) {
		this.bankreversalresponsetime = bankreversalresponsetime;
	}

	@Column(name = "BANKREVERSALRESPONSECODE", precision = 10, scale = 0)
	public Integer getBankreversalresponsecode() {
		return this.bankreversalresponsecode;
	}

	public void setBankreversalresponsecode(Integer bankreversalresponsecode) {
		this.bankreversalresponsecode = bankreversalresponsecode;
	}

	@Column(name = "BANKREVERSALREJECTREASON", length = 1020)
	public String getBankreversalrejectreason() {
		return this.bankreversalrejectreason;
	}

	public void setBankreversalrejectreason(String bankreversalrejectreason) {
		this.bankreversalrejectreason = bankreversalrejectreason;
	}

	@Column(name = "BANKREVERSALERRORTEXT", length = 1020)
	public String getBankreversalerrortext() {
		return this.bankreversalerrortext;
	}

	public void setBankreversalerrortext(String bankreversalerrortext) {
		this.bankreversalerrortext = bankreversalerrortext;
	}

	@Column(name = "BANKREVERSALAUTHORIZATIONCODE", length = 1020)
	public String getBankreversalauthorizationcode() {
		return this.bankreversalauthorizationcode;
	}

	public void setBankreversalauthorizationcode(
			String bankreversalauthorizationcode) {
		this.bankreversalauthorizationcode = bankreversalauthorizationcode;
	}

	@Column(name = "REVERSALCOUNT", precision = 10, scale = 0)
	public Integer getReversalcount() {
		return this.reversalcount;
	}

	public void setReversalcount(Integer reversalcount) {
		this.reversalcount = reversalcount;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "LASTREVERSALTIME")
	public Timestamp getLastreversaltime() {
		return this.lastreversaltime;
	}

	public void setLastreversaltime(Timestamp lastreversaltime) {
		this.lastreversaltime = lastreversaltime;
	}

	@Column(name = "CSRACTION", precision = 10, scale = 0)
	public Integer getCsraction() {
		return this.csraction;
	}

	public void setCsraction(Integer csraction) {
		this.csraction = csraction;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "CSRACTIONTIME")
	public Timestamp getCsractiontime() {
		return this.csractiontime;
	}

	public void setCsractiontime(Timestamp csractiontime) {
		this.csractiontime = csractiontime;
	}

	@Column(name = "CSRUSERID", scale = 0)
	public Long getCsruserid() {
		return this.csruserid;
	}

	public void setCsruserid(Long csruserid) {
		this.csruserid = csruserid;
	}

	@Column(name = "CSRUSERNAME", length = 1020)
	public String getCsrusername() {
		return this.csrusername;
	}

	public void setCsrusername(String csrusername) {
		this.csrusername = csrusername;
	}

	@Column(name = "CSRCOMMENT", length = 1020)
	public String getCsrcomment() {
		return this.csrcomment;
	}

	public void setCsrcomment(String csrcomment) {
		this.csrcomment = csrcomment;
	}

	@Column(name = "ISO8583_PROCESSINGCODE", length = 1020)
	public String getIso8583Processingcode() {
		return this.iso8583Processingcode;
	}

	public void setIso8583Processingcode(String iso8583Processingcode) {
		this.iso8583Processingcode = iso8583Processingcode;
	}

	@Column(name = "ISO8583_PRIMARYACCOUNTNUMBER", length = 1020)
	public String getIso8583Primaryaccountnumber() {
		return this.iso8583Primaryaccountnumber;
	}

	public void setIso8583Primaryaccountnumber(
			String iso8583Primaryaccountnumber) {
		this.iso8583Primaryaccountnumber = iso8583Primaryaccountnumber;
	}

	@Column(name = "ISO8583_SYSTEMTRACEAUDITNUMBER", length = 1020)
	public String getIso8583Systemtraceauditnumber() {
		return this.iso8583Systemtraceauditnumber;
	}

	public void setIso8583Systemtraceauditnumber(
			String iso8583Systemtraceauditnumber) {
		this.iso8583Systemtraceauditnumber = iso8583Systemtraceauditnumber;
	}

	@Column(name = "ISO8583_LOCALTXNTIMEHHMMSS", length = 1020)
	public String getIso8583Localtxntimehhmmss() {
		return this.iso8583Localtxntimehhmmss;
	}

	public void setIso8583Localtxntimehhmmss(String iso8583Localtxntimehhmmss) {
		this.iso8583Localtxntimehhmmss = iso8583Localtxntimehhmmss;
	}

	@Column(name = "ISO8583_MERCHANTTYPE", length = 1020)
	public String getIso8583Merchanttype() {
		return this.iso8583Merchanttype;
	}

	public void setIso8583Merchanttype(String iso8583Merchanttype) {
		this.iso8583Merchanttype = iso8583Merchanttype;
	}

	@Column(name = "ISO8583_ACQUIRINGINSTIDCODE", precision = 10, scale = 0)
	public Integer getIso8583Acquiringinstidcode() {
		return this.iso8583Acquiringinstidcode;
	}

	public void setIso8583Acquiringinstidcode(Integer iso8583Acquiringinstidcode) {
		this.iso8583Acquiringinstidcode = iso8583Acquiringinstidcode;
	}

	@Column(name = "ISO8583_RETRIEVALREFERENCENUM", length = 1020)
	public String getIso8583Retrievalreferencenum() {
		return this.iso8583Retrievalreferencenum;
	}

	public void setIso8583Retrievalreferencenum(
			String iso8583Retrievalreferencenum) {
		this.iso8583Retrievalreferencenum = iso8583Retrievalreferencenum;
	}

	@Column(name = "ISO8583_CARDACCEPTORIDCODE", length = 1020)
	public String getIso8583Cardacceptoridcode() {
		return this.iso8583Cardacceptoridcode;
	}

	public void setIso8583Cardacceptoridcode(String iso8583Cardacceptoridcode) {
		this.iso8583Cardacceptoridcode = iso8583Cardacceptoridcode;
	}

	@Column(name = "ISO8583_VARIANT", length = 1020)
	public String getIso8583Variant() {
		return this.iso8583Variant;
	}

	public void setIso8583Variant(String iso8583Variant) {
		this.iso8583Variant = iso8583Variant;
	}

	@Column(name = "ISO8583_RESPONSECODE", length = 1020)
	public String getIso8583Responsecode() {
		return this.iso8583Responsecode;
	}

	public void setIso8583Responsecode(String iso8583Responsecode) {
		this.iso8583Responsecode = iso8583Responsecode;
	}

	@Column(name = "BULKUPLOADID", scale = 0)
	public Long getBulkuploadid() {
		return this.bulkuploadid;
	}

	public void setBulkuploadid(Long bulkuploadid) {
		this.bulkuploadid = bulkuploadid;
	}

	@Column(name = "BULKUPLOADLINENUMBER", precision = 10, scale = 0)
	public Integer getBulkuploadlinenumber() {
		return this.bulkuploadlinenumber;
	}

	public void setBulkuploadlinenumber(Integer bulkuploadlinenumber) {
		this.bulkuploadlinenumber = bulkuploadlinenumber;
	}

	@Column(name = "COPYTOPERMANENTERROR", length = 1020)
	public String getCopytopermanenterror() {
		return this.copytopermanenterror;
	}

	public void setCopytopermanenterror(String copytopermanenterror) {
		this.copytopermanenterror = copytopermanenterror;
	}

	@Column(name = "WEBCLIENTIP", length = 1020)
	public String getWebclientip() {
		return this.webclientip;
	}

	public void setWebclientip(String webclientip) {
		this.webclientip = webclientip;
	}

	@Column(name = "OPERATORRRN", length = 1020)
	public String getOperatorrrn() {
		return this.operatorrrn;
	}

	public void setOperatorrrn(String operatorrrn) {
		this.operatorrrn = operatorrrn;
	}

	@Column(name = "OPERATORSTAN", length = 1020)
	public String getOperatorstan() {
		return this.operatorstan;
	}

	public void setOperatorstan(String operatorstan) {
		this.operatorstan = operatorstan;
	}

	@Column(name = "PRODUCTINDICATORCODE", length = 1020)
	public String getProductindicatorcode() {
		return this.productindicatorcode;
	}

	public void setProductindicatorcode(String productindicatorcode) {
		this.productindicatorcode = productindicatorcode;
	}

	@Column(name = "UNITS", scale = 0)
	public Long getUnits() {
		return this.units;
	}

	public void setUnits(Long units) {
		this.units = units;
	}

	@Column(name = "DENOMINATION", scale = 0)
	public Long getDenomination() {
		return this.denomination;
	}

	public void setDenomination(Long denomination) {
		this.denomination = denomination;
	}

	@Column(name = "TRANSACTIONCHARGEID", scale = 0)
	public Long getTransactionchargeid() {
		return this.transactionchargeid;
	}

	public void setTransactionchargeid(Long transactionchargeid) {
		this.transactionchargeid = transactionchargeid;
	}

	@Column(name = "ISPARTOFSHAREDUPCHAIN", precision = 3, scale = 0)
	public Boolean getIspartofsharedupchain() {
		return this.ispartofsharedupchain;
	}

	public void setIspartofsharedupchain(Boolean ispartofsharedupchain) {
		this.ispartofsharedupchain = ispartofsharedupchain;
	}

	
	@Transient
	public Boolean getIsCreditInMFSLedger() {
		return this.isCreditInMFSLedger;
	}
	
	public void setIsCreditInMFSLedger(Boolean isCreditInMFSLedger) {
		this.isCreditInMFSLedger=isCreditInMFSLedger;
	}
	
	
	@Transient
	public Long getSctlId() {
		return sctlId;
	}

	public void setSctlId(Long sctlId) {
		this.sctlId = sctlId;
	}

	@Transient	
	public String getGeneratedTxnDescription() {
		return generatedTxnDescription;
	}

	public void setGeneratedTxnDescription(String generatedTxnDescription) {
		this.generatedTxnDescription = generatedTxnDescription;
	}
	private Logger log = LoggerFactory.getLogger(getClass());
	@SuppressWarnings("unchecked")
	public void copy(PendingCommodityTransfer pendingCommodityTransfer) {
		copy(pendingCommodityTransfer, null);
	}
	
	 public void copyBackup(PendingCommodityTransfer pendingCommodityTransfer, ClassMetadata classMetadata) {
	        try {
	            Class ctcl = Class.forName("com.mfino.domain.CommodityTransfer");
	            Class pctcl = Class.forName("com.mfino.domain.PendingCommodityTransfer");
	            
	            if(classMetadata == null){
	            	HibernateService hibernateService = CoreServiceFactory.getInstance().getHibernateService();
	            	classMetadata = hibernateService.getSession().getSessionFactory().getClassMetadata(CommodityTransfer.class);
	            }
	            
	            String[] propertyNames = classMetadata.getPropertyNames();
	            String IdPropertyNames = classMetadata.getIdentifierPropertyName();
	            Class c = null;
	            Method method = pctcl.getMethod("get" + IdPropertyNames, c);
	            Method method1 = ctcl.getMethod("set" + IdPropertyNames, method.getReturnType());
	            method1.invoke(this, method.invoke(pendingCommodityTransfer, new Object[0]));
	            for (int i = 0; i < propertyNames.length; i++) {
	                method = pctcl.getMethod("get" + propertyNames[i], c);
	                //System.out.println(propertyNames[i] + "  " + method.invoke(pendingCommodityTransfer, new Object[0]));
	                method1 = ctcl.getMethod("set" + propertyNames[i], method.getReturnType());
	                method1.invoke(this, method.invoke(pendingCommodityTransfer, new Object[0]));
//	                        Method method2 = ctcl.getMethod("get" + propertyNames[i],null);
//	                        System.out.println(propertyNames[i] + "  " + method2.invoke(this, new Object[0]));
	            }

	        } catch (Exception exp) {
	        	log.error("Commodity Transfer Copy backup failed: ", exp);
	        }

	    }
		
	
	 public void copy(PendingCommodityTransfer pendingCommodityTransfer, ClassMetadata classMetadata) {
	        try {
	            Class ctcl = Class.forName("com.mfino.domain.CommodityTransfer");
	            Class pctcl = Class.forName("com.mfino.domain.PendingCommodityTransfer");
	            
	            if(classMetadata == null){
	            	HibernateService hibernateService = CoreServiceFactory.getInstance().getHibernateService();
	            	classMetadata = hibernateService.getSession().getSessionFactory().getClassMetadata(CommodityTransfer.class);
	            }
	            
	            String[] propertyNames = classMetadata.getPropertyNames();
	            //String IdPropertyNames = classMetadata.getIdentifierPropertyName();
	            Class c = null;
	            Method method;
	            Method method1;
	            Character firstChar;
	            
	            /*System.out.println("IdPropertyNames:" + IdPropertyNames);
	            
	            firstChar = IdPropertyNames.charAt(0);
	            Method idMethod = pctcl.getMethod("get" + firstChar.toString().toUpperCase() + IdPropertyNames.substring(1), c);
	            Method idMethod1 = ctcl.getMethod("set" + firstChar.toString().toUpperCase() + IdPropertyNames.substring(1), idMethod.getReturnType());
	            idMethod1.invoke(this, idMethod.invoke(pendingCommodityTransfer, new Object[0]));*/
	            
	            for (int i = 0; i < propertyNames.length; i++) {
	            	
	            	firstChar = propertyNames[i].charAt(0);
	            	
	            	try{
	            		
	            		method = pctcl.getMethod("get" + firstChar.toString().toUpperCase() + propertyNames[i].substring(1));
	            	}
	            	catch(Exception exp){
	            		log.error("caught exception ", exp);
	            		continue;
	            	}
	                //System.out.println(propertyNames[i] + "  " + method.invoke(pendingCommodityTransfer, new Object[0]));
	            	
	            	method1 = ctcl.getMethod("set" + firstChar.toString().toUpperCase() + propertyNames[i].substring(1), method.getReturnType());
	                method1.invoke(this, method.invoke(pendingCommodityTransfer, new Object[0]));
//	                        Method method2 = ctcl.getMethod("get" + propertyNames[i],null);
//	                        System.out.println(propertyNames[i] + "  " + method2.invoke(this, new Object[0]));
	            }

	        } catch (Exception exp) {
	        	log.error("Commodity Transfer Copy failed: ", exp);
	        }

	    }
	 
	 	@Override
	 	public String toString(){
	 		StringBuilder sb=new StringBuilder();
	 		sb.append("id:"+String.valueOf(getId()));
	 		
	 		sb.append(",sctl id:"+getSctlId());
	 		sb.append(", isCreditInMFSLedger:"+getIsCreditInMFSLedger());
	 		sb.append(", commodity:"+getCommodity());
	 		sb.append(", sourcemdn:"+getSourcemdn());
	 		sb.append(", getUicategory():"+getUicategory());
	 		sb.append(", getDestcardpan():"+getDestcardpan());
	 		sb.append(", getDestmdn():"+getDestmdn());
	 		sb.append(", sourcemessage:"+getSourcemessage());
	 		sb.append(", starttime:"+getStarttime());
	 		sb.append(", desc:"+getGeneratedTxnDescription());
	 		sb.append(", pocket:"+((getPocket()!=null)?getPocket().getId():"null"));
	 		sb.append(", amount:"+getAmount());
	 		sb.append(", charges:"+getCharges());
	 		sb.append(", hashcode:"+hashCode());
	 		sb.append(", updateby:"+getUpdatedby());
	 		return sb.toString();
	 	}
}
