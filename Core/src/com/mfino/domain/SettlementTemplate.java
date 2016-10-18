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
 * SettlementTemplate generated by hbm2java
 */
@Entity
@Table(name = "SETTLEMENT_TEMPLATE")
public class SettlementTemplate extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_SettlementName = "settlementname";
	public static final String FieldName_Partner = "partner";
	private ScheduleTemplate scheduleTemplateByScheduletemplateid;
	private Partner partner;
	private MfinoServiceProvider mfinoServiceProvider;
	private ScheduleTemplate scheduleTemplateByCutofftime;
	private Pocket pocket;
	private String settlementname;
	private Set<ServiceSettlementCfg> serviceSettlementCfgs = new HashSet<ServiceSettlementCfg>(
			0);

	private Long id;
	
	public SettlementTemplate() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "settlement_template_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEDULETEMPLATEID", nullable = false)
	public ScheduleTemplate getScheduleTemplateByScheduletemplateid() {
		return this.scheduleTemplateByScheduletemplateid;
	}

	public void setScheduleTemplateByScheduletemplateid(
			ScheduleTemplate scheduleTemplateByScheduletemplateid) {
		this.scheduleTemplateByScheduletemplateid = scheduleTemplateByScheduletemplateid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTNERID", nullable = false)
	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
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
	@JoinColumn(name = "CUTOFFTIME")
	public ScheduleTemplate getScheduleTemplateByCutofftime() {
		return this.scheduleTemplateByCutofftime;
	}

	public void setScheduleTemplateByCutofftime(
			ScheduleTemplate scheduleTemplateByCutofftime) {
		this.scheduleTemplateByCutofftime = scheduleTemplateByCutofftime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SETTLEMENTPOCKET", nullable = false)
	public Pocket getPocket() {
		return this.pocket;
	}

	public void setPocket(Pocket pocket) {
		this.pocket = pocket;
	}

	
	@Column(name = "SETTLEMENTNAME", nullable = false, length = 1020)
	public String getSettlementname() {
		return this.settlementname;
	}

	public void setSettlementname(String settlementname) {
		this.settlementname = settlementname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settlementTemplate")
	public Set<ServiceSettlementCfg> getServiceSettlementCfgs() {
		return this.serviceSettlementCfgs;
	}

	public void setServiceSettlementCfgs(
			Set<ServiceSettlementCfg> serviceSettlementCfgs) {
		this.serviceSettlementCfgs = serviceSettlementCfgs;
	}

}
