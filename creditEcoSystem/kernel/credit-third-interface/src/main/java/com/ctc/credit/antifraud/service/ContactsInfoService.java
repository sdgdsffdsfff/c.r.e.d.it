package com.ctc.credit.antifraud.service;

import java.util.List;

import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.kernel.base.GenericService;

public interface ContactsInfoService extends
		GenericService<ContactsInfo, String> {
	
	/**
	 * 通过申请单号查询客户联系人信息
	 * 
	 * @param applyCode
	 */
	public List<ContactsInfo> queryContactsByApplyCode(String applyCode);
	
	/**
	 * 从指定系统中查询联系人历史信息
	 * 
	 * @param applyCode
	 * @param sourceSys
	 * @return
	 */
	public List<ContactsInfo> queryHistContactInfo(String applyCode,String sourceSys);
	
}
