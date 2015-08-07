package com.ctc.credit.kernel.service.impl.pengyuan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.dao.pengyuan.CisTelCheckInfoDao;
import com.ctc.credit.kernel.model.pengyuan.CisTelCheckInfo;
import com.ctc.credit.kernel.service.pengyuan.CisTelCheckInfoService;

@Service
@Transactional
public class CisTelCheckInfoServiceImpl extends GenericServiceImpl<CisTelCheckInfo, String>
		implements CisTelCheckInfoService {

     public CisTelCheckInfoServiceImpl() {
	 }
     @Autowired
	private CisTelCheckInfoDao cisTelCheckInfoDao;

     
	public CisTelCheckInfoDao getCisTelCheckInfoDao() {
		return cisTelCheckInfoDao;
	}

	public void setCisTelCheckInfoDao(CisTelCheckInfoDao cisTelCheckInfoDao) {
		this.cisTelCheckInfoDao = cisTelCheckInfoDao;
	}

	@Override
	public String queryMaxDateFromLocal(String telephone) {
		return cisTelCheckInfoDao.queryMaxDateFromLocal(telephone);
	}

	@Override
	public String queryBatchNoByDate(String date,String telephone) {
		return cisTelCheckInfoDao.queryBatchNoByDate(date,telephone);
	}

	@Override
	public List<CisTelCheckInfo> queryTelCheckInfoByBatchNo(String batchNo) {
		return cisTelCheckInfoDao.queryTelCheckInfoByBatchNo(batchNo);
	}

}
