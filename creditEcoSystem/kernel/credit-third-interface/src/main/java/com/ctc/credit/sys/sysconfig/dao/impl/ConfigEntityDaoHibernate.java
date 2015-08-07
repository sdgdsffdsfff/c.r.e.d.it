package com.ctc.credit.sys.sysconfig.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.sys.sysconfig.dao.ConfigEntityDao;
import com.ctc.credit.sys.sysconfig.model.ConfigEntity;

@Repository
public class ConfigEntityDaoHibernate extends DaoHibernate<ConfigEntity, Integer>
		implements ConfigEntityDao {

	public ConfigEntityDaoHibernate() {
		super(ConfigEntity.class);
	}

	@Override
	public ConfigEntity queryConfigValueByKey(String key) {
		String hql = "from ConfigEntity config where config.configName=?";
		@SuppressWarnings("unchecked")
		List<ConfigEntity> configEntities = this.query(hql,new Object[]{key});
		return configEntities.size()>0?configEntities.get(0):null;
	}
}
