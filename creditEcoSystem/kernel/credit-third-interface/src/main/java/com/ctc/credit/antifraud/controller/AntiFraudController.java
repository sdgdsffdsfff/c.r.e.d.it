package com.ctc.credit.antifraud.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.jms.Destination;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.antifraud.model.AntiFraudRequestAndReponse;
import com.ctc.credit.antifraud.model.AsyncFraudResult;
import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.FraudQueryCondition;
import com.ctc.credit.antifraud.model.FraudResult;
import com.ctc.credit.antifraud.model.HistApplyInfo;
import com.ctc.credit.antifraud.model.HistContactInfo;
import com.ctc.credit.antifraud.model.HistCustomerInfo;
import com.ctc.credit.antifraud.model.RuleInfo;
import com.ctc.credit.antifraud.model.SimpleFraudQueryCondition;
import com.ctc.credit.antifraud.rule.IFact;
import com.ctc.credit.antifraud.rule.IRuleManager;
import com.ctc.credit.antifraud.rule.IRuleResult;
import com.ctc.credit.antifraud.rule.IRulesFactory;
import com.ctc.credit.antifraud.rule.impl.IRuleManagerImpl;
import com.ctc.credit.antifraud.service.AntiFraudApplyService;
import com.ctc.credit.antifraud.service.ContactsInfoService;
import com.ctc.credit.antifraud.service.CustomerInfoService;
import com.ctc.credit.common.EntityParse;
import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.jms.service.ProducerService;
import com.ctc.credit.kernel.util.BeanUtil;


/**
 * 反欺诈对外接口controller类
 * 
 * @author sunny
 * 
 */
@Controller
@RequestMapping(value = "/service/antifraud")
public class AntiFraudController {

	private static Logger logger = Logger.getLogger(AntiFraudController.class);
	
	@Autowired
	private AntiFraudApplyService antiFraudApplyService; 
	
	@Autowired
	private IRulesFactory iRulesFactory;
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	CustomerInfoService customerInfoService;
	
	@Autowired
	ContactsInfoService contactsInfoService;
	
	@Resource(name="antiFraudQueueDestination")
	private Destination destination;
	
	/**
	 * 反欺诈实时接口</br>
	 * 对应接口文档反欺诈数据请求接口A
	 * 
	 * @param customerInfo
	 * @return
	 */
	@RequestMapping(value = "/queryantifraud.action", method = RequestMethod.POST)
	public @ResponseBody JSONObject queryAntiFraud(@RequestBody String queryJson){
		long begin = System.currentTimeMillis();
		AntiFraudRequestAndReponse andReponse = new AntiFraudRequestAndReponse();
		FraudResult fraudResult = new FraudResult();
		FraudQueryCondition queryCondition = null;
		try {
			queryCondition = EntityParse.parseFraudQueryEntity(queryJson);
		} catch (JSONException e1) {
			fraudResult.setResultStatus("2");
			andReponse.setReponseCode("2");
			andReponse.setReponseMsg(e1.getMessage());
			fraudResult.setResultMsg(e1.getMessage());
			e1.printStackTrace();
			e1.printStackTrace();
		}
		String applyCode = queryCondition.getApplyCode();
		queryInfoInit(andReponse, queryCondition);
		logger.info("###### 申请单号："+applyCode+"请求反欺诈开始！");
		if (null==applyCode) {
			fraudResult.setResultMsg("0");
			fraudResult.setResultMsg("申请单号不能为空");
			andReponse.setReponseCode("0");
			andReponse.setReponseMsg("申请单号不能为空");
		}else {
			fraudResult.setApplyCode(applyCode);
			IFact ifact = new IFact(queryCondition.getCustomerInfo(), applyCode, queryCondition.getContactsInfo());
			List<IRuleResult> iRuleResults = null;
			IRuleManager iRuleManager = new IRuleManagerImpl();
			try {
				iRuleResults = iRuleManager.executeRules(ifact,iRulesFactory);
			} catch (Exception e) {
				logger.error("###### 申请单号："+applyCode+"规则执行失败！",e);
				fraudResult.setResultStatus("2");
				andReponse.setReponseCode("2");
				andReponse.setReponseMsg(e.getMessage());
				fraudResult.setResultMsg(e.getMessage());
				e.printStackTrace();
			}
			createResult(iRuleResults,fraudResult,andReponse);
			try {
				antiFraudApplyService.save(andReponse);
			} catch (Exception e) {
				logger.error("###### 规则编号："+applyCode+"规则执行信息保存失败！",e);
				e.printStackTrace();
			}
		}
		JSONObject reponseJson = JSONObject.fromObject(fraudResult);
		logger.info("###### 申请单号："+applyCode+"共耗时："+(System.currentTimeMillis()-begin));
		logger.info("###### 申请单号："+applyCode+"请求反欺诈结束");
		return reponseJson;
	}
	
