package com.ctc.credit.kernel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.common.PropertyStrategyWrapper;
import com.ctc.credit.kernel.commoninter.category.CommonInterface;
import com.ctc.credit.kernel.commoninter.category.impl.PyServiceImpl;
import com.ctc.credit.kernel.commoninter.factory.FactoryCreator;
import com.ctc.credit.kernel.commoninter.factory.ServiceFactoryTools;
import com.ctc.credit.kernel.commoninter.factory.impl.PyServiceFactory;
import com.ctc.credit.kernel.constants.PyConstants;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;
import com.ctc.credit.kernel.model.pengyuan.QueryParameterEntity;
import com.ctc.credit.kernel.model.pengyuan.ResultEntity;
import com.ctc.credit.kernel.service.pengyuan.CisArtificialPersonInfoService;
import com.ctc.credit.kernel.service.pengyuan.CisCropExtendInfoService;
import com.ctc.credit.kernel.service.pengyuan.CisTelCheckInfoService;
import com.ctc.credit.kernel.util.DateUtil;
import com.ctc.credit.sys.sysconfig.service.ConfigEntityService;

/**
 * 鹏元对外接口controller类
 * 
 * @author sunny
 * 
 */
@Controller
@RequestMapping(value = "/service/py")
public class PyServiceConstroller {

	private static Logger logger = Logger.getLogger(PyServiceConstroller.class);

	@Resource
	ConfigEntityService configEntityService;

	@Resource
	CisCropExtendInfoService cisCropExtendInfoService;

	@Resource
	CisArtificialPersonInfoService cisArtificialPersonInfoService;

	@Resource
	CisTelCheckInfoService cisTelCheckInfoService;

