package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreareBrOnlineEntiryDao;
import com.ctc.credit.bairong.model.CreareBrOnlineEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CreareBrOnlineEntiryDaoImpl extends DaoHibernate<CreareBrOnlineEntiry,String>
		implements CreareBrOnlineEntiryDao{

	@Override
	public void saveOnlineList(ArrayList<CreareBrOnlineEntiry> lists) {
		// TODO Auto-generated method stub
		Iterator it = lists.iterator();
        while(it.hasNext()){
        	CreareBrOnlineEntiry CreareBrOnlineEntiry = (CreareBrOnlineEntiry) it.next();
        	this.save(CreareBrOnlineEntiry);
        }
	}
	

}
