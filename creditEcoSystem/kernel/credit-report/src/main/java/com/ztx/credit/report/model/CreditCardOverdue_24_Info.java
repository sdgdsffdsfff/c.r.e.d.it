package com.ztx.credit.report.model;

/**
 * 连续24个月贷记卡逾期信息
 * 
 * @author xucy
 *
 */
public class CreditCardOverdue_24_Info {
	private String overdueMonth;
	private String overdueMonthCount;
	private String overdueAmount;
	private String startMonthSpecial;
	private String endMonthSpecial;
	private String overdueMonthSpecial;
	private String overdueMonthCountSpecial;
	private String overDueAmountSpecial;

	public String getOverdueMonth() {
		return overdueMonth;
	}

	public void setOverdueMonth(String overdueMonth) {
		this.overdueMonth = overdueMonth;
	}

	public String getOverdueMonthCount() {
		return overdueMonthCount;
	}

	public void setOverdueMonthCount(String overdueMonthCount) {
		this.overdueMonthCount = overdueMonthCount;
	}

	public String getOverdueAmount() {
		return overdueAmount;
	}

	public void setOverdueAmount(String overdueAmount) {
		this.overdueAmount = overdueAmount;
	}

	public String getStartMonthSpecial() {
		return startMonthSpecial;
	}

	public void setStartMonthSpecial(String startMonthSpecial) {
		this.startMonthSpecial = startMonthSpecial;
	}

	public String getEndMonthSpecial() {
		return endMonthSpecial;
	}

	public void setEndMonthSpecial(String endMonthSpecial) {
		this.endMonthSpecial = endMonthSpecial;
	}

	public String getOverdueMonthSpecial() {
		return overdueMonthSpecial;
	}

	public void setOverdueMonthSpecial(String overdueMonthSpecial) {
		this.overdueMonthSpecial = overdueMonthSpecial;
	}

	public String getOverdueMonthCountSpecial() {
		return overdueMonthCountSpecial;
	}

	public void setOverdueMonthCountSpecial(String overdueMonthCountSpecial) {
		this.overdueMonthCountSpecial = overdueMonthCountSpecial;
	}

	public String getOverDueAmountSpecial() {
		return overDueAmountSpecial;
	}

	public void setOverDueAmountSpecial(String overDueAmountSpecial) {
		this.overDueAmountSpecial = overDueAmountSpecial;
	}

	@Override
	public String toString() {
		return "CreditCardOverdue_24_Info [overdueMonth=" + overdueMonth
				+ ", overdueMonthCount=" + overdueMonthCount
				+ ", overdueAmount=" + overdueAmount + ", startMonthSpecial="
				+ startMonthSpecial + ", endMonthSpecial=" + endMonthSpecial
				+ ", overdueMonthSpecial=" + overdueMonthSpecial
				+ ", overdueMonthCountSpecial=" + overdueMonthCountSpecial
				+ ", overDueAmountSpecial=" + overDueAmountSpecial + "]";
	}

}
