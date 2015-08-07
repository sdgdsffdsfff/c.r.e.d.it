package com.ctc.credit.blackgreylist.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;

public interface IRoleInfo {
	/**
	 * 初始化黑灰名单
	 * @param initList
	 * @return
	 */
	public void initDangerList(CreditBlkgraylistDetailEntity initList);
	
	
	public String getBlackNameDES();
}
