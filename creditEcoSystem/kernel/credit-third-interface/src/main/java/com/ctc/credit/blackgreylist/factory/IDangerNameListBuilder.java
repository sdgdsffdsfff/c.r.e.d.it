package com.ctc.credit.blackgreylist.factory;

import java.util.Map;

import com.ctc.credit.blackgreylist.service.IAbstractBlackMatchChain;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IRoleInfo;

public interface IDangerNameListBuilder {
	
	public void createDangerList();
	
	public void createRoleInfos();
	
	public void createMatchChain();
	
	public IDangerList getDangerList();
	
}
