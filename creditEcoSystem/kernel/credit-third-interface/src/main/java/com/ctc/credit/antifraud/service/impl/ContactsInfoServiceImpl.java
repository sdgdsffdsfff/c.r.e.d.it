package com.ctc.credit.antifraud.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.service.ContactsInfoService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

@Service
@Transactional
public class ContactsInfoServiceImpl extends
		GenericServiceImpl<ContactsInfo, String> implements ContactsInfoService {

	private static Logger logger = Logger
			.getLogger(ContactsInfoServiceImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactsInfo> queryContactsByApplyCode(String applyCode) {
		String hql = "from ContactsInfo c where c.applyCode=?";
		List<ContactsInfo> contactsInfos = this.query(hql, new Object[] {applyCode});
		return contactsInfos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ContactsInfo> queryHistContactInfo(String applyCode, String sourceSys) {
		String hql = "select ci from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.applyCode=? and c.sourceSys=?";
		List<ContactsInfo> contactsInfos = this.query(hql, new Object[] {applyCode,sourceSys});
		return contactsInfos;
	}


}
