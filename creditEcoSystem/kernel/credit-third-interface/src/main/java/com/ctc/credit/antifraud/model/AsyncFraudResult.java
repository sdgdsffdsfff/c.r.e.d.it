package com.ctc.credit.antifraud.model;


/**
 * 反欺诈返回结果:异步
 * 
 * @author sunny
 *
 */
public class AsyncFraudResult {
	
	/** 申请单号 **/
	private String applyCode;
	
	/** 反欺诈异步接口结果  0:失败；1：成功；2：异常 **/
	private String result;
	
	/** 提示信息**/
	private String message;

	/**
	 * @return the applyCode
	 */
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
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	
}
