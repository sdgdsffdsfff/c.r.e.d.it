package com.ztx.credit.report.model;

/**
 * 养老保险金缴存记录
 * 
 * @author xucy
 *
 */
public class PensionPayInfo {
	private String location;
	private String startDate;
	private String payMonthCount;
	private String startMonth;
	private String status;
	private String individualBasePayAmount;
	private String monthPaymentAmount;
	private String updateTime;
	private String company;
	private String stopReason;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getPayMonthCount() {
		return payMonthCount;
	}

	public void setPayMonthCount(String payMonthCount) {
		this.payMonthCount = payMonthCount;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIndividualBasePayAmount() {
		return individualBasePayAmount;
	}

	public void setIndividualBasePayAmount(String individualBasePayAmount) {
		this.individualBasePayAmount = individualBasePayAmount;
	}

	public String getMonthPaymentAmount() {
		return monthPaymentAmount;
	}

	public void setMonthPaymentAmount(String monthPaymentAmount) {
		this.monthPaymentAmount = monthPaymentAmount;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	@Override
	public String toString() {
		return "PensionPayInfo [location=" + location + ", startDate="
				+ startDate + ", payMonthCount=" + payMonthCount
				+ ", startMonth=" + startMonth + ", status=" + status
				+ ", individualBasePayAmount=" + individualBasePayAmount
				+ ", monthPaymentAmount=" + monthPaymentAmount
				+ ", updateTime=" + updateTime + ", company=" + company
				+ ", stopReason=" + stopReason + "]";
	}

}
