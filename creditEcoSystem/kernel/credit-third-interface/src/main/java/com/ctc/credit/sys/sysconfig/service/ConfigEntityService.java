package com.ctc.credit.sys.sysconfig.service;

import com.ctc.credit.kernel.base.GenericService;
import com.ctc.credit.sys.sysconfig.model.ConfigEntity;

public interface ConfigEntityService extends GenericService<ConfigEntity, Integer> {
	
	/**
	 * 查询配置表中的key值对应的配置信息
	 * 
	 * @return
	 */
	public String queryConfigValueByKey(String key);
	
}
