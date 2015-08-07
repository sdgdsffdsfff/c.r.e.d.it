package com.ctc.credit.bairong.api.dto.consumption;

import java.util.ArrayList;

/**
 * 百融：商品消费评估dto
 * @author danggang
 *
 */
public class ConsumptionDto {
	
	/** 流水账单**/
	private String swiftNumber;
	
	/** 商品消费评估类型**/
	private ArrayList<AssessmentDto> assessmentType;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public ArrayList<AssessmentDto> getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(ArrayList<AssessmentDto> assessmentType) {
		this.assessmentType = assessmentType;
	}

	
}
