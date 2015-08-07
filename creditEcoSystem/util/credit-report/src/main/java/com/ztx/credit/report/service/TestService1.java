//package com.ztx.credit.report.service;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
//
//import com.ztx.credit.report.model.AdminPunishmentInfo;
//import com.ztx.credit.report.model.AdministrativeRewardInfo;
//import com.ztx.credit.report.model.AssertDisposeDetailInfo;
//import com.ztx.credit.report.model.BankCreditInfo;
//import com.ztx.credit.report.model.CivilJudgmentInfo;
//import com.ztx.credit.report.model.CreditCardInfo;
//import com.ztx.credit.report.model.DissentDeclareDetailInfo;
//import com.ztx.credit.report.model.EnforcementInfo;
//import com.ztx.credit.report.model.GuaranteeDetailInfo;
//import com.ztx.credit.report.model.GuarantorCompensationDetailInfo;
//import com.ztx.credit.report.model.HousingFundPayInfo;
//import com.ztx.credit.report.model.LoanDeclareDetailInfo;
//import com.ztx.credit.report.model.LoanInfo;
//import com.ztx.credit.report.model.LowReliefInfo;
//import com.ztx.credit.report.model.PensionPayInfo;
//import com.ztx.credit.report.model.PensionReceiveInfo;
//import com.ztx.credit.report.model.PersonalCareerInfo;
//import com.ztx.credit.report.model.PersonalInfo;
//import com.ztx.credit.report.model.PersonalResidentialInfo;
//import com.ztx.credit.report.model.PersonalSpouseInfo;
//import com.ztx.credit.report.model.QualificationInfo;
//import com.ztx.credit.report.model.QuasiCreditInfo;
//import com.ztx.credit.report.model.QueryPersonInfo;
//import com.ztx.credit.report.model.QueryRecordInfo;
//import com.ztx.credit.report.model.ReportHeadInfo;
//import com.ztx.credit.report.model.SummaryCreditInfo;
//import com.ztx.credit.report.model.SummaryGuaranteeInfo;
//import com.ztx.credit.report.model.SummaryNotCloseCreditInfo;
//import com.ztx.credit.report.model.SummaryOutstandingInfo;
//import com.ztx.credit.report.model.SummaryOverdueAndDefaultInfo;
//import com.ztx.credit.report.model.SummaryOverdueInfo;
//import com.ztx.credit.report.model.SummaryQuasiCreditInfo;
//import com.ztx.credit.report.model.SummaryQueryRecordInfo;
//import com.ztx.credit.report.model.TaxesInfo;
//import com.ztx.credit.report.model.TelecomPaymentInfo;
//import com.ztx.credit.report.model.VehicleTradeAndMortgageInfo;
//import com.ztx.credit.report.service.impl.CreditHtmlAnalysisService;
//import com.ztx.selenium.uitl.FileUtil;
//
//public class TestService1 {
//
//	public static void main(String[] args) throws Exception {
//
//		String url = "http://localhost:8080/credit-readPbc/";
//		// 123/";
//		String fileName = "getPbc.action";
//		url += fileName;
//		String txtName = "C:/Users/daniel/" + fileName + ".txt";
//		File f = new File(txtName);
//		if (f.exists()) {
//			f.delete();
//			try {
//				f.createNewFile();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//
//		long start = System.currentTimeMillis();
//		
//		creditReportService.getDriver().get(url);
//		
//		//报告头
//		ReportHeadInfo reportHeadInfo = creditReportService.getReportHeadInfo();
//		//被查询者信息
//		QueryPersonInfo queryPersonInfo = creditReportService.getQueryPersonInfo();
//		//身份信息
//		PersonalInfo personalInfo = creditReportService.getPersonalInfo();
//		//配偶信息
//		PersonalSpouseInfo personalSpouseInfo = creditReportService.getPersonalSpouseInfo();
//		//居住信息
//		List<PersonalResidentialInfo> personalResidentialInfos = creditReportService.getPersonalResidentialInfos();
//		//职业信息
//		List<PersonalCareerInfo> personalCareerInfos = creditReportService.getPersonalCareerInfos();
//		//信用提示
//		SummaryCreditInfo summaryCreditInfo = creditReportService.getSummaryCreditInfo();
//		//中征评分
//		BankCreditInfo bankCreditInfo = creditReportService.getBankCreditInfo();
//		//逾期及违约信息概要
//		SummaryOverdueAndDefaultInfo summaryOverdueAndDefaultInfo = creditReportService.getSummaryOverdueAndDefaultInfo();
//		//逾期（透支）信息汇总
//		SummaryOverdueInfo summaryOverdueInfo = creditReportService.getSummaryOverdueInfo();
//		//未结清贷款信息汇总
//		SummaryOutstandingInfo summaryOutstandingInfo = creditReportService.getSummaryOutstandingInfo();
//		//未销户贷记卡信息汇总
//		SummaryNotCloseCreditInfo summaryNotCloseCreditInfo = creditReportService.getSummaryNotCloseCreditInfo();
//		//未销户准贷记卡信息汇总
//		SummaryQuasiCreditInfo summaryQuasiCreditInfo = creditReportService.getSummaryQuasiCreditInfo();
//		//对外担保信息汇总
//		SummaryGuaranteeInfo summaryGuaranteeInfo = creditReportService.getSummaryGuaranteeInfo();
//		//资产处置信息
//		List<AssertDisposeDetailInfo> assertDisposeDetailInfos = creditReportService.getAssertDisposeDetailInfos();
//		//保证人代偿信息
//		List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos = creditReportService.getGuarantorCompensationDetailInfos();
//		//贷款
//		List<LoanInfo> loanInfos = creditReportService.getLoanInfos();
//		//贷记卡
//		List<CreditCardInfo> creditCardInfos = creditReportService.getCreditCardInfos();
//		//准贷记卡
//		List<QuasiCreditInfo> quasiCreditInfos = creditReportService.getQuasiCreditInfos();
//		//对外担保信息
//		List<GuaranteeDetailInfo> guaranteeDetailInfos = creditReportService.getGuaranteeDetailInfos();
//		//欠税记录
//		List<TaxesInfo> taxesInfos = creditReportService.getTaxesInfos();
//		//民事判决记录
//		List<CivilJudgmentInfo> civilJudgmentInfos = creditReportService.getCivilJudgmentInfos();
//		//强制执行记录
//		List<EnforcementInfo> enforcementInfos = creditReportService.getEnforcementInfos();
//		//行政处罚记录
//		List<AdminPunishmentInfo> adminPunishmentInfos = creditReportService.getAdminPunishmentInfos();
//		//住房公积金参缴记录
//		HousingFundPayInfo housingFundPayInfo = creditReportService.getHousingFundPayInfo();
//		//养老保险金缴存记录
//		PensionPayInfo pensionPayInfo = creditReportService.getPensionPayInfo();
//		//养老保险金发放记录
//		PensionReceiveInfo pensionReceiveInfo = creditReportService.getPensionReceiveInfo();
//		//低保救助记录
//		List<LowReliefInfo> lowReliefInfos = creditReportService.getLowReliefInfos();
//		//执业资格记录
//		List<QualificationInfo> qualificationInfos = creditReportService.getQualificationInfos();
//		//行政奖励记录
//		List<AdministrativeRewardInfo> administrativeRewardInfos = creditReportService.getAdministrativeRewardInfos();
//		//车辆交易和抵押记录
//		List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos = creditReportService.getVehicleTradeAndMortgageInfos();
//		//电信缴费记录
//		List<TelecomPaymentInfo> telecomPaymentInfos = creditReportService.getTelecomPaymentInfos();
//		//本人声明
//		List<LoanDeclareDetailInfo> loanDeclareDetailInfos = creditReportService.getLoanDeclareDetailInfos();
//		//异议标注
//		List<DissentDeclareDetailInfo> dissentDeclareDetailInfos = creditReportService.getDissentDeclareDetailInfos();
//		//查询记录汇总
//		SummaryQueryRecordInfo summaryQueryRecordInfo = creditReportService.getSummaryQueryRecordInfo();
//		//信贷审批查询记录明细
//		List<QueryRecordInfo> queryRecordInfos = creditReportService.getQueryRecordInfos();
//		
//		creditReportService.closeDriver();
//
//		long end = System.currentTimeMillis();
//		FileUtil.AppendContent(txtName, "-----------总计耗时:" + (end - start)
//				/ 1000 + "秒------------");
//		System.out.println("-----------总计耗时:" + (end - start) / 1000
//				+ "秒------------");
//	}
//}
