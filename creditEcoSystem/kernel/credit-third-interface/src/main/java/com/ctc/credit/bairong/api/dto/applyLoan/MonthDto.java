package com.ctc.credit.bairong.api.dto.applyLoan;

import java.util.ArrayList;

public class MonthDto {

	private String month;
	
	private ArrayList<ApplyTypeDto> applyType;

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public ArrayList<ApplyTypeDto> getApplyType() {
		return applyType;
	}

	public void setApplyType(ArrayList<ApplyTypeDto> applyType) {
		this.applyType = applyType;
	}

	
	
}
