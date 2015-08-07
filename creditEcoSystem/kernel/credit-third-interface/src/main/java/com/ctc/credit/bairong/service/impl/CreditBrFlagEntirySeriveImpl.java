package com.ctc.credit.bairong.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.flag.FlagDto;
import com.ctc.credit.bairong.dao.CreditBrFlagEntiryDao;
import com.ctc.credit.bairong.model.CreditBrFlagEntiry;
import com.ctc.credit.bairong.service.CreditBrFlagEntirySerive;
import com.ctc.credit.kernel.base.BaseSearchBean;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.base.PageList;
import com.ctc.credit.kernel.base.ParamBean;
import com.ctc.credit.kernel.base.ResultBean;
@Service
@Transactional
public class CreditBrFlagEntirySeriveImpl extends GenericServiceImpl<CreditBrFlagEntiry, String> implements CreditBrFlagEntirySerive {

	private static Logger logger = Logger.getLogger(CreditBrFlagEntirySeriveImpl.class);
	
	
	public CreditBrFlagEntirySeriveImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	CreditBrFlagEntiryDao creditBrFlagEntiryDto;
	/**
	 * 百融：保存报告输出标识信息实现
	 */
	@Override
	public void saveFlagInfo(FlagDto flagDto) {
		// TODO Auto-generated method stub
		CreditBrFlagEntiry creditBrFlagEntiry = new CreditBrFlagEntiry();
		creditBrFlagEntiry.setSwiftNumber(flagDto.getSwiftNumber());
		creditBrFlagEntiry.setCoreKey(flagDto.getCore().getKey());
		creditBrFlagEntiry.setCoreGid(flagDto.getCore().getGid());	
		creditBrFlagEntiry.setAl(flagDto.getApplyLoan());
		creditBrFlagEntiry.setScore(flagDto.getScore());
		creditBrFlagEntiry.setSl(flagDto.getSpecialList());
		creditBrFlagEntiry.setAc(flagDto.getAccountchange());
		creditBrFlagEntiry.setPc(flagDto.getPayConsumption());
		creditBrFlagEntiry.setCreateUser("danggang");
		creditBrFlagEntiry.setCreateDate(new Date());
		creditBrFlagEntiry.setUpdateUser("danggang");
		creditBrFlagEntiry.setUpdateDate(new Date());
		creditBrFlagEntiryDto.save(creditBrFlagEntiry);
	}

}
