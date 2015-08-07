package com.ctc.credit.kernel.service.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericService;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;

public interface CisTelCheckInfoService extends GenericService<CisTelCheckInfo, String> {
	
	public String queryMaxDateFromLocal(String telephone);
	
	public String queryBatchNoByDate(String date,String telephone);
	
	public List<CisTelCheckInfo> queryTelCheckInfoByBatchNo(String batchNo);
}
