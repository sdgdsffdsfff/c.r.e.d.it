package com.ztx.credit.report.model;

/**
 * 未销户准贷记卡信息汇总
 * @author xucy
 *
 */
public class SummaryQuasiCreditInfo {
	private String cardOfferLegalCounts;
	private String cardIssuerCount;
	private String accountCount;
	private String creditTotalAmount;
	private String highestCreditAmount;
	private String lowestCreditAmount;
	private String overDraftBalance;
	private String last6MonthsAvgOverDraftBalance;
	public String getCardOfferLegalCounts() {
		return cardOfferLegalCounts;
	}
	public void setCardOfferLegalCounts(String cardOfferLegalCounts) {
		this.cardOfferLegalCounts = cardOfferLegalCounts;
	}
	public String getCardIssuerCount() {
		return cardIssuerCount;
	}
	public void setCardIssuerCount(String cardIssuerCount) {
		this.cardIssuerCount = cardIssuerCount;
	}
	public String getAccountCount() {
		return accountCount;
	}
	public void setAccountCount(String accountCount) {
		this.accountCount = accountCount;
	}
	public String getCreditTotalAmount() {
		return creditTotalAmount;
	}
	public void setCreditTotalAmount(String creditTotalAmount) {
		this.creditTotalAmount = creditTotalAmount;
	}
	public String getHighestCreditAmount() {
		return highestCreditAmount;
	}
	public void setHighestCreditAmount(String highestCreditAmount) {
		this.highestCreditAmount = highestCreditAmount;
	}
	public String getLowestCreditAmount() {
		return lowestCreditAmount;
	}
	public void setLowestCreditAmount(String lowestCreditAmount) {
		this.lowestCreditAmount = lowestCreditAmount;
	}
	public String getOverDraftBalance() {
		return overDraftBalance;
	}
	public void setOverDraftBalance(String overDraftBalance) {
		this.overDraftBalance = overDraftBalance;
	}
	public String getLast6MonthsAvgOverDraftBalance() {
		return last6MonthsAvgOverDraftBalance;
	}
	public void setLast6MonthsAvgOverDraftBalance(
			String last6MonthsAvgOverDraftBalance) {
		this.last6MonthsAvgOverDraftBalance = last6MonthsAvgOverDraftBalance;
	}
	@Override
	public String toString() {
		return "SummaryQuasiCreditInfo [cardOfferLegalCounts="
				+ cardOfferLegalCounts + ", cardIssuerCount=" + cardIssuerCount
				+ ", accountCount=" + accountCount + ", creditTotalAmount="
				+ creditTotalAmount + ", highestCreditAmount="
				+ highestCreditAmount + ", lowestCreditAmount="
				+ lowestCreditAmount + ", overDraftBalance=" + overDraftBalance
				+ ", last6MonthsAvgOverDraftBalance="
				+ last6MonthsAvgOverDraftBalance + "]";
	}
	
	
}
