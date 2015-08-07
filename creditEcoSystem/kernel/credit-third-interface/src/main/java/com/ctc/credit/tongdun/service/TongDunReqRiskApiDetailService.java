package com.ctc.credit.tongdun.service;

import com.ctc.credit.tongdun.model.TongDunReqApiDetailEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;

public interface TongDunReqRiskApiDetailService {
	public TongDunReqApiDetailEntity tongDunReqRiskDetailInfoSave(HandleTdRiskApiDetailRequest handleTdDetailRequest)throws Exception;
}
