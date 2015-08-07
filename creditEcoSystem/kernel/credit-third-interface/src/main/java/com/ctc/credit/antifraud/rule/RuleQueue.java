package com.ctc.credit.antifraud.rule;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.ctc.credit.antifraud.rule.contant.IRuleCategory;

/**
 * 请求阻塞队列
 * 
 * @author sunny
 *
 */
public class RuleQueue extends LinkedBlockingQueue<IRuleCategory> {

	
	private static final long serialVersionUID = -8360576469811036868L;
	
	private static final long WAIT_TIME_PUT = 2; 
	private static final long WAIT_TIME_GET = 2; 

	public RuleQueue() {
		super();
	}
	
	/**
	 * 将规则信息放入请求队列
	 * 
	 * @param applyInfo
	 * @throws InterruptedException
	 */
	public void putRule(IRuleCategory ruleInfo) throws InterruptedException{
		this.offer(ruleInfo,WAIT_TIME_PUT,TimeUnit.SECONDS);
	}
	
	/**
	 * 从规则队列中获取请求信息
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public IRuleCategory getRule() throws InterruptedException{
		return this.poll(WAIT_TIME_GET, TimeUnit.SECONDS);
	}

}
