package com.ctc.credit.tongdun.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.tongdun.dao.TongDunReqRiskApiDetailLogDao;
import com.ctc.credit.tongdun.model.TongDunReqApiDetailEntity;
@Repository
public class TongDunReqRiskApiDetailLogHibernate extends DaoHibernate<TongDunReqApiDetailEntity, String>implements TongDunReqRiskApiDetailLogDao {

	@Override
	public void saveTdReqRiskDetailInfo(
			TongDunReqApiDetailEntity tongDunReqDetailEntity) {
		// TODO Auto-generated method stub
		this.save(tongDunReqDetailEntity);
	}

	
}
