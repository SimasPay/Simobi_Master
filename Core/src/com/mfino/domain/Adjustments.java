package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Adjustments generated by hbm2java
 */
@Entity
@Table(name = "ADJUSTMENTS")
public class Adjustments implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Pocket pocketByDestpocketid;
	private ServiceChargeTxnLog serviceChargeTxnLog;
	private Pocket pocketBySourcepocketid;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private BigDecimal amount;
	private long adjustmentstatus;
	private Serializable approveorrejecttime;
	private String approvedorrejectedby;
	private String approveorrejectcomment;
	private String appliedby;
	private Serializable appliedtime;
	private Long adjustmenttype;
	private String description;

	public Adjustments() {
	}

	public Adjustments(BigDecimal id, Pocket pocketByDestpocketid,
			ServiceChargeTxnLog serviceChargeTxnLog,
			Pocket pocketBySourcepocketid, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal amount, long adjustmentstatus) {
		this.id = id;
		this.pocketByDestpocketid = pocketByDestpocketid;
		this.serviceChargeTxnLog = serviceChargeTxnLog;
		this.pocketBySourcepocketid = pocketBySourcepocketid;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.amount = amount;
		this.adjustmentstatus = adjustmentstatus;
	}

	public Adjustments(BigDecimal id, Pocket pocketByDestpocketid,
			ServiceChargeTxnLog serviceChargeTxnLog,
			Pocket pocketBySourcepocketid, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			BigDecimal amount, long adjustmentstatus,
			Serializable approveorrejecttime, String approvedorrejectedby,
			String approveorrejectcomment, String appliedby,
			Serializable appliedtime, Long adjustmenttype, String description) {
		this.id = id;
		this.pocketByDestpocketid = pocketByDestpocketid;
		this.serviceChargeTxnLog = serviceChargeTxnLog;
		this.pocketBySourcepocketid = pocketBySourcepocketid;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.amount = amount;
		this.adjustmentstatus = adjustmentstatus;
		this.approveorrejecttime = approveorrejecttime;
		this.approvedorrejectedby = approvedorrejectedby;
		this.approveorrejectcomment = approveorrejectcomment;
		this.appliedby = appliedby;
		this.appliedtime = appliedtime;
		this.adjustmenttype = adjustmenttype;
		this.description = description;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DESTPOCKETID", nullable = false)
	public Pocket getPocketByDestpocketid() {
		return this.pocketByDestpocketid;
	}

	public void setPocketByDestpocketid(Pocket pocketByDestpocketid) {
		this.pocketByDestpocketid = pocketByDestpocketid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCTLID", nullable = false)
	public ServiceChargeTxnLog getServiceChargeTxnLog() {
		return this.serviceChargeTxnLog;
	}

	public void setServiceChargeTxnLog(ServiceChargeTxnLog serviceChargeTxnLog) {
		this.serviceChargeTxnLog = serviceChargeTxnLog;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOURCEPOCKETID", nullable = false)
	public Pocket getPocketBySourcepocketid() {
		return this.pocketBySourcepocketid;
	}

	public void setPocketBySourcepocketid(Pocket pocketBySourcepocketid) {
		this.pocketBySourcepocketid = pocketBySourcepocketid;
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

	@Column(name = "AMOUNT", nullable = false, precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "ADJUSTMENTSTATUS", nullable = false, precision = 10, scale = 0)
	public long getAdjustmentstatus() {
		return this.adjustmentstatus;
	}

	public void setAdjustmentstatus(long adjustmentstatus) {
		this.adjustmentstatus = adjustmentstatus;
	}

	@Column(name = "APPROVEORREJECTTIME")
	public Serializable getApproveorrejecttime() {
		return this.approveorrejecttime;
	}

	public void setApproveorrejecttime(Serializable approveorrejecttime) {
		this.approveorrejecttime = approveorrejecttime;
	}

	@Column(name = "APPROVEDORREJECTEDBY", length = 1020)
	public String getApprovedorrejectedby() {
		return this.approvedorrejectedby;
	}

	public void setApprovedorrejectedby(String approvedorrejectedby) {
		this.approvedorrejectedby = approvedorrejectedby;
	}

	@Column(name = "APPROVEORREJECTCOMMENT", length = 1020)
	public String getApproveorrejectcomment() {
		return this.approveorrejectcomment;
	}

	public void setApproveorrejectcomment(String approveorrejectcomment) {
		this.approveorrejectcomment = approveorrejectcomment;
	}

	@Column(name = "APPLIEDBY", length = 1020)
	public String getAppliedby() {
		return this.appliedby;
	}

	public void setAppliedby(String appliedby) {
		this.appliedby = appliedby;
	}

	@Column(name = "APPLIEDTIME")
	public Serializable getAppliedtime() {
		return this.appliedtime;
	}

	public void setAppliedtime(Serializable appliedtime) {
		this.appliedtime = appliedtime;
	}

	@Column(name = "ADJUSTMENTTYPE", precision = 10, scale = 0)
	public Long getAdjustmenttype() {
		return this.adjustmenttype;
	}

	public void setAdjustmenttype(Long adjustmenttype) {
		this.adjustmenttype = adjustmenttype;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
