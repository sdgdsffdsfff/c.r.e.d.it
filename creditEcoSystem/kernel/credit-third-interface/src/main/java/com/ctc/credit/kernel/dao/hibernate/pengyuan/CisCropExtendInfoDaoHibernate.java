package com.ctc.credit.kernel.dao.hibernate.pengyuan;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.kernel.dao.pengyuan.CisCropExtendInfoDao;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;

@Repository
public class CisCropExtendInfoDaoHibernate extends DaoHibernate<CisCropExtendInfo, String>
		implements CisCropExtendInfoDao {

	public CisCropExtendInfoDaoHibernate() {
		super(CisCropExtendInfo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryMaxDateFromLocal(String corpName) {
		String hql = "select corp.creationDate from CisCropExtendInfo corp where corp.corpName=?";
		List<String> dates = this.query(hql,new Object[]{corpName});
		return dates.size()>0?dates.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryBatchNoByDate(String date,String corpName) {
		
		String hql = "select corp.batchNo from CisCropExtendInfo corp where corp.creationDate=? and corp.corpName=?";
		List<String> batchNos= this.query(hql,new Object[]{date,corpName});
		return batchNos.size()>0?batchNos.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CisCropExtendInfo> queryCropExtendInfoByBatchNo(String batchNo) {
		String hql = "from CisCropExtendInfo corp where corp.batchNo=?";
		List<CisCropExtendInfo> cisCropExtendInfos= this.query(hql,new Object[]{batchNo});
		return cisCropExtendInfos;
	}
}
