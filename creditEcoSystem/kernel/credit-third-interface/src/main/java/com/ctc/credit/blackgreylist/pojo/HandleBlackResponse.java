package com.ctc.credit.blackgreylist.pojo;

import com.ctc.credit.blackgreylist.constant.ResponseStatusEnum;

public class HandleBlackResponse {
	
	private ResponseStatusEnum status;
	
	private String message;
	
	private String rejectCode;
	
	private String rejectInfo;
	
	private String rejectTigger;

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

	public String getRejectCode() {
		return rejectCode;
	}

	public void setRejectCode(String rejectCode) {
		this.rejectCode = rejectCode;
	}

	public String getRejectInfo() {
		return rejectInfo;
	}

	public void setRejectInfo(String rejectInfo) {
		this.rejectInfo = rejectInfo;
	}

	public String getRejectTigger() {
		return rejectTigger;
	}

	public void setRejectTigger(String rejectTigger) {
		this.rejectTigger = rejectTigger;
	}
	
	
	
}