	/**
	 * 异步查询接口</br>
	 * 对应接口文档反欺诈数据请求接口B
	 * 
	 * asyncFraudResult.setResult 0-失败；1-成功；2-异常
	 * 
	 * @param customerInfo
	 * @return
	 */
	@RequestMapping(value = "/queryantifraudasync.action", method = RequestMethod.POST)
	public @ResponseBody JSONObject queryAntiFraudAsync(@RequestBody String queryJson){
		long begin = System.currentTimeMillis();
		AntiFraudRequestAndReponse andReponse = new AntiFraudRequestAndReponse();
		FraudResult fraudResult = new FraudResult();
		FraudQueryCondition queryCondition = null;
		try {
			queryCondition = EntityParse.parseFraudQueryEntity(queryJson);
		} catch (JSONException e1) {
			fraudResult.setResultStatus("2");
			andReponse.setReponseCode("2");
			andReponse.setReponseMsg(e1.getMessage());
			fraudResult.setResultMsg(e1.getMessage());
			e1.printStackTrace();
			e1.printStackTrace();
		}
		AsyncFraudResult asyncFraudResult = new AsyncFraudResult();
		queryInfoInit(andReponse, queryCondition);
		String applyCode = queryCondition.getApplyCode();
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【异步】接口开始！");
		if (null==applyCode) {
			asyncFraudResult.setResult("0");
			asyncFraudResult.setMessage("申请单号不能为空");
			andReponse.setReponseCode("0");
			andReponse.setReponseMsg("申请单号不能为空");
		}else {
			asyncFraudResult.setApplyCode(applyCode);
			try {
				producerService.sendMessage(destination, JSONObject.fromObject(queryCondition).toString());
				andReponse.setQueryType("1");
				asyncFraudResult.setResult("1");
				andReponse.setReponseCode("1");
			} catch (Exception e) {
				logger.error("###### 申请单号："+applyCode+"反欺诈批量接口保存失败！",e);
				e.printStackTrace();
				asyncFraudResult.setResult("2");
				asyncFraudResult.setMessage(e.getMessage());
				andReponse.setReponseCode("2");
				andReponse.setReponseMsg(e.getMessage());
			}
			try {
				antiFraudApplyService.save(andReponse);
			} catch (Exception e) {
				logger.error("###### 规则编号："+applyCode+"规则执行信息保存失败！",e);
				e.printStackTrace();
			}
		}
		logger.info("###### 申请单号："+applyCode+"共耗时："+(System.currentTimeMillis()-begin));
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【异步】接口结束");
		return JSONObject.fromObject(asyncFraudResult);
	}
	
