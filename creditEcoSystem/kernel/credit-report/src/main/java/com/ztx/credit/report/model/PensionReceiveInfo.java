package com.ztx.credit.report.model;

/**
 * 养老保险金发放记录
 * 
 * @author xucy
 *
 */
public class PensionReceiveInfo {
	private String location;
	private String retiredType;
	private String retiredMonth;
	private String startMonth;
	private String realPension;
	private String stopReason;
	private String company;
	private String updateTime;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getRetiredType() {
		return retiredType;
	}

	public void setRetiredType(String retiredType) {
		this.retiredType = retiredType;
	}

	public String getRetiredMonth() {
		return retiredMonth;
	}

	public void setRetiredMonth(String retiredMonth) {
		this.retiredMonth = retiredMonth;
	}

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getRealPension() {
		return realPension;
	}

	public void setRealPension(String realPension) {
		this.realPension = realPension;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
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
		return "PensionReceiveInfo [location=" + location + ", retiredType="
				+ retiredType + ", retiredMonth=" + retiredMonth
				+ ", startMonth=" + startMonth + ", realPension=" + realPension
				+ ", stopReason=" + stopReason + ", company=" + company
				+ ", updateTime=" + updateTime + "]";
	}

}
