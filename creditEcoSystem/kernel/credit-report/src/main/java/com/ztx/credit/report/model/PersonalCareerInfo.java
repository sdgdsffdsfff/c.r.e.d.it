package com.ztx.credit.report.model;

/**
 * 职业信息
 * 
 * @author xucy
 *
 */
public class PersonalCareerInfo {
	private String serial;
	private String company;
	private String comAddress;
	private String career;
	private String industry;
	private String position;
	private String jobTitle;
	private String entryYear;
	private String updateTime;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getComAddress() {
		return comAddress;
	}

	public void setComAddress(String comAddress) {
		this.comAddress = comAddress;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "PersonalCareerInfo [serial=" + serial + ", company=" + company
				+ ", comAddress=" + comAddress + ", career=" + career
				+ ", industry=" + industry + ", position=" + position
				+ ", jobTitle=" + jobTitle + ", entryYear=" + entryYear
				+ ", updateTime=" + updateTime + "]";
	}

}
