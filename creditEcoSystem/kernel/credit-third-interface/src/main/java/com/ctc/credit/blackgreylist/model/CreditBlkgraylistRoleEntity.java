package com.ctc.credit.blackgreylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "CREDIT_BLKGRAYLIST_ROLE")
public class CreditBlkgraylistRoleEntity {
	
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	
	@Column(name = "TIGGER_INFO")
	private String tiggerInfo;
	
	@Column(name = "TIGGER_DESCRIPTION")
	private String tiggerDescription;
	
	@Column(name = "TIGGER_SOURCE")
	private String tiggerSource;
	
	@Column(name = "BLKGRAY_ROLE_DES")
	private String blkgrayRoleDes;
	
	@Column(name = "BLKGRAY_ROLE_CODE")
	private String blkgrayRoleCode;
	
	@Column(name = "TIGGER_TYPE")
	private Integer tiggerType;
	
	@Column(name = "PRIORITY")
	private Integer priority;
	
	@Column(name = "ROLE_INDEX")
	private Integer roleIndex;
	
	@Column(name = "CREATE_TIME")
	private String createTime;
	
	@Column(name = "UPDATE_TIME")
	private String updateTime;
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTiggerInfo() {
		return tiggerInfo;
	}

	public void setTiggerInfo(String tiggerInfo) {
		this.tiggerInfo = tiggerInfo;
	}

	public String getTiggerDescription() {
		return tiggerDescription;
	}

	public void setTiggerDescription(String tiggerDescription) {
		this.tiggerDescription = tiggerDescription;
	}

	public String getTiggerSource() {
		return tiggerSource;
	}

	public void setTiggerSource(String tiggerSource) {
		this.tiggerSource = tiggerSource;
	}

	public String getBlkgrayRoleDes() {
		return blkgrayRoleDes;
	}

	public void setBlkgrayRoleDes(String blkgrayRoleDes) {
		this.blkgrayRoleDes = blkgrayRoleDes;
	}

	public String getBlkgrayRoleCode() {
		return blkgrayRoleCode;
	}

	public void setBlkgrayRoleCode(String blkgrayRoleCode) {
		this.blkgrayRoleCode = blkgrayRoleCode;
	}

	public Integer getTiggerType() {
		return tiggerType;
	}

	public void setTiggerType(Integer tiggerType) {
		this.tiggerType = tiggerType;
	}

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getRoleIndex() {
		return roleIndex;
	}

	public void setRoleIndex(Integer roleIndex) {
		this.roleIndex = roleIndex;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}
	
}
