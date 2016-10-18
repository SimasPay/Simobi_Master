package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.sql.Clob;

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
 * SmsTransactionLog generated by hbm2java
 */
@Entity
@Table(name = "SMS_TRANSACTION_LOG")
public class SmsTransactionLog extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_SmscID = "smscid";
	public static final String FieldName_FieldID = "fieldid";
	public static final String FieldName_Source = "source";
	public static final String FieldName_DestMDN = "destmdn";
	
	private SmsPartner smsPartner;
	private String fieldid;
	private Timestamp transactiontime;
	private String source;
	private String destmdn;
	private String smscid;
	private String transactionstatus;
	private String deliverystatus;
	private Clob messagedata;
	private Long messagecode;

	private Long id;
	
	public SmsTransactionLog() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "sms_transaction_log_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTNERID", nullable = false)
	public SmsPartner getSmsPartner() {
		return this.smsPartner;
	}

	public void setSmsPartner(SmsPartner smsPartner) {
		this.smsPartner = smsPartner;
	}

	
	@Column(name = "FIELDID", length = 1020)
	public String getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "TRANSACTIONTIME", nullable = false)
	public Timestamp getTransactiontime() {
		return this.transactiontime;
	}

	public void setTransactiontime(Timestamp transactiontime) {
		this.transactiontime = transactiontime;
	}

	@Column(name = "SOURCE", nullable = false, length = 1020)
	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Column(name = "DESTMDN", nullable = false, length = 1020)
	public String getDestmdn() {
		return this.destmdn;
	}

	public void setDestmdn(String destmdn) {
		this.destmdn = destmdn;
	}

	@Column(name = "SMSCID", nullable = false, length = 1020)
	public String getSmscid() {
		return this.smscid;
	}

	public void setSmscid(String smscid) {
		this.smscid = smscid;
	}

	@Column(name = "TRANSACTIONSTATUS", length = 1020)
	public String getTransactionstatus() {
		return this.transactionstatus;
	}

	public void setTransactionstatus(String transactionstatus) {
		this.transactionstatus = transactionstatus;
	}

	@Column(name = "DELIVERYSTATUS", length = 1020)
	public String getDeliverystatus() {
		return this.deliverystatus;
	}

	public void setDeliverystatus(String deliverystatus) {
		this.deliverystatus = deliverystatus;
	}

	@Column(name = "MESSAGEDATA", nullable = false)
	public Clob getMessagedata() {
		return this.messagedata;
	}

	public void setMessagedata(Clob messagedata) {
		this.messagedata = messagedata;
	}

	@Column(name = "MESSAGECODE", precision = 10, scale = 0)
	public Long getMessagecode() {
		return this.messagecode;
	}

	public void setMessagecode(Long messagecode) {
		this.messagecode = messagecode;
	}

}
