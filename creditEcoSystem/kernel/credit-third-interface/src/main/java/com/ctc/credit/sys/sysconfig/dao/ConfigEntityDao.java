package com.ctc.credit.sys.sysconfig.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.sys.sysconfig.model.ConfigEntity;

public interface ConfigEntityDao extends GenericDao<ConfigEntity, Integer> {
	
	public ConfigEntity queryConfigValueByKey(String key);
}
