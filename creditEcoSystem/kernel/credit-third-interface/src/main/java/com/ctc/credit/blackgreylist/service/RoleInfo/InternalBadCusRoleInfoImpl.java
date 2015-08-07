package com.ctc.credit.blackgreylist.service.RoleInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.constant.BlackListEnum;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;
import com.ctc.credit.blackgreylist.service.IRoleInfo;


/**
 * 营业部同业灰名单
 * @author zhangwenjun
 *
 */

@Component
public class InternalBadCusRoleInfoImpl implements IRoleInfo{
	
	private BlackListEnum blackName = BlackListEnum.TheInternalBadCustomers;
	
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
		cre.setBlkgrayRoleCode(blackName.getRejectCode());
		cre.setBlkgrayRoleDes(blackName.getBlackListName());
		cre.setPriority(blackName.getBlackPriority());
		cre.setTiggerDescription("身份证号");
		cre.setTiggerInfo(initList.getCustIdnum());
		cre.setTiggerType(0);
		cre.setRoleIndex(1);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
	}

	
	@Override
	public String getBlackNameDES() {
		// TODO Auto-generated method stub
		return blackName.getBlackListName();
	}
}
