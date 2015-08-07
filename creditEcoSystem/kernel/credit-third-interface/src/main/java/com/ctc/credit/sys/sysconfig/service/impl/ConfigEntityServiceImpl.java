package com.ctc.credit.sys.sysconfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.sys.sysconfig.dao.ConfigEntityDao;
import com.ctc.credit.sys.sysconfig.model.ConfigEntity;
import com.ctc.credit.sys.sysconfig.service.ConfigEntityService;

@Service
@Transactional
public class ConfigEntityServiceImpl extends GenericServiceImpl<ConfigEntity, Integer>
		implements ConfigEntityService {

     public ConfigEntityServiceImpl() {
	 }
     @Autowired
	private ConfigEntityDao configEntityDao;

     
	public ConfigEntityDao getConfigEntityDao() {
		return configEntityDao;
	}

	public void setConfigEntityDao(ConfigEntityDao configEntityDao) {
		this.configEntityDao = configEntityDao;
	}

	@Override
	public String queryConfigValueByKey(String key) {
		String val ="";
		ConfigEntity configEntity = configEntityDao.queryConfigValueByKey(key);
		if(null!=configEntity)
			val = configEntity.getConfigValue();
		return val;
	}

}
