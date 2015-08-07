package com.ctc.credit.antifraud.rule.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.collections.map.HashedMap;
import org.apache.log4j.Logger;

import com.ctc.credit.antifraud.rule.IFact;
import com.ctc.credit.antifraud.rule.IRuleManager;
import com.ctc.credit.antifraud.rule.IRuleResult;
import com.ctc.credit.antifraud.rule.IRulesFactory;
import com.ctc.credit.antifraud.rule.RuleConsumer;
import com.ctc.credit.antifraud.rule.RuleProducer;
import com.ctc.credit.antifraud.rule.RuleQueue;
import com.ctc.credit.antifraud.rule.contant.IRuleCategory;

public class IRuleManagerImpl implements IRuleManager {
	
	private static Logger logger = Logger
			.getLogger(IRuleManagerImpl.class);
	
	private ThreadPoolExecutor threadPool;
	private final Lock lock = new ReentrantLock(false);
	/** 固定线程的数量**/
	private static final int num = 9;
	private static List<IRuleCategory> rulesrun;
	private RuleQueue queue = new RuleQueue();
	static{
		List<IRuleCategory> rules = new ArrayList<IRuleCategory>();
		for (IRuleCategory iRuleCategory : IRuleCategory.values()){
			if (iRuleCategory.getRunState()) {
				rules.add(iRuleCategory);
			}
		}
		rulesrun=rules;
	}
	
	/** 请求单号处理情况 **/
	private Map<String,Boolean> ruleCheckFlg = new HashedMap();
	
	private List<IRuleResult> result = new ArrayList<IRuleResult>(rulesrun.size());
	
	@Override
	public List<IRuleResult> executeRules(IFact ifact,IRulesFactory iRulesFactory) {
		long begin = System.currentTimeMillis();
		//规则是否跑完标识初始化
		for (IRuleCategory iRuleCategory : rulesrun) {
			ruleCheckFlg.put(iRuleCategory.getRuleNo(), false);
		}
		initThreadPool();
		String applyCode = ifact.getApplyCode();
		RuleProducer ruleProducer = new RuleProducer(queue, applyCode);
		ruleProducer.product();
		for (int i = 0; i < num; i++) {
			RuleConsumer ruleConsumer = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
			threadPool.submit(ruleConsumer);
		}
		Boolean run = true;
		while (run) {
			logger.debug("申请单号"+applyCode+"等待规则执行结果。。");
			logger.debug(ruleCheckFlg);
			if (checkIfExecuteOver(ruleCheckFlg)) {
				logger.info("申请单号"+applyCode+"执行结束");
				run = false;
			}
		}
		destoryThreadPool(threadPool);
		logger.info("###### 申请单号："+applyCode+"跑完规则共耗时："+(System.currentTimeMillis()-begin));
		return result;
	}
	
	private void destoryThreadPool(ThreadPoolExecutor threadPool) {
		if (null!=threadPool) {
			threadPool.shutdownNow();
			logger.debug("线程池销毁成功！");
		}
	}

	/**
	 * 初始化线程池
	 */
	private void initThreadPool() {
		if (threadPool == null) {
			try {
				threadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(num);
			} catch (Exception e) {
				logger.error("初始化线程池失败！",e);
			}
		}
	}
	
	/**
	 * 判断当前件是否执行完成
	 * 
	 * @param flg
	 * @return
	 */
	public Boolean checkIfExecuteOver(Map<String,Boolean> flg){
		for(Entry<String, Boolean> entry:flg.entrySet()){
			if (!entry.getValue()) {
				return false;
			}
		}
		return true;   
	}

	@Override
	public List<IRuleResult> executeRules(IFact ifact,
			IRulesFactory iRulesFactory, ThreadPoolExecutor threadPool) {
				//规则是否跑完标识初始化
				for (IRuleCategory iRuleCategory : rulesrun) {
					ruleCheckFlg.put(iRuleCategory.getRuleNo(), false);
				}
				initThreadPool();
				String applyCode = ifact.getApplyCode();
				RuleProducer ruleProducer = new RuleProducer(queue, applyCode);
				ruleProducer.product();
				RuleConsumer ruleConsumer1 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer2 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer3 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer4 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer5 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer6 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer7 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				RuleConsumer ruleConsumer8 = new RuleConsumer(queue, lock, ruleCheckFlg, result, applyCode, iRulesFactory, ifact);
				threadPool.submit(ruleConsumer1);
				threadPool.submit(ruleConsumer2);
				threadPool.submit(ruleConsumer3);
				threadPool.submit(ruleConsumer4);
				threadPool.submit(ruleConsumer5);
				threadPool.submit(ruleConsumer6);
				threadPool.submit(ruleConsumer7);
				threadPool.submit(ruleConsumer8);
				Boolean run = true;
				while (run) {
					logger.debug("申请单号"+applyCode+"等待规则执行结果。。");
					logger.debug(ruleCheckFlg);
					if (checkIfExecuteOver(ruleCheckFlg)) {
						logger.info("申请单号"+applyCode+"执行结束");
						run = false;
						return result;
					}
				}
				destoryThreadPool(threadPool);
				return result;
	}

//	public static void main(String[] args) {
//		BitSet flg = new BitSet(ruleNum);
//		for (int i = 0; i < ruleNum; i++) {
//			flg.set(i,false);
//		}
//		System.out.println(flg);
//		if (flg.isEmpty()) {
//			System.out.println("bitSet is empty");
//		}
//		for (int i = 0; i < flg.length(); i++) {
//			System.out.println(flg.get(i));
//		}
//	}
}
