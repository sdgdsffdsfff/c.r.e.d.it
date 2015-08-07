package com.ctc.credit.antifraud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "contacts_info")
public class ContactsInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -7043501376536020566L;
	
	private String applyCode;
	private String name ;
	private String relation;
	private String mobile;
	private String phone;
	private String companyName;
	private String department;
	private String companyPhone;
	
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
	 * @return the name
	 */
	@Column(name="name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the relation
	 */
	@Column(name="relation",length=1)
	public String getRelation() {
		return relation;
	}
	/**
	 * @param relation the relation to set
	 */
	public void setRelation(String relation) {
		this.relation = relation;
	}
	/**
	 * @return the mobile
	 */
	@Column(name="mobile")
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the phone
	 */
	@Column(name="phone")
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the companyName
	 */
	@Column(name="company_name")
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the department
	 */
	@Column(name="department",length=100)
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the companyPhoneprivate
	 */
	@Column(name="company_phone",length=25)
	public String getCompanyPhone() {
		return companyPhone;
	}
	/**
	 * @param companyPhoneprivate the companyPhoneprivate to set
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	
}
