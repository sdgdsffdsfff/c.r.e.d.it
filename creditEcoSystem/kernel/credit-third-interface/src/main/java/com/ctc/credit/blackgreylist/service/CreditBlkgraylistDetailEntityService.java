package com.ctc.credit.blackgreylist.service;

import java.util.List;

import com.ctc.credit.blackgreylist.model.BlkGrayListQueryPara;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.kernel.base.GenericService;

public interface CreditBlkgraylistDetailEntityService extends
		GenericService<CreditBlkgraylistDetailEntity, String> {
	public void saveAndCreateIndexs(
			List<CreditBlkgraylistDetailEntity> creditBlkgraylistDetailEntities);
	
	public List<CreditBlkgraylistDetailEntity> queryCreditBlkgraylistDetailEntities(BlkGrayListQueryPara blkGrayListQueryPara);
	
	public CreditBlkgraylistDetailEntity queryBlkgrayEntity(String id);
	
	public int queryCount(BlkGrayListQueryPara blkGrayListQueryPara);
}
