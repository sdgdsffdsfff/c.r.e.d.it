package com.ctc.credit.antifraud.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "loan_info")
public class LoanInfo extends AbstractCreditEntity {

	private static final long serialVersionUID = 5991658927539425104L;

	/** 放款合同号 **/
	private String applyCode;
	
	/** 放款合同号 **/
	private String loanContractNo;
	
	/** 放款机构名称 **/
	private String loanOrgName;
	
	/** 放款日期 **/
	private Date loanOpenDate;
	
	/** 到期日期，发生展期需要调整 **/
	private Date loanExpirationDate;
	
	/** 是否理赔 **/
	private String ifClaims;
	
	/** 风险结清标志 **/
	private String ifSettlementRisk;
	
	/** 币种 **/
	private String currency;
	
	/** 授信额度 **/
	private BigDecimal creditLimit;
	
	/** 共享授信额度 **/
	private BigDecimal sharedCreditLimit;
	
	/** 最大负债额  **/
	private BigDecimal maxIndebtedAmount;
	
	/** 还款方式 **/
	private String repaymentWay;
	
	/** 还款频率 **/
	private String paymentFrequency;
	
	/** 贷款总期数 **/
	private String loanStageAll;
	
	/** 协定期还款额 **/
	private BigDecimal agreedPayment ;
	
	/** 担保方式 **/
	private String guaranteeType;
	
	/** 本次还款期次 **/
	private String repaymentStage;
	
	/** 剩余还款月数 **/
	private String leftRepaymentMonth;
	
	/** 应还款日期 **/
	private Date LoanBillingDate;
	
	/** 本期应还款金额（信用卡为本期最低应还款额） **/
	private BigDecimal currentRepaymentAmount;
	
	/** 还款月份 **/
	private String repaymentMonth;
	
	/** 最近一次实际还款日期  **/
	private Date lastActualRepayDate;
	
	/** 本期实还金额 **/
	private BigDecimal currentStageAmount;
	
	/** 余额 **/
	private BigDecimal loanBalance;
	
	/** 是否逾期 **/
	private String ifExpiry;
	
	/** 当前逾期期数 **/
	private String currentExpiryStages;
	
	/** 当前逾期天数 **/
	private String currentExpiryDays;
	
	/** 当前逾期总额 **/
	private BigDecimal currentExpiryTotalAmount;
	
	/** 逾期31-60天未归还贷款本金 **/
	private BigDecimal expiryAmount31_60;
	
	/** 逾期61-90天未归还贷款本金 **/
	private BigDecimal expiryAmount61_90;
	
	/** 逾期91-180天未归还贷款本金 **/
	private BigDecimal expiryAmount91_180;
	
	/** 逾期180天以上未归还贷款本金 **/
	private BigDecimal expiryAmountGt180;
	
	/** 累计逾期期数 **/
	private String totalExpiryStages;
	
	/** 近6期逾期期数 **/
	private String nearly6ExpiryStages;
	
	/** 近6期累计逾期天数 **/
	private String nearly6ExpiryDays;
	
	/** 最高逾期期数 **/
	private String maxExpiryStages;
	
	/** 最高逾期天数 **/
	private String maxExpiryDays;
	
	/** 最高逾期金额 **/
	private BigDecimal maxExpiryAmount;
	
	/** 五级分类状态 **/
	private Integer classifyState;
	
	/** 账户状态 **/
	private Integer accountStatus;
	
	/** 24个月（账户）还款状态 **/
	private String loanPaymentStatus24;
	
	/** 当月还款状态 **/
	private String currmonthPaymentStatus;

	/**
	 * @return the applyCode
	 */
	@Column(name="apply_code",length=50)
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * @param applyCode the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * @return the loanContractNo
	 */
	@Column(name="loan_contract_no",length=60)
	public String getLoanContractNo() {
		return loanContractNo;
	}

	/**
	 * @param loanContractNo the loanContractNo to set
	 */
	public void setLoanContractNo(String loanContractNo) {
		this.loanContractNo = loanContractNo;
	}

	/**
	 * @return the loanOrgName
	 */
	@Column(name="loan_org_name",length=30)
	public String getLoanOrgName() {
		return loanOrgName;
	}

	/**
	 * @param loanOrgName the loanOrgName to set
	 */
	public void setLoanOrgName(String loanOrgName) {
		this.loanOrgName = loanOrgName;
	}

	/**
	 * @return the loanOpenDate
	 */
	@Column(name="loan_open_date")
	public Date getLoanOpenDate() {
		return loanOpenDate;
	}

	/**
	 * @param loanOpenDate the loanOpenDate to set
	 */
	public void setLoanOpenDate(Date loanOpenDate) {
		this.loanOpenDate = loanOpenDate;
	}

