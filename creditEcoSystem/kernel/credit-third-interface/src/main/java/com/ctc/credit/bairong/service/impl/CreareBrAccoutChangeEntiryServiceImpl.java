package com.ctc.credit.bairong.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.account.AccountChangeDto;
import com.ctc.credit.bairong.api.dto.account.AccountTypeDto;
import com.ctc.credit.bairong.api.dto.account.CreditcardDto;
import com.ctc.credit.bairong.api.dto.account.DebitcardDto;
import com.ctc.credit.bairong.api.dto.account.MonthPeriodDto;
import com.ctc.credit.bairong.dao.CreareBrAccoutChangeEntiryDao;
import com.ctc.credit.bairong.model.CreareBrAccoutChangeEntiry;
import com.ctc.credit.bairong.service.CreareBrAccoutChangeEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
@Service
@Transactional
public class CreareBrAccoutChangeEntiryServiceImpl extends GenericServiceImpl<CreareBrAccoutChangeEntiry,String>
implements CreareBrAccoutChangeEntiryService{

	private static Logger logger = Logger.getLogger(CreareBrAccoutChangeEntiryServiceImpl.class);
	
	@Autowired
	CreareBrAccoutChangeEntiryDao creareBrAccoutChangeEntiryDto;
	
	public CreareBrAccoutChangeEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveAccoutChangeInfo(AccountChangeDto accountChangeDto){
		// TODO Auto-generated method stub
		List<CreareBrAccoutChangeEntiry> lists = new ArrayList<CreareBrAccoutChangeEntiry>();
		List<MonthPeriodDto> monthPeriodLists = accountChangeDto.getMonthPeriodDto();
		monthPeriodLists.size();
		Iterator monthPeriodKeys = monthPeriodLists.iterator();
		//过去月份
		while(monthPeriodKeys.hasNext()){
			MonthPeriodDto monthPeriodDto = (MonthPeriodDto) monthPeriodKeys.next();
			List<AccountTypeDto> accountTypeLists = monthPeriodDto.getAccountTypeDto();
			Iterator accountTypeKeys = accountTypeLists.iterator();
			//账户类型
			while(accountTypeKeys.hasNext()){
				CreareBrAccoutChangeEntiry creareBrAccoutChangeEntiry = new CreareBrAccoutChangeEntiry();
				AccountTypeDto accountTypeDto = (AccountTypeDto) accountTypeKeys.next();
				
				//信用卡
				CreditcardDto creditcardDto = accountTypeDto.getCreditcard();
				if (creditcardDto != null) {
					creareBrAccoutChangeEntiry.setCash(creditcardDto.getCash());
					creareBrAccoutChangeEntiry.setOverDue(creditcardDto.getOverdue());
					creareBrAccoutChangeEntiry.setIncome(creditcardDto.getIncome());
					creareBrAccoutChangeEntiry.setOutgo(creditcardDto.getOutgo());
					creareBrAccoutChangeEntiry.setStatus(creditcardDto.getStatus());
				}								
				DebitcardDto debitcardDto = accountTypeDto.getDebitcard();
				//储蓄卡
				if (debitcardDto!= null) {
					creareBrAccoutChangeEntiry.setBalance(debitcardDto.getBalance());
					creareBrAccoutChangeEntiry.setIncome(debitcardDto.getIncome());
					creareBrAccoutChangeEntiry.setOutgo(debitcardDto.getOutgo());
					creareBrAccoutChangeEntiry.setInvestment(debitcardDto.getInvestment());
					creareBrAccoutChangeEntiry.setRepay(debitcardDto.getRepay());

				}
				if (accountTypeDto.getLoan()!= null) {
					creareBrAccoutChangeEntiry.setLoan(accountTypeDto.getLoan());
				}
				//赋值
				creareBrAccoutChangeEntiry.setSwiftNumber(accountChangeDto.getSwiftNumber());
				creareBrAccoutChangeEntiry.setCardindex(accountChangeDto.getCardindex());
				creareBrAccoutChangeEntiry.setRegionno(accountChangeDto.getRegionno());
				creareBrAccoutChangeEntiry.setMonths(monthPeriodDto.getMonthPeriod());
				creareBrAccoutChangeEntiry.setAccountType(accountTypeDto.getAccountType());				
				creareBrAccoutChangeEntiry.setCreateUser("danggang");
				creareBrAccoutChangeEntiry.setCreateDate(new Date());
				creareBrAccoutChangeEntiry.setUpdateUser("danggang");
				creareBrAccoutChangeEntiry.setUpdateDate(new Date());
				lists.add(creareBrAccoutChangeEntiry);
			}
		}
		creareBrAccoutChangeEntiryDto.saveAccountChangeList((ArrayList<CreareBrAccoutChangeEntiry>) lists);
	}

}
