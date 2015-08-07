package com.ctc.credit.tongdun.pojo;

import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDetailDto;


public class HandleTdRiskApiDetailResponse {
	private String p_id;
	private TongDunResRiskApiDetailDto tongDunResRiskApiDetailDto;
	
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public TongDunResRiskApiDetailDto getTongDunResRiskApiDetailDto() {
		return tongDunResRiskApiDetailDto;
	}
	public void setTongDunResRiskApiDetailDto(
			TongDunResRiskApiDetailDto tongDunResRiskApiDetailDto) {
		this.tongDunResRiskApiDetailDto = tongDunResRiskApiDetailDto;
	}
	
	
	
}
