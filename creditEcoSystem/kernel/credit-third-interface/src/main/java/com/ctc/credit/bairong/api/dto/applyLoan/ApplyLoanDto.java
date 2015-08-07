package com.ctc.credit.bairong.api.dto.applyLoan;

import java.util.ArrayList;

public class ApplyLoanDto {

	/** 流水账单**/
	private String swiftNumber;
	
	/** 自然月**/
	private ArrayList<MonthDto> monthDto;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public ArrayList<MonthDto> getMonthDto() {
		return monthDto;
	}

	public void setMonthDto(ArrayList<MonthDto> monthDto) {
		this.monthDto = monthDto;
	}
	
	
}
