package com.ztx.credit.report.model;

import java.util.List;

/**
 * （五）准贷记卡
 * 
 * @author xucy
 *
 */
public class QuasiCreditInfo {

	private String totalDescription;
	private QuasiCreditDetailInfo quasiCreditDetailInfo;
	private String repaymentRecord_24;
	private String repaymentRecord_24Title;
	private String creditOverdueInfosTitle;
	private List<QuasiCreditOverdueInfo> creditOverdueInfos;
	private String specialTradeType;
	private String occurDate;
	private String changedMonthCount;
	private String occurAmount;
	private String overdueRemark;
	private String cardIssuerDeclare;
	private String declareDate_1;
	private String loanerDeclare;
	private String declareDate_2;
	private String dissentMark;
	private String declareDate_3;

	
	
	public String getTotalDescription() {
		return totalDescription;
	}

	public void setTotalDescription(String totalDescription) {
		this.totalDescription = totalDescription;
	}

	public QuasiCreditDetailInfo getQuasiCreditDetailInfo() {
		return quasiCreditDetailInfo;
	}

	public void setQuasiCreditDetailInfo(
			QuasiCreditDetailInfo quasiCreditDetailInfo) {
		this.quasiCreditDetailInfo = quasiCreditDetailInfo;
	}

	public String getRepaymentRecord_24() {
		return repaymentRecord_24;
	}

	public void setRepaymentRecord_24(String repaymentRecord_24) {
		this.repaymentRecord_24 = repaymentRecord_24;
	}

	public String getRepaymentRecord_24Title() {
		return repaymentRecord_24Title;
	}

	public void setRepaymentRecord_24Title(String repaymentRecord_24Title) {
		this.repaymentRecord_24Title = repaymentRecord_24Title;
	}

	public String getCreditOverdueInfosTitle() {
		return creditOverdueInfosTitle;
	}

	public void setCreditOverdueInfosTitle(String creditOverdueInfosTitle) {
		this.creditOverdueInfosTitle = creditOverdueInfosTitle;
	}

	public List<QuasiCreditOverdueInfo> getCreditOverdueInfos() {
		return creditOverdueInfos;
	}

	public void setCreditOverdueInfos(
			List<QuasiCreditOverdueInfo> creditOverdueInfos) {
		this.creditOverdueInfos = creditOverdueInfos;
	}

	public String getSpecialTradeType() {
		return specialTradeType;
	}

	public void setSpecialTradeType(String specialTradeType) {
		this.specialTradeType = specialTradeType;
	}

	public String getOccurDate() {
		return occurDate;
	}

	public void setOccurDate(String occurDate) {
		this.occurDate = occurDate;
	}

	public String getChangedMonthCount() {
		return changedMonthCount;
	}

	public void setChangedMonthCount(String changedMonthCount) {
		this.changedMonthCount = changedMonthCount;
	}

	public String getOccurAmount() {
		return occurAmount;
	}

	public void setOccurAmount(String occurAmount) {
		this.occurAmount = occurAmount;
	}

	public String getOverdueRemark() {
		return overdueRemark;
	}

	public void setOverdueRemark(String overdueRemark) {
		this.overdueRemark = overdueRemark;
	}

	public String getCardIssuerDeclare() {
		return cardIssuerDeclare;
	}

	public void setCardIssuerDeclare(String cardIssuerDeclare) {
		this.cardIssuerDeclare = cardIssuerDeclare;
	}

	public String getDeclareDate_1() {
		return declareDate_1;
	}

	public void setDeclareDate_1(String declareDate_1) {
		this.declareDate_1 = declareDate_1;
	}

	public String getLoanerDeclare() {
		return loanerDeclare;
	}

	public void setLoanerDeclare(String loanerDeclare) {
		this.loanerDeclare = loanerDeclare;
	}

	public String getDeclareDate_2() {
		return declareDate_2;
	}

	public void setDeclareDate_2(String declareDate_2) {
		this.declareDate_2 = declareDate_2;
	}

	public String getDissentMark() {
		return dissentMark;
	}

	public void setDissentMark(String dissentMark) {
		this.dissentMark = dissentMark;
	}

	public String getDeclareDate_3() {
		return declareDate_3;
	}

	public void setDeclareDate_3(String declareDate_3) {
		this.declareDate_3 = declareDate_3;
	}

	@Override
	public String toString() {
		return "QuasiCreditInfo [totalDescription=" + totalDescription
				+ ", quasiCreditDetailInfo=" + quasiCreditDetailInfo
				+ ", repaymentRecord_24=" + repaymentRecord_24
				+ ", repaymentRecord_24Title=" + repaymentRecord_24Title
				+ ", creditOverdueInfosTitle=" + creditOverdueInfosTitle
				+ ", creditOverdueInfos=" + creditOverdueInfos
				+ ", specialTradeType=" + specialTradeType + ", occurDate="
				+ occurDate + ", changedMonthCount=" + changedMonthCount
				+ ", occurAmount=" + occurAmount + ", overdueRemark="
				+ overdueRemark + ", cardIssuerDeclare=" + cardIssuerDeclare
				+ ", declareDate_1=" + declareDate_1 + ", loanerDeclare="
				+ loanerDeclare + ", declareDate_2=" + declareDate_2
				+ ", dissentMark=" + dissentMark + ", declareDate_3="
				+ declareDate_3 + "]";
	}

}