	/**
	 * @return the loanExpirationDate
	 */
	@Column(name="loan_expiration_date")
	public Date getLoanExpirationDate() {
		return loanExpirationDate;
	}

	/**
	 * @param loanExpirationDate the loanExpirationDate to set
	 */
	public void setLoanExpirationDate(Date loanExpirationDate) {
		this.loanExpirationDate = loanExpirationDate;
	}

	/**
	 * @return the ifClaims
	 */
	@Column(name="if_claims",length=1)
	public String getIfClaims() {
		return ifClaims;
	}

	/**
	 * @param ifClaims the ifClaims to set
	 */
	public void setIfClaims(String ifClaims) {
		this.ifClaims = ifClaims;
	}

	/**
	 * @return the ifSettlementRisk
	 */
	@Column(name="if_settlement_risk",length=1)
	public String getIfSettlementRisk() {
		return ifSettlementRisk;
	}

	/**
	 * @param ifSettlementRisk the ifSettlementRisk to set
	 */
	public void setIfSettlementRisk(String ifSettlementRisk) {
		this.ifSettlementRisk = ifSettlementRisk;
	}

	/**
	 * @return the currency
	 */
	@Column(name="currency",length=10)
	public String getCurrency() {
		return currency;
	}

	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * @return the creditLimit
	 */
	@Column(name="credit_limit")
	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	/**
	 * @param creditLimit the creditLimit to set
	 */
	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	/**
	 * @return the sharedCreditLimit
	 */
	@Column(name="shared_credit_limit")
	public BigDecimal getSharedCreditLimit() {
		return sharedCreditLimit;
	}

	/**
	 * @param sharedCreditLimit the sharedCreditLimit to set
	 */
	public void setSharedCreditLimit(BigDecimal sharedCreditLimit) {
		this.sharedCreditLimit = sharedCreditLimit;
	}

	/**
	 * @return the maxIndebtedAmount
	 */
	@Column(name="max_indebted_amount")
	public BigDecimal getMaxIndebtedAmount() {
		return maxIndebtedAmount;
	}

	/**
	 * @param maxIndebtedAmount the maxIndebtedAmount to set
	 */
	public void setMaxIndebtedAmount(BigDecimal maxIndebtedAmount) {
		this.maxIndebtedAmount = maxIndebtedAmount;
	}

	/**
	 * @return the repaymentWay
	 */
	@Column(name="repayment_way",length=10)
	public String getRepaymentWay() {
		return repaymentWay;
	}

	/**
	 * @param repaymentWay the repaymentWay to set
	 */
	public void setRepaymentWay(String repaymentWay) {
		this.repaymentWay = repaymentWay;
	}

	/**
	 * @return the paymentFrequency
	 */
	@Column(name="payment_frequency",length=2)
	public String getPaymentFrequency() {
		return paymentFrequency;
	}

	/**
	 * @param paymentFrequency the paymentFrequency to set
	 */
	public void setPaymentFrequency(String paymentFrequency) {
		this.paymentFrequency = paymentFrequency;
	}

	/**
	 * @return the loanStageAll
	 */
	@Column(name="loan_stage_all",length=3)
	public String getLoanStageAll() {
		return loanStageAll;
	}

	/**
	 * @param loanStageAll the loanStageAll to set
	 */
	public void setLoanStageAll(String loanStageAll) {
		this.loanStageAll = loanStageAll;
	}

	/**
	 * @return the agreedPayment
	 */
	@Column(name="agreed_payment")
	public BigDecimal getAgreedPayment() {
		return agreedPayment;
	}

	/**
	 * @param agreedPayment the agreedPayment to set
	 */
	public void setAgreedPayment(BigDecimal agreedPayment) {
		this.agreedPayment = agreedPayment;
	}

	/**
	 * @return the guaranteeType
	 */
	@Column(name="guarantee_type",length=1)
	public String getGuaranteeType() {
		return guaranteeType;
	}

	/**
	 * @param guaranteeType the guaranteeType to set
	 */
	public void setGuaranteeType(String guaranteeType) {
		this.guaranteeType = guaranteeType;
	}

	/**
	 * @return the repaymentStage
	 */
	@Column(name="repayment_stage",length=3)
	public String getRepaymentStage() {
		return repaymentStage;
	}

	/**
	 * @param repaymentStage the repaymentStage to set
	 */
	public void setRepaymentStage(String repaymentStage) {
		this.repaymentStage = repaymentStage;
	}

	/**
	 * @return the leftRepaymentMonth
	 */
	@Column(name="left_repayment_month",length=3)
	public String getLeftRepaymentMonth() {
		return leftRepaymentMonth;
	}

	/**
	 * @param leftRepaymentMonth the leftRepaymentMonth to set
	 */
	public void setLeftRepaymentMonth(String leftRepaymentMonth) {
		this.leftRepaymentMonth = leftRepaymentMonth;
	}

