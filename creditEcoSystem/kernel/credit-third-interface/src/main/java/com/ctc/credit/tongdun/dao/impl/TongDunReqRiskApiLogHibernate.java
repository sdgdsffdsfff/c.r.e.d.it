package com.ctc.credit.tongdun.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.tongdun.dao.TongDunReqRiskApiLogDao;
import com.ctc.credit.tongdun.model.TongDunReqRiskApiEntity;
@Repository
public class TongDunReqRiskApiLogHibernate extends DaoHibernate<TongDunReqRiskApiEntity, String>implements TongDunReqRiskApiLogDao {
	@Override
	public void saveTdReqRiskApiInfo(
			TongDunReqRiskApiEntity tongDunReqRiskEntity) {
		this.save(tongDunReqRiskEntity);
	}

	
}
