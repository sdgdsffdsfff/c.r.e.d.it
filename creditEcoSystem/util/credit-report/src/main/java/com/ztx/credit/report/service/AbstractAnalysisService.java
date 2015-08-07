package com.ztx.credit.report.service;

import org.openqa.selenium.WebDriver;

import com.ztx.credit.report.analysis.AbstractKeyValue;

public abstract class AbstractAnalysisService implements IAnalysisService{
	protected AbstractKeyValue analysisDriver;
	
	protected WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public AbstractKeyValue getAnalysisDriver() {
		return analysisDriver;
	}

	public void setAnalysisDriver(AbstractKeyValue analysisDriver) {
		this.analysisDriver = analysisDriver;
	}
}
