package com.ctc.credit.antifraud.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 反欺诈返回结果表
 * 
 * @author sunny
 *
 */
public class FraudResult {
	
	/** 申请单号 **/
	private String applyCode;
	
	/** 反欺诈 0:未命中；1：命中；2：异常**/
	private String resultStatus;
	
	/** 反欺诈 异常信息**/
	private String resultMsg;
	
	/** 反欺诈 命中规则 **/
	private List<RuleInfo> hitRules = new ArrayList<RuleInfo>();
	
	/**
	 * @return the applyCode
	 */
	public String getApplyCode() {
		return applyCode;
	}
	public FraudResult() {
		super();
		this.resultStatus = "0";
	}
	/**
	 * @param applyCode the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}
	/**
	 * @return the resultStatus
	 */
	public String getResultStatus() {
		return resultStatus;
	}
	/**
	 * @param resultStatus the resultStatus to set
	 */
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}
	/**
	 * @return the resultMsg
	 */
	public String getResultMsg() {
		return resultMsg;
	}
	/**
	 * @param resultMsg the resultMsg to set
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
	/**
	 * @return the hitRules
	 */
	public List<RuleInfo> getHitRules() {
		return hitRules;
	}
	/**
	 * @param hitRules the hitRules to set
	 */
	public void setHitRules(List<RuleInfo> hitRules) {
		this.hitRules = hitRules;
	}
}
