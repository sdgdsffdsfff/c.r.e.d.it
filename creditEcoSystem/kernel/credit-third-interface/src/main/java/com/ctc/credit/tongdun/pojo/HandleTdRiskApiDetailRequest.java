package com.ctc.credit.tongdun.pojo;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDetailDto;

public class HandleTdRiskApiDetailRequest extends AbstractCreditEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4545369216534455425L;
	private TongDunReqRiskApiDetailDto tongDunReqRiskApiDetailDto;
	private String others_value;
	public TongDunReqRiskApiDetailDto getTongDunReqRiskApiDetailDto() {
		return tongDunReqRiskApiDetailDto;
	}

	public void setTongDunReqRiskApiDetailDto(
			TongDunReqRiskApiDetailDto tongDunReqRiskApiDetailDto) {
		this.tongDunReqRiskApiDetailDto = tongDunReqRiskApiDetailDto;
	}

	public String getOthers_value() {
		return others_value;
	}

	public void setOthers_value(String others_value) {
		this.others_value = others_value;
	}
	
	
}
