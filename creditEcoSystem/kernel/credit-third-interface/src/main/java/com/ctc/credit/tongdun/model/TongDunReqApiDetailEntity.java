package com.ctc.credit.tongdun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "TONGDUNRULESDETAILREQ_INFO")
public class TongDunReqApiDetailEntity extends AbstractCreditEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5826657929073692431L;
	/**
	*partnerCode - 合作方代码，在用户接入时由同盾分配，用于校验
	*/
	private String partnerCode;
	/**
	*partnerKey - 合作方密钥
	*/
	private String partnerKey;
	/**
	*sequenceId - 事件ID
	*/
	private String sequenceId;
	/**
	*ruleUuid - 规则uuid，如填写此uuid，只会返回本条规则的信息
	*/
	private String ruleUuid;
	
	private String othersValue;
	/**
	* @param partnerCode the partnerCode to set - no comment
	*/
	public void setPartnerCode(String partnerCode)
	{
	    this.partnerCode = partnerCode;
	}
	/**
	* @return the partnerCode - no comment
	*/
	@Column(name="partner_code")
	public String getPartnerCode()
	{
	    return partnerCode;
	}
	/**
	* @param partnerKey the partnerKey to set - no comment
	*/
	public void setPartnerKey(String partnerKey)
	{
	    this.partnerKey = partnerKey;
	}
	/**
	* @return the partnerKey - no comment
	*/
	@Column(name="partner_key")
	public String getPartnerKey()
	{
	    return partnerKey;
	}
	/**
	* @param sequenceId the sequenceId to set - no comment
	*/
	public void setSequenceId(String sequenceId)
	{
	    this.sequenceId = sequenceId;
	}
	/**
	* @return the sequenceId - no comment
	*/
	@Column(name="sequence_id")
	public String getSequenceId()
	{
	    return sequenceId;
	}
	/**
	* @param ruleUuid the ruleUuid to set - no comment
	*/
	public void setRuleUuid(String ruleUuid)
	{
	    this.ruleUuid = ruleUuid;
	}
	/**
	* @return the ruleUuid - no comment
	*/
	@Column(name="rule_uuid")
	public String getRuleUuid()
	{
	    return ruleUuid;
	}
	/**
	* @param othersValue the othersValue to set - no comment
	*/
	public void setOthersValue(String othersValue)
	{
	    this.othersValue = othersValue;
	}
	/**
	* @return the othersValue - no comment
	*/
	@Column(name="others_value")
	public String getOthersValue()
	{
	    return othersValue;
	}

}