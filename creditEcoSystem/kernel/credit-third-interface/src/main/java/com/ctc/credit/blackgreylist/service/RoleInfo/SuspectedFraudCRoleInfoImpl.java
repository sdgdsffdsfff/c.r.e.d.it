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
 * 疑似欺诈客户灰名单C
 * @author zhangwenjun
 *
 */
@Component
public class SuspectedFraudCRoleInfoImpl implements IRoleInfo{

	private GrayListEnum grayName = GrayListEnum.SuspectedFraudC;
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	
	@Override
	public void initDangerList(
			CreditBlkgraylistDetailEntity initList) {
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String td = sdf.format(today);
		
		CreditBlkgraylistRoleEntity cre = new CreditBlkgraylistRoleEntity();
		if(initList != null && initList.getCustCorpName() != null && !initList.getCustCorpName().isEmpty()){
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("单位名称");
		cre.setTiggerInfo(initList.getCustCorpName());
		cre.setTiggerType(1);
		cre.setRoleIndex(1);
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
		cre.setRoleIndex(2);
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
		cre.setRoleIndex(3);
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
