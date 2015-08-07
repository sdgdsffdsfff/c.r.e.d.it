package com.ctc.credit.bairong.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：收支等级评估实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_ACCOUTCHANGE_INFO")
public class CreareBrAccoutChangeEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 1830668536495088630L;

	/**流水账单*/
	private String swiftNumber;
	
	/**过去月份*/
	private String months;
	
	/**卡指数*/
	private String cardindex;
	
	/**区域代码*/
	private String regionno;
	
	/**账户类型*/
	private String accountType;
	
	/**现金*/
	private String cash;
	
	/**逾期情况，0：未逾期，1：有逾期*/
	private String overDue;
	
	/**收入*/
	private String income;
	
	/**支出*/
	private String outgo;
	
	private String status;
	
	/**余额*/
	private String balance;
	
	/**投资金额*/
	private String investment;
	
	/**偿还金额*/
	private String repay;
	
	/**贷款金额*/
	private String loan;

	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	@Column(name = "MONTHS",length=255)
	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

	@Column(name = "CARDINDEX",length=255)
	public String getCardindex() {
		return cardindex;
	}

	public void setCardindex(String cardindex) {
		this.cardindex = cardindex;
	}

	@Column(name = "REGIONNO",length=255)
	public String getRegionno() {
		return regionno;
	}

	public void setRegionno(String regionno) {
		this.regionno = regionno;
	}

	@Column(name = "ACCOUNT_TYPE",length=255)
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	@Column(name = "CASH",length=255)
	public String getCash() {
		return cash;
	}
	
	public void setCash(String cash) {
		this.cash = cash;
	}
	@Column(name = "OVER_DUE",length=3)
	public String getOverDue() {
		return overDue;
	}

	public void setOverDue(String overDue) {
		this.overDue = overDue;
	}
	
	@Column(name = "INCOME",length=255)
	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}
	
	@Column(name = "OUTGO",length=255)
	public String getOutgo() {
		return outgo;
	}

	public void setOutgo(String outgo) {
		this.outgo = outgo;
	}

	@Column(name = "STATUS",length=3)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name = "BLANCE",length=255)
	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Column(name = "INVESTMENT",length=255)
	public String getInvestment() {
		return investment;
	}

	public void setInvestment(String investment) {
		this.investment = investment;
	}

	@Column(name = "REPAY",length=255)
	public String getRepay() {
		return repay;
	}

	public void setRepay(String repay) {
		this.repay = repay;
	}

	@Column(name = "LOAN",length=255)
	public String getLoan() {
		return loan;
	}

	public void setLoan(String loan) {
		this.loan = loan;
	}
	
	
	
}
