package com.ctc.credit.tongdun.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.tongdun.model.TongDunResRiskApiEntity;

public interface TongDunResRiskApiLogDao extends GenericDao<TongDunResRiskApiEntity, String> {
	public void saveTdResRiskApiInfo(TongDunResRiskApiEntity tongDunResRiskApiEntity);
}
