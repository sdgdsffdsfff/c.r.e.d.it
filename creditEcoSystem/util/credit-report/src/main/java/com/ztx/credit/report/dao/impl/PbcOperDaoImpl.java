package com.ztx.credit.report.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.util.AmtUtil;
import com.ztx.credit.report.dao.IPbcOperDao;
import com.ztx.credit.report.model.AdminPunishmentInfo;
import com.ztx.credit.report.model.AdministrativeRewardInfo;
import com.ztx.credit.report.model.AssertDisposeDetailInfo;
import com.ztx.credit.report.model.CivilJudgmentInfo;
import com.ztx.credit.report.model.CreditCardInfo;
import com.ztx.credit.report.model.CreditCardOverdue_24_Info;
import com.ztx.credit.report.model.DissentDeclareDetailInfo;
import com.ztx.credit.report.model.EnforcementInfo;
import com.ztx.credit.report.model.GuaranteeDetailInfo;
import com.ztx.credit.report.model.GuarantorCompensationDetailInfo;
import com.ztx.credit.report.model.LoanDeclareDetailInfo;
import com.ztx.credit.report.model.LoanInfo;
import com.ztx.credit.report.model.LoanOverdue_24_Info;
import com.ztx.credit.report.model.LowReliefInfo;
import com.ztx.credit.report.model.PersonCreditInfo;
import com.ztx.credit.report.model.PersonalCareerInfo;
import com.ztx.credit.report.model.PersonalResidentialInfo;
import com.ztx.credit.report.model.QualificationInfo;
import com.ztx.credit.report.model.QuasiCreditInfo;
import com.ztx.credit.report.model.QuasiCreditOverdueInfo;
import com.ztx.credit.report.model.QueryPersonInfo;
import com.ztx.credit.report.model.QueryRecordInfo;
import com.ztx.credit.report.model.ReportHeadInfo;
import com.ztx.credit.report.model.SpecialTradeType;
import com.ztx.credit.report.model.SummaryQueryRecordInfo;
import com.ztx.credit.report.model.TaxesInfo;
import com.ztx.credit.report.model.TelecomPaymentInfo;
import com.ztx.credit.report.model.VehicleTradeAndMortgageInfo;

@Repository
public class PbcOperDaoImpl implements IPbcOperDao {

	@Autowired
	private JdbcTemplate  jdbcTemplate;

