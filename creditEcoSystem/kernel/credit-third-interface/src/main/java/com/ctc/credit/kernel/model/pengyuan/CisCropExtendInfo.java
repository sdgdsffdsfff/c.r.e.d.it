package com.ctc.credit.kernel.model.pengyuan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author daniel
 * 企业地址及电话信息[注册|经营], cisReport.registerContactInfos/manageContactInfos节点数据
 * 鹏元接口MODEL类
 */

@Entity
@Table(name = "CREDIT_CROP_EXTEND_INFO")
public class CisCropExtendInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	@Column(name = "APPLY_NO")
	private String applyNo;
	
	@Column(name = "AREA_CODE")
	private String areaCode;
	
	@Column(name = "AREADESC")
	private String areadesc;
	
	@Column(name = "ADDRESS")
	private String address;
	
	@Column(name = "TELEPHONE")
	private String telephone;
	
	@Column(name = "POST_CODE")
	private String postCode;
	
	@Column(name = "INFO_TYPE")
	private Integer infoType;
	
	@Column(name= "CREATION_DATE")
	
	private String creationDate;
	
	@Column(name = "CORP_NAME")
	private String corpName;
	
	@Column(name = "BATCH_NO")
	private String batchNo;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the applyNo
	 */
	public String getApplyNo() {
		return applyNo;
	}

	/**
	 * @param applyNo the applyNo to set
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	/**
	 * @return the areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/**
	 * @param areaCode the areaCode to set
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	/**
	 * @return the areadesc
	 */
	public String getAreadesc() {
		return areadesc;
	}

	/**
	 * @param areadesc the areadesc to set
	 */
	public void setAreadesc(String areadesc) {
		this.areadesc = areadesc;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the postCode
	 */
	public String getPostCode() {
		return postCode;
	}

	/**
	 * @param postCode the postCode to set
	 */
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	/**
	 * @return the infoType
	 */
	public Integer getInfoType() {
		return infoType;
	}

	/**
	 * @param infoType the infoType to set
	 */
	public void setInfoType(Integer infoType) {
		this.infoType = infoType;
	}

	/**
	 * @return the creationDate
	 */
	public String getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the corpName
	 */
	public String getCorpName() {
		return corpName;
	}

	/**
	 * @param corpName the corpName to set
	 */
	public void setCorpName(String corpName) {
		this.corpName = corpName;
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
