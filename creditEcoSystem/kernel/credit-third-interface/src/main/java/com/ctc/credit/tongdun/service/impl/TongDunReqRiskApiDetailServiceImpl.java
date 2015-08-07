package com.ctc.credit.tongdun.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDetailDto;
import com.ctc.credit.tongdun.dao.TongDunReqRiskApiDetailLogDao;
import com.ctc.credit.tongdun.model.TongDunReqApiDetailEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiDetailService;
@Service
@Transactional
public class TongDunReqRiskApiDetailServiceImpl implements
		TongDunReqRiskApiDetailService {
	@Autowired
	TongDunReqRiskApiDetailLogDao tongDunReqRiskDetailDao;
	
	@Override
	public TongDunReqApiDetailEntity tongDunReqRiskDetailInfoSave(
			HandleTdRiskApiDetailRequest handleTdDetailRequest) throws Exception {
		TongDunReqApiDetailEntity tongDunReqApiDetailEntity=new TongDunReqApiDetailEntity();
		TongDunReqRiskApiDetailDto TongDunReqRiskApiDetailDto=handleTdDetailRequest.getTongDunReqRiskApiDetailDto();
		tongDunReqApiDetailEntity.setPartnerCode(TongDunReqRiskApiDetailDto.getPartner_code());
		tongDunReqApiDetailEntity.setPartnerKey(TongDunReqRiskApiDetailDto.getPartner_key());
		tongDunReqApiDetailEntity.setRuleUuid(TongDunReqRiskApiDetailDto.getRule_uuid());
		tongDunReqApiDetailEntity.setSequenceId(TongDunReqRiskApiDetailDto.getSequence_id());
		tongDunReqApiDetailEntity.setCreateUser("creditadmin");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tongDunReqApiDetailEntity.setCreateDate(sdf.parse(sdf.format(new Date())));
		tongDunReqApiDetailEntity.setOthersValue(handleTdDetailRequest.getOthers_value());
		tongDunReqRiskDetailDao.save(tongDunReqApiDetailEntity);
		return tongDunReqApiDetailEntity;
	}

}
