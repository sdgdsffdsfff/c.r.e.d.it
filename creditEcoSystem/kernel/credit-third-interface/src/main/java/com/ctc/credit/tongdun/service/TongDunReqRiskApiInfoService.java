package com.ctc.credit.tongdun.service;

import com.ctc.credit.tongdun.model.TongDunReqRiskApiEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;

public interface TongDunReqRiskApiInfoService {
	public TongDunReqRiskApiEntity tongDunReqRiskInfoSave(HandleTdRiskApiRequest handleRequest)throws Exception;
}
