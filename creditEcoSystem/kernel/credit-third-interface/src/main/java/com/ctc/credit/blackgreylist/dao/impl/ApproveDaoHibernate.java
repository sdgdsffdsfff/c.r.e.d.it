package com.ctc.credit.blackgreylist.dao.impl;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.base.GenericDaoHibernate;
 
@Repository
public class ApproveDaoHibernate<T, PK extends Serializable> extends
		GenericDaoHibernate<T, PK> {
	public ApproveDaoHibernate(final Class<T> persistentClass) {
		super(persistentClass);
	}
	
	public ApproveDaoHibernate() {
		super();
	}

	@Override
	@Autowired
	@Qualifier("sessionFactory_product_readonly")
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}
}
