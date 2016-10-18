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

/**
 * SharePartner generated by hbm2java
 */
@Entity
@Table(name = "SHARE_PARTNER")
public class SharePartner extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_TransactionCharge = "transactionCharge";
	private Partner partner;
	private TransactionCharge transactionCharge;
	private MfinoServiceProvider mfinoServiceProvider;
	private BigDecimal sharepercentage;
	private String sharetype;
	private String shareholdertype;
	private String actualsharepercentage;
	private String minsharepercentage;
	private String maxsharepercentage;

	private Long id;
	
	public SharePartner() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "share_partner_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARTNERID")
	public Partner getPartner() {
		return this.partner;
	}

	public void setPartner(Partner partner) {
		this.partner = partner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TRANSACTIONCHARGEID", nullable = false)
	public TransactionCharge getTransactionCharge() {
		return this.transactionCharge;
	}

	public void setTransactionCharge(TransactionCharge transactionCharge) {
		this.transactionCharge = transactionCharge;
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

	

	@Column(name = "SHAREPERCENTAGE", precision = 25, scale = 4)
	public BigDecimal getSharepercentage() {
		return this.sharepercentage;
	}

	public void setSharepercentage(BigDecimal sharepercentage) {
		this.sharepercentage = sharepercentage;
	}

	@Column(name = "SHARETYPE", length = 1020)
	public String getSharetype() {
		return this.sharetype;
	}

	public void setSharetype(String sharetype) {
		this.sharetype = sharetype;
	}

	@Column(name = "SHAREHOLDERTYPE", length = 1020)
	public String getShareholdertype() {
		return this.shareholdertype;
	}

	public void setShareholdertype(String shareholdertype) {
		this.shareholdertype = shareholdertype;
	}

	@Column(name = "ACTUALSHAREPERCENTAGE")
	public String getActualsharepercentage() {
		return this.actualsharepercentage;
	}

	public void setActualsharepercentage(String actualsharepercentage) {
		this.actualsharepercentage = actualsharepercentage;
	}

	@Column(name = "MINSHAREPERCENTAGE")
	public String getMinsharepercentage() {
		return this.minsharepercentage;
	}

	public void setMinsharepercentage(String minsharepercentage) {
		this.minsharepercentage = minsharepercentage;
	}

	@Column(name = "MAXSHAREPERCENTAGE")
	public String getMaxsharepercentage() {
		return this.maxsharepercentage;
	}

	public void setMaxsharepercentage(String maxsharepercentage) {
		this.maxsharepercentage = maxsharepercentage;
	}

}
