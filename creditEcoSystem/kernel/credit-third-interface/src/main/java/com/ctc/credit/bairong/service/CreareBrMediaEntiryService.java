package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.media.MediaDto;

public interface CreareBrMediaEntiryService {

	/**
	 * 百融：媒体阅览评估
	 * @param assetsDto
	 */
	public void saveMediaInfo(MediaDto mediaDto);
}
