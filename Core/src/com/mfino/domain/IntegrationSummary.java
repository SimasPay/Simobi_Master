package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * IntegrationSummary generated by hbm2java
 */
@Entity
@Table(name = "INTEGRATION_SUMMARY")
public class IntegrationSummary  extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FieldName_SctlId = "sctlid";
	public static final String FieldName_IntegrationType = "integrationtype";
	public static final String FieldName_ReconcilationID1 = "reconcilationid1";
	public static final String FieldName_ReconcilationID2 = "reconcilationid2";
	public static final String FieldName_ReconcilationID3 = "reconcilationid3";
	
	private Long sctlid;
	private String integrationtype;
	private String reconcilationid1;
	private String reconcilationid2;
	private String reconcilationid3;
	private String reconcilationid4;
	private BigDecimal pctid;
	private String institutionid;
	private Long id;

	public IntegrationSummary() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "integration_summary_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "SCTLID", nullable = false, scale = 0)
	public Long getSctlid() {
		return this.sctlid;
	}

	public void setSctlid(Long sctlid) {
		this.sctlid = sctlid;
	}

	@Column(name = "INTEGRATIONTYPE")
	public String getIntegrationtype() {
		return this.integrationtype;
	}

	public void setIntegrationtype(String integrationtype) {
		this.integrationtype = integrationtype;
	}

	@Column(name = "RECONCILATIONID1")
	public String getReconcilationid1() {
		return this.reconcilationid1;
	}

	public void setReconcilationid1(String reconcilationid1) {
		this.reconcilationid1 = reconcilationid1;
	}

	@Column(name = "RECONCILATIONID2", length = 1024)
	public String getReconcilationid2() {
		return this.reconcilationid2;
	}

	public void setReconcilationid2(String reconcilationid2) {
		this.reconcilationid2 = reconcilationid2;
	}

	@Column(name = "RECONCILATIONID3")
	public String getReconcilationid3() {
		return this.reconcilationid3;
	}

	public void setReconcilationid3(String reconcilationid3) {
		this.reconcilationid3 = reconcilationid3;
	}

	@Column(name = "RECONCILATIONID4", length = 225)
	public String getReconcilationid4() {
		return this.reconcilationid4;
	}

	public void setReconcilationid4(String reconcilationid4) {
		this.reconcilationid4 = reconcilationid4;
	}

	@Column(name = "PCTID", scale = 0)
	public BigDecimal getPctid() {
		return this.pctid;
	}

	public void setPctid(BigDecimal pctid) {
		this.pctid = pctid;
	}

	@Column(name = "INSTITUTIONID", length = 900)
	public String getInstitutionid() {
		return this.institutionid;
	}

	public void setInstitutionid(String institutionid) {
		this.institutionid = institutionid;
	}

}
