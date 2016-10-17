package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

import com.mfino.hibernate.Timestamp;

/**
 * Pocket generated by hbm2java
 */
@Entity
@Table(name = "POCKET", uniqueConstraints = @UniqueConstraint(columnNames = "CARDPAN"))
public class Pocket extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FieldName_IsDefault = "isdefault";
	public static final String FieldName_CardPAN = "cardpan";
	public static final String FieldName_CardAlias = "cardalias";
	public static final String FieldName_PocketStatus = "status";
	public static final String FieldName_Company = "company";
	public static final String FieldName_PocketTemplate = "pocketTemplateByPockettemplateid";
	public static final String FieldName_SubscriberMDNByMDNID = "subscriberMdn";
	
	private SubscriberMdn subscriberMdn;
	private PocketTemplate pocketTemplateByPockettemplateid;
	private Company company;
	private PocketTemplate pocketTemplateByOldpockettemplateid;
	private Timestamp lasttransactiontime;
	private String currentbalance;
	private BigDecimal currentdailyexpenditure;
	private BigDecimal currentweeklyexpenditure;
	private BigDecimal currentmonthlyexpenditure;
	private long currentdailytxnscount;
	private long currentweeklytxnscount;
	private long currentmonthlytxnscount;
	private Long lastbankresponsecode;
	private String lastbankauthorizationcode;
	private Long lastbankrequestcode;
	private String cardpan;
	private long restrictions;
	private Short isdefault;
	private long status;
	private Timestamp statustime;
	private Timestamp activationtime;
	private Timestamp pockettemplatechangetime;
	private String pockettemplatechangedby;
	private Long lowbalnotiftype;
	private Timestamp lowbalnotiftriggertime;
	private Long lowbalnotifregistered;
	private Timestamp lowbalnotifquerytime;
	private String cardalias;
	private Set<SettlementTemplate> settlementTemplates = new HashSet<SettlementTemplate>(
			0);
	private Set<MoneyClearanceGraved> moneyClearanceGravedsForPocketid = new HashSet<MoneyClearanceGraved>(
			0);
	private Set<Adjustments> adjustmentsesForDestpocketid = new HashSet<Adjustments>(
			0);
	private Set<BulkUpload> bulkUploads = new HashSet<BulkUpload>(0);
	private Set<ServiceSettlementCfg> serviceSettlementCfgs = new HashSet<ServiceSettlementCfg>(
			0);
	private Set<PartnerServices> partnerServicesesForSourcepocket = new HashSet<PartnerServices>(
			0);
	private Set<TxnAmountDstrbLog> txnAmountDstrbLogs = new HashSet<TxnAmountDstrbLog>(
			0);
	private Set<ChargeDefinition> chargeDefinitions = new HashSet<ChargeDefinition>(
			0);
	private Set<PendingCommodityTransfer> pendingCommodityTransfers = new HashSet<PendingCommodityTransfer>(
			0);
	private Set<CardInfo> cardInfos = new HashSet<CardInfo>(0);
	private Set<Adjustments> adjustmentsesForSourcepocketid = new HashSet<Adjustments>(
			0);
	private Set<MonthlyBalance> monthlyBalances = new HashSet<MonthlyBalance>(0);
	private Set<MoneyClearanceGraved> moneyClearanceGravedsForRefundpocketid = new HashSet<MoneyClearanceGraved>(
			0);
	private Set<CreditCardTransaction> creditCardTransactions = new HashSet<CreditCardTransaction>(
			0);
	private Set<CommodityTransfer> commodityTransfers = new HashSet<CommodityTransfer>(
			0);
	private Set<PartnerServices> partnerServicesesForDestpocketid = new HashSet<PartnerServices>(
			0);

	public Pocket() {
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDNID", nullable = false)
	public SubscriberMdn getSubscriberMdn() {
		return this.subscriberMdn;
	}

	public void setSubscriberMdn(SubscriberMdn subscriberMdn) {
		this.subscriberMdn = subscriberMdn;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POCKETTEMPLATEID", nullable = false)
	public PocketTemplate getPocketTemplateByPockettemplateid() {
		return this.pocketTemplateByPockettemplateid;
	}

	public void setPocketTemplateByPockettemplateid(
			PocketTemplate pocketTemplateByPockettemplateid) {
		this.pocketTemplateByPockettemplateid = pocketTemplateByPockettemplateid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANYID")
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OLDPOCKETTEMPLATEID")
	public PocketTemplate getPocketTemplateByOldpockettemplateid() {
		return this.pocketTemplateByOldpockettemplateid;
	}

	public void setPocketTemplateByOldpockettemplateid(
			PocketTemplate pocketTemplateByOldpockettemplateid) {
		this.pocketTemplateByOldpockettemplateid = pocketTemplateByOldpockettemplateid;
	}

	
	@Type(type = "userDefinedTimeStamp")
	@Column(name = "LASTTRANSACTIONTIME")
	public Timestamp getLasttransactiontime() {
		return this.lasttransactiontime;
	}

	public void setLasttransactiontime(Timestamp lasttransactiontime) {
		this.lasttransactiontime = lasttransactiontime;
	}

	@Type(type = "uniqueencryptedString")
	@Column(name = "CURRENTBALANCE", length = 1020)
	public String getCurrentbalance() {
		return this.currentbalance;
	}

	public void setCurrentbalance(String currentbalance) {
		this.currentbalance = currentbalance;
	}

	@Column(name = "CURRENTDAILYEXPENDITURE", nullable = false, precision = 25, scale = 4)
	public BigDecimal getCurrentdailyexpenditure() {
		return this.currentdailyexpenditure;
	}

	public void setCurrentdailyexpenditure(BigDecimal currentdailyexpenditure) {
		this.currentdailyexpenditure = currentdailyexpenditure;
	}

	@Column(name = "CURRENTWEEKLYEXPENDITURE", nullable = false, precision = 25, scale = 4)
	public BigDecimal getCurrentweeklyexpenditure() {
		return this.currentweeklyexpenditure;
	}

	public void setCurrentweeklyexpenditure(BigDecimal currentweeklyexpenditure) {
		this.currentweeklyexpenditure = currentweeklyexpenditure;
	}

	@Column(name = "CURRENTMONTHLYEXPENDITURE", nullable = false, precision = 25, scale = 4)
	public BigDecimal getCurrentmonthlyexpenditure() {
		return this.currentmonthlyexpenditure;
	}

	public void setCurrentmonthlyexpenditure(
			BigDecimal currentmonthlyexpenditure) {
		this.currentmonthlyexpenditure = currentmonthlyexpenditure;
	}

	@Column(name = "CURRENTDAILYTXNSCOUNT", nullable = false, precision = 10, scale = 0)
	public long getCurrentdailytxnscount() {
		return this.currentdailytxnscount;
	}

	public void setCurrentdailytxnscount(long currentdailytxnscount) {
		this.currentdailytxnscount = currentdailytxnscount;
	}

	@Column(name = "CURRENTWEEKLYTXNSCOUNT", nullable = false, precision = 10, scale = 0)
	public long getCurrentweeklytxnscount() {
		return this.currentweeklytxnscount;
	}

	public void setCurrentweeklytxnscount(long currentweeklytxnscount) {
		this.currentweeklytxnscount = currentweeklytxnscount;
	}

	@Column(name = "CURRENTMONTHLYTXNSCOUNT", nullable = false, precision = 10, scale = 0)
	public long getCurrentmonthlytxnscount() {
		return this.currentmonthlytxnscount;
	}

	public void setCurrentmonthlytxnscount(long currentmonthlytxnscount) {
		this.currentmonthlytxnscount = currentmonthlytxnscount;
	}

	@Column(name = "LASTBANKRESPONSECODE", precision = 10, scale = 0)
	public Long getLastbankresponsecode() {
		return this.lastbankresponsecode;
	}

	public void setLastbankresponsecode(Long lastbankresponsecode) {
		this.lastbankresponsecode = lastbankresponsecode;
	}

	@Column(name = "LASTBANKAUTHORIZATIONCODE", length = 1020)
	public String getLastbankauthorizationcode() {
		return this.lastbankauthorizationcode;
	}

	public void setLastbankauthorizationcode(String lastbankauthorizationcode) {
		this.lastbankauthorizationcode = lastbankauthorizationcode;
	}

	@Column(name = "LASTBANKREQUESTCODE", precision = 10, scale = 0)
	public Long getLastbankrequestcode() {
		return this.lastbankrequestcode;
	}

	public void setLastbankrequestcode(Long lastbankrequestcode) {
		this.lastbankrequestcode = lastbankrequestcode;
	}
 
	@Type(type = "uniqueencryptedString")
	@Column(name = "CARDPAN", unique = true, length = 1020)
	public String getCardpan() {
		return this.cardpan;
	}

	public void setCardpan(String cardpan) {
		this.cardpan = cardpan;
	}

	@Column(name = "RESTRICTIONS", nullable = false, precision = 10, scale = 0)
	public long getRestrictions() {
		return this.restrictions;
	}

	public void setRestrictions(long restrictions) {
		this.restrictions = restrictions;
	}

	@Column(name = "ISDEFAULT", precision = 3, scale = 0)
	public Short getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(Short isdefault) {
		this.isdefault = isdefault;
	}

	@Column(name = "STATUS", nullable = false, precision = 10, scale = 0)
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "STATUSTIME", nullable = false)
	public Timestamp getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "ACTIVATIONTIME")
	public Timestamp getActivationtime() {
		return this.activationtime;
	}

	public void setActivationtime(Timestamp activationtime) {
		this.activationtime = activationtime;
	}
	
	@Type(type = "userDefinedTimeStamp")
	@Column(name = "POCKETTEMPLATECHANGETIME")
	public Timestamp getPockettemplatechangetime() {
		return this.pockettemplatechangetime;
	}

	public void setPockettemplatechangetime(
			Timestamp pockettemplatechangetime) {
		this.pockettemplatechangetime = pockettemplatechangetime;
	}

	@Column(name = "POCKETTEMPLATECHANGEDBY", length = 1020)
	public String getPockettemplatechangedby() {
		return this.pockettemplatechangedby;
	}

	public void setPockettemplatechangedby(String pockettemplatechangedby) {
		this.pockettemplatechangedby = pockettemplatechangedby;
	}

	@Column(name = "LOWBALNOTIFTYPE", precision = 10, scale = 0)
	public Long getLowbalnotiftype() {
		return this.lowbalnotiftype;
	}

	public void setLowbalnotiftype(Long lowbalnotiftype) {
		this.lowbalnotiftype = lowbalnotiftype;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "LOWBALNOTIFTRIGGERTIME")
	public Timestamp getLowbalnotiftriggertime() {
		return this.lowbalnotiftriggertime;
	}

	public void setLowbalnotiftriggertime(Timestamp lowbalnotiftriggertime) {
		this.lowbalnotiftriggertime = lowbalnotiftriggertime;
	}

	@Column(name = "LOWBALNOTIFREGISTERED", precision = 10, scale = 0)
	public Long getLowbalnotifregistered() {
		return this.lowbalnotifregistered;
	}

	public void setLowbalnotifregistered(Long lowbalnotifregistered) {
		this.lowbalnotifregistered = lowbalnotifregistered;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "LOWBALNOTIFQUERYTIME")
	public Timestamp getLowbalnotifquerytime() {
		return this.lowbalnotifquerytime;
	}

	public void setLowbalnotifquerytime(Timestamp lowbalnotifquerytime) {
		this.lowbalnotifquerytime = lowbalnotifquerytime;
	}

	@Column(name = "CARDALIAS")
	public String getCardalias() {
		return this.cardalias;
	}

	public void setCardalias(String cardalias) {
		this.cardalias = cardalias;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<SettlementTemplate> getSettlementTemplates() {
		return this.settlementTemplates;
	}

	public void setSettlementTemplates(
			Set<SettlementTemplate> settlementTemplates) {
		this.settlementTemplates = settlementTemplates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketByPocketid")
	public Set<MoneyClearanceGraved> getMoneyClearanceGravedsForPocketid() {
		return this.moneyClearanceGravedsForPocketid;
	}

	public void setMoneyClearanceGravedsForPocketid(
			Set<MoneyClearanceGraved> moneyClearanceGravedsForPocketid) {
		this.moneyClearanceGravedsForPocketid = moneyClearanceGravedsForPocketid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketByDestpocketid")
	public Set<Adjustments> getAdjustmentsesForDestpocketid() {
		return this.adjustmentsesForDestpocketid;
	}

	public void setAdjustmentsesForDestpocketid(
			Set<Adjustments> adjustmentsesForDestpocketid) {
		this.adjustmentsesForDestpocketid = adjustmentsesForDestpocketid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<BulkUpload> getBulkUploads() {
		return this.bulkUploads;
	}

	public void setBulkUploads(Set<BulkUpload> bulkUploads) {
		this.bulkUploads = bulkUploads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<ServiceSettlementCfg> getServiceSettlementCfgs() {
		return this.serviceSettlementCfgs;
	}

	public void setServiceSettlementCfgs(
			Set<ServiceSettlementCfg> serviceSettlementCfgs) {
		this.serviceSettlementCfgs = serviceSettlementCfgs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketBySourcepocket")
	public Set<PartnerServices> getPartnerServicesesForSourcepocket() {
		return this.partnerServicesesForSourcepocket;
	}

	public void setPartnerServicesesForSourcepocket(
			Set<PartnerServices> partnerServicesesForSourcepocket) {
		this.partnerServicesesForSourcepocket = partnerServicesesForSourcepocket;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<TxnAmountDstrbLog> getTxnAmountDstrbLogs() {
		return this.txnAmountDstrbLogs;
	}

	public void setTxnAmountDstrbLogs(Set<TxnAmountDstrbLog> txnAmountDstrbLogs) {
		this.txnAmountDstrbLogs = txnAmountDstrbLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<ChargeDefinition> getChargeDefinitions() {
		return this.chargeDefinitions;
	}

	public void setChargeDefinitions(Set<ChargeDefinition> chargeDefinitions) {
		this.chargeDefinitions = chargeDefinitions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<PendingCommodityTransfer> getPendingCommodityTransfers() {
		return this.pendingCommodityTransfers;
	}

	public void setPendingCommodityTransfers(
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<CardInfo> getCardInfos() {
		return this.cardInfos;
	}

	public void setCardInfos(Set<CardInfo> cardInfos) {
		this.cardInfos = cardInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketBySourcepocketid")
	public Set<Adjustments> getAdjustmentsesForSourcepocketid() {
		return this.adjustmentsesForSourcepocketid;
	}

	public void setAdjustmentsesForSourcepocketid(
			Set<Adjustments> adjustmentsesForSourcepocketid) {
		this.adjustmentsesForSourcepocketid = adjustmentsesForSourcepocketid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<MonthlyBalance> getMonthlyBalances() {
		return this.monthlyBalances;
	}

	public void setMonthlyBalances(Set<MonthlyBalance> monthlyBalances) {
		this.monthlyBalances = monthlyBalances;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketByRefundpocketid")
	public Set<MoneyClearanceGraved> getMoneyClearanceGravedsForRefundpocketid() {
		return this.moneyClearanceGravedsForRefundpocketid;
	}

	public void setMoneyClearanceGravedsForRefundpocketid(
			Set<MoneyClearanceGraved> moneyClearanceGravedsForRefundpocketid) {
		this.moneyClearanceGravedsForRefundpocketid = moneyClearanceGravedsForRefundpocketid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<CreditCardTransaction> getCreditCardTransactions() {
		return this.creditCardTransactions;
	}

	public void setCreditCardTransactions(
			Set<CreditCardTransaction> creditCardTransactions) {
		this.creditCardTransactions = creditCardTransactions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocket")
	public Set<CommodityTransfer> getCommodityTransfers() {
		return this.commodityTransfers;
	}

	public void setCommodityTransfers(Set<CommodityTransfer> commodityTransfers) {
		this.commodityTransfers = commodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketByDestpocketid")
	public Set<PartnerServices> getPartnerServicesesForDestpocketid() {
		return this.partnerServicesesForDestpocketid;
	}

	public void setPartnerServicesesForDestpocketid(
			Set<PartnerServices> partnerServicesesForDestpocketid) {
		this.partnerServicesesForDestpocketid = partnerServicesesForDestpocketid;
	}

}
