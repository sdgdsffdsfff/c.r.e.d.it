package com.ctc.credit.antifraud.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.antifraud.model.AntiFraudRequestAndReponse;
import com.ctc.credit.antifraud.service.AntiFraudApplyService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

@Service
@Transactional
public class AntiFraudApplyServiceImpl extends
		GenericServiceImpl<AntiFraudRequestAndReponse, String> implements AntiFraudApplyService {

	private static Logger logger = Logger
			.getLogger(AntiFraudApplyServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public AntiFraudRequestAndReponse queryAntiFraudInfo(String applyCode) {
		String hql = "from AntiFraudRequestAndReponse c where c.applyCode=?";
		List<AntiFraudRequestAndReponse> andReponses = this.query(hql, new Object[] {applyCode});
		return null!=andReponses&&andReponses.size()>0?andReponses.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public AntiFraudRequestAndReponse queryAntiFraudAsyncInfo(String applyCode,
			String type) {
		String hql = "from AntiFraudRequestAndReponse c where c.applyCode=? and c.queryType=? order by c.createDate desc";
		List<AntiFraudRequestAndReponse> andReponses = this.query(hql, new Object[] {applyCode,type});
		return null!=andReponses&&andReponses.size()>0?andReponses.get(0):null;
	}

}
