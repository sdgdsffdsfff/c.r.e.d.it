package com.ztx.credit.report.model;

/**
 * 准贷记卡字段信息
 * 
 * @author xucy
 *
 */
public class QuasiCreditDetailInfo {
	private String sharedLine;
	private String overDraftBalance;
	private String last6MonthsAvgOverDraftBalance;
	private String maxOverDraftBalance;
	private String billDate;
	private String realRepayment;
	private String lastRepaymentDate;
	private String overdue180DaysAboveBalance;

	private String cardIssuer;
	private String serviceNo;
	private String currency;
	private String issueDate;
	private String creditLine;
	private String guaranteeWay;
	private String status;
	private String stateDeadline;

	public String getSharedLine() {
		return sharedLine;
	}

	public void setSharedLine(String sharedLine) {
		this.sharedLine = sharedLine;
	}

	public String getOverDraftBalance() {
		return overDraftBalance;
	}

	public void setOverDraftBalance(String overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}

	public String getLast6MonthsAvgOverDraftBalance() {
		return last6MonthsAvgOverDraftBalance;
	}

	public void setLast6MonthsAvgOverDraftBalance(
			String last6MonthsAvgOverDraftBalance) {
		this.last6MonthsAvgOverDraftBalance = last6MonthsAvgOverDraftBalance;
	}

	public String getMaxOverDraftBalance() {
		return maxOverDraftBalance;
	}

	public void setMaxOverDraftBalance(String maxOverDraftBalance) {
		this.maxOverDraftBalance = maxOverDraftBalance;
	}

	public String getBillDate() {
		return billDate;
	}

	public void setBillDate(String billDate) {
		this.billDate = billDate;
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

	public String getOverdue180DaysAboveBalance() {
		return overdue180DaysAboveBalance;
	}

	public void setOverdue180DaysAboveBalance(String overdue180DaysAboveBalance) {
		this.overdue180DaysAboveBalance = overdue180DaysAboveBalance;
	}

	public String getCardIssuer() {
		return cardIssuer;
	}

	public void setCardIssuer(String cardIssuer) {
		this.cardIssuer = cardIssuer;
	}

	public String getServiceNo() {
		return serviceNo;
	}

	public void setServiceNo(String serviceNo) {
		this.serviceNo = serviceNo;
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

	public String getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(String creditLine) {
		this.creditLine = creditLine;
	}

	public String getGuaranteeWay() {
		return guaranteeWay;
	}

	public void setGuaranteeWay(String guaranteeWay) {
		this.guaranteeWay = guaranteeWay;
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

	@Override
	public String toString() {
		return "QuasiCreditDetailInfo [sharedLine=" + sharedLine
				+ ", overDraftBalance=" + overDraftBalance
				+ ", last6MonthsAvgOverDraftBalance="
				+ last6MonthsAvgOverDraftBalance + ", maxOverDraftBalance="
				+ maxOverDraftBalance + ", billDate=" + billDate
				+ ", realRepayment=" + realRepayment + ", lastRepaymentDate="
				+ lastRepaymentDate + ", overdue180DaysAboveBalance="
				+ overdue180DaysAboveBalance + ", cardIssuer=" + cardIssuer
				+ ", serviceNo=" + serviceNo + ", currency=" + currency
				+ ", issueDate=" + issueDate + ", creditLine=" + creditLine
				+ ", guaranteeWay=" + guaranteeWay + ", status=" + status
				+ ", stateDeadline=" + stateDeadline + "]";
	}

}
