package com.ztx.credit.report.model;

/**
 * 中征信评分
 * 
 * @author xucy
 *
 */
public class BankCreditInfo {
	private String bankCreditGrade;
	private String bankCreditMonth;

	public String getBankCreditGrade() {
		return bankCreditGrade;
	}

	public void setBankCreditGrade(String bankCreditGrade) {
		this.bankCreditGrade = bankCreditGrade;
	}

	public String getBankCreditMonth() {
		return bankCreditMonth;
	}

	public void setBankCreditMonth(String bankCreditMonth) {
		this.bankCreditMonth = bankCreditMonth;
	}

	@Override
	public String toString() {
		return "BankCreditInfo [bankCreditGrade=" + bankCreditGrade
				+ ", bankCreditMonth=" + bankCreditMonth + "]";
	}

}
