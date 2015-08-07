package com.ctc.credit.kernel.model.pengyuan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @author daniel
 * 固定电话反查信息[ 个人|企业]，telCheckInfo.item节点数据
 * 鹏元接口MODEL类
 */

@Entity
@Table(name = "CREDIT_TEL_CHECK_INFO")
public class CisTelCheckInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	@Column(name = "APPLY_NO")
	private String applyNo;
	
	@Column(name = "RESULT_TYPE")
	private String resultType;
	

	@Column(name = "OWNER_NAME")
	private String ownerName;
	
	@Column(name = "AREA_CODE")
	private String areaCode;
	
	@Column(name = "AREA_DESC")
	private String areaDesc;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "CHECK_TYPE")
	private Integer checkType;
	
	@Column(name= "CREATION_DATE")
	private String creationDate;
	
	@Column(name= "TELEPHONE")
	private String telePhone;
	
	@Column(name= "BATCH_NO")
	private String batchNo;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getResultType() {
		return resultType;
	}

	public void setResultType(String resultType) {
		this.resultType = resultType;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaDesc() {
		return areaDesc;
	}

	public void setAreaDesc(String areaDesc) {
		this.areaDesc = areaDesc;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getCheckType() {
		return checkType;
	}

	public void setCheckType(Integer checkType) {
		this.checkType = checkType;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the telePhone
	 */
	public String getTelePhone() {
		return telePhone;
	}

	/**
	 * @param telePhone the telePhone to set
	 */
	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
}
