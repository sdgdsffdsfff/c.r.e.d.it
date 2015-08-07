package com.ctc.credit.bairong.api.dto;

public class ScoreDto {
	/** 流水号 **/
	private String swiftNo;
	/** 百融通用信用评分 评分取值范围[300,1000]，分数越高，客户信用越好 **/
	private String brcreditpoint;
	
	
	public String getSwiftNo() {
		return swiftNo;
	}
	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}
	public String getBrcreditpoint() {
		return brcreditpoint;
	}
	public void setBrcreditpoint(String brcreditpoint) {
		this.brcreditpoint = brcreditpoint;
	}

}
