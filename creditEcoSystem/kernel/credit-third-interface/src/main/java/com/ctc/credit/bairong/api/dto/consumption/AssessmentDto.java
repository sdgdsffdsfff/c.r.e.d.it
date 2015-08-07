package com.ctc.credit.bairong.api.dto.consumption;

import java.util.ArrayList;

public class AssessmentDto {
	
	/** 商品消费评估**/
	private String assessmentType;
	
	/** 商品类型**/
	private ArrayList<CommodityTypeDto> commodityTypeDto;
	
	/** 商品消费级别排名**/
	private ArrayList<LevelDto> levelDto;

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public ArrayList<CommodityTypeDto> getCommodityTypeDto() {
		return commodityTypeDto;
	}

	public void setCommodityTypeDto(ArrayList<CommodityTypeDto> commodityTypeDto) {
		this.commodityTypeDto = commodityTypeDto;
	}

	public ArrayList<LevelDto> getLevelDto() {
		return levelDto;
	}

	public void setLevelDto(ArrayList<LevelDto> levelDto) {
		this.levelDto = levelDto;
	}
	
	
}
