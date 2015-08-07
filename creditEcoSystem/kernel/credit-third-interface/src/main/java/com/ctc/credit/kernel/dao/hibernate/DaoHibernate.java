package com.ctc.credit.kernel.dao.hibernate;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.base.GenericDaoHibernate;
 
@Repository
public class DaoHibernate<T, PK extends Serializable> extends
		GenericDaoHibernate<T, PK> {
	public DaoHibernate(final Class<T> persistentClass) {
		super(persistentClass);
	}
	
	public DaoHibernate() {
		super();
	}

	@Override
	@Autowired
	@Qualifier("sessionFactory_product")
	public void setSessionFactory(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		super.setSessionFactory(sessionFactory);
	}
}
