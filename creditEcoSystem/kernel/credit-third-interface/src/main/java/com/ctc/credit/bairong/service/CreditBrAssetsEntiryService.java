package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.AssetsDto;

public interface CreditBrAssetsEntiryService {

	/**
	 * 百融：保存资产评估信息
	 * @param assetsDto
	 */
	public void saveAssetsInfo(AssetsDto assetsDto);
}
