package com.ctc.credit.bairong.api.dto.consumption;

import java.util.ArrayList;

public class CommodityTypeDto {

	private String commodityType;
	
	private ArrayList<EvaluationContentDto> evaluationContentDto;

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public ArrayList<EvaluationContentDto> getEvaluationContentDto() {
		return evaluationContentDto;
	}

	public void setEvaluationContentDto(ArrayList<EvaluationContentDto> evaluationContentDto) {
		this.evaluationContentDto = evaluationContentDto;
	}
	
	
}
