package com.ctc.credit.bairong.api.dto.account;

import java.util.ArrayList;

public class AccountTypeDto {

	private String accountType;
	
	private CreditcardDto creditcard;
	
	private DebitcardDto debitcard;

	private String loan;

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	

	public CreditcardDto getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(CreditcardDto creditcard) {
		this.creditcard = creditcard;
	}

	public DebitcardDto getDebitcard() {
		return debitcard;
	}

	public void setDebitcard(DebitcardDto debitcard) {
		this.debitcard = debitcard;
	}

	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}
	
	
	
}
