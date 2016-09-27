package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * CashinFirstTime generated by hbm2java
 */
@Entity
@Table(name = "CASHIN_FIRST_TIME")
public class CashinFirstTime implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private BigDecimal mdnid;
	private String mdn;
	private BigDecimal sctlid;
	private BigDecimal transactionamount;

	public CashinFirstTime() {
	}

	public CashinFirstTime(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
	}

	public CashinFirstTime(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal mdnid, String mdn, BigDecimal sctlid,
			BigDecimal transactionamount) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mdnid = mdnid;
		this.mdn = mdn;
		this.sctlid = sctlid;
		this.transactionamount = transactionamount;
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

	@Column(name = "UPDATEDBY", nullable = false)
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

	@Column(name = "CREATEDBY", nullable = false)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "MDNID", scale = 0)
	public BigDecimal getMdnid() {
		return this.mdnid;
	}

	public void setMdnid(BigDecimal mdnid) {
		this.mdnid = mdnid;
	}

	@Column(name = "MDN")
	public String getMdn() {
		return this.mdn;
	}

	public void setMdn(String mdn) {
		this.mdn = mdn;
	}

	@Column(name = "SCTLID", scale = 0)
	public BigDecimal getSctlid() {
		return this.sctlid;
	}

	public void setSctlid(BigDecimal sctlid) {
		this.sctlid = sctlid;
	}

	@Column(name = "TRANSACTIONAMOUNT", precision = 25, scale = 4)
	public BigDecimal getTransactionamount() {
		return this.transactionamount;
	}

	public void setTransactionamount(BigDecimal transactionamount) {
		this.transactionamount = transactionamount;
	}

}
