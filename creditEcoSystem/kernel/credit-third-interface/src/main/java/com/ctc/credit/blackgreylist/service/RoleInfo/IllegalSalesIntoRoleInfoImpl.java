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
 * 违规销售人员进件客户灰名单
 * @author zhangwenjun
 *
 */
@Component
public class IllegalSalesIntoRoleInfoImpl implements IRoleInfo{

	private GrayListEnum grayName = GrayListEnum.IllegalSalesPersonnelIntoPieces;
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	
	@Override
	public void initDangerList(
			CreditBlkgraylistDetailEntity initList) {
		
		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String td = sdf.format(today);
		
		CreditBlkgraylistRoleEntity cre = new CreditBlkgraylistRoleEntity();
		if(initList != null && initList.getSalepersonName() != null && !initList.getSalepersonName().isEmpty()){
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("姓名");
		cre.setTiggerInfo(initList.getSalepersonName());
		cre.setTiggerType(1);
		cre.setRoleIndex(1);
		cre.setTiggerSource(initList.getId());
		cre.setCreateTime(td);
		blkgrayListRoleServiceImpl.save(cre);
		}
		if(initList != null && initList.getDepartmentCity() != null && !initList.getDepartmentCity().isEmpty()){
		cre = new CreditBlkgraylistRoleEntity();
		cre.setBlkgrayRoleDes(grayName.getGrayListName());
		cre.setPriority(grayName.getBlackPriority());
		cre.setTiggerDescription("营业部所在城市");
		cre.setTiggerInfo(initList.getDepartmentCity());
		cre.setTiggerType(1);
		cre.setRoleIndex(1);
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
