package com.ctc.credit.tongdun.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.tongdun.dao.TongDunResRiskApiLogDao;
import com.ctc.credit.tongdun.model.TongDunResRiskApiEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiResponse;
import com.ctc.credit.tongdun.service.TongDunResRiskApiService;
@Service
@Transactional
public class TongDunResRiskApiServiceImpl implements TongDunResRiskApiService {
	@Autowired
	TongDunResRiskApiLogDao tongDunResRiskApiLogDao;
	@Override
	public void tongDunResRiskInfoSave(
			HandleTdRiskApiResponse handleResponse) throws Exception {
		TongDunResRiskApiEntity tongDunResRiskApiEntity=new TongDunResRiskApiEntity();
		tongDunResRiskApiEntity.setP_id(handleResponse.getP_id());
		tongDunResRiskApiEntity.setResinfo(handleResponse.getTongDunResRiskApiDto().getResinfo());
		tongDunResRiskApiEntity.setCreateUser("creditadmin");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tongDunResRiskApiEntity.setCreateDate(sdf.parse(sdf.format(new Date())));
		tongDunResRiskApiLogDao.saveTdResRiskApiInfo(tongDunResRiskApiEntity);
	}

}
