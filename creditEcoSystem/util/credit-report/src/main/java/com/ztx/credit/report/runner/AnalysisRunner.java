package com.ztx.credit.report.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ztx.credit.report.model.PersonCreditInfo;
import com.ztx.credit.report.service.IPbcOperService;
import com.ztx.credit.report.service.IVerifyDataService;
import com.ztx.credit.report.service.impl.VerifyDataServiceImpl;

@Component
@Scope("prototype")
public class AnalysisRunner extends AbstractAnalysisRunner {

	@Autowired
	IPbcOperService pbcOperServiceImpl;

	public AnalysisRunner() {
		super();
	}

	@Override
	public PersonCreditInfo getPersonCreditInfo() {
		analysisService.getDriver().get(this.url);
		PersonCreditInfo pci = new PersonCreditInfo();
		System.out.println("开始解析报告===="
				+ this.url.substring(this.url.indexOf("?") + 4));
		try {
			try {
				// 报告头
				pci.setReportHeadInfo(analysisService.getReportHeadInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==报告头解析出错");
			}
			// 被查询者信息
			try {
				pci.setQueryPersonInfo(analysisService.getQueryPersonInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==被查询者信息解析出错");
			}
			// 身份信息
			try {
				pci.setPersonalInfo(analysisService.getPersonalInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==身份信息解析出错");
			}
			// 配偶信息
			try {
				pci.setPersonalSpouseInfo(analysisService
						.getPersonalSpouseInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==配偶信息解析出错");
			}
			// 居住信息
			try {
				pci.setPersonalResidentialInfos(analysisService
						.getPersonalResidentialInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==居住信息解析出错");
			}
			// 职业信息
			try {
				pci.setPersonalCareerInfos(analysisService
						.getPersonalCareerInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==职业信息解析出错");
			}
			// 信用提示
			try {
				pci.setSummaryCreditInfo(analysisService.getSummaryCreditInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==信用提示解析出错");
			}
			// 中征评分
			try {
				pci.setBankCreditInfo(analysisService.getBankCreditInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==中征评分解析出错");
			}
			// 逾期及违约信息概要
			try {
				pci.setSummaryOverdueAndDefaultInfo(analysisService
						.getSummaryOverdueAndDefaultInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==违约以及逾期信息解析出错");
			}
			// 逾期（透支）信息汇总
			try {
				pci.setSummaryOverdueInfo(analysisService
						.getSummaryOverdueInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==逾期透支解析出错");
			}
			// 未结清贷款信息汇总
			try {
				pci.setSummaryOutstandingInfo(analysisService
						.getSummaryOutstandingInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==未结清贷款信息解析出错");
			}
			// 未销户贷记卡信息汇总
			try {
				pci.setSummaryNotCloseCreditInfo(analysisService
						.getSummaryNotCloseCreditInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==未销户贷记卡信息解析出错");
			}
			// 未销户准贷记卡信息汇总
			try {
				pci.setSummaryQuasiCreditInfo(analysisService
						.getSummaryQuasiCreditInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==未销户准贷记卡信息解析出错");
			}
			// 对外担保信息汇总
			try {
				pci.setSummaryGuaranteeInfo(analysisService
						.getSummaryGuaranteeInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==对外担保信息解析出错");
			}
			// 资产处置信息
			try {
				pci.setAssertDisposeDetailInfos(analysisService
						.getAssertDisposeDetailInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==资产处置信息解析出错");
			}
			// 保证人代偿信息
			try {
				pci.setGuarantorCompensationDetailInfos(analysisService
						.getGuarantorCompensationDetailInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==保证人代偿信息解析出错");
			}
			// 贷款
			try {
				pci.setLoanInfos(analysisService.getLoanInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==贷款信息解析出错");
			}
			// 贷记卡
			try {
				pci.setCreditCardInfos(analysisService.getCreditCardInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==贷记卡信息解析出错");
			}
			// 准贷记卡
			try {
				pci.setQuasiCreditInfos(analysisService.getQuasiCreditInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==身份信息解析出错");
			}
			// 对外担保信息
			try {
				pci.setGuaranteeDetailInfos(analysisService
						.getGuaranteeDetailInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==对外担保信息解析出错");
			}
			// 欠税记录
			try {
				pci.setTaxesInfos(analysisService.getTaxesInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==欠税信息解析出错");
			}
			// 民事判决记录
			try {
				pci.setCivilJudgmentInfos(analysisService
						.getCivilJudgmentInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==民事判决解析出错");
			}
			// 强制执行记录
			try {
				pci.setEnforcementInfos(analysisService.getEnforcementInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==强制执行信息解析出错");
			}
			// 行政处罚记录
			try {
				pci.setAdminPunishmentInfos(analysisService
						.getAdminPunishmentInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==行政处罚信息解析出错");
			}
			// 住房公积金参缴记录
			try {
				pci.setHousingFundPayInfo(analysisService
						.getHousingFundPayInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==住房公积金信息解析出错");
			}
			// 养老保险金缴存记录
			try {
				pci.setPensionPayInfo(analysisService.getPensionPayInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==养老金信息解析出错");
			}
			// //养老保险金发放记录
			// try{
			// pci.setPensionReceiveInfo(analysisService.getPensionReceiveInfo());
			// }catch(Exception ex){
			// System.out.println(this.url.substring(this.url.indexOf("?")+4)
			// +"==住房公积金信息解析出错");
			// }
			// 低保救助记录
			try {

				pci.setLowReliefInfos(analysisService.getLowReliefInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==住房公积金信息解析出错");
			}
			// 执业资格记录
			try {
				pci.setQualificationInfos(analysisService
						.getQualificationInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==执业资格记录信息解析出错");
			}
			// 行政奖励记录
			try {
				pci.setAdministrativeRewardInfos(analysisService
						.getAdministrativeRewardInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==行政奖励信息解析出错");
			}
			// 车辆交易和抵押记录
			try {
				pci.setVehicleTradeAndMortgageInfos(analysisService
						.getVehicleTradeAndMortgageInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==车辆交易和抵押信息解析出错");
			}
			// 电信缴费记录
			try {
				pci.setTelecomPaymentInfos(analysisService
						.getTelecomPaymentInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==电信缴费信息解析出错");
			}
			// 本人声明
			try {
				pci.setLoanDeclareDetailInfos(analysisService
						.getLoanDeclareDetailInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==本人声明信息解析出错");
			}
			// 异议标注
			try {
				pci.setDissentDeclareDetailInfos(analysisService
						.getDissentDeclareDetailInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==异议标记信息解析出错");
			}
			// 查询记录汇总
			try {
				pci.setSummaryQueryRecordInfo(analysisService
						.getSummaryQueryRecordInfo());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==查询记录信息解析出错");
			}
			// 信贷审批查询记录明细
			try {
				pci.setQueryRecordInfos(analysisService.getQueryRecordInfos());
			} catch (Exception ex) {
				System.out
						.println(this.url.substring(this.url.indexOf("?") + 4)
								+ "==信贷审批信息解析出错");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			analysisService.getDriver().close();
			analysisService.getDriver().quit();
		}

		IVerifyDataService vds = new VerifyDataServiceImpl();
		String result = vds.verifyPbc(pci, "");
		pbcOperServiceImpl.insertPbc(pci,
				this.url.substring(this.url.indexOf("?") + 4), result);

		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		getPersonCreditInfo();
	}
}
