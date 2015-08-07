package com.ctc.credit.bairong.api.dto.applyLoan;
/**
 *  百融：申请次数
 * @author danggang
 *
 */
public class ApplyNoDto {

	/** 本机构申请次数**/
	private String selfnumber;
	
	/** 总申请次数**/
	private String allnumber;
	
	/** 总申请机构数**/
	private String orgnumber;

	public String getSelfnumber() {
		return selfnumber;
	}

	public void setSelfnumber(String selfnumber) {
		this.selfnumber = selfnumber;
	}

	public String getAllnumber() {
		return allnumber;
	}

	public void setAllnumber(String allnumber) {
		this.allnumber = allnumber;
	}

	public String getOrgnumber() {
		return orgnumber;
	}

	public void setOrgnumber(String orgnumber) {
		this.orgnumber = orgnumber;
	}
	
	
}
