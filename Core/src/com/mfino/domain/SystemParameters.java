package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * SystemParameters generated by hbm2java
 */
@Entity
@Table(name = "SYSTEM_PARAMETERS")
public class SystemParameters implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private String parametername;
	private String parametervalue;
	private String description;

	public SystemParameters() {
	}

	public SystemParameters(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
	}

	public SystemParameters(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String parametername, String parametervalue, String description) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.parametername = parametername;
		this.parametervalue = parametervalue;
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

	@Column(name = "LASTUPDATETIME", nullable = false)
	public Serializable getLastupdatetime() {
		return this.lastupdatetime;
	}

	public void setLastupdatetime(Serializable lastupdatetime) {
		this.lastupdatetime = lastupdatetime;
	}

	@Column(name = "UPDATEDBY", nullable = false, length = 1020)
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

	@Column(name = "CREATEDBY", nullable = false, length = 1020)
	public String getCreatedby() {
		return this.createdby;
	}

	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	@Column(name = "PARAMETERNAME", length = 1020)
	public String getParametername() {
		return this.parametername;
	}

	public void setParametername(String parametername) {
		this.parametername = parametername;
	}

	@Column(name = "PARAMETERVALUE", length = 1020)
	public String getParametervalue() {
		return this.parametervalue;
	}

	public void setParametervalue(String parametervalue) {
		this.parametervalue = parametervalue;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
