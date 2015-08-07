/**
 * 
 */
package com.ctc.credit.bairong.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.bairong.api.dto.RatingDto;
import com.ctc.credit.bairong.dao.CreareBrRatingInfoDao;
import com.ctc.credit.bairong.model.CreareBrRatingInfo;
import com.ctc.credit.bairong.service.CreareBrRatingService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

/**
 * @author Chengang
 * 2015年8月3日 下午3:40:17 
 */
@Service
@Transactional
public class CreareBrRatingServiceImpl extends GenericServiceImpl<CreareBrRatingInfo, String> implements CreareBrRatingService {

	@Autowired
	CreareBrRatingInfoDao creareBrRatingInfoDao;
	
	@Override
	public void saveRaingInfo(RatingDto dto) {
		CreareBrRatingInfo info = new CreareBrRatingInfo();
		try {
			BeanUtils.copyProperties(info, dto);
			creareBrRatingInfoDao.save(info);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
