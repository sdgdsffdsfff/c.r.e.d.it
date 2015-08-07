package com.ctc.credit.antifraud.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ctc.credit.antifraud.rule.contant.IRuleCategory;

public class RuleProducer {

	private static Logger logger = Logger.getLogger(RuleProducer.class);

	public RuleProducer(RuleQueue queue, String applyCode) {
		this.queue = queue;
		this.applyCode = applyCode;
	}

	public void product() {
		logger.debug("启动规则生产者线程！");
		List<IRuleCategory> rules = new ArrayList<IRuleCategory>();
		try {
			rules = getAllRulesExe();
			for (IRuleCategory rule : rules) {
				queue.putRule(rule);
			}
		} catch (InterruptedException e) {
			logger.error("申请单号:"+applyCode+"规则加入队列失败",e);
			Thread.currentThread().interrupt();
		}finally{
			logger.debug("退出规则生产者线程！");
		}
	}

	/**
	 * 获取所有要跑的规则
	 * 
	 * @return
	 */
	public List<IRuleCategory> getAllRulesExe(){
		List<IRuleCategory> rules = new ArrayList<IRuleCategory>();
		for (IRuleCategory iRuleCategory : IRuleCategory.values()){
			if (iRuleCategory.getRunState()) {
				rules.add(iRuleCategory);
			}
		}
		return rules;
	}
	
	private RuleQueue queue;

	/** 请求单号 **/
	private String applyCode;
	
}
