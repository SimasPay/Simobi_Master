package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.mfino.hibernate.Timestamp;
/**
 * ExcludeSubscriberLc generated by hbm2java
 */
@Entity
@Table(name = "EXCLUDE_SUBSCRIBER_LC")
public class ExcludeSubscriberLc extends Base implements java.io.Serializable {

	
	public static final String FieldName_MDN = "subscriberMdn";
	public static final String FieldName_SubscriberMDNByMDNID = "subscriberMdn";
	private SubscriberMdn subscriberMdn;
	

	public ExcludeSubscriberLc() {
	}

	public ExcludeSubscriberLc(BigDecimal id, SubscriberMdn subscriberMdn,
			Timestamp lastupdatetime, String updatedby,
			Timestamp createtime, String createdby) {
		this.id = id;
		this.subscriberMdn = subscriberMdn;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MDNID", nullable = false)
	public SubscriberMdn getSubscriberMdn() {
		return this.subscriberMdn;
	}

	public void setSubscriberMdn(SubscriberMdn subscriberMdn) {
		this.subscriberMdn = subscriberMdn;
	}

	
}
