package com.ctc.credit.bairong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.media.CommTypeDto;
import com.ctc.credit.bairong.api.dto.media.MediaDto;
import com.ctc.credit.bairong.api.dto.media.PashMonthDto;
import com.ctc.credit.bairong.dao.CreareBrMediaEntiryDto;
import com.ctc.credit.bairong.model.CreareBrMediaEntiry;
import com.ctc.credit.bairong.service.CreareBrMediaEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
@Service
@Transactional
public class CreareBrMediaEntiryServiceImpl extends GenericServiceImpl<CreareBrMediaEntiry,String>
		implements CreareBrMediaEntiryService{
	
	private static Logger logger = Logger.getLogger(CreareBrMediaEntiryServiceImpl.class);
	
	@Autowired
	CreareBrMediaEntiryDto creareBrMediaEntiryDto;
	
	public CreareBrMediaEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveMediaInfo(MediaDto mediaDto) {
		// TODO Auto-generated method stub
		List<CreareBrMediaEntiry> lists = new ArrayList<CreareBrMediaEntiry>();
		List<PashMonthDto> psaaMonthLists = mediaDto.getMonths();
		Iterator monthKeys = psaaMonthLists.iterator();
		while(monthKeys.hasNext()){
			PashMonthDto pashMonthDto = (PashMonthDto) monthKeys.next();
			List<CommTypeDto> commTypeLists = pashMonthDto.getCommTyps();
			Iterator commKeys = commTypeLists.iterator();
			while (commKeys.hasNext()) {
				CommTypeDto commTypeDto = (CommTypeDto) commKeys.next();
				CreareBrMediaEntiry creareBrMediaEntiry = new CreareBrMediaEntiry();
				creareBrMediaEntiry.setSwiftNumber(mediaDto.getSwiftNumber());
				creareBrMediaEntiry.setMonths(pashMonthDto.getMonths());
				creareBrMediaEntiry.setCommType(commTypeDto.getCommTypes());
				creareBrMediaEntiry.setVisitdays(commTypeDto.getVisitdays());
				creareBrMediaEntiry.setCreateUser("danggang");
				creareBrMediaEntiry.setCreateDate(new Date());
				creareBrMediaEntiry.setCreateUser("danggang");
				creareBrMediaEntiry.setUpdateDate(new Date());
				lists.add(creareBrMediaEntiry);
			}
		}
		creareBrMediaEntiryDto.saveMediaList((ArrayList<CreareBrMediaEntiry>) lists);
	}

}
