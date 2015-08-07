package com.ctc.credit.bairong.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreditBrAssetsEntiryDao;
import com.ctc.credit.bairong.model.CreditBrAssetsEntiry;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CreditBrAssetsEntiryDaoImpl extends DaoHibernate<CreditBrAssetsEntiry, String> implements CreditBrAssetsEntiryDao{

}
