package com.ctc.credit.bairong.api.dto.account;

public class DebitcardDto {

	/** 账目**/
	private String balance;
	
	/** 收入**/
	private String income;
	
	/** 支出**/
	private String outgo;
	
	/** 投资**/
	private String investment;
	
	/** 偿还**/
	private String repay;

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
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

	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	public String getRepay() {
		return repay;
	}

	public void setRepay(String repay) {
		this.repay = repay;
	}
	
	
}
