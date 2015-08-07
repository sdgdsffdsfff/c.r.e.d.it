package com.ztx.credit.report.model;

/**
 * 逾期及违约信息概要
 * 
 * @author xucy
 *
 */
public class SummaryOverdueAndDefaultInfo {

	private BadDebtsInfo badDebtsInfo;
	private AssertDisposeInfo assertDisposeInfo;
	private GuarantorCompensationInfo guarantorCompensationInfo;

	public BadDebtsInfo getBadDebtsInfo() {
		return badDebtsInfo;
	}

	public void setBadDebtsInfo(BadDebtsInfo badDebtsInfo) {
		this.badDebtsInfo = badDebtsInfo;
	}

	public AssertDisposeInfo getAssertDisposeInfo() {
		return assertDisposeInfo;
	}

	public void setAssertDisposeInfo(AssertDisposeInfo assertDisposeInfo) {
		this.assertDisposeInfo = assertDisposeInfo;
	}

	public GuarantorCompensationInfo getGuarantorCompensationInfo() {
		return guarantorCompensationInfo;
	}

	public void setGuarantorCompensationInfo(
			GuarantorCompensationInfo guarantorCompensationInfo) {
		this.guarantorCompensationInfo = guarantorCompensationInfo;
	}

	@Override
	public String toString() {
		return "SummaryOverdueAndDefaultInfo [badDebtsInfo=" + badDebtsInfo
				+ ", assertDisposeInfo=" + assertDisposeInfo
				+ ", guarantorCompensationInfo=" + guarantorCompensationInfo
				+ "]";
	}
	
	
}
