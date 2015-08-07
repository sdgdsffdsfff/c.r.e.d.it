package com.ztx.credit.report.runner;

import com.ztx.credit.report.model.PersonCreditInfo;

public interface ICreditReportHtmlRunner extends Runnable{
	public PersonCreditInfo getPersonCreditInfo();
	
	public void setHtmlDriverUrl(String url);
}
