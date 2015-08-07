package com.ztx.credit.report.dao;

import java.util.List;
import java.util.Map;

import com.ztx.credit.report.model.AdminPunishmentInfo;
import com.ztx.credit.report.model.AdministrativeRewardInfo;
import com.ztx.credit.report.model.AssertDisposeDetailInfo;
import com.ztx.credit.report.model.CivilJudgmentInfo;
import com.ztx.credit.report.model.CreditCardInfo;
import com.ztx.credit.report.model.DissentDeclareDetailInfo;
import com.ztx.credit.report.model.EnforcementInfo;
import com.ztx.credit.report.model.GuaranteeDetailInfo;
import com.ztx.credit.report.model.GuarantorCompensationDetailInfo;
import com.ztx.credit.report.model.LoanDeclareDetailInfo;
import com.ztx.credit.report.model.LoanInfo;
import com.ztx.credit.report.model.LowReliefInfo;
import com.ztx.credit.report.model.PersonCreditInfo;
import com.ztx.credit.report.model.PersonalCareerInfo;
import com.ztx.credit.report.model.PersonalResidentialInfo;
import com.ztx.credit.report.model.QualificationInfo;
import com.ztx.credit.report.model.QuasiCreditInfo;
import com.ztx.credit.report.model.QueryPersonInfo;
import com.ztx.credit.report.model.QueryRecordInfo;
import com.ztx.credit.report.model.ReportHeadInfo;
import com.ztx.credit.report.model.SummaryQueryRecordInfo;
import com.ztx.credit.report.model.TaxesInfo;
import com.ztx.credit.report.model.TelecomPaymentInfo;
import com.ztx.credit.report.model.VehicleTradeAndMortgageInfo;

public interface IPbcOperDao {
	/**
	 * 新增用户基本信息表
	 * @param personCreditInfo
	 */
	public void insertPbcUserBaseInfo(PersonCreditInfo personCreditInfo,String urlid);
	/**
	 * 新增用户职业信息
	 * @param personCreditInfo
	 */
	public void insertPbcCareerInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<PersonalCareerInfo> personalCareerInfos,String urlid);
	
	/**
	 * 民事判决记录
	 * @param personCreditInfo
	 */
	public void insertPbcCivilJudgmentInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<CivilJudgmentInfo> civilJudgmentInfos,String urlid);
	
	/**
	 * 代偿信息
	 * @param personCreditInfo
	 */
	public void insertPbcCompensationInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos,String urlid);
	
	
	/**
	 * 贷记卡信息
	 * @param personCreditInfo
	 */
	public void insertPbcCreditCardInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<CreditCardInfo> creditCardInfos,String urlid);
	
	/**
	 * 本人声明
	 * @param personCreditInfo
	 */
	public void insertPbcDeclareDetailInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<LoanDeclareDetailInfo> loanDeclareDetailInfos,String urlid);
	
	/**
	 * 异议标注
	 * @param personCreditInfo
	 */
	public void insertPbcDissentDeclareDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<DissentDeclareDetailInfo> dissentDeclareDetailInfos,String urlid);
	
	/**
	 * 强制执行
	 * @param personCreditInfo
	 */
	public void insertPbcEnforcementInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<EnforcementInfo> enforcementInfos,String urlid);
	
	/**
	 * 对外担保信息
	 * @param personCreditInfo
	 */
	public void insertPbcGuaranteeDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<GuaranteeDetailInfo> guaranteeDetailInfos,String urlid);
	
	/**
	 * 贷款
	 * @param personCreditInfo
	 */
	public void insertPbcLoanInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<LoanInfo> loanInfos,String urlid);
//	
//	/**
//	 * 逾期信息
//	 * @param personCreditInfo
//	 */
//	public void insertPbcLoanOverdueInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo
//			,List<Object> loanOverdueInfos,int loanOverType,String loanOverInfoId,String urlid);	
//	
	
	/**
	 * 信用卡逾期信息
	 */
	public void insertCreditLoanOverdueInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo
			,List<Object> loanOverdueInfos,String loanOverInfoId,String urlid);	
	/**
	 * 贷记卡卡逾期信息
	 */
	public void insertCardLoanOverdueInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo
			,List<Object> loanOverdueInfos,String loanOverInfoId,String urlid);	
	/**
	 * 准贷记卡卡逾期信息
	 */
	public void insertQCardLoanOverdueInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo
			,List<Object> loanOverdueInfos,String loanOverInfoId,String urlid);
	
	/**
	 * 低保救助记录
	 * @param personCreditInfo
	 */
	public void insertPbcLowReLifeInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<LowReliefInfo> lowReliefInfos,String urlid);
	
	/**
	 * 行政处罚记录
	 * @param personCreditInfo
	 */
	public void insertPbcPunishmentInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<AdminPunishmentInfo> adminPunishmentInfos,String urlid);
	
	/**
	 * 执业资格记录
	 * @param personCreditInfo
	 */
	public void insertPbcQualificationInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<QualificationInfo> qualificationInfos,String urlid);
	
	/**
	 * 准贷记卡
	 * @param personCreditInfo
	 */
	public void insertPbcQuasiCreditInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<QuasiCreditInfo> quasiCreditInfos,String urlid);
	
	/**
	 * 查询记录详细
	 * @param personCreditInfo
	 */
	public void insertPbcQueryRecordInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<QueryRecordInfo> queryRecordInfos,String urlid);
	
	
	/**
	 * 查询记录汇总
	 * @param personCreditInfo
	 */
	public void insertPbcQueryRecordSummary(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,SummaryQueryRecordInfo summaryQueryRecordInfo,String urlid);
	
	
	
	/**
	 * 居住信息
	 * @param personCreditInfo
	 */
	public void insertPbcResidentialInfos(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<PersonalResidentialInfo> personalResidentialInfos,String urlid);
	
	/**
	 * 行政奖励记录
	 * @param personCreditInfo
	 */
	public void insertPbcRewardInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<AdministrativeRewardInfo> administrativeRewardInfos,String urlid);
	
	/**
	 * 欠税记录
	 * @param personCreditInfo
	 */
	public void insertPbcTaxesInfos(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<TaxesInfo> taxesInfos,String urlid);
	
	
	/**
	 * 电信缴费记录
	 */
	public void insertPbcTelecomPaymentInfos(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<TelecomPaymentInfo> telecomPaymentInfos,String urlid);
	
	
	/**
	 * 车辆交易和抵押记录
	 * @param personCreditInfo
	 */
	public void insertPbcVehicleTradeAndMortgageInfos(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos,String urlid);
	
	
	/**
	 * 资产处置信息
	 * @param personCreditInfo
	 */
	public void insertPbcAssertDisposeDetailInfo(ReportHeadInfo reportHeadInfo,QueryPersonInfo queryPersonInfo,List<AssertDisposeDetailInfo> assertDisposeDetailInfos,String urlid);
	
	
	/**
	 * 更新日志结果
	 */
	public void updateAnalysisLog(ReportHeadInfo reportHeadInfo,Map<String,Object> param);
	
	

	/**
	 * 获得日志 ID
	 */
	public String getAnalysisLog(String reportId);
	
}
