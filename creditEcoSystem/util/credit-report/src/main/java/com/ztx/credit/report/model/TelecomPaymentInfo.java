package com.ztx.credit.report.model;

/**
 * 电信缴费记录
 * 
 * @author xucy
 *
 */
public class TelecomPaymentInfo {
	private String serial;
	private String telecomOperator;
	private String businessType;
	private String effectiveDate;
	private String status;
	private String debtAmount;
	private String debtMonthCount;
	private String recordDate;
	private String paymentRecord_24;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getTelecomOperator() {
		return telecomOperator;
	}

	public void setTelecomOperator(String telecomOperator) {
		this.telecomOperator = telecomOperator;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDebtAmount() {
		return debtAmount == null ? "" : debtAmount;
	}

	public void setDebtAmount(String debtAmount) {
		this.debtAmount = debtAmount;
	}

	public String getDebtMonthCount() {
		return debtMonthCount;
	}

	public void setDebtMonthCount(String debtMonthCount) {
		this.debtMonthCount = debtMonthCount;
	}

	public String getRecordDate() {
		return recordDate;
	}

	public void setRecordDate(String recordDate) {
		this.recordDate = recordDate;
	}

	public String getPaymentRecord_24() {
		return paymentRecord_24;
	}

	public void setPaymentRecord_24(String paymentRecord_24) {
		this.paymentRecord_24 = paymentRecord_24;
	}

	@Override
	public String toString() {
		return "TelecomPaymentInfo [serial=" + serial + ", telecomOperator="
				+ telecomOperator + ", businessType=" + businessType
				+ ", effectiveDate=" + effectiveDate + ", status=" + status
				+ ", debtAmount=" + debtAmount + ", debtMonthCount="
				+ debtMonthCount + ", recordDate=" + recordDate
				+ ", paymentRecord_24=" + paymentRecord_24 + "]";
	}

}