	/**
	 * @return the loanBillingDate
	 */
	@Column(name="Loan_billing_date")
	public Date getLoanBillingDate() {
		return LoanBillingDate;
	}

	/**
	 * @param loanBillingDate the loanBillingDate to set
	 */
	public void setLoanBillingDate(Date loanBillingDate) {
		LoanBillingDate = loanBillingDate;
	}

	/**
	 * @return the currentRepaymentAmount
	 */
	@Column(name="current_repayment_amount")
	public BigDecimal getCurrentRepaymentAmount() {
		return currentRepaymentAmount;
	}

	/**
	 * @param currentRepaymentAmount the currentRepaymentAmount to set
	 */
	public void setCurrentRepaymentAmount(BigDecimal currentRepaymentAmount) {
		this.currentRepaymentAmount = currentRepaymentAmount;
	}

	/**
	 * @return the repaymentMonth
	 */
	@Column(name="repayment_month",length=3)
	public String getRepaymentMonth() {
		return repaymentMonth;
	}

	/**
	 * @param repaymentMonth the repaymentMonth to set
	 */
	public void setRepaymentMonth(String repaymentMonth) {
		this.repaymentMonth = repaymentMonth;
	}

	/**
	 * @return the lastActualRepayDate
	 */
	@Column(name="last_actual_repay_date")
	public Date getLastActualRepayDate() {
		return lastActualRepayDate;
	}

	/**
	 * @param lastActualRepayDate the lastActualRepayDate to set
	 */
	public void setLastActualRepayDate(Date lastActualRepayDate) {
		this.lastActualRepayDate = lastActualRepayDate;
	}

	/**
	 * @return the currentStageAmount
	 */
	@Column(name="current_stage_amount")
	public BigDecimal getCurrentStageAmount() {
		return currentStageAmount;
	}

	/**
	 * @param currentStageAmount the currentStageAmount to set
	 */
	public void setCurrentStageAmount(BigDecimal currentStageAmount) {
		this.currentStageAmount = currentStageAmount;
	}

	/**
	 * @return the loanBalance
	 */
	@Column(name="loan_balance")
	public BigDecimal getLoanBalance() {
		return loanBalance;
	}

