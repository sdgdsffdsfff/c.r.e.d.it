package com.ctc.credit.blackgreylist.constant;

public enum ResponseStatusEnum {
	Exception("500"),
	Match("000"),
	UnMatch("001");
	
	private String code;
	
	private ResponseStatusEnum(String code){
		this.code = code;
	}
	
	public String getCode(){
		return code;
	}
	
}
