package com.ctc.credit.blackgreylist.dao;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistSearchLogEntity;
import com.ctc.credit.kernel.base.GenericDao;

public interface ISearchLogDao  extends GenericDao<CreditBlkgraylistSearchLogEntity, String>{
	public void saveSearchLog(CreditBlkgraylistSearchLogEntity cbs);
}
