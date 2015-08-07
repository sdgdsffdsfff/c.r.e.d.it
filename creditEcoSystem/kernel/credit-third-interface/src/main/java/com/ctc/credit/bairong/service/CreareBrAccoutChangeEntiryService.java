package com.ctc.credit.bairong.service;

import java.text.ParseException;

import com.ctc.credit.bairong.api.dto.account.AccountChangeDto;

public interface CreareBrAccoutChangeEntiryService {

	/**
	 * 百融：收支等级评估
	 * @param assetsDto
	 * @throws ParseException 
	 * @throws NumberFormatException 
	 */
	public void saveAccoutChangeInfo(AccountChangeDto accountChangeDto);
}
