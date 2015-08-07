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
 * 疑似欺诈客户灰名单A
 * @author zhangwenjun
 *
 */
@Component
public class SuspectedFraudARoleInfoImpl implements IRoleInfo{

	private GrayListEnum grayName = GrayListEnum.SuspectedFraudA;
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	
	@Override
	public void initDangerList(
			CreditBlkgraylistDetailEntity initList) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String td = sdf.format(today);
		

		CreditBlkgraylistRoleEntity cre = new CreditBlkgraylistRoleEntity();
		if(initList != null && initList.getCustIdnum() != null && !initList.getCustIdnum().isEmpty()){
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("身份证号");
		cre.setTiggerInfo(initList.getCustIdnum());
		cre.setTiggerType(1);
		cre.setRoleIndex(1);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getCustMobile() != null && !initList.getCustMobile().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("手机号");
		cre.setTiggerInfo(initList.getCustMobile());
		cre.setTiggerType(1);
		cre.setRoleIndex(2);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getCustHomeAddress() != null && !initList.getCustHomeAddress().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("住宅地址");
		cre.setTiggerInfo(initList.getCustHomeAddress());
		cre.setTiggerType(1);
		cre.setRoleIndex(3);
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
		cre.setRoleIndex(4);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getCustCorpName() != null && !initList.getCustCorpName().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("单位名称");
		cre.setTiggerInfo(initList.getCustCorpName());
		cre.setTiggerType(1);
		cre.setRoleIndex(5);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getCustCorpAddress() != null && !initList.getCustCorpAddress().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("单位地址");
		cre.setTiggerInfo(initList.getCustCorpAddress());
		cre.setTiggerType(1);
		cre.setRoleIndex(6);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getCustCorpPhone() != null && !initList.getCustCorpPhone().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("单位电话");
		cre.setTiggerInfo(initList.getCustCorpPhone());
		cre.setTiggerType(1);
		cre.setRoleIndex(7);
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