	/**
	 * 鹏元电话查询接口
	 * 
	 * @param paras
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryCorpTelInfos.action", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject queryCorpTelInfos(
			@RequestBody QueryConditionEntity queryConditionEntity){
		long start = System.currentTimeMillis();
		ResultEntity resultEntity = parametersVerify(queryConditionEntity);
		try {
			if (PyConstants.PY_RECODE_003.equals(resultEntity.getReturnCode())) {// 如果参数不完整直接返回结果不做任何查询
				return JSONObject.fromObject(resultEntity);
			}
			queryDatas(queryConditionEntity, resultEntity);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		if(null==resultEntity.getReturnData())
			resultEntity.setReturnData(new JSONArray());
		logger.info("鹏元电话查询，总耗时：" + (System.currentTimeMillis() - start));
		System.out.println("鹏元电话查询，总耗时：" + (System.currentTimeMillis() - start));
		return JSONObject.fromObject(resultEntity);
	}

	/**
	 * 鹏元法人核查查询接口
	 * 
	 * @param paras
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryArtificialPersonInfos.action", method = RequestMethod.POST)
	public @ResponseBody
	JSONObject queryArtificialPersonInfos(
			@RequestBody QueryConditionEntity queryConditionEntity)
			throws Exception {
		ResultEntity resultEntity = parametersVerify(queryConditionEntity);
		if (PyConstants.PY_RECODE_003.equals(resultEntity.getReturnCode())) {// 如果参数不完整直接返回结果不做任何查询
			return JSONObject.fromObject(resultEntity);
		}
		queryDatas(queryConditionEntity, resultEntity);
		if(null==resultEntity.getReturnData())
			resultEntity.setReturnData(new JSONArray());
		return JSONObject.fromObject(resultEntity);
	}

	/**
	 * 请求参数检查
	 * 
	 * @param queryConditionEntity
	 * @return
	 */
	private ResultEntity parametersVerify(
			QueryConditionEntity queryConditionEntity) {
		ResultEntity resultEntity = new ResultEntity();
		if (null != queryConditionEntity) {
			String queryType = queryConditionEntity.getQueryType();
			String querySource = queryConditionEntity.getQuerySource();
			QueryParameterEntity queryParameterEntity = queryConditionEntity
					.getQueryParas();
			if (StringUtils.isEmpty(queryType)) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP1);
				return resultEntity;
			}
			if (StringUtils.isEmpty(querySource)) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP2);
				return resultEntity;
			}
			if (null == queryParameterEntity) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3);
				return resultEntity;
			}
			if (StringUtils.isEmpty(queryParameterEntity.getSendCode())) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_1);
				return resultEntity;
			}
			if (StringUtils.isEmpty(queryParameterEntity.getApplyNo())) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_2);
				return resultEntity;
			}
			if (PyConstants.PY_QUERYTYPE_90035.equals(queryType)) {
				if (StringUtils.isEmpty(queryParameterEntity.getCorpName())) {
					resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
					resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_3);
					return resultEntity;
				}
			}
			if (PyConstants.PY_QUERYTYPE_21603.equals(queryType)) {
				if (StringUtils.isEmpty(queryParameterEntity.getTelephone())) {
					resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
					resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_4);
					return resultEntity;
				}
			}
			if (PyConstants.PY_QUERYTYPE_21303.equals(queryType)) {
				if (StringUtils.isEmpty(queryParameterEntity.getIdType())) {
					resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
					resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_5);
					return resultEntity;
				}
				if (StringUtils.isEmpty(queryParameterEntity.getPersonName())) {
					resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
					resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_6);
					return resultEntity;
				}
				if (StringUtils.isEmpty(queryParameterEntity.getIdNumber())) {
					resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
					resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_7);
					return resultEntity;
				}
			}
		}
		return resultEntity;
	}

	/**
	 * 根据查询条件查询数据
	 * 
	 * @param queryConditionEntity
	 * @return
	 */
	private void queryDatas(QueryConditionEntity queryConditionEntity,
			ResultEntity resultEntity) {
		String queryFlag = configEntityService
				.queryConfigValueByKey(PyConstants.PY_QUERY_FLAG);// 0 是local
																	// 1是remote
																	// 2 是正常
		if (StringUtils.isEmpty(queryFlag)) {
			queryFlag = PyConstants.PY_QUERY_STATUS_NORMAL;
		}
		String queryType = queryConditionEntity.getQueryType();
		String maxDate = null;
		String timeoutDays = "";
		QueryParameterEntity queryParameterEntity = queryConditionEntity
				.getQueryParas();
		if (PyConstants.PY_QUERYTYPE_90035.equals(queryType)) {
			String corpName = queryParameterEntity.getCorpName();
			maxDate = cisCropExtendInfoService.queryMaxDateFromLocal(corpName);
			timeoutDays = configEntityService
					.queryConfigValueByKey(PyConstants.PY90035_QUERY_DAYS);
		} else if (PyConstants.PY_QUERYTYPE_21603.equals(queryType)) {
			String telephone = queryParameterEntity.getTelephone();
			maxDate = cisTelCheckInfoService.queryMaxDateFromLocal(telephone);
			timeoutDays = configEntityService
					.queryConfigValueByKey(PyConstants.PY21603_QUERY_DAYS);
		} else if (PyConstants.PY_QUERYTYPE_21303.equals(queryType)) {
			String idType = queryParameterEntity.getIdType();
			String personName = queryParameterEntity.getPersonName();
			String idNumber = queryParameterEntity.getIdNumber();
			maxDate = cisArtificialPersonInfoService.queryMaxDateFromLocal(
					idType, personName, idNumber);
			timeoutDays = configEntityService
					.queryConfigValueByKey(PyConstants.PY21303_QUERY_DAYS);

		} else {
			resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
			resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_8);
			return;
		}
		if (PyConstants.PY_QUERY_STATUS_REMOTE.equals(queryFlag)) {
			queryPyRemoteWithException(queryConditionEntity, resultEntity);
		} else if (PyConstants.PY_QUERY_STATUS_LOCAL.equals(queryFlag)) {
			queryPyLocalWithException(queryConditionEntity, resultEntity,
					maxDate);
		} else {
			if (ifQueryRemote(maxDate, timeoutDays))
				queryPyRemoteWithException(queryConditionEntity, resultEntity);
			else
				queryPyLocalWithException(queryConditionEntity, resultEntity,
						maxDate);
		}
	}

	/**
	 * 查询鹏元远端数据 异常处理
	 * 
	 * @param queryConditionEntity
	 * @param resultEntity
	 */
	private void queryPyRemoteWithException(
			QueryConditionEntity queryConditionEntity, ResultEntity resultEntity) {
		try {
			JSONObject returnJsonObject = queryRemotePyInfos(
					PyServiceFactory.BEAN_NAME, PyServiceImpl.BEAN_NAME,
					queryConditionEntity, resultEntity);
			if (null != returnJsonObject) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP4);
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("查询鹏元数据出错！" + e.getMessage());
			resultEntity.setReturnCode(PyConstants.PY_RECODE_006);
			resultEntity.setReturnMsg("查询鹏元数据出错");
		}
	}

	/**
	 * 查询鹏元Local数据 异常处理
	 * 
	 * @param queryConditionEntity
	 * @param resultEntity
	 * @param maxDate
	 */
	private void queryPyLocalWithException(
			QueryConditionEntity queryConditionEntity,
			ResultEntity resultEntity, String maxDate) {
		try {
			queryLocalInfos(queryConditionEntity, resultEntity, maxDate);
		} catch (Exception e) {
			logger.error("查询鹏元本地数据出错！" + e.getMessage());
			resultEntity.setReturnCode(PyConstants.PY_RECODE_006);
			resultEntity.setReturnMsg("查询鹏元本地数据出错");
		}
	}

	/**
	 * 是否查询远端数据
	 * 
	 * @param maxDate
	 * @param days
	 * @return
	 */
	private Boolean ifQueryRemote(String maxDate, String days) {
		if (null == maxDate) {
			return true;
		}
		int configDys = 0;
		if (StringUtils.isEmpty(days)) {
			return false;
		} else {
			configDys = Integer.parseInt(days);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date mdate;
		try {
			mdate = sdf.parse(maxDate);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return false;
		}
		int dys = calculateDaysBetween(new Date(), mdate);
		if (dys > configDys)
			return true;
		return false;
	}

	/**
	 * 从本地查询数据
	 * 
	 * @param queryConditionEntity
	 * @return
	 * @throws Exception
	 */
	private void queryLocalInfos(QueryConditionEntity queryConditionEntity,
			ResultEntity resultEntity, String maxDate) throws Exception {
		String queryType = queryConditionEntity.getQueryType();
		QueryParameterEntity parameterEntity = queryConditionEntity
				.getQueryParas();
		if (PyConstants.PY_QUERYTYPE_90035.equals(queryType)) {
			String batchNo = cisCropExtendInfoService.queryBatchNoByDate(
					maxDate, parameterEntity.getCorpName());
			List<CisCropExtendInfo> cisCropExtendInfos = cisCropExtendInfoService
					.queryCropExtendInfoByBatchNo(batchNo);
			if (cisCropExtendInfos.size() > 0) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisCropExtendInfos));
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP4_1);
			}
		} else if (PyConstants.PY_QUERYTYPE_21603.equals(queryType)) {
			String batchNo = cisTelCheckInfoService.queryBatchNoByDate(maxDate,
					parameterEntity.getTelephone());
			List<CisTelCheckInfo> cisTelCheckInfos = cisTelCheckInfoService
					.queryTelCheckInfoByBatchNo(batchNo);
			if (cisTelCheckInfos.size()>0) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisTelCheckInfos));
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP4_1);
			}
		} else if (PyConstants.PY_QUERYTYPE_21303.equals(queryType)) {
			String batchNo = cisArtificialPersonInfoService.queryBatchNoByDate(
					maxDate, parameterEntity.getIdType(),
					parameterEntity.getPersonName(),
					parameterEntity.getIdNumber());
			List<CisArtificialPersonInfo> cisArtificialPersonInfos = cisArtificialPersonInfoService
					.queryArtificialPersonInfoByBatchNo(batchNo);
			if (cisArtificialPersonInfos.size() > 0) {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisArtificialPersonInfos));
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP4_1);
			}
		} else {
			resultEntity.setReturnCode(PyConstants.PY_RECODE_003);
			resultEntity.setReturnMsg(PyConstants.PY_REMSG_TP3_8);
		}
	}

	/**
	 * 调用鹏元接口
	 * 
	 * @param factoryBeanName
	 * @param serviceImplBeanName
	 * @return
	 */
	private JSONObject queryRemotePyInfos(String factoryBeanName,
			String serviceImplBeanName,
			QueryConditionEntity queryConditionEntity, ResultEntity resultEntity)
			throws Exception {
		
		FactoryCreator factoryCreator = ServiceFactoryTools
				.getServiceCreateFactory(factoryBeanName);
		
		CommonInterface commonInterface = factoryCreator.createPyService(
				serviceImplBeanName);
		JSONObject jsonObject = commonInterface.executeService(resultEntity,queryConditionEntity);
		
		
		if (PyConstants.PY_RECODE_001.equals(resultEntity.getReturnCode()))
			crateReturnData(queryConditionEntity, jsonObject, resultEntity);
		
		return jsonObject;
	}

	/**
	 * 计算两个日期间的天数
	 * 
	 * @param smallDate
	 * @param bigDate
	 * @return
	 */
	private int calculateDaysBetween(Date smallDate, Date bigDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(smallDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l1 = c.getTimeInMillis();

		c.setTime(bigDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l2 = c.getTimeInMillis();

		long betweenDays = (l2 - l1) / (1000 * 60 * 60 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}

	private void crateReturnData(QueryConditionEntity queryConditionEntity,
			JSONObject jsonObject, ResultEntity resultEntity) {
		QueryParameterEntity queryParameterEntity = queryConditionEntity.getQueryParas();
		String batchNo = queryParameterEntity.getSendCode();
		String queryType = queryConditionEntity.getQueryType();
		String createDate  = DateUtil.getDateTime("yyyyMMddHHmmss", new Date());
		if (queryType.equals(PyConstants.PY_QUERYTYPE_90035)) {
			List<CisCropExtendInfo> cisCropExtendInfos = new ArrayList<CisCropExtendInfo>();
			JSONArray jsonArray = (JSONArray) jsonObject
					.get("manageContactInfosList");
			if (null != jsonArray) {
				for (Object jsonOb : jsonArray) {
					JSONObject jsonObject2 = (JSONObject) jsonOb;
					CisCropExtendInfo a = (CisCropExtendInfo) getBean(
							jsonObject2, CisCropExtendInfo.class);
					a.setCorpName(queryParameterEntity.getCorpName());
					a.setBatchNo(batchNo);
					a.setCreationDate(createDate);
					cisCropExtendInfos.add(a);
				}
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisCropExtendInfos));
				return;
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				return;
			}
		} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21603)) {
			JSONArray jsonArray = (JSONArray) jsonObject.get("telCheckInfos");
			List<CisTelCheckInfo> cisTelCheckInfos = new ArrayList<CisTelCheckInfo>();
			if (null != jsonArray) {
				for (Object jsonOb : jsonArray) {
					JSONObject jsonObject2 = (JSONObject) jsonOb;
					CisTelCheckInfo cisTelCheckInfo = (CisTelCheckInfo) getBean(
							jsonObject2, CisTelCheckInfo.class);
					cisTelCheckInfo.setTelePhone(queryParameterEntity.getTelephone());
					cisTelCheckInfo.setBatchNo(batchNo);
					cisTelCheckInfo.setCreationDate(createDate);
					cisTelCheckInfos.add(cisTelCheckInfo);
				}
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisTelCheckInfos));
				return;
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				return;
			}
		} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21303)) {
			List<CisArtificialPersonInfo> cisArtificialPersonInfos = new ArrayList<CisArtificialPersonInfo>();
			JSONArray jsonArray = (JSONArray) jsonObject
					.get("artificialNationalInfoList");
			if (null != jsonArray) {
				for (Object jsonOb : jsonArray) {
					JSONObject jsonObject2 = (JSONObject) jsonOb;
					CisArtificialPersonInfo a = (CisArtificialPersonInfo) getBean(
							jsonObject2, CisArtificialPersonInfo.class);
					a.setBatchNo(batchNo);
					a.setIdType(queryParameterEntity.getIdType());
					a.setIdNumber(queryParameterEntity.getIdNumber());
					a.setPersonName(queryParameterEntity.getPersonName());
					a.setCreationDate(createDate);
					cisArtificialPersonInfos.add(a);
				}
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				resultEntity.setReturnData(JSONArray
						.fromObject(cisArtificialPersonInfos));
				return;
			} else {
				resultEntity.setReturnCode(PyConstants.PY_RECODE_002);
				return;
			}
		}
	}

	private <T> Object getBean(JSONObject jsonObject, Class<T> clazz) {
		// 声明JsonConfig对象
		JsonConfig cfg = new JsonConfig();
		// 设置属性包装器
		cfg.setPropertySetStrategy(new PropertyStrategyWrapper(
				PropertySetStrategy.DEFAULT));
		// 设置要转换成的JavaBean
		cfg.setRootClass(clazz);
		// 转换
		Object object = JSONObject.toBean(jsonObject, cfg);
		return object;
	}
}