package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

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

import com.mfino.hibernate.Timestamp;

/**
 * Brand generated by hbm2java
 */
@Entity
@Table(name = "BRAND", uniqueConstraints = @UniqueConstraint(columnNames = "BRANDNAME"))
public class Brand extends Base  implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FieldName_PrefixCode = "prefixcode";
	public static final String FieldName_BrandName = "brandname";

	public static final String FieldName_Company = "company";
	
	private MfinoServiceProvider mfinoServiceProvider;
	private Company company;
	private String internationalcountrycode;
	private String prefixcode;
	private String brandname;
	private Set<SmsCode> smsCodes = new HashSet<SmsCode>(0);
	private Set<MdnRange> mdnRanges = new HashSet<MdnRange>(0);

	public Brand() {
	}

	public Brand(BigDecimal id, MfinoServiceProvider mfinoServiceProvider,
			Company company, Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			String internationalcountrycode, String prefixcode, String brandname) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.internationalcountrycode = internationalcountrycode;
		this.prefixcode = prefixcode;
		this.brandname = brandname;
	}

	public Brand(BigDecimal id, MfinoServiceProvider mfinoServiceProvider,
			Company company, Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby,
			String internationalcountrycode, String prefixcode,
			String brandname, Set<SmsCode> smsCodes, Set<MdnRange> mdnRanges) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.company = company;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.internationalcountrycode = internationalcountrycode;
		this.prefixcode = prefixcode;
		this.brandname = brandname;
		this.smsCodes = smsCodes;
		this.mdnRanges = mdnRanges;
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

	
	@Column(name = "INTERNATIONALCOUNTRYCODE", nullable = false, length = 1020)
	public String getInternationalcountrycode() {
		return this.internationalcountrycode;
	}

	public void setInternationalcountrycode(String internationalcountrycode) {
		this.internationalcountrycode = internationalcountrycode;
	}

	@Column(name = "PREFIXCODE", nullable = false, length = 1020)
	public String getPrefixcode() {
		return this.prefixcode;
	}

	public void setPrefixcode(String prefixcode) {
		this.prefixcode = prefixcode;
	}

	@Column(name = "BRANDNAME", unique = true, nullable = false, length = 1020)
	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<SmsCode> getSmsCodes() {
		return this.smsCodes;
	}

	public void setSmsCodes(Set<SmsCode> smsCodes) {
		this.smsCodes = smsCodes;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "brand")
	public Set<MdnRange> getMdnRanges() {
		return this.mdnRanges;
	}

	public void setMdnRanges(Set<MdnRange> mdnRanges) {
		this.mdnRanges = mdnRanges;
	}

}
