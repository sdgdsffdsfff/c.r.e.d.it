package com.ztx.credit.report.model;

/**
 * 执业资格记录
 * 
 * @author xucy
 *
 */
public class QualificationInfo {
	private String serial;
	private String qualificationName;
	private String rank;
	private String getDate;
	private String dueDate;
	private String revocationDate;
	private String authority;
	private String location;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getGetDate() {
		return getDate;
	}

	public void setGetDate(String getDate) {
		this.getDate = getDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getRevocationDate() {
		return revocationDate;
	}

	public void setRevocationDate(String revocationDate) {
		this.revocationDate = revocationDate;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "QualificationInfo [serial=" + serial + ", qualificationName="
				+ qualificationName + ", rank=" + rank + ", getDate=" + getDate
				+ ", dueDate=" + dueDate + ", revocationDate=" + revocationDate
				+ ", authority=" + authority + ", location=" + location + "]";
	}

}
