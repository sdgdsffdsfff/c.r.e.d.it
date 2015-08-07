package com.ctc.credit.antifraud.model;


public class SimpleFraudQueryCondition {

	/** 申请条码 **/
	private String applyCode;
	
	/***
	 * 来源系统
	 * 01-信贷
	 * 02-车贷
	 * 03-消金
	 * 04-其他
	 *
	 **/
	private String sourceSys;

	/**
	 * @return the applyCode
	 */
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * @param applyCode the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * @return the sourceSys
	 */
	public String getSourceSys() {
		return sourceSys;
	}

	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(String sourceSys) {
		this.sourceSys = sourceSys;
	}
}
