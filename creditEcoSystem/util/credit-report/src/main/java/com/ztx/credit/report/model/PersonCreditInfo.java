package com.ztx.credit.report.model;

import java.util.ArrayList;
import java.util.List;

public class PersonCreditInfo {
	// 报告头
	private ReportHeadInfo reportHeadInfo;
	// 被查询者信息
	private QueryPersonInfo queryPersonInfo;
	// 身份信息
	private PersonalInfo personalInfo;
	// 配偶信息
	private PersonalSpouseInfo personalSpouseInfo;
	// 信用提示
	private SummaryCreditInfo summaryCreditInfo;
	// 中征评分
	private BankCreditInfo bankCreditInfo;
	// 逾期及违约信息概要
	private SummaryOverdueAndDefaultInfo summaryOverdueAndDefaultInfo;
	// 逾期（透支）信息汇总
	private SummaryOverdueInfo summaryOverdueInfo;
	// 未结清贷款信息汇总
	private SummaryOutstandingInfo summaryOutstandingInfo;
	// 未销户贷记卡信息汇总
	private SummaryNotCloseCreditInfo summaryNotCloseCreditInfo;
	// 未销户准贷记卡信息汇总
	private SummaryQuasiCreditInfo summaryQuasiCreditInfo;
	// 对外担保信息汇总
	private SummaryGuaranteeInfo summaryGuaranteeInfo;
	// 住房公积金参缴记录
	private HousingFundPayInfo housingFundPayInfo;
	// 养老保险金缴存记录
	private PensionPayInfo pensionPayInfo;
	// 养老保险金发放记录
	private PensionReceiveInfo pensionReceiveInfo;
	// 低保救助记录
	private List<LowReliefInfo> lowReliefInfos;
	// 执业资格记录
	private List<QualificationInfo> qualificationInfos;
	// 行政奖励记录
	private List<AdministrativeRewardInfo> administrativeRewardInfos;
	// 车辆交易和抵押记录
	private List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos;
	// 电信缴费记录
	private List<TelecomPaymentInfo> telecomPaymentInfos;
	// 居住信息
	private List<PersonalResidentialInfo> personalResidentialInfos;
	// 职业信息
	private List<PersonalCareerInfo> personalCareerInfos;
	// 本人声明
	private List<LoanDeclareDetailInfo> loanDeclareDetailInfos;
	// 异议标注
	private List<DissentDeclareDetailInfo> dissentDeclareDetailInfos;
	// 信贷审批查询记录明细
	private List<QueryRecordInfo> queryRecordInfos;
	// 资产处置信息
	private List<AssertDisposeDetailInfo> assertDisposeDetailInfos;
	// 保证人代偿信息
	private List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos;
	// 贷款
	private List<LoanInfo> loanInfos; 
	// 贷记卡
	private List<CreditCardInfo> creditCardInfos; 
	// 准贷记卡
	private List<QuasiCreditInfo> quasiCreditInfos; 
	// 对外担保信息
	private List<GuaranteeDetailInfo> guaranteeDetailInfos;
	// 欠税记录
	private List<TaxesInfo> taxesInfos;
	// 民事判决记录
	private List<CivilJudgmentInfo> civilJudgmentInfos;
	// 强制执行记录
	private List<EnforcementInfo> enforcementInfos;
	// 行政处罚记录
	private List<AdminPunishmentInfo> adminPunishmentInfos;
	// 查询记录汇总
	private SummaryQueryRecordInfo summaryQueryRecordInfo;
		
