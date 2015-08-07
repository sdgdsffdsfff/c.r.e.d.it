package com.ctc.credit.bairong.api.dto.account;

import java.util.ArrayList;

public class MonthPeriodDto {
	
	private String monthPeriod;
	
	private ArrayList<AccountTypeDto> accountTypeDto;

	public String getMonthPeriod() {
		return monthPeriod;
	}

	public void setMonthPeriod(String monthPeriod) {
		this.monthPeriod = monthPeriod;
	}

	public ArrayList<AccountTypeDto> getAccountTypeDto() {
		return accountTypeDto;
	}

	public void setAccountTypeDto(ArrayList<AccountTypeDto> accountTypeDto) {
		this.accountTypeDto = accountTypeDto;
	}
	
	
}
