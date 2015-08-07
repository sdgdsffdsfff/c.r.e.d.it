package com.ztx.credit.report.model;

/**
 * 信用提示
 * 
 * @author xucy
 *
 */
public class SummaryCreditInfo {
	private String houseLoanCount = "0";
	private String otherLoanCount  = "0";
	private String firstLoanOfferMonth  = "0";
	private String debitAccountCount  = "0";
	private String firstDebitOfferMonth  = "0";
	private String quasiCreditAccountCount  = "0";
	private String firstQuasiDebitOfferMonth  = "0";
	private String declareCount  = "0";
	private String dissentMarkCount  = "0";

	public String getHouseLoanCount() {
		return houseLoanCount;
	}

	public void setHouseLoanCount(String houseLoanCount) {
		this.houseLoanCount = houseLoanCount;
	}

	public String getOtherLoanCount() {
		return otherLoanCount;
	}

	public void setOtherLoanCount(String otherLoanCount) {
		this.otherLoanCount = otherLoanCount;
	}

	public String getFirstLoanOfferMonth() {
		return firstLoanOfferMonth;
	}

	public void setFirstLoanOfferMonth(String firstLoanOfferMonth) {
		this.firstLoanOfferMonth = firstLoanOfferMonth;
	}

	public String getDebitAccountCount() {
		return debitAccountCount;
	}

	public void setDebitAccountCount(String debitAccountCount) {
		this.debitAccountCount = debitAccountCount;
	}

	public String getFirstDebitOfferMonth() {
		return firstDebitOfferMonth;
	}

	public void setFirstDebitOfferMonth(String firstDebitOfferMonth) {
		this.firstDebitOfferMonth = firstDebitOfferMonth;
	}

	public String getQuasiCreditAccountCount() {
		return quasiCreditAccountCount;
	}

	public void setQuasiCreditAccountCount(String quasiCreditAccountCount) {
		this.quasiCreditAccountCount = quasiCreditAccountCount;
	}

	public String getFirstQuasiDebitOfferMonth() {
		return firstQuasiDebitOfferMonth;
	}

	public void setFirstQuasiDebitOfferMonth(String firstQuasiDebitOfferMonth) {
		this.firstQuasiDebitOfferMonth = firstQuasiDebitOfferMonth;
	}

	public String getDeclareCount() {
		return declareCount;
	}

	public void setDeclareCount(String declareCount) {
		this.declareCount = declareCount;
	}

	public String getDissentMarkCount() {
		return dissentMarkCount;
	}

	public void setDissentMarkCount(String dissentMarkCount) {
		this.dissentMarkCount = dissentMarkCount;
	}

	@Override
	public String toString() {
		return "SummaryCreditInfo [houseLoanCount=" + houseLoanCount
				+ ", otherLoanCount=" + otherLoanCount
				+ ", firstLoanOfferMonth=" + firstLoanOfferMonth
				+ ", debitAccountCount=" + debitAccountCount
				+ ", firstDebitOfferMonth=" + firstDebitOfferMonth
				+ ", quasiCreditAccountCount=" + quasiCreditAccountCount
				+ ", firstQuasiDebitOfferMonth=" + firstQuasiDebitOfferMonth
				+ ", declareCount=" + declareCount + ", dissentMarkCount="
				+ dissentMarkCount + "]";
	}

}
