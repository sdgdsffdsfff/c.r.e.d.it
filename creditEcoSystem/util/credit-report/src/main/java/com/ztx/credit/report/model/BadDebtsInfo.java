package com.ztx.credit.report.model;

/**
 * 呆账信息汇总
 * @author xucy
 *
 */
public class BadDebtsInfo {
	private String totalCount;
	private String totalBalance;

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalBalance() {
		return totalBalance == null ? "" :totalBalance;
	}

	public void setTotalBalance(String totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "BadDebtsInfo [totalCount=" + totalCount + ", totalBalance="
				+ totalBalance + "]";
	}

}
