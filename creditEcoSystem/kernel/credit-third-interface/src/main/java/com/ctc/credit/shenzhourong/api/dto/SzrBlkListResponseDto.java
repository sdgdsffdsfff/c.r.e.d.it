package com.ctc.credit.shenzhourong.api.dto;

/**
 * 神州融征信黑名单返回报文对象
 * @author sunny
 *
 */
public class SzrBlkListResponseDto {
	/** 返回状态代码  **/
	private String status;
	/** 返回 状态值 **/
	private String value;
//	/** 返回查询代码  **/
//	private String resultCode;
//	/** 返回查询描述  **/
//	private String resultDesc;
	/** 姓名  **/
	private String name;
	/** 证件号  **/
	private String idNo;
	/** 证件类别  **/
	private String idType;
	/** 黑名单等级  **/
	private String grade;
	/** 来源  **/
	private String sourceId;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
//	public String getResultCode() {
//		return resultCode;
//	}
//	public void setResultCode(String resultCode) {
//		this.resultCode = resultCode;
//	}
//	public String getResultDesc() {
//		return resultDesc;
//	}
//	public void setResultDesc(String resultDesc) {
//		this.resultDesc = resultDesc;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	
	
	
}
