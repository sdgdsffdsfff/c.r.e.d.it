package com.ctc.credit.blackgreylist.service.RoleInfo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.constant.BlackListEnum;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;
import com.ctc.credit.blackgreylist.service.IRoleInfo;


/**
 * 不良嗜好客户黑名单
 * @author zhangwenjun
 *
 */
@Component
public class BadHabitsCustomerRoleInfoImpl implements IRoleInfo{

	private BlackListEnum blackName = BlackListEnum.BadHabitsOfCustomers;
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	
	@Override
	public void initDangerList(
			CreditBlkgraylistDetailEntity initList) {
		
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			cre.setCreateTime(sdf.format(new Date()));
			blkgrayListRoleServiceImpl.save(cre);
		}
	}


	@Override
	public String getBlackNameDES() {
		// TODO Auto-generated method stub
		return blackName.getBlackListName();
	}
}
