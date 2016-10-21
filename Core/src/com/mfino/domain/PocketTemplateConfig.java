package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * PocketTemplateConfig generated by hbm2java
 */
@Entity
@Table(name = "POCKET_TEMPLATE_CONFIG")
public class PocketTemplateConfig extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String FieldName_SubscriberType = "subscribertype";

	public static final String FieldName_BusinessPartnerType = "businesspartnertype";

	public static final String FieldName_KYCLevelByKYCLevel = "kycLevel";

	public static final String FieldName_PocketType = "pockettype";

	public static final String FieldName_Commodity = "commodity";

	public static final String FieldName_IsDefault = "isdefault";

	public static final String FieldName_IsSuspencePocket = "issuspencepocket";

	public static final String FieldName_IsCollectorPocket = "iscollectorpocket";

	public static final String FieldName_PTC_Group_MapFromPtcID = "ptcGroupMappings";
	
	private KycLevel kycLevel;
	private PocketTemplate pocketTemplate;
	private int subscribertype;
	private Integer businesspartnertype;
	private long commodity;
	private Integer pockettype;
	private Boolean issuspencepocket;
	private Boolean iscollectorpocket;
	private Boolean isdefault;
	private Long id;
	private Set<PtcGroupMapping> ptcGroupMappings = new HashSet<PtcGroupMapping>(
			0);

	public PocketTemplateConfig() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "pocket_template_config_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "KYCLEVEL", nullable = false)
	public KycLevel getKycLevel() {
		return this.kycLevel;
	}

	public void setKycLevel(KycLevel kycLevel) {
		this.kycLevel = kycLevel;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POCKETTEMPLATEID", nullable = false)
	public PocketTemplate getPocketTemplate() {
		return this.pocketTemplate;
	}

	public void setPocketTemplate(PocketTemplate pocketTemplate) {
		this.pocketTemplate = pocketTemplate;
	}

	

	@Column(name = "SUBSCRIBERTYPE", nullable = false, precision = 10, scale = 0)
	public int getSubscribertype() {
		return this.subscribertype;
	}

	public void setSubscribertype(int subscribertype) {
		this.subscribertype = subscribertype;
	}

	@Column(name = "BUSINESSPARTNERTYPE", precision = 10, scale = 0)
	public Integer getBusinesspartnertype() {
		return this.businesspartnertype;
	}

	public void setBusinesspartnertype(Integer businesspartnertype) {
		this.businesspartnertype = businesspartnertype;
	}

	@Column(name = "COMMODITY", nullable = false, precision = 10, scale = 0)
	public long getCommodity() {
		return this.commodity;
	}

	public void setCommodity(long commodity) {
		this.commodity = commodity;
	}

	@Column(name = "POCKETTYPE", nullable = false, precision = 10, scale = 0)
	public Integer getPockettype() {
		return this.pockettype;
	}

	public void setPockettype(Integer pockettype) {
		this.pockettype = pockettype;
	}

	@Column(name = "ISSUSPENCEPOCKET", precision = 3, scale = 0)
	public Boolean getIssuspencepocket() {
		return this.issuspencepocket;
	}

	public void setIssuspencepocket(Boolean issuspencepocket) {
		this.issuspencepocket = issuspencepocket;
	}

	@Column(name = "ISCOLLECTORPOCKET", precision = 3, scale = 0)
	public Boolean getIscollectorpocket() {
		return this.iscollectorpocket;
	}

	public void setIscollectorpocket(Boolean iscollectorpocket) {
		this.iscollectorpocket = iscollectorpocket;
	}

	@Column(name = "ISDEFAULT", precision = 3, scale = 0)
	public Boolean getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(Boolean isdefault) {
		this.isdefault = isdefault;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pocketTemplateConfig")
	public Set<PtcGroupMapping> getPtcGroupMappings() {
		return this.ptcGroupMappings;
	}

	public void setPtcGroupMappings(Set<PtcGroupMapping> ptcGroupMappings) {
		this.ptcGroupMappings = ptcGroupMappings;
	}

}
