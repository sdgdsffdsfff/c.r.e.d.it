package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.stabliity.StabilityDto;
import com.ctc.credit.bairong.model.CreditBrStabilityEntiry;
import com.ctc.credit.kernel.base.GenericService;

public interface CreditBrStabilityEntiryService extends GenericService <CreditBrStabilityEntiry, String>{
	
	/**
	 * 百融：保存稳定性评估
	 * @param stabilityDto
	 */
	public void saveStabilityInfo(StabilityDto stabilityDto);
}
