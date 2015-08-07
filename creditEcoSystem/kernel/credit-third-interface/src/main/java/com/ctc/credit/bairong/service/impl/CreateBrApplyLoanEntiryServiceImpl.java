package com.ctc.credit.bairong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.applyLoan.ApplyLoanDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyNoDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyOragnDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyTypeDto;
import com.ctc.credit.bairong.api.dto.applyLoan.MonthDto;
import com.ctc.credit.bairong.dao.CreateBrApplyLoanEntiryDto;
import com.ctc.credit.bairong.model.CreateBrApplyLoanEntiry;
import com.ctc.credit.bairong.service.CreateBrApplyLoanEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
@Service
@Transactional
public class CreateBrApplyLoanEntiryServiceImpl extends GenericServiceImpl<CreateBrApplyLoanEntiry,String> 
		implements CreateBrApplyLoanEntiryService {

	private static Logger logger = Logger.getLogger(CreateBrApplyLoanEntiryServiceImpl.class);
	
	@Autowired
	CreateBrApplyLoanEntiryDto createBrApplyLoanEntiryDto;
	
	public CreateBrApplyLoanEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveApplyInfo(ApplyLoanDto applyLoanDto) {
		// TODO Auto-generated method stub
		List<MonthDto> applyLists = applyLoanDto.getMonthDto();
		List<CreateBrApplyLoanEntiry> lists = new ArrayList<CreateBrApplyLoanEntiry>();
		Iterator it = applyLists.iterator();
		while(it.hasNext()){
			MonthDto monthDto = (MonthDto) it.next();
			List<ApplyTypeDto> applyTypeLists = monthDto.getApplyType();
			Iterator typeKeys = applyTypeLists.iterator();
			while(typeKeys.hasNext()){
				ApplyTypeDto applyTypeDto = (ApplyTypeDto) typeKeys.next();
				List<ApplyOragnDto> applyOragnLists = applyTypeDto.getApplyOragn();
				Iterator oragnKeys = applyOragnLists.iterator();
				while (oragnKeys.hasNext()) {
					ApplyOragnDto applyOragnDto = (ApplyOragnDto) oragnKeys.next();
					List<ApplyNoDto> applyNoLists = applyOragnDto.getApplyNo();
					Iterator noKeys = applyNoLists.iterator();
					while (noKeys.hasNext()) {
						ApplyNoDto applyNoDto = (ApplyNoDto) noKeys.next();
						CreateBrApplyLoanEntiry createBrApplyLoanEntiry = new CreateBrApplyLoanEntiry();
						createBrApplyLoanEntiry.setSwiftNumber(applyLoanDto.getSwiftNumber());
						createBrApplyLoanEntiry.setMonth(monthDto.getMonth());
						createBrApplyLoanEntiry.setApplyType(applyTypeDto.getApplyType());
						createBrApplyLoanEntiry.setApplyOrgan(applyOragnDto.getApplyOragn());
						createBrApplyLoanEntiry.setSelfnumber(applyNoDto.getSelfnumber());
						createBrApplyLoanEntiry.setOrgnumber(applyNoDto.getOrgnumber());
						createBrApplyLoanEntiry.setAllnumber(applyNoDto.getAllnumber());
						createBrApplyLoanEntiry.setCreateUser("danggang");
						createBrApplyLoanEntiry.setCreateDate(new Date());
						createBrApplyLoanEntiry.setUpdateUser("danggang");
						createBrApplyLoanEntiry.setUpdateDate(new Date());
						lists.add(createBrApplyLoanEntiry);
					}
				}
			}
		}
		createBrApplyLoanEntiryDto.saveApplyList((ArrayList<CreateBrApplyLoanEntiry>) lists);
	}

}
