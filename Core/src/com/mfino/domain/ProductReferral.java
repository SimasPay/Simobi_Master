package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import com.mfino.hibernate.Timestamp;

/**
 * ProductReferral generated by hbm2java
 */
@Entity
@Table(name = "PRODUCT_REFERRAL")
public class ProductReferral extends Base implements java.io.Serializable {

	
	private String agentmdn;
	private String fullname;
	private String subscribermdn;
	private String email;
	private String productdesired;
	private String others;

	public ProductReferral() {
	}

	public ProductReferral(BigDecimal id, Timestamp createtime,
			String createdby, String agentmdn, String fullname,
			String subscribermdn, String productdesired) {
		this.id = id;
		this.createtime = createtime;
		this.createdby = createdby;
		this.agentmdn = agentmdn;
		this.fullname = fullname;
		this.subscribermdn = subscribermdn;
		this.productdesired = productdesired;
	}

	public ProductReferral(BigDecimal id, Timestamp lastupdatetime,
			String updatedby, Timestamp createtime, String createdby,
			String agentmdn, String fullname, String subscribermdn,
			String email, String productdesired, String others) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.agentmdn = agentmdn;
		this.fullname = fullname;
		this.subscribermdn = subscribermdn;
		this.email = email;
		this.productdesired = productdesired;
		this.others = others;
	}

	

	@Column(name = "AGENTMDN", nullable = false)
	public String getAgentmdn() {
		return this.agentmdn;
	}

	public void setAgentmdn(String agentmdn) {
		this.agentmdn = agentmdn;
	}

	@Column(name = "FULLNAME", nullable = false)
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "SUBSCRIBERMDN", nullable = false)
	public String getSubscribermdn() {
		return this.subscribermdn;
	}

	public void setSubscribermdn(String subscribermdn) {
		this.subscribermdn = subscribermdn;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "PRODUCTDESIRED", nullable = false)
	public String getProductdesired() {
		return this.productdesired;
	}

	public void setProductdesired(String productdesired) {
		this.productdesired = productdesired;
	}

	@Column(name = "OTHERS")
	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}
