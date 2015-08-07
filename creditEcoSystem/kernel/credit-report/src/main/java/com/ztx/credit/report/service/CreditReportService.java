package com.ztx.credit.report.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.ztx.credit.report.analysis.AbstractKeyValue;
import com.ztx.credit.report.model.AdminPunishmentInfo;
import com.ztx.credit.report.model.AdministrativeRewardInfo;
import com.ztx.credit.report.model.AssertDisposeDetailInfo;
import com.ztx.credit.report.model.AssertDisposeInfo;
import com.ztx.credit.report.model.BadDebtsInfo;
import com.ztx.credit.report.model.BankCreditInfo;
import com.ztx.credit.report.model.CivilJudgmentInfo;
import com.ztx.credit.report.model.CreditCardDetailInfo;
import com.ztx.credit.report.model.CreditCardInfo;
import com.ztx.credit.report.model.CreditCardOverdue;
import com.ztx.credit.report.model.CreditCardOverdue_24_Info;
import com.ztx.credit.report.model.DissentDeclareDetailInfo;
import com.ztx.credit.report.model.EnforcementInfo;
import com.ztx.credit.report.model.GuaranteeDetailInfo;
import com.ztx.credit.report.model.GuarantorCompensationDetailInfo;
import com.ztx.credit.report.model.GuarantorCompensationInfo;
import com.ztx.credit.report.model.HousingFundPayInfo;
import com.ztx.credit.report.model.Last1MonthQuery;
import com.ztx.credit.report.model.Last1MonthQueryInstitution;
import com.ztx.credit.report.model.Last2YearsQuery;
import com.ztx.credit.report.model.LoanDeclareDetailInfo;
import com.ztx.credit.report.model.LoanDetailInfo;
import com.ztx.credit.report.model.LoanInfo;
import com.ztx.credit.report.model.LoanOverDueInfo;
import com.ztx.credit.report.model.LoanOverdue_24_Info;
import com.ztx.credit.report.model.LowReliefInfo;
import com.ztx.credit.report.model.PensionPayInfo;
import com.ztx.credit.report.model.PensionReceiveInfo;
import com.ztx.credit.report.model.PersonalCareerInfo;
import com.ztx.credit.report.model.PersonalInfo;
import com.ztx.credit.report.model.PersonalResidentialInfo;
import com.ztx.credit.report.model.PersonalSpouseInfo;
import com.ztx.credit.report.model.QualificationInfo;
import com.ztx.credit.report.model.QuasiCreditDetailInfo;
import com.ztx.credit.report.model.QuasiCreditInfo;
import com.ztx.credit.report.model.QuasiCreditOverdraftAbove60Days;
import com.ztx.credit.report.model.QuasiCreditOverdueInfo;
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
import com.ztx.selenium.uitl.WebdriverUtil;

public class CreditReportService extends AbstractKeyValue implements IService {
	private static Logger logger = Logger.getLogger(CreditReportService.class);

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public CreditReportService() {
//		if (driver == null) {
//			driver = new HtmlUnitDriver(true);
//		}
	}

	@Override
	public ReportHeadInfo getReportHeadInfo() throws Exception {
		try {

			ReportHeadInfo headInfo = new ReportHeadInfo();
			WebElement e = this.getElement(this.getDriver(), "报告编号", "查询请求时间",
					"报告时间");

			String text = e.getText().replaceAll("\\s", "");

			if (text == null || text.trim().length() < 1) {
				logger.info("报告头信息为空！");
				return null;
			}
			// 报告编号对应的值
			String reportNo = text
					.substring(text.indexOf("报告编号"), text.indexOf("查询请求时间"))
					.substring(5).trim();

			// 查询请求时间对应的值
			String reqTime = text
					.substring(text.indexOf("查询请求时间"), text.indexOf("报告时间"))
					.substring(7).trim();

			// 报告时间对应的值
			String reportTime = text.substring(text.indexOf("报告时间"))
					.substring(5).trim().substring(0, 18);

			headInfo.setReportNo(reportNo);
			headInfo.setReqTime(reqTime);
			headInfo.setReportTime(reportTime);

			logger.info("报告编号:[" + reportNo + "]," + "查询请求时间:[" + reportTime
					+ "]," + "报告时间:[" + reqTime + "]");

			return headInfo;
		} catch (Exception e) {
			throw new Exception("报告头信息异常＝＝" + e.getMessage());
		}
	}

	@Override
	public QueryPersonInfo getQueryPersonInfo() throws Exception {

		WebElement e = this.getElement(this.getDriver(), "被查询者姓名", "被查询者证件类型",
				"被查询者证件号码", "查询原因");
		Map<String, String> map = this.getKeyValue(e, "被查询者姓名", "被查询者证件类型",
				"被查询者证件号码", "查询原因");

		if (map == null || map.size() < 1) {
			return null;
		}
		QueryPersonInfo queryPersonInfo = new QueryPersonInfo();
		queryPersonInfo.setName(map.get("被查询者姓名"));
		queryPersonInfo.setIdType(map.get("被查询者证件类型"));
		queryPersonInfo.setiDNumber(map.get("被查询者证件号码"));
		queryPersonInfo.setOperator(map.get("查询操作员"));
		queryPersonInfo.setQueryReason(map.get("查询原因"));
		logger.info("被查询者信息:" + queryPersonInfo);
		return queryPersonInfo;
	}

	@Override
	public PersonalInfo getPersonalInfo() throws Exception {
		WebElement e1 = this.getElement(this.getDriver(), "通讯地址", "户籍地址");
		Map<String, String> map = this.getKeyValue(e1, "通讯地址", "户籍地址");
		WebElement e2 = this.getElement(this.getDriver(), "出生日期", "单位电话", "学位",
				"学历", "住宅电话", "婚姻状况", "手机号码");
		map.putAll(this.getKeyValue(e2, "出生日期", "单位电话", "学位", "学历", "住宅电话",
				"婚姻状况", "手机号码"));
		PersonalInfo personalInfo = new PersonalInfo();
		personalInfo.setAddress(map.get("通讯地址"));
		personalInfo.setBirthday(map.get("出生日期"));
		personalInfo.setComPhone(map.get("单位电话"));
		personalInfo.setDegree(map.get("学位"));
		personalInfo.setEducation(map.get("学历"));
		personalInfo.setGender(map.get("性别"));
		personalInfo.setHomePhone(map.get("住宅电话"));
		personalInfo.setIsMarried(map.get("婚姻状况"));
		personalInfo.setMobilePhone(map.get("手机号码"));
		personalInfo.setPermanentAddress(map.get("户籍地址"));
		logger.info("身份信息: " + personalInfo);
		return personalInfo;
	}

	@Override
	public PersonalSpouseInfo getPersonalSpouseInfo() throws Exception {

		WebElement e = this.getElement(this.getDriver(), "姓名", "证件号码", "证件类型",
				"工作单位", "联系电话");
		Map<String, String> map = this.getKeyValue(e, "姓名", "证件号码", "证件类型",
				"工作单位", "联系电话");

		if (map == null || map.size() < 1) {
			return null;
		}

		PersonalSpouseInfo personalSpouseInfo = new PersonalSpouseInfo();
		personalSpouseInfo.setName(map.get("姓名"));
		personalSpouseInfo.setiDNumber(map.get("证件号码"));
		personalSpouseInfo.setiDType(map.get("证件类型"));
		personalSpouseInfo.setCompany(map.get("工作单位"));
		personalSpouseInfo.setPhone(map.get("联系电话"));
		logger.info("配偶信息:" + personalSpouseInfo);
		return personalSpouseInfo;
	}

	@Override
	public List<PersonalResidentialInfo> getPersonalResidentialInfos()
			throws Exception {
		List<PersonalResidentialInfo> residentialInfos = new ArrayList<PersonalResidentialInfo>();
		WebElement element = this.getElement(this.getDriver(), "居住地址", "居住状况",
				"编号", "信息更新日期");
		List<Map<String, String>> addrInfos = this.getListData(null, element,
				null, "居住地址", "居住状况", "编号", "信息更新日期");
		for (Map<String, String> map : addrInfos) {
			PersonalResidentialInfo info = new PersonalResidentialInfo();
			info.setAddress(map.get("居住地址"));
			info.setResidentialStatus(map.get("居住状况"));
			info.setSerial(map.get("编号"));
			info.setUpdateTime(map.get("信息更新日期"));

			residentialInfos.add(info);
		}
		logger.info("居住信息:" + residentialInfos);
		return residentialInfos;
	}

	@Override
	public List<PersonalCareerInfo> getPersonalCareerInfos() throws Exception {
		List<PersonalCareerInfo> personalCareerInfos = new ArrayList<PersonalCareerInfo>();
		WebElement e = this.getElement(this.getDriver(), "单位地址", "编号", "工作单位");
		WebElement e2 = this.getElement(this.getDriver(), "行业", "职业", "职称",
				"进入本单位年份", "信息更新日期");

		List<Map<String, String>> infos = this.getListData(e, e2, new String[] {
				"编号", "工作单位", "单位地址" }, "编号", "行业", "职业", "职称", "进入本单位年份",
				"信息更新日期");

		for (Map<String, String> map : infos) {
			PersonalCareerInfo careerInfo = new PersonalCareerInfo();
			careerInfo.setCareer(map.get("职业"));
			careerInfo.setComAddress(map.get("单位地址"));
			careerInfo.setCompany(map.get("工作单位"));
			careerInfo.setEntryYear(map.get("进入本单位年份"));
			careerInfo.setIndustry(map.get("行业"));
			careerInfo.setJobTitle(map.get("职称"));
			careerInfo.setPosition(map.get("职务"));
			careerInfo.setSerial(map.get("编号"));
			careerInfo.setUpdateTime(map.get("信息更新日期"));

			personalCareerInfos.add(careerInfo);
		}

		logger.info("职业信息:" + personalCareerInfos);
		return personalCareerInfos;
	}