	public ReportHeadInfo getReportHeadInfo() {
		return reportHeadInfo == null ? new ReportHeadInfo() : reportHeadInfo;
	}
	public void setReportHeadInfo(ReportHeadInfo reportHeadInfo) {
		this.reportHeadInfo = reportHeadInfo;
	}
	public QueryPersonInfo getQueryPersonInfo() {
		return queryPersonInfo == null ? new QueryPersonInfo() : queryPersonInfo;
	}
	public void setQueryPersonInfo(QueryPersonInfo queryPersonInfo) {
		this.queryPersonInfo = queryPersonInfo;
	}
	public PersonalInfo getPersonalInfo() {
		return personalInfo == null ? new PersonalInfo() : personalInfo;
	}
	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}
	public PersonalSpouseInfo getPersonalSpouseInfo() {
		return personalSpouseInfo == null? new PersonalSpouseInfo() : personalSpouseInfo;
	}
	public void setPersonalSpouseInfo(PersonalSpouseInfo personalSpouseInfo) {
		this.personalSpouseInfo = personalSpouseInfo;
	}
	public List<PersonalResidentialInfo> getPersonalResidentialInfos() {
		return personalResidentialInfos == null ? new ArrayList<PersonalResidentialInfo>() : personalResidentialInfos;
	}
	public void setPersonalResidentialInfos(
			List<PersonalResidentialInfo> personalResidentialInfos) {
		this.personalResidentialInfos = personalResidentialInfos;
	}
	public List<PersonalCareerInfo> getPersonalCareerInfos() {
		return personalCareerInfos == null ? new ArrayList<PersonalCareerInfo>() : personalCareerInfos;
	}
	public void setPersonalCareerInfos(List<PersonalCareerInfo> personalCareerInfos) {
		this.personalCareerInfos = personalCareerInfos;
	}
	public SummaryCreditInfo getSummaryCreditInfo() {
		return summaryCreditInfo == null ? new SummaryCreditInfo():summaryCreditInfo;
	}
	public void setSummaryCreditInfo(SummaryCreditInfo summaryCreditInfo) {
		this.summaryCreditInfo = summaryCreditInfo;
	}
	public BankCreditInfo getBankCreditInfo() {
		return bankCreditInfo == null ? new BankCreditInfo():bankCreditInfo;
	}
	public void setBankCreditInfo(BankCreditInfo bankCreditInfo) {
		this.bankCreditInfo = bankCreditInfo;
	}
	public SummaryOverdueAndDefaultInfo getSummaryOverdueAndDefaultInfo() {
		return summaryOverdueAndDefaultInfo == null ? new SummaryOverdueAndDefaultInfo() : summaryOverdueAndDefaultInfo;
	}
	public void setSummaryOverdueAndDefaultInfo(
			SummaryOverdueAndDefaultInfo summaryOverdueAndDefaultInfo) {
		this.summaryOverdueAndDefaultInfo = summaryOverdueAndDefaultInfo;
	}
	public SummaryOverdueInfo getSummaryOverdueInfo() {
		return summaryOverdueInfo == null? new SummaryOverdueInfo():summaryOverdueInfo;
	}
	public void setSummaryOverdueInfo(SummaryOverdueInfo summaryOverdueInfo) {
		this.summaryOverdueInfo = summaryOverdueInfo;
	}
	public SummaryOutstandingInfo getSummaryOutstandingInfo() {
		return summaryOutstandingInfo == null? new SummaryOutstandingInfo() : summaryOutstandingInfo;
	}
	public void setSummaryOutstandingInfo(
			SummaryOutstandingInfo summaryOutstandingInfo) {
		this.summaryOutstandingInfo = summaryOutstandingInfo;
	}
	public SummaryNotCloseCreditInfo getSummaryNotCloseCreditInfo() {
		return summaryNotCloseCreditInfo == null ? new SummaryNotCloseCreditInfo():summaryNotCloseCreditInfo;
	}
	public void setSummaryNotCloseCreditInfo(
			SummaryNotCloseCreditInfo summaryNotCloseCreditInfo) {
		this.summaryNotCloseCreditInfo = summaryNotCloseCreditInfo;
	}
	public SummaryQuasiCreditInfo getSummaryQuasiCreditInfo() {
		return summaryQuasiCreditInfo == null?new SummaryQuasiCreditInfo() :summaryQuasiCreditInfo;
	}
	public void setSummaryQuasiCreditInfo(
			SummaryQuasiCreditInfo summaryQuasiCreditInfo) {
		this.summaryQuasiCreditInfo = summaryQuasiCreditInfo;
	}
	public SummaryGuaranteeInfo getSummaryGuaranteeInfo() {
		return summaryGuaranteeInfo == null? new SummaryGuaranteeInfo() :summaryGuaranteeInfo;
	}
	public void setSummaryGuaranteeInfo(SummaryGuaranteeInfo summaryGuaranteeInfo) {
		this.summaryGuaranteeInfo = summaryGuaranteeInfo;
	}
	public List<AssertDisposeDetailInfo> getAssertDisposeDetailInfos() {
		return assertDisposeDetailInfos == null ? new ArrayList<AssertDisposeDetailInfo>() :assertDisposeDetailInfos;
	}
	public void setAssertDisposeDetailInfos(
			List<AssertDisposeDetailInfo> assertDisposeDetailInfos) {
		this.assertDisposeDetailInfos = assertDisposeDetailInfos;
	}
	public List<GuarantorCompensationDetailInfo> getGuarantorCompensationDetailInfos() {
		return guarantorCompensationDetailInfos == null? new ArrayList<GuarantorCompensationDetailInfo>() :guarantorCompensationDetailInfos;
	}
	public void setGuarantorCompensationDetailInfos(
			List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos) {
		this.guarantorCompensationDetailInfos = guarantorCompensationDetailInfos;
	}
	public List<LoanInfo> getLoanInfos() {
		return loanInfos == null ? new ArrayList<LoanInfo>() : loanInfos;
	}
	public void setLoanInfos(List<LoanInfo> loanInfos) {
		this.loanInfos = loanInfos;
	}
	public List<CreditCardInfo> getCreditCardInfos() {
		return creditCardInfos == null ? new ArrayList<CreditCardInfo>() : creditCardInfos;
	}
	public void setCreditCardInfos(List<CreditCardInfo> creditCardInfos) {
		this.creditCardInfos = creditCardInfos;
	}
	public List<QuasiCreditInfo> getQuasiCreditInfos() {
		return quasiCreditInfos == null? new ArrayList<QuasiCreditInfo>():quasiCreditInfos;
	}
	public void setQuasiCreditInfos(List<QuasiCreditInfo> quasiCreditInfos) {
		this.quasiCreditInfos = quasiCreditInfos;
	}
	public List<GuaranteeDetailInfo> getGuaranteeDetailInfos() {
		return guaranteeDetailInfos == null ? new ArrayList<GuaranteeDetailInfo>() : guaranteeDetailInfos;
	}
	public void setGuaranteeDetailInfos(
			List<GuaranteeDetailInfo> guaranteeDetailInfos) {
		this.guaranteeDetailInfos = guaranteeDetailInfos;
	}
	public List<TaxesInfo> getTaxesInfos() {
		return taxesInfos == null? new ArrayList<TaxesInfo>() : taxesInfos;
	}
	public void setTaxesInfos(List<TaxesInfo> taxesInfos) {
		this.taxesInfos = taxesInfos;
	}
	public List<CivilJudgmentInfo> getCivilJudgmentInfos() {
		return civilJudgmentInfos == null? new ArrayList<CivilJudgmentInfo>() :civilJudgmentInfos ;
	}
	public void setCivilJudgmentInfos(List<CivilJudgmentInfo> civilJudgmentInfos) {
		this.civilJudgmentInfos = civilJudgmentInfos;
	}
	public List<EnforcementInfo> getEnforcementInfos() {
		return enforcementInfos == null ? new ArrayList<EnforcementInfo>() : enforcementInfos;
	}
	public void setEnforcementInfos(List<EnforcementInfo> enforcementInfos) {
		this.enforcementInfos = enforcementInfos;
	}
	public List<AdminPunishmentInfo> getAdminPunishmentInfos() {
		return adminPunishmentInfos == null? new ArrayList<AdminPunishmentInfo>() : adminPunishmentInfos;
	}
	public void setAdminPunishmentInfos(
			List<AdminPunishmentInfo> adminPunishmentInfos) {
		this.adminPunishmentInfos = adminPunishmentInfos;
	}
	public HousingFundPayInfo getHousingFundPayInfo() {
		return housingFundPayInfo == null? new HousingFundPayInfo() : housingFundPayInfo;
	}
	public void setHousingFundPayInfo(HousingFundPayInfo housingFundPayInfo) {
		this.housingFundPayInfo = housingFundPayInfo;
	}
	public PensionPayInfo getPensionPayInfo() {
		return pensionPayInfo == null? new PensionPayInfo() : pensionPayInfo;
	}
	public void setPensionPayInfo(PensionPayInfo pensionPayInfo) {
		this.pensionPayInfo = pensionPayInfo;
	}
	public PensionReceiveInfo getPensionReceiveInfo() {
		return pensionReceiveInfo == null? new PensionReceiveInfo() : pensionReceiveInfo;
	}
	public void setPensionReceiveInfo(PensionReceiveInfo pensionReceiveInfo) {
		this.pensionReceiveInfo = pensionReceiveInfo;
	}
	public List<LowReliefInfo> getLowReliefInfos() {
		return lowReliefInfos == null? new ArrayList<LowReliefInfo>() : lowReliefInfos;
	}
	public void setLowReliefInfos(List<LowReliefInfo> lowReliefInfos) {
		this.lowReliefInfos = lowReliefInfos;
	}
	public List<QualificationInfo> getQualificationInfos() {
		return qualificationInfos == null? new ArrayList<QualificationInfo>() : qualificationInfos;
	}
	public void setQualificationInfos(List<QualificationInfo> qualificationInfos) {
		this.qualificationInfos = qualificationInfos;
	}
	public List<AdministrativeRewardInfo> getAdministrativeRewardInfos() {
		return administrativeRewardInfos == null ? new ArrayList<AdministrativeRewardInfo>() : administrativeRewardInfos;
	}
	public void setAdministrativeRewardInfos(
			List<AdministrativeRewardInfo> administrativeRewardInfos) {
		this.administrativeRewardInfos = administrativeRewardInfos;
	}
	public List<VehicleTradeAndMortgageInfo> getVehicleTradeAndMortgageInfos() {
		return vehicleTradeAndMortgageInfos == null? new ArrayList<VehicleTradeAndMortgageInfo>() : vehicleTradeAndMortgageInfos;
	}
	public void setVehicleTradeAndMortgageInfos(
			List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos) {
		this.vehicleTradeAndMortgageInfos = vehicleTradeAndMortgageInfos;
	}
	public List<TelecomPaymentInfo> getTelecomPaymentInfos() {
		return telecomPaymentInfos == null ? new ArrayList<TelecomPaymentInfo>() : telecomPaymentInfos;
	}
	public void setTelecomPaymentInfos(List<TelecomPaymentInfo> telecomPaymentInfos) {
		this.telecomPaymentInfos = telecomPaymentInfos;
	}
	public List<LoanDeclareDetailInfo> getLoanDeclareDetailInfos() {
		return loanDeclareDetailInfos == null ? new ArrayList<LoanDeclareDetailInfo>() : loanDeclareDetailInfos;
	}
	public void setLoanDeclareDetailInfos(
			List<LoanDeclareDetailInfo> loanDeclareDetailInfos) {
		this.loanDeclareDetailInfos = loanDeclareDetailInfos;
	}
	public List<DissentDeclareDetailInfo> getDissentDeclareDetailInfos() {
		return dissentDeclareDetailInfos == null ? new ArrayList<DissentDeclareDetailInfo>() : dissentDeclareDetailInfos;
	}
	public void setDissentDeclareDetailInfos(
			List<DissentDeclareDetailInfo> dissentDeclareDetailInfos) {
		this.dissentDeclareDetailInfos = dissentDeclareDetailInfos;
	}
	public SummaryQueryRecordInfo getSummaryQueryRecordInfo() {
		return summaryQueryRecordInfo == null? new SummaryQueryRecordInfo() : summaryQueryRecordInfo;
	}
	public void setSummaryQueryRecordInfo(
			SummaryQueryRecordInfo summaryQueryRecordInfo) {
		this.summaryQueryRecordInfo = summaryQueryRecordInfo;
	}
	public List<QueryRecordInfo> getQueryRecordInfos() {
		return queryRecordInfos == null? new ArrayList<QueryRecordInfo>() : queryRecordInfos;
	}
	public void setQueryRecordInfos(List<QueryRecordInfo> queryRecordInfos) {
		this.queryRecordInfos = queryRecordInfos;
	}
}
