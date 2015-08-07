package com.ctc.credit.bairong.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreditBrLocationEntiryDao;
import com.ctc.credit.bairong.model.CreditBrLocationEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
/**
 * 
 * @author danggang
 *
 */
@Repository
public class CreditBrLocationEntiryDaoImpl extends DaoHibernate <CreditBrLocationEntiry,String> 
	implements CreditBrLocationEntiryDao{

}
