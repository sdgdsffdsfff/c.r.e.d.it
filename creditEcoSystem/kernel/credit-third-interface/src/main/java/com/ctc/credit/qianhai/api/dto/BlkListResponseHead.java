package com.ctc.credit.qianhai.api.dto;

/**
 *  响应报文头节点
 * @author sunny
 *
 */
public class BlkListResponseHead {
	
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

	/**
	 * @return the rtCode
	 */
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
	public String getRtMsg() {
		return rtMsg;
	}

	/**
	 * @param rtMsg the rtMsg to set
	 */
	public void setRtMsg(String rtMsg) {
		this.rtMsg = rtMsg;
	}
	
}
