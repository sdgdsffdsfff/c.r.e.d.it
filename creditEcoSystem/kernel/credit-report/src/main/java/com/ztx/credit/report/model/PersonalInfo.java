package com.ztx.credit.report.model;

/**
 * 身份信息
 * @author xucy
 *
 */
public class PersonalInfo {
	private String gender;
	private String birthday;
	private String isMarried;
	private String mobilePhone;
	private String comPhone;
	private String homePhone;
	private String education;
	private String degree;
	private String address;
	private String permanentAddress;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIsMarried() {
		return isMarried;
	}

	public void setIsMarried(String isMarried) {
		this.isMarried = isMarried;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getComPhone() {
		return comPhone;
	}

	public void setComPhone(String comPhone) {
		this.comPhone = comPhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	@Override
	public String toString() {
		return "PersonalInfo [gender=" + gender + ", birthday=" + birthday
				+ ", isMarried=" + isMarried + ", mobilePhone=" + mobilePhone
				+ ", comPhone=" + comPhone + ", homePhone=" + homePhone
				+ ", education=" + education + ", degree=" + degree
				+ ", address=" + address + ", permanentAddress="
				+ permanentAddress + "]";
	}

}
