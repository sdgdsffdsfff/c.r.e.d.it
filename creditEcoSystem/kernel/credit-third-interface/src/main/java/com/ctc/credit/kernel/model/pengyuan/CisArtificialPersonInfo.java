package com.ctc.credit.kernel.model.pengyuan;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


/**
 * 
 * @author daniel
 * 个人担任法定代表人信息，cisReport.artificialNationalInfo 节点数据
 * 鹏元接口MODEL类
 */

@Entity
@Table(name = "CREDIT_ARTIFICIAL_PERSON_INFO")
public class CisArtificialPersonInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	@Column(name = "APPLY_NO")
	private String applyNo;
	
	@Column(name = "ARTIFICIAL_NAME")
	private String artificialName;
	
	@Column(name= "CORP_NAME")
	private String corpName;
	
	@Column(name= "REGISTER_NO")
	private String registerNo;
	
	@Column(name= "ORG_CODE")
	private String orgCode;
	
	@Column(name= "CORP_TYPE")
	private String corpType;
	
	@Column(name= "CORP_TYPE_DESC")
	private String corpTypeDesc;
	
	@Column(name= "REGISTER_FUND")
	private String registerFund;
	
	@Column(name= "CORP_STATUS")
	private String corpStatus;
	
	@Column(name= "CORP_STATUS_DESC")
	private String corpStatusDesc;
	
	@Column(name= "CREATION_DATE")
	private String creationDate;
	
	@Column(name= "BATCH_NO")
	private String batchNo;
	
	@Column(name= "id_type")
	private String idType;
	
	@Column(name= "person_name")
	private String personName;
	
	@Column(name= "id_number")
	private String idNumber;
	
	
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

	public String getArtificialName() {
		return artificialName;
	}

	public void setArtificialName(String artificialName) {
		this.artificialName = artificialName;
	}

	public String getCorpName() {
		return corpName;
	}

	public void setCorpName(String corpName) {
		this.corpName = corpName;
	}

	public String getRegisterNo() {
		return registerNo;
	}

	public void setRegisterNo(String registerNo) {
		this.registerNo = registerNo;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getCorpType() {
		return corpType;
	}

	public void setCorpType(String corpType) {
		this.corpType = corpType;
	}

	public String getCorpTypeDesc() {
		return corpTypeDesc;
	}

	public void setCorpTypeDesc(String corpTypeDesc) {
		this.corpTypeDesc = corpTypeDesc;
	}

	public String getRegisterFund() {
		return registerFund;
	}

	public void setRegisterFund(String registerFund) {
		this.registerFund = registerFund;
	}

	public String getCorpStatus() {
		return corpStatus;
	}

	public void setCorpStatus(String corpStatus) {
		this.corpStatus = corpStatus;
	}

	public String getCorpStatusDesc() {
		return corpStatusDesc;
	}

	public void setCorpStatusDesc(String corpStatusDesc) {
		this.corpStatusDesc = corpStatusDesc;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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

	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}

	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}

	/**
	 * @return the idNumber
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
}
