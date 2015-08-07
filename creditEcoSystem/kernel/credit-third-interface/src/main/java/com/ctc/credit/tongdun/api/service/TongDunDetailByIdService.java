package com.ctc.credit.tongdun.api.service;

import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDetailDto;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;

public interface TongDunDetailByIdService {
	public TongDunResRiskApiDetailDto queryDetailById(HandleTdRiskApiDetailRequest handleTdRiskApiDetailRequest)throws Exception;
}
