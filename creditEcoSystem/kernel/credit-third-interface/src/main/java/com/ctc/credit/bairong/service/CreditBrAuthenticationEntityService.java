package com.ctc.credit.bairong.service;

import com.ctc.credit.bairong.api.dto.AuthenticationDto;
import com.ctc.credit.bairong.model.CreditBrAuthenticationEntity;
import com.ctc.credit.kernel.base.GenericService;


public interface CreditBrAuthenticationEntityService extends GenericService<CreditBrAuthenticationEntity, String>{

	/**
	 * 百融：保存身份认证信息
	 * @param authenticationDto
	 * @return
	 */
	public void saveAuthenticationInfo(AuthenticationDto authenticationDto);
}
