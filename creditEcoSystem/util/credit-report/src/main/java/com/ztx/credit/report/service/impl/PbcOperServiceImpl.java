package com.ztx.credit.report.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ztx.credit.report.dao.IPbcOperDao;
import com.ztx.credit.report.model.PersonCreditInfo;
import com.ztx.credit.report.model.QueryPersonInfo;
import com.ztx.credit.report.model.ReportHeadInfo;
import com.ztx.credit.report.service.IPbcOperService;

@Service
@Transactional
public class PbcOperServiceImpl implements IPbcOperService {

	@Autowired
	IPbcOperDao pbcOperDaoImpl;

	@Override
	public void insertPbc(PersonCreditInfo personCreditInfo,String urlId,String resultInfo) {
		String result = resultInfo;
		// TODO Auto-generated method stub
		// 插入用户基本信息
		ReportHeadInfo reportHeadInfo = personCreditInfo.getReportHeadInfo();
		QueryPersonInfo queryPersonInfo = personCreditInfo.getQueryPersonInfo();
		
		String logid = pbcOperDaoImpl.getAnalysisLog(urlId);
		
		
		try {
			if(personCreditInfo.getReportHeadInfo().getReportNo() == null || personCreditInfo.getReportHeadInfo().getReportNo().isEmpty()){
				result +="ERROR:MessyCode";
			}else{
				pbcOperDaoImpl.insertPbcUserBaseInfo(personCreditInfo,logid);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:UserBaseInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcAssertDisposeDetailInfo(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getAssertDisposeDetailInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:DisposeDetailInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcCareerInfo(reportHeadInfo, queryPersonInfo,
					personCreditInfo.getPersonalCareerInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:CareerInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcCivilJudgmentInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getCivilJudgmentInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:CivilJudgmentInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcCompensationInfo(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getGuarantorCompensationDetailInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:CompensationInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcCreditCardInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getCreditCardInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:CreditCardInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcDeclareDetailInfo(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getLoanDeclareDetailInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:DeclareDetailInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcDissentDeclareDetailInfo(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getDissentDeclareDetailInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:DeclareDetailInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcEnforcementInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getEnforcementInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:EnforcementInfo|";
		}
		try {
			pbcOperDaoImpl
					.insertPbcGuaranteeDetailInfo(reportHeadInfo,
							queryPersonInfo,
							personCreditInfo.getGuaranteeDetailInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:GuaranteeDetailInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcLoanInfo(reportHeadInfo, queryPersonInfo,
					personCreditInfo.getLoanInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:PbcLoanInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcLowReLifeInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getLowReliefInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:LowReLifeInfo|";
		}
		try {
			pbcOperDaoImpl
					.insertPbcPunishmentInfo(reportHeadInfo, queryPersonInfo,
							personCreditInfo.getAdminPunishmentInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:PunishmentInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcQualificationInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getQualificationInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:QualificationInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcQuasiCreditInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getQuasiCreditInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:QuasiCreditInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcQueryRecordInfo(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getQueryRecordInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:QueryRecordInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcQueryRecordSummary(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getSummaryQueryRecordInfo(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:QueryRecordSummary|";
		}
		try {
			pbcOperDaoImpl.insertPbcResidentialInfos(reportHeadInfo,
					queryPersonInfo,
					personCreditInfo.getPersonalResidentialInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:ResidentialInfos|";
		}
		try {
			pbcOperDaoImpl.insertPbcRewardInfo(reportHeadInfo, queryPersonInfo,
					personCreditInfo.getAdministrativeRewardInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:PbcRewardInfo|";
		}
		try {
			pbcOperDaoImpl.insertPbcTaxesInfos(reportHeadInfo, queryPersonInfo,
					personCreditInfo.getTaxesInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:PbcTaxesInfos|";
		}
		try {
			pbcOperDaoImpl.insertPbcTelecomPaymentInfos(reportHeadInfo,
					queryPersonInfo, personCreditInfo.getTelecomPaymentInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:TelecomPaymentInfos|";
		}
		try {
			pbcOperDaoImpl.insertPbcVehicleTradeAndMortgageInfos(
					reportHeadInfo, queryPersonInfo,
					personCreditInfo.getVehicleTradeAndMortgageInfos(),logid);
		} catch (Exception ex) {
			ex.printStackTrace();
			result += "ERROR:VehicleTradeAndMortgageInfos|";
		}
		
		try {
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("source_id", urlId);
			param.put("parth", "");//urlId.substring(urlId.lastIndexOf("/"))
			param.put("analysis_result", "".equals(result)?"SUCCESS":result);
			pbcOperDaoImpl.updateAnalysisLog(
					reportHeadInfo, param);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
