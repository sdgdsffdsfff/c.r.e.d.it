package com.ctc.credit.tongdun.pojo;

import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDto;


public class HandleTdRiskApiRequest{
	private String others_value;
	private TongDunReqRiskApiDto tongDunReqRiskApiDto;

	public TongDunReqRiskApiDto getTongDunReqRiskApiDto() {
		return tongDunReqRiskApiDto;
	}

	public void setTongDunReqRiskApiDto(TongDunReqRiskApiDto tongDunReqRiskApiDto) {
		this.tongDunReqRiskApiDto = tongDunReqRiskApiDto;
	}

	public String getOthers_value() {
		return others_value;
	}

	public void setOthers_value(String others_value) {
		this.others_value = others_value;
	}
	
	
}
