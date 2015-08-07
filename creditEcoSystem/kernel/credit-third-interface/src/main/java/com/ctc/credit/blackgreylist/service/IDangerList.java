package com.ctc.credit.blackgreylist.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;

public interface IDangerList {
	
	/**
	 * 初始化黑灰名单
	 * @param initList
	 * @return
	 */
	public int initDangerList(CreditBlkgraylistDetailEntity initList);
	
	
	/**
	 * 匹配黑灰名单
	 * @return List<Map<String,Object>>
	 * 每个 MAP 用于匹配的 key 和 匹配到的 黑灰名单 Enum
	 */
	public List<Map<String,Object>> matchDangerList(HandleRequest handRequest);
	
	public Map<String, IRoleInfo> getRoleInfos();
	
	public void setRoleInfos(Map<String, IRoleInfo> roleInfos);
	
	public IAbstractBlackMatchChain getRoleMatchChain();
	
	public void setRoleMatchChain(IAbstractBlackMatchChain roleMatchChain);
	
	public void setGrayRoleMatchChain(IAbstractGrayMatchChain roleMatchChain);
	
	public IAbstractGrayMatchChain getGrayRoleMatchChain();
	
}
