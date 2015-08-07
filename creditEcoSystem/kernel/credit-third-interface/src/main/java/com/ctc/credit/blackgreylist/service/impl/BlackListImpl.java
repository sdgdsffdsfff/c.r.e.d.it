package com.ctc.credit.blackgreylist.service.impl;
		
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.constant.BlackListEnum;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IAbstractBlackMatchChain;
import com.ctc.credit.blackgreylist.service.IAbstractGrayMatchChain;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IRoleInfo;

@Service
@Transactional
public class BlackListImpl implements IDangerList {
	
	private static Map<String,String> regCodeMap = new HashMap<String,String>();
	static {
		regCodeMap.put(BlackListEnum.BadHabitsOfCustomers.getBlackListName(),BlackListEnum.BadHabitsOfCustomers.getRejectCode());
		regCodeMap.put(BlackListEnum.BadUnits.getBlackListName(),BlackListEnum.BadUnits.getRejectCode());
		regCodeMap.put(BlackListEnum.CustomerFraud.getBlackListName(),BlackListEnum.CustomerFraud.getRejectCode());
		regCodeMap.put(BlackListEnum.DepartmentFeedbackPeer.getBlackListName(),BlackListEnum.DepartmentFeedbackPeer.getRejectCode());
		regCodeMap.put(BlackListEnum.FamilyOppositionLoanCustomers.getBlackListName(),BlackListEnum.FamilyOppositionLoanCustomers.getRejectCode());
		regCodeMap.put(BlackListEnum.FrenchOpenFail.getBlackListName(),BlackListEnum.FrenchOpenFail.getRejectCode());
		regCodeMap.put(BlackListEnum.InternalStaff.getBlackListName(),BlackListEnum.InternalStaff.getRejectCode());
		regCodeMap.put(BlackListEnum.MaliciousCustomerComplaints.getBlackListName(),BlackListEnum.MaliciousCustomerComplaints.getRejectCode());
		regCodeMap.put(BlackListEnum.NetworkCustomer.getBlackListName(),BlackListEnum.NetworkCustomer.getRejectCode());
		regCodeMap.put(BlackListEnum.OnThePhoneBlacklist.getBlackListName(),BlackListEnum.OnThePhoneBlacklist.getRejectCode());
		regCodeMap.put(BlackListEnum.OutsideCreditList.getBlackListName(),BlackListEnum.OutsideCreditList.getRejectCode());
		regCodeMap.put(BlackListEnum.TheCollapseOfTheFactory.getBlackListName(),BlackListEnum.TheCollapseOfTheFactory.getRejectCode());
		regCodeMap.put(BlackListEnum.TheInternalBadCustomers.getBlackListName(),BlackListEnum.TheInternalBadCustomers.getRejectCode());
		regCodeMap.put(BlackListEnum.TheInternalBusinessDepartmentRefused.getBlackListName(),BlackListEnum.TheInternalBusinessDepartmentRefused.getRejectCode());
	}
	
	Map<String,IRoleInfo> roleInfos = null;
	
	IAbstractBlackMatchChain roleMatchChain = null;
	
	@Override
	public Map<String, IRoleInfo> getRoleInfos() {
		return roleInfos;
	}

	@Override
	public void setRoleInfos(Map<String, IRoleInfo> roleInfos) {
		this.roleInfos = roleInfos;
	}

	@Override
	public IAbstractBlackMatchChain getRoleMatchChain() {
		return roleMatchChain;
	}

	@Override
	public void setRoleMatchChain(IAbstractBlackMatchChain roleMatchChain) {
		this.roleMatchChain = roleMatchChain;
	}

	
	
	@Override
	public int initDangerList(CreditBlkgraylistDetailEntity initList) {
		// TODO Auto-generated method stub
		IRoleInfo roleInfo = roleInfos.get(regCodeMap.get(initList.getCategoryDesc()));
		roleInfo.initDangerList(initList);
		return 0;
	}

	@Override
	public List<Map<String, Object>> matchDangerList(HandleRequest handRequest) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> res = new ArrayList<Map<String,Object>>();
		Map<String,Object> matchResult = roleMatchChain.doMatch(handRequest);
		res.add(matchResult);
		return res;
	}

	@Override
	public void setGrayRoleMatchChain(IAbstractGrayMatchChain roleMatchChain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public IAbstractGrayMatchChain getGrayRoleMatchChain() {
		// TODO Auto-generated method stub
		return null;
	}


}
