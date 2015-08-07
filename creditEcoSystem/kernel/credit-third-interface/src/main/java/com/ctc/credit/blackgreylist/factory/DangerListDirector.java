package com.ctc.credit.blackgreylist.factory;

import com.ctc.credit.blackgreylist.service.IDangerList;

public class DangerListDirector {
	
	private IDangerNameListBuilder builder;
	
	private static IDangerList dangerList;
	
	public DangerListDirector(IDangerNameListBuilder builder){
		this.builder = builder;
	}
	
	public IDangerList createDangerList(){
		builder.createDangerList();
		builder.createMatchChain();
		builder.createRoleInfos();
		return dangerList =  builder.getDangerList();
	}
}
