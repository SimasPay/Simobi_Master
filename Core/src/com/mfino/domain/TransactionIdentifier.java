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
 * TransactionIdentifier generated by hbm2java
 */
@Entity
@Table(name = "TRANSACTION_IDENTIFIER")
public class TransactionIdentifier implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private String transactionidentifier;
	private BigDecimal servicechargetransactionlogid;

	public TransactionIdentifier() {
	}

	public TransactionIdentifier(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String transactionidentifier) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.transactionidentifier = transactionidentifier;
	}

	public TransactionIdentifier(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String transactionidentifier,
			BigDecimal servicechargetransactionlogid) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.transactionidentifier = transactionidentifier;
		this.servicechargetransactionlogid = servicechargetransactionlogid;
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

	@Column(name = "TRANSACTIONIDENTIFIER", nullable = false)
	public String getTransactionidentifier() {
		return this.transactionidentifier;
	}

	public void setTransactionidentifier(String transactionidentifier) {
		this.transactionidentifier = transactionidentifier;
	}

	@Column(name = "SERVICECHARGETRANSACTIONLOGID", scale = 0)
	public BigDecimal getServicechargetransactionlogid() {
		return this.servicechargetransactionlogid;
	}

	public void setServicechargetransactionlogid(
			BigDecimal servicechargetransactionlogid) {
		this.servicechargetransactionlogid = servicechargetransactionlogid;
	}

}
