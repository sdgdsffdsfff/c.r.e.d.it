package com.ctc.credit.bairong.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreateBrApplyLoanEntiryDto;
import com.ctc.credit.bairong.model.CreateBrApplyLoanEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CreateBrApplyLoanEntiryDtoImpl extends DaoHibernate<CreateBrApplyLoanEntiry,String>
		implements CreateBrApplyLoanEntiryDto{

	@Override
	public void saveApplyList(ArrayList<CreateBrApplyLoanEntiry> lists) {
		// TODO Auto-generated method stub
		Iterator it = lists.iterator();
        while(it.hasNext()){
        	CreateBrApplyLoanEntiry createBrApplyLoanEntiry = (CreateBrApplyLoanEntiry) it.next();
        	this.save(createBrApplyLoanEntiry);
        }
	}

}
