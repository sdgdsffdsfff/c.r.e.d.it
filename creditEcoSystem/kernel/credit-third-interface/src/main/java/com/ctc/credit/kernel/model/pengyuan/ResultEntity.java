package com.ctc.credit.kernel.model.pengyuan;

import java.io.Serializable;

import net.sf.json.JSONArray;


/**
 * 
 * 通用接口返回信息实体对象
 * @author sunny
 *
 */
public class ResultEntity implements Serializable {
	
	private static final long serialVersionUID = -7898848019494231029L;

	/** 
	 * <pre>
	 * 001:正常有数据返回,
	 * 002:正常无数据返回,
	 * 003：参数不完整,
	 * 004:请求超时,
	 * 005:网络异常
	 * 006:其他
	 * </pre>
	 */
	private String returnCode;
	
	/**
	 * 返回数据Json对象
	 */
	private JSONArray returnData;
	
	/**
	 * 数据返回详细信息
	 */
	private String returnMsg;
	
	/**
	 * 数据返回备注
	 */
	private String returnMemo;

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public Object getReturnData() {
		return returnData;
	}

	public void setReturnData(JSONArray returnData) {
		this.returnData = returnData;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getReturnMemo() {
		return returnMemo;
	}

	public void setReturnMemo(String returnMemo) {
		this.returnMemo = returnMemo;
	}

}
