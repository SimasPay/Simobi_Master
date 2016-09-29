package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
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
 * MfsBiller generated by hbm2java
 */
@Entity
@Table(name = "MFS_BILLER")
public class MfsBiller  extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_MFSBillerName = "mfsbillername";
	public static final String FieldName_MFSBillerCode = "mfsbillercode";
	public static final String FieldName_MFSBillerType = "mfsbillertype";
	private MfinoServiceProvider mfinoServiceProvider;
	private String mfsbillername;
	private String mfsbillercode;
	private String mfsbillertype;
	private Set<MfsbillerPartnerMap> mfsbillerPartnerMaps = new HashSet<MfsbillerPartnerMap>(
			0);
	private Set<IntegrationPartnerMap> integrationPartnerMaps = new HashSet<IntegrationPartnerMap>(
			0);

	public MfsBiller() {
	}

	public MfsBiller(BigDecimal id, MfinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String mfsbillername,
			String mfsbillercode, String mfsbillertype) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mfsbillername = mfsbillername;
		this.mfsbillercode = mfsbillercode;
		this.mfsbillertype = mfsbillertype;
	}

	public MfsBiller(BigDecimal id, MfinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String mfsbillername,
			String mfsbillercode, String mfsbillertype,
			Set<MfsbillerPartnerMap> mfsbillerPartnerMaps,
			Set<IntegrationPartnerMap> integrationPartnerMaps) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.mfsbillername = mfsbillername;
		this.mfsbillercode = mfsbillercode;
		this.mfsbillertype = mfsbillertype;
		this.mfsbillerPartnerMaps = mfsbillerPartnerMaps;
		this.integrationPartnerMaps = integrationPartnerMaps;
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

	
	@Column(name = "MFSBILLERNAME", nullable = false, length = 1020)
	public String getMfsbillername() {
		return this.mfsbillername;
	}

	public void setMfsbillername(String mfsbillername) {
		this.mfsbillername = mfsbillername;
	}

	@Column(name = "MFSBILLERCODE", nullable = false, length = 1020)
	public String getMfsbillercode() {
		return this.mfsbillercode;
	}

	public void setMfsbillercode(String mfsbillercode) {
		this.mfsbillercode = mfsbillercode;
	}

	@Column(name = "MFSBILLERTYPE", nullable = false, length = 1020)
	public String getMfsbillertype() {
		return this.mfsbillertype;
	}

	public void setMfsbillertype(String mfsbillertype) {
		this.mfsbillertype = mfsbillertype;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mfsBiller")
	public Set<MfsbillerPartnerMap> getMfsbillerPartnerMaps() {
		return this.mfsbillerPartnerMaps;
	}

	public void setMfsbillerPartnerMaps(
			Set<MfsbillerPartnerMap> mfsbillerPartnerMaps) {
		this.mfsbillerPartnerMaps = mfsbillerPartnerMaps;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mfsBiller")
	public Set<IntegrationPartnerMap> getIntegrationPartnerMaps() {
		return this.integrationPartnerMaps;
	}

	public void setIntegrationPartnerMaps(
			Set<IntegrationPartnerMap> integrationPartnerMaps) {
		this.integrationPartnerMaps = integrationPartnerMaps;
	}

}
