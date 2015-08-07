package com.ctc.credit.blackgreylist.service.RoleInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.constant.GrayListEnum;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;
import com.ctc.credit.blackgreylist.service.IRoleInfo;


/**
 * 疑似欺诈客户灰名单D
 * @author zhangwenjun
 *
 */
@Component
public class SuspectedFraudDRoleInfoImpl implements IRoleInfo{

	private GrayListEnum grayName = GrayListEnum.SuspectedFraudD;
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	
	@Override
	public void initDangerList(
			CreditBlkgraylistDetailEntity initList) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String td = sdf.format(today);
		
		CreditBlkgraylistRoleEntity cre = new CreditBlkgraylistRoleEntity();
		if(initList != null && initList.getCustMobile() != null && !initList.getCustMobile().isEmpty()){
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("手机号码");
		cre.setTiggerInfo(initList.getCustMobile());
		cre.setTiggerType(1);
		cre.setRoleIndex(1);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		
		if(initList != null && initList.getCustHomePhone() != null && !initList.getCustHomePhone().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("住宅电话");
		cre.setTiggerInfo(initList.getCustHomePhone());
		cre.setTiggerType(1);
		cre.setRoleIndex(2);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		
	}

	
	@Override
	public String getBlackNameDES() {
		// TODO Auto-generated method stub
		return grayName.getGrayListName();
	}
}
