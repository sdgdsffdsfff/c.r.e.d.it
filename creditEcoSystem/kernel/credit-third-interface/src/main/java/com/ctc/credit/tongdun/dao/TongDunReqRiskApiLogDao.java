package com.ctc.credit.tongdun.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.tongdun.model.TongDunReqRiskApiEntity;

public interface TongDunReqRiskApiLogDao extends GenericDao<TongDunReqRiskApiEntity, String> {
	public void saveTdReqRiskApiInfo(TongDunReqRiskApiEntity tongDunReqRiskEntity);
}
