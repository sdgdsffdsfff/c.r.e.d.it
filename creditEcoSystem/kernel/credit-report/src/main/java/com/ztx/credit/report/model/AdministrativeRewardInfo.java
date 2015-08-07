package com.ztx.credit.report.model;

/**
 * 行政奖励记录
 * 
 * @author xucy
 *
 */
public class AdministrativeRewardInfo {
	private String serial;
	private String rewardInstitution;
	private String rewardContent;
	private String effectiveDate;
	private String endDate;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getRewardInstitution() {
		return rewardInstitution;
	}

	public void setRewardInstitution(String rewardInstitution) {
		this.rewardInstitution = rewardInstitution;
	}

	public String getRewardContent() {
		return rewardContent;
	}

	public void setRewardContent(String rewardContent) {
		this.rewardContent = rewardContent;
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

	@Override
	public String toString() {
		return "AdministrativeRewardInfo [serial=" + serial
				+ ", rewardInstitution=" + rewardInstitution
				+ ", rewardContent=" + rewardContent + ", effectiveDate="
				+ effectiveDate + ", endDate=" + endDate + "]";
	}

}
