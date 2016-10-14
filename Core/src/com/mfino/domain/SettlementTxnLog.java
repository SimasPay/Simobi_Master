package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * SettlementTxnLog generated by hbm2java
 */
@Entity
@Table(name = "SETTLEMENT_TXN_LOG")
public class SettlementTxnLog  extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private BigDecimal mspid;
	private BigDecimal partnerservicesid;
	private BigDecimal commoditytransferid;
	private BigDecimal servicesettlementconfigid;
	private Long transferstatus;
	private String response;
	private BigDecimal amount;
	private String description;
	private Set<SctlSettlementMap> sctlSettlementMaps = new HashSet<SctlSettlementMap>(
			0);
	private Set<SettlementTxnSctlMap> settlementTxnSctlMaps = new HashSet<SettlementTxnSctlMap>(
			0);

	public SettlementTxnLog() {
	}

	
	

	@Column(name = "MSPID", nullable = false, scale = 0)
	public BigDecimal getMspid() {
		return this.mspid;
	}

	public void setMspid(BigDecimal mspid) {
		this.mspid = mspid;
	}

	@Column(name = "PARTNERSERVICESID", nullable = false, scale = 0)
	public BigDecimal getPartnerservicesid() {
		return this.partnerservicesid;
	}

	public void setPartnerservicesid(BigDecimal partnerservicesid) {
		this.partnerservicesid = partnerservicesid;
	}

	@Column(name = "COMMODITYTRANSFERID", scale = 0)
	public BigDecimal getCommoditytransferid() {
		return this.commoditytransferid;
	}

	public void setCommoditytransferid(BigDecimal commoditytransferid) {
		this.commoditytransferid = commoditytransferid;
	}

	@Column(name = "SERVICESETTLEMENTCONFIGID", scale = 0)
	public BigDecimal getServicesettlementconfigid() {
		return this.servicesettlementconfigid;
	}

	public void setServicesettlementconfigid(
			BigDecimal servicesettlementconfigid) {
		this.servicesettlementconfigid = servicesettlementconfigid;
	}

	@Column(name = "TRANSFERSTATUS", precision = 10, scale = 0)
	public Long getTransferstatus() {
		return this.transferstatus;
	}

	public void setTransferstatus(Long transferstatus) {
		this.transferstatus = transferstatus;
	}

	@Column(name = "RESPONSE", length = 1020)
	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	@Column(name = "AMOUNT", precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settlementTxnLog")
	public Set<SctlSettlementMap> getSctlSettlementMaps() {
		return this.sctlSettlementMaps;
	}

	public void setSctlSettlementMaps(Set<SctlSettlementMap> sctlSettlementMaps) {
		this.sctlSettlementMaps = sctlSettlementMaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settlementTxnLog")
	public Set<SettlementTxnSctlMap> getSettlementTxnSctlMaps() {
		return this.settlementTxnSctlMaps;
	}

	public void setSettlementTxnSctlMaps(
			Set<SettlementTxnSctlMap> settlementTxnSctlMaps) {
		this.settlementTxnSctlMaps = settlementTxnSctlMaps;
	}

}
