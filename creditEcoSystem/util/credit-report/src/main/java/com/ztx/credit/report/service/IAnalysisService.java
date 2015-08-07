package com.ztx.credit.report.service;

import java.util.List;

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

/**
 * 获取征信报告信息
 * 
 * @author xuchongying
 *
 */
public interface IAnalysisService {

	/**
	 * 报告头
	 * 
	 * @return 报告头信息
	 * @throws Exception
	 */
	ReportHeadInfo getReportHeadInfo() throws Exception;

	/**
	 * 被查询者信息
	 * 
	 * @return 被查询者信息
	 * @throws Exception
	 */
	QueryPersonInfo getQueryPersonInfo() throws Exception;

	/**
	 * 身份信息
	 * 
	 * @return 身份信息
	 * @throws Exception
	 */
	PersonalInfo getPersonalInfo()throws Exception;

	/**
	 * 配偶信息
	 * 
	 * @return 配偶信息
	 * @throws Exception
	 */
	PersonalSpouseInfo getPersonalSpouseInfo() throws Exception;

	/**
	 * 居住信息,最多5条
	 * 
	 * @return 居住信息
	 * @throws Exception
	 */
	List<PersonalResidentialInfo> getPersonalResidentialInfos() throws Exception;

	/**
	 * 职业信息,最多5条
	 * 
	 * @return 职业信息
	 * @throws Exception
	 */
	List<PersonalCareerInfo> getPersonalCareerInfos() throws Exception;

	/**
	 * 信用提示
	 * 
	 * @return 信用提示
	 * @throws Exception
	 */
	SummaryCreditInfo getSummaryCreditInfo() throws Exception;

	/**
	 * 中征信评分
	 * 
	 * @return 中征信评分
	 * @throws Exception
	 */
	BankCreditInfo getBankCreditInfo() throws Exception;

	/**
	 * 逾期及违约信息概要
	 * 
	 * @return 逾期及违约信息概要
	 * @throws Exception
	 */
	SummaryOverdueAndDefaultInfo getSummaryOverdueAndDefaultInfo() throws Exception;

	/**
	 * 逾期（透支）信息汇总
	 * 
	 * @return 逾期（透支）信息汇总
	 * @throws Exception
	 */
	SummaryOverdueInfo getSummaryOverdueInfo() throws Exception;

	/**
	 * 未结清贷款信息汇总
	 * 
	 * @return 未结清贷款信息汇总
	 * @throws Exception
	 */
	SummaryOutstandingInfo getSummaryOutstandingInfo() throws Exception;

	/**
	 * 未销户贷记卡信息汇总
	 * 
	 * @return 未销户贷记卡信息汇总
	 * @throws Exception
	 */
	SummaryNotCloseCreditInfo getSummaryNotCloseCreditInfo() throws Exception;

	/**
	 * 未销户准贷记卡信息汇总
	 * 
	 * @return 未销户准贷记卡信息汇总
	 * @throws Exception
	 */
	SummaryQuasiCreditInfo getSummaryQuasiCreditInfo() throws Exception;

	/**
	 * 对外担保信息汇总
	 * 
	 * @return 对外担保信息汇总
	 * @throws Exception
	 */
	SummaryGuaranteeInfo getSummaryGuaranteeInfo() throws Exception;

	/**
	 * 资产处置信息
	 * 
	 * @return 资产处置信息
	 * @throws Exception
	 */
	List<AssertDisposeDetailInfo> getAssertDisposeDetailInfos() throws Exception;

	/**
	 * 保证人代偿信息
	 * 
	 * @return 保证人代偿信息
	 * @throws Exception
	 */
	List<GuarantorCompensationDetailInfo> getGuarantorCompensationDetailInfos() throws Exception;

	/**
	 * (三)贷款
	 * 
	 * @return 贷款信息
	 * @throws Exception
	 */
	List<LoanInfo> getLoanInfos() throws Exception;

