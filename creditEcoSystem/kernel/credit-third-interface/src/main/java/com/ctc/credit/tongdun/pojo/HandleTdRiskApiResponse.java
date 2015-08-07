package com.ctc.credit.tongdun.pojo;

import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDto;




public class HandleTdRiskApiResponse {
	private String p_id;
	
	private TongDunResRiskApiDto tongDunResRiskApiDto;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	
	public TongDunResRiskApiDto getTongDunResRiskApiDto() {
		return tongDunResRiskApiDto;
	}
	public void setTongDunResRiskApiDto(TongDunResRiskApiDto tongDunResRiskApiDto) {
		this.tongDunResRiskApiDto = tongDunResRiskApiDto;
	} 
	
	
	
	
}
