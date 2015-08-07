package com.ztx.credit.report.service;

import com.ztx.credit.report.model.PersonCreditInfo;

public interface IPbcOperService {
	public void insertPbc(PersonCreditInfo personCreditInfo,String urlId,String result);
}
