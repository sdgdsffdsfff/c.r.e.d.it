package com.ctc.credit.jms.listener;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.consume.api.dto.FraudReqJson;
import com.ctc.consume.api.service.FraudService;
import com.ctc.credit.antifraud.model.AntiFraudRequestAndReponse;
import com.ctc.credit.antifraud.model.FraudQueryCondition;
import com.ctc.credit.antifraud.model.FraudResult;
import com.ctc.credit.antifraud.model.RuleInfo;
import com.ctc.credit.antifraud.rule.IFact;
import com.ctc.credit.antifraud.rule.IRuleManager;
import com.ctc.credit.antifraud.rule.IRuleResult;
import com.ctc.credit.antifraud.rule.IRulesFactory;
import com.ctc.credit.antifraud.rule.impl.IRuleManagerImpl;
import com.ctc.credit.antifraud.service.AntiFraudApplyService;
import com.ctc.credit.common.EntityParse;
import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.jms.service.impl.ProducerServiceImpl;
import com.ctc.credit.kernel.util.hessian.HessianUtil;

/**
 * 反欺诈异步处理监听器
 * 
 * @author sunny
 *
 */
@Component
public class BatchAntiFraudMessageListener implements MessageListener {
	
	private static Logger logger = Logger.getLogger(ProducerServiceImpl.class);
	
	private final static int batchThreadpoolnum = 8;
	private final static ThreadPoolExecutor batchthreadPool = (ThreadPoolExecutor)Executors.newFixedThreadPool(batchThreadpoolnum) ;
	
	@Autowired
	private IRulesFactory iRulesFactory;
	
	@Autowired
	private AntiFraudApplyService antiFraudApplyService; 
	
	@Override
	public void onMessage(Message message) {
		logger.info("----------------反欺诈异步处理数据开始----------------");  
		TextMessage textMsg = (TextMessage) message;  
        try {  
        	String content = textMsg.getText();
        	process(content);
        	logger.info("消息内容是：" + content);  
        } catch (JMSException e) {
            e.printStackTrace(); 
            logger.error("消息处理失败", e);
            throw new RuntimeException("消息处理失败，失败原因："+e.getMessage());
        } 
        logger.info("----------------反欺诈异步处理数据结束----------------");  
	}

	/**
	 * 消息处理
	 * 
	 * @param content
	 */
	private void process(String content) throws JMSException{
		FraudQueryCondition queryCondition = EntityParse.parseFraudQueryEntity(content);
		long begin = System.currentTimeMillis();
		FraudResult fraudResult = new FraudResult();
		String applyCode = queryCondition.getApplyCode();
		logger.info("###### 申请单号："+applyCode+"异步处理反欺诈开始！");
		fraudResult.setApplyCode(applyCode);
		IFact ifact = new IFact(queryCondition.getCustomerInfo(), applyCode, queryCondition.getContactsInfo());
		List<IRuleResult> iRuleResults = null;
		IRuleManager iRuleManager = new IRuleManagerImpl();
		AntiFraudRequestAndReponse andReponse = antiFraudApplyService.queryAntiFraudAsyncInfo(applyCode, "1");
		if (null!=andReponse) {
			try {
				try {
					iRuleResults = iRuleManager.executeRules(ifact,iRulesFactory,batchthreadPool);
				} catch (Exception e) {
					logger.error("###### 申请单号："+applyCode+"规则执行失败！",e);
					fraudResult.setResultStatus("2");
					andReponse .setReponseCode("2");
					andReponse.setReponseMsg(e.getMessage());
					fraudResult.setResultMsg(e.getMessage());
					e.printStackTrace();
					throw new JMSException("###### 申请单号："+applyCode+"规则执行失败！，反欺诈规则稍后会重跑！");
				}
				createResult(iRuleResults,fraudResult,andReponse);
				logger.info("###### 申请单号："+applyCode+"规则执行结果："+ JSONObject.fromObject(andReponse));
				try {
					antiFraudApplyService.update(andReponse);
				} catch (Exception e) {
					logger.error("###### 申请单号："+applyCode+"规则执行信息保存失败！",e);
					e.printStackTrace();
					throw new JMSException("###### 申请单号："+applyCode+"规则执行信息保存失败！");
				}
			} catch (Exception e) {
				fraudResult.setResultStatus("2");
				logger.error("###### 申请单号："+applyCode+"反欺诈规则执行失败！",e);
				e.printStackTrace();
			}
			try {
				//回调调用方接口，回取数据
				if ("0".equals(fraudResult.getResultStatus())) {
					sendMsg(queryCondition.getSourceSys(),applyCode,"4444");
				}else if ("2".equals(fraudResult.getResultStatus())) {
					sendMsg(queryCondition.getSourceSys(),applyCode,"9999");
				}else {
					sendMsg(queryCondition.getSourceSys(),applyCode,"0000");
				}
			} catch (Exception e) {
				e.printStackTrace();
				logger.error("###### 申请单号："+applyCode+"规则回调调用方失败！",e);
				throw new JMSException("###### 申请单号："+applyCode+"规则回调调用方失败！");
			}
		}
		logger.info("###### 申请单号："+applyCode+"共耗时："+(System.currentTimeMillis()-begin));
		logger.info("###### 申请单号："+applyCode+"请求反欺诈结束");
	}

	
	/**
	 * 创建反欺诈返回结果
	 * 
	 * @param iRuleResults
	 * @param fraudResult
	 */
	private void createResult(List<IRuleResult> iRuleResults,FraudResult fraudResult,AntiFraudRequestAndReponse andReponse) {
		if (null!=iRuleResults) {
			andReponse.setFraudCheckStatus("1");
			for (IRuleResult iRuleResult : iRuleResults) {
				if (iRuleResult.getRuleResult()) {
					fraudResult.setResultStatus("1");
					andReponse.setReponseCode("1");
					RuleInfo ruleInfo = new RuleInfo();
					ruleInfo.setRuleId(iRuleResult.getiRuleCategory().getRuleNo());
					ruleInfo.setRuleDesc(iRuleResult.getiRuleCategory().getRuleDesc());
					ruleInfo.setHitHist(iRuleResult.getHitApplyCodes());
					fraudResult.getHitRules().add(ruleInfo);
				}
			}
			andReponse.setReponseJson(JSONObject.fromObject(fraudResult).toString());
		}
	}
	
	/**
	 * 消息处理完毕通知异步接口调用方，回取数据
	 * 
	 * @param sourceSys
	 * @param applyCode
	 * @param successFlg 0000:查询成功，9999:查询数据失败，4444:未查询到数据）
	 * @throws Exception 
	 */
	private void sendMsg(String sourceSys,String applyCode,String successFlg) throws Exception{
		if (ConfigsContant.SOURCE_SYS_CONSUMLOAN.equals(sourceSys)) {
			//消金通知hessian接口
			FraudService fraudService = HessianUtil.getInterFaceProxy(FraudService.class, ConfigsContant.CONSUM_LOAN_REQ_URL);
			FraudReqJson fraudReqJson = new FraudReqJson();
			fraudReqJson.setApplyCode(applyCode);
			if ("0000".equals(successFlg)) {
				fraudReqJson.setDealDesc("成功");
				fraudReqJson.setDealStatus("0000");
			}else {
				fraudReqJson.setDealDesc("成功");
				fraudReqJson.setDealStatus("0000");
			}
			System.out.println(fraudService.receiveFraud(fraudReqJson));
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BatchAntiFraudMessageListener bth = new BatchAntiFraudMessageListener();
		bth.sendMsg("2", "A10000002", "0000");
	}
}
