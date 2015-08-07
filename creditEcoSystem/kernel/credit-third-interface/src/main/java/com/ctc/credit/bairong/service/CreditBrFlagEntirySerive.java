package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.flag.FlagDto;
import com.ctc.credit.bairong.model.CreditBrFlagEntiry;
import com.ctc.credit.kernel.base.GenericService;

public interface CreditBrFlagEntirySerive extends GenericService<CreditBrFlagEntiry,String>{
	/**
	 * 百融：报告输出标识
	 * @param creditBrFlagEntiryDto
	 */
	public void saveFlagInfo(FlagDto flagDto);

}
