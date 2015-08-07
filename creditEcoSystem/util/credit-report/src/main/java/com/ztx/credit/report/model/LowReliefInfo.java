package com.ztx.credit.report.model;

/**
 * 低保救助记录
 * 
 * @author xucy
 *
 */
public class LowReliefInfo {
	private String serial;
	private String personType;
	private String location;
	private String company;
	private String familyMonthlyIncome;
	private String applyDate;
	private String approvalDate;
	private String updateTime;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFamilyMonthlyIncome() {
		return familyMonthlyIncome == null ? "" : familyMonthlyIncome;
	}

	public void setFamilyMonthlyIncome(String familyMonthlyIncome) {
		this.familyMonthlyIncome = familyMonthlyIncome;
	}

	public String getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}

	public String getApprovalDate() {
		return approvalDate;
	}

	public void setApprovalDate(String approvalDate) {
		this.approvalDate = approvalDate;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "LowReliefInfo [serial=" + serial + ", personType=" + personType
				+ ", location=" + location + ", company=" + company
				+ ", familyMonthlyIncome=" + familyMonthlyIncome
				+ ", applyDate=" + applyDate + ", approvalDate=" + approvalDate
				+ ", updateTime=" + updateTime + "]";
	}

}
