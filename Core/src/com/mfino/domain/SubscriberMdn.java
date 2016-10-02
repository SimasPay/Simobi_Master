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

import com.mfino.hibernate.Timestamp;

/**
 * SubscriberMdn generated by hbm2java
 */
@Entity
@Table(name = "SUBSCRIBER_MDN", uniqueConstraints = @UniqueConstraint(columnNames = "MDN"))
public class SubscriberMdn extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_MDN = "mdn";
	public static final String FieldName_StatusTime = "statustime";
	public static final String FieldName_MDNStatus = "status";
	public static final String FieldName_IsMDNRecycled = "ismdnrecycled";
	public static final String FieldName_PocketFromMDNID = "pockets";
	public static final String FieldName_IsForceCloseRequested = "isforcecloserequested";
	public static final String FieldName_LastTransactionTime = "lasttransactiontime";
	public static final String FieldName_Subscriber = "subscriber";
	private Subscriber subscriber;
	private String mdn;
	private String imsi;
	private String marketingcategory;
	private String idtype;
	private String idnumber;
	private String authenticationphonenumber;
	private long status;
	private String authenticationphrase;
	private long restrictions;
	private long wrongpincount;
	private String digestedpin;
	private String merchantdigestedpin;
	private String mdnbrand;
	private Timestamp statustime;
	private Timestamp activationtime;
	private Timestamp lasttransactiontime;
	private BigDecimal lasttransactionid;
	private String h2hallowedip;
	private Short ismdnrecycled;
	private String scramblecode;
	private String otp;
	private Timestamp otpexpirationtime;
	private String applicationid;
	private Short isforcecloserequested;
	private String authorizationtoken;
	private String userapikey;
	private String othermdn;
	private Long otpretrycount;
	private BigDecimal cashinfirsttimeid;
	private String isidlifetime;
	private String domaddridentity;
	private String ktpdocumentpath;
	private String subscriberformpath;
	private String supportingdocumentpath;
	private String closecomments;
	private BigDecimal upgradeacctstatus;
	private String upgradeacctapprovedby;
	private Timestamp upgradeaccttime;
	private String upgradeacctcomments;
	private BigDecimal closeagent;
	private String closeuser;
	private String ktpid;
	private Set<MoneyClearanceGraved> moneyClearanceGravedsForRefundmdnid = new HashSet<MoneyClearanceGraved>(
			0);
	private Set<MoneyClearanceGraved> moneyClearanceGravedsForMdnid = new HashSet<MoneyClearanceGraved>(
			0);
	private Set<BulkLOP> bulkLops = new HashSet<BulkLOP>(0);
	private Set<PendingCommodityTransfer> pendingCommodityTransfers = new HashSet<PendingCommodityTransfer>(
			0);
	private Set<ClosedAccountSettlementMDN> closeAcctSetlMdns = new HashSet<ClosedAccountSettlementMDN>(
			0);
	private Set<Pocket> pockets = new HashSet<Pocket>(0);
	private Set<CommodityTransfer> commodityTransfers = new HashSet<CommodityTransfer>(
			0);
	private Set<ExcludeSubscriberLifeCycle> excludeSubscriberLcs = new HashSet<ExcludeSubscriberLifeCycle>(
			0);
	private Set<LOP> letterOfPurchases = new HashSet<LOP>(
			0);
	private Set<UnRegisteredTxnInfo> unregisteredTxnInfos = new HashSet<UnRegisteredTxnInfo>(
			0);
	private Set<ChannelSessionManagement> channelSessionMgmts = new HashSet<ChannelSessionManagement>(
			0);

	public SubscriberMdn() {
	}

	public SubscriberMdn(BigDecimal id, Subscriber subscriber,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String mdn, long status,
			long restrictions, long wrongpincount, Timestamp statustime) {
		this.id = id;
		this.subscriber = subscriber;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mdn = mdn;
		this.status = status;
		this.restrictions = restrictions;
		this.wrongpincount = wrongpincount;
		this.statustime = statustime;
	}

	public SubscriberMdn(BigDecimal id, Subscriber subscriber,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String mdn, String imsi,
			String marketingcategory, String idtype, String idnumber,
			String authenticationphonenumber, long status,
			String authenticationphrase, long restrictions, long wrongpincount,
			String digestedpin, String merchantdigestedpin, String mdnbrand,
			Timestamp statustime, Timestamp activationtime,
			Timestamp lasttransactiontime, BigDecimal lasttransactionid,
			String h2hallowedip, Short ismdnrecycled, String scramblecode,
			String otp, Timestamp otpexpirationtime, String applicationid,
			Short isforcecloserequested, String authorizationtoken,
			String userapikey, String othermdn, Long otpretrycount,
			BigDecimal cashinfirsttimeid, String isidlifetime,
			String domaddridentity, String ktpdocumentpath,
			String subscriberformpath, String supportingdocumentpath,
			String closecomments, BigDecimal upgradeacctstatus,
			String upgradeacctapprovedby, Timestamp upgradeaccttime,
			String upgradeacctcomments, BigDecimal closeagent,
			String closeuser, String ktpid,
			Set<MoneyClearanceGraved> moneyClearanceGravedsForRefundmdnid,
			Set<MoneyClearanceGraved> moneyClearanceGravedsForMdnid,
			Set<BulkLOP> bulkLops,
			Set<PendingCommodityTransfer> pendingCommodityTransfers,
			Set<ClosedAccountSettlementMDN> closeAcctSetlMdns, Set<Pocket> pockets,
			Set<CommodityTransfer> commodityTransfers,
			Set<ExcludeSubscriberLifeCycle> excludeSubscriberLcs,
			Set<LOP> letterOfPurchases,
			Set<UnRegisteredTxnInfo> unregisteredTxnInfos,
			Set<ChannelSessionManagement> channelSessionMgmts) {
		this.id = id;
		this.subscriber = subscriber;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mdn = mdn;
		this.imsi = imsi;
		this.marketingcategory = marketingcategory;
		this.idtype = idtype;
		this.idnumber = idnumber;
		this.authenticationphonenumber = authenticationphonenumber;
		this.status = status;
		this.authenticationphrase = authenticationphrase;
		this.restrictions = restrictions;
		this.wrongpincount = wrongpincount;
		this.digestedpin = digestedpin;
		this.merchantdigestedpin = merchantdigestedpin;
		this.mdnbrand = mdnbrand;
		this.statustime = statustime;
		this.activationtime = activationtime;
		this.lasttransactiontime = lasttransactiontime;
		this.lasttransactionid = lasttransactionid;
		this.h2hallowedip = h2hallowedip;
		this.ismdnrecycled = ismdnrecycled;
		this.scramblecode = scramblecode;
		this.otp = otp;
		this.otpexpirationtime = otpexpirationtime;
		this.applicationid = applicationid;
		this.isforcecloserequested = isforcecloserequested;
		this.authorizationtoken = authorizationtoken;
		this.userapikey = userapikey;
		this.othermdn = othermdn;
		this.otpretrycount = otpretrycount;
		this.cashinfirsttimeid = cashinfirsttimeid;
		this.isidlifetime = isidlifetime;
		this.domaddridentity = domaddridentity;
		this.ktpdocumentpath = ktpdocumentpath;
		this.subscriberformpath = subscriberformpath;
		this.supportingdocumentpath = supportingdocumentpath;
		this.closecomments = closecomments;
		this.upgradeacctstatus = upgradeacctstatus;
		this.upgradeacctapprovedby = upgradeacctapprovedby;
		this.upgradeaccttime = upgradeaccttime;
		this.upgradeacctcomments = upgradeacctcomments;
		this.closeagent = closeagent;
		this.closeuser = closeuser;
		this.ktpid = ktpid;
		this.moneyClearanceGravedsForRefundmdnid = moneyClearanceGravedsForRefundmdnid;
		this.moneyClearanceGravedsForMdnid = moneyClearanceGravedsForMdnid;
		this.bulkLops = bulkLops;
		this.pendingCommodityTransfers = pendingCommodityTransfers;
		this.closeAcctSetlMdns = closeAcctSetlMdns;
		this.pockets = pockets;
		this.commodityTransfers = commodityTransfers;
		this.excludeSubscriberLcs = excludeSubscriberLcs;
		this.letterOfPurchases = letterOfPurchases;
		this.unregisteredTxnInfos = unregisteredTxnInfos;
		this.channelSessionMgmts = channelSessionMgmts;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBSCRIBERID", nullable = false)
	public Subscriber getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	
	@Column(name = "MDN", unique = true, nullable = false, length = 1020)
	public String getMdn() {
		return this.mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	@Column(name = "IMSI", length = 1020)
	public String getImsi() {
		return this.imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	@Column(name = "MARKETINGCATEGORY", length = 1020)
	public String getMarketingcategory() {
		return this.marketingcategory;
	}

	public void setMarketingcategory(String marketingcategory) {
		this.marketingcategory = marketingcategory;
	}

	@Column(name = "IDTYPE", length = 1020)
	public String getIdtype() {
		return this.idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	@Column(name = "IDNUMBER", length = 1020)
	public String getIdnumber() {
		return this.idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	@Column(name = "AUTHENTICATIONPHONENUMBER", length = 1020)
	public String getAuthenticationphonenumber() {
		return this.authenticationphonenumber;
	}

	public void setAuthenticationphonenumber(String authenticationphonenumber) {
		this.authenticationphonenumber = authenticationphonenumber;
	}

	@Column(name = "STATUS", nullable = false, precision = 10, scale = 0)
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Column(name = "AUTHENTICATIONPHRASE", length = 1020)
	public String getAuthenticationphrase() {
		return this.authenticationphrase;
	}

	public void setAuthenticationphrase(String authenticationphrase) {
		this.authenticationphrase = authenticationphrase;
	}

	@Column(name = "RESTRICTIONS", nullable = false, precision = 10, scale = 0)
	public long getRestrictions() {
		return this.restrictions;
	}

	public void setRestrictions(long restrictions) {
		this.restrictions = restrictions;
	}

	@Column(name = "WRONGPINCOUNT", nullable = false, precision = 10, scale = 0)
	public long getWrongpincount() {
		return this.wrongpincount;
	}

	public void setWrongpincount(long wrongpincount) {
		this.wrongpincount = wrongpincount;
	}

	@Column(name = "DIGESTEDPIN", length = 1020)
	public String getDigestedpin() {
		return this.digestedpin;
	}

	public void setDigestedpin(String digestedpin) {
		this.digestedpin = digestedpin;
	}

	@Column(name = "MERCHANTDIGESTEDPIN", length = 1020)
	public String getMerchantdigestedpin() {
		return this.merchantdigestedpin;
	}

	public void setMerchantdigestedpin(String merchantdigestedpin) {
		this.merchantdigestedpin = merchantdigestedpin;
	}

	@Column(name = "MDNBRAND", length = 1020)
	public String getMdnbrand() {
		return this.mdnbrand;
	}

	public void setMdnbrand(String mdnbrand) {
		this.mdnbrand = mdnbrand;
	}

	@Column(name = "STATUSTIME", nullable = false)
	public Timestamp getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}

	@Column(name = "ACTIVATIONTIME")
	public Timestamp getActivationtime() {
		return this.activationtime;
	}

	public void setActivationtime(Timestamp activationtime) {
		this.activationtime = activationtime;
	}

	@Column(name = "LASTTRANSACTIONTIME")
	public Timestamp getLasttransactiontime() {
		return this.lasttransactiontime;
	}

	public void setLasttransactiontime(Timestamp lasttransactiontime) {
		this.lasttransactiontime = lasttransactiontime;
	}

	@Column(name = "LASTTRANSACTIONID", scale = 0)
	public BigDecimal getLasttransactionid() {
		return this.lasttransactionid;
	}

	public void setLasttransactionid(BigDecimal lasttransactionid) {
		this.lasttransactionid = lasttransactionid;
	}

	@Column(name = "H2HALLOWEDIP", length = 1020)
	public String getH2hallowedip() {
		return this.h2hallowedip;
	}

	public void setH2hallowedip(String h2hallowedip) {
		this.h2hallowedip = h2hallowedip;
	}

	@Column(name = "ISMDNRECYCLED", precision = 3, scale = 0)
	public Short getIsmdnrecycled() {
		return this.ismdnrecycled;
	}

	public void setIsmdnrecycled(Short ismdnrecycled) {
		this.ismdnrecycled = ismdnrecycled;
	}

	@Column(name = "SCRAMBLECODE", length = 1020)
	public String getScramblecode() {
		return this.scramblecode;
	}

	public void setScramblecode(String scramblecode) {
		this.scramblecode = scramblecode;
	}

	@Column(name = "OTP", length = 1020)
	public String getOtp() {
		return this.otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	@Column(name = "OTPEXPIRATIONTIME")
	public Timestamp getOtpexpirationtime() {
		return this.otpexpirationtime;
	}

	public void setOtpexpirationtime(Timestamp otpexpirationtime) {
		this.otpexpirationtime = otpexpirationtime;
	}

	@Column(name = "APPLICATIONID", length = 1020)
	public String getApplicationid() {
		return this.applicationid;
	}

	public void setApplicationid(String applicationid) {
		this.applicationid = applicationid;
	}

	@Column(name = "ISFORCECLOSEREQUESTED", precision = 3, scale = 0)
	public Short getIsforcecloserequested() {
		return this.isforcecloserequested;
	}

	public void setIsforcecloserequested(Short isforcecloserequested) {
		this.isforcecloserequested = isforcecloserequested;
	}

	@Column(name = "AUTHORIZATIONTOKEN")
	public String getAuthorizationtoken() {
		return this.authorizationtoken;
	}

	public void setAuthorizationtoken(String authorizationtoken) {
		this.authorizationtoken = authorizationtoken;
	}

	@Column(name = "USERAPIKEY")
	public String getUserapikey() {
		return this.userapikey;
	}

	public void setUserapikey(String userapikey) {
		this.userapikey = userapikey;
	}

	@Column(name = "OTHERMDN", length = 1020)
	public String getOthermdn() {
		return this.othermdn;
	}

	public void setOthermdn(String othermdn) {
		this.othermdn = othermdn;
	}

	@Column(name = "OTPRETRYCOUNT", precision = 10, scale = 0)
	public Long getOtpretrycount() {
		return this.otpretrycount;
	}

	public void setOtpretrycount(Long otpretrycount) {
		this.otpretrycount = otpretrycount;
	}

	@Column(name = "CASHINFIRSTTIMEID", scale = 0)
	public BigDecimal getCashinfirsttimeid() {
		return this.cashinfirsttimeid;
	}

	public void setCashinfirsttimeid(BigDecimal cashinfirsttimeid) {
		this.cashinfirsttimeid = cashinfirsttimeid;
	}

	@Column(name = "ISIDLIFETIME", length = 2)
	public String getIsidlifetime() {
		return this.isidlifetime;
	}

	public void setIsidlifetime(String isidlifetime) {
		this.isidlifetime = isidlifetime;
	}

	@Column(name = "DOMADDRIDENTITY", length = 2)
	public String getDomaddridentity() {
		return this.domaddridentity;
	}

	public void setDomaddridentity(String domaddridentity) {
		this.domaddridentity = domaddridentity;
	}

	@Column(name = "KTPDOCUMENTPATH")
	public String getKtpdocumentpath() {
		return this.ktpdocumentpath;
	}

	public void setKtpdocumentpath(String ktpdocumentpath) {
		this.ktpdocumentpath = ktpdocumentpath;
	}

	@Column(name = "SUBSCRIBERFORMPATH")
	public String getSubscriberformpath() {
		return this.subscriberformpath;
	}

	public void setSubscriberformpath(String subscriberformpath) {
		this.subscriberformpath = subscriberformpath;
	}

	@Column(name = "SUPPORTINGDOCUMENTPATH")
	public String getSupportingdocumentpath() {
		return this.supportingdocumentpath;
	}

	public void setSupportingdocumentpath(String supportingdocumentpath) {
		this.supportingdocumentpath = supportingdocumentpath;
	}

	@Column(name = "CLOSECOMMENTS", length = 512)
	public String getClosecomments() {
		return this.closecomments;
	}

	public void setClosecomments(String closecomments) {
		this.closecomments = closecomments;
	}

	@Column(name = "UPGRADEACCTSTATUS", precision = 22, scale = 0)
	public BigDecimal getUpgradeacctstatus() {
		return this.upgradeacctstatus;
	}

	public void setUpgradeacctstatus(BigDecimal upgradeacctstatus) {
		this.upgradeacctstatus = upgradeacctstatus;
	}

	@Column(name = "UPGRADEACCTAPPROVEDBY")
	public String getUpgradeacctapprovedby() {
		return this.upgradeacctapprovedby;
	}

	public void setUpgradeacctapprovedby(String upgradeacctapprovedby) {
		this.upgradeacctapprovedby = upgradeacctapprovedby;
	}

	@Column(name = "UPGRADEACCTTIME")
	public Timestamp getUpgradeaccttime() {
		return this.upgradeaccttime;
	}

	public void setUpgradeaccttime(Timestamp upgradeaccttime) {
		this.upgradeaccttime = upgradeaccttime;
	}

	@Column(name = "UPGRADEACCTCOMMENTS")
	public String getUpgradeacctcomments() {
		return this.upgradeacctcomments;
	}

	public void setUpgradeacctcomments(String upgradeacctcomments) {
		this.upgradeacctcomments = upgradeacctcomments;
	}

	@Column(name = "CLOSEAGENT", scale = 0)
	public BigDecimal getCloseagent() {
		return this.closeagent;
	}

	public void setCloseagent(BigDecimal closeagent) {
		this.closeagent = closeagent;
	}

	@Column(name = "CLOSEUSER")
	public String getCloseuser() {
		return this.closeuser;
	}

	public void setCloseuser(String closeuser) {
		this.closeuser = closeuser;
	}

	@Column(name = "KTPID", length = 50)
	public String getKtpid() {
		return this.ktpid;
	}

	public void setKtpid(String ktpid) {
		this.ktpid = ktpid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdnByRefundmdnid")
	public Set<MoneyClearanceGraved> getMoneyClearanceGravedsForRefundmdnid() {
		return this.moneyClearanceGravedsForRefundmdnid;
	}

	public void setMoneyClearanceGravedsForRefundmdnid(
			Set<MoneyClearanceGraved> moneyClearanceGravedsForRefundmdnid) {
		this.moneyClearanceGravedsForRefundmdnid = moneyClearanceGravedsForRefundmdnid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdnByMdnid")
	public Set<MoneyClearanceGraved> getMoneyClearanceGravedsForMdnid() {
		return this.moneyClearanceGravedsForMdnid;
	}

	public void setMoneyClearanceGravedsForMdnid(
			Set<MoneyClearanceGraved> moneyClearanceGravedsForMdnid) {
		this.moneyClearanceGravedsForMdnid = moneyClearanceGravedsForMdnid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<BulkLOP> getBulkLops() {
		return this.bulkLops;
	}

	public void setBulkLops(Set<BulkLOP> bulkLops) {
		this.bulkLops = bulkLops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<PendingCommodityTransfer> getPendingCommodityTransfers() {
		return this.pendingCommodityTransfers;
	}

	public void setPendingCommodityTransfers(
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<ClosedAccountSettlementMDN> getCloseAcctSetlMdns() {
		return this.closeAcctSetlMdns;
	}

	public void setCloseAcctSetlMdns(Set<ClosedAccountSettlementMDN> closeAcctSetlMdns) {
		this.closeAcctSetlMdns = closeAcctSetlMdns;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<Pocket> getPockets() {
		return this.pockets;
	}

	public void setPockets(Set<Pocket> pockets) {
		this.pockets = pockets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<CommodityTransfer> getCommodityTransfers() {
		return this.commodityTransfers;
	}

	public void setCommodityTransfers(Set<CommodityTransfer> commodityTransfers) {
		this.commodityTransfers = commodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<ExcludeSubscriberLifeCycle> getExcludeSubscriberLcs() {
		return this.excludeSubscriberLcs;
	}

	public void setExcludeSubscriberLcs(
			Set<ExcludeSubscriberLifeCycle> excludeSubscriberLcs) {
		this.excludeSubscriberLcs = excludeSubscriberLcs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<LOP> getLetterOfPurchases() {
		return this.letterOfPurchases;
	}

	public void setLetterOfPurchases(Set<LOP> letterOfPurchases) {
		this.letterOfPurchases = letterOfPurchases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<UnRegisteredTxnInfo> getUnregisteredTxnInfos() {
		return this.unregisteredTxnInfos;
	}

	public void setUnregisteredTxnInfos(
			Set<UnRegisteredTxnInfo> unregisteredTxnInfos) {
		this.unregisteredTxnInfos = unregisteredTxnInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "subscriberMdn")
	public Set<ChannelSessionManagement> getChannelSessionMgmts() {
		return this.channelSessionMgmts;
	}

	public void setChannelSessionMgmts(
			Set<ChannelSessionManagement> channelSessionMgmts) {
		this.channelSessionMgmts = channelSessionMgmts;
	}

}
