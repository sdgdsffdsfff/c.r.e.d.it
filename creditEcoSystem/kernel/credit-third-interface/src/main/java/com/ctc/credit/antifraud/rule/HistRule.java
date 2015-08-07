package com.ctc.credit.antifraud.rule;

/**
 * 历史规则类
 * @author sunny
 *
 */
public class HistRule {

	/** 来源系统 **/
	private String sourceSys;
	
	/** 申请单号 **/
	private String applyCode;
	
	public HistRule(String sourceSys, String applyCode) {
		this.sourceSys = sourceSys;
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
	
	
}