	/**
	 * 贷记卡信息
	 * 
	 * @return 贷记卡信息
	 * @throws Exception
	 */
	List<CreditCardInfo> getCreditCardInfos() throws Exception;

	/**
	 * 准贷记卡
	 * 
	 * @return 准贷记卡
	 * @throws Exception
	 */
	List<QuasiCreditInfo> getQuasiCreditInfos() throws Exception;

	/**
	 * 对外担保信息
	 * 
	 * @return 对外担保信息
	 * @throws Exception
	 */
	List<GuaranteeDetailInfo> getGuaranteeDetailInfos() throws Exception;

	/**
	 * 欠税记录
	 * 
	 * @return 欠税记录
	 * @throws Exception
	 */
	List<TaxesInfo> getTaxesInfos() throws Exception;

	/**
	 * 民事判决记录
	 * 
	 * @return 民事判决记录
	 * @throws Exception
	 */
	List<CivilJudgmentInfo> getCivilJudgmentInfos() throws Exception;

	/**
	 * 强制执行记录
	 * 
	 * @return 强制执行记录
	 * @throws Exception
	 */
	List<EnforcementInfo> getEnforcementInfos() throws Exception;

	/**
	 * 行政处罚记录
	 * 
	 * @return 行政处罚记录
	 * @throws Exception
	 */
	List<AdminPunishmentInfo> getAdminPunishmentInfos() throws Exception;

	/**
	 * 住房公积金参缴记录
	 * 
	 * @return 住房公积金参缴记录
	 * @throws Exception
	 */
	HousingFundPayInfo getHousingFundPayInfo() throws Exception;

	/**
	 * 养老保险金缴存记录
	 * 
	 * @return 养老保险金缴存记录
	 * @throws Exception
	 */
	PensionPayInfo getPensionPayInfo() throws Exception;

	/**
	 * 养老保险金发放记录
	 * 
	 * @return 养老保险金发放记录
	 * @throws Exception
	 */
	PensionReceiveInfo getPensionReceiveInfo() throws Exception;

	/**
	 * 低保救助记录
	 * 
	 * @return 低保救助记录
	 * @throws Exception
	 */
	List<LowReliefInfo> getLowReliefInfos() throws Exception;

	/**
	 * 执业资格记录
	 * 
	 * @return 执业资格记录
	 * @throws Exception
	 */
	List<QualificationInfo> getQualificationInfos() throws Exception;

	/**
	 * 行政奖励记录
	 * 
	 * @return 行政奖励记录
	 * @throws Exception
	 */
	List<AdministrativeRewardInfo> getAdministrativeRewardInfos() throws Exception;

	/**
	 * 车辆交易和抵押记录
	 * 
	 * @return 车辆交易和抵押记录
	 * @throws Exception
	 */
	List<VehicleTradeAndMortgageInfo> getVehicleTradeAndMortgageInfos() throws Exception;

	/**
	 * 电信缴费记录
	 * 
	 * @return 电信缴费记录
	 * @throws Exception
	 */
	List<TelecomPaymentInfo> getTelecomPaymentInfos() throws Exception;

	/**
	 * 本人声明
	 * 
	 * @return 本人声明
	 * @throws Exception
	 */
	List<LoanDeclareDetailInfo> getLoanDeclareDetailInfos() throws Exception;

	/**
	 * 异议标注
	 * 
	 * @return 异议标注
	 * @throws Exception
	 */
	List<DissentDeclareDetailInfo> getDissentDeclareDetailInfos() throws Exception;

	/**
	 * 查询记录汇总
	 * 
	 * @return 查询记录汇总
	 * @throws Exception
	 */
	SummaryQueryRecordInfo getSummaryQueryRecordInfo() throws Exception;

	/**
	 * 信贷审批查询记录明细
	 * 
	 * @return 信贷审批查询记录明细
	 * @throws Exception
	 */
	List<QueryRecordInfo> getQueryRecordInfos() throws Exception;

//	/**
//	 * 关闭driver
//	 * 
//	 * @throws Exception
//	 */
//	void closeDriver();

}
