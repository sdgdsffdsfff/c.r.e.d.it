package com.ctc.credit.blackgreylist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctc.credit.blackgreylist.dao.IAccountInternalDataDao;

@Repository
public class AccountInternalDataHibernate extends ApproveDaoHibernate implements IAccountInternalDataDao{

	@Override
	public List<String> getAllApplyCode(List<String> extisingCode) {
		// TODO Auto-generated method stub
		String sql = 
				" select "+
				" distinct eai.APPLY_CODE_ "+
				" from eam.eam_acc_period_main apm "+
				" inner join eam.eam_account_info eai "+
				" on apm.account_id_ = eai.id_ "+
				" where apm.DELINQUENT_DAYS_ >= 60 "+
				" or eai.account_status_＝'7' "+
				" and eai.apply_code_ not in ('1'";
		
		StringBuffer sqlBuffer = new StringBuffer(sql);
		for(String code : extisingCode){
			sqlBuffer.append(" ,'"+code+"'");
		}
		sqlBuffer.append(")");
		
		return this.querySql(sqlBuffer.toString());
	}

}
