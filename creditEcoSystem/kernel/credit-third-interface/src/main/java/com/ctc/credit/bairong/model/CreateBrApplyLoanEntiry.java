package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

/**
 * 百融：审核信息核查实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_APPLYLOAN_INFO")
public class CreateBrApplyLoanEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 8441091740202255622L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**自然月，含当月*/
	private String month;
	
	/**申请机构*/
	private String applyOrgan;
	
	/**申请类型*/
	private String applyType;
	
	/**本机构申请次数*/
	private String selfnumber;
	
	/**总申请次数*/
	private String allnumber;
	
	/**总申请机构数*/
	private String orgnumber;

	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	@Column(name = "MONTH",length=255)
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "APPLY_ORGAN",length=255)
	public String getApplyOrgan() {
		return applyOrgan;
	}

	public void setApplyOrgan(String applyOrgan) {
		this.applyOrgan = applyOrgan;
	}

	@Column(name = "APPLY_TYPE",length=255)
	public String getApplyType() {
		return applyType;
	}

	public void setApplyType(String applyType) {
		this.applyType = applyType;
	}

	@Column(name = "SELF_NUMBER",length=255)
	public String getSelfnumber() {
		return selfnumber;
	}

	public void setSelfnumber(String selfnumber) {
		this.selfnumber = selfnumber;
	}

	@Column(name = "ALL_NUMBER",length=255)
	public String getAllnumber() {
		return allnumber;
	}

	public void setAllnumber(String allnumber) {
		this.allnumber = allnumber;
	}

	@Column(name = "ORG_NUMBER",length=255)
	public String getOrgnumber() {
		return orgnumber;
	}

	public void setOrgnumber(String orgnumber) {
		this.orgnumber = orgnumber;
	}
	
	

}
