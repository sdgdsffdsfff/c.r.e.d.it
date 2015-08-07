package com.ctc.credit.bairong.api.dto.applyLoan;

import java.util.ArrayList;

public class ApplyOragnDto {

	private String applyOragn;
	
	private ArrayList<ApplyNoDto> applyNo;

	public String getApplyOragn() {
		return applyOragn;
	}

	public void setApplyOragn(String applyOragn) {
		this.applyOragn = applyOragn;
	}

	public ArrayList<ApplyNoDto> getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(ArrayList<ApplyNoDto> applyNo) {
		this.applyNo = applyNo;
	}
	
	
}
