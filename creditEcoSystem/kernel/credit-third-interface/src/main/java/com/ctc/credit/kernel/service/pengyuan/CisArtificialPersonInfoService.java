package com.ctc.credit.kernel.service.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericService;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;

public interface CisArtificialPersonInfoService extends GenericService<CisArtificialPersonInfo, String> {

	public void saveArtificialPersonInfos(List<CisArtificialPersonInfo> artificialPersonInfos);
	
	public String queryMaxDateFromLocal(String idType,String personName,String idNumber);
	
	public String queryBatchNoByDate(String date,String idType,String personName,String idNumber);
	
	public List<CisArtificialPersonInfo> queryArtificialPersonInfoByBatchNo(String batchNo);
}
