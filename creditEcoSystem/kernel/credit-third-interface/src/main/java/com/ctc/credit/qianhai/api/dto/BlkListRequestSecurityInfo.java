package com.ctc.credit.qianhai.api.dto;

/**
 * 请求报文安全信息节点
 * @author sunny
 *
 */
public class BlkListRequestSecurityInfo {
	
	/** 签名 **/
	private String signatureValue;
	
	/** 虚拟用户 **/
	private String userName;
	
	/** 密码 **/
	private String userPassword;

	/**
	 * @return the signatureValue
	 */
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}

	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
}
