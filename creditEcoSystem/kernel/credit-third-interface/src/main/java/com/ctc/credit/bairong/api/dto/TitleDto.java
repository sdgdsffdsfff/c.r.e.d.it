package com.ctc.credit.bairong.api.dto;

public class TitleDto {
	/** 流水号 **/
	private String swiftNo;
	
	/** 企业主/高管标识:0（无），1（小微企业主），2（企业高管） **/
	private String title;

	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
