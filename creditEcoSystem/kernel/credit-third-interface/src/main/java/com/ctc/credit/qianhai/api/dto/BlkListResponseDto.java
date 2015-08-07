package com.ctc.credit.qianhai.api.dto;

/**
 * 前海征信返回报文对象
 * @author sunny
 *
 */
public class BlkListResponseDto {

	private BlkListResponseHead header;
	
	private String busiData;
	
	private BlkListResponseSecurityInfo securityInfo;

	/**
	 * @return the header
	 */
	public BlkListResponseHead getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(BlkListResponseHead header) {
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
	public BlkListResponseSecurityInfo getSecurityInfo() {
		return securityInfo;
	}

	/**
	 * @param securityInfo the securityInfo to set
	 */
	public void setSecurityInfo(BlkListResponseSecurityInfo securityInfo) {
		this.securityInfo = securityInfo;
	}

}
