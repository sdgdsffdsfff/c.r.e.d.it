package com.ctc.credit.kernel.service.impl.pengyuan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.dao.pengyuan.CisArtificialPersonInfoDao;
import com.ctc.credit.kernel.service.pengyuan.CisArtificialPersonInfoService;
import com.ctc.credit.kernel.model.pengyuan.CisArtificialPersonInfo;

@Service
@Transactional
public class CisArtificialPersonInfoServiceImpl extends GenericServiceImpl<CisArtificialPersonInfo, String>
		implements CisArtificialPersonInfoService {

     public CisArtificialPersonInfoServiceImpl() {
	 }
     @Autowired
	private CisArtificialPersonInfoDao cisArtificialPersonInfoDao;

     
	public CisArtificialPersonInfoDao getCisArtificialPersonInfoDao() {
		return cisArtificialPersonInfoDao;
	}

	public void setCisArtificialPersonInfoDao(CisArtificialPersonInfoDao cisArtificialPersonInfoDao) {
		this.cisArtificialPersonInfoDao = cisArtificialPersonInfoDao;
	}

	@Override
	public void saveArtificialPersonInfos(
			List<CisArtificialPersonInfo> artificialPersonInfos) {
		if(null!=artificialPersonInfos)
			for (CisArtificialPersonInfo cisArtificialPersonInfo : artificialPersonInfos) {
				cisArtificialPersonInfoDao.save(cisArtificialPersonInfo);
			}
	}

	@Override
	public String queryMaxDateFromLocal(String idType,String personName,String idNumber) {
		return cisArtificialPersonInfoDao.queryMaxDateFromLocal(idType, personName, idNumber);
	}

	@Override
	public String queryBatchNoByDate(String date,String idType,String personName,String idNumber) {
		return cisArtificialPersonInfoDao.queryBatchNoByDate(date,idType,personName,idNumber);
	}

	@Override
	public List<CisArtificialPersonInfo> queryArtificialPersonInfoByBatchNo(
			String batchNo) {
		return cisArtificialPersonInfoDao.queryArtificialPersonInfoByBatchNo(batchNo);
	}

}
