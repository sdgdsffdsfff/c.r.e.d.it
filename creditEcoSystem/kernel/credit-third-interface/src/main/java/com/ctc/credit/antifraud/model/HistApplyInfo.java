package com.ctc.credit.antifraud.model;

import java.util.ArrayList;
import java.util.List;

public class HistApplyInfo {
	
	/** 查询成功  **/
	public static String SUCCESS_MSG = "查询成功";
	
	/** 未查的数据 **/
	public static String NODATA_MSG = "未查的数据";
	
	/** 数据查询异常 **/
	public static String EXCPT_MSG_DBERROR = "数据查询异常";
	
	public static String EXCPT_MSG_HANDLE_ERROR = "数据转换异常";
	
	/** 未查的数据 **/
	public static String NO_DATA = "0"; 
	
	/** 查的数据 **/
	public static String DATA_GOT = "1"; 
	
	/** 异常 **/
	public static String EXCEPTION = "2"; 
	
	public HistApplyInfo() {
		this.resultStatus = "1";
		this.resultMsg = HistApplyInfo.SUCCESS_MSG;
	}

	/** 结果状态 
	 *0-	未查的
	 *1-	查的
	 *2-	异常
	 **/
	private String resultStatus;
	
	/** 结果信息 **/
	private String resultMsg;

	/** 申请单号 **/
	private String applyCode;
	
	/** 来源系统 **/
	private String sourceSys;
	
	/** 客户信息 **/
	private HistCustomerInfo customerInfo;
	
	/** 联系人信息 **/
	private List<HistContactInfo> contactInfo = new ArrayList<HistContactInfo>();
	

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
	 * @return the sourceSys
	 */
	public String getSourceSys() {
		return sourceSys;
	}

	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(String sourceSys) {
		this.sourceSys = sourceSys;
	}

	/**
	 * @return the customerInfo
	 */
	public HistCustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	/**
	 * @param customerInfo the customerInfo to set
	 */
	public void setCustomerInfo(HistCustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	/**
	 * @return the contactInfo
	 */
	public List<HistContactInfo> getContactInfo() {
		return contactInfo;
	}

	/**
	 * @param contactInfo the contactInfo to set
	 */
	public void setContactInfo(List<HistContactInfo> contactInfo) {
		this.contactInfo = contactInfo;
	}

	
	/**
	 * @return the resultStatus
	 */
	public String getResultStatus() {
		return resultStatus;
	}

	/**
	 * @param resultStatus the resultStatus to set
	 */
	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

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

//	public static void main(String[] args) {
//		HistApplyInfo histApplyInfo  = new HistApplyInfo();
//		HistContactInfo histContactInfo = new HistContactInfo();
//		histApplyInfo.getContactInfo().add(histContactInfo);
//		System.out.println(JSONObject.fromObject(histApplyInfo));
//	}
}
