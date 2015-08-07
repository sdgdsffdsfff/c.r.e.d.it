package com.ctc.credit.bairong.api.dto.online;

import java.util.ArrayList;

public class OnlineDto {

	/** 流水账单**/
	private String swiftNumber;
	
	private ArrayList<NodeOneDto> nodeOne;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public ArrayList<NodeOneDto> getNodeOne() {
		return nodeOne;
	}

	public void setNodeOne(ArrayList<NodeOneDto> nodeOne) {
		this.nodeOne = nodeOne;
	}

	
	
	
}
