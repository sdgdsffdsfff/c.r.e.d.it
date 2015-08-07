package com.ztx.credit.report.model;

/**
 * 贷款明细字段信息
 * 
 * @author xucy
 *
 */
public class LoanDetailInfo {
	private String loanInstitution;
	private String serviceNo;
	private String loanType;
	private String currency;
	private String issueDate;
	private String dueDate;
	private String contractTotalAmount;
	private String guaranteeWay;
	private String repaymentFrequency;
	private String repaymentPeriods;
	private String status;
	private String stateDeadline;
	private String stateEndedMarch;
	private String fiveClassification;
	private String principalBalance;
	private String remainRepaymentPeriodCount;
	private String scheduledRepayment;
	private String scheduledRepaymentDate;
	private String realRepayment;
	private String lastRepaymentDate;
	private String overDuePeriodCount;
	private String overDueAmount;
	private String overdue31_60DaysPrincipal;
	private String overdue61_90DaysPrincipal;
	private String overdue91_180DaysPrincipal;
	private String overdue180DaysAbovePrincipal;

	public String getLoanInstitution() {
		return loanInstitution;
	}

	public void setLoanInstitution(String loanInstitution) {
		this.loanInstitution = loanInstitution;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
	}

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getContractTotalAmount() {
		return contractTotalAmount;
	}

	public void setContractTotalAmount(String contractTotalAmount) {
		this.contractTotalAmount = contractTotalAmount;
	}

	public String getGuaranteeWay() {
		return guaranteeWay;
	}

	public void setGuaranteeWay(String guaranteeWay) {
		this.guaranteeWay = guaranteeWay;
	}

	public String getRepaymentFrequency() {
		return repaymentFrequency;
	}

	public void setRepaymentFrequency(String repaymentFrequency) {
		this.repaymentFrequency = repaymentFrequency;
	}

	public String getRepaymentPeriods() {
		return repaymentPeriods;
	}

	public void setRepaymentPeriods(String repaymentPeriods) {
		this.repaymentPeriods = repaymentPeriods;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStateDeadline() {
		return stateDeadline;
	}

	public void setStateDeadline(String stateDeadline) {
		this.stateDeadline = stateDeadline;
	}

	public String getStateEndedMarch() {
		return stateEndedMarch;
	}

	public void setStateEndedMarch(String stateEndedMarch) {
		this.stateEndedMarch = stateEndedMarch;
	}

	public String getFiveClassification() {
		return fiveClassification;
	}

	public void setFiveClassification(String fiveClassification) {
		this.fiveClassification = fiveClassification;
	}

	public String getPrincipalBalance() {
		return principalBalance;
	}

	public void setPrincipalBalance(String principalBalance) {
		this.principalBalance = principalBalance;
	}

	public String getRemainRepaymentPeriodCount() {
		return remainRepaymentPeriodCount;
	}

	public void setRemainRepaymentPeriodCount(String remainRepaymentPeriodCount) {
		this.remainRepaymentPeriodCount = remainRepaymentPeriodCount;
	}

	public String getScheduledRepayment() {
		return scheduledRepayment;
	}

	public void setScheduledRepayment(String scheduledRepayment) {
		this.scheduledRepayment = scheduledRepayment;
	}

	public String getScheduledRepaymentDate() {
		return scheduledRepaymentDate;
	}

	public void setScheduledRepaymentDate(String scheduledRepaymentDate) {
		this.scheduledRepaymentDate = scheduledRepaymentDate;
	}

	public String getRealRepayment() {
		return realRepayment;
	}

	public void setRealRepayment(String realRepayment) {
		this.realRepayment = realRepayment;
	}

	public String getLastRepaymentDate() {
		return lastRepaymentDate;
	}

	public void setLastRepaymentDate(String lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}

	public String getOverDuePeriodCount() {
		return overDuePeriodCount;
	}

	public void setOverDuePeriodCount(String overDuePeriodCount) {
		this.overDuePeriodCount = overDuePeriodCount;
	}

	public String getOverDueAmount() {
		return overDueAmount;
	}

	public void setOverDueAmount(String overDueAmount) {
		this.overDueAmount = overDueAmount;
	}

	public String getOverdue31_60DaysPrincipal() {
		return overdue31_60DaysPrincipal;
	}

	public void setOverdue31_60DaysPrincipal(String overdue31_60DaysPrincipal) {
		this.overdue31_60DaysPrincipal = overdue31_60DaysPrincipal;
	}

	public String getOverdue61_90DaysPrincipal() {
		return overdue61_90DaysPrincipal;
	}

	public void setOverdue61_90DaysPrincipal(String overdue61_90DaysPrincipal) {
		this.overdue61_90DaysPrincipal = overdue61_90DaysPrincipal;
	}

	public String getOverdue91_180DaysPrincipal() {
		return overdue91_180DaysPrincipal;
	}

	public void setOverdue91_180DaysPrincipal(String overdue91_180DaysPrincipal) {
		this.overdue91_180DaysPrincipal = overdue91_180DaysPrincipal;
	}

	public String getOverdue180DaysAbovePrincipal() {
		return overdue180DaysAbovePrincipal;
	}

	public void setOverdue180DaysAbovePrincipal(
			String overdue180DaysAbovePrincipal) {
		this.overdue180DaysAbovePrincipal = overdue180DaysAbovePrincipal;
	}

	@Override
	public String toString() {
		return "LoanDetailInfo [loanInstitution=" + loanInstitution
				+ ", serviceNo=" + serviceNo + ", loanType=" + loanType
				+ ", currency=" + currency + ", issueDate=" + issueDate
				+ ", dueDate=" + dueDate + ", contractTotalAmount="
				+ contractTotalAmount + ", guaranteeWay=" + guaranteeWay
				+ ", repaymentFrequency=" + repaymentFrequency
				+ ", repaymentPeriods=" + repaymentPeriods + ", status="
				+ status + ", stateDeadline=" + stateDeadline
				+ ", stateEndedMarch=" + stateEndedMarch
				+ ", fiveClassification=" + fiveClassification
				+ ", principalBalance=" + principalBalance
				+ ", remainRepaymentPeriodCount=" + remainRepaymentPeriodCount
				+ ", scheduledRepayment=" + scheduledRepayment
				+ ", scheduledRepaymentDate=" + scheduledRepaymentDate
				+ ", realRepayment=" + realRepayment + ", lastRepaymentDate="
				+ lastRepaymentDate + ", overDuePeriodCount="
				+ overDuePeriodCount + ", overDueAmount=" + overDueAmount
				+ ", overdue31_60DaysPrincipal=" + overdue31_60DaysPrincipal
				+ ", overdue61_90DaysPrincipal=" + overdue61_90DaysPrincipal
				+ ", overdue91_180DaysPrincipal=" + overdue91_180DaysPrincipal
				+ ", overdue180DaysAbovePrincipal="
				+ overdue180DaysAbovePrincipal + "]";
	}

}
