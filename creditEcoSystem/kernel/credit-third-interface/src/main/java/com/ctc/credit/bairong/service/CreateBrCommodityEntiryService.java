package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.consumption.ConsumptionDto;

public interface CreateBrCommodityEntiryService {

	/**
	 * 百融：商品评估
	 * @param assetsDto
	 */
	public void saveCommodityInfo(ConsumptionDto consumptionDto);
}
