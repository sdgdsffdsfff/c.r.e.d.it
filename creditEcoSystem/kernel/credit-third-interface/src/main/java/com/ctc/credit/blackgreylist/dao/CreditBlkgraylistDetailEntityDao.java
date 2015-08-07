package com.ctc.credit.blackgreylist.dao;

import java.util.List;

import com.ctc.credit.blackgreylist.model.BlkGrayListQueryPara;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreditBlkgraylistDetailEntityDao extends
		GenericDao<CreditBlkgraylistDetailEntity, String> {

	public List<CreditBlkgraylistDetailEntity> queryCreditBlkgraylistDetailEntities(
			BlkGrayListQueryPara blkGrayListQueryPara);

	public CreditBlkgraylistDetailEntity queryBlkgrayEntity(String id);
	
	public int queryCount(BlkGrayListQueryPara blkGrayListQueryPara);
	
	public List<String> getExistingApplyNo();
}