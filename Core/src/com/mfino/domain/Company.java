package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Company generated by hbm2java
 */
@Entity
@Table(name = "COMPANY", uniqueConstraints = {
		@UniqueConstraint(columnNames = "COMPANYNAME"),
		@UniqueConstraint(columnNames = "COMPANYCODE") })
public class Company implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private String companyname;
	private long companycode;
	private String customerservicenumber;
	private String smsc;
	private Set<Brand> brands = new HashSet<Brand>(0);
	private Set<BillPaymentTxn> billPaymentTxns = new HashSet<BillPaymentTxn>(0);
	private Set<CreditCardTransaction> creditCardTransactions = new HashSet<CreditCardTransaction>(
			0);
	private Set<Subscriber> subscribers = new HashSet<Subscriber>(0);
	private Set<PendingCommodityTransfer> pendingCommodityTransfers = new HashSet<PendingCommodityTransfer>(
			0);
	private Set<BulkUpload> bulkUploads = new HashSet<BulkUpload>(0);
	private Set<PendingTxnsFile> pendingTxnsFiles = new HashSet<PendingTxnsFile>(
			0);
	private Set<Biller> billers = new HashSet<Biller>(0);
	private Set<OfflineReportCompany> offlineReportCompanies = new HashSet<OfflineReportCompany>(
			0);
	private Set<MfinoUser> mfinoUsers = new HashSet<MfinoUser>(0);
	private Set<MerchantCode> merchantCodes = new HashSet<MerchantCode>(0);
	private Set<ProductIndicator> productIndicators = new HashSet<ProductIndicator>(
			0);
	private Set<Pocket> pockets = new HashSet<Pocket>(0);
	private Set<Region> regions = new HashSet<Region>(0);
	private Set<ActivitiesLog> activitiesLogs = new HashSet<ActivitiesLog>(0);
	private Set<BulkUploadFile> bulkUploadFiles = new HashSet<BulkUploadFile>(0);
	private Set<LetterOfPurchase> letterOfPurchases = new HashSet<LetterOfPurchase>(
			0);
	private Set<BulkLop> bulkLops = new HashSet<BulkLop>(0);
	private Set<CommodityTransfer> commodityTransfers = new HashSet<CommodityTransfer>(
			0);
	private Set<Notification> notifications = new HashSet<Notification>(0);

	public Company() {
	}

	public Company(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String companyname, long companycode) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.companyname = companyname;
		this.companycode = companycode;
	}

	public Company(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String companyname, long companycode, String customerservicenumber,
			String smsc, Set<Brand> brands,
			Set<BillPaymentTxn> billPaymentTxns,
			Set<CreditCardTransaction> creditCardTransactions,
			Set<Subscriber> subscribers,
			Set<PendingCommodityTransfer> pendingCommodityTransfers,
			Set<BulkUpload> bulkUploads, Set<PendingTxnsFile> pendingTxnsFiles,
			Set<Biller> billers,
			Set<OfflineReportCompany> offlineReportCompanies,
			Set<MfinoUser> mfinoUsers, Set<MerchantCode> merchantCodes,
			Set<ProductIndicator> productIndicators, Set<Pocket> pockets,
			Set<Region> regions, Set<ActivitiesLog> activitiesLogs,
			Set<BulkUploadFile> bulkUploadFiles,
			Set<LetterOfPurchase> letterOfPurchases, Set<BulkLop> bulkLops,
			Set<CommodityTransfer> commodityTransfers,
			Set<Notification> notifications) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.companyname = companyname;
		this.companycode = companycode;
		this.customerservicenumber = customerservicenumber;
		this.smsc = smsc;
		this.brands = brands;
		this.billPaymentTxns = billPaymentTxns;
		this.creditCardTransactions = creditCardTransactions;
		this.subscribers = subscribers;
		this.pendingCommodityTransfers = pendingCommodityTransfers;
		this.bulkUploads = bulkUploads;
		this.pendingTxnsFiles = pendingTxnsFiles;
		this.billers = billers;
		this.offlineReportCompanies = offlineReportCompanies;
		this.mfinoUsers = mfinoUsers;
		this.merchantCodes = merchantCodes;
		this.productIndicators = productIndicators;
		this.pockets = pockets;
		this.regions = regions;
		this.activitiesLogs = activitiesLogs;
		this.bulkUploadFiles = bulkUploadFiles;
		this.letterOfPurchases = letterOfPurchases;
		this.bulkLops = bulkLops;
		this.commodityTransfers = commodityTransfers;
		this.notifications = notifications;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	@Version
	@Column(name = "VERSION", nullable = false, precision = 10, scale = 0)
	public long getVersion() {
		return this.version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	@Column(name = "LASTUPDATETIME", nullable = false)
	public Serializable getLastupdatetime() {
		return this.lastupdatetime;
	}

	public void setLastupdatetime(Serializable lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Column(name = "UPDATEDBY", nullable = false, length = 1020)
	public String getUpdatedby() {
		return this.updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	@Column(name = "CREATETIME", nullable = false)
	public Serializable getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Serializable createtime) {
		this.createtime = createtime;
	}

	@Column(name = "CREATEDBY", nullable = false, length = 1020)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "COMPANYNAME", unique = true, nullable = false, length = 1020)
	public String getCompanyname() {
		return this.companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	@Column(name = "COMPANYCODE", unique = true, nullable = false, precision = 10, scale = 0)
	public long getCompanycode() {
		return this.companycode;
	}

	public void setCompanycode(long companycode) {
		this.companycode = companycode;
	}

	@Column(name = "CUSTOMERSERVICENUMBER", length = 1020)
	public String getCustomerservicenumber() {
		return this.customerservicenumber;
	}

	public void setCustomerservicenumber(String customerservicenumber) {
		this.customerservicenumber = customerservicenumber;
	}

	@Column(name = "SMSC", length = 1020)
	public String getSmsc() {
		return this.smsc;
	}

	public void setSmsc(String smsc) {
		this.smsc = smsc;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Brand> getBrands() {
		return this.brands;
	}

	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<BillPaymentTxn> getBillPaymentTxns() {
		return this.billPaymentTxns;
	}

	public void setBillPaymentTxns(Set<BillPaymentTxn> billPaymentTxns) {
		this.billPaymentTxns = billPaymentTxns;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<CreditCardTransaction> getCreditCardTransactions() {
		return this.creditCardTransactions;
	}

	public void setCreditCardTransactions(
			Set<CreditCardTransaction> creditCardTransactions) {
		this.creditCardTransactions = creditCardTransactions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Subscriber> getSubscribers() {
		return this.subscribers;
	}

	public void setSubscribers(Set<Subscriber> subscribers) {
		this.subscribers = subscribers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<PendingCommodityTransfer> getPendingCommodityTransfers() {
		return this.pendingCommodityTransfers;
	}

	public void setPendingCommodityTransfers(
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<BulkUpload> getBulkUploads() {
		return this.bulkUploads;
	}

	public void setBulkUploads(Set<BulkUpload> bulkUploads) {
		this.bulkUploads = bulkUploads;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<PendingTxnsFile> getPendingTxnsFiles() {
		return this.pendingTxnsFiles;
	}

	public void setPendingTxnsFiles(Set<PendingTxnsFile> pendingTxnsFiles) {
		this.pendingTxnsFiles = pendingTxnsFiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Biller> getBillers() {
		return this.billers;
	}

	public void setBillers(Set<Biller> billers) {
		this.billers = billers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<OfflineReportCompany> getOfflineReportCompanies() {
		return this.offlineReportCompanies;
	}

	public void setOfflineReportCompanies(
			Set<OfflineReportCompany> offlineReportCompanies) {
		this.offlineReportCompanies = offlineReportCompanies;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<MfinoUser> getMfinoUsers() {
		return this.mfinoUsers;
	}

	public void setMfinoUsers(Set<MfinoUser> mfinoUsers) {
		this.mfinoUsers = mfinoUsers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<MerchantCode> getMerchantCodes() {
		return this.merchantCodes;
	}

	public void setMerchantCodes(Set<MerchantCode> merchantCodes) {
		this.merchantCodes = merchantCodes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<ProductIndicator> getProductIndicators() {
		return this.productIndicators;
	}

	public void setProductIndicators(Set<ProductIndicator> productIndicators) {
		this.productIndicators = productIndicators;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Pocket> getPockets() {
		return this.pockets;
	}

	public void setPockets(Set<Pocket> pockets) {
		this.pockets = pockets;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Region> getRegions() {
		return this.regions;
	}

	public void setRegions(Set<Region> regions) {
		this.regions = regions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<ActivitiesLog> getActivitiesLogs() {
		return this.activitiesLogs;
	}

	public void setActivitiesLogs(Set<ActivitiesLog> activitiesLogs) {
		this.activitiesLogs = activitiesLogs;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<BulkUploadFile> getBulkUploadFiles() {
		return this.bulkUploadFiles;
	}

	public void setBulkUploadFiles(Set<BulkUploadFile> bulkUploadFiles) {
		this.bulkUploadFiles = bulkUploadFiles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<LetterOfPurchase> getLetterOfPurchases() {
		return this.letterOfPurchases;
	}

	public void setLetterOfPurchases(Set<LetterOfPurchase> letterOfPurchases) {
		this.letterOfPurchases = letterOfPurchases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<BulkLop> getBulkLops() {
		return this.bulkLops;
	}

	public void setBulkLops(Set<BulkLop> bulkLops) {
		this.bulkLops = bulkLops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<CommodityTransfer> getCommodityTransfers() {
		return this.commodityTransfers;
	}

	public void setCommodityTransfers(Set<CommodityTransfer> commodityTransfers) {
		this.commodityTransfers = commodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	public Set<Notification> getNotifications() {
		return this.notifications;
	}

	public void setNotifications(Set<Notification> notifications) {
		this.notifications = notifications;
	}

}
