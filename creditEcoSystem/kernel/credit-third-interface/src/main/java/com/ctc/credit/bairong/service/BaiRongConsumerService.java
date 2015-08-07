package com.ctc.credit.bairong.service;

import java.text.ParseException;

import com.ctc.credit.bairong.api.dto.HandleBrRequest;

public interface BaiRongConsumerService {
	/**
	 * 查询百融用户的报告
	 * @param handleBrRequest
	 * @return
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public String queryUserPortrait(HandleBrRequest handleBrRequest);

}