	@Override
	public void insertPbcUserBaseInfo(final PersonCreditInfo personCreditInfo, final String logId) {
		// TODO Auto-generated method stub
		String insertSql = "insert into PBC_USER_BASE_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";  
		  jdbcTemplate.update(insertSql, new PreparedStatementSetter() {  
		      @Override  
		      public void setValues(PreparedStatement pstmt) throws SQLException {
		    	  String isMarried = personCreditInfo.getPersonalInfo().getIsMarried();
		          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
		          pstmt.setObject(2, personCreditInfo.getReportHeadInfo().getReportNo());//征信报告编号
		          pstmt.setObject(3, personCreditInfo.getReportHeadInfo().getReqTime());//查询请求时间
		          pstmt.setObject(4, personCreditInfo.getReportHeadInfo().getReportTime());//报告时间
		          pstmt.setObject(5, personCreditInfo.getQueryPersonInfo().getName());//被查询者姓名
		          pstmt.setObject(6, personCreditInfo.getQueryPersonInfo().getIdType());//被查询者证件类型
		          pstmt.setObject(7, personCreditInfo.getQueryPersonInfo().getiDNumber());//被查询者证件号码
		          pstmt.setObject(8, personCreditInfo.getQueryPersonInfo().getOperator());//查询操作员
		          pstmt.setObject(9, personCreditInfo.getQueryPersonInfo().getQueryReason());//查询原因
		          pstmt.setObject(10, "男".equals(personCreditInfo.getPersonalInfo().getGender())?1:2);//性别 : 1 男  2女
		          pstmt.setObject(11, personCreditInfo.getPersonalInfo().getBirthday());//出生日期
		          pstmt.setObject(12, "已婚".equals(isMarried)?1:"未婚".equals(isMarried)?2:"离异".equals(isMarried)?3:4);//婚姻状况：1已婚 2未婚 3离异 4丧偶
		          pstmt.setObject(13, personCreditInfo.getPersonalInfo().getMobilePhone());//手机号码
		          pstmt.setObject(14, personCreditInfo.getPersonalInfo().getComPhone());//单位电话
		          pstmt.setObject(15, personCreditInfo.getPersonalInfo().getHomePhone());//住宅电话
		          pstmt.setObject(16, personCreditInfo.getPersonalInfo().getEducation());//学历
		          pstmt.setObject(17, personCreditInfo.getPersonalInfo().getDegree());//学位
		          pstmt.setObject(18, personCreditInfo.getPersonalInfo().getAddress());//通讯地址
		          pstmt.setObject(19, personCreditInfo.getPersonalInfo().getPermanentAddress());//户籍地址
		          pstmt.setObject(20, personCreditInfo.getPersonalSpouseInfo().getName());//配偶姓名
		          pstmt.setObject(21, personCreditInfo.getPersonalSpouseInfo().getiDType());//配偶证件类型
		          pstmt.setObject(22, personCreditInfo.getPersonalSpouseInfo().getiDNumber());//配偶证件号码
		          pstmt.setObject(23, personCreditInfo.getPersonalSpouseInfo().getCompany());//配偶工作单位
		          pstmt.setObject(24, personCreditInfo.getPersonalSpouseInfo().getPhone());//配偶联系电话
		          pstmt.setObject(25, personCreditInfo.getSummaryCreditInfo().getHouseLoanCount());//住房贷款笔数
		          pstmt.setObject(26, personCreditInfo.getSummaryCreditInfo().getOtherLoanCount());//其他贷款笔数
		          pstmt.setObject(27, personCreditInfo.getSummaryCreditInfo().getFirstLoanOfferMonth());//首笔贷款发放月份
		          pstmt.setObject(28, personCreditInfo.getSummaryCreditInfo().getDebitAccountCount());//贷记卡账户数
		          pstmt.setObject(29, personCreditInfo.getSummaryCreditInfo().getFirstDebitOfferMonth());//首张贷记卡发卡月份
		          pstmt.setObject(30, personCreditInfo.getSummaryCreditInfo().getQuasiCreditAccountCount());//准贷记卡账户数
		          pstmt.setObject(31, personCreditInfo.getSummaryCreditInfo().getFirstQuasiDebitOfferMonth());//首张准贷记卡发卡月份
		          pstmt.setObject(32, personCreditInfo.getSummaryCreditInfo().getDeclareCount());//本人声明数目
		          pstmt.setObject(33, personCreditInfo.getSummaryCreditInfo().getDissentMarkCount());//异议标注数目
		          pstmt.setObject(34, personCreditInfo.getBankCreditInfo().getBankCreditGrade());//中征信评分
		          pstmt.setObject(35, personCreditInfo.getBankCreditInfo().getBankCreditMonth());//评分月份
		          pstmt.setObject(36, personCreditInfo.getSummaryOverdueAndDefaultInfo().getBadDebtsInfo().getTotalCount());//呆账信息汇总笔数
		          pstmt.setObject(37, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueAndDefaultInfo().getBadDebtsInfo().getTotalBalance().replaceAll(",", "")));//呆账信息汇总余额（以分为单位）
		          pstmt.setObject(38, personCreditInfo.getSummaryOverdueAndDefaultInfo().getAssertDisposeInfo().getTotalCount());//资产处置信息汇总笔数
		          pstmt.setObject(39, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueAndDefaultInfo().getAssertDisposeInfo().getTotalBalance().replaceAll(",", "")));
		          pstmt.setObject(40, personCreditInfo.getSummaryOverdueAndDefaultInfo().getGuarantorCompensationInfo().getTotalCount());//保证人代偿信息汇总笔数
		          pstmt.setObject(41, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueAndDefaultInfo().getGuarantorCompensationInfo().getTotalBalance().replaceAll(",", "")));//保证人代偿信息汇总余额（以分为单位）
		          pstmt.setObject(42, personCreditInfo.getSummaryOverdueInfo().getLoanOverDueInfo().getCount());//贷款逾期笔数
		          pstmt.setObject(43, personCreditInfo.getSummaryOverdueInfo().getLoanOverDueInfo().getMonthCount());//贷款逾期月份数
		          pstmt.setObject(44, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueInfo().getLoanOverDueInfo().getHighestMonthlyTotalAmount().replaceAll(",", "")));//贷款逾期单月最高逾期总额
		          pstmt.setObject(45, personCreditInfo.getSummaryOverdueInfo().getLoanOverDueInfo().getLongestOverDueMonthCount());//贷款逾期最长逾期月数
		          pstmt.setObject(46, personCreditInfo.getSummaryOverdueInfo().getCreditCardOverdue().getAccountCount());//贷记卡逾期账户数
		          pstmt.setObject(47, personCreditInfo.getSummaryOverdueInfo().getCreditCardOverdue().getMonthCount());//贷记卡逾期月份数
		          pstmt.setObject(48, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueInfo().getCreditCardOverdue().getHighestMonthlyTotalAmount().replaceAll(",", "")));//贷记卡逾期单月最高逾期总额
		          pstmt.setObject(49, personCreditInfo.getSummaryOverdueInfo().getCreditCardOverdue().getLongestOverDueMonthCount());//贷记卡最长逾期月数
		          pstmt.setObject(50, personCreditInfo.getSummaryOverdueInfo().getQuasiCreditOverdraftAbove60Days().getAccountCount());//准贷记卡60天以上透支账户数 QCARD = QUASI CARD
		          pstmt.setObject(51, personCreditInfo.getSummaryOverdueInfo().getQuasiCreditOverdraftAbove60Days().getMonthCount());//准贷记卡60天以上透支月份数
		          pstmt.setObject(52, AmtUtil.yuanToFen(personCreditInfo.getSummaryOverdueInfo().getQuasiCreditOverdraftAbove60Days().getHighestMonthlyTotalAmount().replaceAll(",", "")));//准贷记卡60天以上透支单月最高透支余额
		          pstmt.setObject(53, personCreditInfo.getSummaryOverdueInfo().getQuasiCreditOverdraftAbove60Days().getLongestOverDueMonthCount());//准贷记卡60天以上透支最长透支月数
		          pstmt.setObject(54, personCreditInfo.getSummaryOutstandingInfo().getLoanLegalCount());//未结清贷款法人机构数OS = outstanding
		          pstmt.setObject(55, personCreditInfo.getSummaryOutstandingInfo().getLoanInstitutionCount());//未结清贷款机构数
		          pstmt.setObject(56, personCreditInfo.getSummaryOutstandingInfo().getCount());//未结清贷款笔数
		          pstmt.setObject(57, AmtUtil.yuanToFen(personCreditInfo.getSummaryOutstandingInfo().getContractTotalAmount().replaceAll(",", "")));//未结清贷款合同总额
		          pstmt.setObject(58, AmtUtil.yuanToFen(personCreditInfo.getSummaryOutstandingInfo().getBalance().replaceAll(",", "")));//未结清贷款余额
		          pstmt.setObject(59, AmtUtil.yuanToFen(personCreditInfo.getSummaryOutstandingInfo().getLast6MonthsAvgRepayment().replaceAll(",", "")));//未结清贷款最近6个月平均应还款
		          pstmt.setObject(60, personCreditInfo.getSummaryNotCloseCreditInfo().getCardOfferLegalCounts());//未销户贷记卡发卡法人机构数 UCARD = UNCANCEL CARD
		          pstmt.setObject(61, personCreditInfo.getSummaryNotCloseCreditInfo().getCardIssuerCount());//未销户贷记卡发卡机构数
		          pstmt.setObject(62, personCreditInfo.getSummaryNotCloseCreditInfo().getAccountCount());//未销户贷记卡账户数
		          pstmt.setObject(63, AmtUtil.yuanToFen(personCreditInfo.getSummaryNotCloseCreditInfo().getCreditTotalLine().replaceAll(",", "")));//未销户贷记卡授信总额
		          pstmt.setObject(64, AmtUtil.yuanToFen(personCreditInfo.getSummaryNotCloseCreditInfo().getHighestCreditLine().replaceAll(",", "")));//未销户贷记卡单家行最高授信额
		          pstmt.setObject(65, AmtUtil.yuanToFen(personCreditInfo.getSummaryNotCloseCreditInfo().getLowestCreditLine().replaceAll(",", "")));//未销户贷记卡单家行最低授信额
		          pstmt.setObject(66, AmtUtil.yuanToFen(personCreditInfo.getSummaryNotCloseCreditInfo().getUsedLine().replaceAll(",", "")));//未销户贷记卡已用额度
		          pstmt.setObject(67, AmtUtil.yuanToFen(personCreditInfo.getSummaryNotCloseCreditInfo().getLast6MonthsAvgUsedLine().replaceAll(",", "")));//未销户贷记卡最近6个月平均使用额
		          pstmt.setObject(68, personCreditInfo.getSummaryQuasiCreditInfo().getCardOfferLegalCounts());//未销户准贷记卡发卡法人机构数
		          pstmt.setObject(69, personCreditInfo.getSummaryQuasiCreditInfo().getCardIssuerCount());//未销户准贷记卡发卡机构数
		          pstmt.setObject(70, personCreditInfo.getSummaryQuasiCreditInfo().getAccountCount());//未销户准贷记卡账户数
		          pstmt.setObject(71, AmtUtil.yuanToFen(personCreditInfo.getSummaryQuasiCreditInfo().getCreditTotalAmount().replaceAll(",", "")));//未销户准贷记卡授信总额
		          pstmt.setObject(72, AmtUtil.yuanToFen(personCreditInfo.getSummaryQuasiCreditInfo().getHighestCreditAmount().replaceAll(",", "")));//未销户准贷记卡单家行最高授信额
		          pstmt.setObject(73, AmtUtil.yuanToFen(personCreditInfo.getSummaryQuasiCreditInfo().getLowestCreditAmount().replaceAll(",", "")));//未销户准贷记卡单家行最低授信额
		          pstmt.setObject(74, AmtUtil.yuanToFen(personCreditInfo.getSummaryQuasiCreditInfo().getOverDraftBalance().replaceAll(",", "")));//未销户准贷记卡透支余额
		          pstmt.setObject(75, AmtUtil.yuanToFen(personCreditInfo.getSummaryQuasiCreditInfo().getLast6MonthsAvgOverDraftBalance().replaceAll(",", "")));//未销户准贷记卡最近6个月平均透支余额
		          pstmt.setObject(76, personCreditInfo.getSummaryGuaranteeInfo().getGuaranteeCount());//对外担保信息担保笔数
		          pstmt.setObject(77, AmtUtil.yuanToFen(personCreditInfo.getSummaryGuaranteeInfo().getGuaranteeAmount().replaceAll(",", "")));//对外担保信息担保金额
		          pstmt.setObject(78, AmtUtil.yuanToFen(personCreditInfo.getSummaryGuaranteeInfo().getGuaranteePrincipalBalance().replaceAll(",", "")));//对外担保信息担保本金余额
		          pstmt.setObject(79, personCreditInfo.getHousingFundPayInfo().getLocation());//住房公积金参缴参缴地
		          pstmt.setObject(80, personCreditInfo.getHousingFundPayInfo().getStartDate());//住房公积金参缴参缴日期
		          pstmt.setObject(81, personCreditInfo.getHousingFundPayInfo().getStartMonth());//住房公积金参缴初缴月份
		          pstmt.setObject(82, personCreditInfo.getHousingFundPayInfo().getEndMonth());//住房公积金参缴缴至月份
		          pstmt.setObject(83, personCreditInfo.getHousingFundPayInfo().getStatus());//住房公积金参缴缴费状态
		          pstmt.setObject(84, AmtUtil.yuanToFen(personCreditInfo.getHousingFundPayInfo().getAmount().replaceAll(",", "")));//住房公积金参缴月缴存额
		          pstmt.setObject(85, personCreditInfo.getHousingFundPayInfo().getIndividualProportion().replaceAll("%",""));//住房公积金参缴个人缴存比例(百分比 比如12表示12%)
		          pstmt.setObject(86, personCreditInfo.getHousingFundPayInfo().getCompanyProportion().replaceAll("%",""));//住房公积金参缴单位缴存比例(百分比 比如12表示12%)
		          pstmt.setObject(87, personCreditInfo.getHousingFundPayInfo().getCompany());//住房公积金参缴缴费单位
		          pstmt.setObject(88, personCreditInfo.getHousingFundPayInfo().getUpdateTime());//住房公积金参缴信息更新日期
		          pstmt.setObject(89, personCreditInfo.getPensionPayInfo().getLocation());//养老保险金缴存参保地
		          pstmt.setObject(90, personCreditInfo.getPensionPayInfo().getStartDate());//养老保险金缴存参保日期
		          pstmt.setObject(91, personCreditInfo.getPensionPayInfo().getPayMonthCount());//养老保险金缴存累计缴费月数
		          pstmt.setObject(92, personCreditInfo.getPensionPayInfo().getStartMonth());//养老保险金缴存参加工作月份
		          pstmt.setObject(93, personCreditInfo.getPensionPayInfo().getStatus());//养老保险金缴存缴费状态
		          pstmt.setObject(94, AmtUtil.yuanToFen(personCreditInfo.getPensionPayInfo().getIndividualBasePayAmount().replaceAll(",", "")));//养老保险金缴存个人缴费基数
		          pstmt.setObject(95, AmtUtil.yuanToFen(personCreditInfo.getPensionPayInfo().getMonthPaymentAmount().replaceAll(",", "")));//养老保险金缴存本月缴费金额
		          pstmt.setObject(96, personCreditInfo.getPensionPayInfo().getUpdateTime());//养老保险金缴存信息更新日期
		          pstmt.setObject(97, personCreditInfo.getPensionPayInfo().getCompany());//养老保险金缴存缴费单位
		          pstmt.setObject(98, personCreditInfo.getPensionPayInfo().getStopReason());//养老保险金缴存中断或终止缴费原因
		          pstmt.setObject(99, personCreditInfo.getPensionReceiveInfo().getLocation());//养老保险金发放记录发放地
		          pstmt.setObject(100, personCreditInfo.getPensionReceiveInfo().getRetiredType());//养老保险金发放记录离退休类别
		          pstmt.setObject(101, personCreditInfo.getPensionReceiveInfo().getRetiredMonth());//养老保险金发放记录离退休月份
		          pstmt.setObject(102, personCreditInfo.getPensionReceiveInfo().getStartMonth());//养老保险金发放记录参加工作月份
		          pstmt.setObject(103, AmtUtil.yuanToFen(personCreditInfo.getPensionReceiveInfo().getRealPension().replaceAll(",", "")));//养老保险金发放记录本月实发养老金
		          pstmt.setObject(104, personCreditInfo.getPensionReceiveInfo().getStopReason());//养老保险金发放记录停发原因
		          pstmt.setObject(105, personCreditInfo.getPensionReceiveInfo().getCompany());//养老保险金发放记录原单位名称
		          pstmt.setObject(106, personCreditInfo.getPensionReceiveInfo().getUpdateTime());//养老保险金发放记录信息更新日期
		          pstmt.setObject(107, logId);
		  }});  
		 
		
	}

	@Override
	public void insertPbcCareerInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<PersonalCareerInfo> personalCareerInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_CAREER_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final PersonalCareerInfo pciTemp: personalCareerInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getCompany());//工作单位
			          pstmt.setObject(7, pciTemp.getComAddress());//单位地址
			          pstmt.setObject(8, pciTemp.getCareer());//职业
			          pstmt.setObject(9, pciTemp.getIndustry());//行业
			          pstmt.setObject(10, pciTemp.getPosition());//职务
			          pstmt.setObject(11, pciTemp.getJobTitle());//职称
			          pstmt.setObject(12, pciTemp.getEntryYear());//进入本单位年份
			          pstmt.setObject(13, pciTemp.getUpdateTime());//信息更新日期
			          pstmt.setObject(14,logId);
			         }});
		}
		    
	}

	@Override
	public void insertPbcCivilJudgmentInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<CivilJudgmentInfo> civilJudgmentInfos,final String logId) {
		String sql = "insert into PBC_CIVIL_JUDGMENT_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final CivilJudgmentInfo pciTemp: civilJudgmentInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getFileCourt());//立案法院
			          pstmt.setObject(7, pciTemp.getFileReason());//案由
			          pstmt.setObject(8, pciTemp.getFileDate());//立案日期
			          pstmt.setObject(9, pciTemp.getSettleWay());//结案方式
			          pstmt.setObject(10, pciTemp.getDecisionResults());//判决/调解结果
			          pstmt.setObject(11, pciTemp.getEffectiveDate());//判决/调解生效日期
			          pstmt.setObject(12, pciTemp.getLitigationObject());//诉讼标的
			          pstmt.setObject(13, pciTemp.getLitigationObjectAmount());//诉讼标的金额
			          pstmt.setObject(14,logId);
			         }});
		}
	}

	@Override
	public void insertPbcCompensationInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<GuarantorCompensationDetailInfo> guarantorCompensationDetailInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_COMPENSATION_INFO values (?,?,?,?,?,?,?,?,?,?,?)";
		for(final GuarantorCompensationDetailInfo pciTemp: guarantorCompensationDetailInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getCompensationInstitutionCount());//代偿机构
			          pstmt.setObject(7, pciTemp.getLastCompensationDate());//最近一次代偿日期
			          pstmt.setObject(8, AmtUtil.yuanToFen(pciTemp.getTotalCompensationAmount().replaceAll(",", "")));//累计代偿金额
			          pstmt.setObject(9, pciTemp.getLastRepaymentDate());//最近一次还款日期
			          pstmt.setObject(10, AmtUtil.yuanToFen(pciTemp.getBalance().replaceAll(",", "")));//余额
			          pstmt.setObject(11,logId);
			         }});
		}
	}

	@Override
	public void insertPbcCreditCardInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<CreditCardInfo> creditCardInfos,final String logId) {
		String sql = "insert into PBC_CREDIT_CARD_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String specialSql = "insert into PBC_SPE_TRADE_DETAIL values(?,?,?,?,?,?,?,?)";
		for(final CreditCardInfo pciTemp: creditCardInfos){
			final String  guid = UUID.randomUUID().toString().replace("-", "");
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, guid);
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getTotalDescription());//总体描述
			          pstmt.setObject(6, pciTemp.getRepaymentRecord_24());//24个还款记录
			          pstmt.setObject(7, pciTemp.getRepaymentRecord_24Title());//24个还款记录标题
			          pstmt.setObject(8, pciTemp.getCreditCardOverdue_24_InfosTitle());//24个月逾期标题
