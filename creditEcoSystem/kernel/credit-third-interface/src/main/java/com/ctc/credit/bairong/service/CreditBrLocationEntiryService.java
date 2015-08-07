package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.location.LocationDto;
import com.ctc.credit.bairong.model.CreditBrLocationEntiry;
import com.ctc.credit.kernel.base.GenericService;

public interface CreditBrLocationEntiryService extends GenericService <CreditBrLocationEntiry, String>{
	/**
	 * 百融：保存位置信息核查信息
	 * @param internetDto
	 */
	public void saveLocationInfo(LocationDto locationDto);

}
