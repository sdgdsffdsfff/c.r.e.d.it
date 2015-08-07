/**
 * 
 */
package com.ctc.credit.bairong.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.TitleDto;
import com.ctc.credit.bairong.dao.CreareBrTitleInfoDao;
import com.ctc.credit.bairong.model.CreareBrTitleInfo;
import com.ctc.credit.bairong.service.CreareBrTitleService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

/**
 * @author Chengang
 * 2015年8月3日 下午4:05:14 
 */
@Service
@Transactional
public class CreareBrTitleServiceImpl extends GenericServiceImpl<CreareBrTitleInfo, String> implements CreareBrTitleService {

	@Autowired
	CreareBrTitleInfoDao creareBrTitleInfoDao;
	
	@Override
	public void saveTitleInfo(TitleDto dto) {
		CreareBrTitleInfo info = new CreareBrTitleInfo();
		try {
			BeanUtils.copyProperties(info, dto);
			creareBrTitleInfoDao.save(info);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
