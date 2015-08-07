package com.ctc.credit.tongdun.api.service;

import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDto;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;

public interface TongDunReqRiskApiService {
	public TongDunResRiskApiDto getTongDunRiskData(HandleTdRiskApiRequest handleTdRiskApiRequest)throws Exception;
}
