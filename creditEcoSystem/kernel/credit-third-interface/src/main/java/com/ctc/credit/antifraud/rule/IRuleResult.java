package com.ctc.credit.antifraud.rule;

import java.util.List;

import com.ctc.credit.antifraud.model.HistInfo;
import com.ctc.credit.antifraud.rule.contant.IRuleCategory;

public class IRuleResult {
	
	private IRuleCategory iRuleCategory;
	
	private Boolean ruleResult;
	
	private Boolean ifHitHist;
	
	private List<HistInfo> hitApplyCodes;
	
	public IRuleResult() {
		this.ruleResult = false;
		this.ifHitHist = false;
		this.hitApplyCodes = null;
	}

	/**
	 * @return the iRuleCategory
	 */
	public IRuleCategory getiRuleCategory() {
		return iRuleCategory;
	}

	/**
	 * @param iRuleCategory the iRuleCategory to set
	 */
	public void setiRuleCategory(IRuleCategory iRuleCategory) {
		this.iRuleCategory = iRuleCategory;
	}

	/**
	 * @return the ruleResult
	 */
	public Boolean getRuleResult() {
		return ruleResult;
	}

	/**
	 * @param ruleResult the ruleResult to set
	 */
	public void setRuleResult(Boolean ruleResult) {
		this.ruleResult = ruleResult;
	}

	/**
	 * @return the ifHitHist
	 */
	public Boolean getIfHitHist() {
		return ifHitHist;
	}

	/**
	 * @param ifHitHist the ifHitHist to set
	 */
	public void setIfHitHist(Boolean ifHitHist) {
		this.ifHitHist = ifHitHist;
	}

	/**
	 * @return the hitApplyCodes
	 */
	public List<HistInfo> getHitApplyCodes() {
		return hitApplyCodes;
	}

	/**
	 * @param hitApplyCodes the hitApplyCodes to set
	 */
	public void setHitApplyCodes(List<HistInfo> hitApplyCodes) {
		if (null!=hitApplyCodes&&hitApplyCodes.size()>0) {
			this.ifHitHist = true;
		}
		this.hitApplyCodes = hitApplyCodes;
	}

	
}