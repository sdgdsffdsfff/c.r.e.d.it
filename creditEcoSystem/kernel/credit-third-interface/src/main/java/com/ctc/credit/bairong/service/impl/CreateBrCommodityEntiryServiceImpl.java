package com.ctc.credit.bairong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.consumption.AssessmentDto;
import com.ctc.credit.bairong.api.dto.consumption.CommodityTypeDto;
import com.ctc.credit.bairong.api.dto.consumption.ConsumptionDto;
import com.ctc.credit.bairong.api.dto.consumption.EvaluationContentDto;
import com.ctc.credit.bairong.api.dto.consumption.LevelDto;
import com.ctc.credit.bairong.dao.CreareBrLevelEntiryDao;
import com.ctc.credit.bairong.dao.CreateBrCommodityEntiryDao;
import com.ctc.credit.bairong.model.CreareBrLevelEntiry;
import com.ctc.credit.bairong.model.CreateBrCommodityEntiry;
import com.ctc.credit.bairong.service.CreateBrCommodityEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
/**
 * 百融：商品评估Service实现
 * @author danggang
 *
 */
@Service
@Transactional
public class CreateBrCommodityEntiryServiceImpl extends GenericServiceImpl<CreateBrCommodityEntiry, String>
		implements CreateBrCommodityEntiryService{
	private static Logger logger = Logger.getLogger(CreateBrCommodityEntiryServiceImpl.class);
	
	@Autowired
	CreateBrCommodityEntiryDao createBrCommodityEntiryDao;
	
	@Autowired
	CreareBrLevelEntiryDao creareBrLevelEntiryDao;
	
	public CreateBrCommodityEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveCommodityInfo(ConsumptionDto consumptionDto) {
		// TODO Auto-generated method stub		
		ArrayList<AssessmentDto> list = consumptionDto.getAssessmentType();
		List<CreateBrCommodityEntiry> commodityLists = new ArrayList<CreateBrCommodityEntiry>();
		List<CreareBrLevelEntiry> levelLists = new ArrayList<CreareBrLevelEntiry>();
		Iterator it = list.iterator();
		while(it.hasNext()){			
			AssessmentDto assessmentDto = (AssessmentDto) it.next();			
			String str = assessmentDto.getAssessmentType().toString();
			if(str.indexOf("level")!=-1){
				ArrayList<LevelDto> list3 = assessmentDto.getLevelDto();				
				Iterator it3 = list3.iterator();
				while(it3.hasNext()){
					CreareBrLevelEntiry creareBrLevelEntiry = new CreareBrLevelEntiry();
					LevelDto levelDto = (LevelDto) it3.next();
					creareBrLevelEntiry.setMerchandiseType(levelDto.getCommodityType());
					creareBrLevelEntiry.setLevel(levelDto.getLevelRanking());
					creareBrLevelEntiry.setCreateDate(new Date());
					creareBrLevelEntiry.setCreateUser("da");
					creareBrLevelEntiry.setUpdateDate(new Date());
					creareBrLevelEntiry.setUpdateUser("dd");
					levelLists.add(creareBrLevelEntiry);
				}
				creareBrLevelEntiryDao.saveLevleList((ArrayList<CreareBrLevelEntiry>) levelLists);
			}
			else{
				ArrayList<CommodityTypeDto> list1 = assessmentDto.getCommodityTypeDto();
				Iterator it1 = list1.iterator();
				while(it1.hasNext()){
					CommodityTypeDto CommodityTypeDto = (CommodityTypeDto) it1.next();
					ArrayList<EvaluationContentDto> list2 = CommodityTypeDto.getEvaluationContentDto();
					Iterator it2 = list2.iterator();
					while(it2.hasNext()){
						CreateBrCommodityEntiry createBrCommodityEntiry = new CreateBrCommodityEntiry();
						createBrCommodityEntiry.setSwiftNumber(consumptionDto.getSwiftNumber());
						EvaluationContentDto EvaluationContentDto = (EvaluationContentDto) it2.next();												
						createBrCommodityEntiry.setMonth(assessmentDto.getAssessmentType().toString());						
						createBrCommodityEntiry.setMerchandiseType(CommodityTypeDto.getCommodityType());
						createBrCommodityEntiry.setVisits(EvaluationContentDto.getVisits());
						createBrCommodityEntiry.setNo(EvaluationContentDto.getNumber());
						createBrCommodityEntiry.setPay(EvaluationContentDto.getPay());
						createBrCommodityEntiry.setMaxPay(EvaluationContentDto.getMaxpay());						
						createBrCommodityEntiry.setCreateDate(new Date());
						createBrCommodityEntiry.setCreateUser("党");
						createBrCommodityEntiry.setUpdateDate(new Date());
						createBrCommodityEntiry.setUpdateUser("haha");
						commodityLists.add(createBrCommodityEntiry);						
					}
				}	
			}	
			
        }
		createBrCommodityEntiryDao.saveCommdityList((ArrayList<CreateBrCommodityEntiry>) commodityLists);
		System.out.println(commodityLists);
	}

}
