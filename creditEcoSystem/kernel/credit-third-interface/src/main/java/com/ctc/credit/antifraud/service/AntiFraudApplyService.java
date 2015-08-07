package com.ctc.credit.antifraud.service;

import com.ctc.credit.antifraud.model.AntiFraudRequestAndReponse;
import com.ctc.credit.kernel.base.GenericService;

public interface AntiFraudApplyService extends
		GenericService<AntiFraudRequestAndReponse, String> {
	
	/**
	 * 查询反欺诈申请信息
	 * 
	 * @param applyCode
	 * @return
	 */
	public AntiFraudRequestAndReponse queryAntiFraudInfo(String applyCode);
	
	/**
	 * 查询反欺诈批量异步接口 欺诈结果数据
	 * 
	 * @param applyCode
	 * @param type
	 * @return
	 */
	public AntiFraudRequestAndReponse queryAntiFraudAsyncInfo(String applyCode,String type);
	
}
