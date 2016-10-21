package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mfino.hibernate.Timestamp;

/**
 * Adjustments generated by hbm2java
 */
@Entity
@Table(name = "ADJUSTMENTS")
public class Adjustments extends Base implements java.io.Serializable {

	
	public static final String FieldName_ServiceChargeTransactionLogBySctlId = null;
	public static final String FieldName_AdjustmentStatus = "adjustmentstatus";
	
	private Long id;
	private Pocket pocketByDestpocketid;
	private ServiceChargeTxnLog serviceChargeTxnLog;
	private Pocket pocketBySourcepocketid;
	private BigDecimal amount;
	private Integer adjustmentstatus;
	private Timestamp approveorrejecttime;
	private String approvedorrejectedby;
	private String approveorrejectcomment;
	private String appliedby;
	private Timestamp appliedtime;
	private Long adjustmenttype;
	private String description;

	public Adjustments() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "adjustments_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	

	@Column(name = "AMOUNT", nullable = false, precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "ADJUSTMENTSTATUS", nullable = false, precision = 10, scale = 0)
	public Integer getAdjustmentstatus() {
		return this.adjustmentstatus;
	}

	public void setAdjustmentstatus(Integer adjustmentstatus) {
		this.adjustmentstatus = adjustmentstatus;
	}

	@Column(name = "APPROVEORREJECTTIME")
	public Timestamp getApproveorrejecttime() {
		return this.approveorrejecttime;
	}

	public void setApproveorrejecttime(Timestamp approveorrejecttime) {
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
	
	@Type(type = "userDefinedTimeStamp")
	@Column(name = "APPLIEDTIME")
	public Timestamp getAppliedtime() {
		return this.appliedtime;
	}

	public void setAppliedtime(Timestamp appliedtime) {
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
