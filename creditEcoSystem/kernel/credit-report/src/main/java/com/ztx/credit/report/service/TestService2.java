package com.ztx.credit.report.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.ztx.credit.report.model.AdminPunishmentInfo;
import com.ztx.credit.report.model.AdministrativeRewardInfo;
import com.ztx.credit.report.model.AssertDisposeDetailInfo;
import com.ztx.credit.report.model.BankCreditInfo;
import com.ztx.credit.report.model.CivilJudgmentInfo;
import com.ztx.credit.report.model.CreditCardInfo;
import com.ztx.credit.report.model.DissentDeclareDetailInfo;
import com.ztx.credit.report.model.EnforcementInfo;
import com.ztx.credit.report.model.GuaranteeDetailInfo;
import com.ztx.credit.report.model.GuarantorCompensationDetailInfo;
import com.ztx.credit.report.model.HousingFundPayInfo;
import com.ztx.credit.report.model.LoanDeclareDetailInfo;
import com.ztx.credit.report.model.LoanInfo;
import com.ztx.credit.report.model.LowReliefInfo;
import com.ztx.credit.report.model.PensionPayInfo;
import com.ztx.credit.report.model.PensionReceiveInfo;
import com.ztx.credit.report.model.PersonalCareerInfo;
import com.ztx.credit.report.model.PersonalInfo;
import com.ztx.credit.report.model.PersonalResidentialInfo;
import com.ztx.credit.report.model.PersonalSpouseInfo;
import com.ztx.credit.report.model.QualificationInfo;
import com.ztx.credit.report.model.QuasiCreditInfo;
import com.ztx.credit.report.model.QueryPersonInfo;
import com.ztx.credit.report.model.QueryRecordInfo;
import com.ztx.credit.report.model.ReportHeadInfo;
import com.ztx.credit.report.model.SummaryCreditInfo;
import com.ztx.credit.report.model.SummaryGuaranteeInfo;
import com.ztx.credit.report.model.SummaryNotCloseCreditInfo;
import com.ztx.credit.report.model.SummaryOutstandingInfo;
import com.ztx.credit.report.model.SummaryOverdueAndDefaultInfo;
import com.ztx.credit.report.model.SummaryOverdueInfo;
import com.ztx.credit.report.model.SummaryQuasiCreditInfo;
import com.ztx.credit.report.model.SummaryQueryRecordInfo;
import com.ztx.credit.report.model.TaxesInfo;
import com.ztx.credit.report.model.TelecomPaymentInfo;
import com.ztx.credit.report.model.VehicleTradeAndMortgageInfo;
import com.ztx.selenium.uitl.FileUtil;
import com.ztx.selenium.uitl.WebdriverUtil;

public class TestService2 {

	public static void main(String[] args) throws Exception {

		String url = "http://10.2.129.102:8080/test/123/";
				//123/";
		String fileName = "205.htm";
		url += fileName;
		String txtName = "/java/log/" + fileName + ".txt";
		File f = new File(txtName);
		if (f.exists()) {
			f.delete();
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		long start = System.currentTimeMillis();
		CreditReportService creditReportService = new CreditReportService();
		creditReportService.setDriver(new FirefoxDriver());
		creditReportService.getDriver().get(url);
		
		ReportHeadInfo reportHeadInfo = creditReportService.getReportHeadInfo();
		System.out.println(reportHeadInfo);
		creditReportService.closeDriver();

		long end = System.currentTimeMillis();
		System.out.println("-----------总计耗时:" + (end - start)
				/ 1000 + "秒------------");

	}
}
