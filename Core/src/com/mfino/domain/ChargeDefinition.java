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
import javax.persistence.UniqueConstraint;

/**
 * ChargeDefinition generated by hbm2java
 */
@Entity
@Table(name = "CHARGE_DEFINITION", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class ChargeDefinition extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final String FieldName_Name = "name";
	public static final String FieldName_ChargeType = "chargeTypeByChargetypeid";
	public static final String FieldName_PartnerByFundingPartnerID = "partner";
	public static final String FieldName_Pocket = "pocket";
	
	private Pocket pocket;
	private ChargeType chargeTypeByChargetypeid;
	private Partner partner;
	private MfinoServiceProvider mfinoServiceProvider;
	private ChargeType chargeTypeByDependantchargetypeid;
	private String name;
	private String description;
	private short ischargefromcustomer;
	private short istaxable;
	private Long id;
	private Set<TransactionCharge> transactionCharges = new HashSet<TransactionCharge>(
			0);
	private Set<ChargePricing> chargePricings = new HashSet<ChargePricing>(0);

	public ChargeDefinition() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "charge_definition_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POCKETID")
	public Pocket getPocket() {
		return this.pocket;
	}

	public void setPocket(Pocket pocket) {
		this.pocket = pocket;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHARGETYPEID", nullable = false)
	public ChargeType getChargeTypeByChargetypeid() {
		return this.chargeTypeByChargetypeid;
	}

	public void setChargeTypeByChargetypeid(ChargeType chargeTypeByChargetypeid) {
		this.chargeTypeByChargetypeid = chargeTypeByChargetypeid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FUNDINGPARTNERID")
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
	@JoinColumn(name = "DEPENDANTCHARGETYPEID")
	public ChargeType getChargeTypeByDependantchargetypeid() {
		return this.chargeTypeByDependantchargetypeid;
	}

	public void setChargeTypeByDependantchargetypeid(
			ChargeType chargeTypeByDependantchargetypeid) {
		this.chargeTypeByDependantchargetypeid = chargeTypeByDependantchargetypeid;
	}

	

	@Column(name = "NAME", unique = true, nullable = false, length = 1020)
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

	@Column(name = "ISCHARGEFROMCUSTOMER", nullable = false, precision = 3, scale = 0)
	public short getIschargefromcustomer() {
		return this.ischargefromcustomer;
	}

	public void setIschargefromcustomer(short ischargefromcustomer) {
		this.ischargefromcustomer = ischargefromcustomer;
	}

	@Column(name = "ISTAXABLE", nullable = false, precision = 3, scale = 0)
	public short getIstaxable() {
		return this.istaxable;
	}

	public void setIstaxable(short istaxable) {
		this.istaxable = istaxable;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chargeDefinition")
	public Set<TransactionCharge> getTransactionCharges() {
		return this.transactionCharges;
	}

	public void setTransactionCharges(Set<TransactionCharge> transactionCharges) {
		this.transactionCharges = transactionCharges;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "chargeDefinition")
	public Set<ChargePricing> getChargePricings() {
		return this.chargePricings;
	}

	public void setChargePricings(Set<ChargePricing> chargePricings) {
		this.chargePricings = chargePricings;
	}

}
