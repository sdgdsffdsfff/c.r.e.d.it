package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.BrReportRequestDto;




public interface CreareBrRequestEntieyService {

	/**
	 * 百融：保存商户登录信息 
	 */
	public void saveRequestInfo(BrReportRequestDto brReportRequestDto);
}
