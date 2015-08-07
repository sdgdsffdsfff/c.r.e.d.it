package com.ztx.credit.report.model;

/**
 * 贷款逾期
 * @author xucy
 *
 */
public class LoanOverDueInfo {
	private String count;
	private String monthCount;
	private String highestMonthlyTotalAmount;
	private String longestOverDueMonthCount;
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(String monthCount) {
		this.monthCount = monthCount;
	}
	public String getHighestMonthlyTotalAmount() {
		return highestMonthlyTotalAmount;
	}
	public void setHighestMonthlyTotalAmount(String highestMonthlyTotalAmount) {
		this.highestMonthlyTotalAmount = highestMonthlyTotalAmount;
	}
	public String getLongestOverDueMonthCount() {
		return longestOverDueMonthCount;
	}
	public void setLongestOverDueMonthCount(String longestOverDueMonthCount) {
		this.longestOverDueMonthCount = longestOverDueMonthCount;
	}
	@Override
	public String toString() {
		return "LoanOverDueInfo [count=" + count + ", monthCount=" + monthCount
				+ ", highestMonthlyTotalAmount=" + highestMonthlyTotalAmount
				+ ", longestOverDueMonthCount=" + longestOverDueMonthCount
				+ "]";
	}
	

}
