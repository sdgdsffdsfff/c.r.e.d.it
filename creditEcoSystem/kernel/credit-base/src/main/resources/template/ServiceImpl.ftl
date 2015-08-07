package com.ctc.credit.kernel.${module}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.dao.${module}.${entity}Dao;
import com.ctc.credit.kernel.service.${module}.${entity}Service;
import com.ctc.credit.kernel.model.${module}.${entity};

@Service
@Transactional
public class ${entity}ServiceImpl extends GenericServiceImpl<${entity}, ${idType}>
		implements ${entity}Service {

     public ${entity}ServiceImpl() {
	 }
     @Autowired
	private ${entity}Dao ${entitylower}Dao;

     
	public ${entity}Dao get${entity}Dao() {
		return ${entitylower}Dao;
	}

	public void set${entity}Dao(${entity}Dao ${entitylower}Dao) {
		this.${entitylower}Dao = ${entitylower}Dao;
	}

}
