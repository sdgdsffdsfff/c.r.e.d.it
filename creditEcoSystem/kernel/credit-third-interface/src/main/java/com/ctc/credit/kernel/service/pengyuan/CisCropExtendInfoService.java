package com.ctc.credit.kernel.service.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.base.GenericService;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;

public interface CisCropExtendInfoService extends GenericService<CisCropExtendInfo, String> {
	
	public void saveCropExtendInfos(List<CisCropExtendInfo> cisCropExtendInfos);
	
	public String queryMaxDateFromLocal(String corpName);
	
	public String queryBatchNoByDate(String date,String corpName);
	
	public List<CisCropExtendInfo> queryCropExtendInfoByBatchNo(String batchNo);
}
