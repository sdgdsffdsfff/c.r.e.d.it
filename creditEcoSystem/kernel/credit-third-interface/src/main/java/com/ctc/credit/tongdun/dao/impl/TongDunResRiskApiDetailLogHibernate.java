package com.ctc.credit.tongdun.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.tongdun.dao.TongDunResRiskApiDetailLogDao;
import com.ctc.credit.tongdun.model.TongDunResApiDetailEntity;
@Repository
public class TongDunResRiskApiDetailLogHibernate extends DaoHibernate<TongDunResApiDetailEntity, String> implements
		TongDunResRiskApiDetailLogDao {


	@Override
	public void saveTdResRiskApiDeetailInfo(
			TongDunResApiDetailEntity tongDunResApiDetailEntity) {
		// TODO Auto-generated method stub
		this.save(tongDunResApiDetailEntity);
	}

}
