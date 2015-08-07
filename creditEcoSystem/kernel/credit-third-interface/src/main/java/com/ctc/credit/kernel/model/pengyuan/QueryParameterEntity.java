package com.ctc.credit.kernel.model.pengyuan;

import java.io.Serializable;

/**
 * 
 * 通用查询接口查询参数实体对象
 * 
 * @author sunny
 * 
 */
public class QueryParameterEntity implements Serializable {

	private static final long serialVersionUID = -8891855402693561201L;

	/**
	 * uuuid，申请件的唯一标示
	 */
	private String sendCode;

	/**
	 * 申请条码
	 */
	private String applyNo;

	/**
	 * 电话号码
	 */
	private String telephone;
	
	/**
	 * 单位名称
	 */
	private String corpName;

	/**
	 * 证件类型
	 */
	private String idType;

	/**
	 * 请求人姓名
	 */
	private String personName;

	/**
	 * 证件号码
	 */
	private String idNumber;

	/**
	 * @return the sendCode
	 */
	public String getSendCode() {
		return sendCode;
	}

	/**
	 * @param sendCode
	 *            the sendCode to set
	 */
	public void setSendCode(String sendCode) {
		this.sendCode = sendCode;
	}

	/**
	 * @return the applyNo
	 */
	public String getApplyNo() {
		return applyNo;
	}

	/**
	 * @param applyNo
	 *            the applyNo to set
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the idType
	 */
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType
	 *            the idType to set
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
	 * @param personName
	 *            the personName to set
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
	 * @param idNumber
	 *            the idNumber to set
	 */
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
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

}
