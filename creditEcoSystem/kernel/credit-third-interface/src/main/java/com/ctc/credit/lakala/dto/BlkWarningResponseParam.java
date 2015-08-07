package com.ctc.credit.lakala.dto;

public class BlkWarningResponseParam {
	//几家单位上传数据
	private String dwCount;
	
	//被上传次数
	private String scCount;
	
	//最新更新时间
	private String newDate;
	
	//黑名单事件(对应最新更新时间记录)
	private String hmdSj;
	
	//黑名单事件备注(对应最新更新时间记录)
	private String hmdSjBz;

	
	public String getDwCount() {
		return dwCount;
	}

	public void setDwCount(String dwCount) {
		this.dwCount = dwCount;
	}

	public String getScCount() {
		return scCount;
	}

	public void setScCount(String scCount) {
		this.scCount = scCount;
	}

	public String getNewDate() {
		return newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}

	public String getHmdSj() {
		return hmdSj;
	}

	public void setHmdSj(String hmdSj) {
		this.hmdSj = hmdSj;
	}

	public String getHmdSjBz() {
		return hmdSjBz;
	}

	public void setHmdSjBz(String hmdSjBz) {
		this.hmdSjBz = hmdSjBz;
	}
	
	
}
