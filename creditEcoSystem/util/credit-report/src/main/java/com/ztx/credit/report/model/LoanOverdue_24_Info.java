package com.ztx.credit.report.model;

/**
 * 连续24个月的逾期记录
 * @author xucy
 *
 */
public class LoanOverdue_24_Info {
	private String overdueMonth;
	private String overdueMonthCount;
	private String overdueAmount;
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
		return overdueAmount == null ? "" : overdueAmount;
	}
	public void setOverdueAmount(String overdueAmount) {
		this.overdueAmount = overdueAmount;
	}
	@Override
	public String toString() {
		return "LoanOverdue_24_Info [overdueMonth=" + overdueMonth
				+ ", overdueMonthCount=" + overdueMonthCount
				+ ", overdueAmount=" + overdueAmount + "]";
	}
	

}
