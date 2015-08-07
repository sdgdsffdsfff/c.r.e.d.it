package com.ztx.credit.report.service;

import java.io.File;
import java.io.IOException;
import java.util.List;

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

public class TestService1 {

	public static void main(String[] args) throws Exception {

		String url = "http://10.2.129.102:8080/test/";
		// 123/";
		String fileName = "index.htm";
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
		creditReportService.setDriver(new HtmlUnitDriver());
		creditReportService.getDriver().get(url);
		
		ReportHeadInfo reportHeadInfo = creditReportService.getReportHeadInfo();

		if (reportHeadInfo == null) {
			FileUtil.AppendContent(txtName, "报告头----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"报告头----" + reportHeadInfo.toString() + "\r\n");
		}
		QueryPersonInfo queryPersonInfo = creditReportService
				.getQueryPersonInfo();
		if (queryPersonInfo == null) {
			FileUtil.AppendContent(txtName, "被查询者信息----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"被查询者信息----" + queryPersonInfo.toString() + "\r\n");
		}
		PersonalInfo personalInfo = creditReportService.getPersonalInfo();
		if (personalInfo == null) {
			FileUtil.AppendContent(txtName, "身份信息----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"身份信息----" + personalInfo.toString() + "\r\n");
		}
		try {
			PersonalSpouseInfo personalSpouseInfo = creditReportService
					.getPersonalSpouseInfo();
			if (personalSpouseInfo == null) {
				FileUtil.AppendContent(txtName, "配偶信息----没有数据\r\n");
			} else {
				FileUtil.AppendContent(txtName,
						"配偶信息----" + personalSpouseInfo.toString() + "\r\n");
			}
		} catch (Exception e) {
		}
		List<PersonalResidentialInfo> personalResidentialInfos = creditReportService
				.getPersonalResidentialInfos();
		if (personalResidentialInfos == null
				|| personalResidentialInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "居住信息----没有数据\r\n");
		} else {
			for (PersonalResidentialInfo personalResidentialInfo : personalResidentialInfos) {
				FileUtil.AppendContent(txtName, "居住信息----"
						+ personalResidentialInfo.toString() + "\r\n");
			}
		}
		List<PersonalCareerInfo> personalCareerInfos = creditReportService
				.getPersonalCareerInfos();
		if (personalCareerInfos == null || personalCareerInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "职业信息----没有数据\r\n");
		} else {
			for (PersonalCareerInfo personalCareerInfo : personalCareerInfos) {
				FileUtil.AppendContent(txtName,
						"职业信息----" + personalCareerInfo.toString() + "\r\n");
			}
		}

		SummaryCreditInfo summaryCreditInfo = creditReportService
				.getSummaryCreditInfo();
		if (summaryCreditInfo == null) {
			FileUtil.AppendContent(txtName, "信用提示----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"信用提示----" + summaryCreditInfo.toString() + "\r\n");
		}
		BankCreditInfo bankCreditInfo = creditReportService.getBankCreditInfo();

		if (bankCreditInfo == null) {
			FileUtil.AppendContent(txtName, "中征信评分----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"中征信评分----" + bankCreditInfo.toString() + "\r\n");
		}

		SummaryOverdueAndDefaultInfo summaryOverdueAndDefaultInfo = creditReportService
				.getSummaryOverdueAndDefaultInfo();

		if (summaryOverdueAndDefaultInfo == null) {
			FileUtil.AppendContent(txtName, "逾期及违约信息概要----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "逾期及违约信息概要----"
					+ summaryOverdueAndDefaultInfo.toString() + "\r\n");
		}
		SummaryOverdueInfo summaryOverdueInfo = creditReportService
				.getSummaryOverdueInfo();

		if (summaryOverdueInfo == null) {
			FileUtil.AppendContent(txtName, "逾期（透支）信息汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "逾期（透支）信息汇总----"
					+ summaryOverdueInfo.toString() + "\r\n");
		}
		SummaryOutstandingInfo summaryOutstandingInfo = creditReportService
				.getSummaryOutstandingInfo();

		if (summaryOutstandingInfo == null) {
			FileUtil.AppendContent(txtName, "未结清贷款信息汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "未结清贷款信息汇总----"
					+ summaryOutstandingInfo.toString() + "\r\n");
		}
		SummaryNotCloseCreditInfo summaryNotCloseCreditInfo = creditReportService
				.getSummaryNotCloseCreditInfo();
		if (summaryNotCloseCreditInfo == null) {
			FileUtil.AppendContent(txtName, "未销户贷记卡信息汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "未销户贷记卡信息汇总----"
					+ summaryNotCloseCreditInfo.toString() + "\r\n");
		}
		SummaryQuasiCreditInfo summaryQuasiCreditInfo = creditReportService
				.getSummaryQuasiCreditInfo();
		if (summaryQuasiCreditInfo == null) {
			FileUtil.AppendContent(txtName, "未销户准贷记卡信息汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "未销户准贷记卡信息汇总----"
					+ summaryQuasiCreditInfo.toString() + "\r\n");
		}
		SummaryGuaranteeInfo summaryGuaranteeInfo = creditReportService
				.getSummaryGuaranteeInfo();
		if (summaryGuaranteeInfo == null) {
			FileUtil.AppendContent(txtName, "对外担保信息汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "对外担保信息汇总----"
					+ summaryGuaranteeInfo.toString() + "\r\n");
		}
		List<AssertDisposeDetailInfo> assertDisposeDetailInfos = creditReportService
				.getAssertDisposeDetailInfos();
		if (assertDisposeDetailInfos == null
				|| assertDisposeDetailInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "资产处置信息----没有数据\r\n");
		} else {
			for (AssertDisposeDetailInfo assertDisposeDetailInfo : assertDisposeDetailInfos) {
				FileUtil.AppendContent(txtName, "资产处置信息----"
						+ assertDisposeDetailInfo.toString() + "\r\n");
			}
		}
		List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos = creditReportService
				.getGuarantorCompensationDetailInfos();
		if (guarantorCompensationDetailInfos == null
				|| guarantorCompensationDetailInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "保证人代偿信息----没有数据\r\n");
		} else {
			for (GuarantorCompensationDetailInfo guarantorCompensationDetailInfo : guarantorCompensationDetailInfos) {
				FileUtil.AppendContent(txtName, "保证人代偿信息----"
						+ guarantorCompensationDetailInfo.toString() + "\r\n");

			}
		}
		List<LoanInfo> loanInfos = creditReportService.getLoanInfos();

		if (loanInfos == null || loanInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "贷款----没有数据\r\n");
		} else {
			for (LoanInfo loanInfo : loanInfos) {
				FileUtil.AppendContent(txtName, "贷款----" + loanInfo.toString()
						+ "\r\n");
			}
		}
		List<CreditCardInfo> creditCardInfos = creditReportService
				.getCreditCardInfos();
		if (creditCardInfos == null || creditCardInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "贷记卡----没有数据\r\n");
		} else {
			for (CreditCardInfo creditCardInfo : creditCardInfos) {
				FileUtil.AppendContent(txtName,
						"贷记卡----" + creditCardInfo.toString() + "\r\n");

			}
		}
		List<QuasiCreditInfo> quasiCreditInfos = creditReportService
				.getQuasiCreditInfos();

