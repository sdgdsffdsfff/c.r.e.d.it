package com.ctc.credit.kernel.commoninter.category.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ctc.credit.api.dto.CreditApplyDto;
import com.ctc.credit.api.service.CreditApiService;
import com.ctc.credit.common.PropertyStrategyWrapper;
import com.ctc.credit.kernel.commoninter.category.AbstractPyService;
import com.ctc.credit.kernel.constants.PyConstants;
import com.ctc.credit.kernel.dao.pengyuan.CisTelCheckInfoDao;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;
import com.ctc.credit.kernel.model.pengyuan.QueryParameterEntity;
import com.ctc.credit.kernel.model.pengyuan.ResultEntity;
import com.ctc.credit.kernel.service.pengyuan.CisArtificialPersonInfoService;
import com.ctc.credit.kernel.service.pengyuan.CisCropExtendInfoService;
import com.ctc.credit.kernel.util.DateUtil;
import com.ctc.credit.sys.sysconfig.service.ConfigEntityService;

@Service(PyServiceImpl.BEAN_NAME)
@Transactional
public class PyServiceImpl extends AbstractPyService {

	public static final String BEAN_NAME = "pyServiceImpl";
	
	private static Logger logger = Logger.getLogger(PyServiceImpl.class);

	@Resource
	ConfigEntityService configEntityService;

	@Resource
	CisCropExtendInfoService cisCropExtendInfoService;

	@Resource
	CisArtificialPersonInfoService cisArtificialPersonInfoService;

	@Resource
	CisTelCheckInfoDao cisTelCheckInfoDao;

	@Override
	public JSONObject executeService(ResultEntity resultEntity,QueryConditionEntity queryConditionEntity) throws Exception {
		long start = System.currentTimeMillis();
		JSONObject returnEntity = null;
		String serviceName = configEntityService
				.queryConfigValueByKey(PyConstants.PY_SERVICE_METHOD_NAME);
		Method method = null;
		try {
			if (StringUtils.isEmpty(serviceName))
				throw new RuntimeException("鹏元参数[PY_SERVICE_NAME]尚未配置，清数据库配置！");
			method = CreditApiService.class.getDeclaredMethod(serviceName,
					CreditApplyDto.class, String.class);
		} catch (NoSuchMethodException e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
		} catch (SecurityException e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
		}
		
		CreditApplyDto applyDto = super.transform(queryConditionEntity);
		String categoryCode = getCategoryCode(queryConditionEntity);
		try {
			returnEntity = (JSONObject) method.invoke(creditApiService,
					applyDto, categoryCode);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		if (null != returnEntity){
			try{
				savePyInfos(queryConditionEntity, returnEntity,resultEntity);
			}catch(Exception ex){
				ex.printStackTrace();
				logger.error(ex.getMessage());
			}
		}
		logger.info("鹏元hessian调用，总耗时：" + (System.currentTimeMillis() - start));
		System.out.println("鹏元hessian调用，总耗时：" + (System.currentTimeMillis() - start));
		return returnEntity;
	}

	/**
	 * 保存鹏元返回的数据
	 * 
	 * @param queryType
	 * @param jsonObject
	 */
	public void savePyInfos(QueryConditionEntity queryConditionEntity, JSONObject jsonObject,ResultEntity resultEntity) {
		QueryParameterEntity queryParameterEntity = queryConditionEntity.getQueryParas();
		String batchNo = queryParameterEntity.getSendCode();
		String queryType = queryConditionEntity.getQueryType();
		String createDate  = DateUtil.getDateTime("yyyyMMddHHmmss", new Date());
		if (queryType.equals(PyConstants.PY_QUERYTYPE_90035)) {
			List<CisCropExtendInfo> cisCropExtendInfos = new ArrayList<CisCropExtendInfo>();
			JSONArray jsonArray = (JSONArray) jsonObject
					.get("manageContactInfosList");
			if(null!=jsonArray){
				for (Object jsonOb : jsonArray) {
					JSONObject jsonObject2 = (JSONObject) jsonOb;
					CisCropExtendInfo a = (CisCropExtendInfo) getBean(jsonObject2,
							CisCropExtendInfo.class);
					a.setCorpName(queryParameterEntity.getCorpName());
					a.setBatchNo(batchNo);
					a.setCreationDate(createDate);
					cisCropExtendInfos.add(a);
				}
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				cisCropExtendInfoService.saveCropExtendInfos(cisCropExtendInfos);
			}
		} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21603)) {
			List<CisTelCheckInfo> cisTelCheckInfos = new ArrayList<CisTelCheckInfo>();
			JSONArray jsonArray = (JSONArray) jsonObject.get("telCheckInfos");
			if(null!=jsonArray){
				for (Object jsonOb : jsonArray) {
					JSONObject jsonObject2 = (JSONObject) jsonOb;
					CisTelCheckInfo cisTelCheckInfo = (CisTelCheckInfo) getBean(jsonObject2,
							CisTelCheckInfo.class);
					cisTelCheckInfo.setTelePhone(queryParameterEntity.getTelephone());
					cisTelCheckInfo.setBatchNo(batchNo);
					cisTelCheckInfo.setCreationDate(createDate);
					cisTelCheckInfos.add(cisTelCheckInfo);
				}
				resultEntity.setReturnCode(PyConstants.PY_RECODE_001);
				cisTelCheckInfoDao.saveTelCheckInfos(cisTelCheckInfos);
			}
		} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21303)) {
			List<CisArtificialPersonInfo> cisArtificialPersonInfos = new ArrayList<CisArtificialPersonInfo>();
			JSONArray jsonArray = (JSONArray) jsonObject
					.get("artificialNationalInfoList");
			if(null!=jsonArray){
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
				cisArtificialPersonInfoService
					.saveArtificialPersonInfos(cisArtificialPersonInfos);
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
