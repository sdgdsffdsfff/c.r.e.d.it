package com.ctc.credit.bairong.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.AuthenticationDto;
import com.ctc.credit.bairong.dao.CreditBrAuthenticationEntityDao;
import com.ctc.credit.bairong.dao.impl.CreditBrAuthenticationEntityDaoImpl;
import com.ctc.credit.bairong.model.CreditBrAuthenticationEntity;
import com.ctc.credit.bairong.service.CreditBrAuthenticationEntityService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
/**
 * 百融：身份认证service的实现
 * @author danggang
 *
 */
@Service
@Transactional
public class CreditBrAuthenticationEntityServiceImpl extends GenericServiceImpl<CreditBrAuthenticationEntity, String>
		implements CreditBrAuthenticationEntityService {
	private static Logger logger = Logger.getLogger(CreditBrAuthenticationEntityServiceImpl.class);
	
	public CreditBrAuthenticationEntityServiceImpl() {
		super();
	}

	@Autowired
	CreditBrAuthenticationEntityDao creditBrAuthenticationEntityDao;
	
	@Override
	public void saveAuthenticationInfo(AuthenticationDto authenticationDto) {
		// TODO Auto-generated method stub
		CreditBrAuthenticationEntity creditBrAuthenticationEntity = new CreditBrAuthenticationEntity();
		creditBrAuthenticationEntity.setUserId(authenticationDto.getId());
		creditBrAuthenticationEntity.setCell(authenticationDto.getCell());
		creditBrAuthenticationEntity.setMail(authenticationDto.getMail());
		creditBrAuthenticationEntity.setKeyRrelation(authenticationDto.getKey_relation());
		creditBrAuthenticationEntity.setName(authenticationDto.getName());
		creditBrAuthenticationEntity.setTelBiz(authenticationDto.getName());
		creditBrAuthenticationEntity.setTelHome(authenticationDto.getTel_home());
		creditBrAuthenticationEntity.setSwiftNumber(authenticationDto.getSwiftNumber());
		creditBrAuthenticationEntity.setCreateDate(new Date());
		creditBrAuthenticationEntity.setCreateUser("danggang");
		creditBrAuthenticationEntity.setUpdateDate(new Date());
		creditBrAuthenticationEntity.setUpdateUser("danggang");
		creditBrAuthenticationEntityDao.save(creditBrAuthenticationEntity);
	}

}
