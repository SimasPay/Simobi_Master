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
 * DistributionChainLvl generated by hbm2java
 */
@Entity
@Table(name = "DISTRIBUTION_CHAIN_LVL", uniqueConstraints = @UniqueConstraint(columnNames = {
		"TEMPLATEID", "DISTRIBUTIONLEVEL" }))
public class DistributionChainLevel extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_DistributionChainTemplateByTemplateID = null;
	public static final String FieldName_DistributionLevel = "distributionlevel";
	
	private DistributionChainTemplate distributionChainTemp;
	private long distributionlevel;
	private long permissions;
	private BigDecimal commission;
	private BigDecimal maxcommission;
	private BigDecimal mincommission;
	private BigDecimal maxweeklylopamount;
	private BigDecimal maxlopamount;
	private Long transactiontypeid;
	private Set<CommodityTransfer> commodityTransfers = new HashSet<CommodityTransfer>(
			0);
	private Set<LOP> letterOfPurchases = new HashSet<LOP>(
			0);
	private Set<BulkLOP> bulkLops = new HashSet<BulkLOP>(0);
	private Set<PendingCommodityTransfer> pendingCommodityTransfers = new HashSet<PendingCommodityTransfer>(
			0);

	public DistributionChainLevel() {
	}

	public DistributionChainLevel(BigDecimal id,
			DistributionChainTemplate distributionChainTemp,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, long distributionlevel,
			long permissions) {
		this.id = id;
		this.distributionChainTemp = distributionChainTemp;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.distributionlevel = distributionlevel;
		this.permissions = permissions;
	}

	public DistributionChainLevel(BigDecimal id,
			DistributionChainTemplate distributionChainTemp,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, long distributionlevel,
			long permissions, BigDecimal commission, BigDecimal maxcommission,
			BigDecimal mincommission, BigDecimal maxweeklylopamount,
			BigDecimal maxlopamount, Long transactiontypeid,
			Set<CommodityTransfer> commodityTransfers,
			Set<LOP> letterOfPurchases, Set<BulkLOP> bulkLops,
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.id = id;
		this.distributionChainTemp = distributionChainTemp;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.distributionlevel = distributionlevel;
		this.permissions = permissions;
		this.commission = commission;
		this.maxcommission = maxcommission;
		this.mincommission = mincommission;
		this.maxweeklylopamount = maxweeklylopamount;
		this.maxlopamount = maxlopamount;
		this.transactiontypeid = transactiontypeid;
		this.commodityTransfers = commodityTransfers;
		this.letterOfPurchases = letterOfPurchases;
		this.bulkLops = bulkLops;
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEMPLATEID", nullable = false)
	public DistributionChainTemplate getDistributionChainTemp() {
		return this.distributionChainTemp;
	}

	public void setDistributionChainTemp(
			DistributionChainTemplate distributionChainTemp) {
		this.distributionChainTemp = distributionChainTemp;
	}

	

	@Column(name = "DISTRIBUTIONLEVEL", nullable = false, precision = 10, scale = 0)
	public long getDistributionlevel() {
		return this.distributionlevel;
	}

	public void setDistributionlevel(long distributionlevel) {
		this.distributionlevel = distributionlevel;
	}

	@Column(name = "PERMISSIONS", nullable = false, precision = 10, scale = 0)
	public long getPermissions() {
		return this.permissions;
	}

	public void setPermissions(long permissions) {
		this.permissions = permissions;
	}

	@Column(name = "COMMISSION", precision = 25, scale = 4)
	public BigDecimal getCommission() {
		return this.commission;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	@Column(name = "MAXCOMMISSION", precision = 25, scale = 4)
	public BigDecimal getMaxcommission() {
		return this.maxcommission;
	}

	public void setMaxcommission(BigDecimal maxcommission) {
		this.maxcommission = maxcommission;
	}

	@Column(name = "MINCOMMISSION", precision = 25, scale = 4)
	public BigDecimal getMincommission() {
		return this.mincommission;
	}

	public void setMincommission(BigDecimal mincommission) {
		this.mincommission = mincommission;
	}

	@Column(name = "MAXWEEKLYLOPAMOUNT", precision = 25, scale = 4)
	public BigDecimal getMaxweeklylopamount() {
		return this.maxweeklylopamount;
	}

	public void setMaxweeklylopamount(BigDecimal maxweeklylopamount) {
		this.maxweeklylopamount = maxweeklylopamount;
	}

	@Column(name = "MAXLOPAMOUNT", precision = 25, scale = 4)
	public BigDecimal getMaxlopamount() {
		return this.maxlopamount;
	}

	public void setMaxlopamount(BigDecimal maxlopamount) {
		this.maxlopamount = maxlopamount;
	}

	@Column(name = "TRANSACTIONTYPEID", precision = 10, scale = 0)
	public Long getTransactiontypeid() {
		return this.transactiontypeid;
	}

	public void setTransactiontypeid(Long transactiontypeid) {
		this.transactiontypeid = transactiontypeid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainLvl")
	public Set<CommodityTransfer> getCommodityTransfers() {
		return this.commodityTransfers;
	}

	public void setCommodityTransfers(Set<CommodityTransfer> commodityTransfers) {
		this.commodityTransfers = commodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainLvl")
	public Set<LOP> getLetterOfPurchases() {
		return this.letterOfPurchases;
	}

	public void setLetterOfPurchases(Set<LOP> letterOfPurchases) {
		this.letterOfPurchases = letterOfPurchases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainLvl")
	public Set<BulkLOP> getBulkLops() {
		return this.bulkLops;
	}

	public void setBulkLops(Set<BulkLOP> bulkLops) {
		this.bulkLops = bulkLops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainLvl")
	public Set<PendingCommodityTransfer> getPendingCommodityTransfers() {
		return this.pendingCommodityTransfers;
	}

	public void setPendingCommodityTransfers(
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

}
