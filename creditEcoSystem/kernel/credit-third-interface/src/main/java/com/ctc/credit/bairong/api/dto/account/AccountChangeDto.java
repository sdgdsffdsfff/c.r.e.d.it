package com.ctc.credit.bairong.api.dto.account;

import java.util.ArrayList;

public class AccountChangeDto {

	/** 流水账单**/
	private String swiftNumber; 
	
	/** 卡指数**/
	private String cardindex;
	
	/** 区域编号**/
	private String regionno;
	
	private ArrayList<MonthPeriodDto> monthPeriodDto;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public String getCardindex() {
		return cardindex;
	}

	public void setCardindex(String cardindex) {
		this.cardindex = cardindex;
	}

	public String getRegionno() {
		return regionno;
	}

	public void setRegionno(String regionno) {
		this.regionno = regionno;
	}

	public ArrayList<MonthPeriodDto> getMonthPeriodDto() {
		return monthPeriodDto;
	}

	public void setMonthPeriodDto(ArrayList<MonthPeriodDto> monthPeriodDto) {
		this.monthPeriodDto = monthPeriodDto;
	}

	

	
	
	
}
