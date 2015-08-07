package com.ctc.credit.bairong.api.dto.media;

import java.util.ArrayList;

public class PashMonthDto {

	private String months;
	
	private ArrayList<CommTypeDto> commTyps;

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	public ArrayList<CommTypeDto> getCommTyps() {
		return commTyps;
	}

	public void setCommTyps(ArrayList<CommTypeDto> commTyps) {
		this.commTyps = commTyps;
	}
	
	
}
