package com.ztx.credit.report.model;

/**
 * 资产处置信息
 * 
 * @author xucy
 *
 */
public class AssertDisposeDetailInfo {
	private String serial;
	private String assetManagementCompany;
	private String debtReceivedDate;
	private String receivedCreditAmount;
	private String lastRepaymentDate;
	private String balance;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getAssetManagementCompany() {
		return assetManagementCompany;
	}

	public void setAssetManagementCompany(String assetManagementCompany) {
		this.assetManagementCompany = assetManagementCompany;
	}

	public String getDebtReceivedDate() {
		return debtReceivedDate;
	}

	public void setDebtReceivedDate(String debtReceivedDate) {
		this.debtReceivedDate = debtReceivedDate;
	}

	public String getReceivedCreditAmount() {
		return receivedCreditAmount;
	}

	public void setReceivedCreditAmount(String receivedCreditAmount) {
		this.receivedCreditAmount = receivedCreditAmount;
	}

	public String getLastRepaymentDate() {
		return lastRepaymentDate;
	}

	public void setLastRepaymentDate(String lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "AssertDisposeDetailInfo [serial=" + serial
				+ ", assetManagementCompany=" + assetManagementCompany
				+ ", debtReceivedDate=" + debtReceivedDate
				+ ", receivedCreditAmount=" + receivedCreditAmount
				+ ", lastRepaymentDate=" + lastRepaymentDate + ", balance="
				+ balance + "]";
	}

}
