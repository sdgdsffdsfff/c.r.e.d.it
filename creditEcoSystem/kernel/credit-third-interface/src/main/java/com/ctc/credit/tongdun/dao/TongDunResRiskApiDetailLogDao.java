package com.ctc.credit.tongdun.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.tongdun.model.TongDunResApiDetailEntity;

public interface TongDunResRiskApiDetailLogDao extends GenericDao<TongDunResApiDetailEntity, String> {
	public void saveTdResRiskApiDeetailInfo(TongDunResApiDetailEntity tongDunResApiDetailEntity);
}
