package com.ztx.credit.report.model;

/**
 * 欠税记录
 * @author xucy
 *
 */
public class TaxesInfo {
	private String serial;
	private String 	taxAuthorities;
	private String 	taxesTotalAmount;
	private String 	statisticalDate;
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getTaxAuthorities() {
		return taxAuthorities;
	}
	public void setTaxAuthorities(String taxAuthorities) {
		this.taxAuthorities = taxAuthorities;
	}
	public String getTaxesTotalAmount() {
		return taxesTotalAmount == null ? "" : taxesTotalAmount;
	}
	public void setTaxesTotalAmount(String taxesTotalAmount) {
		this.taxesTotalAmount = taxesTotalAmount;
	}
	public String getStatisticalDate() {
		return statisticalDate;
	}
	public void setStatisticalDate(String statisticalDate) {
		this.statisticalDate = statisticalDate;
	}
	@Override
	public String toString() {
		return "TaxesInfo [serial=" + serial + ", taxAuthorities="
				+ taxAuthorities + ", taxesTotalAmount=" + taxesTotalAmount
				+ ", statisticalDate=" + statisticalDate + "]";
	}

}
