package com.ctc.credit.tongdun.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.tongdun.model.TongDunReqApiDetailEntity;

public interface TongDunReqRiskApiDetailLogDao extends GenericDao<TongDunReqApiDetailEntity, String> {
	public void saveTdReqRiskDetailInfo(TongDunReqApiDetailEntity tongDunReqDetailEntity);
}
