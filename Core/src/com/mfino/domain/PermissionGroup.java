package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.mfino.hibernate.Timestamp;

/**
 * PermissionGroup generated by hbm2java
 */
@Entity
@Table(name = "PERMISSION_GROUP")
public class PermissionGroup extends Base implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String permissiongroupname;
	private Set<PermissionItem> permissionItems = new HashSet<PermissionItem>(0);

	public PermissionGroup() {
	}

	public PermissionGroup(BigDecimal id, Timestamp lastupdatetime,
			String updatedby, Timestamp createtime, String createdby,
			String permissiongroupname) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.permissiongroupname = permissiongroupname;
	}

	public PermissionGroup(BigDecimal id, Timestamp lastupdatetime,
			String updatedby, Timestamp createtime, String createdby,
			String permissiongroupname, Set<PermissionItem> permissionItems) {
		this.id = id;
		this.lastupdatetime = lastupdatetime;
		this.updatedby = updatedby;
		this.createtime = createtime;
		this.createdby = createdby;
		this.permissiongroupname = permissiongroupname;
		this.permissionItems = permissionItems;
	}

	

	@Column(name = "PERMISSIONGROUPNAME", nullable = false)
	public String getPermissiongroupname() {
		return this.permissiongroupname;
	}

	public void setPermissiongroupname(String permissiongroupname) {
		this.permissiongroupname = permissiongroupname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "permissionGroup")
	public Set<PermissionItem> getPermissionItems() {
		return this.permissionItems;
	}

	public void setPermissionItems(Set<PermissionItem> permissionItems) {
		this.permissionItems = permissionItems;
	}

}
