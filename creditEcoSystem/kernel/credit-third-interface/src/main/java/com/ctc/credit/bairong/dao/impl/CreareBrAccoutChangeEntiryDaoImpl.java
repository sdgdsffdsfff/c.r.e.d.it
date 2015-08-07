package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreareBrAccoutChangeEntiryDao;
import com.ctc.credit.bairong.model.CreareBrAccoutChangeEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
@Repository
public class CreareBrAccoutChangeEntiryDaoImpl extends DaoHibernate<CreareBrAccoutChangeEntiry,String>
		implements CreareBrAccoutChangeEntiryDao{

	@Override
	public void saveAccountChangeList(ArrayList<CreareBrAccoutChangeEntiry> lists) {
		// TODO Auto-generated method stub
		Iterator it = lists.iterator();
		while(it.hasNext()){
			CreareBrAccoutChangeEntiry creareBrAccoutChangeEntiry = (CreareBrAccoutChangeEntiry) it.next();
			this.save(creareBrAccoutChangeEntiry);
		}	
	}

}
