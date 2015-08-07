package com.ctc.credit.blackgreylist.dao;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.kernel.base.GenericDao;

public interface IBlkgrayListRoleDao extends GenericDao<CreditBlkgraylistRoleEntity, String>{
	public List<Map<String,Object>> matchBlackLsit(int tigger_type,String rejectCode,Map<String,String> param);
	
	public List<Map<String,Object>> matchGrayLsit(int tigger_type,Map<String,String> param);
	
	public List<Map<String,Object>> matchIdNumber(String idNumber);
	
	public List<Map<String,Object>> matchNameAndMobile(String name,String mobile);
	
	public List<Map<String,Object>> matchCompanyName(String company);
	
	public List<Map<String,Object>> matchHomePhoneAndMoble(String mobile,String homePhone);
	
	public List<Map<String,Object>> matchCompanyInfo(String companyAddress,String companyName,String companyPhone);
	
	public List<Map<String,Object>> matchNameAndEncIdNumber(String name);
	
	/**
	 * 根据触发项原始数据ID 查询索引数据
	 * @param srcId 触发项原始数据ID
	 * @return
	 */
	public List<CreditBlkgraylistRoleEntity> queryEntitiesById(String srcId);
}
