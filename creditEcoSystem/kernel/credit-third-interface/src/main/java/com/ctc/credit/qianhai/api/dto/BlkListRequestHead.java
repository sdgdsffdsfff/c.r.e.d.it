package com.ctc.credit.qianhai.api.dto;

/**
 *  请求报文头节点
 * @author sunny
 *
 */
public class BlkListRequestHead {
	
	/** 机构代码 **/
	private String orgCode = "10000003";
	
	/** 渠道、系统ID **/
	private String chnlId = "ctcf";
	
	/** 交易流水号 **/
	private String transNo;
	
	/** 交易时间 **/
	private String transDate;
	
	/** 授权代码 **/
	private String authCode;
	
	/** 授权时间 **/
	private String authDate;

	/**
	 * @return the orgCode
	 */
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
	public String getAuthDate() {
		return authDate;
	}

	/**
	 * @param authDate the authDate to set
	 */
	public void setAuthDate(String authDate) {
		this.authDate = authDate;
	}
	
}
