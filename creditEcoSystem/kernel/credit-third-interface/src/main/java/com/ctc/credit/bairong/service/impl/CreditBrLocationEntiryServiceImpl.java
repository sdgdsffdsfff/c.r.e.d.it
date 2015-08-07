package com.ctc.credit.bairong.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.location.LocationDto;
import com.ctc.credit.bairong.dao.CreditBrLocationEntiryDao;
import com.ctc.credit.bairong.model.CreditBrLocationEntiry;
import com.ctc.credit.bairong.service.CreditBrLocationEntiryService;
import com.ctc.credit.kernel.base.BaseSearchBean;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.base.PageList;
import com.ctc.credit.kernel.base.ParamBean;
import com.ctc.credit.kernel.base.ResultBean;
/**
 * 百融：位置信息核查Service实现类
 * @author danggang
 *
 */
@Service
@Transactional
public class CreditBrLocationEntiryServiceImpl extends GenericServiceImpl<CreditBrLocationEntiry,String> 
		implements CreditBrLocationEntiryService {

	private static Logger logger = Logger.getLogger(CreditBrLocationEntiryServiceImpl.class);
	
	@Autowired
	CreditBrLocationEntiryDao creditBrLocationEntiryDao;
	
	public CreditBrLocationEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	@Override
	public void saveLocationInfo(LocationDto locationDto) {
		// TODO Auto-generated method stub
		CreditBrLocationEntiry creditBrLocationEntiry = new CreditBrLocationEntiry();
		creditBrLocationEntiry.setSwiftNumber(locationDto.getSwiftNumber());	
		creditBrLocationEntiry.setAddr11(locationDto.getHome_addr().getAddr11());
		creditBrLocationEntiry.setAddr12(locationDto.getHome_addr().getAddr12());
		creditBrLocationEntiry.setAddr13(locationDto.getHome_addr().getAddr13());
		creditBrLocationEntiry.setAddr14(locationDto.getHome_addr().getAddr14());
		creditBrLocationEntiry.setAddr15(locationDto.getHome_addr().getAddr15());
		creditBrLocationEntiry.setAddr21(locationDto.getBiz_addr().getAddr21());
		creditBrLocationEntiry.setAddr22(locationDto.getBiz_addr().getAddr22());
		creditBrLocationEntiry.setAddr23(locationDto.getBiz_addr().getAddr23());
		creditBrLocationEntiry.setAddr24(locationDto.getBiz_addr().getAddr24());
		creditBrLocationEntiry.setAddr25(locationDto.getBiz_addr().getAddr25());
		creditBrLocationEntiry.setAddr31(locationDto.getPer_addr().getAddr31());
		creditBrLocationEntiry.setAddr32(locationDto.getPer_addr().getAddr32());
		creditBrLocationEntiry.setAddr33(locationDto.getPer_addr().getAddr33());
		creditBrLocationEntiry.setAddr34(locationDto.getPer_addr().getAddr34());
		creditBrLocationEntiry.setAddr35(locationDto.getPer_addr().getAddr35());
		creditBrLocationEntiry.setAddr41(locationDto.getApply_addr().getAddr41());
		creditBrLocationEntiry.setAddr42(locationDto.getApply_addr().getAddr42());
		creditBrLocationEntiry.setAddr43(locationDto.getApply_addr().getAddr43());
		creditBrLocationEntiry.setAddr44(locationDto.getApply_addr().getAddr44());
		creditBrLocationEntiry.setAddr45(locationDto.getApply_addr().getAddr45());
		creditBrLocationEntiry.setAddr51(locationDto.getOth_addr().getAddr51());
		creditBrLocationEntiry.setAddr52(locationDto.getOth_addr().getAddr52());
		creditBrLocationEntiry.setAddr53(locationDto.getOth_addr().getAddr53());
		creditBrLocationEntiry.setAddr54(locationDto.getOth_addr().getAddr54());
		creditBrLocationEntiry.setAddr55(locationDto.getOth_addr().getAddr55());
		creditBrLocationEntiry.setCreateUser("danggang");
		creditBrLocationEntiry.setCreateDate(new Date());
		creditBrLocationEntiry.setUpdateUser("danggang");
		creditBrLocationEntiry.setUpdateDate(new Date());
		creditBrLocationEntiryDao.save(creditBrLocationEntiry);
	}
}
