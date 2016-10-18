package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mfino.hibernate.Timestamp;

/**
 * ServiceSettlementCfg generated by hbm2java
 */
@Entity
@Table(name = "SERVICE_SETTLEMENT_CFG")
public class ServiceSettlementCfg extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_PartnerServicesByPartnerServiceID = "partnerServices";
	public static final String FieldName_PocketByCollectorPocket = "pocket";
	public static final String FieldName_SchedulerStatus = "schedulerstatus";
	public static final String FieldName_StartDate = "startdate";
	
	private MfinoServiceProvider mfinoServiceProvider;
	private PartnerServices partnerServices;
	private SettlementTemplate settlementTemplate;
	private Pocket pocket;
	private Timestamp startdate;
	private Timestamp enddate;
	private Short isdefault;
	private Long schedulerstatus;
	private BigDecimal similarconfigid;

	private Long id;
	
	public ServiceSettlementCfg() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "service_settlement_cfg_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@JoinColumn(name = "PARTNERSERVICEID", nullable = false)
	public PartnerServices getPartnerServices() {
		return this.partnerServices;
	}

	public void setPartnerServices(PartnerServices partnerServices) {
		this.partnerServices = partnerServices;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENTTEMPLATEID", nullable = false)
	public SettlementTemplate getSettlementTemplate() {
		return this.settlementTemplate;
	}

	public void setSettlementTemplate(SettlementTemplate settlementTemplate) {
		this.settlementTemplate = settlementTemplate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COLLECTORPOCKET")
	public Pocket getPocket() {
		return this.pocket;
	}

	public void setPocket(Pocket pocket) {
		this.pocket = pocket;
	}

	
	@Type(type = "userDefinedTimeStamp")
	@Column(name = "STARTDATE")
	public Timestamp getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Timestamp startdate) {
		this.startdate = startdate;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "ENDDATE")
	public Timestamp getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	@Column(name = "ISDEFAULT", precision = 3, scale = 0)
	public Short getIsdefault() {
		return this.isdefault;
	}

	public void setIsdefault(Short isdefault) {
		this.isdefault = isdefault;
	}

	@Column(name = "SCHEDULERSTATUS", precision = 10, scale = 0)
	public Long getSchedulerstatus() {
		return this.schedulerstatus;
	}

	public void setSchedulerstatus(Long schedulerstatus) {
		this.schedulerstatus = schedulerstatus;
	}

	@Column(name = "SIMILARCONFIGID", scale = 0)
	public BigDecimal getSimilarconfigid() {
		return this.similarconfigid;
	}

	public void setSimilarconfigid(BigDecimal similarconfigid) {
		this.similarconfigid = similarconfigid;
	}

}
