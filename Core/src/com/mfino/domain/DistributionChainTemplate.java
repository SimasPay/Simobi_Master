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
 * DistributionChainTemp generated by hbm2java
 */
@Entity
@Table(name = "DISTRIBUTION_CHAIN_TEMP")
public class DistributionChainTemplate extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	public static final String FieldName_DistributionChainName = "name";

	public static final String FieldName_ServiceID = "serviceid";

	public static final String FieldName_PartnerServicesFromDistributionChainTemplateID = null;
	
	private MfinoServiceProvider mfinoServiceProvider;
	private String name;
	private String description;
	private long serviceid;
	private Set<LOP> letterOfPurchases = new HashSet<LOP>(
			0);
	private Set<BulkLOP> bulkLops = new HashSet<BulkLOP>(0);
	private Set<DistributionChainLevel> distributionChainLvls = new HashSet<DistributionChainLevel>(
			0);
	private Set<PartnerServices> partnerServiceses = new HashSet<PartnerServices>(
			0);

	public DistributionChainTemplate() {
	}

	public DistributionChainTemplate(BigDecimal id,
			MfinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String name,
			long serviceid) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.name = name;
		this.serviceid = serviceid;
	}

	public DistributionChainTemplate(BigDecimal id,
			MfinoServiceProvider mfinoServiceProvider,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby, String name,
			String description, long serviceid,
			Set<LOP> letterOfPurchases, Set<BulkLOP> bulkLops,
			Set<DistributionChainLevel> distributionChainLvls,
			Set<PartnerServices> partnerServiceses) {
		this.id = id;
		this.mfinoServiceProvider = mfinoServiceProvider;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.name = name;
		this.description = description;
		this.serviceid = serviceid;
		this.letterOfPurchases = letterOfPurchases;
		this.bulkLops = bulkLops;
		this.distributionChainLvls = distributionChainLvls;
		this.partnerServiceses = partnerServiceses;
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

	

	@Column(name = "NAME", nullable = false, length = 1020)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "SERVICEID", nullable = false, precision = 10, scale = 0)
	public long getServiceid() {
		return this.serviceid;
	}

	public void setServiceid(long serviceid) {
		this.serviceid = serviceid;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainTemp")
	public Set<LOP> getLetterOfPurchases() {
		return this.letterOfPurchases;
	}

	public void setLetterOfPurchases(Set<LOP> letterOfPurchases) {
		this.letterOfPurchases = letterOfPurchases;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainTemp")
	public Set<BulkLOP> getBulkLops() {
		return this.bulkLops;
	}

	public void setBulkLops(Set<BulkLOP> bulkLops) {
		this.bulkLops = bulkLops;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainTemp")
	public Set<DistributionChainLevel> getDistributionChainLvls() {
		return this.distributionChainLvls;
	}

	public void setDistributionChainLvls(
			Set<DistributionChainLevel> distributionChainLvls) {
		this.distributionChainLvls = distributionChainLvls;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "distributionChainTemp")
	public Set<PartnerServices> getPartnerServiceses() {
		return this.partnerServiceses;
	}

	public void setPartnerServiceses(Set<PartnerServices> partnerServiceses) {
		this.partnerServiceses = partnerServiceses;
	}
	@Override
	public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if(obj == null) {
            return false;
        } else {
            if(getId() != null){
            	return (getId().equals(((DistributionChainTemplate)obj).getId()));
            }
            
            return false;
        }
	}
	
	@Override
	public int hashCode() {
		if(null != this.getId()){
			return this.getId().intValue();
		}
		
		return -1;
	}
	
	@Override
	public String toString() {
		return "DCTID:"+getId() + ",DctName:"+getName();
	}
}
