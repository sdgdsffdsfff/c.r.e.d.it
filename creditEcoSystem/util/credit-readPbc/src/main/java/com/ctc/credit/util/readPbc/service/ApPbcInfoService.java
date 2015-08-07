package com.ctc.credit.util.readPbc.service;

import java.sql.Blob;
import java.util.List;

public interface ApPbcInfoService {
	
	public Blob getApPbcInfo(String id);
	
	public List<String> getNeedAnalysisFiles();
}
