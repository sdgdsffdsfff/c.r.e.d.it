package com.ctc.credit.antifraud.model;

import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class FraudQueryCondition {
	
	/** 申请条码 **/
	private String applyCode;
	
	/***
	 * 来源系统
	 * 01-信贷
	 * 02-车贷
	 * 03-消金
	 * 04-其他
	 *
	 **/
	private String sourceSys;
	
	/** 请求类型 0-实时查询；1-批量查询 **/
	private String queryType;
	
	/** 客户相关信息 **/
	private CustomerInfo customerInfo;
	
	/** 联系人相关信息 **/
	private List<ContactsInfo> contactsInfo;
	
	/**
	 * @return the applyCode
	 */
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
	 * @return the sourceSys
	 */
	public String getSourceSys() {
		return sourceSys;
	}
	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(String sourceSys) {
		this.sourceSys = sourceSys;
	}
	/**
	 * @return the queryType
	 */
	public String getQueryType() {
		return queryType;
	}
	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	/**
	 * @return the customerInfo
	 */
	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}
	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}
	/**
	 * @return the contactsInfo
	 */
	public List<ContactsInfo> getContactsInfo() {
		return contactsInfo;
	}
	/**
	 * @param contactsInfo the contactsInfo to set
	 */
	public void setContactsInfo(List<ContactsInfo> contactsInfo) {
		this.contactsInfo = contactsInfo;
	}
	public static void main(String[] args) {
		FraudQueryCondition fraudQueryCondition = new FraudQueryCondition();
		fraudQueryCondition.setCustomerInfo(new CustomerInfo());
		List<ContactsInfo> contactsInfos = new ArrayList<ContactsInfo>();
		contactsInfos.add(new ContactsInfo());
		fraudQueryCondition.setContactsInfo(contactsInfos);
		System.out.println(JSONObject.fromObject(fraudQueryCondition));
	}
}
