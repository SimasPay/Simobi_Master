package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

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

import com.mfino.hibernate.Timestamp;

/**
 * MfaTransactionsInfo generated by hbm2java
 */
@Entity
@Table(name = "MFA_TRANSACTIONS_INFO")
public class MFATransactionInfo extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_Service = "service";
	public static final String FieldName_TransactionType = "transactionType";
	public static final String FieldName_ChannelCode = "channelCode";
	public static final String FieldName_MFAMode = "mfamode";
	private ChannelCode channelCode;
	private Service service;
	private TransactionType transactionType;
	private BigDecimal mspid;
	private long mfamode;

	public MFATransactionInfo() {
	}

	public MFATransactionInfo(BigDecimal id, ChannelCode channelCode,
			Service service, TransactionType transactionType,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, BigDecimal mspid,
			long mfamode) {
		this.id = id;
		this.channelCode = channelCode;
		this.service = service;
		this.transactionType = transactionType;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mspid = mspid;
		this.mfamode = mfamode;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHANNELCODEID", nullable = false)
	public ChannelCode getChannelCode() {
		return this.channelCode;
	}

	public void setChannelCode(ChannelCode channelCode) {
		this.channelCode = channelCode;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERVICEID", nullable = false)
	public Service getService() {
		return this.service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTIONTYPEID", nullable = false)
	public TransactionType getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	
	@Column(name = "MSPID", nullable = false, scale = 0)
	public BigDecimal getMspid() {
		return this.mspid;
	}

	public void setMspid(BigDecimal mspid) {
		this.mspid = mspid;
	}

	@Column(name = "MFAMODE", nullable = false, precision = 10, scale = 0)
	public long getMfamode() {
		return this.mfamode;
	}

	public void setMfamode(long mfamode) {
		this.mfamode = mfamode;
	}

}
