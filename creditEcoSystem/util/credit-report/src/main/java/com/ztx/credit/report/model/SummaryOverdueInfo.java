package com.ztx.credit.report.model;

/**
 * 逾期（透支）信息汇总
 * @author xucy
 *
 */
public class SummaryOverdueInfo {

	private LoanOverDueInfo loanOverDueInfo;
	private CreditCardOverdue creditCardOverdue;
	private QuasiCreditOverdraftAbove60Days quasiCreditOverdraftAbove60Days;

	public LoanOverDueInfo getLoanOverDueInfo() {
		return loanOverDueInfo;
	}

	public void setLoanOverDueInfo(LoanOverDueInfo loanOverDueInfo) {
		this.loanOverDueInfo = loanOverDueInfo;
	}

	public CreditCardOverdue getCreditCardOverdue() {
		return creditCardOverdue;
	}

	public void setCreditCardOverdue(CreditCardOverdue creditCardOverdue) {
		this.creditCardOverdue = creditCardOverdue;
	}

	public QuasiCreditOverdraftAbove60Days getQuasiCreditOverdraftAbove60Days() {
		return quasiCreditOverdraftAbove60Days;
	}

	public void setQuasiCreditOverdraftAbove60Days(
			QuasiCreditOverdraftAbove60Days quasiCreditOverdraftAbove60Days) {
		this.quasiCreditOverdraftAbove60Days = quasiCreditOverdraftAbove60Days;
	}

	@Override
	public String toString() {
		return "SummaryOverdueInfo [loanOverDueInfo=" + loanOverDueInfo
				+ ", creditCardOverdue=" + creditCardOverdue
				+ ", quasiCreditOverdraftAbove60Days="
				+ quasiCreditOverdraftAbove60Days + "]";
	}

}
