package com.ctc.credit.bairong.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.AssetsDto;
import com.ctc.credit.bairong.dao.CreditBrAssetsEntiryDao;
import com.ctc.credit.bairong.model.CreditBrAssetsEntiry;
import com.ctc.credit.bairong.service.CreditBrAssetsEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
/**
 * 百融：资产评估Service的实现
 * @author danggang
 *
 */
@Service
@Transactional
public class CreditBrAssetsEntiryServiceImpl extends GenericServiceImpl<CreditBrAssetsEntiry, String> 
	implements CreditBrAssetsEntiryService{
	private static Logger logger = Logger.getLogger(CreditBrAssetsEntiryServiceImpl.class);
	
	
	public CreditBrAssetsEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CreditBrAssetsEntiryDao creditBrAssetsEntiryDto;
	
	@Override
	public void saveAssetsInfo(AssetsDto assetsDto) {
		// TODO Auto-generated method stub
		CreditBrAssetsEntiry creditBrAssetsEntiry = new CreditBrAssetsEntiry();
		creditBrAssetsEntiry.setCar(assetsDto.getCar());
		creditBrAssetsEntiry.setHouse(assetsDto.getHouse());
		creditBrAssetsEntiry.setFin(assetsDto.getFin());
		creditBrAssetsEntiry.setWealth(assetsDto.getWealth());
		creditBrAssetsEntiry.setSwiftNumber(assetsDto.getSwiftNumber());
		creditBrAssetsEntiry.setCreateDate(new Date());
		creditBrAssetsEntiry.setCreateUser("danggang");
		creditBrAssetsEntiry.setUpdateDate(new Date());
		creditBrAssetsEntiry.setUpdateUser("danggang");
		creditBrAssetsEntiryDto.save(creditBrAssetsEntiry);
		
	}

}
