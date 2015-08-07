package com.ctc.credit.blackgreylist.model;

public class XlsCheckReturnEntity {

	/** xls上传数据返回结果--成功  **/
	public static final String RES_SUCCESS = "A";
	
	public static final String RES_SUCCESS_STR = "文件上传成功";

	/** xls上传数据返回结果 -- 错误**/
	public static final String RES_DEFEAT = "F";
	
	public static final String RES_DEFEAT_STR = "文件上传失败";
	
	/** xls上传数据保存失败 **/
	public static final String RES_DEFEAT_SAVE_ERR = "xls文件 数据保存失败";
	
	/** 检查结果 **/
	private String resultMsg;
	
	/** 错误信息 **/
	private String errorMsg;
	
	/** 成功保存条数 **/
	private Integer successDataCount;

	/**
	 * @return the resultMsg
	 */
	public String getResultMsg() {
		return resultMsg;
	}

	/**
	 * @param resultMsg the resultMsg to set
	 */
	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the successDataCount
	 */
	public Integer getSuccessDataCount() {
		return successDataCount;
	}

	/**
	 * @param successDataCount the successDataCount to set
	 */
	public void setSuccessDataCount(Integer successDataCount) {
		this.successDataCount = successDataCount;
	}
	
}
