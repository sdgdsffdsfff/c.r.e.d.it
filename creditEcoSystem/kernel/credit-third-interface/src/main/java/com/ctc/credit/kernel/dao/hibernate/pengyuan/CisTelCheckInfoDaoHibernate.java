package com.ctc.credit.kernel.dao.hibernate.pengyuan;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.kernel.dao.pengyuan.CisTelCheckInfoDao;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;

@Repository
public class CisTelCheckInfoDaoHibernate extends DaoHibernate<CisTelCheckInfo, String>
		implements CisTelCheckInfoDao {

	public CisTelCheckInfoDaoHibernate() {
		super(CisTelCheckInfo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryMaxDateFromLocal(String telephone) {
		String hql = "select teleinfo.creationDate from CisTelCheckInfo teleinfo where teleinfo.telePhone=?";
		List<String> dates = this.query(hql,new Object[]{telephone});
		return dates.size()>0?dates.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryBatchNoByDate(String date,String telephone) {
		String hql = "select teleinfo.batchNo from CisTelCheckInfo teleinfo where teleinfo.creationDate=? and teleinfo.telePhone=?";
		List<String> batchNos= this.query(hql,new Object[]{date,telephone});
		return batchNos.size()>0?batchNos.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CisTelCheckInfo> queryTelCheckInfoByBatchNo(String batchNo) {
		String hql = "from CisTelCheckInfo teleinfo where teleinfo.batchNo=?";
		List<CisTelCheckInfo> cisTelCheckInfos= this.query(hql,new Object[]{batchNo});
		return cisTelCheckInfos;
	}

	@Override
	public void saveTelCheckInfos(List<CisTelCheckInfo> cisTelCheckInfos) {
		if (null!=cisTelCheckInfos)
			for (CisTelCheckInfo cisTelCheckInfo : cisTelCheckInfos)
				this.save(cisTelCheckInfo);
	}
}
