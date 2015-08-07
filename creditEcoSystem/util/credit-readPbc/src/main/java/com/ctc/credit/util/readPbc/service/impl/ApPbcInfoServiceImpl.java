package com.ctc.credit.util.readPbc.service.impl;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.util.readPbc.dao.ApPbcInfoDao;
import com.ctc.credit.util.readPbc.service.ApPbcInfoService;

@Service
@Transactional
public class ApPbcInfoServiceImpl implements ApPbcInfoService{
	@Autowired
	ApPbcInfoDao apPbcInfo;

	public Blob getApPbcInfo(String id) {
		// TODO Auto-generated method stub
		return apPbcInfo.getApPbcInfo(id);
	}

	@Override
	public List<String> getNeedAnalysisFiles() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> needAnalysis = apPbcInfo.getNeedAnalysisFiles();
		List<String> result = new ArrayList<String>();
		for(Map<String,Object> np : needAnalysis){
			np.put("source_id", np.get("SOURCE_ID_"));
//			np.put("parth", null);
//			np.put("analysis_result", null);
//			np.put("source_type", 1);
			result.add(np.get("SOURCE_ID_").toString());
			apPbcInfo.updateAnalysisLog(np);
		}
		
		return result;
	}
}