//			          pstmt.setObject(9, pciTemp.getSpecialTradeType());//特殊交易类型
//			          pstmt.setObject(10, pciTemp.getOccurDate());//发生日期
//			          pstmt.setObject(11, pciTemp.getChangedMonthCount());//变更月数
//			          pstmt.setObject(12, AmtUtil.yuanToFen(pciTemp.getOccurAmount().replaceAll(",", "")));//发生金额
//			          pstmt.setObject(13, pciTemp.getOverdueRemark());//明细记录
			          pstmt.setObject(9, pciTemp.getCardIssuerDeclare());//发卡机构说明
			          pstmt.setObject(10, pciTemp.getDeclareDate_1());//发卡机构更新日期
			          pstmt.setObject(11, pciTemp.getLoanerDeclare());//本人声明
			          pstmt.setObject(12, pciTemp.getDeclareDate_2());//本人申明更新日期
			          pstmt.setObject(13, pciTemp.getDissentMark());//异议标记
			          pstmt.setObject(14, pciTemp.getDeclareDate_3());//异议标记更新日期
			          pstmt.setObject(15, pciTemp.getCardDetailInfo().getCardIssuer());//发卡机构数
			          pstmt.setObject(16, pciTemp.getCardDetailInfo().getServiceNo());//业务号
			          pstmt.setObject(17, pciTemp.getCardDetailInfo().getCurrency());//币种
			          pstmt.setObject(18, pciTemp.getCardDetailInfo().getIssueDate());//发放日期/贷款发放日期
			          pstmt.setObject(19, pciTemp.getCardDetailInfo().getCreditLine());//授信额度
			          pstmt.setObject(20, pciTemp.getCardDetailInfo().getGuaranteeWay());//担保方式
			          pstmt.setObject(21, pciTemp.getCardDetailInfo().getStatus());//状态
			          pstmt.setObject(22, pciTemp.getCardDetailInfo().getStateDeadline());//状态截止日
			          pstmt.setObject(23, pciTemp.getCardDetailInfo().getSharedLine());//共享额度
			          pstmt.setObject(24, pciTemp.getCardDetailInfo().getUsedLine());//已用额度
			          pstmt.setObject(25, pciTemp.getCardDetailInfo().getLast6MonthsAvgUsedLine());//过去6个月平均使用额度
			          pstmt.setObject(26, pciTemp.getCardDetailInfo().getMaxUsedLine());//最大使用额度
			          pstmt.setObject(27, pciTemp.getCardDetailInfo().getScheduledRepayment());//本月应还款
			          pstmt.setObject(28, pciTemp.getCardDetailInfo().getBillDate());//账单日
			          pstmt.setObject(29, pciTemp.getCardDetailInfo().getRealRepayment());//本月实还款
			          pstmt.setObject(30, pciTemp.getCardDetailInfo().getLastRepaymentDate());//最近一次还款日期
			          pstmt.setObject(31, pciTemp.getCardDetailInfo().getOverDuePeriodCount());//当期逾期数
			          pstmt.setObject(32, AmtUtil.yuanToFen(pciTemp.getCardDetailInfo().getOverDueAmount().replaceAll(",", "")));//当期逾期金额
			          pstmt.setObject(33,logId);
			      }});
			
			for(final SpecialTradeType stt : pciTemp.getSpecialTradeTypes()){
				jdbcTemplate.update(specialSql, new PreparedStatementSetter() {  
				      @Override  
				      public void setValues(PreparedStatement pstmt) throws SQLException {
				    	  pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
				    	  pstmt.setObject(2, guid);
				    	  pstmt.setObject(3, stt.getSpecialTradeType());
				    	  pstmt.setObject(4, stt.getOccurDate());
				    	  pstmt.setObject(5, stt.getChangedMonthCount());
				    	  pstmt.setObject(6, AmtUtil.yuanToFen(stt.getOccurAmount().replaceAll(",", "")));
				    	  pstmt.setObject(7, stt.getOverdueRemark());
				    	  pstmt.setObject(8, 2);
				      }});
			}
			insertCardLoanOverdueInfo(reportHeadInfo,queryPersonInfo,pciTemp.getCreditCardOverdue_24_Infos(), guid,logId);
			
			
		}
	}

	@Override
	public void insertPbcDeclareDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<LoanDeclareDetailInfo> loanDeclareDetailInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_DECLARE_DETAIL_INFO values (?,?,?,?,?,?,?,?)";
		for(final LoanDeclareDetailInfo pciTemp: loanDeclareDetailInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getContent());//申明内容
			          pstmt.setObject(7, pciTemp.getDeclareDate());//申明时间
			          pstmt.setObject(8,logId);
			      }});
		}
	}

	@Override
	public void insertPbcDissentDeclareDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<DissentDeclareDetailInfo> dissentDeclareDetailInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_DISSENT_DECLARE_INFO values (?,?,?,?,?,?,?,?)";
		for(final DissentDeclareDetailInfo pciTemp: dissentDeclareDetailInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getContent());//申明内容
			          pstmt.setObject(7, pciTemp.getDeclareDate());//申明时间
			          pstmt.setObject(8,logId);
			      }});
		}
	}

	@Override
	public void insertPbcEnforcementInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<EnforcementInfo> enforcementInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_ENFORCEMENT_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final EnforcementInfo pciTemp: enforcementInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getExecuteCourt());//执行法院
			          pstmt.setObject(7, pciTemp.getExecuteReason());//执行案由
			          pstmt.setObject(8, pciTemp.getExecuteDate());//立案日期
			          pstmt.setObject(9, pciTemp.getExecuteWay());//结案方式
			          pstmt.setObject(10, pciTemp.getStatus());//案件状态
			          pstmt.setObject(11, pciTemp.getSettlementDate());//结案日期
			          pstmt.setObject(12, pciTemp.getApplyExecuteObject());//申请执行标的
			          pstmt.setObject(13, pciTemp.getApplyExecuteObjectValue());//申请执行标的价值
			          pstmt.setObject(14, pciTemp.getExecutedObject());//已执行标的
			          pstmt.setObject(15, AmtUtil.yuanToFen(pciTemp.getExecutedObjectAmount().replaceAll(",", "")));//已执行标的金额
			          pstmt.setObject(15,logId);
			      }});
		}
	}

	@Override
	public void insertPbcGuaranteeDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<GuaranteeDetailInfo> guaranteeDetailInfos,final String logId) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		String sql = "insert into PBC_GUARANTEE_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final GuaranteeDetailInfo pciTemp: guaranteeDetailInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getLoanIssuer());//担保贷款发放机构
			          pstmt.setObject(7, AmtUtil.yuanToFen(pciTemp.getLoanContractAmount().replaceAll(",", "")));//担保贷款合同金额
			          pstmt.setObject(8, pciTemp.getIssueDate());//担保贷款发放日期
			          pstmt.setObject(9, pciTemp.getDueDate());//担保贷款到期日期
			          pstmt.setObject(10, AmtUtil.yuanToFen(pciTemp.getGuaranteeAmount().replaceAll(",", "")));//担保金额
			          pstmt.setObject(11, AmtUtil.yuanToFen(pciTemp.getPrincipalBalance().replaceAll(",", "")));//担保贷款本金余额
			          pstmt.setObject(12, pciTemp.getFiveClassification());//担保贷款五级分类
			          pstmt.setObject(13, pciTemp.getSettlementDate());//结算日期
			          pstmt.setObject(14,logId);
			 }});
		}		
	}

	@Override
	public void insertPbcLoanInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<LoanInfo> loanInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_LOAN_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String specialSql = "insert into PBC_SPE_TRADE_DETAIL values(?,?,?,?,?,?,?,?)";
		for(final LoanInfo pciTemp: loanInfos){
			final String guid = UUID.randomUUID().toString().replaceAll("-","");
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, guid);
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getTotalDescription());//贷款标题
			          pstmt.setObject(6, pciTemp.getRepaymentRecord_24());//24个月还款记录
			          pstmt.setObject(7, pciTemp.getRepaymentRecord_24Title());//24个月还款记录标题
			          pstmt.setObject(8, pciTemp.getLoanOverdue_24_InfoTitle());//24个月逾期记录
