package com.ctc.credit.blackgreylist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctc.credit.blackgreylist.dao.IApproveInternalDataDao;

@Repository
public class ApproveInternalDataHibernate extends ApproveDaoHibernate implements IApproveInternalDataDao {

	public List<Map<String, Object>> getCustomerInfoByApplyCode(List<String> applyCode) {
		// TODO Auto-generated method stub
		String sql = 
			"	select "+
			"	cbi.name, "+
			"	cbi.cardNo, "+
 			"	cbi.mobile, "+
			"	cbi.addressProvince, "+
			"	cbi.addressCity, "+
			"	cbi.addressDistrict, "+
			"	cbi.addressDetail, "+
			"	cbi.phone, "+
			"	cbi.companyName, "+
			"	cbi.companyPhone, "+
			"	cbi.companyAddressDetail, "+
			"	api.code "+
			"	from app.APPLYINFO api "+
			"	inner join app.APPLY_CUSTOMER_BASEINFO cbi on api.applyCustomerBaseInfoId = cbi.id "+
			"	where api.code in ( '1'";
		StringBuffer sqlBuffer = new StringBuffer(sql);
		for(String applyC : applyCode){
			sqlBuffer.append(" ,'"+applyC+"'");
		}
		sqlBuffer.append(")");
		
		return this.querySql2Listmap(sqlBuffer.toString());
	}

	
	@Override
	public List<Map<String, Object>> getGrayListInfo() {
		// TODO Auto-generated method stub
		String sql = 
				" select "+ 
				" cbi.name, "+
				" cbi.cardNo, "+
				" cbi.mobile, "+
				" cbi.addressProvince, "+
				" cbi.addressCity, "+
				" cbi.addressDistrict, "+ 
				" cbi.addressDetail, "+
				" cbi.phone,  "+
				" cbi.companyName, "+ 
				" cbi.companyPhone,  "+
				" cbi.companyAddressDetail, "+ 
				" api.code,  "+
				" nvl(api.refuseCode,'null') refuseCode,  "+
				" nvl(api.refuseCode2,'null') refuseCode2,  "+
				" nvl(api.refuseCode3,'null') refuseCode3,  "+
				" nvl(api.refuseCode4,'null') refuseCode4 "+
				" from app.APPLYINFO api  "+
				" inner join app.APPLY_CUSTOMER_BASEINFO cbi on api.applyCustomerBaseInfoId = cbi.id "+
				" where (api.refuseCode in ('02DF','02JY','02LD','02DB','02SB','02YT','02LS','02ZT','02HL','02DY','02LX','02JL','02QL','02SY','02ZK','02ZP','02QK','02FS','02FJ','02FK','03XH','02RF','02QZ','02NB','02NY','02EY','02YY','02WL','02BL','02JR','02YG','02ZX','02HZ','02WZ','02GZ','02DW','02FQ','02ZG','02DH') "+
				" or api.refuseCode2 in ('02DF','02JY','02LD','02DB','02SB','02YT','02LS','02ZT','02HL','02DY','02LX','02JL','02QL','02SY','02ZK','02ZP','02QK','02FS','02FJ','02FK','03XH','02RF','02QZ','02NB','02NY','02EY','02YY','02WL','02BL','02JR','02YG','02ZX','02HZ','02WZ','02GZ','02DW','02FQ','02ZG','02DH') "+
				" or api.refuseCode3 in ('02DF','02JY','02LD','02DB','02SB','02YT','02LS','02ZT','02HL','02DY','02LX','02JL','02QL','02SY','02ZK','02ZP','02QK','02FS','02FJ','02FK','03XH','02RF','02QZ','02NB','02NY','02EY','02YY','02WL','02BL','02JR','02YG','02ZX','02HZ','02WZ','02GZ','02DW','02FQ','02ZG','02DH') "+
				" or api.refuseCode4 in ('02DF','02JY','02LD','02DB','02SB','02YT','02LS','02ZT','02HL','02DY','02LX','02JL','02QL','02SY','02ZK','02ZP','02QK','02FS','02FJ','02FK','03XH','02RF','02QZ','02NB','02NY','02EY','02YY','02WL','02BL','02JR','02YG','02ZX','02HZ','02WZ','02GZ','02DW','02FQ','02ZG','02DH') ) "+
				" and api.code not in ( "+
				"	SELECT distinct detail.apply_no "+
			    "    FROM credit.CREDIT_BLKGRAYLIST_DETAIL detail "+
			    "    inner join  credit.CREDIT_BLKGRAYLIST_ROLE rInfo "+
			    "    on detail.id = rInfo.tigger_source "+
			    "   where rInfo.TIGGER_TYPE = 1 "+
			    "   and rInfo.PRIORITY in (1,2,3,4)"+
			    "  and detail.apply_no is not null "+
				")";
		return this.querySql2Listmap(sql);
	}


	@Override
	public List<Map<String, Object>> getInterBadCustomer() {
		// TODO Auto-generated method stub
		String sql =
			"	select  "+
			" 	cbi.name,  "+
			"   cbi.cardNo,  "+
			"   cbi.mobile,  "+
			"   cbi.addressProvince, "+ 
			"   cbi.addressCity,  "+
			"   cbi.addressDistrict, "+ 
			"   cbi.addressDetail,  "+
			"   cbi.phone,  "+
			"   cbi.companyName, "+ 
			"   cbi.companyPhone,  "+
			"   cbi.companyAddressDetail, "+ 
			"    api.code  "+
			"	from app.APPLYINFO api "+
			"	inner join app.APPLY_CUSTOMER_BASEINFO cbi on api.applyCustomerBaseInfoId = cbi.id "+
			"	where api.code in ( "+
			"     select "+
			"     distinct eai.APPLY_CODE_ "+
			"     from eam.eam_acc_period_main apm "+
			"     inner join eam.eam_account_info eai "+
			"     on apm.account_id_ = eai.id_ "+
			"     where (apm.DELINQUENT_DAYS_ >= 60 "+
			"     or eai.account_status_＝'7') "+
			"     and  not exists ("+
			"        SELECT distinct detail.apply_no "+
			"        FROM credit.CREDIT_BLKGRAYLIST_DETAIL detail "+
			"        inner join  credit.CREDIT_BLKGRAYLIST_ROLE rInfo "+
			"        on detail.id = rInfo.tigger_source "+
			"        where rInfo.TIGGER_TYPE = 0 "+
			"        and rInfo.PRIORITY in (1,2,3,4) "+
			"		 and eai.apply_code_  = detail.apply_no "+
			"     ) "+
			"   ) ";
		return this.querySql2Listmap(sql);
	}
}
