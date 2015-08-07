package com.ctc.credit.blackgreylist.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.constant.BlackListEnum;
import com.ctc.credit.blackgreylist.service.IAbstractBlackMatchChain;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IRoleInfo;
import com.ctc.credit.blackgreylist.service.RoleInfo.BadHabitsCustomerRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.BadUnitsRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.CollapseOfFactoryRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.CustomerFraudRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.DepartmentFeedRolInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.DepartmentRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.FamilyOppositionRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.FrenchOpenFailRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.InternalBadCusRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.InternalStaffRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.MaliciousRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.NetworkCustomerRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.OnThePhoneRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.OutSideCreditRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.blackChain.ComInfoMatchChain;
import com.ctc.credit.blackgreylist.service.blackChain.CompanyNameMatchChain;
import com.ctc.credit.blackgreylist.service.blackChain.HomePhoneAndMobileMatchChain;
import com.ctc.credit.blackgreylist.service.blackChain.IdNumberMatchChain;
import com.ctc.credit.blackgreylist.service.blackChain.MobileAndNameMatchChain;
import com.ctc.credit.blackgreylist.service.blackChain.NameAndEncIDNumberMatchChain;
import com.ctc.credit.common.SpringContextHelper;

@Component
public class BlackNameListBuilder implements IDangerNameListBuilder {

	private IDangerList dangerList;
	
	@Override
	public void createRoleInfos() {
		// TODO Auto-generated method stub
		if(dangerList.getRoleInfos() == null){
			Map<String,IRoleInfo> roleInfos = new HashMap<String,IRoleInfo>();
			roleInfos.put(BlackListEnum.BadHabitsOfCustomers.getRejectCode(), (BadHabitsCustomerRoleInfoImpl)SpringContextHelper.getBean("badHabitsCustomerRoleInfoImpl"));
			roleInfos.put(BlackListEnum.BadUnits.getRejectCode(), (BadUnitsRoleInfoImpl)SpringContextHelper.getBean("badUnitsRoleInfoImpl"));
			roleInfos.put(BlackListEnum.CustomerFraud.getRejectCode(), (CustomerFraudRoleInfoImpl)SpringContextHelper.getBean("customerFraudRoleInfoImpl"));
			roleInfos.put(BlackListEnum.DepartmentFeedbackPeer.getRejectCode(), (DepartmentFeedRolInfoImpl)SpringContextHelper.getBean("departmentFeedRolInfoImpl"));
			roleInfos.put(BlackListEnum.FamilyOppositionLoanCustomers.getRejectCode(), (FamilyOppositionRoleInfoImpl)SpringContextHelper.getBean("familyOppositionRoleInfoImpl"));
			roleInfos.put(BlackListEnum.FrenchOpenFail.getRejectCode(), (FrenchOpenFailRoleInfoImpl)SpringContextHelper.getBean("frenchOpenFailRoleInfoImpl"));
			roleInfos.put(BlackListEnum.InternalStaff.getRejectCode(), (InternalStaffRoleInfoImpl)SpringContextHelper.getBean("internalStaffRoleInfoImpl"));
			roleInfos.put(BlackListEnum.MaliciousCustomerComplaints.getRejectCode(), (MaliciousRoleInfoImpl)SpringContextHelper.getBean("maliciousRoleInfoImpl"));
			roleInfos.put(BlackListEnum.NetworkCustomer.getRejectCode(), (NetworkCustomerRoleInfoImpl)SpringContextHelper.getBean("networkCustomerRoleInfoImpl"));
			roleInfos.put(BlackListEnum.OnThePhoneBlacklist.getRejectCode(), (OnThePhoneRoleInfoImpl)SpringContextHelper.getBean("onThePhoneRoleInfoImpl"));
			roleInfos.put(BlackListEnum.OutsideCreditList.getRejectCode(), (OutSideCreditRoleInfoImpl)SpringContextHelper.getBean("outSideCreditRoleInfoImpl"));
			roleInfos.put(BlackListEnum.TheCollapseOfTheFactory.getRejectCode(), (CollapseOfFactoryRoleInfoImpl)SpringContextHelper.getBean("collapseOfFactoryRoleInfoImpl"));
			roleInfos.put(BlackListEnum.TheInternalBadCustomers.getRejectCode(), (InternalBadCusRoleInfoImpl)SpringContextHelper.getBean("internalBadCusRoleInfoImpl"));
			roleInfos.put(BlackListEnum.TheInternalBusinessDepartmentRefused.getRejectCode(), (DepartmentRoleInfoImpl)SpringContextHelper.getBean("departmentRoleInfoImpl"));
			dangerList.setRoleInfos(roleInfos);
		}
	}

	@Override
	public void createMatchChain() {
		// TODO Auto-generated method stub
		if(dangerList.getRoleMatchChain() == null ){
			IAbstractBlackMatchChain idNumberMatchChain = (IdNumberMatchChain)SpringContextHelper.getBean("idNumberMatchChain");
			IAbstractBlackMatchChain mobileAndNameMatchChain = (MobileAndNameMatchChain)SpringContextHelper.getBean("mobileAndNameMatchChain");
			IAbstractBlackMatchChain nameAndEncIDNumberMatchChain = (NameAndEncIDNumberMatchChain)SpringContextHelper.getBean("nameAndEncIDNumberMatchChain");
			IAbstractBlackMatchChain nameEncIDNumberMatchChian = (CompanyNameMatchChain)SpringContextHelper.getBean("companyNameMatchChain");
			IAbstractBlackMatchChain comInfoMatchChain = (ComInfoMatchChain)SpringContextHelper.getBean("comInfoMatchChain");
			IAbstractBlackMatchChain homePhoneAndMobileMatchChain = (HomePhoneAndMobileMatchChain)SpringContextHelper.getBean("homePhoneAndMobileMatchChain");
			
			idNumberMatchChain.setNextChain(mobileAndNameMatchChain);
			mobileAndNameMatchChain.setNextChain(nameAndEncIDNumberMatchChain);
			nameAndEncIDNumberMatchChain.setNextChain(nameEncIDNumberMatchChian);
			nameEncIDNumberMatchChian.setNextChain(comInfoMatchChain);
			comInfoMatchChain.setNextChain(homePhoneAndMobileMatchChain);
			
			dangerList.setRoleMatchChain(idNumberMatchChain);
		}
	}

	@Override
	public IDangerList getDangerList() {
		// TODO Auto-generated method stub
		return dangerList;
	}

	@Override
	public void createDangerList() {
		dangerList = (IDangerList)SpringContextHelper.getBean("blackListImpl");
		System.out.println(System.identityHashCode(dangerList));
	}

}
