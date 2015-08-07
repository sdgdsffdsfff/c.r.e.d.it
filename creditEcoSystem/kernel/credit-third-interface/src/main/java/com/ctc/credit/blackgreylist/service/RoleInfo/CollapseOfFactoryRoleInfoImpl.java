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
 * 倒闭工厂
 * @author zhangwenjun
 *
 */
@Component
public class CollapseOfFactoryRoleInfoImpl implements IRoleInfo{

	private BlackListEnum blackName = BlackListEnum.TheCollapseOfTheFactory;
	
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
			cre.setBlkgrayRoleCode(blackName.getRejectCode());
			cre.setBlkgrayRoleDes(blackName.getBlackListName());
			cre.setPriority(blackName.getBlackPriority());
			cre.setTiggerDescription("单位名称");
			cre.setTiggerInfo(initList.getCustCorpName());
			cre.setTiggerType(0);
			cre.setRoleIndex(1);
			cre.setTiggerSource(initList.getId());
			cre.setCreateTime(td);
			blkgrayListRoleServiceImpl.save(cre);
		}
		
		if(initList != null && initList.getCustCorpAddress() != null && !initList.getCustCorpAddress().isEmpty()){
			cre = new CreditBlkgraylistRoleEntity();
			cre.setBlkgrayRoleCode(blackName.getRejectCode());
			cre.setBlkgrayRoleDes(blackName.getBlackListName());
			cre.setPriority(blackName.getBlackPriority());
			cre.setTiggerDescription("单位地址");
			cre.setTiggerInfo(initList.getCustCorpAddress());
			cre.setTiggerType(0);
			cre.setRoleIndex(2);
			cre.setTiggerSource(initList.getId());
			cre.setCreateTime(td);
			blkgrayListRoleServiceImpl.save(cre);
		}
		
		
		if(initList != null && initList.getCustCorpPhone() != null && !initList.getCustCorpPhone().isEmpty()){
			cre = new CreditBlkgraylistRoleEntity();
			cre.setBlkgrayRoleCode(blackName.getRejectCode());
			cre.setBlkgrayRoleDes(blackName.getBlackListName());
			cre.setPriority(blackName.getBlackPriority());
			cre.setTiggerDescription("单位电话");
			cre.setTiggerInfo(initList.getCustCorpPhone());
			cre.setTiggerType(0);
			cre.setRoleIndex(3);
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