	@Override
	public SummaryCreditInfo getSummaryCreditInfo() throws Exception {

		SummaryCreditInfo summaryCreditInfo = new SummaryCreditInfo();

		WebElement e = this.getElement(this.getDriver(), "账户数", "本人声明", "发卡月份",
				"住房贷款");
		Map<String, String> map = this.getKeyValue(e, "本人声明数目", "贷记卡账户数",
				"异议标注数目", "首张贷记卡发卡月份", "首笔贷款发放月份", "首张准贷记卡发卡月份", "住房贷款笔数");

		summaryCreditInfo.setDebitAccountCount(map.get("贷记卡账户数"));
		summaryCreditInfo.setDeclareCount(map.get("本人声明数目"));
		summaryCreditInfo.setDissentMarkCount(map.get("异议标注数目"));
		summaryCreditInfo.setFirstDebitOfferMonth(map.get("首张贷记卡发卡月份"));
		summaryCreditInfo.setFirstLoanOfferMonth(map.get("首笔贷款发放月份"));
		summaryCreditInfo.setFirstQuasiDebitOfferMonth(map.get("首张准贷记卡发卡月份"));
		summaryCreditInfo.setHouseLoanCount(map.get("住房贷款笔数"));
		summaryCreditInfo.setOtherLoanCount(map.get("其他贷款笔数"));
		summaryCreditInfo.setQuasiCreditAccountCount(map.get("准贷记卡账户数"));

		logger.info("信用提示:" + summaryCreditInfo);
		return summaryCreditInfo;
	}

	@Override
	public BankCreditInfo getBankCreditInfo() throws Exception {

		WebElement e = this.getElement(this.getDriver(), "评分月份", "中征信评分");

		Map<String, String> map = this.getKeyValue(e, "中征信评分", "评分月份");

		BankCreditInfo bankCreditInfo = new BankCreditInfo();
		bankCreditInfo.setBankCreditGrade(map.get("中征信评分"));
		bankCreditInfo.setBankCreditMonth(map.get("评分月份"));
		logger.info("中征信评分:" + bankCreditInfo);
		return bankCreditInfo;
	}

	@Override
	public SummaryOverdueAndDefaultInfo getSummaryOverdueAndDefaultInfo()
			throws Exception {
		SummaryOverdueAndDefaultInfo summaryOverdueAndDefaultInfo = new SummaryOverdueAndDefaultInfo();
		AssertDisposeInfo assertDisposeInfo = new AssertDisposeInfo();
		BadDebtsInfo badDebtsInfo = new BadDebtsInfo();
		GuarantorCompensationInfo guarantorCompensationInfo = new GuarantorCompensationInfo();

		WebElement e = this.getElement(this.getDriver(), "呆账信息汇总", "资产处置信息汇总",
				"保证人代偿信息汇总");

		Map<String, String> map = this.getKeyValueSpecial(e, new String[] {
				"呆账信息汇总", "资产处置信息汇总", "保证人代偿信息汇总" }, "笔数", "余额");

		assertDisposeInfo.setTotalCount(map.get("资产处置信息汇总笔数"));
		assertDisposeInfo.setTotalBalance(map.get("资产处置信息汇总余额"));
		badDebtsInfo.setTotalCount(map.get("呆账信息汇总笔数"));
		badDebtsInfo.setTotalBalance(map.get("呆账信息汇总余额"));
		guarantorCompensationInfo.setTotalCount(map.get("保证人代偿信息汇总笔数"));
		guarantorCompensationInfo.setTotalBalance(map.get("保证人代偿信息汇总余额"));
		summaryOverdueAndDefaultInfo.setAssertDisposeInfo(assertDisposeInfo);
		summaryOverdueAndDefaultInfo.setBadDebtsInfo(badDebtsInfo);
		summaryOverdueAndDefaultInfo
				.setGuarantorCompensationInfo(guarantorCompensationInfo);
		logger.info("逾期及违约信息概要:" + summaryOverdueAndDefaultInfo);
		return summaryOverdueAndDefaultInfo;
	}

	@Override
	public SummaryOverdueInfo getSummaryOverdueInfo() throws Exception {
		SummaryOverdueInfo summaryOverdueInfo = new SummaryOverdueInfo();
		CreditCardOverdue creditCardOverdue = new CreditCardOverdue();
		LoanOverDueInfo loanOverDueInfo = new LoanOverDueInfo();
		QuasiCreditOverdraftAbove60Days quasiCreditOverdraftAbove60Days = new QuasiCreditOverdraftAbove60Days();

		WebElement e = this.getElement(this.getDriver(), "贷记卡逾期", "贷款逾期",
				"准贷记卡60天以上透支");

		Map<String, String> map = this.getKeyValueSpecial(e, new String[] {
				"贷记卡逾期", "贷款逾期", "准贷记卡60天以上透支" }, "笔数", "最长逾期月数", "单月最高透支余额");
		creditCardOverdue.setAccountCount(map.get("贷记卡逾期账户数"));
		creditCardOverdue
				.setHighestMonthlyTotalAmount(map.get("贷记卡逾期单月最高逾期总额"));
		creditCardOverdue.setLongestOverDueMonthCount(map.get("贷记卡逾期最长逾期月数"));
		creditCardOverdue.setMonthCount(map.get("贷记卡逾期月份数"));

		loanOverDueInfo.setCount(map.get("贷款逾期笔数"));
		loanOverDueInfo.setHighestMonthlyTotalAmount(map.get("贷款逾期单月最高逾期总额"));
		loanOverDueInfo.setLongestOverDueMonthCount(map.get("贷款逾期最长逾期月数"));
		loanOverDueInfo.setMonthCount(map.get("贷款逾期月份数"));

		quasiCreditOverdraftAbove60Days.setAccountCount(map
				.get("准贷记卡60天以上透支账户数"));
		quasiCreditOverdraftAbove60Days.setHighestMonthlyTotalAmount(map
				.get("准贷记卡60天以上透支单月最高透支余额"));
		quasiCreditOverdraftAbove60Days.setLongestOverDueMonthCount(map
				.get("准贷记卡60天以上透支最长透支月数"));
		quasiCreditOverdraftAbove60Days
				.setMonthCount(map.get("准贷记卡60天以上透支月份数"));

		summaryOverdueInfo
				.setQuasiCreditOverdraftAbove60Days(quasiCreditOverdraftAbove60Days);
		summaryOverdueInfo.setCreditCardOverdue(creditCardOverdue);
		summaryOverdueInfo.setLoanOverDueInfo(loanOverDueInfo);
		logger.info("逾期（透支）信息汇总:" + summaryOverdueInfo);

		return summaryOverdueInfo;
	}

	@Override
	public SummaryOutstandingInfo getSummaryOutstandingInfo() throws Exception {

		SummaryOutstandingInfo summaryOutstandingInfo = new SummaryOutstandingInfo();

		WebElement e = this.getElement(this.getDriver(), "合同总额", "贷款法人机构数",
				"贷款机构数", "余额");
		Map<String, String> map = this.getKeyValue(e, "余额", "合同总额", "笔数", "笔数",
				"最近6个月平均应还款", "贷款机构数", "贷款法人机构数");

		summaryOutstandingInfo.setBalance(map.get("余额"));
		summaryOutstandingInfo.setContractTotalAmount(map.get("合同总额"));
		summaryOutstandingInfo.setCount(map.get("笔数"));
		summaryOutstandingInfo
				.setLast6MonthsAvgRepayment(map.get("最近6个月平均应还款"));
		summaryOutstandingInfo.setLoanInstitutionCount(map.get("贷款机构数"));
		summaryOutstandingInfo.setLoanLegalCount(map.get("贷款法人机构数"));
		logger.info("未结清贷款信息汇总:" + summaryOutstandingInfo);
		return summaryOutstandingInfo;

	}

	@Override
	public SummaryNotCloseCreditInfo getSummaryNotCloseCreditInfo()
			throws Exception {
		SummaryNotCloseCreditInfo summaryNotCloseCreditInfo = new SummaryNotCloseCreditInfo();

		WebElement e = this
				.getElement(this.getDriver(), "已用额度", "发卡机构数", "账户数",
						"发卡法人机构数", "授信总额", "单家行最高授信额", "最近6个月平均使用额度",
						"单家行最低授信额");
		Map<String, String> map = this.getKeyValue(e, "已用额度", "发卡机构数", "账户数",
				"发卡法人机构数", "授信总额", "单家行最高授信额", "最近6个月平均使用额度", "单家行最低授信额");

		summaryNotCloseCreditInfo.setAccountCount(map.get("账户数"));
		summaryNotCloseCreditInfo.setCardIssuerCount(map.get("发卡机构数"));
		summaryNotCloseCreditInfo.setCardOfferLegalCounts(map.get("发卡法人机构数"));
		summaryNotCloseCreditInfo.setCreditTotalLine(map.get("授信总额"));
		summaryNotCloseCreditInfo.setHighestCreditLine(map.get("单家行最高授信额"));
		summaryNotCloseCreditInfo.setLast6MonthsAvgUsedLine(map
				.get("最近6个月平均使用额度"));
		summaryNotCloseCreditInfo.setLowestCreditLine(map.get("单家行最低授信额"));
		summaryNotCloseCreditInfo.setUsedLine(map.get("已用额度"));

		logger.info("未销户贷记卡信息汇总:" + summaryNotCloseCreditInfo);
		return summaryNotCloseCreditInfo;
	}

	@Override
	public SummaryQuasiCreditInfo getSummaryQuasiCreditInfo() throws Exception {
		SummaryQuasiCreditInfo summaryQuasiCreditInfo = new SummaryQuasiCreditInfo();
		WebElement e = this.getElement(this.getDriver(), "透支余额", "账户数",
				"发卡机构数", "发卡法人机构数", "授信总额", "单家行最高授信额", "最近6个月平均透支余额",
				"单家行最低授信额");
		Map<String, String> map = this.getKeyValue(e, "透支余额", "账户数", "发卡机构数",
				"发卡法人机构数", "授信总额", "单家行最高授信额", "最近6个月平均透支余额", "单家行最低授信额");

		summaryQuasiCreditInfo.setAccountCount(map.get("账户数"));
		summaryQuasiCreditInfo.setCardIssuerCount(map.get("发卡机构数"));
		summaryQuasiCreditInfo.setCardOfferLegalCounts(map.get("发卡法人机构数"));
		summaryQuasiCreditInfo.setCreditTotalAmount(map.get("授信总额"));
		summaryQuasiCreditInfo.setHighestCreditAmount(map.get("单家行最高授信额"));
		summaryQuasiCreditInfo.setLast6MonthsAvgOverDraftBalance(map
				.get("最近6个月平均透支余额"));
		summaryQuasiCreditInfo.setLowestCreditAmount(map.get("单家行最低授信额"));
		summaryQuasiCreditInfo.setOverDraftBalance(map.get("透支余额"));

		logger.info("未销户准贷记卡信息汇总:" + summaryQuasiCreditInfo);
		return summaryQuasiCreditInfo;
	}

