package com.ctc.credit.antifraud.model;


/**
 * 反欺诈命中历史概要信息
 * 
 * @author sunny
 *
 */
public class HistInfo {

	/** 来源系统 **/
	private String sourceSys;
	
	/** 申请单号 **/
	private String applyCode;
	
	public HistInfo(String sourceSys, String applyCode) {
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HistInfo [sourceSys=" + sourceSys + ", applyCode=" + applyCode
				+ "]";
	}
	
}
