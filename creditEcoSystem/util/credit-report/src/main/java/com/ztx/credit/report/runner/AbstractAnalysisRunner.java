package com.ztx.credit.report.runner;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.ztx.credit.report.analysis.HtmlAnalysis;
import com.ztx.credit.report.service.AbstractAnalysisService;
import com.ztx.credit.report.service.impl.CreditHtmlAnalysisService;

public abstract class AbstractAnalysisRunner implements ICreditReportHtmlRunner {
	protected AbstractAnalysisService analysisService;
	protected String url;
	
	public AbstractAnalysisRunner(){
		analysisService = new CreditHtmlAnalysisService();
	}
	
	public void setHtmlDriverUrl(String url){
		analysisService.setDriver(new HtmlUnitDriver());
//		analysisService.setDriver(WebdriverUtil.getWebDriver(BrowserType.CHROME));
		analysisService.setAnalysisDriver(new HtmlAnalysis());
		this.url = url;
	}

}
