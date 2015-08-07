package com.ztx.credit.report.model;

/**
 * 配偶信息
 * 
 * @author xucy
 *
 */
public class PersonalSpouseInfo {

	private String name;
	private String iDType;
	private String iDNumber;
	private String company;
	private String phone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getiDType() {
		return iDType;
	}

	public void setiDType(String iDType) {
		this.iDType = iDType;
	}

	public String getiDNumber() {
		return iDNumber;
	}

	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "PersonalSpouseInfo [name=" + name + ", iDType=" + iDType
				+ ", iDNumber=" + iDNumber + ", company=" + company
				+ ", phone=" + phone + "]";
	}

}
