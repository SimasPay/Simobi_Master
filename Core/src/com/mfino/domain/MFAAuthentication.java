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
 * MfaAuthentication generated by hbm2java
 */
@Entity
@Table(name = "MFA_AUTHENTICATION")
public class MfaAuthentication implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private BigDecimal sctlid;
	private long mfamode;
	private String mfavalue;
	private BigDecimal retryattempt;

	public MfaAuthentication() {
	}

	public MfaAuthentication(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal sctlid, long mfamode, String mfavalue) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.sctlid = sctlid;
		this.mfamode = mfamode;
		this.mfavalue = mfavalue;
	}

	public MfaAuthentication(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal sctlid, long mfamode, String mfavalue,
			BigDecimal retryattempt) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.sctlid = sctlid;
		this.mfamode = mfamode;
		this.mfavalue = mfavalue;
		this.retryattempt = retryattempt;
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

	@Column(name = "SCTLID", nullable = false, scale = 0)
	public BigDecimal getSctlid() {
		return this.sctlid;
	}

	public void setSctlid(BigDecimal sctlid) {
		this.sctlid = sctlid;
	}

	@Column(name = "MFAMODE", nullable = false, precision = 10, scale = 0)
	public long getMfamode() {
		return this.mfamode;
	}

	public void setMfamode(long mfamode) {
		this.mfamode = mfamode;
	}

	@Column(name = "MFAVALUE", nullable = false, length = 1020)
	public String getMfavalue() {
		return this.mfavalue;
	}

	public void setMfavalue(String mfavalue) {
		this.mfavalue = mfavalue;
	}

	@Column(name = "RETRYATTEMPT", precision = 22, scale = 0)
	public BigDecimal getRetryattempt() {
		return this.retryattempt;
	}

	public void setRetryattempt(BigDecimal retryattempt) {
		this.retryattempt = retryattempt;
	}

}
