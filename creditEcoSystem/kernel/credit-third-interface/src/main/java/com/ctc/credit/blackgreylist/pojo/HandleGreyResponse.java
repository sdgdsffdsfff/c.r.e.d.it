package com.ctc.credit.blackgreylist.pojo;

import java.util.List;

import com.ctc.credit.blackgreylist.constant.ResponseStatusEnum;

public class HandleGreyResponse {
	
	private ResponseStatusEnum status;
	
	private String message;
	
	private List<GreyListResponseInfo> greyListInfo;

	public ResponseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusEnum status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<GreyListResponseInfo> getGreyListInfo() {
		return greyListInfo;
	}

	public void setGreyListInfo(List<GreyListResponseInfo> greyListInfo) {
		this.greyListInfo = greyListInfo;
	}
	
	
}
