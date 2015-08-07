package com.ctc.credit.bairong.service.impl;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.BrReportRequestDto;
import com.ctc.credit.bairong.dao.CreareBrRequestEntieyDao;
import com.ctc.credit.bairong.model.CreareBrRequestEntiey;
import com.ctc.credit.bairong.service.CreareBrRequestEntieyService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

@Service
@Transactional
public class CreareBrRequestEntieyServiceImpl extends GenericServiceImpl<CreareBrRequestEntiey,String>
	implements CreareBrRequestEntieyService{

	private static Logger logger = Logger.getLogger(CreareBrRequestEntieyServiceImpl.class);
	
	@Autowired
	CreareBrRequestEntieyDao creareBrRequestEntieyDao;
	
	public CreareBrRequestEntieyServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveRequestInfo(BrReportRequestDto brReportRequestDto) {
		CreareBrRequestEntiey creareBrRequestEntiey = new CreareBrRequestEntiey();
		creareBrRequestEntiey.setAge(brReportRequestDto.getAge());
		creareBrRequestEntiey.setApplyAddr(brReportRequestDto.getApplyAddr());
		creareBrRequestEntiey.setApplyMoney(brReportRequestDto.getApplyMoney());
		creareBrRequestEntiey.setApplyProduct(brReportRequestDto.getApplyProduct());
		creareBrRequestEntiey.setApplySource(brReportRequestDto.getApplySource());
		creareBrRequestEntiey.setApplyTime(brReportRequestDto.getApplyTime());		
		creareBrRequestEntiey.setAppVisitNum(brReportRequestDto.getAppVisitNum());
		creareBrRequestEntiey.setBankId(brReportRequestDto.getBankId());
		creareBrRequestEntiey.setBankRunningAttNum(brReportRequestDto.getBankRunningAttNum());
		creareBrRequestEntiey.setBizAddr(brReportRequestDto.getBizAddr());
		creareBrRequestEntiey.setBizIndustry(brReportRequestDto.getBizIndustry());
		creareBrRequestEntiey.setBizPositon(brReportRequestDto.getBizPositon());
		creareBrRequestEntiey.setBizType(brReportRequestDto.getBizType());
		creareBrRequestEntiey.setBizWorkfor(brReportRequestDto.getBizWorkfor());
		creareBrRequestEntiey.setCell(brReportRequestDto.getCell());
		creareBrRequestEntiey.setCreateDate(new Date());
		creareBrRequestEntiey.setCreateUser("danggang");
		creareBrRequestEntiey.setEduAttNum(brReportRequestDto.getEduAttNum());
		creareBrRequestEntiey.setEducationallevel(brReportRequestDto.getEducationallevel());
		creareBrRequestEntiey.setGid(brReportRequestDto.getGid());
		creareBrRequestEntiey.setHomeAddr(brReportRequestDto.getHomeAddr());
		creareBrRequestEntiey.setHouseType(brReportRequestDto.getHouseType());
		creareBrRequestEntiey.setIdCardNo(brReportRequestDto.getIdCardNo());
		creareBrRequestEntiey.setImei(brReportRequestDto.getImei());
		creareBrRequestEntiey.setImsi(brReportRequestDto.getImsi());
		creareBrRequestEntiey.setIncome(brReportRequestDto.getIncome());
		creareBrRequestEntiey.setLinkmanAddr(brReportRequestDto.getLinkmanAddr());
		creareBrRequestEntiey.setLinkmanCell(brReportRequestDto.getLinkmanCell());
		creareBrRequestEntiey.setLinkmanName(brReportRequestDto.getLinkmanName());
		creareBrRequestEntiey.setLinkmanRela(brReportRequestDto.getLinkmanRela());
		creareBrRequestEntiey.setLoanReason(brReportRequestDto.getLoanReason());
		creareBrRequestEntiey.setMail(brReportRequestDto.getMail());
		creareBrRequestEntiey.setMarriage(brReportRequestDto.getMarriage());
		creareBrRequestEntiey.setMerchantName(brReportRequestDto.getMerchantName());
		creareBrRequestEntiey.setMerchantPwd(brReportRequestDto.getMerchantPwd());
		creareBrRequestEntiey.setMobileType(brReportRequestDto.getMobileType());
		creareBrRequestEntiey.setName(brReportRequestDto.getName());
		creareBrRequestEntiey.setOthAddr(brReportRequestDto.getOthAddr());
		creareBrRequestEntiey.setPerAddr(brReportRequestDto.getPerAddr());
		creareBrRequestEntiey.setPostalcode(brReportRequestDto.getPostalcode());
		creareBrRequestEntiey.setRefundPeriods(brReportRequestDto.getRefundPeriods());
		creareBrRequestEntiey.setRequestTime(brReportRequestDto.getRequestDate());
		creareBrRequestEntiey.setSex(brReportRequestDto.getSex());
		creareBrRequestEntiey.setTelBiz(brReportRequestDto.getTelBiz());
		creareBrRequestEntiey.setTelHome(brReportRequestDto.getTelHome());
		creareBrRequestEntiey.setTonkenId(brReportRequestDto.getTonkenId());
		creareBrRequestEntiey.setUpdateDate(new Date());
		creareBrRequestEntiey.setUpdateUser("danggang");
		
		creareBrRequestEntieyDao.save(creareBrRequestEntiey);
	}

}
