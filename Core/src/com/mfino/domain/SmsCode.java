package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * SmsCode generated by hbm2java
 */
@Entity
@Table(name = "SMS_CODE", uniqueConstraints = @UniqueConstraint(columnNames = "SMSCODETEXT"))
public class SmsCode extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_SMSCodeText = "smscodetext";
	public static final String FieldName_SMSCodeStatus = "smscodestatus";
	private Brand brand;
	private String smscodetext;
	private String servicename;
	private String description;
	private long smscodestatus;
	private String shortcodes;

	public SmsCode() {
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BRANDID", nullable = false)
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	
	@Column(name = "SMSCODETEXT", unique = true, nullable = false, length = 1020)
	public String getSmscodetext() {
		return this.smscodetext;
	}

	public void setSmscodetext(String smscodetext) {
		this.smscodetext = smscodetext;
	}

	@Column(name = "SERVICENAME", nullable = false, length = 1020)
	public String getServicename() {
		return this.servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	@Column(name = "DESCRIPTION", nullable = false, length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SMSCODESTATUS", nullable = false, precision = 10, scale = 0)
	public long getSmscodestatus() {
		return this.smscodestatus;
	}

	public void setSmscodestatus(long smscodestatus) {
		this.smscodestatus = smscodestatus;
	}

	@Column(name = "SHORTCODES", length = 1020)
	public String getShortcodes() {
		return this.shortcodes;
	}

	public void setShortcodes(String shortcodes) {
		this.shortcodes = shortcodes;
	}

}
