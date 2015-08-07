package com.ctc.credit.qianhai.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.qianhai.dao.CreditQhBlkListEntityDao;
import com.ctc.credit.qianhai.model.CreditQhApplyBlkListEntity;

@Repository
public class CreditQhBlkListEntityDaoImpl extends
		DaoHibernate<CreditQhApplyBlkListEntity, String> implements
		CreditQhBlkListEntityDao {

}
