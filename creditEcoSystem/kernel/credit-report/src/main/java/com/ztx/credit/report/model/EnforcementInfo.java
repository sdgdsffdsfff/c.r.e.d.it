package com.ztx.credit.report.model;

/**
 * 强制执行记录
 * 
 * @author xucy
 *
 */
public class EnforcementInfo {
	private String serial;
	private String executeCourt;
	private String executeReason;
	private String executeDate;
	private String executeWay;
	private String status;
	private String settlementDate;
	private String applyExecuteObject;
	private String applyExecuteObjectValue;
	private String executedObject;
	private String executedObjectAmount;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getExecuteCourt() {
		return executeCourt;
	}

	public void setExecuteCourt(String executeCourt) {
		this.executeCourt = executeCourt;
	}

	public String getExecuteReason() {
		return executeReason;
	}

	public void setExecuteReason(String executeReason) {
		this.executeReason = executeReason;
	}

	public String getExecuteDate() {
		return executeDate;
	}

	public void setExecuteDate(String executeDate) {
		this.executeDate = executeDate;
	}

	public String getExecuteWay() {
		return executeWay;
	}

	public void setExecuteWay(String executeWay) {
		this.executeWay = executeWay;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(String settlementDate) {
		this.settlementDate = settlementDate;
	}

	public String getApplyExecuteObject() {
		return applyExecuteObject;
	}

	public void setApplyExecuteObject(String applyExecuteObject) {
		this.applyExecuteObject = applyExecuteObject;
	}

	public String getApplyExecuteObjectValue() {
		return applyExecuteObjectValue;
	}

	public void setApplyExecuteObjectValue(String applyExecuteObjectValue) {
		this.applyExecuteObjectValue = applyExecuteObjectValue;
	}

	public String getExecutedObject() {
		return executedObject;
	}

	public void setExecutedObject(String executedObject) {
		this.executedObject = executedObject;
	}

	public String getExecutedObjectAmount() {
		return executedObjectAmount;
	}

	public void setExecutedObjectAmount(String executedObjectAmount) {
		this.executedObjectAmount = executedObjectAmount;
	}

	@Override
	public String toString() {
		return "EnforcementInfo [serial=" + serial + ", executeCourt="
				+ executeCourt + ", executeReason=" + executeReason
				+ ", executeDate=" + executeDate + ", executeWay=" + executeWay
				+ ", status=" + status + ", settlementDate=" + settlementDate
				+ ", applyExecuteObject=" + applyExecuteObject
				+ ", applyExecuteObjectValue=" + applyExecuteObjectValue
				+ ", executedObject=" + executedObject
				+ ", executedObjectAmount=" + executedObjectAmount + "]";
	}

}
