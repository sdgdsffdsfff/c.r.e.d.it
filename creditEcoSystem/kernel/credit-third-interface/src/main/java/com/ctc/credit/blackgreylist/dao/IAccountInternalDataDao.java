package com.ctc.credit.blackgreylist.dao;

import java.util.List;
import java.util.Map;

public interface IAccountInternalDataDao {
	public List<String> getAllApplyCode(List<String> extisingCode);
	
}