//			          pstmt.setObject(9, pciTemp.getSpecialTradeType());//特殊交易类型
//			          pstmt.setObject(10, pciTemp.getOccurDate());//发生日期
//			          pstmt.setObject(11, pciTemp.getChangedMonthCount());//变更月数
//			          pstmt.setObject(12, AmtUtil.yuanToFen(pciTemp.getOccurAmount().replaceAll(",", "")));//发生金额
//			          pstmt.setObject(13, pciTemp.getOverdueRemark());//明细记录
			          pstmt.setObject(9, pciTemp.getLoanInstitutionDeclare());//贷款机构说明
			          pstmt.setObject(10, pciTemp.getDeclareDate_1());//添加日期
			          pstmt.setObject(11, pciTemp.getLoanerDeclare());//本人声明
			          pstmt.setObject(12, pciTemp.getDeclareDate_2());//添加日期
			          pstmt.setObject(13, pciTemp.getDissentMark());//异议标注
			          pstmt.setObject(14, pciTemp.getDeclareDate_3());//添加日期
			          pstmt.setObject(15, pciTemp.getLoanDetailInfo().getLoanInstitution());//贷款机构,贷款机构名称
			          pstmt.setObject(16, pciTemp.getLoanDetailInfo().getServiceNo());//业务号
			          pstmt.setObject(17, pciTemp.getLoanDetailInfo().getLoanType());//贷款种类细分,贷款种类
			          pstmt.setObject(18, pciTemp.getLoanDetailInfo().getCurrency());//币种
			          pstmt.setObject(19, pciTemp.getLoanDetailInfo().getIssueDate());//发卡日期
			          pstmt.setObject(20, pciTemp.getLoanDetailInfo().getDueDate());//担保贷款到期日期
			          pstmt.setObject(21, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getContractTotalAmount().replaceAll(",", "")));//合同总额
			          pstmt.setObject(22, pciTemp.getLoanDetailInfo().getGuaranteeWay());//担保方式
			          pstmt.setObject(23, pciTemp.getLoanDetailInfo().getRepaymentFrequency());//还款频率
			          pstmt.setObject(24, pciTemp.getLoanDetailInfo().getRepaymentPeriods());//repaymentPeriods
			          pstmt.setObject(25, pciTemp.getLoanDetailInfo().getStatus());//状态
			          pstmt.setObject(26, pciTemp.getLoanDetailInfo().getStateDeadline());//状态截止日
			          pstmt.setObject(27, pciTemp.getLoanDetailInfo().getStateEndedMarch());//状态截止月/转出月
			          pstmt.setObject(28, pciTemp.getLoanDetailInfo().getFiveClassification());//五级分类
			          pstmt.setObject(29, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getPrincipalBalance().replaceAll(",", "")));//本金余额
			          pstmt.setObject(30, pciTemp.getLoanDetailInfo().getRemainRepaymentPeriodCount());//剩余还款期数
			          pstmt.setObject(31, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getScheduledRepayment().replaceAll(",", "")));//本月应还款
			          pstmt.setObject(32, pciTemp.getLoanDetailInfo().getScheduledRepaymentDate());//应还款日
			          pstmt.setObject(33, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getRealRepayment().replaceAll(",", "")));//本月实还款
			          pstmt.setObject(34, pciTemp.getLoanDetailInfo().getLastRepaymentDate());//最近一次还款日期
			          pstmt.setObject(35, pciTemp.getLoanDetailInfo().getOverDuePeriodCount());//当前逾期期数
			          pstmt.setObject(36, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getOverDueAmount().replaceAll(",", "")));//当前逾期金额
			          pstmt.setObject(37, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getOverdue31_60DaysPrincipal().replaceAll(",", "")));//60天未还本金
			          pstmt.setObject(38, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getOverdue61_90DaysPrincipal().replaceAll(",", "")));//90天未还本金
			          pstmt.setObject(39, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getOverdue91_180DaysPrincipal().replaceAll(",", "")));//180天未还本金
			          pstmt.setObject(40, AmtUtil.yuanToFen(pciTemp.getLoanDetailInfo().getOverdue180DaysAbovePrincipal().replaceAll(",", "")));//逾期180天以上未还本金
			          pstmt.setObject(41,logId);
			    }});
			
			for(final SpecialTradeType stt : pciTemp.getSpecialTradeTypes()){
				jdbcTemplate.update(specialSql, new PreparedStatementSetter() {  
				      @Override  
				      public void setValues(PreparedStatement pstmt) throws SQLException {
				    	  pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
				    	  pstmt.setObject(2, guid);
				    	  pstmt.setObject(3, stt.getSpecialTradeType());
				    	  pstmt.setObject(4, stt.getOccurDate());
				    	  pstmt.setObject(5, stt.getChangedMonthCount());
				    	  pstmt.setObject(6, AmtUtil.yuanToFen(stt.getOccurAmount().replaceAll(",", "")));
				    	  pstmt.setObject(7, stt.getOverdueRemark());
				    	  pstmt.setObject(8, 2);
				      }});
			}
			
			
			insertCreditLoanOverdueInfo(reportHeadInfo,queryPersonInfo,pciTemp.getLoanOverdue_24_Infos(), guid,logId);
		}			
	}

