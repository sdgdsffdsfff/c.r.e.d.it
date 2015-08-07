package com.ztx.credit.report.model;

/**
 * 资产处置信息汇总
 * @author xucy
 *
 */
public class AssertDisposeInfo {
	private String totalCount;
	private String totalBalance;

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalBalance() {
		return totalBalance;
	}

	public void setTotalBalance(String totalBalance) {
		this.totalBalance = totalBalance;
	}

	@Override
	public String toString() {
		return "AssertDisposeInfo [totalCount=" + totalCount
				+ ", totalBalance=" + totalBalance + "]";
	}

}
