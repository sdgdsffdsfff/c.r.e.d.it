package com.ctc.credit.antifraud.rule;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;

import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.rule.contant.IRuleContant;

public class IFact {
	
	private String applyCode;
	
	/** 客户基本信息 **/
	private CustomerInfo customerInfo;
	
	/** 联系人信息 **/
	private List<ContactsInfo> contactsInfo;
	
	/** 工作证明人信息  **/
	private List<ContactsInfo> workProverInfo;
	
	/** 父母 信息 **/
	private List<ContactsInfo> parentInfo;
	
	/** 子女 信息 **/
	private List<ContactsInfo> chidrenInfo;
	
	/** 其他联系人信息  **/
	private List<ContactsInfo> otherLinkManInfo;
	
	/** 家庭联系人信息  **/
	private List<ContactsInfo> familyContactsInfo;
	
	
	
	public IFact(CustomerInfo customerInfo, String applyCode,
			List<ContactsInfo> contactsInfos) {
		super();
		initLinkManInfos(customerInfo,contactsInfos);
		this.customerInfo = customerInfo;
		this.applyCode = applyCode;
	}
	
	/**
	 * 将联系人列表分类
	 * 
	 * @param contactsInfos
	 */
	private void initLinkManInfos(CustomerInfo customerInfo,List<ContactsInfo> contactsInfos){
		workProverInfo = new ArrayList<ContactsInfo>();
		parentInfo = new ArrayList<ContactsInfo>();
		chidrenInfo = new ArrayList<ContactsInfo>();
		otherLinkManInfo = new ArrayList<ContactsInfo>();
		familyContactsInfo = new ArrayList<ContactsInfo>();
		ContactsInfo spounseInfo = new ContactsInfo();
		//配偶也算家庭联系人
		spounseInfo.setName(customerInfo.getSpouseName());
		spounseInfo.setMobile(customerInfo.getSpouseMobile());
		spounseInfo.setCompanyName(customerInfo.getSpouseCompany());
		familyContactsInfo.add(spounseInfo);
		if (null!=contactsInfos) {
			for (ContactsInfo contactsInfo : contactsInfos) {
				if (null!=contactsInfo) {
					String relation = contactsInfo.getRelation();
					if(StringUtils.isNotEmpty(relation)){
						if (IRuleContant.CON_RELATION_PROVER.equals(relation)) {
							workProverInfo.add(contactsInfo);
						}else if(IRuleContant.CON_RELATION_PARENT.equals(relation)){
							parentInfo.add(contactsInfo);
							familyContactsInfo.add(contactsInfo);
						}else if(IRuleContant.CON_RELATION_CHILD.equals(relation)){
							chidrenInfo.add(contactsInfo);
							familyContactsInfo.add(contactsInfo);
						}else if(IRuleContant.CON_RELATION_OTHERFAMILY.equals(relation)){
							familyContactsInfo.add(contactsInfo);
						}else if(IRuleContant.CON_RELATION_OTHER.equals(relation)){
							otherLinkManInfo.add(contactsInfo);
						}
					}
				}
			}
		}
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
	 * @return the workProverInfo
	 */
	public List<ContactsInfo> getWorkProverInfo() {
		return workProverInfo;
	}

	/**
	 * @param workProverInfo the workProverInfo to set
	 */
	public void setWorkProverInfo(List<ContactsInfo> workProverInfo) {
		this.workProverInfo = workProverInfo;
	}

	/**
	 * @return the parentInfo
	 */
	public List<ContactsInfo> getParentInfo() {
		return parentInfo;
	}

	/**
	 * @param parentInfo the parentInfo to set
	 */
	public void setParentInfo(List<ContactsInfo> parentInfo) {
		this.parentInfo = parentInfo;
	}

	/**
	 * @return the chidrenInfo
	 */
	public List<ContactsInfo> getChidrenInfo() {
		return chidrenInfo;
	}

	/**
	 * @param chidrenInfo the chidrenInfo to set
	 */
	public void setChidrenInfo(List<ContactsInfo> chidrenInfo) {
		this.chidrenInfo = chidrenInfo;
	}

	/**
	 * @return the otherLinkManInfo
	 */
	public List<ContactsInfo> getOtherLinkManInfo() {
		return otherLinkManInfo;
	}

	/**
	 * @param otherLinkManInfo the otherLinkManInfo to set
	 */
	public void setOtherLinkManInfo(List<ContactsInfo> otherLinkManInfo) {
		this.otherLinkManInfo = otherLinkManInfo;
	}

	/**
	 * @return the familyContactsInfo
	 */
	public List<ContactsInfo> getFamilyContactsInfo() {
		return familyContactsInfo;
	}

	/**
	 * @param familyContactsInfo the familyContactsInfo to set
	 */
	public void setFamilyContactsInfo(List<ContactsInfo> familyContactsInfo) {
		this.familyContactsInfo = familyContactsInfo;
	}

}
