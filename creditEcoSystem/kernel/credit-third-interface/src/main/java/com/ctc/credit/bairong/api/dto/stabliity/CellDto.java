package com.ctc.credit.bairong.api.dto.stabliity;

public class CellDto {
	
	/** 百融该key值数量**/
	private String number;
	
	/** 匹配成功的cell在百融库中出现的最早时间**/
	private String firsttime;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getFirsttime() {
		return firsttime;
	}

	public void setFirsttime(String firsttime) {
		this.firsttime = firsttime;
	}
	
	
}
