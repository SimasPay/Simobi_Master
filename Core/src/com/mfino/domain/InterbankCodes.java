package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import com.mfino.hibernate.Timestamp;

/**
 * InterbankCodes generated by hbm2java
 */
@Entity
@Table(name = "INTERBANK_CODES")
public class InterbankCodes extends Base implements java.io.Serializable {


	private String bankcode;
	private String bankname;
	private short iballowed;

	public InterbankCodes() {
	}

	public InterbankCodes(BigDecimal id, Timestamp lastupdatetime,
			String updatedby, Timestamp createtime, String createdby,
			String bankcode, String bankname, short iballowed) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.bankcode = bankcode;
		this.bankname = bankname;
		this.iballowed = iballowed;
	}

	
	@Column(name = "BANKCODE", nullable = false, length = 1020)
	public String getBankcode() {
		return this.bankcode;
	}

	public void setBankcode(String bankcode) {
		this.bankcode = bankcode;
	}

	@Column(name = "BANKNAME", nullable = false, length = 1020)
	public String getBankname() {
		return this.bankname;
	}

	public void setBankname(String bankname) {
		this.bankname = bankname;
	}

	@Column(name = "IBALLOWED", nullable = false, precision = 3, scale = 0)
	public short getIballowed() {
		return this.iballowed;
	}

	public void setIballowed(short iballowed) {
		this.iballowed = iballowed;
	}

}
