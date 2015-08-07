package com.ctc.credit.lakala.dto;

public class RequestHead {
	//客户号
	private String customerId;
	
	//产品组编码
	private String prdGrpId;
	
	//产品编码
	private String prdId;
	
	//业务数据
	private String reqData;
	
	//签名结果
	private String sign;
	
	
	public RequestHead(String reqData,String customerId,String prdGrpId,String prdId,String sign){
		this.reqData = reqData;
		this.customerId = customerId;
		this.prdGrpId = prdGrpId;
		this.prdId = prdId;
		this.sign = sign;
	}
	
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getPrdGrpId() {
		return prdGrpId;
	}
	public void setPrdGrpId(String prdGrpId) {
		this.prdGrpId = prdGrpId;
	}
	public String getPrdId() {
		return prdId;
	}
	public void setPrdId(String prdId) {
		this.prdId = prdId;
	}
	public String getReqData() {
		return reqData;
	}
	public void setReqData(String reqData) {
		this.reqData = reqData;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	
	
}
