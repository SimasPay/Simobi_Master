package com.mfino.domain;

// Generated Sep 27, 2016 5:23:21 PM by Hibernate Tools 3.4.0.CR1

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
import javax.persistence.UniqueConstraint;

/**
 * PermissionItem generated by hbm2java
 */
@Entity
@Table(name = "PERMISSION_ITEM", uniqueConstraints = @UniqueConstraint(columnNames = {
		"PERMISSION", "ITEMTYPE", "ITEMID", "FIELDID", "ACTION" }))
public class PermissionItem extends Base implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private PermissionGroup permissionGroup;
	private Integer permission;
	private Integer itemtype;
	private String itemid;
	private String fieldid;
	private String action;
	private String description;
	private Long id;

	public PermissionItem() {
	}
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "permission_item_ID_SEQ")
	@Column(name = "ID", unique = true, nullable = false, scale = 0)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERMISSIONGROUPID")
	public PermissionGroup getPermissionGroup() {
		return this.permissionGroup;
	}

	public void setPermissionGroup(PermissionGroup permissionGroup) {
		this.permissionGroup = permissionGroup;
	}

	
	@Column(name = "PERMISSION", nullable = false, precision = 10, scale = 0)
	public Integer getPermission() {
		return this.permission;
	}

	public void setPermission(Integer permission) {
		this.permission = permission;
	}

	@Column(name = "ITEMTYPE", nullable = false, precision = 10, scale = 0)
	public Integer getItemtype() {
		return this.itemtype;
	}

	public void setItemtype(Integer itemtype) {
		this.itemtype = itemtype;
	}

	@Column(name = "ITEMID", nullable = false, length = 1020)
	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	@Column(name = "FIELDID", nullable = false, length = 1020)
	public String getFieldid() {
		return this.fieldid;
	}

	public void setFieldid(String fieldid) {
		this.fieldid = fieldid;
	}

	@Column(name = "ACTION", nullable = false, length = 1020)
	public String getAction() {
		return this.action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Column(name = "DESCRIPTION", length = 1020)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public boolean equals(Object newObject)
    {

        if(!(newObject instanceof PermissionItem))
            return false;

        PermissionItem pNewObject = (PermissionItem) newObject;


        if(this.getItemtype().equals(pNewObject.getItemtype()) &&
            this.getItemid().trim().equals(pNewObject.getItemid().trim()) &&
            this.getFieldid().trim().equals(pNewObject.getFieldid().trim()) &&
            this.getAction().trim().equals(pNewObject.getAction().trim()))
        {
            return true;
        }
        else
            return false;
        
    }

	 	public boolean matchesWithoutField(PermissionItem permissionItems){
	        return this.getItemtype().equals(permissionItems.getItemtype()) &&
	            this.getItemid().trim().equals(permissionItems.getItemid().trim()) &&
	            this.getAction().trim().equals(permissionItems.getAction().trim());
	    }
}
