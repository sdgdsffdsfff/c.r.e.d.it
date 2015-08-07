package com.ctc.credit.tongdun.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.tongdun.dao.TongDunResRiskApiLogDao;
import com.ctc.credit.tongdun.model.TongDunResRiskApiEntity;
@Repository
public class TongDunResRiskApiLogHibernate extends DaoHibernate<TongDunResRiskApiEntity, String> implements TongDunResRiskApiLogDao {
	@Override
	public void saveTdResRiskApiInfo(
			TongDunResRiskApiEntity tongDunResRiskApiEntity) {
		// TODO Auto-generated method stub
		this.save(tongDunResRiskApiEntity);
	}

}
