package com.ctc.credit.qianhai.api.service;

import com.ctc.credit.qianhai.api.dto.BlkListRequestDto;
import com.ctc.credit.qianhai.api.dto.BlkListResponseDto;

public interface QianHaiCreditApiService {

	public BlkListResponseDto getQianhaiCreditData(BlkListRequestDto blkListRequestDto) throws Exception;
	
}
