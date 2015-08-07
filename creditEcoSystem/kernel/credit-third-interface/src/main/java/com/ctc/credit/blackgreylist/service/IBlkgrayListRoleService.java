package com.ctc.credit.blackgreylist.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.kernel.base.GenericService;

public interface IBlkgrayListRoleService extends GenericService<CreditBlkgraylistRoleEntity, String>{
	
	/**黑名单匹配规则**/
	public List<Map<String,Object>> matchBlackLsit(int tigger_type,String rejectCode,Map<String,String> param);
	
	public List<Map<String,Object>> matchIdNumber(String idNumber);
	
	public List<Map<String,Object>> matchNameAndMobile(String name,String mobile);
	
	public List<Map<String,Object>> matchCompanyName(String company);
	
	public List<Map<String,Object>> matchHomePhoneAndMoble(String mobile,String homePhone);
	
	public List<Map<String,Object>> matchCompanyInfo(String companyAddress,String companyName,String companyPhone);
	
	public List<Map<String,Object>> matchNameAndEncIdNumber(String name,String idNumber);
	
	/**灰名单匹配规则**/
	public List<Map<String,Object>> matchPersonalInfo(String idNumber,String mobile,String address,String homePhone);
	
	public List<Map<String,Object>> matchPersonaCompanylInfo(String idNumber,String mobile,String address,String homePhone,String companyName
			,String companyAddress,String companyPhone);
	
	public List<Map<String,Object>> matchGrayCompanyInfo(String companyAddress,String companyName,String companyPhone);
	
	public List<Map<String,Object>>  matchMobileAndHomePhone(String mobile,String homePhone);
	
	public List<Map<String,Object>>  matchGrayIdNumber(String idNumber);
	
	public List<Map<String,Object>> matchAddressAndName(String address,String name);
	
	public List<Map<String,Object>> matchNameAndDeptCity(String name,String deptCity);
	
	/**
	 * 根据触发项原始数据ID 查询索引数据
	 * @param srcId 触发项原始数据ID
	 * @return
	 */
	public List<CreditBlkgraylistRoleEntity> queryEntitiesById(String srcId);
}
