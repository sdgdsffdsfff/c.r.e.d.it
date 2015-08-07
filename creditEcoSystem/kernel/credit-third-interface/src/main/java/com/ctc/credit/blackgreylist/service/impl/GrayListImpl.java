package com.ctc.credit.blackgreylist.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IAbstractBlackMatchChain;
import com.ctc.credit.blackgreylist.service.IAbstractGrayMatchChain;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IRoleInfo;


@Service
@Transactional
public class GrayListImpl implements IDangerList {
	
	Map<String,IRoleInfo> roleInfos = null;
	
	IAbstractGrayMatchChain roleMatchChain = null;

	@Override
	public int initDangerList(CreditBlkgraylistDetailEntity initList) {
		// TODO Auto-generated method stub
		IRoleInfo roleInfo = roleInfos.get(initList.getCategoryDesc());
		roleInfo.initDangerList(initList);
		return 0;
	}

	@Override
	public List<Map<String, Object>> matchDangerList(HandleRequest handRequest) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
		List<Map<String,Object>> matchResult = roleMatchChain.doMatch(handRequest);
		res.addAll(matchResult);
		return res;
	}

	@Override
	public Map<String, IRoleInfo> getRoleInfos() {
		// TODO Auto-generated method stub
		return roleInfos;
	}

	@Override
	public void setRoleInfos(Map<String, IRoleInfo> roleInfos) {
		// TODO Auto-generated method stub
		this.roleInfos = roleInfos;
	}

	@Override
	public IAbstractBlackMatchChain getRoleMatchChain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoleMatchChain(IAbstractBlackMatchChain roleMatchChain) {
		// TODO Auto-generated method stub
	}

	@Override
	public void setGrayRoleMatchChain(IAbstractGrayMatchChain roleMatchChain) {
		// TODO Auto-generated method stub
		this.roleMatchChain = roleMatchChain;
	}

	@Override
	public IAbstractGrayMatchChain getGrayRoleMatchChain() {
		// TODO Auto-generated method stub
		return roleMatchChain;
	}


}
