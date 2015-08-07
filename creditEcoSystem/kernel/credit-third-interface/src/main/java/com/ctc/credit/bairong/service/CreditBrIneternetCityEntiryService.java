package com.ctc.credit.bairong.service;

import java.util.ArrayList;

import com.ctc.credit.bairong.api.dto.internet.InternetDto;
import com.ctc.credit.bairong.model.CreditBrIneternetCityEntiry;
import com.ctc.credit.kernel.base.GenericService;

public interface CreditBrIneternetCityEntiryService extends GenericService<CreditBrIneternetCityEntiry, String>{

	/**
	 * 百融：保存上网信息核查信息
	 * @param internetDtos
	 */
	public void saveNeternetCityInfo(ArrayList<InternetDto> internetDtos);
}
