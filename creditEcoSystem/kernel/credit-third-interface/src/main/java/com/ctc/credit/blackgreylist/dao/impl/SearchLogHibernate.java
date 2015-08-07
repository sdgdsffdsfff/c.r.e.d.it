package com.ctc.credit.blackgreylist.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.blackgreylist.dao.ISearchLogDao;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistSearchLogEntity;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;


@Repository
public class SearchLogHibernate extends DaoHibernate<CreditBlkgraylistSearchLogEntity, String>
implements ISearchLogDao{

	@Override
	public void saveSearchLog(CreditBlkgraylistSearchLogEntity cbs) {
		// TODO Auto-generated method stub
		this.save(cbs);
	}

}
