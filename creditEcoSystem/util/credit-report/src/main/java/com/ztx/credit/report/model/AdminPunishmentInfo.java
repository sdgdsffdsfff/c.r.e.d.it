package com.ztx.credit.report.model;

/**
 * 行政处罚记录
 * 
 * @author xucy
 *
 */
public class AdminPunishmentInfo {
	private String serial;
	private String punishInstitution;
	private String punishContent;
	private String punishAmount;
	private String effectiveDate;
	private String endDate;
	private String adminReviewResult;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getPunishInstitution() {
		return punishInstitution;
	}

	public void setPunishInstitution(String punishInstitution) {
		this.punishInstitution = punishInstitution;
	}

	public String getPunishContent() {
		return punishContent;
	}

	public void setPunishContent(String punishContent) {
		this.punishContent = punishContent;
	}

	public String getPunishAmount() {
		return punishAmount == null ? "" : punishAmount;
	}

	public void setPunishAmount(String punishAmount) {
		this.punishAmount = punishAmount;
	}

	public String getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getAdminReviewResult() {
		return adminReviewResult;
	}

	public void setAdminReviewResult(String adminReviewResult) {
		this.adminReviewResult = adminReviewResult;
	}

	@Override
	public String toString() {
		return "AdminPunishmentInfo [serial=" + serial + ", punishInstitution="
				+ punishInstitution + ", punishContent=" + punishContent
				+ ", punishAmount=" + punishAmount + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate
				+ ", adminReviewResult=" + adminReviewResult + "]";
	}

}
