package com.ctc.credit.blackgreylist.factory;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.constant.GrayListEnum;
import com.ctc.credit.blackgreylist.service.IAbstractGrayMatchChain;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.IRoleInfo;
import com.ctc.credit.blackgreylist.service.RoleInfo.IdentityLeakageRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.IllegalSalesIntoRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.InterbankBusinessDepartmentRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.SuspectedFraudARoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.SuspectedFraudBRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.SuspectedFraudCRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.SuspectedFraudDRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.RoleInfo.TimeoutTrunToGreyRoleInfoImpl;
import com.ctc.credit.blackgreylist.service.grayChain.AddressAndNameMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.CompanyInfoMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.GrayCustomerIdMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.MobileAndHomePhoneMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.NameAndDepAddressMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.PersonalCompanyInfoMatchChain;
import com.ctc.credit.blackgreylist.service.grayChain.PersonalInfoMatchChain;
import com.ctc.credit.common.SpringContextHelper;


@Component
public class GrayNameListBuilder  implements IDangerNameListBuilder {
	
	private IDangerList dangerList;
	
	@Override
	public void createDangerList() {
		// TODO Auto-generated method stub
		dangerList = (IDangerList)SpringContextHelper.getBean("grayListImpl");
		System.out.println(System.identityHashCode(dangerList));
	}

	@Override
	public void createRoleInfos() {
		//
		if(dangerList.getRoleInfos() == null){
			Map<String,IRoleInfo> roleInfos = new HashMap<String,IRoleInfo>();
			roleInfos.put(GrayListEnum.IdentityLeakage.getGrayListName(), (IdentityLeakageRoleInfoImpl)SpringContextHelper.getBean("identityLeakageRoleInfoImpl"));
			roleInfos.put(GrayListEnum.IllegalSalesPersonnelIntoPieces.getGrayListName(), (IllegalSalesIntoRoleInfoImpl)SpringContextHelper.getBean("illegalSalesIntoRoleInfoImpl"));
			roleInfos.put(GrayListEnum.InterbankBusinessDepartment.getGrayListName(), (InterbankBusinessDepartmentRoleInfoImpl)SpringContextHelper.getBean("interbankBusinessDepartmentRoleInfoImpl"));
			roleInfos.put(GrayListEnum.SuspectedFraudA.getGrayListName(), (SuspectedFraudARoleInfoImpl)SpringContextHelper.getBean("suspectedFraudARoleInfoImpl"));
			roleInfos.put(GrayListEnum.SuspectedFraudB.getGrayListName(), (SuspectedFraudBRoleInfoImpl)SpringContextHelper.getBean("suspectedFraudBRoleInfoImpl"));
			roleInfos.put(GrayListEnum.SuspectedFraudC.getGrayListName(), (SuspectedFraudCRoleInfoImpl)SpringContextHelper.getBean("suspectedFraudCRoleInfoImpl"));
			roleInfos.put(GrayListEnum.SuspectedFraudD.getGrayListName(), (SuspectedFraudDRoleInfoImpl)SpringContextHelper.getBean("suspectedFraudDRoleInfoImpl"));
			roleInfos.put(GrayListEnum.TimeoutTrunToGrey.getGrayListName(), (TimeoutTrunToGreyRoleInfoImpl)SpringContextHelper.getBean("timeoutTrunToGreyRoleInfoImpl"));
			dangerList.setRoleInfos(roleInfos);
		}
	}

	@Override
	public void createMatchChain() {
		// TODO Auto-generated method stub
		if(dangerList.getRoleMatchChain() == null ){
			IAbstractGrayMatchChain addressAndNameMatchChain = (AddressAndNameMatchChain)SpringContextHelper.getBean("addressAndNameMatchChain");
			IAbstractGrayMatchChain companyInfoMatchChain = (CompanyInfoMatchChain)SpringContextHelper.getBean("companyInfoMatchChain");
			IAbstractGrayMatchChain grayCustomerIdMatchChain = (GrayCustomerIdMatchChain)SpringContextHelper.getBean("grayCustomerIdMatchChain");
			IAbstractGrayMatchChain mobileAndHomePhoneMatchChain = (MobileAndHomePhoneMatchChain)SpringContextHelper.getBean("mobileAndHomePhoneMatchChain");
			IAbstractGrayMatchChain nameAndDepAddressMatchChain = (NameAndDepAddressMatchChain)SpringContextHelper.getBean("nameAndDepAddressMatchChain");
			IAbstractGrayMatchChain personalCompanyInfoMatchChain = (PersonalCompanyInfoMatchChain)SpringContextHelper.getBean("personalCompanyInfoMatchChain");
			IAbstractGrayMatchChain personalInfoMatchChain = (PersonalInfoMatchChain)SpringContextHelper.getBean("personalInfoMatchChain");
			
			addressAndNameMatchChain.setNextChain(companyInfoMatchChain);
			companyInfoMatchChain.setNextChain(grayCustomerIdMatchChain);
			grayCustomerIdMatchChain.setNextChain(mobileAndHomePhoneMatchChain);
			mobileAndHomePhoneMatchChain.setNextChain(nameAndDepAddressMatchChain);
			nameAndDepAddressMatchChain.setNextChain(personalCompanyInfoMatchChain);
			personalCompanyInfoMatchChain.setNextChain(personalInfoMatchChain);
			dangerList.setGrayRoleMatchChain(addressAndNameMatchChain);
		}
	}

	@Override
	public IDangerList getDangerList() {
		// TODO Auto-generated method stub
		return dangerList;
	}

}
