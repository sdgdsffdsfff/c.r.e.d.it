package com.ctc.credit.kernel.dao.${module}.hibernate;

import com.ctc.credit.kernel.dao.${module}.${entity}Dao;
import com.ctc.credit.kernel.model.${module}.${entity};
import org.springframework.stereotype.Repository;

@Repository
public class ${entity}DaoHibernate extends DaoHibernate<${entity}, ${idType}>
		implements ${entity}Dao {

	public ${entity}DaoHibernate() {
		super(${entity}.class);
	}
}
