package com.ctc.credit.blackgreylist.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.dao.IBlkgrayListRoleDao;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;
import com.ctc.credit.kernel.base.GenericServiceImpl;


@Service
@Transactional
public class BlkgrayListRoleServiceImpl extends GenericServiceImpl<CreditBlkgraylistRoleEntity, String>
implements IBlkgrayListRoleService{

	@Autowired
	private IBlkgrayListRoleDao iBlkgrayListRoleDao;
	
	@Override
	public List<Map<String, Object>> matchBlackLsit(int tigger_type,String rejectCode,Map<String,String> param) {
		// TODO Auto-generated method stub
		/**
		 * 需要动态的拼装 SQL param 的
		 */
		StringBuffer sql =  new StringBuffer("select * from CREDIT_BLKGRAYLIST_ROLE where tigger_type =  "+tigger_type + " and (");
		
		int i = 1 ;
		for(String key : param.keySet()){
			if(i < param.size()){
				sql.append(" TIGGER_INFO = '"+param.get(key)+"' or ");
			}else{
				sql.append(" TIGGER_INFO = '"+param.get(key)+"' ");
			}
		}
		
		sql.append(" )  and  BLKGRAY_ROLE_CODE = "+rejectCode+" order by PRIORITY ASC,CREATE_TIME DESC");
		
		return this.querySql2Listmap(sql.toString());
	}

	@Override
	public List<Map<String, Object>> matchIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		String sql = "	SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE   "
				+ "	FROM ( "
				+ "	SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE   "
				+ "	FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and TIGGER_INFO = '"+idNumber+"' order by PRIORITY ASC,CREATE_TIME DESC "
				+ "	) WHERE ROWNUM = 1";
				
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchNameAndMobile(String name,
			String mobile) {
		// TODO Auto-generated method stub
		String sql = 
					" SELECT "+
				" mobileInfo.TIGGER_INFO ||' '||nameInfo.TIGGER_INFO TIGGER_INFO, "+
				" mobileInfo.BLKGRAY_ROLE_CODE, "+
				" mobileInfo.PRIORITY, "+
				" mobileInfo.TIGGER_SOURCE "+
				" FROM ( "+
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,ROLE_INDEX,TIGGER_SOURCE,CREATE_TIME "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and TIGGER_INFO ='"+mobile+"' "+
				" ) mobileInfo inner join ( "+
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,ROLE_INDEX "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and TIGGER_INFO ='"+name+"' "+
				" ) nameInfo "+
				" on mobileInfo.ROLE_INDEX = nameInfo.ROLE_INDEX "+
				" and mobileInfo.BLKGRAY_ROLE_CODE = nameInfo.BLKGRAY_ROLE_CODE ORDER BY mobileInfo.PRIORITY ASC,mobileInfo.CREATE_TIME DESC";
				
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>>  matchCompanyName(String company) {
		// TODO Auto-generated method stub
		String sql = "	SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE   "
				+ "	FROM ( "
				+ "	SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE   "
				+ "	FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and TIGGER_INFO = '"+company+"' order by PRIORITY ASC,CREATE_TIME DESC "
				+ "	) WHERE ROWNUM = 1";
			
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchHomePhoneAndMoble(String mobile,
			String homePhone) {
		// TODO Auto-generated method stub
		String sql = 
			" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE "+
			" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and "
			+ "(TIGGER_INFO ='"+mobile+"'  or TIGGER_INFO = '"+homePhone+"') and BLKGRAY_ROLE_CODE = '02DH' order by PRIORITY ASC,CREATE_TIME DESC";
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchCompanyInfo(String companyAddress,
			String companyName, String companyPhone) {
		// TODO Auto-generated method stub
		String sql = 
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 0 and "
				+ "(TIGGER_INFO ='"+companyAddress+"'  or TIGGER_INFO = '"+companyName+"' or TIGGER_INFO = '"+companyPhone+"')"
				+ " and (BLKGRAY_ROLE_CODE = '02LD' or  BLKGRAY_ROLE_CODE= '02DB') order by PRIORITY ASC,CREATE_TIME DESC";
			return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchNameAndEncIdNumber(String name,String idNumber) {
		String sql = 
				" select BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE,TIGGER_INFO "+
				" from CREDIT_BLKGRAYLIST_ROLE s "+
				" where TIGGER_TYPE = 0 "+
				" and BLKGRAY_ROLE_CODE in ('02YY','02RF') "+
				" and TIGGER_SOURCE IN ( "+
				"   select TIGGER_SOURCE from CREDIT_BLKGRAYLIST_ROLE "+
				"   where TIGGER_TYPE = 0 "+
				"   and TIGGER_INFO = '"+name+"' "+
				"   and BLKGRAY_ROLE_CODE in ('02YY','02RF') "+
				" ) "+
				" and not exists (" +
				"   select TIGGER_SOURCE from CREDIT_BLKGRAYLIST_ROLE  t"+
				"   where TIGGER_TYPE = 0 "+
				"   and TIGGER_INFO = '"+idNumber+"' "+
				"   and BLKGRAY_ROLE_CODE in ('02YY','02RF') "+ 
				" and t.id = s.id)"+
				" AND ROLE_INDEX IN (1,2) order by PRIORITY ASC,CREATE_TIME DESC";
			
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchPersonalInfo(String idNumber,
			String mobile, String address, String homePhone) {
		// TODO Auto-generated method stub
		String sql = " select BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE,TIGGER_INFO "+
				" from CREDIT_BLKGRAYLIST_ROLE s "+
				" where s.TIGGER_TYPE = 1 "+
				" and (TIGGER_INFO = '"+idNumber+"' "+
				" or TIGGER_INFO = '"+mobile+"' "+
				" or TIGGER_INFO = '"+address+"' "+
				" or TIGGER_INFO = '"+homePhone+"' "+
				" ) and PRIORITY = 2";
		return this.querySql2Listmap(sql.toString());
	}

	@Override
	public List<Map<String, Object>> matchPersonaCompanylInfo(String idNumber,
			String mobile, String address, String homePhone,
			String companyName, String companyAddress, String companyPhone) {
		// TODO Auto-generated method stub
		String sql = " select BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE,TIGGER_INFO "+
				" from CREDIT_BLKGRAYLIST_ROLE s "+
				" where s.TIGGER_TYPE = 1 "+
				" and (TIGGER_INFO = '"+idNumber+"' "+
				" or TIGGER_INFO = '"+mobile+"' "+
				" or TIGGER_INFO = '"+address+"' "+
				" or TIGGER_INFO = '"+homePhone+"' "+
				" or TIGGER_INFO = '"+companyName+"' "+
				" or TIGGER_INFO = '"+companyAddress+"' "+
				" or TIGGER_INFO = '"+companyPhone+"' "+
				" ) and PRIORITY = 1";
		return this.querySql2Listmap(sql.toString());
	}

	@Override
	public List<Map<String, Object>> matchGrayCompanyInfo(
			String companyAddress, String companyName, String companyPhone) {
		// TODO Auto-generated method stub
		String sql = 
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 1 and "
				+ "(TIGGER_INFO ='"+companyAddress+"'  or TIGGER_INFO = '"+companyName+"' or TIGGER_INFO = '"+companyPhone+"')"
				+ " and PRIORITY = 3";
			return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchMobileAndHomePhone(String mobile,
			String homePhone) {
		// TODO Auto-generated method stub
		String sql = 
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 1 and "
				+ "(TIGGER_INFO ='"+mobile+"'  or TIGGER_INFO = '"+homePhone+"')"
				+ " and PRIORITY in (4,7)";
			return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchGrayIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		String sql = 
				" SELECT TIGGER_INFO,BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE "+
				" FROM CREDIT_BLKGRAYLIST_ROLE CBR where tigger_type = 1 and "
				+ "(TIGGER_INFO ='"+idNumber+"')"
				+ " and PRIORITY in (5,6)";
			return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchAddressAndName(String address,
			String name) {
		// TODO Auto-generated method stub
		String sql = 
				" select cusName.BLKGRAY_ROLE_CODE,cusName.PRIORITY,cusName.TIGGER_SOURCE || ' ' || address.TIGGER_SOURCE TIGGER_SOURCE,cusName.TIGGER_INFO "+
				" from CREDIT_BLKGRAYLIST_ROLE address  inner join CREDIT_BLKGRAYLIST_ROLE cusName "+
				" on address.tigger_source = cusName.Tigger_Source "+
				" and address.tigger_info = '"+address+"' and  cusName.Tigger_Info = '"+name+"' "+
				" where address.TIGGER_TYPE = 1 "+
				" and address.PRIORITY = 6  "+
				" and address.ROLE_INDEX = 2 "+
				" and cusName.ROLE_INDEX = 2 "+
				" and cusName.TIGGER_TYPE = 1 "+
				" and cusName.PRIORITY = 6";
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<Map<String, Object>> matchNameAndDeptCity(String name,
			String deptCity) {
		// TODO Auto-generated method stub
		String sql = 
				" select city.BLKGRAY_ROLE_CODE,city.PRIORITY,city.TIGGER_SOURCE, name.TIGGER_INFO|| ' ' ||city.TIGGER_INFO  TIGGER_INFO from ( "+
				" 		select BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE,TIGGER_INFO ,CREATE_TIME  "+
				" 		from CREDIT_BLKGRAYLIST_ROLE s  where s.TIGGER_TYPE = 1  "+
				" 		and TIGGER_INFO = '"+deptCity+"'   and PRIORITY = 8 "+
				" 		) city inner join ( "+
				" 		select BLKGRAY_ROLE_CODE,PRIORITY,TIGGER_SOURCE,TIGGER_INFO   "+
				" 		from CREDIT_BLKGRAYLIST_ROLE s  where s.TIGGER_TYPE = 1  "+
				" 		and TIGGER_INFO = '"+name+"'   and PRIORITY = 8 "+
				" 		) name "+
				" 		on city.TIGGER_SOURCE = name.TIGGER_SOURCE "+
				" 		order by city.create_time  ";
		return this.querySql2Listmap(sql);
	}

	@Override
	public List<CreditBlkgraylistRoleEntity> queryEntitiesById(String srcId) {
		return iBlkgrayListRoleDao.queryEntitiesById(srcId);
	}

}
