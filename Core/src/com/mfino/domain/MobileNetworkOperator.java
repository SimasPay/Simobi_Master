package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.mfino.hibernate.Timestamp;
/**
 * MobileNetworkOperator generated by hbm2java
 */
@Entity
@Table(name = "MOBILE_NETWORK_OPERATOR")
public class MobileNetworkOperator extends Base implements java.io.Serializable {

	
	private String name;
	private String description;
	private Long status;
	private Timestamp statustime;
	private Long id;

	public MobileNetworkOperator() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "mobile_network_operator_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NAME", length = 1020)
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

	@Column(name = "STATUS", precision = 10, scale = 0)
	public Long getStatus() {
		return this.status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Type(type = "userDefinedTimeStamp")
	@Column(name = "STATUSTIME")
	public Timestamp getStatustime() {
		return this.statustime;
	}

	public void setStatustime(Timestamp statustime) {
		this.statustime = statustime;
	}

}