	/**
	 * @param loanBalance the loanBalance to set
	 */
	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}

	/**
	 * @return the ifExpiry
	 */
	@Column(name="if_expiry",length=1)
	public String getIfExpiry() {
		return ifExpiry;
	}

	/**
	 * @param ifExpiry the ifExpiry to set
	 */
	public void setIfExpiry(String ifExpiry) {
		this.ifExpiry = ifExpiry;
	}

	/**
	 * @return the currentExpiryStages
	 */
	@Column(name="current_expiry_stages",length=3)
	public String getCurrentExpiryStages() {
		return currentExpiryStages;
	}

	/**
	 * @param currentExpiryStages the currentExpiryStages to set
	 */
	public void setCurrentExpiryStages(String currentExpiryStages) {
		this.currentExpiryStages = currentExpiryStages;
	}

	/**
	 * @return the currentExpiryDays
	 */
	@Column(name="current_expiry_days",length=3)
	public String getCurrentExpiryDays() {
		return currentExpiryDays;
	}

	/**
	 * @param currentExpiryDays the currentExpiryDays to set
	 */
	public void setCurrentExpiryDays(String currentExpiryDays) {
		this.currentExpiryDays = currentExpiryDays;
	}

	/**
	 * @return the currentExpiryTotalAmount
	 */
	@Column(name="current_expiry_total_amount")
	public BigDecimal getCurrentExpiryTotalAmount() {
		return currentExpiryTotalAmount;
	}

	/**
	 * @param currentExpiryTotalAmount the currentExpiryTotalAmount to set
	 */
	public void setCurrentExpiryTotalAmount(BigDecimal currentExpiryTotalAmount) {
		this.currentExpiryTotalAmount = currentExpiryTotalAmount;
	}

	/**
	 * @return the expiryAmount31_60
	 */
	@Column(name="expiry_amount31_60")
	public BigDecimal getExpiryAmount31_60() {
		return expiryAmount31_60;
	}

	/**
	 * @param expiryAmount31_60 the expiryAmount31_60 to set
	 */
	public void setExpiryAmount31_60(BigDecimal expiryAmount31_60) {
		this.expiryAmount31_60 = expiryAmount31_60;
	}

	/**
	 * @return the expiryAmount61_90
	 */
	@Column(name="expiry_amount61_90")
	public BigDecimal getExpiryAmount61_90() {
		return expiryAmount61_90;
	}

	/**
	 * @param expiryAmount61_90 the expiryAmount61_90 to set
	 */
	public void setExpiryAmount61_90(BigDecimal expiryAmount61_90) {
		this.expiryAmount61_90 = expiryAmount61_90;
	}

	/**
	 * @return the expiryAmount91_180
	 */
	@Column(name="expiry_amount91_180")
	public BigDecimal getExpiryAmount91_180() {
		return expiryAmount91_180;
	}

	/**
	 * @param expiryAmount91_180 the expiryAmount91_180 to set
	 */
	public void setExpiryAmount91_180(BigDecimal expiryAmount91_180) {
		this.expiryAmount91_180 = expiryAmount91_180;
	}

	/**
	 * @return the expiryAmountGt180
	 */
	@Column(name="expiry_amount_gt180")
	public BigDecimal getExpiryAmountGt180() {
		return expiryAmountGt180;
	}

	/**
	 * @param expiryAmountGt180 the expiryAmountGt180 to set
	 */
	public void setExpiryAmountGt180(BigDecimal expiryAmountGt180) {
		this.expiryAmountGt180 = expiryAmountGt180;
	}

	/**
	 * @return the totalExpiryStages
	 */
	@Column(name="total_expiry_stages",length=3)
	public String getTotalExpiryStages() {
		return totalExpiryStages;
	}

	/**
	 * @param totalExpiryStages the totalExpiryStages to set
	 */
	public void setTotalExpiryStages(String totalExpiryStages) {
		this.totalExpiryStages = totalExpiryStages;
	}

	/**
	 * @return the nearly6ExpiryStages
	 */
	@Column(name="nearly6_expiry_stages",length=3)
	public String getNearly6ExpiryStages() {
		return nearly6ExpiryStages;
	}

	/**
	 * @param nearly6ExpiryStages the nearly6ExpiryStages to set
	 */
	public void setNearly6ExpiryStages(String nearly6ExpiryStages) {
		this.nearly6ExpiryStages = nearly6ExpiryStages;
	}

	/**
	 * @return the nearly6ExpiryDays
	 */
	@Column(name="nearly6_expiry_days",length=3)
	public String getNearly6ExpiryDays() {
		return nearly6ExpiryDays;
	}

	/**
	 * @param nearly6ExpiryDays the nearly6ExpiryDays to set
	 */
	public void setNearly6ExpiryDays(String nearly6ExpiryDays) {
		this.nearly6ExpiryDays = nearly6ExpiryDays;
	}

	/**
	 * @return the maxExpiryStages
	 */
	@Column(name="max_expiry_stages",length=3)
	public String getMaxExpiryStages() {
		return maxExpiryStages;
	}

	/**
	 * @param maxExpiryStages the maxExpiryStages to set
	 */
	public void setMaxExpiryStages(String maxExpiryStages) {
		this.maxExpiryStages = maxExpiryStages;
	}

	/**
	 * @return the maxExpiryDays
	 */
	@Column(name="max_expiry_days",length=3)
	public String getMaxExpiryDays() {
		return maxExpiryDays;
	}

	/**
	 * @param maxExpiryDays the maxExpiryDays to set
	 */
	public void setMaxExpiryDays(String maxExpiryDays) {
		this.maxExpiryDays = maxExpiryDays;
	}

	/**
	 * @return the maxExpiryAmount
	 */
	@Column(name="max_expiry_amount")
	public BigDecimal getMaxExpiryAmount() {
		return maxExpiryAmount;
	}

	/**
	 * @param maxExpiryAmount the maxExpiryAmount to set
	 */
	public void setMaxExpiryAmount(BigDecimal maxExpiryAmount) {
		this.maxExpiryAmount = maxExpiryAmount;
	}

	/**
	 * @return the classifyState
	 */
	@Column(name="classify_state")
	public Integer getClassifyState() {
		return classifyState;
	}

	/**
	 * @param classifyState the classifyState to set
	 */
	public void setClassifyState(Integer classifyState) {
		this.classifyState = classifyState;
	}

	/**
	 * @return the accountStatus
	 */
	@Column(name="account_status")
	public Integer getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(Integer accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * @return the loanPaymentStatus24
	 */
	@Column(name="loan_payment_status24",length=24)
	public String getLoanPaymentStatus24() {
		return loanPaymentStatus24;
	}

	/**
	 * @param loanPaymentStatus24 the loanPaymentStatus24 to set
	 */
	public void setLoanPaymentStatus24(String loanPaymentStatus24) {
		this.loanPaymentStatus24 = loanPaymentStatus24;
	}

	/**
	 * @return the currmonthPaymentStatus
	 */
	@Column(name="currmonth_payment_status",length=24)
	public String getCurrmonthPaymentStatus() {
		return currmonthPaymentStatus;
	}

	/**
	 * @param currmonthPaymentStatus the currmonthPaymentStatus to set
	 */
	public void setCurrmonthPaymentStatus(String currmonthPaymentStatus) {
		this.currmonthPaymentStatus = currmonthPaymentStatus;
	}
	
}
