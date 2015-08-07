/**
 * 
 */
package com.ctc.credit.bairong.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.ScoreDto;
import com.ctc.credit.bairong.dao.CreareBrScoreInfoDao;
import com.ctc.credit.bairong.model.CreareBrScoreInfo;
import com.ctc.credit.bairong.service.CreareBrScoreService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

/**
 * @author Chengang
 * 2015年8月3日 下午3:19:07 
 */
@Service
@Transactional
public class CreareBrScoreServiceImpl extends GenericServiceImpl<CreareBrScoreInfo, String> implements CreareBrScoreService {

	@Autowired
	CreareBrScoreInfoDao creareBrScoreInfoDao;
	
	@Override
	public void saveScoreInfo(ScoreDto dto) {
		CreareBrScoreInfo info = new CreareBrScoreInfo();
		try {
			BeanUtils.copyProperties(info, dto);
			creareBrScoreInfoDao.save(info);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
