package com.ztx.credit.report.model;

/**
 * 住房公积金参缴记录
 * 
 * @author xucy
 *
 */
public class HousingFundPayInfo {
	private String location;
	private String startDate;
	private String startMonth;
	private String endMonth;
	private String status;
	private String amount;
	private String individualProportion;
	private String companyProportion;
	private String company;
	private String updateTime;

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

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getIndividualProportion() {
		return individualProportion;
	}

	public void setIndividualProportion(String individualProportion) {
		this.individualProportion = individualProportion;
	}

	public String getCompanyProportion() {
		return companyProportion;
	}

	public void setCompanyProportion(String companyProportion) {
		this.companyProportion = companyProportion;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "HousingFundPayInfo [location=" + location + ", startDate="
				+ startDate + ", startMonth=" + startMonth + ", endMonth="
				+ endMonth + ", status=" + status + ", amount=" + amount
				+ ", individualProportion=" + individualProportion
				+ ", companyProportion=" + companyProportion + ", company="
				+ company + ", updateTime=" + updateTime + "]";
	}

}
