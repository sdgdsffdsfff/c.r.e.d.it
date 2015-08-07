package com.ctc.credit.bairong.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreditBrIneternetCityEntiryDao;
import com.ctc.credit.bairong.model.CreditBrIneternetCityEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
/**
 * 百融：网上信息核查dao实现
 * @author danggang
 *
 */
@Repository
public class CreditBrIneternetCityEntiryDaoImpl extends DaoHibernate<CreditBrIneternetCityEntiry, String> 
	implements CreditBrIneternetCityEntiryDao{

}
