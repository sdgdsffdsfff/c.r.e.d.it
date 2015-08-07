package com.ctc.credit.antifraud.rule;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;

import org.apache.log4j.Logger;

import com.ctc.credit.antifraud.annotation.RuleConfig;
import com.ctc.credit.antifraud.rule.contant.IRuleCategory;
import com.ctc.credit.antifraud.rule.contant.IRuleContant;

/**
 * 规则执行者
 * 
 * @author sunny
 *
 */
public class RuleConsumer implements Runnable{
	
	private static Logger logger = Logger.getLogger(RuleConsumer.class);
	
	public RuleConsumer(RuleQueue queue,Lock lock,Map<String,Boolean> flg,List<IRuleResult> result,String applyCode,IRulesFactory iRulesFactory,IFact iFact) {
        this.queue = queue;
        this.lock = lock;
        this.flg = flg;
        this.result = result;
        this.applyCode = applyCode;
        this.iRulesFactory = iRulesFactory;
        this.iFact = iFact;
    }
 
	@Override
	public void run() {
		logger.debug("消费者线程执行规则开始。。");
		IRuleResult iRuleResult = null;
		Boolean isRuning= true;
		while (isRuning) {
			 try {
				 	logger.debug("正从队列获取规则信息...");
			        int taskCount = queue.size();
			        logger.debug("###### 当前队列待处理规则还有： " + taskCount);
			        IRuleCategory data = null;
					try {
						data = queue.getRule();
					} catch (Exception e) {
						logger.debug("取任务超时 ，消费者线程准备退出。");
			        	isRuning = false;
					}
					logger.debug("###### data:"+data);
			        if (null!=data) {
			        	String ruleNo = data.getRuleNo();
			            logger.debug("取得规则：" + ruleNo);
			            String ruleMethod = IRuleContant.RULEMETHODPRE_STR+data.getRuleNo();
			            logger.debug("正在执行规则：" + ruleNo);
						iRuleResult = executeRule(iRulesFactory,iFact,ruleMethod);
			            logger.debug("规则：" + ruleNo+" 执行结束。");
			            lock.lock(); 
			            result.add(iRuleResult);
			            flg.put(ruleNo,true);
			        }else if (null==data) {
			        	logger.debug("队列为空 ，消费者线程准备退出。");
			        	isRuning = false;
			        	logger.debug("消费者线程准备退出开始。");
					}
		        } catch (Exception e) {
		        	isRuning = false;
		            logger.error("申请单号:"+applyCode+"规则执行失败",e);
		        } finally {
		            try {
						lock.unlock();
					} catch (Exception e) {
						logger.debug("消费者线程不拥有该对象监视器。");
					}
		        }
			 logger.debug("消费者线程执行规则结束。");
		}
		logger.debug("消费者线程退出结束。");
	}
	
	/**
	 * 执行具体规则
	 * @param iRulesFactory
	 * @param methodName
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	private IRuleResult executeRule(IRulesFactory iRulesFactory,IFact iFact,String methodName) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		Method m = IRulesFactory.class.getDeclaredMethod(methodName, IFact.class);
		IRuleResult i = (IRuleResult) m.invoke(iRulesFactory, iFact);
		Annotation[] ans = m.getAnnotations();
		for (Annotation annotation : ans) {
			if (RuleConfig.class.isInstance(annotation)) {
				RuleConfig ruleConfig = (RuleConfig) annotation;
				i.setiRuleCategory(ruleConfig.ruleCategory());
			}
		}
		return i;
	}
	
    private RuleQueue queue;
    private Lock lock;
    private Map<String,Boolean> flg;
    private String applyCode;
    private IRulesFactory iRulesFactory;
    private IFact iFact;
    private List<IRuleResult> result;
    
}