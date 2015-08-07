package com.ctc.credit.bairong.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.online.NodeOneDto;
import com.ctc.credit.bairong.api.dto.online.NodeTwoDto;
import com.ctc.credit.bairong.api.dto.online.OnlineDto;
import com.ctc.credit.bairong.api.dto.online.OnlineNoDaysDto;
import com.ctc.credit.bairong.dao.CreareBrOnlineEntiryDao;
import com.ctc.credit.bairong.model.CreareBrOnlineEntiry;
import com.ctc.credit.bairong.service.CreareBrOnlineEntiryService;
import com.ctc.credit.kernel.base.GenericServiceImpl;
@Service
@Transactional
public class CreareBrOnlineEntiryServiceImpl extends GenericServiceImpl<CreareBrOnlineEntiry,String>
		implements CreareBrOnlineEntiryService{

	private static Logger logger = Logger.getLogger(CreareBrOnlineEntiryServiceImpl.class);
	
	@Autowired
	CreareBrOnlineEntiryDao creareBrOnlineEntiryDao;
	
	public CreareBrOnlineEntiryServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveOnlineInfo(OnlineDto onlineDto) {
		// TODO Auto-generated method stub
		List<CreareBrOnlineEntiry> lists = new ArrayList<CreareBrOnlineEntiry>();
		List<NodeOneDto> nodeOneLists = onlineDto.getNodeOne();
		Iterator ondeKeys = nodeOneLists.iterator();
		while(ondeKeys.hasNext()){
			NodeOneDto nodeOneDto = (NodeOneDto) ondeKeys.next();
			List<NodeTwoDto> nodeTwoLists = nodeOneDto.getOndeTwo();
			Iterator twoKeys = nodeTwoLists.iterator();
			while(twoKeys.hasNext()){
				NodeTwoDto nodeTwoDto = (NodeTwoDto) twoKeys.next();
				List<OnlineNoDaysDto> onlineDaysLists = nodeTwoDto.getOnlineNoDays();
				Iterator dayKeys = onlineDaysLists.iterator();
				while(dayKeys.hasNext()){
					OnlineNoDaysDto onlineNoDaysDto = (OnlineNoDaysDto) dayKeys.next();
					CreareBrOnlineEntiry createBrOnlineEntiry = new CreareBrOnlineEntiry();
					createBrOnlineEntiry.setSwiftNumber(onlineDto.getSwiftNumber());
					createBrOnlineEntiry.setNodeOne(nodeOneDto.getNodeOne());
					createBrOnlineEntiry.setNodeTwo(nodeTwoDto.getNodeTwo());
					createBrOnlineEntiry.setLasttime(onlineNoDaysDto.getLasttime());
					createBrOnlineEntiry.setLastweekdays(onlineNoDaysDto.getLastweekdays());
					createBrOnlineEntiry.setTotaldays(onlineNoDaysDto.getTotaldays());
					createBrOnlineEntiry.setCreateDate(new Date());
					createBrOnlineEntiry.setCreateUser("danggang");
					createBrOnlineEntiry.setUpdateDate(new Date());
					createBrOnlineEntiry.setUpdateUser("danggang");
					lists.add(createBrOnlineEntiry);
				}
			}
		}
		creareBrOnlineEntiryDao.saveOnlineList((ArrayList<CreareBrOnlineEntiry>) lists);
	}

}
