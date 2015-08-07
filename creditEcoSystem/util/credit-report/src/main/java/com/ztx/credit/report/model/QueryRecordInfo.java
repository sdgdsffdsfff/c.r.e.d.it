package com.ztx.credit.report.model;

/**
 * 信贷审批查询记录明细
 * 
 * @author xucy
 *
 */
public class QueryRecordInfo {
	private String serial;
	private String queryDate;
	private String queryOperator;
	private String queryReason;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public String getQueryOperator() {
		return queryOperator;
	}

	public void setQueryOperator(String queryOperator) {
		this.queryOperator = queryOperator;
	}

	public String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}

	@Override
	public String toString() {
		return "QueryRecordInfo [serial=" + serial + ", queryDate=" + queryDate
				+ ", queryOperator=" + queryOperator + ", queryReason="
				+ queryReason + "]";
	}

}
