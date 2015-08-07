package com.ctc.credit.kernel.dao.hibernate.pengyuan;

import java.util.List;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.kernel.dao.pengyuan.CisArtificialPersonInfoDao;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;

import org.springframework.stereotype.Repository;

@Repository
public class CisArtificialPersonInfoDaoHibernate extends DaoHibernate<CisArtificialPersonInfo, String>
		implements CisArtificialPersonInfoDao {

	public CisArtificialPersonInfoDaoHibernate() {
		super(CisArtificialPersonInfo.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryMaxDateFromLocal(String idType, String personName,
			String idNumber) {
		String hql = "select personInfo.creationDate from CisArtificialPersonInfo personInfo where personInfo.idType=? and personInfo.personName=? and personInfo.idNumber=?";
		List<String> dates = this.query(hql,new Object[]{idType,personName,idNumber});
		return dates.size()>0?dates.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String queryBatchNoByDate(String date,String idType,String personName,String idNumber) {
		String hql = "select personInfo.batchNo from CisArtificialPersonInfo personInfo where personInfo.creationDate=? and personInfo.idType=? and personInfo.personName=? and personInfo.idNumber=?";
		List<String> batchNos= this.query(hql,new Object[]{date,idType,personName,idNumber});
		return batchNos.size()>0?batchNos.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CisArtificialPersonInfo> queryArtificialPersonInfoByBatchNo(
			String batchNo) {
		String hql = "from CisArtificialPersonInfo personInfo where personInfo.batchNo=?";
		List<CisArtificialPersonInfo> cisArtificialPersonInfos = this.query(hql,new Object[]{batchNo});
		return cisArtificialPersonInfos;
	}
}
