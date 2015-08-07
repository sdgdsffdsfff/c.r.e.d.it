package com.ztx.credit.report.model;

/**
 * 报告头
 * 
 * @author xucy
 *
 */
public class ReportHeadInfo {
	private String reportNo;
	private String reqTime;
	private String reportTime;

	public String getReportNo() {
		return reportNo;
	}

	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}

	public String getReqTime() {
		return reqTime;
	}

	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}

	public String getReportTime() {
		return reportTime;
	}

	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}

	@Override
	public String toString() {
		return "ReportHeadInfo [reportNo=" + reportNo + ", reqTime=" + reqTime
				+ ", reportTime=" + reportTime + "]";
	}

}