		if (quasiCreditInfos == null || quasiCreditInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "准贷记卡----没有数据\r\n");
		} else {
			for (QuasiCreditInfo quasiCreditInfo : quasiCreditInfos) {
				FileUtil.AppendContent(txtName,
						"准贷记卡----" + quasiCreditInfo.toString() + "\r\n");

			}
		}
		List<GuaranteeDetailInfo> guaranteeDetailInfos = creditReportService
				.getGuaranteeDetailInfos();

		if (guaranteeDetailInfos == null || guaranteeDetailInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "对外担保信息----没有数据\r\n");
		} else {
			for (GuaranteeDetailInfo guaranteeDetailInfo : guaranteeDetailInfos) {
				FileUtil.AppendContent(txtName, "对外担保信息----"
						+ guaranteeDetailInfo.toString() + "\r\n");
			}
		}

		List<TaxesInfo> taxesInfos = creditReportService.getTaxesInfos();
		if (taxesInfos == null || taxesInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "欠税记录----没有数据\r\n");
		} else {
			for (TaxesInfo taxesInfo : taxesInfos) {
				FileUtil.AppendContent(txtName,
						"欠税记录----" + taxesInfo.toString() + "\r\n");
			}
		}
		List<CivilJudgmentInfo> civilJudgmentInfos = creditReportService
				.getCivilJudgmentInfos();
		if (civilJudgmentInfos == null || civilJudgmentInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "民事判决记录----没有数据\r\n");
		} else {
			for (CivilJudgmentInfo civilJudgmentInfo : civilJudgmentInfos) {
				FileUtil.AppendContent(txtName, "民事判决记录----"
						+ civilJudgmentInfo.toString() + "\r\n");
			}
		}
		List<EnforcementInfo> enforcementInfos = creditReportService
				.getEnforcementInfos();
		if (enforcementInfos == null || enforcementInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "强制执行记录----没有数据\r\n");
		} else {
			for (EnforcementInfo enforcementInfo : enforcementInfos) {
				FileUtil.AppendContent(txtName,
						"强制执行记录----" + enforcementInfo.toString() + "\r\n");
			}
		}

		List<AdminPunishmentInfo> adminPunishmentInfos = creditReportService
				.getAdminPunishmentInfos();
		if (adminPunishmentInfos == null || adminPunishmentInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "行政处罚记录----没有数据\r\n");
		} else {
			for (AdminPunishmentInfo adminPunishmentInfo : adminPunishmentInfos) {
				FileUtil.AppendContent(txtName, "行政处罚记录----"
						+ adminPunishmentInfo.toString() + "\r\n");
			}
		}
		HousingFundPayInfo housingFundPayInfo = creditReportService
				.getHousingFundPayInfo();

		if (housingFundPayInfo == null) {
			FileUtil.AppendContent(txtName, "住房公积金参缴记录----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "住房公积金参缴记录----"
					+ housingFundPayInfo.toString() + "\r\n");
		}
		PensionPayInfo pensionPayInfo = creditReportService.getPensionPayInfo();

		if (pensionPayInfo == null) {
			FileUtil.AppendContent(txtName, "养老保险金缴存记录----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName,
					"养老保险金缴存记录----" + pensionPayInfo.toString() + "\r\n");
		}
		PensionReceiveInfo pensionReceiveInfo = creditReportService
				.getPensionReceiveInfo();
		if (pensionReceiveInfo == null) {
			FileUtil.AppendContent(txtName, "养老保险金发放记录----没有数据\r\n");
		} else {

			FileUtil.AppendContent(txtName, "养老保险金发放记录----"
					+ pensionReceiveInfo.toString() + "\r\n");
		}
		List<LowReliefInfo> lowReliefInfos = creditReportService
				.getLowReliefInfos();
		if (lowReliefInfos == null || lowReliefInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "低保救助记录----没有数据\r\n");
		} else {
			for (LowReliefInfo lowReliefInfo : lowReliefInfos) {
				FileUtil.AppendContent(txtName,
						"低保救助记录----" + lowReliefInfo.toString() + "\r\n");
			}
		}
		List<QualificationInfo> qualificationInfos = creditReportService
				.getQualificationInfos();
		if (qualificationInfos == null || qualificationInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "执业资格记录----没有数据\r\n");
		} else {
			for (QualificationInfo qualificationInfo : qualificationInfos) {
				FileUtil.AppendContent(txtName, "执业资格记录----"
						+ qualificationInfo.toString() + "\r\n");
			}
		}
		List<AdministrativeRewardInfo> administrativeRewardInfos = creditReportService
				.getAdministrativeRewardInfos();
		if (administrativeRewardInfos == null
				|| administrativeRewardInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "行政奖励记录----没有数据\r\n");
		} else {
			for (AdministrativeRewardInfo administrativeRewardInfo : administrativeRewardInfos) {
				FileUtil.AppendContent(txtName, "行政奖励记录----"
						+ administrativeRewardInfo.toString() + "\r\n");
			}
		}

		List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos = creditReportService
				.getVehicleTradeAndMortgageInfos();

		if (vehicleTradeAndMortgageInfos == null
				|| vehicleTradeAndMortgageInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "车辆交易和抵押记录----没有数据\r\n");
		} else {
			for (VehicleTradeAndMortgageInfo vehicleTradeAndMortgageInfo : vehicleTradeAndMortgageInfos) {
				FileUtil.AppendContent(txtName, "车辆交易和抵押记录----"
						+ vehicleTradeAndMortgageInfo.toString() + "\r\n");
			}
		}

		List<TelecomPaymentInfo> telecomPaymentInfos = creditReportService
				.getTelecomPaymentInfos();
		if (telecomPaymentInfos == null || telecomPaymentInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "电信缴费记录----没有数据\r\n");
		} else {
			for (TelecomPaymentInfo telecomPaymentInfo : telecomPaymentInfos) {
				FileUtil.AppendContent(txtName, "电信缴费记录----"
						+ telecomPaymentInfo.toString() + "\r\n");
			}
		}
		List<LoanDeclareDetailInfo> loanDeclareDetailInfos = creditReportService
				.getLoanDeclareDetailInfos();
		if (loanDeclareDetailInfos == null || loanDeclareDetailInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "本人声明----没有数据\r\n");
		} else {
			for (LoanDeclareDetailInfo loanDeclareDetailInfo : loanDeclareDetailInfos) {
				FileUtil.AppendContent(txtName, "本人声明----"
						+ loanDeclareDetailInfo.toString() + "\r\n");
			}
		}
		List<DissentDeclareDetailInfo> dissentDeclareDetailInfos = creditReportService
				.getDissentDeclareDetailInfos();
		if (dissentDeclareDetailInfos == null
				|| dissentDeclareDetailInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "异议标注----没有数据\r\n");
		} else {
			for (DissentDeclareDetailInfo dissentDeclareDetailInfo : dissentDeclareDetailInfos) {
				FileUtil.AppendContent(txtName, "异议标注----"
						+ dissentDeclareDetailInfo.toString() + "\r\n");
			}
		}
		SummaryQueryRecordInfo summaryQueryRecordInfo = creditReportService
				.getSummaryQueryRecordInfo();
		if (summaryQueryRecordInfo == null) {
			FileUtil.AppendContent(txtName, "查询记录汇总----没有数据\r\n");
		} else {
			FileUtil.AppendContent(txtName, "查询记录汇总----"
					+ summaryQueryRecordInfo.toString() + "\r\n");
		}
		List<QueryRecordInfo> queryRecordInfos = creditReportService
				.getQueryRecordInfos();
		if (queryRecordInfos == null || queryRecordInfos.size() < 1) {
			FileUtil.AppendContent(txtName, "信贷审批查询记录明细----没有数据\r\n");
		} else {
			for (QueryRecordInfo queryRecordInfo : queryRecordInfos) {
				FileUtil.AppendContent(txtName, "信贷审批查询记录明细----"
						+ queryRecordInfo.toString() + "\r\n");
			}
		}

		creditReportService.closeDriver();

		long end = System.currentTimeMillis();
		FileUtil.AppendContent(txtName, "-----------总计耗时:" + (end - start)
				/ 1000 + "秒------------");
		System.out.println("-----------总计耗时:" + (end - start) / 1000
				+ "秒------------");
	}
}
