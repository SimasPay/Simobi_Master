package com.mfino.domain;

// Generated Sep 27, 2016 2:09:23 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

/**
 * Region generated by hbm2java
 */
@Entity
@Table(name = "REGION", uniqueConstraints = @UniqueConstraint(columnNames = "REGIONCODE"))
public class Region implements java.io.Serializable {

	private BigDecimal id;
	private long version;
	private Company company;
	private Serializable lastupdatetime;
	private String updatedby;
	private Serializable createtime;
	private String createdby;
	private String regionname;
	private String regioncode;
	private String description;
	private Set<Merchant> merchants = new HashSet<Merchant>(0);

	public Region() {
	}

	public Region(BigDecimal id, Company company, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String regionname, String regioncode) {
		this.id = id;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.regionname = regionname;
		this.regioncode = regioncode;
	}

	public Region(BigDecimal id, Company company, Serializable lastupdatetime,
			String updatedby, Serializable createtime, String createdby,
			String regionname, String regioncode, String description,
			Set<Merchant> merchants) {
		this.id = id;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.regionname = regionname;
		this.regioncode = regioncode;
		this.description = description;
		this.merchants = merchants;
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
	@JoinColumn(name = "COMPANYID", nullable = false)
	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
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

	@Column(name = "REGIONNAME", nullable = false, length = 1020)
	public String getRegionname() {
		return this.regionname;
	}

	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}

	@Column(name = "REGIONCODE", unique = true, nullable = false, length = 1020)
	public String getRegioncode() {
		return this.regioncode;
	}

	public void setRegioncode(String regioncode) {
		this.regioncode = regioncode;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "region")
	public Set<Merchant> getMerchants() {
		return this.merchants;
	}

	public void setMerchants(Set<Merchant> merchants) {
		this.merchants = merchants;
	}

}
