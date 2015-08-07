package com.ctc.credit.util.readPbc.dao;

import java.sql.Blob;
import java.util.List;
import java.util.Map;

public interface ApPbcInfoDao {
	public Blob getApPbcInfo(String id);
	
	public List<Map<String,	Object>> getNeedAnalysisFiles();
	
	public void updateAnalysisLog(Map<String,Object> param);
}