	@Override
	public SummaryGuaranteeInfo getSummaryGuaranteeInfo() throws Exception {
		SummaryGuaranteeInfo summaryGuaranteeInfo = new SummaryGuaranteeInfo();
		WebElement e = this.getElement(this.getDriver(), "担保金额", "担保笔数",
				"担保本金余额");
		Map<String, String> map = this.getKeyValue(e, "担保金额", "担保笔数", "担保本金余额");

		summaryGuaranteeInfo.setGuaranteeAmount(map.get("担保金额"));
		summaryGuaranteeInfo.setGuaranteeCount(map.get("担保笔数"));
		summaryGuaranteeInfo.setGuaranteePrincipalBalance(map.get("担保本金余额"));
		logger.info("对外担保信息汇总:" + summaryGuaranteeInfo);
		return summaryGuaranteeInfo;
	}

	@Override
	public List<AssertDisposeDetailInfo> getAssertDisposeDetailInfos()
			throws Exception {
		List<AssertDisposeDetailInfo> assertDisposeDetailInfos = new ArrayList<AssertDisposeDetailInfo>();
		WebElement e = this.getElement(this.getDriver(), "资产管理公司", "债务接收日期",
				"最近一次还款日期");
		List<Map<String, String>> listData = this.getListData(e, "资产管理公司",
				"债务接收日期", "最近一次还款日期", "余额", "接收的债权金额", "编号");

		for (Map<String, String> map : listData) {
			AssertDisposeDetailInfo detailInfo = new AssertDisposeDetailInfo();
			detailInfo.setAssetManagementCompany(map.get("资产管理公司"));
			detailInfo.setBalance(map.get("余额"));
			detailInfo.setDebtReceivedDate(map.get("债务接收日期"));
			detailInfo.setLastRepaymentDate(map.get("最近一次还款日期"));
			detailInfo.setReceivedCreditAmount(map.get("接收的债权金额"));
			detailInfo.setSerial(map.get("编号"));
			assertDisposeDetailInfos.add(detailInfo);
		}
		logger.info("资产处置信息:" + assertDisposeDetailInfos);
		return assertDisposeDetailInfos;
	}

	@Override
	public List<GuarantorCompensationDetailInfo> getGuarantorCompensationDetailInfos()
			throws Exception {
		List<GuarantorCompensationDetailInfo> compensationDetailInfos = new ArrayList<GuarantorCompensationDetailInfo>();

		WebElement e = this.getElement(this.getDriver(), "代偿机构", "最近一次代偿日期",
				"累计代偿金额");
		List<Map<String, String>> listData = this.getListData(e, "代偿机构",
				"最近一次代偿日期", "累计代偿金额", "余额", "编号", "最近一次还款日期");

		for (Map<String, String> map : listData) {

			GuarantorCompensationDetailInfo compensationDetailInfo = new GuarantorCompensationDetailInfo();
			compensationDetailInfo.setBalance(map.get("余额"));
			compensationDetailInfo.setCompensationInstitutionCount(map
					.get("代偿机构"));
			compensationDetailInfo.setLastCompensationDate(map.get("最近一次代偿日期"));
			compensationDetailInfo.setLastRepaymentDate(map.get("最近一次还款日期"));
			compensationDetailInfo.setSerial(map.get("编号"));
			compensationDetailInfo
					.setTotalCompensationAmount(map.get("累计代偿金额"));

			compensationDetailInfos.add(compensationDetailInfo);
		}
		logger.info("保证人代偿信息:" + compensationDetailInfos);
		return compensationDetailInfos;
	}

	@Override
	public List<LoanInfo> getLoanInfos() throws Exception {
		List<LoanInfo> loanInfos = new ArrayList<LoanInfo>();
		WebElement e = null;
		String[] finder = { "业务号", "发放的", "贷款" };

		try {
			e = this.getElement(this.getDriver(), finder);
		} catch (Exception ex) {
			finder = new String[] { "贷款种类", "业务号", "贷款机构名称" };
			e = this.getElement(this.getDriver(), finder);
		}

		List<WebElement> elements = this.getElements(e, new String[] { "贷记卡" },
				finder);

		for (int i = 0; i < elements.size(); i++) {
			WebElement title = elements.get(i);
			String totalDescription = elements.get(i).getText()
					.replaceAll("\\s", "");
			if (!title.getText().contains("贷记卡")) {
				//System.out.println(title.getText().replaceAll("\\s", ""));
				LoanInfo loanInfo = new LoanInfo();
				loanInfo.setTotalDescription(totalDescription);

				this.setLoanInfo(loanInfo, title);

				//System.out.println(loanInfo);
				loanInfos.add(loanInfo);
			}
		}

		for (LoanInfo loanInfo : loanInfos) {
			logger.info("贷款信息----"+loanInfo);
		}
		return loanInfos;
	}

	/**
	 * 根据标题输入数据
	 * 
	 * @param loanInfo
	 * @param title
	 * @throws Exception
	 */
	private void setLoanInfo(LoanInfo loanInfo, WebElement title)
			throws Exception {

		LoanDetailInfo loanDetailInfo = new LoanDetailInfo();

		String txt = title.getText().replaceAll("\\s", "");
		if (txt.contains("贷款种类") && txt.contains("业务号")
				&& txt.contains("贷款机构名称")) {
			loanInfo.setTotalDescription(null);
			Map<String, String> map = this.getKeyValue(title, "贷款种类", "业务号",
					"贷款机构名称", "担保方式", "币种");
			loanDetailInfo.setLoanType(map.get("贷款种类细分") == null ? map
					.get("贷款种类") : map.get("贷款种类细分"));
			loanDetailInfo.setServiceNo(map.get("业务号"));
			loanDetailInfo.setLoanInstitution(map.get("贷款机构") == null ? map
					.get("贷款机构名称") : map.get("贷款机构"));
			loanDetailInfo.setGuaranteeWay(map.get("担保方式"));
			loanDetailInfo.setCurrency(map.get("币种"));
			loanDetailInfo.setStatus(map.get("状态") == null ? map.get("账户状态")
					: map.get("状态"));
			loanInfo.setLoanDetailInfo(loanDetailInfo);

		}

		String e = this.getNextElement(title).getText().replaceAll("\\s", "");

		if (e.contains("贷记卡")) {
			return;
		}

		List<WebElement> trs = new ArrayList<WebElement>();
		String tagName = title.getTagName();
		List<WebElement> eles = title
				.findElements(By.xpath("./following-sibling::" + tagName
						+ " | ./following::tr"));
		for (int i = 0; i < eles.size(); i++) {
			String str = eles.get(i).getText().replaceAll("\\s", "");
			if (str.contains("业务号") || str.contains("贷记卡")) {
				break;
			}
			trs.add(eles.get(i));
		}

		for (int i = 0; i < trs.size(); i++) {
			String tr_value = trs.get(i).getText().replaceAll("\\s", "");

			WebElement ele = trs.get(i);
			if (tr_value.contains("五级分类") && tr_value.contains("应还款日")) {
				Map<String, String> map = this.getKeyValue(ele, "五级分类", "本金余额",
						"剩余还款期数", "本月应还款", "应还款日");
				loanDetailInfo.setFiveClassification(map.get("五级分类"));
				loanDetailInfo.setScheduledRepayment(map.get("本月应还款"));
				loanDetailInfo.setScheduledRepaymentDate(map.get("应还款日"));
				loanDetailInfo.setRemainRepaymentPeriodCount(map.get("剩余还款期数"));
				loanDetailInfo.setRealRepayment(map.get("本月实还款"));
				loanDetailInfo.setPrincipalBalance(map.get("本金余额"));
				loanDetailInfo.setLastRepaymentDate(map.get("最近一次还款日期"));
				loanInfo.setLoanDetailInfo(loanDetailInfo);
			}
			if (tr_value.contains("未还本金") && tr_value.contains("当前逾期")) {
				Map<String, String> map = this.getKeyValue(ele, "当前逾期期数",
						"当前逾期金额", "60天未还本金", "90天未还本金", "180天未还本金",
						"逾期180天以上未还本金");
				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("180天以上")) {
						loanDetailInfo.setOverdue180DaysAbovePrincipal(map
								.get(key));
					}
					if (key.contains("90")) {
						loanDetailInfo.setOverdue61_90DaysPrincipal(map
								.get(key));
					}
					if (key.contains("60天")) {
						loanDetailInfo.setOverdue31_60DaysPrincipal(map
								.get(key));
					}
					if (key.contains("91")) {
						loanDetailInfo.setOverdue91_180DaysPrincipal(map
								.get(key));
					}
					if (key.contains("180")) {
						loanDetailInfo.setOverdue180DaysAbovePrincipal(map
								.get(key));
					}
					if (key.contains("180")) {
						loanDetailInfo.setOverdue180DaysAbovePrincipal(map
								.get(key));
					}
				}

				loanDetailInfo.setOverDueAmount(map.get("当前逾期金额"));

				loanDetailInfo.setOverDuePeriodCount(map.get("当前逾期期数"));
				loanInfo.setLoanDetailInfo(loanDetailInfo);
			}
			if (tr_value.contains("贷款机构说明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "贷款机构说明",
						"添加日期");
				loanInfo.setLoanInstitutionDeclare(map.get("贷款机构说明"));
				loanInfo.setDeclareDate_1(map.get("添加日期"));
			}
			if (tr_value.contains("本人声明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "本人声明", "添加日期");
				loanInfo.setLoanerDeclare(map.get("本人声明"));
				loanInfo.setDeclareDate_2(map.get("添加日期"));
			}
			if (tr_value.contains("异议标注") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "异议标注", "添加日期");

				System.out.println(map.get("异议标注"));
				loanInfo.setDissentMark(map.get("异议标注"));
				loanInfo.setDeclareDate_3(map.get("添加日期"));
			}
			if (tr_value.contains("发生日期") && tr_value.contains("发生金额")
					&& tr_value.contains("特殊交易类型")) {
				Map<String, String> map = this.getKeyValue(ele, "发生日期",
						"特殊交易类型", "发生金额");

				loanInfo.setSpecialTradeType(map.get("特殊交易类型"));
				loanInfo.setOccurAmount(map.get("发生金额"));
				loanInfo.setOccurDate(map.get("发生日期"));
				loanInfo.setOverdueRemark(map.get("明细记录"));
				loanInfo.setChangedMonthCount(map.get("变更月数"));
			}

