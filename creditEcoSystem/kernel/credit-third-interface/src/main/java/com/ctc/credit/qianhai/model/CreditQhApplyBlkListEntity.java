package com.ctc.credit.qianhai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "QH_APPLY_BLKLIST")
public class CreditQhApplyBlkListEntity extends AbstractCreditEntity{

	private static final long serialVersionUID = -467823648772563357L;
	
	/** 机构代码 **/
	private String orgCode;
	
	/** 渠道、系统ID **/
	private String chnlId;
	
	/** 交易流水号 **/
	private String transNo;
	
	/** 交易时间 **/
	private String transDate;
	
	/** 授权代码 **/
	private String authCode;
	
	/** 授权时间 **/
	private String authDate;
	
	/** 错误代码 **/
	private String rtCode;
	
	/** 错误消息 **/
	private String rtMsg;
	
	/** 批次号 **/
	private String batchNo;
	
	/** 证件号码 **/
	private String idNo;
	
	/** 证件类型 **/
	private String idType;
	
	/** 查询原因 **/
	private String reasonCode;
	
	/** 主体名称 **/
	private String name;
	
	/** 序列号 **/
	private String seqNo;
	
	/** 签名 **/
	private String signatureValue;
	
	/** 签名 前海返回 **/
	private String signatureValueRe;
	
	/** 异常code **/
	private String exceptionCode;
	
	/** 异常消息 **/
	private String exceptionMsg;
	
	/** 申请条码 **/
	private String applyNo;
	
	/**
	 * @return the orgCode
	 */
	@Column(name = "ORG_CODE",length=24)
	public String getOrgCode() {
		return orgCode;
	}

	/**
	 * @param orgCode the orgCode to set
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	/**
	 * @return the chnlId
	 */
	@Column(name = "CHNL_ID",length=16)
	public String getChnlId() {
		return chnlId;
	}

	/**
	 * @param chnlId the chnlId to set
	 */
	public void setChnlId(String chnlId) {
		this.chnlId = chnlId;
	}

	/**
	 * @return the transNo
	 */
	@Column(name = "TRANS_NO",length=24)
	public String getTransNo() {
		return transNo;
	}

	/**
	 * @param transNo the transNo to set
	 */
	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	/**
	 * @return the transDate
	 */
	@Column(name = "TRANS_DATE",length=24)
	public String getTransDate() {
		return transDate;
	}

	/**
	 * @param transDate the transDate to set
	 */
	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	/**
	 * @return the authCode
	 */
	@Column(name = "AUTH_CODE",length=32)
	public String getAuthCode() {
		return authCode;
	}

	/**
	 * @param authCode the authCode to set
	 */
	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	/**
	 * @return the authDate
	 */
	@Column(name = "AUTH_DATE",length=24)
	public String getAuthDate() {
		return authDate;
	}

	/**
	 * @param authDate the authDate to set
	 */
	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}

	/**
	 * @return the rtCode
	 */
	@Column(name = "RT_CODE",length=8)
	public String getRtCode() {
		return rtCode;
	}

	/**
	 * @param rtCode the rtCode to set
	 */
	public void setRtCode(String rtCode) {
		this.rtCode = rtCode;
	}

	/**
	 * @return the rtMsg
	 */
	@Column(name = "RT_MSG",length=1500)
	public String getRtMsg() {
		return rtMsg;
	}

	/**
	 * @param rtMsg the rtMsg to set
	 */
	public void setRtMsg(String rtMsg) {
		this.rtMsg = rtMsg;
	}

	/**
	 * @return the batchNo
	 */
	@Column(name = "BATCH_NO",length=32)
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the idNo
	 */
	@Column(name = "ID_NO",length=64)
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return the idType
	 */
	@Column(name = "ID_TYPE",length=1)
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}

	/**
	 * @return the reasonCode
	 */
	@Column(name = "REASON_CODE",length=2)
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the name
	 */
	@Column(name = "NAME",length=128)
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
	 * @return the seqNo
	 */
	@Column(name = "SEQ_NO",length=24)
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}


	/**
	 * @return the signatureValue
	 */
	@Column(name = "SIGNATURE_VALUE",length=1500)
	public String getSignatureValue() {
		return signatureValue;
	}

	/**
	 * @param signatureValue the signatureValue to set
	 */
	public void setSignatureValue(String signatureValue) {
		this.signatureValue = signatureValue;
	}

	/**
	 * @return the signatureValueRe
	 */
	@Column(name = "SIGNATURE_VALUE_RE",length=1500)
	public String getSignatureValueRe() {
		return signatureValueRe;
	}

	/**
	 * @param signatureValueRe the signatureValueRe to set
	 */
	public void setSignatureValueRe(String signatureValueRe) {
		this.signatureValueRe = signatureValueRe;
	}

	/**
	 * @return the exceptionCode
	 */
	@Column(name = "EXCEPTION_CODE",length=50)
	public String getExceptionCode() {
		return exceptionCode;
	}

	/**
	 * @param exceptionCode the exceptionCode to set
	 */
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	/**
	 * @return the exceptionMsg
	 */
	@Column(name = "EXCEPTION_MSG",length=1500)
	public String getExceptionMsg() {
		return exceptionMsg;
	}

	/**
	 * @return the applyNo
	 */
	public String getApplyNo() {
		return applyNo;
	}

	/**
	 * @param applyNo the applyNo to set
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	/**
	 * @param exceptionMsg the exceptionMsg to set
	 */
	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}
	
}
