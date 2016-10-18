package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SapGroupid generated by hbm2java
 */
@Entity
@Table(name = "SAP_GROUPID")
public class SapGroupid extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	public static final String FieldName_GroupID = "groupid";
	public static final String FieldName_GroupIDName = "groupidname";
	private String groupid;
	private String groupidname;

	private Long id;
	
	public SapGroupid() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "sap_groupid_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	@Column(name = "GROUPID", nullable = false, length = 1020)
	public String getGroupid() {
		return this.groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	@Column(name = "GROUPIDNAME", nullable = false, length = 1020)
	public String getGroupidname() {
		return this.groupidname;
	}

	public void setGroupidname(String groupidname) {
		this.groupidname = groupidname;
	}

}
