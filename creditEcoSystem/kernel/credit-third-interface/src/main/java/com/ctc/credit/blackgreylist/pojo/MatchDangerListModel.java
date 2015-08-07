package com.ctc.credit.blackgreylist.pojo;

import java.util.Map;

import com.ctc.credit.blackgreylist.constant.ResponseStatusEnum;

public class MatchDangerListModel {
	public ResponseStatusEnum status;
	
	public Map<String,String> mactchInfo;

	public ResponseStatusEnum getStatus() {
		return status;
	}

	public void setStatus(ResponseStatusEnum status) {
		this.status = status;
	}

	public Map<String, String> getMactchInfo() {
		return mactchInfo;
	}

	public void setMactchInfo(Map<String, String> mactchInfo) {
		this.mactchInfo = mactchInfo;
	}
	
}
