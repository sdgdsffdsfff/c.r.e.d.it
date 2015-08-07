package com.ctc.credit.antifraud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "refuse_reason_info")
public class RefuseReasonInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -7043501376536020566L;
	
	private String applyCode;
	private String parentCode;
	private String parentCodeDesc;
	private String refuseCode;
	private String codeDesc;
	private String codeType;
	
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
	 * @return the parentCode
	 */
	@Column(name="parent_code",length=50)
	public String getParentCode() {
		return parentCode;
	}
	/**
	 * @param parentCode the parentCode to set
	 */
	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}
	/**
	 * @return the parentCodeDesc
	 */
	@Column(name="parent_code_desc",length=255)
	public String getParentCodeDesc() {
		return parentCodeDesc;
	}
	/**
	 * @param parentCodeDesc the parentCodeDesc to set
	 */
	public void setParentCodeDesc(String parentCodeDesc) {
		this.parentCodeDesc = parentCodeDesc;
	}
	/**
	 * @return the refuseCode
	 */
	@Column(name="refuse_code",length=50)
	public String getRefuseCode() {
		return refuseCode;
	}
	/**
	 * @param refuseCode the refuseCode to set
	 */
	public void setRefuseCode(String refuseCode) {
		this.refuseCode = refuseCode;
	}
	/**
	 * @return the codeDesc
	 */
	@Column(name="code_desc",length=255)
	public String getCodeDesc() {
		return codeDesc;
	}
	/**
	 * @param codeDesc the codeDesc to set
	 */
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	/**
	 * @return the codeType
	 */
	@Column(name="code_type",length=1)
	public String getCodeType() {
		return codeType;
	}
	/**
	 * @param codeType the codeType to set
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	
}
