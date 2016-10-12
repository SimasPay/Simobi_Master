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
 * BillPaymentTxn generated by hbm2java
 */
@Entity
@Table(name = "BILL_PAYMENT_TXN")
public class BillPaymentTxn  extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public static final String FieldName_TransactionID = "transactionid";
	public static final String FieldName_BillerName = "billername";
	
	private Subscriber subscriber;
	private Company company;
	private BigDecimal parenttransactionid;
	private BigDecimal transactionid;
	private long bankcode;
	private BigDecimal billerid;
	private String billername;
	private String billpaymentreferenceid;
	private BigDecimal amount;
	private String customerid;
	private long billpaymenttransactiontype;
	private BigDecimal transactionfee;
	private Long status;
	private Long notificationcode;
	private String transactiondate;
	private String billercode;

	public BillPaymentTxn() {
	}

	public BillPaymentTxn(BigDecimal id, Subscriber subscriber,
			Company company, Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			BigDecimal parenttransactionid, long bankcode, String customerid,
			long billpaymenttransactiontype) {
		this.id = id;
		this.subscriber = subscriber;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.parenttransactionid = parenttransactionid;
		this.bankcode = bankcode;
		this.customerid = customerid;
		this.billpaymenttransactiontype = billpaymenttransactiontype;
	}

	public BillPaymentTxn(BigDecimal id, Subscriber subscriber,
			Company company, Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			BigDecimal parenttransactionid, BigDecimal transactionid,
			long bankcode, BigDecimal billerid, String billername,
			String billpaymentreferenceid, BigDecimal amount,
			String customerid, long billpaymenttransactiontype,
			BigDecimal transactionfee, Long status, Long notificationcode,
			String transactiondate, String billercode) {
		this.id = id;
		this.subscriber = subscriber;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.parenttransactionid = parenttransactionid;
		this.transactionid = transactionid;
		this.bankcode = bankcode;
		this.billerid = billerid;
		this.billername = billername;
		this.billpaymentreferenceid = billpaymentreferenceid;
		this.amount = amount;
		this.customerid = customerid;
		this.billpaymenttransactiontype = billpaymenttransactiontype;
		this.transactionfee = transactionfee;
		this.status = status;
		this.notificationcode = notificationcode;
		this.transactiondate = transactiondate;
		this.billercode = billercode;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBSCRIBERID", nullable = false)
	public Subscriber getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(Subscriber subscriber) {
		this.subscriber = subscriber;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANYID", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company=company;
	}

	
	@Column(name = "PARENTTRANSACTIONID", nullable = false, scale = 0)
	public BigDecimal getParenttransactionid() {
		return this.parenttransactionid;
	}

	public void setParenttransactionid(BigDecimal parenttransactionid) {
		this.parenttransactionid = parenttransactionid;
	}

	@Column(name = "TRANSACTIONID", scale = 0)
	public BigDecimal getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(BigDecimal transactionid) {
		this.transactionid = transactionid;
	}

	@Column(name = "BANKCODE", nullable = false, precision = 10, scale = 0)
	public long getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(long bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "BILLERID", scale = 0)
	public BigDecimal getBillerid() {
		return this.billerid;
	}

	public void setBillerid(BigDecimal billerid) {
		this.billerid = billerid;
	}

	@Column(name = "BILLERNAME", length = 1020)
	public String getBillername() {
		return this.billername;
	}

	public void setBillername(String billername) {
		this.billername = billername;
	}

	@Column(name = "BILLPAYMENTREFERENCEID", length = 1020)
	public String getBillpaymentreferenceid() {
		return this.billpaymentreferenceid;
	}

	public void setBillpaymentreferenceid(String billpaymentreferenceid) {
		this.billpaymentreferenceid = billpaymentreferenceid;
	}

	@Column(name = "AMOUNT", precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Column(name = "CUSTOMERID", nullable = false, length = 1020)
	public String getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	@Column(name = "BILLPAYMENTTRANSACTIONTYPE", nullable = false, precision = 10, scale = 0)
	public long getBillpaymenttransactiontype() {
		return this.billpaymenttransactiontype;
	}

	public void setBillpaymenttransactiontype(long billpaymenttransactiontype) {
		this.billpaymenttransactiontype = billpaymenttransactiontype;
	}

	@Column(name = "TRANSACTIONFEE", precision = 25, scale = 4)
	public BigDecimal getTransactionfee() {
		return this.transactionfee;
	}

	public void setTransactionfee(BigDecimal transactionfee) {
		this.transactionfee = transactionfee;
	}

	@Column(name = "STATUS", precision = 10, scale = 0)
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Column(name = "NOTIFICATIONCODE", precision = 10, scale = 0)
	public Long getNotificationcode() {
		return this.notificationcode;
	}

	public void setNotificationcode(Long notificationcode) {
		this.notificationcode = notificationcode;
	}

	@Column(name = "TRANSACTIONDATE", length = 1020)
	public String getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(String transactiondate) {
		this.transactiondate = transactiondate;
	}

	@Column(name = "BILLERCODE", length = 1020)
	public String getBillercode() {
		return this.billercode;
	}

	public void setBillercode(String billercode) {
		this.billercode = billercode;
	}

}
