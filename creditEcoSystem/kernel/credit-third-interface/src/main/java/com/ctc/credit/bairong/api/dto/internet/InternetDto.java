package com.ctc.credit.bairong.api.dto.internet;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

public class InternetDto {
		
	/** 流水账单**/
	private String swiftNumber;
	
	/** city:地级市（国家&省市&地级市）**/
	private String city;
	
	private InternetStatisticsDto internetStatisticsDto;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public InternetStatisticsDto getInternetStatisticsDto() {
		return internetStatisticsDto;
	}

	public void setInternetStatisticsDto(InternetStatisticsDto internetStatisticsDto) {
		this.internetStatisticsDto = internetStatisticsDto;
	}

	


}
