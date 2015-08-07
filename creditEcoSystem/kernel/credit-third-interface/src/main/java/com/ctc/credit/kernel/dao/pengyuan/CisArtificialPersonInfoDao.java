package com.ctc.credit.kernel.dao.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;

public interface CisArtificialPersonInfoDao extends GenericDao<CisArtificialPersonInfo, String> {
	
	public String queryMaxDateFromLocal(String idType,String personName,String idNumber);
	
	public String queryBatchNoByDate(String date,String idType,String personName,String idNumber);
	
	public List<CisArtificialPersonInfo> queryArtificialPersonInfoByBatchNo(String batchNo);
}
