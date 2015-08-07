package com.ctc.credit.kernel.commoninter.category;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.ctc.credit.api.dto.CreditApplyDto;
import com.ctc.credit.api.service.CreditApiService;
import com.ctc.credit.kernel.constants.PyConstants;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;
import com.ctc.credit.kernel.model.pengyuan.ResultEntity;

@Service(AbstractPyService.BEAN_NAME)
public abstract class AbstractPyService implements CommonInterface {
	
	public static final String BEAN_NAME = "abstractPyService";

	protected CreditApiService creditApiService;

	@Override
	public void doBefore(CreditApiService creditApiService) {
		this.creditApiService = creditApiService;
	}

	/**
	 * 执行接口动作</br> 每个具体的实现必须重写该方法
	 * 
	 * @throws Exception
	 */
	@Override
	public abstract JSONObject executeService(ResultEntity resultEntity,QueryConditionEntity queryConditionEntity) throws Exception;

	@Override
	public void doAfter() {

	}

	protected CreditApplyDto transform(QueryConditionEntity queryConditionEntity) {
		CreditApplyDto applyDto = new CreditApplyDto();
		applyDto.setApplyNo(queryConditionEntity.getQueryParas().getSendCode());
		applyDto.setIdNumber(queryConditionEntity.getQueryParas().getIdNumber());
		String idType = queryConditionEntity.getQueryParas().getIdType();
		if(null!=idType)
			applyDto.setIdType(Short.valueOf(idType));
		applyDto.setPersonName(queryConditionEntity.getQueryParas()
				.getPersonName());
		applyDto.setPhone(queryConditionEntity.getQueryParas().getTelephone());
		applyDto.setCorpName(queryConditionEntity.getQueryParas().getCorpName());
		applyDto.setQueryReasonID("101");

		// creditApply.setApplyNo(creditApplyDto.getApplyNo());
		// creditApply.setIdNumber(creditApplyDto.getIdNumber());
		// creditApply.setIdType(creditApplyDto.getIdType());
		// creditApply.setPersonName(creditApplyDto.getPersonName());
		// creditApply.setPhone(creditApplyDto.getPhone());
		// creditApply.setSbm(creditApplyDto.getSbm());
		// creditApply.setFsd(creditApplyDto.getFsd());
		// creditApply.setYwlx(creditApplyDto.getYwlx());
		// creditApply.setLevelNo(creditApplyDto.getLevelNo());
		// creditApply.setGraduateYear(creditApplyDto.getGraduateYear());
		// creditApply.setCollege(creditApplyDto.getCollege());
		// creditApply.setAreaCode(creditApplyDto.getAreaCode()); // 行政区划
		// creditApply.setCorpName(creditApplyDto.getCorpName()); // 被查询企业名称
		// creditApply.setOrgCode(creditApplyDto.getOrgCode()); // 被查询企业组织机构代码
		// creditApply.setRegisterNo(creditApplyDto.getRegisterNo()); //
		// 被查询企业工商注册号
		// creditApply.setQueryType(creditApplyDto.getQueryType()); // 查询类型ID
		// creditApply.setSubreportIDs(creditApplyDto.getSubreportIDs());
		// creditApply.setQueryReasonID(creditApplyDto.getQueryReasonID());
		// creditApply.setDistibuteFlag(creditApplyDto.getDistibuteFlag());
		// creditApply.setRefID(creditApplyDto.getRefID());
		return applyDto;
	}

	protected String getCategoryCode(QueryConditionEntity queryConditionEntity) {
		String categoryCode = "";
		String queryType = queryConditionEntity.getQueryType();
		if (StringUtils.isNotEmpty(queryType)) {
			if (queryType.equals(PyConstants.PY_QUERYTYPE_90035)) {
				categoryCode = "8";
			} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21603)) {
				categoryCode = "12";
			} else if (queryType.equals(PyConstants.PY_QUERYTYPE_21303)) {
				categoryCode = "10";
			}
		}
		return categoryCode;

	}

}
