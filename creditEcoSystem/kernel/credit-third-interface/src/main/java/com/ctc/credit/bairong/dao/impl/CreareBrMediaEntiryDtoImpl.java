package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreareBrMediaEntiryDto;
import com.ctc.credit.bairong.model.CreareBrMediaEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
@Repository
public class CreareBrMediaEntiryDtoImpl  extends DaoHibernate<CreareBrMediaEntiry, String>
		implements CreareBrMediaEntiryDto{

	@Override
	public void saveMediaList(ArrayList<CreareBrMediaEntiry> lists) {
		// TODO Auto-generated method stub
		Iterator it = lists.iterator();
		while(it.hasNext()){
			CreareBrMediaEntiry creareBrMediaEntiry = (CreareBrMediaEntiry) it.next();
			this.save(creareBrMediaEntiry);
		}		
	}
}
