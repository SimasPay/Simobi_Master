package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.mfino.hibernate.Timestamp;

/**
 * CloseAcctSetlMdn generated by hbm2java
 */
@Entity
@Table(name = "CLOSE_ACCT_SETL_MDN")
public class CloseAcctSetlMdn extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FieldName_SubscriberMDNByMDNID = "subscriberMdn";
	public static final String FieldName_SettlementMDN = "settlementmdn";
	public static final String FieldName_SettlementAccountNumber = "settlementaccountnumber";
	
	private SubscriberMdn subscriberMdn;
	private Short tobankaccount;
	private String settlementmdn;
	private String settlementaccountnumber;
	private Long approvalstate;
	private Timestamp approveorrejecttime;
	private String approvedorrejectedby;
	private String approveorrejectcomment;

	public CloseAcctSetlMdn() {
	}

	public CloseAcctSetlMdn(BigDecimal id, SubscriberMdn subscriberMdn,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby) {
		this.id = id;
		this.subscriberMdn = subscriberMdn;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
	}

	public CloseAcctSetlMdn(BigDecimal id, SubscriberMdn subscriberMdn,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, Short tobankaccount,
			String settlementmdn, String settlementaccountnumber,
			Long approvalstate, Timestamp approveorrejecttime,
			String approvedorrejectedby, String approveorrejectcomment) {
		this.id = id;
		this.subscriberMdn = subscriberMdn;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.tobankaccount = tobankaccount;
		this.settlementmdn = settlementmdn;
		this.settlementaccountnumber = settlementaccountnumber;
		this.approvalstate = approvalstate;
		this.approveorrejecttime = approveorrejecttime;
		this.approvedorrejectedby = approvedorrejectedby;
		this.approveorrejectcomment = approveorrejectcomment;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDNID", nullable = false)
	public SubscriberMdn getSubscriberMdn() {
		return this.subscriberMdn;
	}

	public void setSubscriberMdn(SubscriberMdn subscriberMdn) {
		this.subscriberMdn = subscriberMdn;
	}

	

	@Column(name = "TOBANKACCOUNT", precision = 3, scale = 0)
	public Short getTobankaccount() {
		return this.tobankaccount;
	}

	public void setTobankaccount(Short tobankaccount) {
		this.tobankaccount = tobankaccount;
	}

	@Column(name = "SETTLEMENTMDN")
	public String getSettlementmdn() {
		return this.settlementmdn;
	}

	public void setSettlementmdn(String settlementmdn) {
		this.settlementmdn = settlementmdn;
	}

	@Column(name = "SETTLEMENTACCOUNTNUMBER")
	public String getSettlementaccountnumber() {
		return this.settlementaccountnumber;
	}

	public void setSettlementaccountnumber(String settlementaccountnumber) {
		this.settlementaccountnumber = settlementaccountnumber;
	}

	@Column(name = "APPROVALSTATE", precision = 10, scale = 0)
	public Long getApprovalstate() {
		return this.approvalstate;
	}

	public void setApprovalstate(Long approvalstate) {
		this.approvalstate = approvalstate;
	}

	@Column(name = "APPROVEORREJECTTIME")
	public Timestamp getApproveorrejecttime() {
		return this.approveorrejecttime;
	}

	public void setApproveorrejecttime(Timestamp approveorrejecttime) {
		this.approveorrejecttime = approveorrejecttime;
	}

	@Column(name = "APPROVEDORREJECTEDBY")
	public String getApprovedorrejectedby() {
		return this.approvedorrejectedby;
	}

	public void setApprovedorrejectedby(String approvedorrejectedby) {
		this.approvedorrejectedby = approvedorrejectedby;
	}

	@Column(name = "APPROVEORREJECTCOMMENT")
	public String getApproveorrejectcomment() {
		return this.approveorrejectcomment;
	}

	public void setApproveorrejectcomment(String approveorrejectcomment) {
		this.approveorrejectcomment = approveorrejectcomment;
	}

}
