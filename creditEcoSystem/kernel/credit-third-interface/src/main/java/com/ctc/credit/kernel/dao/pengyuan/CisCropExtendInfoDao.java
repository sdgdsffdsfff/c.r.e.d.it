package com.ctc.credit.kernel.dao.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;

public interface CisCropExtendInfoDao extends GenericDao<CisCropExtendInfo, String> {
	
	public String queryMaxDateFromLocal(String corpName);
	
	public String queryBatchNoByDate(String date,String corpName);
	
	public List<CisCropExtendInfo> queryCropExtendInfoByBatchNo(String batchNo);
}
