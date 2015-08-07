package com.ztx.credit.report.model;
/**
 * 保证人代偿信息
 * @author xucy
 *
 */
public class GuarantorCompensationDetailInfo {
	private String serial;
	private String compensationInstitutionCount;
	private String lastCompensationDate;
	private String totalCompensationAmount;
	private String lastRepaymentDate;
	private String balance;
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getCompensationInstitutionCount() {
		return compensationInstitutionCount;
	}
	public void setCompensationInstitutionCount(String compensationInstitutionCount) {
		this.compensationInstitutionCount = compensationInstitutionCount;
	}
	public String getLastCompensationDate() {
		return lastCompensationDate;
	}
	public void setLastCompensationDate(String lastCompensationDate) {
		this.lastCompensationDate = lastCompensationDate;
	}
	public String getTotalCompensationAmount() {
		return totalCompensationAmount == null ? "":totalCompensationAmount;
	}
	public void setTotalCompensationAmount(String totalCompensationAmount) {
		this.totalCompensationAmount = totalCompensationAmount;
	}
	public String getLastRepaymentDate() {
		return lastRepaymentDate;
	}
	public void setLastRepaymentDate(String lastRepaymentDate) {
		this.lastRepaymentDate = lastRepaymentDate;
	}
	public String getBalance() {
		return balance == null ? "" : balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "GuarantorCompensationDetailInfo [serial=" + serial
				+ ", compensationInstitutionCount="
				+ compensationInstitutionCount + ", lastCompensationDate="
				+ lastCompensationDate + ", totalCompensationAmount="
				+ totalCompensationAmount + ", lastRepaymentDate="
				+ lastRepaymentDate + ", balance=" + balance + "]";
	}

}
