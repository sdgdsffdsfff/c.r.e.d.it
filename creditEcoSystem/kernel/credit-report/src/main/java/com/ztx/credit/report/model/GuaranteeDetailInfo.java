package com.ztx.credit.report.model;

/**
 * 担保信息
 * @author xucy
 *
 */
public class GuaranteeDetailInfo {
	private String serial;
	private String loanIssuer;
	private String loanContractAmount;
	private String 	issueDate;
	private String dueDate ;
	private String guaranteeAmount;
	private String principalBalance;
	private String fiveClassification;
	private String settlementDate;
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getLoanIssuer() {
		return loanIssuer;
	}
	public void setLoanIssuer(String loanIssuer) {
		this.loanIssuer = loanIssuer;
	}
	public String getLoanContractAmount() {
		return loanContractAmount;
	}
	public void setLoanContractAmount(String loanContractAmount) {
		this.loanContractAmount = loanContractAmount;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getGuaranteeAmount() {
		return guaranteeAmount;
	}
	public void setGuaranteeAmount(String guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}
	public String getPrincipalBalance() {
		return principalBalance;
	}
	public void setPrincipalBalance(String principalBalance) {
		this.principalBalance = principalBalance;
	}
	public String getFiveClassification() {
		return fiveClassification;
	}
	public void setFiveClassification(String fiveClassification) {
		this.fiveClassification = fiveClassification;
	}
	public String getSettlementDate() {
		return settlementDate;
	}
	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}
	@Override
	public String toString() {
		return "GuaranteeDetailInfo [serial=" + serial + ", loanIssuer="
				+ loanIssuer + ", loanContractAmount=" + loanContractAmount
				+ ", issueDate=" + issueDate + ", dueDate=" + dueDate
				+ ", guaranteeAmount=" + guaranteeAmount
				+ ", principalBalance=" + principalBalance
				+ ", fiveClassification=" + fiveClassification
				+ ", settlementDate=" + settlementDate + "]";
	}
	
}