//	@Override
//	public void insertPbcLoanOverdueInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo
//			,final List<Object> loanOverdueInfos,int loanOverType,String loanOverInfoId) {
////		// TODO Auto-generated method stub
//		if(loanOverType == 1){
//			insertCreditLoanOverdueInfo(reportHeadInfo,queryPersonInfo,loanOverdueInfos,loanOverInfoId);
//		}else if(loanOverType == 2){
//			insertCardLoanOverdueInfo(reportHeadInfo,queryPersonInfo,loanOverdueInfos,loanOverInfoId);
//		}else if(loanOverType == 3){
//			insertQCardLoanOverdueInfo(reportHeadInfo,queryPersonInfo,loanOverdueInfos,loanOverInfoId);
//		}
//		
//	
//	}

	@Override
	public void insertPbcLowReLifeInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<LowReliefInfo> lowReliefInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_LOW_RELIEF_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final LowReliefInfo pciTemp: lowReliefInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getPersonType());//人员类别
			          pstmt.setObject(7, pciTemp.getLocation());//所在地
			          pstmt.setObject(8, pciTemp.getCompany());//工作单位
			          pstmt.setObject(9, AmtUtil.yuanToFen(pciTemp.getFamilyMonthlyIncome().replaceAll(",", "")));//家庭月收入
			          pstmt.setObject(10, pciTemp.getApplyDate());//申请日期
			          pstmt.setObject(11, pciTemp.getApprovalDate());//批准日期
			          pstmt.setObject(12, pciTemp.getUpdateTime());//信息更新日期
			          pstmt.setObject(13,logId);
			 }});
		}		
	}

	@Override
	public void insertPbcPunishmentInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<AdminPunishmentInfo> adminPunishmentInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_PUNISHMENT_INFO values (?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final AdminPunishmentInfo pciTemp: adminPunishmentInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getPunishInstitution());//处罚机构
			          pstmt.setObject(7, pciTemp.getPunishContent());//处罚内容
			          pstmt.setObject(8, AmtUtil.yuanToFen(pciTemp.getPunishAmount().replaceAll(",", "")));//处罚金额
			          pstmt.setObject(9, pciTemp.getEffectiveDate());//生效日期
			          pstmt.setObject(10, pciTemp.getEndDate());//截止日期
			          pstmt.setObject(11, pciTemp.getAdminReviewResult());//行政复议结果
			          pstmt.setObject(12,logId);
			 }});
		}			
	}

	@Override
	public void insertPbcQualificationInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<QualificationInfo> qualificationInfos,final String logId) {
		String sql = "insert into PBC_QUALIFICATION_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final QualificationInfo pciTemp: qualificationInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getQualificationName());//执业资格名称
			          pstmt.setObject(7, pciTemp.getRank());//等级
			          pstmt.setObject(8, pciTemp.getGetDate());//获得日期
			          pstmt.setObject(9, pciTemp.getDueDate());//到期日期
			          pstmt.setObject(10, pciTemp.getRevocationDate());//吊销日期
			          pstmt.setObject(11, pciTemp.getAuthority());//颁发机构
			          pstmt.setObject(12, pciTemp.getLocation());//机构所在地
			          pstmt.setObject(13,logId);
			 }});
		}
	}

	@Override
	public void insertPbcQuasiCreditInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<QuasiCreditInfo> quasiCreditInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_QUASI_CREDIT_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String specialSql = "insert into PBC_SPE_TRADE_DETAIL values(?,?,?,?,?,?,?,?)";
		for(final QuasiCreditInfo pciTemp: quasiCreditInfos){
			final String guid = UUID.randomUUID().toString().replaceAll("-","");
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, guid);
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getTotalDescription());//总体描述
			          pstmt.setObject(6, pciTemp.getRepaymentRecord_24());//24个月还款记录
			          pstmt.setObject(7, pciTemp.getRepaymentRecord_24Title());//24个月还款记录标题
			          pstmt.setObject(8, pciTemp.getCreditOverdueInfosTitle());//24个月逾期记录
