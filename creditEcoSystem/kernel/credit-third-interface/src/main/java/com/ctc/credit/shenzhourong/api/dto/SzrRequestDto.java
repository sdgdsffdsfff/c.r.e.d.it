package com.ctc.credit.shenzhourong.api.dto;

/**
 * 前海征信请求报文对象
 * @author sunny
 *
 */
public class SzrRequestDto {
	/** 用户名 **/
	private String userId;
	/** 密码 **/
	private String password;
	/** 服务编码 **/
	private String serviceCode;
	/** 身份证号 **/
	private String idNo;
	/** 姓名 **/
	private String name;
	/** 证件类型 **/
	private String idType;
	/** 手机 **/
	private String mobile;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

}
