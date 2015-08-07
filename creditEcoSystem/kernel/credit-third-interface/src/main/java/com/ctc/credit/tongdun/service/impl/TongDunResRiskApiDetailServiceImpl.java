package com.ctc.credit.tongdun.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.tongdun.dao.TongDunResRiskApiDetailLogDao;
import com.ctc.credit.tongdun.model.TongDunResApiDetailEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailResponse;
import com.ctc.credit.tongdun.service.TongDunResRiskApiDetailService;
@Service
@Transactional
public class TongDunResRiskApiDetailServiceImpl implements
		TongDunResRiskApiDetailService {
	
	@Autowired
	TongDunResRiskApiDetailLogDao tongDunResRiskApiDetailLogDao;
	
	@Override
	public void tongDunResApiDetailInfoSave(
			HandleTdRiskApiDetailResponse handleResponse) throws Exception {
		// TODO Auto-generated method stub
		TongDunResApiDetailEntity tongDunResDetailEntity=new TongDunResApiDetailEntity();
		
		tongDunResDetailEntity.setResinfo(handleResponse.getTongDunResRiskApiDetailDto().getResinfo());
		tongDunResDetailEntity.setP_id(handleResponse.getP_id());
		tongDunResDetailEntity.setCreateUser("creditadmin");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tongDunResDetailEntity.setCreateDate(sdf.parse(sdf.format(new Date())));
		tongDunResRiskApiDetailLogDao.saveTdResRiskApiDeetailInfo(tongDunResDetailEntity);
	}

}
