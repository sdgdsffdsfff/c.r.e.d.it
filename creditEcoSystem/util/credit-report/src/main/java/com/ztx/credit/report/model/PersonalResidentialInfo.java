package com.ztx.credit.report.model;

/**
 * 居住信息
 * 
 * @author xucy
 *
 */
public class PersonalResidentialInfo {
	private String serial;
	private String address;
	private String residentialStatus;
	private String updateTime;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getResidentialStatus() {
		return residentialStatus;
	}

	public void setResidentialStatus(String residentialStatus) {
		this.residentialStatus = residentialStatus;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	@Override
	public String toString() {
		return "PersonalResidentialInfo [serial=" + serial + ", address="
				+ address + ", residentialStatus=" + residentialStatus
				+ ", updateTime=" + updateTime + "]";
	}

}
