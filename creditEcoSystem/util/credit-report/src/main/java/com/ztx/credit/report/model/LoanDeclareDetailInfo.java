package com.ztx.credit.report.model;

/**
 * 本人声明
 * @author xucy
 *
 */
public class LoanDeclareDetailInfo {
	private String serial;
	private String content;
	private String declareDate;

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDeclareDate() {
		return declareDate;
	}

	public void setDeclareDate(String declareDate) {
		this.declareDate = declareDate;
	}

	@Override
	public String toString() {
		return "LoanDeclareDetailInfo [serial=" + serial + ", content="
				+ content + ", declareDate=" + declareDate + "]";
	}

}
