package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * AgentCommissionFee generated by hbm2java
 */
@Entity
@Table(name = "AGENT_COMMISSION_FEE", uniqueConstraints = @UniqueConstraint(columnNames = {
		"PARTNERID", "MONTH", "YEAR" }))
public class AgentCommissionFee implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private BigDecimal partnerid;
	private String month;
	private long year;
	private BigDecimal customerbalancefee;
	private BigDecimal openaccountfee;

	public AgentCommissionFee() {
	}

	public AgentCommissionFee(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal partnerid, String month, long year,
			BigDecimal customerbalancefee, BigDecimal openaccountfee) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.partnerid = partnerid;
		this.month = month;
		this.year = year;
		this.customerbalancefee = customerbalancefee;
		this.openaccountfee = openaccountfee;
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

	@Column(name = "PARTNERID", nullable = false, scale = 0)
	public BigDecimal getPartnerid() {
		return this.partnerid;
	}

	public void setPartnerid(BigDecimal partnerid) {
		this.partnerid = partnerid;
	}

	@Column(name = "MONTH", nullable = false, length = 20)
	public String getMonth() {
		return this.month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "YEAR", nullable = false, precision = 10, scale = 0)
	public long getYear() {
		return this.year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	@Column(name = "CUSTOMERBALANCEFEE", nullable = false, precision = 25, scale = 4)
	public BigDecimal getCustomerbalancefee() {
		return this.customerbalancefee;
	}

	public void setCustomerbalancefee(BigDecimal customerbalancefee) {
		this.customerbalancefee = customerbalancefee;
	}

	@Column(name = "OPENACCOUNTFEE", nullable = false, precision = 25, scale = 4)
	public BigDecimal getOpenaccountfee() {
		return this.openaccountfee;
	}

	public void setOpenaccountfee(BigDecimal openaccountfee) {
		this.openaccountfee = openaccountfee;
	}

}
