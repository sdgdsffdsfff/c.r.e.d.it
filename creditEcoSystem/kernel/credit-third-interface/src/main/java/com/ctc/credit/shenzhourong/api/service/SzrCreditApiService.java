package com.ctc.credit.shenzhourong.api.service;

import com.ctc.credit.shenzhourong.api.dto.SzrRequestDto;
import com.ctc.credit.shenzhourong.api.dto.SzrBlkListResponseDto;
import com.ctc.credit.shenzhourong.api.dto.SzrCPointResponseDto;

/**
 * 神州融黑名单查询接口
 * @author Chengang
 * 2015年7月23日 上午11:19:25
 */
public interface SzrCreditApiService {

	/**
	 * 黑名单查询
	 * @author Chengang
	 * @param blkListRequestDto
	 * @return
	 */
	SzrBlkListResponseDto getSzrBlkListresult(SzrRequestDto RequestDto);

	/**
	 * 信用评分
	 * @author Chengang
	 * @param scporintRequestDto
	 * @return
	 */
	SzrCPointResponseDto getSzrCreditPointResult(SzrRequestDto RequestDto);
	
}
