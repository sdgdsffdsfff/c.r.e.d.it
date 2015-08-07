package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.online.OnlineDto;

public interface CreareBrOnlineEntiryService {
	
	/**
	 * 百融：线上行为评估
	 * @param assetsDto
	 */
	public void saveOnlineInfo(OnlineDto onlineDto);
}
