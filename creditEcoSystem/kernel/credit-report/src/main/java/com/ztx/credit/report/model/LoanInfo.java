package com.ztx.credit.report.model;

import java.util.List;

/**
 * (三)贷款
 * @author xucy
 *
 */
public class LoanInfo {
	private String totalDescription;
	private String repaymentRecord_24;
	private String repaymentRecord_24Title;
	private LoanDetailInfo loanDetailInfo;
	private String loanOverdue_24_InfoTitle;
	private List<LoanOverdue_24_Info> loanOverdue_24_Infos;
	private String specialTradeType;
	private String occurDate;
	private String changedMonthCount;
	private String occurAmount;
	private String overdueRemark;
	private String loanInstitutionDeclare;
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
	public LoanDetailInfo getLoanDetailInfo() {
		return loanDetailInfo;
	}
	public void setLoanDetailInfo(LoanDetailInfo loanDetailInfo) {
		this.loanDetailInfo = loanDetailInfo;
	}
	public String getLoanOverdue_24_InfoTitle() {
		return loanOverdue_24_InfoTitle;
	}
	public void setLoanOverdue_24_InfoTitle(String loanOverdue_24_InfoTitle) {
		this.loanOverdue_24_InfoTitle = loanOverdue_24_InfoTitle;
	}
	public List<LoanOverdue_24_Info> getLoanOverdue_24_Infos() {
		return loanOverdue_24_Infos;
	}
	public void setLoanOverdue_24_Infos(
			List<LoanOverdue_24_Info> loanOverdue_24_Infos) {
		this.loanOverdue_24_Infos = loanOverdue_24_Infos;
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
	public String getLoanInstitutionDeclare() {
		return loanInstitutionDeclare;
	}
	public void setLoanInstitutionDeclare(String loanInstitutionDeclare) {
		this.loanInstitutionDeclare = loanInstitutionDeclare;
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
		return "LoanInfo [totalDescription=" + totalDescription
				+ ", repaymentRecord_24=" + repaymentRecord_24
				+ ", repaymentRecord_24Title=" + repaymentRecord_24Title
				+ ", loanDetailInfo=" + loanDetailInfo
				+ ", loanOverdue_24_InfoTitle=" + loanOverdue_24_InfoTitle
				+ ", loanOverdue_24_Infos=" + loanOverdue_24_Infos
				+ ", specialTradeType=" + specialTradeType + ", occurDate="
				+ occurDate + ", changedMonthCount=" + changedMonthCount
				+ ", occurAmount=" + occurAmount + ", overdueRemark="
				+ overdueRemark + ", loanInstitutionDeclare="
				+ loanInstitutionDeclare + ", declareDate_1=" + declareDate_1
				+ ", loanerDeclare=" + loanerDeclare + ", declareDate_2="
				+ declareDate_2 + ", dissentMark=" + dissentMark
				+ ", declareDate_3=" + declareDate_3 + "]";
	}
	
}
