package com.ctc.credit.bairong.api.dto.media;

import java.util.ArrayList;

public class MediaDto {

	/** 流水账单**/
	private String swiftNumber;
	
	private ArrayList<PashMonthDto> months;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public ArrayList<PashMonthDto> getMonths() {
		return months;
	}

	public void setMonths(ArrayList<PashMonthDto> months) {
		this.months = months;
	}

	
	
	
}
