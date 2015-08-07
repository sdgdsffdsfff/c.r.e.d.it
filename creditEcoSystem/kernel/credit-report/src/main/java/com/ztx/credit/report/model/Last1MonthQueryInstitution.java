package com.ztx.credit.report.model;

/**
 * 最近1个月内的查询机构数
 * 
 * @author xucy
 *
 */
public class Last1MonthQueryInstitution {
	private String loanApprovalCount;
	private String creditCardApprovalCount;

	public String getLoanApprovalCount() {
		return loanApprovalCount;
	}

	public void setLoanApprovalCount(String loanApprovalCount) {
		this.loanApprovalCount = loanApprovalCount;
	}

	public String getCreditCardApprovalCount() {
		return creditCardApprovalCount;
	}

	public void setCreditCardApprovalCount(String creditCardApprovalCount) {
		this.creditCardApprovalCount = creditCardApprovalCount;
	}

	@Override
	public String toString() {
		return "Last1MonthQueryInstitution [loanApprovalCount="
				+ loanApprovalCount + ", creditCardApprovalCount="
				+ creditCardApprovalCount + "]";
	}

}
