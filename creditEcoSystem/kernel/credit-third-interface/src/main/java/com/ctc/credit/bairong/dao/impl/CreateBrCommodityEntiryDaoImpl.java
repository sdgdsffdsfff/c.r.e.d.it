package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreateBrCommodityEntiryDao;
import com.ctc.credit.bairong.model.CreateBrCommodityEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CreateBrCommodityEntiryDaoImpl  extends DaoHibernate<CreateBrCommodityEntiry,String> 
		implements CreateBrCommodityEntiryDao{

	@Override
	public void saveCommdityList(ArrayList<CreateBrCommodityEntiry> lists){		
		Iterator it = lists.iterator();
        while(it.hasNext()){
        	CreateBrCommodityEntiry createBrCommodityEntiry = (com.ctc.credit.bairong.model.CreateBrCommodityEntiry) it.next();
        	this.save(createBrCommodityEntiry);
        }		
	}

}