			if (tr_value.contains("的还款记录")) {
				WebElement value = ele.findElement(By
						.xpath("./following-sibling::*[1]"));
				loanInfo.setRepaymentRecord_24(tr_value);
				loanInfo.setRepaymentRecord_24Title(value.getText().replaceAll(
						"\\s", ""));
			}

			if (tr_value.contains("状态") && tr_value.contains("状态截止日")) {
				Map<String, String> map = new HashMap<String, String>();
				try {
					List<WebElement> k_v = trs.get(i).findElements(
							By.xpath("./child::*"));
					int size = k_v.size();
					if (size <= 4) {
						for (int j = 0; j < size; j++) {
							String key = k_v.get(j).getText()
									.replaceAll("\\s", "");
							String value = k_v.get(j + 1).getText()
									.replaceAll("\\s", "");
							map.put(key, value);
							j++;
						}
					} else {

						map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));

					}
				} catch (Exception ex) {
					map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));
				}
				loanDetailInfo.setStatus(map.get("状态"));
				loanDetailInfo.setStateDeadline(map.get("状态截止日"));

			}
			if (tr_value.contains("的逾期记录") || tr_value.contains("逾期记录")) {
				loanInfo.setLoanOverdue_24_InfoTitle(tr_value);
				List<LoanOverdue_24_Info> loanOverdue_24_Infos = new ArrayList<LoanOverdue_24_Info>();

				int count = 1;
				while (true) {
					WebElement key = ele.findElement(By
							.xpath("./following::tr[1]"));
					// 获取下一个元素tr
					WebElement vs = key.findElement(By.xpath("./following::tr["
							+ count + "]"));
					List<WebElement> keys = key.findElements(By
							.xpath("./child::*"));

					String keyStr = key.getText().replaceAll("\\s", "");
					List<WebElement> values = vs.findElements(By
							.xpath("./child::*"));
					int keysCount = keys.size();
					int valuesCount = values.size();

					if (keysCount != valuesCount) {
						break;
					}
					if (this.isContainChinese(vs.getText()
							.replaceAll("\\s", ""))) {
						break;
					}

					if (keysCount != valuesCount) {
						break;
					}
					LoanOverdue_24_Info info1 = new LoanOverdue_24_Info();
					LoanOverdue_24_Info info2 = new LoanOverdue_24_Info();
					if (keyStr.length() / 2 == 14) {
						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");
							if (j < keysCount / 2) {
								if (k.contains("逾期月份")) {
									info1.setOverdueMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info1.setOverdueMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info1.setOverdueAmount(v);
								}
							} else {
								if (k.contains("逾期月份")) {
									info2.setOverdueMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info2.setOverdueMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info2.setOverdueAmount(v);
								}
							}

						}
						loanOverdue_24_Infos.add(info1);
						loanOverdue_24_Infos.add(info2);
					} else {

						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");

							if (k.contains("逾期月份")) {
								info2.setOverdueMonth(v);
							}
							if (k.contains("逾期持续月数")) {
								info2.setOverdueMonthCount(v);
							}
							if (k.contains("逾期金额")) {
								info2.setOverdueAmount(v);
							}

						}
						loanOverdue_24_Infos.add(info2);
					}
					count++;
				}
				loanInfo.setLoanOverdue_24_Infos(loanOverdue_24_Infos);
			}
		}

		// title.findElement(By.xpath(""))
		// this.getNextElement(title, new String[]{"贷记卡"},"","","","");

		loanInfo.setLoanDetailInfo(loanDetailInfo);
	}

	/**
	 * 是否包含中文字符
	 * 
	 * @param str
	 * @return
	 */
	private boolean isContainChinese(String str) {

		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			return true;
		}
		return false;
	}

	@Override
	public List<CreditCardInfo> getCreditCardInfos() throws Exception {
		List<CreditCardInfo> creditCardInfos = new ArrayList<CreditCardInfo>();
		String xpath = "//*[contains(text(),'）贷记卡')]/ancestor::*/following-sibling::p";
		// 获取所有的贷记卡信息
		List<WebElement> txts = driver.findElements(By.xpath(xpath));// 个人信用报告（银行专业版）样本.htm

		boolean isValueNull = false;
		String str = null;
		for (WebElement txt : txts) {
			str += txt.getText();
		}
		if (str == null || str.trim().length() < 5) {//
			isValueNull = true;
		}

		/**
		 * 如果贷记卡不为空，并且不是中行的
		 */
		if (!isValueNull
				&& txts != null
				&& txts.size() > 0
				&& !WebdriverUtil.isElementExist(driver,
						"//*[contains(text(),'贷款机构名称')]")) {

			this.putCreditCardInfo(creditCardInfos, txts);
		}
		/**
		 * 不是特殊的
		 */
		else {

			txts = driver.findElements(By
					.xpath("//*[contains(text(),'贷记卡')]/following::tr"));// 陈明.htm
			this.putCreditCardInfo(creditCardInfos, txts);
		}

		
		for (CreditCardInfo creditCardInfo : creditCardInfos) {
			logger.info("贷记卡信息----"+creditCardInfo);
		}
		return creditCardInfos;
	}

	/**
	 * 存放页面中的贷记卡信息
	 * 
	 * @param creditCardInfos
	 * @param txts
	 * @throws Exception
	 */
	private void putCreditCardInfo(List<CreditCardInfo> creditCardInfos,
			List<WebElement> txts) throws Exception {
		for (int i = 0; i < txts.size(); i++) {
			String titleStr = txts.get(i).getText().replaceAll("\\s", "");
			WebElement title = txts.get(i);
			if (titleStr.contains("准贷记卡")) {
				break;
			}

			if (titleStr.length() > 30 && titleStr.contains("发放的")
					&& titleStr.contains("贷记卡")) {

				//System.out.println(titleStr);
				CreditCardInfo cardInfo = new CreditCardInfo();
				cardInfo.setTotalDescription(titleStr);
				this.setCreditCardInfo(cardInfo, title);
				
				//System.out.println("==="+cardInfo);
				creditCardInfos.add(cardInfo);

			} else {
				if (titleStr.contains("业务号")) {
					CreditCardInfo cardInfo = new CreditCardInfo();
					cardInfo.setTotalDescription(titleStr);
					this.setCreditCardInfo(cardInfo, title);
					creditCardInfos.add(cardInfo);
				}

			}
		}

	}

	/**
	 * 设置贷记卡信息
	 * 
	 * @param creditCardInfo
	 * @param title
	 * @throws Exception
	 */
	private void setCreditCardInfo(CreditCardInfo creditCardInfo,
			WebElement title) throws Exception {

		CreditCardDetailInfo cardDetailInfo = new CreditCardDetailInfo();
		String txt = title.getText().replaceAll("\\s", "");
		if (txt.contains("发卡机构") && txt.contains("业务号") && txt.contains("币种")
				&& txt.contains("发卡日期")) {
			Map<String, String> map = this.getKeyValue(title, "发卡机构", "业务号",
					"发卡日期");
			cardDetailInfo.setCardIssuer(map.get("发卡机构"));
			cardDetailInfo.setCreditLine(map.get("授信额度"));
			cardDetailInfo.setCurrency(map.get("币种"));
			cardDetailInfo.setGuaranteeWay(map.get("担保方式"));
			cardDetailInfo.setIssueDate(map.get("发卡日期"));
			cardDetailInfo.setServiceNo(map.get("业务号"));
			cardDetailInfo.setIssueDate(map.get("发卡日期"));
			cardDetailInfo.setStatus(map.get("状态") == null ? map.get("账户状态")
					: map.get("状态"));
		}

		String e = this.getNextElement(title).getText().replaceAll("\\s", "");

		if (e.contains("准贷记卡")) {
			return;
		}

		List<WebElement> trs = new ArrayList<WebElement>();
		String tagName = title.getTagName();
		List<WebElement> eles = title
				.findElements(By.xpath("./following-sibling::" + tagName
						+ " | ./following::tr"));
		for (int i = 0; i < eles.size(); i++) {
			String str = eles.get(i).getText().replaceAll("\\s", "");
			if (str.contains("业务号") || str.contains("准贷记卡")) {
				break;
			}
			trs.add(eles.get(i));
		}

		for (int i = 0; i < trs.size(); i++) {
			String tr_value = trs.get(i).getText().replaceAll("\\s", "");
			WebElement ele = trs.get(i);
			if (tr_value.contains("共享额度") && tr_value.contains("已用额度")) {
				Map<String, String> map = this.getKeyValue(ele, "共享额度", "已用额度",
						"最大使用额度");

				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("共享额度")) {
						cardDetailInfo.setSharedLine(map.get(key));
					}
					if (key.contains("已用额度")) {
						cardDetailInfo.setUsedLine(map.get(key));
					}
					if (key.contains("平均使用额度")) {
						cardDetailInfo.setLast6MonthsAvgUsedLine(map.get(key));
					}
					if (key.contains("最大使用")) {
						cardDetailInfo.setMaxUsedLine(map.get(key));
					}
					if (key.contains("本月应还款")) {
						cardDetailInfo.setScheduledRepayment(map.get(key));
					}
				}

				creditCardInfo.setCardDetailInfo(cardDetailInfo);
			}
			if (tr_value.contains("账单日") && tr_value.contains("本月实还款")
					&& tr_value.contains("当前逾期期数")) {
				Map<String, String> map = this.getKeyValue(ele, "账单日", "本月实还款",
						"当前逾期期数");
				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("账单日")) {
						cardDetailInfo.setBillDate(map.get(key));
					}
					if (key.contains("本月实还款")) {
						cardDetailInfo.setRealRepayment(map.get(key));
					}
					if (key.contains("最近一次还款日期")) {
						cardDetailInfo.setLastRepaymentDate(map.get(key));
					}
					if (key.contains("当前逾期期数")) {

						cardDetailInfo.setOverDuePeriodCount(map.get(key));
					}
					if (key.contains("当前逾期金额")) {
						cardDetailInfo.setOverDueAmount(map.get(key));
					}
				}
				creditCardInfo.setCardDetailInfo(cardDetailInfo);
			}

			if (tr_value.contains("发生日期") && tr_value.contains("特殊交易类型")) {
				Map<String, String> map = this.getKeyValue(ele, "发生日期",
						"特殊交易类型");

				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("特殊交易类型")) {
						creditCardInfo.setSpecialTradeType(map.get(key));
					}
					if (key.contains("发生日期")) {
						creditCardInfo.setOccurDate(map.get(key));
					}
					if (key.contains("变更月数")) {
						creditCardInfo.setChangedMonthCount(map.get(key));
					}
					if (key.contains("发生金额")) {

						creditCardInfo.setOccurAmount(map.get(key));
					}
					if (key.contains("明细记录")) {
						creditCardInfo.setOverdueRemark(map.get(key));
					}
				}
				creditCardInfo.setCardDetailInfo(cardDetailInfo);
			}
			if (tr_value.contains("发卡机构说明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "发卡机构说明",
						"添加日期");
				creditCardInfo.setCardIssuerDeclare(map.get("发卡机构说明"));
				creditCardInfo.setDeclareDate_1(map.get("添加日期"));
			}
			if (tr_value.contains("本人声明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "本人声明", "添加日期");
				creditCardInfo.setLoanerDeclare(map.get("本人声明"));
				creditCardInfo.setDeclareDate_2(map.get("添加日期"));
			}
			if (tr_value.contains("异议标注") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "异议标注", "添加日期");

				creditCardInfo.setDissentMark(map.get("异议标注"));
				creditCardInfo.setDeclareDate_3(map.get("添加日期"));
			}

			if (tr_value.contains("的还款记录")) {
				WebElement value = ele.findElement(By
						.xpath("./following-sibling::*[1]"));
				creditCardInfo.setRepaymentRecord_24(tr_value);
				creditCardInfo.setRepaymentRecord_24Title(value.getText()
						.replaceAll("\\s", ""));
			}
			if (tr_value.contains("状态") && tr_value.contains("状态截止日")) {
				Map<String, String> map = new HashMap<String, String>();
				try {
					List<WebElement> k_v = trs.get(i).findElements(
							By.xpath("./child::*"));
					int size = k_v.size();
					if (size <= 4) {
						for (int j = 0; j < size; j++) {
							String key = k_v.get(j).getText()
									.replaceAll("\\s", "");
							String value = k_v.get(j + 1).getText()
									.replaceAll("\\s", "");
							map.put(key, value);
							j++;
						}
					} else {

						map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));

					}
				} catch (Exception ex) {
					map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));
				}
				cardDetailInfo.setStatus(map.get("状态"));
				cardDetailInfo.setStateDeadline(map.get("状态截止日"));
				creditCardInfo.setCardDetailInfo(cardDetailInfo);
			}

			if (tr_value.contains("的逾期记录") || tr_value.contains("逾期记录")) {
				List<CreditCardOverdue_24_Info> creditCardOverdue_24_Infos = new ArrayList<CreditCardOverdue_24_Info>();
				creditCardInfo.setCreditCardOverdue_24_InfosTitle(tr_value);
				int count = 1;
				while (true) {
					WebElement key = ele.findElement(By
							.xpath("./following::tr[1]"));
					// 获取下一个元素tr
					WebElement vs = key.findElement(By.xpath("./following::tr["
							+ count + "]"));
					List<WebElement> keys = key.findElements(By
							.xpath("./child::*"));

					String keyStr = key.getText().replaceAll("\\s", "");
					List<WebElement> values = vs.findElements(By
							.xpath("./child::*"));
					int keysCount = keys.size();
					int valuesCount = values.size();

					if (keysCount != valuesCount) {
						break;
					}
					if (this.isContainChinese(vs.getText()
							.replaceAll("\\s", ""))) {
						break;
					}

					if (keysCount != valuesCount) {
						break;
					}
					CreditCardOverdue_24_Info info1 = new CreditCardOverdue_24_Info();
					CreditCardOverdue_24_Info info2 = new CreditCardOverdue_24_Info();
					if (keyStr.length() / 2 == 14) {
						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");
							if (j < keysCount / 2) {
								if (k.contains("逾期月份")) {
									info1.setOverdueMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info1.setOverdueMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info1.setOverdueAmount(v);
								}
							} else {
								if (k.contains("逾期月份")) {
									info2.setOverdueMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info2.setOverdueMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info2.setOverdueAmount(v);
								}
							}

						}
						creditCardOverdue_24_Infos.add(info1);
						creditCardOverdue_24_Infos.add(info2);
					} else if (keyStr.length() == 14) {

						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");

							if (k.contains("逾期月份")) {
								info2.setOverdueMonth(v);
							}
							if (k.contains("逾期持续月数")) {
								info2.setOverdueMonthCount(v);
							}
							if (k.contains("逾期金额")) {
								info2.setOverdueAmount(v);
							}

						}
						creditCardOverdue_24_Infos.add(info2);
					} else {
						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");

							if (k.contains("逾期月份")) {
								info2.setOverdueMonthSpecial(v);
							}
							if (k.contains("逾期持续月数")) {
								info2.setOverdueMonthCountSpecial(v);
							}
							if (k.contains("逾期金额")) {
								info2.setOverDueAmountSpecial(v);
							}
							if (k.contains("起始月")) {
								info2.setStartMonthSpecial(v);
							}
							if (k.contains("截止月")) {
								info2.setEndMonthSpecial(v);
							}
						}
						creditCardOverdue_24_Infos.add(info2);
					}
					count++;
				}
				creditCardInfo
						.setCreditCardOverdue_24_Infos(creditCardOverdue_24_Infos);
			}
		}

	}

	@Override
	public List<QuasiCreditInfo> getQuasiCreditInfos() throws Exception {
		List<QuasiCreditInfo> quasiCreditInfos = new ArrayList<QuasiCreditInfo>();
		String xpath = "//*[contains(text(),'准贷记卡')]/ancestor::*/following-sibling::p";
		// 获取所有的贷记卡信息
		List<WebElement> txts = driver.findElements(By.xpath(xpath));// 个人信用报告（银行专业版）样本.htm

		boolean isValueNull = false;
		String str = null;
		for (WebElement txt : txts) {
			str += txt.getText();
		}
		if (str == null || str.trim().length() < 5) {//
			isValueNull = true;
		}

		/**
		 * 如果贷记卡不为空，并且不是中行的
		 */
		if (!isValueNull
				&& txts != null
				&& txts.size() > 0
				&& !WebdriverUtil.isElementExist(driver,
						"//*[contains(text(),'贷款机构名称')]")) {
			//System.out.println("=================");

			this.putQuasiCreditInfo(quasiCreditInfos, txts);
		}
		/**
		 * 不是特殊的
		 */
		else {
			//System.out.println("********");
			txts = driver.findElements(By
					.xpath("//*[contains(text(),'准贷记卡')]/following::tr"));// 陈明.htm
			this.putQuasiCreditInfo(quasiCreditInfos, txts);
		}

		for (QuasiCreditInfo quasiCreditInfo : quasiCreditInfos) {
			logger.info("准贷记卡信息----"+quasiCreditInfo);
		}
		
		return quasiCreditInfos;
	}

	/**
	 * 
	 * @param quasiCreditInfos
	 * @param txts
	 * @throws Exception 
	 */
	private void putQuasiCreditInfo(List<QuasiCreditInfo> quasiCreditInfos,
			List<WebElement> txts) throws Exception {

		for (int i = 0; i < txts.size(); i++) {
			String titleStr = txts.get(i).getText().replaceAll("\\s", "");
			WebElement title = txts.get(i);
			if (titleStr.contains("欠税记录")) {
				break;
			}

			if (titleStr.length() > 30 && titleStr.contains("发放的")
					&& titleStr.contains("准贷记卡")) {
				//System.out.println(titleStr);
				QuasiCreditInfo quasiCreditInfo = new QuasiCreditInfo();
				quasiCreditInfo.setTotalDescription(titleStr);
				this.QuasiCreditInfo(quasiCreditInfo, title);
				quasiCreditInfos.add(quasiCreditInfo);

			} else {
				if (titleStr.contains("业务号")&& titleStr.contains("发卡机构")) {
					QuasiCreditInfo quasiCreditInfo = new QuasiCreditInfo();
					quasiCreditInfo.setTotalDescription(titleStr);
					this.QuasiCreditInfo(quasiCreditInfo, title);
					quasiCreditInfos.add(quasiCreditInfo);
				}

			}
		}

	}

	/**
	 * 输入准贷记卡信息
	 * 
	 * @param quasiCreditInfo
	 * @param title
	 * @throws Exception 
	 */
	private void QuasiCreditInfo(QuasiCreditInfo quasiCreditInfo,
			WebElement title) throws Exception {

		QuasiCreditDetailInfo quasiCreditDetailInfo = new QuasiCreditDetailInfo();
		String txt = title.getText().replaceAll("\\s", "");
		if (txt.contains("发卡机构") && txt.contains("业务号") && txt.contains("币种")
				&& txt.contains("发卡日期")) {
			Map<String, String> map = this.getKeyValue(title, "发卡机构", "业务号",
					"发卡日期");
			quasiCreditDetailInfo.setCardIssuer(map.get("发卡机构"));
			quasiCreditDetailInfo.setCreditLine(map.get("授信额度"));
			quasiCreditDetailInfo.setCurrency(map.get("币种"));
			quasiCreditDetailInfo.setGuaranteeWay(map.get("担保方式"));
			quasiCreditDetailInfo.setIssueDate(map.get("发卡日期"));
			quasiCreditDetailInfo.setServiceNo(map.get("业务号"));
			quasiCreditDetailInfo.setIssueDate(map.get("发卡日期"));
			quasiCreditDetailInfo.setStatus(map.get("状态") == null ? map
					.get("账户状态") : map.get("状态"));
			quasiCreditInfo.setQuasiCreditDetailInfo(quasiCreditDetailInfo);
		}

		String e = this.getNextElement(title).getText().replaceAll("\\s", "");

		if (e.contains("担保信息")) {
			return;
		}

		List<WebElement> trs = new ArrayList<WebElement>();
		String tagName = title.getTagName();
		List<WebElement> eles = title
				.findElements(By.xpath("./following-sibling::" + tagName
						+ " | ./following::tr"));
		for (int i = 0; i < eles.size(); i++) {
			String str = eles.get(i).getText().replaceAll("\\s", "");
			if (str.contains("业务号") || str.contains("担保信息")) {
				break;
			}
			trs.add(eles.get(i));
		}

		for (int i = 0; i < trs.size(); i++) {
			String tr_value = trs.get(i).getText().replaceAll("\\s", "");
			WebElement ele = trs.get(i);
			if (tr_value.contains("共享额度") && tr_value.contains("透支余额")
					&& tr_value.contains("最大透支余额") && tr_value.contains("未付余额")) {
				Map<String, String> map = this.getKeyValue(ele, "共享额度", "透支余额",
						"最大透支余额");

				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("共享额度")) {
						quasiCreditDetailInfo.setSharedLine(map.get(key));
					}
					if (key.contains("透支余额")) {
						quasiCreditDetailInfo.setOverDraftBalance(map.get(key));
					}
					if (key.contains("平均透支余额")) {
						quasiCreditDetailInfo
								.setLast6MonthsAvgOverDraftBalance(map.get(key));
					}
					if (key.contains("最大透支余额")) {
						quasiCreditDetailInfo.setMaxOverDraftBalance(map
								.get(key));
					}
					if (key.contains("账单日")) {
						quasiCreditDetailInfo.setBillDate(map.get(key));
					}
					if (key.contains("本月实还款")) {
						quasiCreditDetailInfo.setRealRepayment(map.get(key));
					}
					if (key.contains("最近一次还款日期")) {
						quasiCreditDetailInfo
								.setLastRepaymentDate(map.get(key));
					}
					if (key.contains("以上未付余额")) {
						quasiCreditDetailInfo.setOverdue180DaysAboveBalance(map
								.get(key));
					}
				}

				quasiCreditInfo.setQuasiCreditDetailInfo(quasiCreditDetailInfo);
			}

			if (tr_value.contains("发生日期") && tr_value.contains("特殊交易类型")) {
				Map<String, String> map = this.getKeyValue(ele, "发生日期",
						"特殊交易类型");

				Set<String> keySet = map.keySet();
				Iterator<String> it = keySet.iterator();
				while (it.hasNext()) {
					String key = it.next();
					if (key.contains("特殊交易类型")) {
						quasiCreditInfo.setSpecialTradeType(map.get(key));
					}
					if (key.contains("发生日期")) {
						quasiCreditInfo.setOccurDate(map.get(key));
					}
					if (key.contains("变更月数")) {
						quasiCreditInfo.setChangedMonthCount(map.get(key));
					}
					if (key.contains("发生金额")) {

						quasiCreditInfo.setOccurAmount(map.get(key));
					}
					if (key.contains("明细记录")) {
						quasiCreditInfo.setOverdueRemark(map.get(key));
					}
				}
				quasiCreditInfo.setQuasiCreditDetailInfo(quasiCreditDetailInfo);
			}
			if (tr_value.contains("发卡机构说明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "发卡机构说明",
						"添加日期");
				quasiCreditInfo.setCardIssuerDeclare(map.get("发卡机构说明"));
				quasiCreditInfo.setDeclareDate_1(map.get("添加日期"));
			}
			if (tr_value.contains("本人声明") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "本人声明", "添加日期");
				quasiCreditInfo.setLoanerDeclare(map.get("本人声明"));
				quasiCreditInfo.setDeclareDate_2(map.get("添加日期"));
			}
			if (tr_value.contains("异议标注") && tr_value.contains("添加日期")) {
				Map<String, String> map = this.getKeyValue(ele, "异议标注", "添加日期");

				quasiCreditInfo.setDissentMark(map.get("异议标注"));
				quasiCreditInfo.setDeclareDate_3(map.get("添加日期"));
			}

			if (tr_value.contains("的还款记录")) {
				WebElement value = ele.findElement(By
						.xpath("./following-sibling::*[1]"));
				quasiCreditInfo.setRepaymentRecord_24(tr_value);
				quasiCreditInfo.setRepaymentRecord_24Title(value.getText()
						.replaceAll("\\s", ""));
			}
			if (tr_value.contains("状态") && tr_value.contains("状态截止日")) {
				Map<String, String> map = new HashMap<String, String>();
				try {
					List<WebElement> k_v = trs.get(i).findElements(
							By.xpath("./child::*"));
					int size = k_v.size();
					if (size <= 4) {
						for (int j = 0; j < size; j++) {
							String key = k_v.get(j).getText()
									.replaceAll("\\s", "");
							String value = k_v.get(j + 1).getText()
									.replaceAll("\\s", "");
							map.put(key, value);
							j++;
						}
					} else {

						map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));

					}
				} catch (Exception ex) {
					map.putAll(this.getKeyValue(trs.get(i), "状态", "状态截止日"));
				}
				quasiCreditDetailInfo.setStatus(map.get("状态"));
				quasiCreditDetailInfo.setStateDeadline(map.get("状态截止日"));
				quasiCreditInfo.setQuasiCreditDetailInfo(quasiCreditDetailInfo);
			}

			if (tr_value.contains("的逾期记录") || tr_value.contains("逾期记录")) {

				List<QuasiCreditOverdueInfo> creditOverdueInfos = new ArrayList<QuasiCreditOverdueInfo>();
				quasiCreditInfo.setCreditOverdueInfosTitle(tr_value);
				int count = 1;
				while (true) {
					WebElement key = ele.findElement(By
							.xpath("./following::tr[1]"));
					// 获取下一个元素tr
					WebElement vs = key.findElement(By.xpath("./following::tr["
							+ count + "]"));
					List<WebElement> keys = key.findElements(By
							.xpath("./child::*"));

					String keyStr = key.getText().replaceAll("\\s", "");
					List<WebElement> values = vs.findElements(By
							.xpath("./child::*"));
					int keysCount = keys.size();
					int valuesCount = values.size();

					if (keysCount != valuesCount) {
						break;
					}
					if (this.isContainChinese(vs.getText()
							.replaceAll("\\s", ""))) {
						break;
					}

					if (keysCount != valuesCount) {
						break;
					}
					QuasiCreditOverdueInfo info1 = new QuasiCreditOverdueInfo();
					QuasiCreditOverdueInfo info2 = new QuasiCreditOverdueInfo();
					if (keyStr.length() / 2 == 14) {
						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");
							if (j < keysCount / 2) {
								if (k.contains("逾期月份")) {
									info1.setOverDraftMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info1.setOverDraftMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info1.setOverDraftAmount(v);
								}
							} else {
								if (k.contains("逾期月份")) {
									info2.setOverDraftMonth(v);
								}
								if (k.contains("逾期持续月数")) {
									info2.setOverDraftMonthCount(v);
								}
								if (k.contains("逾期金额")) {
									info2.setOverDraftAmount(v);
								}
							}

						}
						creditOverdueInfos.add(info1);
						creditOverdueInfos.add(info2);
					} else{

						for (int j = 0; j < keysCount; j++) {
							String k = keys.get(j).getText()
									.replaceAll("\\s", "");
							String v = values.get(j).getText()
									.replaceAll("\\s", "");
							if (k.contains("逾期月份")) {
								info2.setOverDraftMonth(v);
							}
							if (k.contains("逾期持续月数")) {
								info2.setOverDraftMonthCount(v);
							}
							if (k.contains("逾期金额")) {
								info2.setOverDraftAmount(v);
							}

						}
						creditOverdueInfos.add(info2);
					} 
					count++;
				}
				quasiCreditInfo.setCreditOverdueInfos(creditOverdueInfos);
			}
		}

	}

	@Override
	public List<GuaranteeDetailInfo> getGuaranteeDetailInfos() throws Exception {
		List<GuaranteeDetailInfo> detailInfos = new ArrayList<GuaranteeDetailInfo>();

		WebElement e = this
				.getElement(this.getDriver(), "担保贷款", "结算日期", "五级分类");
		List<Map<String, String>> listData = this.getListData(e, "担保贷款到期日期",
				"担保贷款五级分类", "担保金额", "担保贷款发放日期", "担保贷款合同金额", "担保贷款发放机构",
				"担保贷款本金余额", "担保贷款本金余额", "编号", "结算日期");

		for (Map<String, String> map : listData) {
			GuaranteeDetailInfo detailInfo = new GuaranteeDetailInfo();
			detailInfo.setDueDate(map.get("担保贷款到期日期"));
			detailInfo.setFiveClassification(map.get("担保贷款五级分类"));
			detailInfo.setGuaranteeAmount(map.get("担保金额"));
			detailInfo.setIssueDate(map.get("担保贷款发放日期"));
			detailInfo.setLoanContractAmount(map.get("担保贷款合同金额"));
			detailInfo.setLoanIssuer(map.get("担保贷款发放机构"));
			detailInfo.setPrincipalBalance(map.get("担保贷款本金余额"));
			detailInfo.setSerial(map.get("编号"));
			detailInfo.setSettlementDate(map.get("结算日期"));
			detailInfos.add(detailInfo);
		}
		logger.info("对外担保信息:" + detailInfos);
		return detailInfos;
	}

	@Override
	public List<TaxesInfo> getTaxesInfos() throws Exception {
		List<TaxesInfo> taxesInfos = new ArrayList<TaxesInfo>();
		WebElement e = this.getElement(this.getDriver(), "欠税总额", "欠税统计日期",
				"主管税务机关");
		List<Map<String, String>> listData = this.getListData(e, "欠税总额",
				"欠税统计日期", "主管税务机关");

		for (Map<String, String> map : listData) {
			TaxesInfo info = new TaxesInfo();

			info.setSerial(map.get("编号"));
			info.setStatisticalDate(map.get("欠税统计日期"));
			info.setTaxAuthorities(map.get("主管税务机关"));
			info.setTaxesTotalAmount(map.get("欠税总额"));
			taxesInfos.add(info);
		}
		logger.info("欠税记录:" + taxesInfos);
		return taxesInfos;
	}

	@Override
	public List<CivilJudgmentInfo> getCivilJudgmentInfos() throws Exception {

		List<CivilJudgmentInfo> civilJudgmentInfos = new ArrayList<CivilJudgmentInfo>();

		WebElement e = this.getElement(this.getDriver(), "立案法院", "立案日期", "案由");
		WebElement e2 = this.getElement(this.getDriver(), "诉讼标的", "诉讼标的金额",
				"生效日期");
		List<Map<String, String>> listData = this.getListData(e, e2,
				new String[] { "立案法院", "立案日期", "案由" }, "判决/调解结果", "判决/调解生效日期",
				"诉讼标的");

		for (Map<String, String> map : listData) {
			CivilJudgmentInfo civilJudgmentInfo = new CivilJudgmentInfo();

			civilJudgmentInfo.setDecisionResults(map.get("判决/调解结果"));
			civilJudgmentInfo.setEffectiveDate(map.get("判决/调解生效日期"));
			civilJudgmentInfo.setFileCourt(map.get("立案法院"));
			civilJudgmentInfo.setFileDate(map.get("立案日期"));
			civilJudgmentInfo.setFileReason(map.get("案由"));
			civilJudgmentInfo.setLitigationObject(map.get("诉讼标的"));
			civilJudgmentInfo.setLitigationObjectAmount(map.get("诉讼标的金额"));
			civilJudgmentInfo.setSerial(map.get("编号"));
			civilJudgmentInfo.setSettleWay(map.get("结案方式"));
			civilJudgmentInfos.add(civilJudgmentInfo);
		}
		logger.info("民事判决记录:" + civilJudgmentInfos);
		return civilJudgmentInfos;
	}

	@Override
	public List<EnforcementInfo> getEnforcementInfos() throws Exception {
		List<EnforcementInfo> enforcementInfos = new ArrayList<EnforcementInfo>();
		WebElement e = this.getElement(this.getDriver(), "执行法院", "执行案由",
				"立案日期", "结案方式");
		WebElement e2 = this.getElement(this.getDriver(), "案件状态", "结案日期",
				"申请执行标的", "申请执行标的价值");
		List<Map<String, String>> listData = this.getListData(e, e2,
				new String[] { "执行法院", "执行案由", "立案日期", "结案方式" }, "案件状态",
				"结案日期", "申请执行标的", "申请执行标的价值", "已执行标的", "已执行标的金额");

		for (Map<String, String> map : listData) {
			EnforcementInfo enforcementInfo = new EnforcementInfo();
			enforcementInfo.setApplyExecuteObject(map.get("申请执行标的"));
			enforcementInfo.setApplyExecuteObjectValue(map.get("申请执行标的价值"));
			enforcementInfo.setExecuteCourt(map.get("执行法院"));
			enforcementInfo.setExecuteDate(map.get("立案日期"));
			enforcementInfo.setExecutedObject(map.get("已执行标的"));
			enforcementInfo.setExecutedObjectAmount(map.get("已执行标的金额"));
			enforcementInfo.setExecuteReason(map.get("执行案由"));
			enforcementInfo.setExecuteWay(map.get("结案方式"));
			enforcementInfo.setSerial(map.get("编号"));
			enforcementInfo.setSettlementDate(map.get("结案日期"));
			enforcementInfo.setStatus(map.get("案件状态"));

			enforcementInfos.add(enforcementInfo);

		}
		logger.info("强制执行记录:" + enforcementInfos);
		return enforcementInfos;
	}

	@Override
	public List<AdminPunishmentInfo> getAdminPunishmentInfos() throws Exception {
		List<AdminPunishmentInfo> adminPunishmentInfos = new ArrayList<AdminPunishmentInfo>();

		WebElement e = this
				.getElement(this.getDriver(), "处罚机构", "处罚内容", "处罚金额");
		List<Map<String, String>> listData = this.getListData(e, "处罚机构",
				"处罚内容", "处罚金额", "生效日期", "截止日期", "行政复议结果");

		for (Map<String, String> map : listData) {
			AdminPunishmentInfo adminPunishmentInfo = new AdminPunishmentInfo();

			adminPunishmentInfo.setAdminReviewResult(map.get("行政复议结果"));
			adminPunishmentInfo.setEffectiveDate(map.get("生效日期"));
			adminPunishmentInfo.setEndDate(map.get("截止日期"));
			adminPunishmentInfo.setPunishAmount(map.get("处罚金额"));
			adminPunishmentInfo.setPunishContent(map.get("处罚内容"));
			adminPunishmentInfo.setPunishInstitution(map.get("处罚机构"));
			adminPunishmentInfo.setSerial(map.get("编号"));

			adminPunishmentInfos.add(adminPunishmentInfo);
		}
		logger.info("行政处罚记录:" + adminPunishmentInfos);
		return adminPunishmentInfos;
	}

	@Override
	public HousingFundPayInfo getHousingFundPayInfo() throws Exception {
		HousingFundPayInfo housingFundPayInfo = new HousingFundPayInfo();
		WebElement e1 = this
				.getElement(this.getDriver(), "参缴日期", "参缴地", "初缴月份");
		Map<String, String> map = this.getKeyValue(e1, "参缴日期", "参缴地", "初缴月份");
		WebElement e2 = this.getElement(this.getDriver(), "缴费单位", "信息更新日期");
		map.putAll(this.getKeyValue(e2, "缴费单位", "信息更新日期"));

		housingFundPayInfo.setAmount(map.get("月缴存额"));
		housingFundPayInfo.setCompany(map.get("缴费单位"));
		housingFundPayInfo.setCompanyProportion(map.get("单位缴存比例"));
		housingFundPayInfo.setEndMonth(map.get("缴至月份"));
		housingFundPayInfo.setIndividualProportion(map.get("个人缴存比例"));
		housingFundPayInfo.setLocation(map.get("参缴地"));
		housingFundPayInfo.setStartDate(map.get("参缴日期"));
		housingFundPayInfo.setStartMonth(map.get("初缴月份"));
		housingFundPayInfo.setStatus(map.get("缴费状态"));
		housingFundPayInfo.setUpdateTime(map.get("信息更新日期"));
		logger.info("住房公积金参缴记录:" + housingFundPayInfo);
		return housingFundPayInfo;
	}

	@Override
	public PensionPayInfo getPensionPayInfo() throws Exception {
		PensionPayInfo pensionPayInfo = new PensionPayInfo();

		WebElement e1 = this.getElement(this.getDriver(), "参保日期", "参保地",
				"参加工作月份");
		Map<String, String> map = this.getKeyValue(e1, "参保日期", "参保地", "参加工作月份");
		WebElement e2 = this.getElement(this.getDriver(), "缴费单位", "中断或终止缴费原因");
		map.putAll(this.getKeyValue(e2, "缴费单位", "中断或终止缴费原因"));

		pensionPayInfo.setCompany(map.get("缴费单位"));
		pensionPayInfo.setIndividualBasePayAmount(map.get("个人缴费基数"));
		pensionPayInfo.setLocation(map.get("参保地"));
		pensionPayInfo.setMonthPaymentAmount(map.get("本月缴费金额"));
		pensionPayInfo.setPayMonthCount(map.get("累计缴费月数"));
		pensionPayInfo.setStartDate(map.get("参保日期"));
		pensionPayInfo.setStartMonth(map.get("参加工作月份"));
		pensionPayInfo.setStatus(map.get("缴费状态"));
		pensionPayInfo.setStopReason(map.get("中断或终止缴费原因"));
		pensionPayInfo.setUpdateTime(map.get("信息更新日期"));
		logger.info("养老保险金缴存记录:" + pensionPayInfo);
		return pensionPayInfo;
	}

	@Override
	public PensionReceiveInfo getPensionReceiveInfo() throws Exception {
		PensionReceiveInfo pensionReceiveInfo = new PensionReceiveInfo();

		WebElement e1 = this.getElement(this.getDriver(), "离退休类别", "发放地",
				"离退休月份");
		Map<String, String> map = this.getKeyValue(e1, "离退休类别", "发放地", "离退休月份");
		WebElement e2 = this.getElement(this.getDriver(), "原单位名称", "信息更新日期");
		map.putAll(this.getKeyValue(e2, "原单位名称", "信息更新日期"));

		pensionReceiveInfo.setCompany(map.get("原单位名称"));
		pensionReceiveInfo.setRealPension(map.get("本月实发养老金"));
		pensionReceiveInfo.setLocation(map.get("发放地"));
		pensionReceiveInfo.setRetiredMonth(map.get("离退休月份"));
		pensionReceiveInfo.setRetiredType(map.get("离退休类别"));
		pensionReceiveInfo.setStartMonth(map.get("参加工作月份"));
		pensionReceiveInfo.setStopReason(map.get("停发原因"));
		pensionReceiveInfo.setUpdateTime(map.get("信息更新日期"));
		logger.info("养老保险金发放记录:" + pensionReceiveInfo);
		return pensionReceiveInfo;
	}

	@Override
	public List<LowReliefInfo> getLowReliefInfos() throws Exception {
		List<LowReliefInfo> lowReliefInfos = new ArrayList<LowReliefInfo>();

		WebElement e = this.getElement(this.getDriver(), "人员类别", "所在地", "工作单位");
		List<Map<String, String>> listData = this.getListData(e, "人员类别", "所在地",
				"工作单位");

		for (Map<String, String> map : listData) {

			LowReliefInfo lowReliefInfo = new LowReliefInfo();

			lowReliefInfo.setApplyDate(map.get("申请日期"));
			lowReliefInfo.setApprovalDate(map.get("批准日期"));
			lowReliefInfo.setCompany(map.get("工作单位"));
			lowReliefInfo.setFamilyMonthlyIncome(map.get("家庭月收入"));
			lowReliefInfo.setLocation(map.get("所在地"));
			lowReliefInfo.setPersonType(map.get("人员类别"));
			lowReliefInfo.setSerial(map.get("编号"));
			lowReliefInfo.setUpdateTime(map.get("信息更新日期"));

			lowReliefInfos.add(lowReliefInfo);
		}
		logger.info("低保救助记录:" + lowReliefInfos);
		return lowReliefInfos;
	}

	@Override
	public List<QualificationInfo> getQualificationInfos() throws Exception {
		List<QualificationInfo> qualificationInfos = new ArrayList<QualificationInfo>();

		WebElement e = this.getElement(this.getDriver(), "执业资格名称", "吊销日期",
				"获得日期");
		List<Map<String, String>> listData = this.getListData(e, "执业资格名称",
				"吊销日期", "获得日期");
		for (Map<String, String> map : listData) {
			QualificationInfo qualificationInfo = new QualificationInfo();

			qualificationInfo.setAuthority(map.get("颁发机构"));
			qualificationInfo.setDueDate(map.get("到期日期"));
			qualificationInfo.setGetDate(map.get("获得日期"));
			qualificationInfo.setLocation(map.get("机构所在地"));
			qualificationInfo.setQualificationName(map.get("执业资格名称"));
			qualificationInfo.setRank(map.get("等级"));
			qualificationInfo.setRevocationDate(map.get("吊销日期"));
			qualificationInfo.setSerial(map.get("编号"));

			qualificationInfos.add(qualificationInfo);
		}
		logger.info("执业资格记录:" + qualificationInfos);
		return qualificationInfos;
	}

	@Override
	public List<AdministrativeRewardInfo> getAdministrativeRewardInfos()
			throws Exception {
		List<AdministrativeRewardInfo> administrativeRewardInfos = new ArrayList<AdministrativeRewardInfo>();
		WebElement e = this.getElement(this.getDriver(), "奖励机构", "奖励内容",
				"生效日期", "截止日期");
		List<Map<String, String>> listData = this.getListData(e, "奖励机构",
				"奖励内容", "生效日期", "截止日期");

		for (Map<String, String> map : listData) {

			AdministrativeRewardInfo administrativeRewardInfo = new AdministrativeRewardInfo();

			administrativeRewardInfo.setEffectiveDate(map.get("生效日期"));
			administrativeRewardInfo.setEndDate(map.get("截止日期"));
			administrativeRewardInfo.setRewardContent(map.get("奖励内容"));
			administrativeRewardInfo.setRewardInstitution(map.get("奖励机构"));
			administrativeRewardInfo.setSerial(map.get("编号"));

			administrativeRewardInfos.add(administrativeRewardInfo);
		}
		logger.info("行政奖励记录:" + administrativeRewardInfos);
		return administrativeRewardInfos;
	}

	@Override
	public List<VehicleTradeAndMortgageInfo> getVehicleTradeAndMortgageInfos()
			throws Exception {
		List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos = new ArrayList<VehicleTradeAndMortgageInfo>();

		WebElement e = this.getElement(this.getDriver(), "车牌号码", "车辆类型",
				"抵押标记", "信息更新日期");
		List<Map<String, String>> listData = this.getListData(e, "车牌号码",
				"车辆类型", "抵押标记", "信息更新日期");
		for (Map<String, String> map : listData) {

			VehicleTradeAndMortgageInfo vehicleTradeAndMortgageInfo = new VehicleTradeAndMortgageInfo();

			vehicleTradeAndMortgageInfo.setBrand(map.get("品牌"));
			vehicleTradeAndMortgageInfo.setEngineNo(map.get("发动机号"));
			vehicleTradeAndMortgageInfo.setIsMortgage(map.get("抵押标记"));
			vehicleTradeAndMortgageInfo.setSerial(map.get("编号"));
			vehicleTradeAndMortgageInfo.setStatus(map.get("车辆状态"));
			vehicleTradeAndMortgageInfo.setUpdateTime(map.get("信息更新日期"));
			vehicleTradeAndMortgageInfo.setUseAttribute(map.get("使用性质"));

			vehicleTradeAndMortgageInfo.setVehicleType(map.get("车辆类型"));

			vehicleTradeAndMortgageInfo.setVehicleNo(map.get("车牌号码"));

			vehicleTradeAndMortgageInfos.add(vehicleTradeAndMortgageInfo);
		}
		logger.info("车辆交易和抵押记录:" + vehicleTradeAndMortgageInfos);
		return vehicleTradeAndMortgageInfos;
	}

	@Override
	public List<TelecomPaymentInfo> getTelecomPaymentInfos() throws Exception {
		String xpath = "//*[contains(text(),'电信缴费记录')]/following::tr//*[contains(text(),'业务类型')]/ancestor::*[5]//tr";
		List<WebElement> trs = driver.findElements(By.xpath(xpath));
		if (trs.size() < 1) {
			return null;
		}
		int count = trs.size() / 2;
		List<TelecomPaymentInfo> telecomPaymentInfos = new ArrayList<TelecomPaymentInfo>();

		WebElement e = this.getElement(this.getDriver(), "电信运营商", "业务类型",
				"当前欠费金额", "业务开通日期");

		List<Map<String, String>> listData = this.getListData(e, new String[] {
				"电信运营商", "业务类型", "当前欠费金额", "业务开通日期" });

		for (int i = 0; i < listData.size(); i++) {
			Map<String, String> map = listData.get(i);
			String value = trs.get(i + count + 1).getText()
					.replaceAll("^\\d", "").replaceAll("\\s", "");
			TelecomPaymentInfo telecomPaymentInfo = new TelecomPaymentInfo();
			telecomPaymentInfo.setBusinessType(map.get("业务类型"));
			telecomPaymentInfo.setDebtAmount(map.get("当前欠费金额"));
			telecomPaymentInfo.setDebtMonthCount(map.get("当前欠费月数"));
			telecomPaymentInfo.setEffectiveDate(map.get("业务开通日期"));
			telecomPaymentInfo.setPaymentRecord_24(value);
			telecomPaymentInfo.setRecordDate(map.get("记账年月"));
			telecomPaymentInfo.setSerial(map.get("编号"));
			telecomPaymentInfo.setStatus(map.get("当前缴费状态"));
			telecomPaymentInfo.setTelecomOperator(map.get("电信运营商"));

			telecomPaymentInfos.add(telecomPaymentInfo);
		}
		logger.info("电信缴费记录:" + telecomPaymentInfos);
		return telecomPaymentInfos;

	}

	@Override
	public List<LoanDeclareDetailInfo> getLoanDeclareDetailInfos()
			throws Exception {
		List<LoanDeclareDetailInfo> loanDeclareDetailInfos = new ArrayList<LoanDeclareDetailInfo>();
		WebElement e = this.getElement(this.getDriver(), "声明内容", "添加日期");

		List<Map<String, String>> listData = this
				.getListData(e, "声明内容", "添加日期");
		for (Map<String, String> map : listData) {
			LoanDeclareDetailInfo loanDeclareDetailInfo = new LoanDeclareDetailInfo();

			loanDeclareDetailInfo.setContent(map.get("声明内容"));
			loanDeclareDetailInfo.setDeclareDate(map.get("添加日期"));
			loanDeclareDetailInfo.setSerial(map.get("编号"));

			loanDeclareDetailInfos.add(loanDeclareDetailInfo);
		}
		logger.info("本人声明:" + loanDeclareDetailInfos);
		return loanDeclareDetailInfos;
	}

	@Override
	public List<DissentDeclareDetailInfo> getDissentDeclareDetailInfos()
			throws Exception {

		List<DissentDeclareDetailInfo> dissentDeclareDetailInfos = new ArrayList<DissentDeclareDetailInfo>();
		WebElement e = this.getElement(this.getDriver(), "标注内容", "添加日期");

		List<Map<String, String>> listData = this
				.getListData(e, "标注内容", "添加日期");
		for (Map<String, String> map : listData) {
			DissentDeclareDetailInfo dissentDeclareDetailInfo = new DissentDeclareDetailInfo();

			dissentDeclareDetailInfo.setContent(map.get("标注内容"));
			dissentDeclareDetailInfo.setDeclareDate(map.get("添加日期"));
			dissentDeclareDetailInfo.setSerial(map.get("编号"));

			dissentDeclareDetailInfos.add(dissentDeclareDetailInfo);
		}
		logger.info("异议标注:" + dissentDeclareDetailInfos);
		return dissentDeclareDetailInfos;
	}

	@Override
	public SummaryQueryRecordInfo getSummaryQueryRecordInfo() throws Exception {
		SummaryQueryRecordInfo summaryQueryRecordInfo = new SummaryQueryRecordInfo();
		WebElement e = this.getElement(this.getDriver(), "贷后管理", "贷款审批");

		Map<String, String> map = this.getKeyValueSpecial(
				e.findElement(By.xpath("./preceding-sibling::*[1]")),
				new String[] { "个月内的查询机构数", "内的查询次数" }, "贷后管理", "贷款审批");

		Last1MonthQuery last1MonthQuery = new Last1MonthQuery();
		Last1MonthQueryInstitution last1MonthQueryInstitution = new Last1MonthQueryInstitution();
		Last2YearsQuery last2YearsQuery = new Last2YearsQuery();

		last1MonthQueryInstitution.setCreditCardApprovalCount(map
				.get("最近1个月内的查询机构数信用卡审批"));
		last1MonthQueryInstitution.setLoanApprovalCount(map
				.get("最近1个月内的查询机构数贷款审批"));
		last1MonthQuery.setCreditCardApprovalCount(map.get("最近1个月内的查询次数信用卡审批"));
		last1MonthQuery.setLoanApprovalCount(map.get("最近1个月内的查询次数贷款审批"));
		last2YearsQuery.setGuaranteeCount(map.get("最近2年内的查询次数担保资格审查"));
		last2YearsQuery.setMerchantReview(map.get("最近2年内的查询次数特约商户实名审查"));
		last2YearsQuery.setPostLoanManageCount(map.get("最近2年内的查询次数贷后管理"));

		summaryQueryRecordInfo.setLast1MonthQuery(last1MonthQuery);
		summaryQueryRecordInfo
				.setLast1MonthQueryInstitution(last1MonthQueryInstitution);
		summaryQueryRecordInfo.setLast2YearsQuery(last2YearsQuery);
		logger.info("查询记录汇总:" + summaryQueryRecordInfo);
		return summaryQueryRecordInfo;
	}

	@Override
	public List<QueryRecordInfo> getQueryRecordInfos() throws Exception {
		List<QueryRecordInfo> queryRecordInfos = new ArrayList<QueryRecordInfo>();
		WebElement e = this.getElement(this.getDriver(), "查询操作员", "查询日期",
				"查询原因");

		List<Map<String, String>> listData = this.getListData(e, "查询操作员",
				"查询日期", "查询原因");
		for (Map<String, String> map : listData) {
			QueryRecordInfo queryRecordInfo = new QueryRecordInfo();

			queryRecordInfo.setQueryDate(map.get("查询日期"));
			queryRecordInfo.setQueryOperator(map.get("查询操作员"));
			queryRecordInfo.setQueryReason(map.get("查询原因"));
			queryRecordInfo.setSerial(map.get("编号"));

			queryRecordInfos.add(queryRecordInfo);
		}
		logger.info("信贷审批查询记录明细:" + queryRecordInfos);
		return queryRecordInfos;
	}

	@Override
	public void closeDriver() throws Exception {
		this.getDriver().quit();

	}

}
