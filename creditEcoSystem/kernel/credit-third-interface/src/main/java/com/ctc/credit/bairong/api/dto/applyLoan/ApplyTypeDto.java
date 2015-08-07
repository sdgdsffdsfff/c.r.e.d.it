package com.ctc.credit.bairong.api.dto.applyLoan;

import java.util.ArrayList;

public class ApplyTypeDto {
	
	private String applyType;
	
	private ArrayList<ApplyOragnDto> applyOragn;

	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	public ArrayList<ApplyOragnDto> getApplyOragn() {
		return applyOragn;
	}

	public void setApplyOragn(ArrayList<ApplyOragnDto> applyOragn) {
		this.applyOragn = applyOragn;
	}
	
	
}
