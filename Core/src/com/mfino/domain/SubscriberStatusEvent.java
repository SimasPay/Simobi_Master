package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mfino.hibernate.Timestamp;

/**
 * SubscriberStatusEvent generated by hbm2java
 */
@Entity
@Table(name = "SUBSCRIBER_STATUS_EVENT")
public class SubscriberStatusEvent extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_PickUpDateTime = "pickupdatetime";
	public static final String FieldName_ProcessingStatus = "processingstatus";
	public static final String FieldName_StatusOnPickup = "statusonpickup";
	public static final String FieldName_SubscriberType = "subscribertype";
	public static final String FieldName_SubscriberId = "subscriberid";
	private BigDecimal subscriberid;
	private Timestamp pickupdatetime;
	private Short processingstatus;
	private long statusonpickup;
	private long subscribertype;

	public SubscriberStatusEvent() {
	}

	

	@Column(name = "SUBSCRIBERID", nullable = false, scale = 0)
	public BigDecimal getSubscriberid() {
		return this.subscriberid;
	}

	public void setSubscriberid(BigDecimal subscriberid) {
		this.subscriberid = subscriberid;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "PICKUPDATETIME", nullable = false)
	public Timestamp getPickupdatetime() {
		return this.pickupdatetime;
	}

	public void setPickupdatetime(Timestamp pickupdatetime) {
		this.pickupdatetime = pickupdatetime;
	}

	@Column(name = "PROCESSINGSTATUS", precision = 3, scale = 0)
	public Short getProcessingstatus() {
		return this.processingstatus;
	}

	public void setProcessingstatus(Short processingstatus) {
		this.processingstatus = processingstatus;
	}

	@Column(name = "STATUSONPICKUP", nullable = false, precision = 10, scale = 0)
	public long getStatusonpickup() {
		return this.statusonpickup;
	}

	public void setStatusonpickup(long statusonpickup) {
		this.statusonpickup = statusonpickup;
	}

	@Column(name = "SUBSCRIBERTYPE", nullable = false, precision = 10, scale = 0)
	public long getSubscribertype() {
		return this.subscribertype;
	}

	public void setSubscribertype(long subscribertype) {
		this.subscribertype = subscribertype;
	}

}
