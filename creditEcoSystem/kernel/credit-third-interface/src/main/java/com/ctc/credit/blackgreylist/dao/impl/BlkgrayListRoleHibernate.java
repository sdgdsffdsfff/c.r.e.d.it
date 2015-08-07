package com.ctc.credit.blackgreylist.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ctc.credit.blackgreylist.dao.IBlkgrayListRoleDao;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;


@Repository
public class BlkgrayListRoleHibernate extends DaoHibernate<CreditBlkgraylistRoleEntity, String>
implements IBlkgrayListRoleDao {

	@Override
	public List<Map<String, Object>> matchBlackLsit(int tigger_type,
			String rejectCode, Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchGrayLsit(int tigger_type,
			Map<String, String> param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchIdNumber(String idNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchNameAndMobile(String name,
			String mobile) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchCompanyName(String company) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchHomePhoneAndMoble(String mobile,
			String homePhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchCompanyInfo(String companyAddress,
			String companyName, String companyPhone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> matchNameAndEncIdNumber(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CreditBlkgraylistRoleEntity> queryEntitiesById(String srcId) {
		String hql = "from CreditBlkgraylistRoleEntity role where role.tiggerSource=?";
		return this.query(hql, new Object[]{srcId});
	}

}
