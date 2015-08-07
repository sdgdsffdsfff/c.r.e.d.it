package com.ctc.credit.lakala.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.lakala.dao.ILklApplyBlkListDao;
import com.ctc.credit.lakala.model.LklApplyBlkList;


@Repository
public class LklApplyBlkListHibernate extends DaoHibernate<LklApplyBlkList, String> implements ILklApplyBlkListDao{

}
