package com.ctc.credit.bairong.api.service;

import com.ctc.credit.bairong.api.dto.BrReportRequestDto;
import com.ctc.credit.bairong.api.dto.BrReportResponseDto;
/**
 * 
 * 调用：百融客户端API接口，包括：1.调用登录 接口    2.调用报告接口
 * @author danggang
 *
 */
public interface BrCreditApiService {

	
	/**
	 * 调用报告接口
	 * @param brReportRequestDto
	 * @return
	 */
	public BrReportResponseDto getBrUserPortrait(BrReportRequestDto brReportRequestDto);
	
}
