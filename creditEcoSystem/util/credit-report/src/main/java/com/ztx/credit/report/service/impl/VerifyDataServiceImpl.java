package com.ztx.credit.report.service.impl;

import com.ztx.credit.report.model.PersonCreditInfo;
import com.ztx.credit.report.model.PersonalInfo;
import com.ztx.credit.report.model.QueryPersonInfo;
import com.ztx.credit.report.model.ReportHeadInfo;
import com.ztx.credit.report.service.IVerifyDataService;

public class VerifyDataServiceImpl implements IVerifyDataService {

	@Override
	public String verifyPbc(PersonCreditInfo personCreditInfo, String urlId) {
		// TODO Auto-generated method stub
		/**
		 * 报告头、被查询者信息、身份信息 ----校验报告的完整性； 报告头：报告编号、查询请求时间、报告时间-----校验报告有效性；
		 * 被查询者信息：被查询者姓名、被查询者证件类型、被查询者证件号码---校验被查询者真实性； 1、住房贷款笔数+其他贷款笔数=贷
		 * 款模块明细数总和，当住房贷款笔数+其他贷款笔数=0 时，则不需要查询贷款模块信息；
		 * 2、贷记卡账户数=贷记卡模块中的明细数总和，当贷记卡账户数=0时，则不需要查询贷记卡模块信息； 3、准贷记卡账户数=准贷记卡模块中
		 * 明细数总和，当准贷记卡账户数=0时，则不需要查询准贷记卡模块信息； 4、汇总的未销户贷记卡账户数=明细中计算的未销户贷记卡数
		 * 5、汇总的未结清贷款笔数=明细中统计的未结清贷款笔数
		 ***/

		String resultInfo = "";

		// 报告头信息
		ReportHeadInfo rhi = personCreditInfo.getReportHeadInfo();
		// 被查询者信息 ----校验报告的完整性；
		QueryPersonInfo qpi = personCreditInfo.getQueryPersonInfo();
		// 身份信息
		PersonalInfo pi = personCreditInfo.getPersonalInfo();

		if (rhi.getReportNo().isEmpty()) {
			resultInfo += " || 报告编号缺失";
		}
		if (rhi.getReportTime().isEmpty()) {
			resultInfo += " || 报告生成时间缺失";
		}
		if (rhi.getReqTime().isEmpty()) {
			resultInfo += " || 报告请求时间缺失";
		}

		if (qpi.getName().isEmpty()) {
			resultInfo += " || 查询者姓名缺失";
		}
		if (qpi.getiDNumber().isEmpty()) {
			resultInfo += " || 查询者省份证缺失";
		}
		if (qpi.getIdType().isEmpty()) {
			resultInfo += " || 查询者证件类型缺失";
		}

		// 住房贷款笔数+其他贷款笔数=贷 款模块明细数总和，当住房贷款笔数+其他贷款笔数=0 时，则不需要查询贷款模块信息；
		try {
			if (Integer.parseInt(personCreditInfo.getSummaryCreditInfo()
					.getHouseLoanCount())
					+ Integer.parseInt(personCreditInfo.getSummaryCreditInfo()
							.getOtherLoanCount()) != 0) {

				int loanCount = Integer.parseInt(personCreditInfo
						.getSummaryCreditInfo().getHouseLoanCount())
						+ Integer.parseInt(personCreditInfo
								.getSummaryCreditInfo().getOtherLoanCount());
				if (loanCount != personCreditInfo.getLoanInfos().size()) {
					resultInfo += " || 款模块明细数总和不一致";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 2、贷记卡账户数=贷记卡模块中的明细数总和，当贷记卡账户数=0时，则不需要查询贷记卡模块信息；
		try {
			if (Integer.parseInt(personCreditInfo.getSummaryCreditInfo()
					.getDebitAccountCount()) != 0) {
				if (personCreditInfo.getCreditCardInfos().size() != Integer
						.parseInt(personCreditInfo.getSummaryCreditInfo()
								.getDebitAccountCount())) {
					resultInfo += " || 贷记卡账户数总和不一致";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 3、准贷记卡账户数=准贷记卡模块中 明细数总和，当准贷记卡账户数=0时，则不需要查询准贷记卡模块信息；
		try {
			if (Integer.parseInt(personCreditInfo.getSummaryCreditInfo()
					.getQuasiCreditAccountCount()) != 0) {
				if (personCreditInfo.getQuasiCreditInfos().size() != Integer
						.parseInt(personCreditInfo.getSummaryCreditInfo()
								.getQuasiCreditAccountCount())) {
					resultInfo += " || 准贷记卡账户数总和不一致";
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// 4、汇总的未销户贷记卡账户数=明细中计算的未销户贷记卡数
		// if(Integer.parseInt(
		// personCreditInfo.getSummaryNotCloseCreditInfo().getAccountCount()) !=
		// 0){
		//
		// }

		// 5、汇总的未结清贷款笔数=明细中统计的未结清贷款笔数
		// if(Integer.parseInt(personCreditInfo.getSummaryOutstandingInfo().getCount())
		// != 0){
		//
		// }

		return resultInfo;
	}

}
