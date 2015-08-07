package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.applyLoan.ApplyLoanDto;

public interface CreateBrApplyLoanEntiryService {

	/**
	 * 百融：申请信息核查
	 * @param assetsDto
	 */
	public void saveApplyInfo(ApplyLoanDto applyLoanDto);
}
