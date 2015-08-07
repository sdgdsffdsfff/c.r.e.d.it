package com.ztx.credit.report.service;

import com.ztx.credit.report.model.PersonCreditInfo;

public interface IVerifyDataService {
	public String verifyPbc(PersonCreditInfo personCreditInfo,String urlId);
}