	/**
	 * 异步结果查询接口</br>
	 * 对应接口文档反欺诈数据请求接口C
	 * 
	 * @param customerInfo
	 * @return
	 */
	@RequestMapping(value = "/getantifraudresult.action", method = RequestMethod.POST)
	public @ResponseBody JSONObject getAntiFraudResult(@RequestBody SimpleFraudQueryCondition queryCondition){
		//获取结果
		long begin = System.currentTimeMillis();
		String applyCode = queryCondition.getApplyCode();
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【异步数据】接口开始！");
		AntiFraudRequestAndReponse andReponse = null;
		JSONObject returnJson = null;
		FraudResult fraudResult = new FraudResult();
		try {
			andReponse = antiFraudApplyService.queryAntiFraudAsyncInfo(applyCode , "1");
			andReponse.setReponseCode("1");
			antiFraudApplyService.update(andReponse);
			returnJson = null;
		} catch (Exception e) {
			logger.error("###### 规则编号："+applyCode+"请求反欺诈【异步数据】接口失败",e);
			e.printStackTrace();
			fraudResult.setResultStatus("2");
			fraudResult.setResultMsg("请求反欺诈【异步数据】接口失败，失败原因："+e.getMessage());
		}
		if (null!=andReponse) {
			returnJson = JSONObject.fromObject(andReponse.getReponseJson());
		}else if (null==andReponse) {
			returnJson = JSONObject.fromObject(fraudResult);
		}
		logger.info("###### 申请单号："+applyCode+"相应结果："+returnJson);
		logger.info("###### 申请单号："+applyCode+"共耗时："+(System.currentTimeMillis()-begin));
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【异步数据】接口结束");
		return returnJson;
	}
	
	/**
	 * 异步结果查询接口</br>
	 * 对应接口文档反欺诈数据请求接口D
	 * 
	 * @param queryCondition
	 * @return
	 */
	@RequestMapping(value = "/getfraudhistdata.action", method = RequestMethod.POST)
	public @ResponseBody JSONObject getFraudHistData(@RequestBody SimpleFraudQueryCondition queryCondition){
		//获取结果
		long begin = System.currentTimeMillis();
		String applyCode = queryCondition.getApplyCode();
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【历史数据】接口开始！");
		String sourceSys = queryCondition.getSourceSys();
		HistApplyInfo histApplyInfo = new HistApplyInfo();
		queryHistAndCreateRetnData(applyCode,sourceSys,histApplyInfo);
		JSONObject returnJson = JSONObject.fromObject(histApplyInfo);
		logger.info("###### 申请单号："+applyCode+"相应结果："+returnJson);
		logger.info("###### 申请单号："+applyCode+"共耗时："+(System.currentTimeMillis()-begin));
		logger.info("###### 申请单号："+applyCode+"请求反欺诈【历史数据】接口结束");
		return returnJson;
	}
	
