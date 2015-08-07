package com.ctc.credit.bairong.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.stabliity.StabilityDto;
import com.ctc.credit.bairong.dao.CreditBrStabilityEntiryDao;
import com.ctc.credit.bairong.model.CreditBrStabilityEntiry;
import com.ctc.credit.bairong.service.CreditBrStabilityEntiryService;
import com.ctc.credit.kernel.base.BaseSearchBean;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.kernel.base.PageList;
import com.ctc.credit.kernel.base.ParamBean;
import com.ctc.credit.kernel.base.ResultBean;
/**
 * 百融：稳定性评估Service实现类
 * @author danggang
 *
 */
@Service
@Transactional
public class CreditBrStabilityEntiryServiceImpl extends GenericServiceImpl<CreditBrStabilityEntiry, String>
		implements CreditBrStabilityEntiryService {
	
	private static Logger logger = Logger.getLogger(CreditBrStabilityEntiryServiceImpl.class);
	
	@Autowired
	CreditBrStabilityEntiryDao creditBrStabilityEntiryDao;
	
	public CreditBrStabilityEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public void saveStabilityInfo(StabilityDto stabilityDto) {
		// TODO Auto-generated method stub
		CreditBrStabilityEntiry creditBrStabilityEntiry = new CreditBrStabilityEntiry();
		creditBrStabilityEntiry.setSwiftNumber(stabilityDto.getSwiftNumber());
		creditBrStabilityEntiry.setIdNo(stabilityDto.getId().getNumber());
		creditBrStabilityEntiry.setCellNo(stabilityDto.getCell().getNumber());
		creditBrStabilityEntiry.setCellFirsttime(stabilityDto.getCell().getFirsttime());
		creditBrStabilityEntiry.setNameNo(stabilityDto.getName().getNumber());
		creditBrStabilityEntiry.setMailNo(stabilityDto.getMail().getNumber());
		creditBrStabilityEntiry.setTelNo(stabilityDto.getTel().getNumber());
		creditBrStabilityEntiry.setAddrNo(stabilityDto.getAddr().getNumber());
		creditBrStabilityEntiry.setCreateUser("danggang");
		creditBrStabilityEntiry.setCreateDate(new Date());
		creditBrStabilityEntiry.setUpdateUser("danggang");
		creditBrStabilityEntiry.setUpdateDate(new Date());
		creditBrStabilityEntiryDao.save(creditBrStabilityEntiry);
	}

	
}
