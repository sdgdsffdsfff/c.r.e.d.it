package com.ctc.credit.bairong.api.dto;

import java.util.List;

public class SpecialListDto {
	/** 流水号 **/
	private String swiftNo;
	
	/** （银行和非银）信贷申请次数 **/
	private List<DegreeDto> degreeList;
	
	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	public List<DegreeDto> getDegreeList() {
		return degreeList;
	}

	public void setDegreeList(List<DegreeDto> degreeList) {
		this.degreeList = degreeList;
	}
	
}
