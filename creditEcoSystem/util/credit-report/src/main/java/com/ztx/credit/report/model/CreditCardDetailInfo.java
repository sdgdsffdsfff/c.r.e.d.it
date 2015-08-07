package com.ztx.credit.report.model;

/**
 * 贷记卡字段信息
 * 
 * @author xucy
 *
 */
public class CreditCardDetailInfo {
	private String cardIssuer;
	private String serviceNo;
	private String currency;
	private String issueDate;
	private String creditLine;
	private String guaranteeWay;
	private String status;
	private String stateDeadline;
	private String sharedLine;
	private String usedLine;
	private String last6MonthsAvgUsedLine;
	private String maxUsedLine;
	private String scheduledRepayment;
	private String billDate;
	private String realRepayment;
	private String lastRepaymentDate;

	private String overDuePeriodCount;
	private String overDueAmount;

	public String getOverDuePeriodCount() {
		return overDuePeriodCount;
	}

	public void setOverDuePeriodCount(String overDuePeriodCount) {
		this.overDuePeriodCount = overDuePeriodCount;
	}

	public String getOverDueAmount() {
		return overDueAmount == null? "":overDueAmount;
	}

	public void setOverDueAmount(String overDueAmount) {
		this.overDueAmount = overDueAmount;
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

	public String getSharedLine() {
		return sharedLine;
	}

	public void setSharedLine(String sharedLine) {
		this.sharedLine = sharedLine;
	}

	public String getUsedLine() {
		return usedLine;
	}

	public void setUsedLine(String usedLine) {
		this.usedLine = usedLine;
	}

	public String getLast6MonthsAvgUsedLine() {
		return last6MonthsAvgUsedLine;
	}

	public void setLast6MonthsAvgUsedLine(String last6MonthsAvgUsedLine) {
		this.last6MonthsAvgUsedLine = last6MonthsAvgUsedLine;
	}

	public String getMaxUsedLine() {
		return maxUsedLine;
	}

	public void setMaxUsedLine(String maxUsedLine) {
		this.maxUsedLine = maxUsedLine;
	}

	public String getScheduledRepayment() {
		return scheduledRepayment;
	}

	public void setScheduledRepayment(String scheduledRepayment) {
		this.scheduledRepayment = scheduledRepayment;
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

	@Override
	public String toString() {
		return "CreditCardDetailInfo [cardIssuer=" + cardIssuer
				+ ", serviceNo=" + serviceNo + ", currency=" + currency
				+ ", issueDate=" + issueDate + ", creditLine=" + creditLine
				+ ", guaranteeWay=" + guaranteeWay + ", status=" + status
				+ ", stateDeadline=" + stateDeadline + ", sharedLine="
				+ sharedLine + ", usedLine=" + usedLine
				+ ", last6MonthsAvgUsedLine=" + last6MonthsAvgUsedLine
				+ ", maxUsedLine=" + maxUsedLine + ", scheduledRepayment="
				+ scheduledRepayment + ", billDate=" + billDate
				+ ", realRepayment=" + realRepayment + ", lastRepaymentDate="
				+ lastRepaymentDate + ", overDuePeriodCount="
				+ overDuePeriodCount + ", overDueAmount=" + overDueAmount + "]";
	}

}
