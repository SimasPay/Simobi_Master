package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.sql.Clob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.mfino.hibernate.Timestamp;

/**
 * Notification generated by hbm2java
 */
@Entity
@Table(name = "NOTIFICATION", uniqueConstraints = @UniqueConstraint(columnNames = {
		"MSPID", "CODE", "NOTIFICATIONMETHOD", "LANGUAGE", "COMPANYID" }))
public class Notification extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FieldName_Language = "language";
	public static final String FieldName_NotificationCode = "code";
	public static final String FieldName_NotificationMethod = "notificationmethod";
	public static final String FieldName_NotificationText = "text";
	public static final String FieldName_NotificationCodeName = "codename";
	public static final String FieldName_Company = "company";
	
	private BigDecimal id;
	private long version;
	private MfinoServiceProvider mfinoServiceProvider;
	private Company company;
	private long code;
	private String codename;
	private long notificationmethod;
	private Clob text;
	private Clob stkml;
	private long language;
	private long status;
	private Timestamp statustime;
	private String accesscode;
	private String smsnotificationcode;
	private Short isactive;

	public Notification() {
	}

	public Notification(BigDecimal id,
			MfinoServiceProvider mfinoServiceProvider, Company company,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, long code,
			String codename, long notificationmethod, Clob text, long language,
			long status, Timestamp statustime) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.code = code;
		this.codename = codename;
		this.notificationmethod = notificationmethod;
		this.text = text;
		this.language = language;
		this.status = status;
		this.statustime = statustime;
	}

	public Notification(BigDecimal id,
			MfinoServiceProvider mfinoServiceProvider, Company company,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, long code,
			String codename, long notificationmethod, Clob text, Clob stkml,
			long language, long status, Timestamp statustime,
			String accesscode, String smsnotificationcode, Short isactive) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.code = code;
		this.codename = codename;
		this.notificationmethod = notificationmethod;
		this.text = text;
		this.stkml = stkml;
		this.language = language;
		this.status = status;
		this.statustime = statustime;
		this.accesscode = accesscode;
		this.smsnotificationcode = smsnotificationcode;
		this.isactive = isactive;
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
	@JoinColumn(name = "MSPID", nullable = false)
	public MfinoServiceProvider getMfinoServiceProvider() {
		return this.mfinoServiceProvider;
	}

	public void setMfinoServiceProvider(
			MfinoServiceProvider mfinoServiceProvider) {
		this.mfinoServiceProvider = mfinoServiceProvider;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMPANYID", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Column(name = "CODE", nullable = false, precision = 10, scale = 0)
	public long getCode() {
		return this.code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	@Column(name = "CODENAME", nullable = false, length = 1020)
	public String getCodename() {
		return this.codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	@Column(name = "NOTIFICATIONMETHOD", nullable = false, precision = 10, scale = 0)
	public long getNotificationmethod() {
		return this.notificationmethod;
	}

	public void setNotificationmethod(long notificationmethod) {
		this.notificationmethod = notificationmethod;
	}

	@Column(name = "TEXT", nullable = false)
	public Clob getText() {
		return this.text;
	}

	public void setText(Clob text) {
		this.text = text;
	}

	@Column(name = "STKML")
	public Clob getStkml() {
		return this.stkml;
	}

	public void setStkml(Clob stkml) {
		this.stkml = stkml;
	}

	@Column(name = "LANGUAGE", nullable = false, precision = 10, scale = 0)
	public long getLanguage() {
		return this.language;
	}

	public void setLanguage(long language) {
		this.language = language;
	}

	@Column(name = "STATUS", nullable = false, precision = 10, scale = 0)
	public long getStatus() {
		return this.status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	@Column(name = "STATUSTIME", nullable = false)
	public Timestamp getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}

	@Column(name = "ACCESSCODE", length = 1020)
	public String getAccesscode() {
		return this.accesscode;
	}

	public void setAccesscode(String accesscode) {
		this.accesscode = accesscode;
	}

	@Column(name = "SMSNOTIFICATIONCODE", length = 1020)
	public String getSmsnotificationcode() {
		return this.smsnotificationcode;
	}

	public void setSmsnotificationcode(String smsnotificationcode) {
		this.smsnotificationcode = smsnotificationcode;
	}

	@Column(name = "ISACTIVE", precision = 3, scale = 0)
	public Short getIsactive() {
		return this.isactive;
	}

	public void setIsactive(Short isactive) {
		this.isactive = isactive;
	}

}
