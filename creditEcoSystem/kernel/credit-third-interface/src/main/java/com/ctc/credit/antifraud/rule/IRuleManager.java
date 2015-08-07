package com.ctc.credit.antifraud.rule;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;


/**
 * 规则运行管理类
 * 
 * @author sunny
 *
 */
public interface IRuleManager {

	/**
	 * 执行规则
	 * 
	 * @param iFact
	 * @return
	 */
	public List<IRuleResult> executeRules(IFact iFact,IRulesFactory iRulesFactory);
	
	/**
	 * 执行规则批量接口
	 * 
	 * @param iFact
	 * @return
	 */
	public List<IRuleResult> executeRules(IFact iFact,IRulesFactory iRulesFactory,ThreadPoolExecutor threadPool);
}
