package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MfinoJobDetails generated by hbm2java
 */
@Entity
@Table(name = "MFINO_JOB_DETAILS")
public class MfinoJobDetails implements java.io.Serializable {

	private MfinoJobDetailsId id;
	private String description;
	private String jobClassName;
	private String isDurable;
	private String isVolatile;
	private String isStateful;
	private String requestsRecovery;
	private Blob jobData;
	private Set<MfinoJobListeners> mfinoJobListenerses = new HashSet<MfinoJobListeners>(
			0);
	private Set<MfinoTriggers> mfinoTriggerses = new HashSet<MfinoTriggers>(0);

	public MfinoJobDetails() {
	}

	

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "jobName", column = @Column(name = "JOB_NAME", nullable = false, length = 200)),
			@AttributeOverride(name = "jobGroup", column = @Column(name = "JOB_GROUP", nullable = false, length = 200)) })
	public MfinoJobDetailsId getId() {
		return this.id;
	}

	public void setId(MfinoJobDetailsId id) {
		this.id = id;
	}

	@Column(name = "DESCRIPTION", length = 250)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "JOB_CLASS_NAME", nullable = false, length = 250)
	public String getJobClassName() {
		return this.jobClassName;
	}

	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
	}

	@Column(name = "IS_DURABLE", nullable = false, length = 1)
	public String getIsDurable() {
		return this.isDurable;
	}

	public void setIsDurable(String isDurable) {
		this.isDurable = isDurable;
	}

	@Column(name = "IS_VOLATILE", nullable = false, length = 1)
	public String getIsVolatile() {
		return this.isVolatile;
	}

	public void setIsVolatile(String isVolatile) {
		this.isVolatile = isVolatile;
	}

	@Column(name = "IS_STATEFUL", nullable = false, length = 1)
	public String getIsStateful() {
		return this.isStateful;
	}

	public void setIsStateful(String isStateful) {
		this.isStateful = isStateful;
	}

	@Column(name = "REQUESTS_RECOVERY", nullable = false, length = 1)
	public String getRequestsRecovery() {
		return this.requestsRecovery;
	}

	public void setRequestsRecovery(String requestsRecovery) {
		this.requestsRecovery = requestsRecovery;
	}

	@Column(name = "JOB_DATA")
	public Blob getJobData() {
		return this.jobData;
	}

	public void setJobData(Blob jobData) {
		this.jobData = jobData;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mfinoJobDetails")
	public Set<MfinoJobListeners> getMfinoJobListenerses() {
		return this.mfinoJobListenerses;
	}

	public void setMfinoJobListenerses(
			Set<MfinoJobListeners> mfinoJobListenerses) {
		this.mfinoJobListenerses = mfinoJobListenerses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mfinoJobDetails")
	public Set<MfinoTriggers> getMfinoTriggerses() {
		return this.mfinoTriggerses;
	}

	public void setMfinoTriggerses(Set<MfinoTriggers> mfinoTriggerses) {
		this.mfinoTriggerses = mfinoTriggerses;
	}

}
