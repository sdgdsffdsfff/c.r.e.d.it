package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreareBrLevelEntiryDao;
import com.ctc.credit.bairong.model.CreareBrLevelEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
@Repository
public class CreareBrLevelEntiryDaoImpl extends DaoHibernate<CreareBrLevelEntiry,String> 
		implements CreareBrLevelEntiryDao{

	@Override
	public void saveLevleList(ArrayList<CreareBrLevelEntiry> lists) {
		// TODO Auto-generated method stub
		Iterator it = lists.iterator();
        while(it.hasNext()){
        	CreareBrLevelEntiry creareBrLevelEntiry = (CreareBrLevelEntiry) it.next();
        	this.save(creareBrLevelEntiry);
        }
	}

}
