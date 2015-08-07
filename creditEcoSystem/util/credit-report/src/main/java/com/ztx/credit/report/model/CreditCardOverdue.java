package com.ztx.credit.report.model;

/**
 * 贷记卡逾期
 * 
 * @author xucy
 *
 */
public class CreditCardOverdue {

	private String accountCount;
	private String monthCount;
	private String highestMonthlyTotalAmount;
	private String longestOverDueMonthCount;
	public String getAccountCount() {
		return accountCount;
	}
	public void setAccountCount(String accountCount) {
		this.accountCount = accountCount;
	}
	public String getMonthCount() {
		return monthCount;
	}
	public void setMonthCount(String monthCount) {
		this.monthCount = monthCount;
	}
	public String getHighestMonthlyTotalAmount() {
		return highestMonthlyTotalAmount == null ?"":highestMonthlyTotalAmount;
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
		return "CreditCardOverdue [accountCount=" + accountCount
				+ ", monthCount=" + monthCount + ", highestMonthlyTotalAmount="
				+ highestMonthlyTotalAmount + ", longestOverDueMonthCount="
				+ longestOverDueMonthCount + "]";
	}
	
}