//			          pstmt.setObject(9, pciTemp.getSpecialTradeType());//特殊交易类型
//			          pstmt.setObject(10, pciTemp.getOccurDate());//发生日期
//			          pstmt.setObject(11, pciTemp.getChangedMonthCount());//变更月数
//			          pstmt.setObject(12, AmtUtil.yuanToFen(pciTemp.getOccurAmount().replaceAll(",", "")));//发生金额
//			          pstmt.setObject(13, pciTemp.getOverdueRemark());//明细记录
			          pstmt.setObject(9, pciTemp.getCardIssuerDeclare());//贷款机构说明
			          pstmt.setObject(10, pciTemp.getDeclareDate_1());//添加日期
			          pstmt.setObject(11, pciTemp.getLoanerDeclare());//本人声明
			          pstmt.setObject(12, pciTemp.getDeclareDate_2());//添加日期
			          pstmt.setObject(13, pciTemp.getDissentMark());//异议标注
			          pstmt.setObject(14, pciTemp.getDeclareDate_3());//添加日期
			          pstmt.setObject(15, pciTemp.getQuasiCreditDetailInfo().getSharedLine());//共享额度
			          pstmt.setObject(16, pciTemp.getQuasiCreditDetailInfo().getOverDraftBalance());//透支余额
			          pstmt.setObject(17, pciTemp.getQuasiCreditDetailInfo().getLast6MonthsAvgOverDraftBalance());//最近6个月平均透支余额
			          pstmt.setObject(18, pciTemp.getQuasiCreditDetailInfo().getMaxOverDraftBalance());//最大透支余额
			          pstmt.setObject(19, pciTemp.getQuasiCreditDetailInfo().getBillDate());//账单日
			          pstmt.setObject(20, pciTemp.getQuasiCreditDetailInfo().getRealRepayment());//本月实还款
			          pstmt.setObject(21, pciTemp.getQuasiCreditDetailInfo().getLastRepaymentDate());//最近一次还款日期
			          pstmt.setObject(22, pciTemp.getQuasiCreditDetailInfo().getOverdue180DaysAboveBalance());//透支180天以上未付余额
			          pstmt.setObject(23, pciTemp.getQuasiCreditDetailInfo().getCardIssuer());//发卡机构
			          pstmt.setObject(24, pciTemp.getQuasiCreditDetailInfo().getServiceNo());//业务号
			          pstmt.setObject(25, pciTemp.getQuasiCreditDetailInfo().getCurrency());//币种
			          pstmt.setObject(26, pciTemp.getQuasiCreditDetailInfo().getIssueDate());//发卡日期
			          pstmt.setObject(27, pciTemp.getQuasiCreditDetailInfo().getCreditLine());//授信额度
			          pstmt.setObject(28, pciTemp.getQuasiCreditDetailInfo().getGuaranteeWay());//担保方式
			          pstmt.setObject(29, pciTemp.getQuasiCreditDetailInfo().getStatus());//状态/账户状态
			          pstmt.setObject(30, pciTemp.getQuasiCreditDetailInfo().getStateDeadline());//状态截止日
			          pstmt.setObject(31,logId);
			         
			 }});
			
			for(final SpecialTradeType stt : pciTemp.getSpecialTradeTypes()){
				jdbcTemplate.update(specialSql, new PreparedStatementSetter() {  
				      @Override  
				      public void setValues(PreparedStatement pstmt) throws SQLException {
				    	  pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
				    	  pstmt.setObject(2, guid);
				    	  pstmt.setObject(3, stt.getSpecialTradeType());
				    	  pstmt.setObject(4, stt.getOccurDate());
				    	  pstmt.setObject(5, stt.getChangedMonthCount());
				    	  pstmt.setObject(6, AmtUtil.yuanToFen(stt.getOccurAmount().replaceAll(",", "")));
				    	  pstmt.setObject(7, stt.getOverdueRemark());
				    	  pstmt.setObject(8, 2);
				      }});
			}
			
			
			insertQCardLoanOverdueInfo(reportHeadInfo,queryPersonInfo,pciTemp.getCreditOverdueInfos(), guid,logId);
		}	
	}

	@Override
	public void insertPbcQueryRecordInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<QueryRecordInfo> queryRecordInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_QUERY_RECORD_INFO values (?,?,?,?,?,?,?,?,?)";
		for(final QueryRecordInfo pciTemp: queryRecordInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getQueryDate());//查询日期
			          pstmt.setObject(7, pciTemp.getQueryOperator());//查询员
			          pstmt.setObject(8, pciTemp.getQueryReason());//查询理由
			          pstmt.setObject(9,logId);
			 }});
		}			
	}

	@Override
	public void insertPbcQueryRecordSummary(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final SummaryQueryRecordInfo summaryQueryRecordInfo,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_QUERY_RECORD_SUMMARY values (?,?,?,?,?,?,?,?,?,?,?,?)";
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, summaryQueryRecordInfo.getLast1MonthQueryInstitution().getLoanApprovalCount());//最近1个月内的查询机构数贷款审批
			          pstmt.setObject(6, summaryQueryRecordInfo.getLast1MonthQueryInstitution().getCreditCardApprovalCount());//最近1个月内的查询机构数信用卡审批
			          pstmt.setObject(7, summaryQueryRecordInfo.getLast1MonthQuery().getLoanApprovalCount());//最近1个月内的查询次数贷款审批
			          pstmt.setObject(8, summaryQueryRecordInfo.getLast1MonthQuery().getCreditCardApprovalCount());//最近1个月内的查询次数信用卡审批
			          pstmt.setObject(9, summaryQueryRecordInfo.getLast2YearsQuery().getPostLoanManageCount());//最近2年内的查询次数贷后管理
			          pstmt.setObject(10, summaryQueryRecordInfo.getLast2YearsQuery().getGuaranteeCount());//最近2年内的查询次数担保资格审查
			          pstmt.setObject(11, summaryQueryRecordInfo.getLast2YearsQuery().getMerchantReview());//最近2年内的查询次数特约商户实名审查
			          pstmt.setObject(12,logId);
			 }});
	}

	@Override
	public void insertPbcResidentialInfos(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<PersonalResidentialInfo> personalResidentialInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_RESIDENTIAL_INFO values (?,?,?,?,?,?,?,?,?)";
		for(final PersonalResidentialInfo pciTemp: personalResidentialInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getAddress());//居住地址
			          pstmt.setObject(7, pciTemp.getResidentialStatus());//居住状况
			          pstmt.setObject(8, pciTemp.getUpdateTime());//信息更新日期
			          pstmt.setObject(9,logId);
			 }});
		}		
	}

	@Override
	public void insertPbcRewardInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final List<AdministrativeRewardInfo> administrativeRewardInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_REWARD_INFO values (?,?,?,?,?,?,?,?,?,?)";
		for(final AdministrativeRewardInfo pciTemp: administrativeRewardInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getRewardInstitution());//奖励机构
			          pstmt.setObject(7, pciTemp.getRewardContent());//奖励内容
			          pstmt.setObject(8, pciTemp.getEffectiveDate());//生效日期
			          pstmt.setObject(9, pciTemp.getEndDate());//截止日期
			          pstmt.setObject(10,logId);
			 }});
		}		
	}

	@Override
	public void insertPbcTaxesInfos(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final  List<TaxesInfo> taxesInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_TAXES_INFO values (?,?,?,?,?,?,?,?,?)";
		for(final TaxesInfo pciTemp: taxesInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getTaxAuthorities());//主管税务机关
			          pstmt.setObject(7, AmtUtil.yuanToFen(pciTemp.getTaxesTotalAmount().replaceAll(",", "")));//欠税总额
			          pstmt.setObject(8, pciTemp.getStatisticalDate());//欠税统计日期
			 }});
		}
	}

	@Override
	public void insertPbcTelecomPaymentInfos(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final  List<TelecomPaymentInfo> telecomPaymentInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_QUALIFICATION_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final TelecomPaymentInfo pciTemp: telecomPaymentInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getTelecomOperator());//电信运营商
			          pstmt.setObject(7, pciTemp.getBusinessType());//业务类型
			          pstmt.setObject(8, pciTemp.getEffectiveDate());//业务开通日期
			          pstmt.setObject(9, "正常".equals(pciTemp.getStatus())?1:0);//当前缴费状态 0 欠费 1正常
			          pstmt.setObject(10, AmtUtil.yuanToFen(pciTemp.getDebtAmount().replaceAll(",", "")));//当前欠费金额
			          pstmt.setObject(11, pciTemp.getDebtMonthCount());//当前欠费月数
			          pstmt.setObject(12, pciTemp.getRecordDate());//记账年月
			          pstmt.setObject(13, pciTemp.getPaymentRecord_24());//最近24个月缴费记录
			          pstmt.setObject(14,logId);
			 }});
		}
	}

	@Override
	public void insertPbcVehicleTradeAndMortgageInfos(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final  List<VehicleTradeAndMortgageInfo> vehicleTradeAndMortgageInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_VEHICLE_TM_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final VehicleTradeAndMortgageInfo pciTemp: vehicleTradeAndMortgageInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getVehicleNo());//车牌号码
			          pstmt.setObject(7, pciTemp.getEngineNo());//发动机号
			          pstmt.setObject(8, pciTemp.getBrand());//品牌
			          pstmt.setObject(9, pciTemp.getVehicleType());//车辆类型
			          pstmt.setObject(10, pciTemp.getUseAttribute());//使用性质
			          pstmt.setObject(11, pciTemp.getStatus());//车辆状态
			          pstmt.setObject(12, "未抵押".equals(pciTemp.getIsMortgage())?0:1);//抵押标记 0 未抵押 1抵押
			          pstmt.setObject(13, pciTemp.getUpdateTime());//信息更新日期
			          pstmt.setObject(14,logId);
			 }});
		}		
	}

	@Override
	public void insertPbcAssertDisposeDetailInfo(final ReportHeadInfo reportHeadInfo,final QueryPersonInfo queryPersonInfo,final  List<AssertDisposeDetailInfo> assertDisposeDetailInfos,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_ASSERT_DISPOSE_INFO values (?,?,?,?,?,?,?,?,?,?,?)";
		for(final AssertDisposeDetailInfo pciTemp: assertDisposeDetailInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, pciTemp.getSerial());//编号
			          pstmt.setObject(6, pciTemp.getAssetManagementCompany());//资产管理公司
			          pstmt.setObject(7, pciTemp.getDebtReceivedDate());//债务接收日期
			          pstmt.setObject(8, AmtUtil.yuanToFen(pciTemp.getReceivedCreditAmount().replaceAll(",", "")));//接收的债权金额
			          pstmt.setObject(9, pciTemp.getLastRepaymentDate());//最近一次还款日期
			          pstmt.setObject(10, AmtUtil.yuanToFen(pciTemp.getBalance().replaceAll(",", "")));//余额
			          pstmt.setObject(11, logId);
			 }});
		}		
	}

	@Override
	public void insertCreditLoanOverdueInfo(final ReportHeadInfo reportHeadInfo,
			final QueryPersonInfo queryPersonInfo,final List loanOverdueInfos,
			final String loanOverInfoId,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_LOAN_OVERDUE_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final Object ot: loanOverdueInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			    	  LoanOverdue_24_Info pciTemp = (LoanOverdue_24_Info)ot;
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, 1);//逾期业务类型 1 信用卡 2贷记卡 3准贷记卡
			          pstmt.setObject(6, loanOverInfoId);//逾期业务ID
			          pstmt.setObject(7, pciTemp.getOverdueMonth());//逾期月份
			          pstmt.setObject(8, pciTemp.getOverdueMonthCount());//逾期持续月数
			          pstmt.setObject(9, AmtUtil.yuanToFen(pciTemp.getOverdueAmount().replaceAll(",", "")));//逾期金额
			          pstmt.setObject(10, null);//起始月
			          pstmt.setObject(11, null);//截止月
			          pstmt.setObject(12, null);//逾期月份
			          pstmt.setObject(13, null);//逾期持续月数
			          pstmt.setObject(14, null);//逾期金额
			          pstmt.setObject(15,logId);
			 }});
		}			
	}

	@Override
	public void insertCardLoanOverdueInfo(final ReportHeadInfo reportHeadInfo,
			final  QueryPersonInfo queryPersonInfo, final  List loanOverdueInfos,
			final  String loanOverInfoId,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_LOAN_OVERDUE_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final Object ot: loanOverdueInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			    	  CreditCardOverdue_24_Info pciTemp = (CreditCardOverdue_24_Info)ot;
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, 2);//逾期业务类型 1 信用卡 2贷记卡 3准贷记卡
			          pstmt.setObject(6, loanOverInfoId);//逾期业务ID
			          pstmt.setObject(7, pciTemp.getOverdueMonth());//逾期月份
			          pstmt.setObject(8, pciTemp.getOverdueMonthCount());//逾期持续月数
			          pstmt.setObject(9, AmtUtil.yuanToFen(pciTemp.getOverdueAmount().replaceAll(",", "")));//逾期金额
			          pstmt.setObject(10, pciTemp.getStartMonthSpecial());//起始月
			          pstmt.setObject(11, pciTemp.getEndMonthSpecial());//截止月
			          pstmt.setObject(12, pciTemp.getOverdueMonthCount());//逾期月份
			          pstmt.setObject(13, pciTemp.getOverdueMonthCountSpecial());//逾期持续月数
			          pstmt.setObject(14, pciTemp.getOverdueAmount());//逾期金额
			          pstmt.setObject(15,logId);
			 }});
		}
	}

	@Override
	public void insertQCardLoanOverdueInfo(final ReportHeadInfo reportHeadInfo,
			final QueryPersonInfo queryPersonInfo, final List loanOverdueInfos,
			final String loanOverInfoId,final String logId) {
		// TODO Auto-generated method stub
		String sql = "insert into PBC_LOAN_OVERDUE_INFO values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		for(final Object ot: loanOverdueInfos){
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			    	  QuasiCreditOverdueInfo pciTemp = (QuasiCreditOverdueInfo)ot;
			          pstmt.setObject(1, UUID.randomUUID().toString().replace("-", ""));
			          pstmt.setObject(2, reportHeadInfo.getReportNo());//征信报告编号
			          pstmt.setObject(3, queryPersonInfo.getIdType());//被查询者证件类型
			          pstmt.setObject(4, queryPersonInfo.getiDNumber());//被查询者证件号码
			          pstmt.setObject(5, 3);//逾期业务类型 1 信用卡 2贷记卡 3准贷记卡
			          pstmt.setObject(6, loanOverInfoId);//逾期业务ID
			          pstmt.setObject(7, pciTemp.getOverDraftMonth());//逾期月份
			          pstmt.setObject(8, pciTemp.getOverDraftMonthCount());//逾期持续月数
			          pstmt.setObject(9, AmtUtil.yuanToFen(pciTemp.getOverDraftAmount().replaceAll(",", "")));//逾期金额
			          pstmt.setObject(10, null);//起始月
			          pstmt.setObject(11, null);//截止月
			          pstmt.setObject(12, null);//逾期月份
			          pstmt.setObject(13, null);//逾期持续月数
			          pstmt.setObject(14, null);//逾期金额
			          pstmt.setObject(15,logId);
			 }});
		}	
		
	}

	@Override
	public void updateAnalysisLog(ReportHeadInfo reportHeadInfo,
			final Map<String, Object> param) {
		// TODO Auto-generated method stub
		String sql = "update PBC_ANALYSIS_LOG set PARTH=?,ANALYSIS_RESULT=?,SOURCE_TYPE=? where SOURCE_ID = ?";
			jdbcTemplate.update(sql, new PreparedStatementSetter() {  
			      @Override  
			      public void setValues(PreparedStatement pstmt) throws SQLException {
			          pstmt.setObject(1, param.get("parth").toString());//路径
			          pstmt.setObject(2, param.get("analysis_result").toString());//解析结果
			          pstmt.setObject(3, 2);//1 数据库 2文件
			          pstmt.setObject(4, param.get("source_id"));//来源ID 数据库ID 或者 文件名字
			 }});	
	}

	@Override
	public String getAnalysisLog(String reportId) {
		// TODO Auto-generated method stub
		String sql = "select ID from PBC_ANALYSIS_LOG where SOURCE_ID = ?";
		Map<String, Object>  object = jdbcTemplate.queryForMap(sql, reportId);
		return object.get("ID").toString();
	}


}
