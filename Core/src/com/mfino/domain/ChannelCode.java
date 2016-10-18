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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * ChannelCode generated by hbm2java
 */
@Entity
@Table(name = "CHANNEL_CODE", uniqueConstraints = @UniqueConstraint(columnNames = "CHANNELCODE"))
public class ChannelCode extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	public static final String FieldName_ChannelCode = "channelcode";
	public static final String FieldName_ChannelName = "channelname";
	public static final String FieldName_ChannelSourceApplication = "channelsourceapplication";
	
	private String channelcode;
	private String channelname;
	private String description;
	private long channelsourceapplication;
	private Long id;
	private Set<MfaTransactionsInfo> mfaTransactionsInfos = new HashSet<MfaTransactionsInfo>(
			0);
	private Set<TransactionRule> transactionRules = new HashSet<TransactionRule>(
			0);
	private Set<ActorChannelMapping> actorChannelMappings = new HashSet<ActorChannelMapping>(
			0);

	public ChannelCode() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "channel_code_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name = "CHANNELCODE", unique = true, nullable = false, length = 1020)
	public String getChannelcode() {
		return this.channelcode;
	}

	public void setChannelcode(String channelcode) {
		this.channelcode = channelcode;
	}

	@Column(name = "CHANNELNAME", nullable = false, length = 1020)
	public String getChannelname() {
		return this.channelname;
	}

	public void setChannelname(String channelname) {
		this.channelname = channelname;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "CHANNELSOURCEAPPLICATION", nullable = false, precision = 10, scale = 0)
	public long getChannelsourceapplication() {
		return this.channelsourceapplication;
	}

	public void setChannelsourceapplication(long channelsourceapplication) {
		this.channelsourceapplication = channelsourceapplication;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "channelCode")
	public Set<MfaTransactionsInfo> getMfaTransactionsInfos() {
		return this.mfaTransactionsInfos;
	}

	public void setMfaTransactionsInfos(
			Set<MfaTransactionsInfo> mfaTransactionsInfos) {
		this.mfaTransactionsInfos = mfaTransactionsInfos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "channelCode")
	public Set<TransactionRule> getTransactionRules() {
		return this.transactionRules;
	}

	public void setTransactionRules(Set<TransactionRule> transactionRules) {
		this.transactionRules = transactionRules;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "channelCode")
	public Set<ActorChannelMapping> getActorChannelMappings() {
		return this.actorChannelMappings;
	}

	public void setActorChannelMappings(
			Set<ActorChannelMapping> actorChannelMappings) {
		this.actorChannelMappings = actorChannelMappings;
	}

}
