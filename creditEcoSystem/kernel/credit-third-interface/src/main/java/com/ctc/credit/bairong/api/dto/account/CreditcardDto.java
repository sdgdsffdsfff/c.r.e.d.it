package com.ctc.credit.bairong.api.dto.account;

public class CreditcardDto {
	
	/** 现金**/
	private String cash;
	
	/** 过期情况**/
	private String overdue;
	
	/** 收入**/
	private String income;
	
	/** 支出**/
	private String outgo;
	
	private String status;

	public String getCash() {
		return cash;
	}

	public void setCash(String cash) {
		this.cash = cash;
	}

	public String getOverdue() {
		return overdue;
	}

	public void setOverdue(String overdue) {
		this.overdue = overdue;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	public String getOutgo() {
		return outgo;
	}

	public void setOutgo(String outgo) {
		this.outgo = outgo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
