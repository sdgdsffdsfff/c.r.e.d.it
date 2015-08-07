package com.ctc.credit.qianhai.api.dto;

/**
 * 前海征信请求报文对象
 * @author sunny
 *
 */
public class BlkListRequestDto {

	private BlkListRequestHead header;
	
	private String busiData;
	
	private BlkListRequestSecurityInfo securityInfo;

	/**
	 * @return the header
	 */
	public BlkListRequestHead getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(BlkListRequestHead header) {
		this.header = header;
	}

	/**
	 * @return the busiData
	 */
	public String getBusiData() {
		return busiData;
	}

	/**
	 * @param busiData the busiData to set
	 */
	public void setBusiData(String busiData) {
		this.busiData = busiData;
	}

	/**
	 * @return the securityInfo
	 */
	public BlkListRequestSecurityInfo getSecurityInfo() {
		return securityInfo;
	}

	/**
	 * @param securityInfo the securityInfo to set
	 */
	public void setSecurityInfo(BlkListRequestSecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}
	
}
