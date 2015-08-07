package com.ctc.credit.qianhai.api.dto;

/**
 * 请求报文安全信息节点
 * @author sunny
 *
 */
public class BlkListResponseSecurityInfo {
	
	/** 签名 **/
	private String signatureValue;

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
	
}
