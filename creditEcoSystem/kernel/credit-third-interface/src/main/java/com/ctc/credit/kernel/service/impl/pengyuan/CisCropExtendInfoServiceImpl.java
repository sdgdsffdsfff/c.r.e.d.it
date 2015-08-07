package com.ctc.credit.kernel.service.impl.pengyuan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.dao.pengyuan.CisCropExtendInfoDao;
import com.ctc.credit.kernel.service.pengyuan.CisCropExtendInfoService;
import com.ctc.credit.kernel.model.pengyuan.CisCropExtendInfo;

@Service
@Transactional
public class CisCropExtendInfoServiceImpl extends GenericServiceImpl<CisCropExtendInfo, String>
		implements CisCropExtendInfoService {

     public CisCropExtendInfoServiceImpl() {
	 }
     @Autowired
	private CisCropExtendInfoDao cisCropExtendInfoDao;

     
	public CisCropExtendInfoDao getCisCropExtendInfoDao() {
		return cisCropExtendInfoDao;
	}

	public void setCisCropExtendInfoDao(CisCropExtendInfoDao cisCropExtendInfoDao) {
		this.cisCropExtendInfoDao = cisCropExtendInfoDao;
	}

	@Override
	public void saveCropExtendInfos(List<CisCropExtendInfo> cisCropExtendInfos) {
		if(null!=cisCropExtendInfos)
			for (CisCropExtendInfo cisCropExtendInfo : cisCropExtendInfos) {
				cisCropExtendInfoDao.save(cisCropExtendInfo);
			}
	}

	@Override
	public String queryMaxDateFromLocal(String CorpName) {
		return cisCropExtendInfoDao.queryMaxDateFromLocal(CorpName);
	}

	@Override
	public String queryBatchNoByDate(String date,String corpName) {
		return cisCropExtendInfoDao.queryBatchNoByDate(date,corpName);
	}

	@Override
	public List<CisCropExtendInfo> queryCropExtendInfoByBatchNo(String batchNo) {
		return cisCropExtendInfoDao.queryCropExtendInfoByBatchNo(batchNo);
	}

}
