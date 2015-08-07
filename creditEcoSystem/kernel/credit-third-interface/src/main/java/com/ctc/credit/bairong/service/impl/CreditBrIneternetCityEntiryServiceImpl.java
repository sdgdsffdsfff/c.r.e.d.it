package com.ctc.credit.bairong.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.internet.InternetDto;
import com.ctc.credit.bairong.dao.CreditBrIneternetCityEntiryDao;
import com.ctc.credit.bairong.model.CreditBrIneternetCityEntiry;
import com.ctc.credit.bairong.service.CreditBrIneternetCityEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.base.TimeUtil;
/**
 * 百融：网上信息核查service的实现
 * @author danggang
 *
 */
@Service
@Transactional
public class CreditBrIneternetCityEntiryServiceImpl extends GenericServiceImpl <CreditBrIneternetCityEntiry, String> 
	implements CreditBrIneternetCityEntiryService{
	private static Logger logger = Logger.getLogger(CreditBrIneternetCityEntiryServiceImpl.class);

	
	public CreditBrIneternetCityEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	CreditBrIneternetCityEntiryDao creditBrIneternetCityEntiryDao;
	
	@Override
	public void saveNeternetCityInfo(ArrayList<InternetDto> internetDtos) {
		// TODO Auto-generated method stub
		Iterator it = internetDtos.iterator();
		while(it.hasNext()){
			InternetDto internetDto = (InternetDto) it.next();
			CreditBrIneternetCityEntiry creditBrIneternetCityEntiry = new CreditBrIneternetCityEntiry();
			creditBrIneternetCityEntiry.setSwiftNumber(internetDto.getSwiftNumber());
			creditBrIneternetCityEntiry.setCity(internetDto.getCity());
			creditBrIneternetCityEntiry.setLasttime(TimeUtil.parseDayDate(internetDto.getInternetStatisticsDto().getLasttime()));
			creditBrIneternetCityEntiry.setLastweekdays(internetDto.getInternetStatisticsDto().getLastweekdays());
			creditBrIneternetCityEntiry.setTotaldays(internetDto.getInternetStatisticsDto().getTotaldays());
			creditBrIneternetCityEntiry.setCreateUser("danggang");
			creditBrIneternetCityEntiry.setCreateDate(new Date());
			creditBrIneternetCityEntiry.setUpdateUser("danggang");
			creditBrIneternetCityEntiry.setUpdateDate(new Date());
			creditBrIneternetCityEntiryDao.save(creditBrIneternetCityEntiry);
		}		
	}

}
