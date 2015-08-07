package com.ztx.credit.report.model;

/**
 * 连续24个月的准贷记卡逾期信息
 * 
 * @author xucy
 *
 */
public class QuasiCreditOverdueInfo {
	private String overDraftMonth;
	private String overDraftMonthCount;
	private String overDraftAmount;

	public String getOverDraftMonth() {
		return overDraftMonth;
	}

	public void setOverDraftMonth(String overDraftMonth) {
		this.overDraftMonth = overDraftMonth;
	}

	public String getOverDraftMonthCount() {
		return overDraftMonthCount;
	}

	public void setOverDraftMonthCount(String overDraftMonthCount) {
		this.overDraftMonthCount = overDraftMonthCount;
	}

	public String getOverDraftAmount() {
		return overDraftAmount;
	}

	public void setOverDraftAmount(String overDraftAmount) {
		this.overDraftAmount = overDraftAmount;
	}

	@Override
	public String toString() {
		return "QuasiCreditOverdueInfo [overDraftMonth=" + overDraftMonth
				+ ", overDraftMonthCount=" + overDraftMonthCount
				+ ", overDraftAmount=" + overDraftAmount + "]";
	}

}
