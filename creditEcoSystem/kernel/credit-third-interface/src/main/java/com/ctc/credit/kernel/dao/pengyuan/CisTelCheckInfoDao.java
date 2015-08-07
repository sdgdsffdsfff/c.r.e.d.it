package com.ctc.credit.kernel.dao.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;

public interface CisTelCheckInfoDao extends GenericDao<CisTelCheckInfo, String> {
	
	public String queryMaxDateFromLocal(String telephone);
	
	public String queryBatchNoByDate(String date,String telephone);
	
	public List<CisTelCheckInfo> queryTelCheckInfoByBatchNo(String batchNo);
	
	public void saveTelCheckInfos(List<CisTelCheckInfo> cisTelCheckInfos);
}

