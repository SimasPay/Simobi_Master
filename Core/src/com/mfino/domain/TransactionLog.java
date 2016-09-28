package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.mfino.hibernate.Timestamp;

/**
 * TransactionLog generated by hbm2java
 */
@Entity
@Table(name = "TRANSACTION_LOG")
public class TransactionLog  extends Base implements java.io.Serializable {

	public static final String FieldName_LastUpdateTime = "lastupdatetime";
	private mFinoServiceProvider mfinoServiceProvider;
	private BigDecimal parenttransactionid;
	private Long multixid;
	private Timestamp transactiontime;
	private long messagecode;
	private Clob messagedata;
	private Set<CommodityTransfer> commodityTransfers = new HashSet<CommodityTransfer>(
			0);
	private Set<PendingCommodityTransfer> pendingCommodityTransfers = new HashSet<PendingCommodityTransfer>(
			0);
	private Set<LetterOfPurchase> letterOfPurchases = new HashSet<LetterOfPurchase>(
			0);

	public TransactionLog() {
	}

	public TransactionLog(BigDecimal id,
			mFinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			Timestamp transactiontime, long messagecode, Clob messagedata) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.transactiontime = transactiontime;
		this.messagecode = messagecode;
		this.messagedata = messagedata;
	}

	public TransactionLog(BigDecimal id,
			mFinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			BigDecimal parenttransactionid, Long multixid,
			Timestamp transactiontime, long messagecode, Clob messagedata,
			Set<CommodityTransfer> commodityTransfers,
			Set<PendingCommodityTransfer> pendingCommodityTransfers,
			Set<LetterOfPurchase> letterOfPurchases) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.parenttransactionid = parenttransactionid;
		this.multixid = multixid;
		this.transactiontime = transactiontime;
		this.messagecode = messagecode;
		this.messagedata = messagedata;
		this.commodityTransfers = commodityTransfers;
		this.pendingCommodityTransfers = pendingCommodityTransfers;
		this.letterOfPurchases = letterOfPurchases;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MSPID", nullable = false)
	public mFinoServiceProvider getMfinoServiceProvider() {
		return this.mfinoServiceProvider;
	}

	public void setMfinoServiceProvider(
			mFinoServiceProvider mfinoServiceProvider) {
		this.mfinoServiceProvider = mfinoServiceProvider;
	}


	@Column(name = "PARENTTRANSACTIONID", scale = 0)
	public BigDecimal getParenttransactionid() {
		return this.parenttransactionid;
	}

	public void setParenttransactionid(BigDecimal parenttransactionid) {
		this.parenttransactionid = parenttransactionid;
	}

	@Column(name = "MULTIXID", precision = 10, scale = 0)
	public Long getMultixid() {
		return this.multixid;
	}

	public void setMultixid(Long multixid) {
		this.multixid = multixid;
	}

	@Column(name = "TRANSACTIONTIME", nullable = false)
	public Timestamp getTransactiontime() {
		return this.transactiontime;
	}

	public void setTransactiontime(Timestamp transactiontime) {
		this.transactiontime = transactiontime;
	}

	@Column(name = "MESSAGECODE", nullable = false, precision = 10, scale = 0)
	public long getMessagecode() {
		return this.messagecode;
	}

	public void setMessagecode(long messagecode) {
		this.messagecode = messagecode;
	}

	@Column(name = "MESSAGEDATA", nullable = false)
	public Clob getMessagedata() {
		return this.messagedata;
	}

	public void setMessagedata(Clob messagedata) {
		this.messagedata = messagedata;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionLog")
	public Set<CommodityTransfer> getCommodityTransfers() {
		return this.commodityTransfers;
	}

	public void setCommodityTransfers(Set<CommodityTransfer> commodityTransfers) {
		this.commodityTransfers = commodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionLog")
	public Set<PendingCommodityTransfer> getPendingCommodityTransfers() {
		return this.pendingCommodityTransfers;
	}

	public void setPendingCommodityTransfers(
			Set<PendingCommodityTransfer> pendingCommodityTransfers) {
		this.pendingCommodityTransfers = pendingCommodityTransfers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "transactionLog")
	public Set<LetterOfPurchase> getLetterOfPurchases() {
		return this.letterOfPurchases;
	}

	public void setLetterOfPurchases(Set<LetterOfPurchase> letterOfPurchases) {
		this.letterOfPurchases = letterOfPurchases;
	}

}
