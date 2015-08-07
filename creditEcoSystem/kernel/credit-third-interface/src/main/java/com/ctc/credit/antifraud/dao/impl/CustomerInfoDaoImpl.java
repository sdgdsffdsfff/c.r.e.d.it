package com.ctc.credit.antifraud.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.antifraud.dao.CustomerInfoDao;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;

@Repository
public class CustomerInfoDaoImpl extends
		DaoHibernate<CustomerInfo, String> implements
		CustomerInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public CustomerInfo queryCustomerByApplyCode(String applyCode) {

		String hql = "from CustomerInfo c where c.applyCode=?";
		List<CustomerInfo> customerInfos = this.query(hql,new Object[]{applyCode});
		return customerInfos.size()>0?customerInfos.get(0):null;
	}

}