	/**
	 * 查询历史并且创建返回数据对象
	 * 
	 * @param applyCode
	 * @param sourceSys
	 * @param histApplyInfo
	 */
	private void queryHistAndCreateRetnData(String applyCode,String sourceSys,HistApplyInfo histApplyInfo){
		histApplyInfo.setApplyCode(applyCode);
		histApplyInfo.setSourceSys(sourceSys);
		CustomerInfo histCustomerInfo = null;
		HistCustomerInfo histCustomerInfoRe = null;//待返回数据
		List<ContactsInfo> histContactsInfos = null;
		List<HistContactInfo> histContactInfosRe = new ArrayList<HistContactInfo>();//待返回数据
		
		try {//查询历史客户信息
			histCustomerInfo = customerInfoService.queryHistCustomerInfo(applyCode, sourceSys);
		} catch (Exception e) {
			histApplyInfo.setResultStatus(HistApplyInfo.EXCEPTION);
			histApplyInfo.setResultMsg(HistApplyInfo.EXCPT_MSG_DBERROR);
			logger.error("###### 规则编号："+applyCode+"请求反欺诈【历史数据】接口失败，失败原因：",e);
			e.printStackTrace();
		}
		try {//查询历史联系人信息
			histContactsInfos = contactsInfoService.queryHistContactInfo(applyCode, sourceSys);
		} catch (Exception e) {
			histApplyInfo.setResultStatus(HistApplyInfo.EXCEPTION);
			histApplyInfo.setResultMsg(HistApplyInfo.EXCPT_MSG_DBERROR);
			logger.error("###### 规则编号："+applyCode+"请求反欺诈【历史数据】接口失败，失败原因：",e);
			e.printStackTrace();
		}
		Boolean hasData = true;
		Boolean hasData2 = true;
		try {
			if (null!=histCustomerInfo) {
				histCustomerInfoRe = new HistCustomerInfo();
				transCustomerInfoToHist(histCustomerInfo,histCustomerInfoRe);
				histApplyInfo.setCustomerInfo(histCustomerInfoRe);
			}else {
				hasData  = false;
			}
			
			if (null!=histContactsInfos&&histContactsInfos.size()>0) {
				transContactInfoToHist(histContactsInfos,histContactInfosRe);
				histApplyInfo.setContactInfo(histContactInfosRe);
			}else {
				hasData2  = false;
			}
		} catch (Exception e) {
			histApplyInfo.setResultStatus(HistApplyInfo.EXCEPTION);
			histApplyInfo.setResultMsg(HistApplyInfo.EXCPT_MSG_HANDLE_ERROR);
			logger.error("###### 规则编号："+applyCode+"请求反欺诈【历史数据】接口失败，失败原因：返回参数对象转换失败，",e);
			e.printStackTrace();
		}

		if (!hasData&&!hasData2) {
			histApplyInfo.setResultStatus(HistApplyInfo.NO_DATA);
			histApplyInfo.setResultMsg(HistApplyInfo.NODATA_MSG);
		}
	}
	
	/**
	 * 转换联系人信息对象为返回对象
	 * 
	 * @param histContactsInfos
	 * @param histContactInfosRe
	 * @throws Exception 
	 */
	private void transContactInfoToHist(List<ContactsInfo> histContactsInfos,
			List<HistContactInfo> histContactInfosRe) throws Exception{
		for (ContactsInfo histContactInfo : histContactsInfos) {
			HistContactInfo histContactInfo2 = new HistContactInfo();
			BeanUtil.beanCopyByTarget(histContactInfo, histContactInfo2);
			histContactInfosRe.add(histContactInfo2);
		}
	}

	/**
	 * 转换客户信息对象为返回对象
	 * 
	 * @param customerInfo
	 * @param customerInfoRe
	 * @throws Exception 
	 */
	private void transCustomerInfoToHist(CustomerInfo customerInfo,
			HistCustomerInfo customerInfoRe) throws Exception {
		BeanUtil.beanCopyByTarget(customerInfo, customerInfoRe);
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
					ruleInfo.setRuleType(iRuleResult.getiRuleCategory().getRuleType().getValue());
					ruleInfo.setRuleDesc(iRuleResult.getiRuleCategory().getRuleDesc());
					ruleInfo.setHitHist(iRuleResult.getHitApplyCodes());
					fraudResult.getHitRules().add(ruleInfo);
				}
			}
			andReponse.setReponseJson(JSONObject.fromObject(fraudResult).toString());
		}
	}

	/**
	 * 保存请求信息
	 * 
	 * @param andReponse
	 * @param queryCondition
	 */
	public void queryInfoInit(AntiFraudRequestAndReponse andReponse,FraudQueryCondition queryCondition){
		andReponse.setApplyCode(queryCondition.getApplyCode());
		andReponse.setName(queryCondition.getCustomerInfo().getName());
		andReponse.setIdCard(queryCondition.getCustomerInfo().getIdcard());
		andReponse.setCreateDate(new Date());
		andReponse.setCreateUser(ConfigsContant.DEFAULT_USER);
		andReponse.setQueryType(queryCondition.getQueryType());
		andReponse.setSourceSys(queryCondition.getSourceSys());
		JSONObject jsonObject = JSONObject.fromObject(queryCondition);
		andReponse.setRequestJson(jsonObject.toString());
	}
	
}
