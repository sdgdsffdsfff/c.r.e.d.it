package com.ctc.credit.blackgreylist.dao;

import java.util.List;
import java.util.Map;

public interface IApproveInternalDataDao {
	
	public List<Map<String,Object>> getCustomerInfoByApplyCode(List<String> applyCode);
	
	public List<Map<String,Object>> getGrayListInfo();
	
	public List<Map<String,Object>> getInterBadCustomer();
}
