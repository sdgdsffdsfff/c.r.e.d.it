package com.ctc.credit.bairong.api.dto.online;

import java.util.ArrayList;

public class NodeTwoDto {

	private String nodeTwo;
	
	private ArrayList<OnlineNoDaysDto> onlineNoDays;

	public String getNodeTwo() {
		return nodeTwo;
	}

	public void setNodeTwo(String nodeTwo) {
		this.nodeTwo = nodeTwo;
	}

	public ArrayList<OnlineNoDaysDto> getOnlineNoDays() {
		return onlineNoDays;
	}

	public void setOnlineNoDays(ArrayList<OnlineNoDaysDto> onlineNoDays) {
		this.onlineNoDays = onlineNoDays;
	}
	
	
}
