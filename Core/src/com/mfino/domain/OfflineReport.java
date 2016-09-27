package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Clob;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * OfflineReport generated by hbm2java
 */
@Entity
@Table(name = "OFFLINE_REPORT")
public class OfflineReport implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private String name;
	private Clob reportsql;
	private String reportclass;
	private Short triggerenable;
	private Short isdaily;
	private Short ismonthly;
	private Short isonlinereport;
	private Set<OfflineReportReceiver> offlineReportReceivers = new HashSet<OfflineReportReceiver>(
			0);
	private Set<OfflineReportCompany> offlineReportCompanies = new HashSet<OfflineReportCompany>(
			0);

	public OfflineReport() {
	}

	public OfflineReport(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String name) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.name = name;
	}

	public OfflineReport(BigDecimal id, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String name, Clob reportsql, String reportclass,
			Short triggerenable, Short isdaily, Short ismonthly,
			Short isonlinereport,
			Set<OfflineReportReceiver> offlineReportReceivers,
			Set<OfflineReportCompany> offlineReportCompanies) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.name = name;
		this.reportsql = reportsql;
		this.reportclass = reportclass;
		this.triggerenable = triggerenable;
		this.isdaily = isdaily;
		this.ismonthly = ismonthly;
		this.isonlinereport = isonlinereport;
		this.offlineReportReceivers = offlineReportReceivers;
		this.offlineReportCompanies = offlineReportCompanies;
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

	@Column(name = "NAME", nullable = false, length = 1020)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "REPORTSQL")
	public Clob getReportsql() {
		return this.reportsql;
	}

	public void setReportsql(Clob reportsql) {
		this.reportsql = reportsql;
	}

	@Column(name = "REPORTCLASS", length = 1020)
	public String getReportclass() {
		return this.reportclass;
	}

	public void setReportclass(String reportclass) {
		this.reportclass = reportclass;
	}

	@Column(name = "TRIGGERENABLE", precision = 3, scale = 0)
	public Short getTriggerenable() {
		return this.triggerenable;
	}

	public void setTriggerenable(Short triggerenable) {
		this.triggerenable = triggerenable;
	}

	@Column(name = "ISDAILY", precision = 3, scale = 0)
	public Short getIsdaily() {
		return this.isdaily;
	}

	public void setIsdaily(Short isdaily) {
		this.isdaily = isdaily;
	}

	@Column(name = "ISMONTHLY", precision = 3, scale = 0)
	public Short getIsmonthly() {
		return this.ismonthly;
	}

	public void setIsmonthly(Short ismonthly) {
		this.ismonthly = ismonthly;
	}

	@Column(name = "ISONLINEREPORT", precision = 3, scale = 0)
	public Short getIsonlinereport() {
		return this.isonlinereport;
	}

	public void setIsonlinereport(Short isonlinereport) {
		this.isonlinereport = isonlinereport;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offlineReport")
	public Set<OfflineReportReceiver> getOfflineReportReceivers() {
		return this.offlineReportReceivers;
	}

	public void setOfflineReportReceivers(
			Set<OfflineReportReceiver> offlineReportReceivers) {
		this.offlineReportReceivers = offlineReportReceivers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "offlineReport")
	public Set<OfflineReportCompany> getOfflineReportCompanies() {
		return this.offlineReportCompanies;
	}

	public void setOfflineReportCompanies(
			Set<OfflineReportCompany> offlineReportCompanies) {
		this.offlineReportCompanies = offlineReportCompanies;
	}

}
