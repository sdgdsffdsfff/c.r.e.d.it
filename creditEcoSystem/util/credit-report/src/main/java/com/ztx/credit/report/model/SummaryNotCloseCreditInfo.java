package com.ztx.credit.report.model;

/**
 * 未销户贷记卡信息汇总
 * 
 * @author xucy
 *
 */
public class SummaryNotCloseCreditInfo {
	private String cardOfferLegalCounts;
	private String cardIssuerCount;
	private String accountCount;
	private String creditTotalLine;
	private String highestCreditLine;
	private String lowestCreditLine;
	private String usedLine;
	private String last6MonthsAvgUsedLine;

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

	public String getCreditTotalLine() {
		return creditTotalLine == null ? "" : creditTotalLine;
	}

	public void setCreditTotalLine(String creditTotalLine) {
		this.creditTotalLine = creditTotalLine;
	}

	public String getHighestCreditLine() {
		return highestCreditLine == null ? "":highestCreditLine;
	}

	public void setHighestCreditLine(String highestCreditLine) {
		this.highestCreditLine = highestCreditLine;
	}

	public String getLowestCreditLine() {
		return lowestCreditLine == null?"":lowestCreditLine;
	}

	public void setLowestCreditLine(String lowestCreditLine) {
		this.lowestCreditLine = lowestCreditLine;
	}

	public String getUsedLine() {
		return usedLine == null ? "":usedLine;
	}

	public void setUsedLine(String usedLine) {
		this.usedLine = usedLine;
	}

	public String getLast6MonthsAvgUsedLine() {
		return last6MonthsAvgUsedLine == null ? "":last6MonthsAvgUsedLine;
	}

	public void setLast6MonthsAvgUsedLine(String last6MonthsAvgUsedLine) {
		this.last6MonthsAvgUsedLine = last6MonthsAvgUsedLine;
	}

	@Override
	public String toString() {
		return "SummaryNotCloseCreditInfo [cardOfferLegalCounts="
				+ cardOfferLegalCounts + ", cardIssuerCount=" + cardIssuerCount
				+ ", accountCount=" + accountCount + ", creditTotalLine="
				+ creditTotalLine + ", highestCreditLine=" + highestCreditLine
				+ ", lowestCreditLine=" + lowestCreditLine + ", usedLine="
				+ usedLine + ", last6MonthsAvgUsedLine="
				+ last6MonthsAvgUsedLine + "]";
	}

}
