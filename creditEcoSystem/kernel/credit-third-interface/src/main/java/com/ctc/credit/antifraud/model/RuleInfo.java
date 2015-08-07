package com.ctc.credit.antifraud.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 反欺诈命中规则信息
 * @author sunny
 *
 */
public class RuleInfo {

	/** 规则id **/
	private String ruleId;
	
	/** 规则类型 **/
	private String ruleType;
	
	/** 规则描述 **/
	private String ruleDesc;
	
	/** 规则命中字段 **/
	private List<String> ruleFields = new ArrayList<String>();
	
	/** 规则命中历史 **/
	private List<HistInfo> hitHist = new ArrayList<HistInfo>();
	
	/**
	 * @return the ruleId
	 */
	public String getRuleId() {
		return ruleId;
	}
	/**
	 * @param ruleId the ruleId to set
	 */
	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}
	/**
	 * @return the ruleDesc
	 */
	public String getRuleDesc() {
		return ruleDesc;
	}
	/**
	 * @param ruleDesc the ruleDesc to set
	 */
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	/**
	 * @return the hitHist
	 */
	public List<HistInfo> getHitHist() {
		return hitHist;
	}
	/**
	 * @param hitHist the hitHist to set
	 */
	public void setHitHist(List<HistInfo> hitHist) {
		this.hitHist = hitHist;
	}
	/**
	 * @return the ruleFields
	 */
	public List<String> getRuleFields() {
		return ruleFields;
	}
	/**
	 * @param ruleFields the ruleFields to set
	 */
	public void setRuleFields(List<String> ruleFields) {
		this.ruleFields = ruleFields;
	}
	/**
	 * @return the ruleType
	 */
	public String getRuleType() {
		return ruleType;
	}
	/**
	 * @param ruleType the ruleType to set
	 */
	public void setRuleType(String ruleType) {
		this.ruleType = ruleType;
	}
	
}
