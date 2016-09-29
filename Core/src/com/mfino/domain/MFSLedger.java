package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.mfino.hibernate.Timestamp;

/**
 * MfsLedger generated by hbm2java
 */
@Entity
@Table(name = "MFS_LEDGER")
public class MFSLedger extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FieldName_PocketID = "pocketid";
	public static final String FieldName_CommodityTransferID = "commoditytransferid";
	public static final String FieldName_LedgerStatus = "ledgerstatus";
	public static final String FieldName_SctlId = "sctlid";
	
	private BigDecimal sctlid;
	private BigDecimal commoditytransferid;
	private BigDecimal pocketid;
	private BigDecimal amount;
	private String ledgertype;
	private String ledgerstatus;

	public MFSLedger() {
	}

	public MFSLedger(BigDecimal id, Timestamp lastupdatetime,
			String updatedby, Timestamp createtime, String createdby,
			BigDecimal sctlid, BigDecimal commoditytransferid,
			BigDecimal pocketid, BigDecimal amount, String ledgertype,
			String ledgerstatus) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.sctlid = sctlid;
		this.commoditytransferid = commoditytransferid;
		this.pocketid = pocketid;
		this.amount = amount;
		this.ledgertype = ledgertype;
		this.ledgerstatus = ledgerstatus;
	}

	

	@Column(name = "SCTLID", nullable = false, scale = 0)
	public BigDecimal getSctlid() {
		return this.sctlid;
	}

	public void setSctlid(BigDecimal sctlid) {
		this.sctlid = sctlid;
	}

	@Column(name = "COMMODITYTRANSFERID", nullable = false, scale = 0)
	public BigDecimal getCommoditytransferid() {
		return this.commoditytransferid;
	}

	public void setCommoditytransferid(BigDecimal commoditytransferid) {
		this.commoditytransferid = commoditytransferid;
	}

	@Column(name = "POCKETID", nullable = false, scale = 0)
	public BigDecimal getPocketid() {
		return this.pocketid;
	}

	public void setPocketid(BigDecimal pocketid) {
		this.pocketid = pocketid;
	}

	@Column(name = "AMOUNT", nullable = false, precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "LEDGERTYPE", nullable = false, length = 25)
	public String getLedgertype() {
		return this.ledgertype;
	}

	public void setLedgertype(String ledgertype) {
		this.ledgertype = ledgertype;
	}

	@Column(name = "LEDGERSTATUS", nullable = false, length = 25)
	public String getLedgerstatus() {
		return this.ledgerstatus;
	}

	public void setLedgerstatus(String ledgerstatus) {
		this.ledgerstatus = ledgerstatus;
	}

}
