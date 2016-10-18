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

import org.hibernate.annotations.Type;

/**
 * Ledger generated by hbm2java
 */
@Entity
@Table(name = "LEDGER")
public class Ledger extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FieldName_SourcePocketID = "sourcepocketid";
	public static final String FieldName_SourceMDN = "sourcemdn";
	public static final String FieldName_CommodityTransferID = "commoditytransferid";
	public static final String FieldName_DestPocketID = "destpocketid";
	public static final String FieldName_DestMDN = "destmdn";
	
	private Long commoditytransferid;
	private String sourcemdn;
	private Long sourcepocketid;
	private String sourcepocketbalance;
	private String destmdn;
	private Long destpocketid;
	private String destpocketbalance;
	private BigDecimal amount;
    private Long id;
	public Ledger() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ledger_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name = "COMMODITYTRANSFERID", nullable = false, scale = 0)
	public Long getCommoditytransferid() {
		return this.commoditytransferid;
	}

	public void setCommoditytransferid(Long commoditytransferid) {
		this.commoditytransferid = commoditytransferid;
	}

	@Column(name = "SOURCEMDN", length = 1020)
	public String getSourcemdn() {
		return this.sourcemdn;
	}

	public void setSourcemdn(String sourcemdn) {
		this.sourcemdn = sourcemdn;
	}

	@Column(name = "SOURCEPOCKETID", scale = 0)
	public Long getSourcepocketid() {
		return this.sourcepocketid;
	}

	public void setSourcepocketid(Long sourcepocketid) {
		this.sourcepocketid = sourcepocketid;
	}

	@Type(type = "uniqueencryptedString")
	@Column(name = "SOURCEPOCKETBALANCE", length = 1020)
	public String getSourcepocketbalance() {
		return this.sourcepocketbalance;
	}

	public void setSourcepocketbalance(String sourcepocketbalance) {
		this.sourcepocketbalance = sourcepocketbalance;
	}

	@Column(name = "DESTMDN", length = 1020)
	public String getDestmdn() {
		return this.destmdn;
	}

	public void setDestmdn(String destmdn) {
		this.destmdn = destmdn;
	}

	@Column(name = "DESTPOCKETID", scale = 0)
	public Long getDestpocketid() {
		return this.destpocketid;
	}

	public void setDestpocketid(Long destpocketid) {
		this.destpocketid = destpocketid;
	}

	@Type(type = "uniqueencryptedString")
	@Column(name = "DESTPOCKETBALANCE", length = 1020)
	public String getDestpocketbalance() {
		return this.destpocketbalance;
	}

	public void setDestpocketbalance(String destpocketbalance) {
		this.destpocketbalance = destpocketbalance;
	}

	@Column(name = "AMOUNT", precision = 25, scale = 4)
	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

}
