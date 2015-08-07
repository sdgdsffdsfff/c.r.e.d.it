package com.ztx.credit.report.model;

/**
 * 未结清贷款信息汇总
 * 
 * @author xucy
 *
 */
public class SummaryOutstandingInfo {
	private String loanLegalCount;
	private String loanInstitutionCount;
	private String count;
	private String contractTotalAmount;
	private String balance;
	private String last6MonthsAvgRepayment;

	public String getLoanLegalCount() {
		return loanLegalCount;
	}

	public void setLoanLegalCount(String loanLegalCount) {
		this.loanLegalCount = loanLegalCount;
	}

	public String getLoanInstitutionCount() {
		return loanInstitutionCount;
	}

	public void setLoanInstitutionCount(String loanInstitutionCount) {
		this.loanInstitutionCount = loanInstitutionCount;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getContractTotalAmount() {
		return contractTotalAmount;
	}

	public void setContractTotalAmount(String contractTotalAmount) {
		this.contractTotalAmount = contractTotalAmount;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getLast6MonthsAvgRepayment() {
		return last6MonthsAvgRepayment;
	}

	public void setLast6MonthsAvgRepayment(String last6MonthsAvgRepayment) {
		this.last6MonthsAvgRepayment = last6MonthsAvgRepayment;
	}

	@Override
	public String toString() {
		return "SummaryOutstandingInfo [loanLegalCount=" + loanLegalCount
				+ ", loanInstitutionCount=" + loanInstitutionCount + ", count="
				+ count + ", contractTotalAmount=" + contractTotalAmount
				+ ", balance=" + balance + ", last6MonthsAvgRepayment="
				+ last6MonthsAvgRepayment + "]";
	}

}
