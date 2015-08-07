package com.ztx.credit.report.model;

/**
 * 对外担保信息汇总
 * 
 * @author xucy
 *
 */
public class SummaryGuaranteeInfo {
	private String guaranteeCount;
	private String guaranteeAmount;
	private String guaranteePrincipalBalance;

	public String getGuaranteeCount() {
		return guaranteeCount;
	}

	public void setGuaranteeCount(String guaranteeCount) {
		this.guaranteeCount = guaranteeCount;
	}

	public String getGuaranteeAmount() {
		return guaranteeAmount == null ? "" : guaranteeAmount;
	}

	public void setGuaranteeAmount(String guaranteeAmount) {
		this.guaranteeAmount = guaranteeAmount;
	}

	public String getGuaranteePrincipalBalance() {
		return guaranteePrincipalBalance == null ? "" :guaranteePrincipalBalance;
	}

	public void setGuaranteePrincipalBalance(String guaranteePrincipalBalance) {
		this.guaranteePrincipalBalance = guaranteePrincipalBalance;
	}

	@Override
	public String toString() {
		return "SummaryGuaranteeInfo [guaranteeCount=" + guaranteeCount
				+ ", guaranteeAmount=" + guaranteeAmount
				+ ", guaranteePrincipalBalance=" + guaranteePrincipalBalance
				+ "]";
	}

}
