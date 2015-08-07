package com.ctc.credit.antifraud.dao;

import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.kernel.base.GenericDao;

public interface CustomerInfoDao extends
		GenericDao<CustomerInfo, String> {
	/**
	 * 通过申请单号查询客户信息
	 * 
	 * @param applyCode
	 */
	public CustomerInfo queryCustomerByApplyCode(String applyCode);
	
}