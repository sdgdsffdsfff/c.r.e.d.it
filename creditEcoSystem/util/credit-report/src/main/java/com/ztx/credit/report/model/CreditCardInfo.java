package com.ztx.credit.report.model;

import java.util.ArrayList;
import java.util.List;

/**
 * （四）贷记卡信息
 * 
 * @author xucy
 *
 */
public class CreditCardInfo {

	private String totalDescription = "";
	private String repaymentRecord_24  = "";
	private String repaymentRecord_24Title  = "";
	private String creditCardOverdue_24_InfosTitle  = "";
	private List<CreditCardOverdue_24_Info> creditCardOverdue_24_Infos = new ArrayList<CreditCardOverdue_24_Info>();
	private CreditCardDetailInfo cardDetailInfo  = new CreditCardDetailInfo();
	private List<SpecialTradeType> specialTradeTypes  = new ArrayList<SpecialTradeType>();
	private String cardIssuerDeclare  = "";
	private String declareDate_1  = "";
	private String loanerDeclare  = "";
	private String declareDate_2  = "";
	private String dissentMark  = "";
	private String declareDate_3  = "";
	public String getTotalDescription() {
		return totalDescription;
	}
	public void setTotalDescription(String totalDescription) {
		this.totalDescription = totalDescription;
	}
	public String getRepaymentRecord_24() {
		return repaymentRecord_24;
	}
	public void setRepaymentRecord_24(String repaymentRecord_24) {
		this.repaymentRecord_24 = repaymentRecord_24;
	}
	public String getRepaymentRecord_24Title() {
		return repaymentRecord_24Title;
	}
	public void setRepaymentRecord_24Title(String repaymentRecord_24Title) {
		this.repaymentRecord_24Title = repaymentRecord_24Title;
	}
	public String getCreditCardOverdue_24_InfosTitle() {
		return creditCardOverdue_24_InfosTitle;
	}
	public void setCreditCardOverdue_24_InfosTitle(
			String creditCardOverdue_24_InfosTitle) {
		this.creditCardOverdue_24_InfosTitle = creditCardOverdue_24_InfosTitle;
	}
	public List<CreditCardOverdue_24_Info> getCreditCardOverdue_24_Infos() {
		return creditCardOverdue_24_Infos;
	}
	public void setCreditCardOverdue_24_Infos(
			List<CreditCardOverdue_24_Info> creditCardOverdue_24_Infos) {
		this.creditCardOverdue_24_Infos = creditCardOverdue_24_Infos;
	}
	public CreditCardDetailInfo getCardDetailInfo() {
		return cardDetailInfo;
	}
	public void setCardDetailInfo(CreditCardDetailInfo cardDetailInfo) {
		this.cardDetailInfo = cardDetailInfo;
	}
	
	public String getCardIssuerDeclare() {
		return cardIssuerDeclare;
	}
	public void setCardIssuerDeclare(String cardIssuerDeclare) {
		this.cardIssuerDeclare = cardIssuerDeclare;
	}
	public String getDeclareDate_1() {
		return declareDate_1;
	}
	public void setDeclareDate_1(String declareDate_1) {
		this.declareDate_1 = declareDate_1;
	}
	public String getLoanerDeclare() {
		return loanerDeclare;
	}
	public void setLoanerDeclare(String loanerDeclare) {
		this.loanerDeclare = loanerDeclare;
	}
	public String getDeclareDate_2() {
		return declareDate_2;
	}
	public void setDeclareDate_2(String declareDate_2) {
		this.declareDate_2 = declareDate_2;
	}
	public String getDissentMark() {
		return dissentMark;
	}
	public void setDissentMark(String dissentMark) {
		this.dissentMark = dissentMark;
	}
	public String getDeclareDate_3() {
		return declareDate_3;
	}
	public void setDeclareDate_3(String declareDate_3) {
		this.declareDate_3 = declareDate_3;
	}
	@Override
	public String toString() {
		return "CreditCardInfo [totalDescription=" + totalDescription
				+ ", repaymentRecord_24=" + repaymentRecord_24
				+ ", repaymentRecord_24Title=" + repaymentRecord_24Title
				+ ", creditCardOverdue_24_InfosTitle="
				+ creditCardOverdue_24_InfosTitle
				+ ", creditCardOverdue_24_Infos=" + creditCardOverdue_24_Infos
				+ ", cardDetailInfo=" + cardDetailInfo + ", specialTradeTypes="
				+ specialTradeTypes + ", cardIssuerDeclare="
				+ cardIssuerDeclare + ", declareDate_1=" + declareDate_1
				+ ", loanerDeclare=" + loanerDeclare + ", declareDate_2="
				+ declareDate_2 + ", dissentMark=" + dissentMark
				+ ", declareDate_3=" + declareDate_3 + "]";
	}
	public List<SpecialTradeType> getSpecialTradeTypes() {
		return specialTradeTypes == null? new ArrayList<SpecialTradeType>() : specialTradeTypes;
	}
	public void setSpecialTradeTypes(List<SpecialTradeType> specialTradeTypes) {
		this.specialTradeTypes = specialTradeTypes;
	}

}
