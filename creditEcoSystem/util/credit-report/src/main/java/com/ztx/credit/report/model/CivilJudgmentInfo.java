package com.ztx.credit.report.model;

/**
 * 民事判决记录
 * @author xucy
 *
 */
public class CivilJudgmentInfo {
	private String serial;
	private String fileCourt;
	private String fileReason;
	private String fileDate;
	private String settleWay;
	private String decisionResults;
	private String effectiveDate;
	private String 	litigationObject;
	private String 	litigationObjectAmount;
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getFileCourt() {
		return fileCourt;
	}
	public void setFileCourt(String fileCourt) {
		this.fileCourt = fileCourt;
	}
	public String getFileReason() {
		return fileReason;
	}
	public void setFileReason(String fileReason) {
		this.fileReason = fileReason;
	}
	public String getFileDate() {
		return fileDate;
	}
	public void setFileDate(String fileDate) {
		this.fileDate = fileDate;
	}
	public String getSettleWay() {
		return settleWay;
	}
	public void setSettleWay(String settleWay) {
		this.settleWay = settleWay;
	}
	public String getDecisionResults() {
		return decisionResults;
	}
	public void setDecisionResults(String decisionResults) {
		this.decisionResults = decisionResults;
	}
	public String getEffectiveDate() {
		return effectiveDate;
	}
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	public String getLitigationObject() {
		return litigationObject;
	}
	public void setLitigationObject(String litigationObject) {
		this.litigationObject = litigationObject;
	}
	public String getLitigationObjectAmount() {
		return litigationObjectAmount;
	}
	public void setLitigationObjectAmount(String litigationObjectAmount) {
		this.litigationObjectAmount = litigationObjectAmount;
	}
	@Override
	public String toString() {
		return "CivilJudgmentInfo [serial=" + serial + ", fileCourt="
				+ fileCourt + ", fileReason=" + fileReason + ", fileDate="
				+ fileDate + ", settleWay=" + settleWay + ", decisionResults="
				+ decisionResults + ", effectiveDate=" + effectiveDate
				+ ", litigationObject=" + litigationObject
				+ ", litigationObjectAmount=" + litigationObjectAmount + "]";
	}

	
}
