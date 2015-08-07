/**
 * 
 */
package com.ctc.credit.bairong.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.DegreeDto;
import com.ctc.credit.bairong.api.dto.SpecialListDto;
import com.ctc.credit.bairong.dao.CreareBrSpeciallistInfoDao;
import com.ctc.credit.bairong.model.CreareBrSpeciallistInfo;
import com.ctc.credit.bairong.service.CreareBrSpeciallistService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

/**
 * @author Chengang
 * 2015年8月3日 下午2:49:27 
 */
@Service
@Transactional
public class CreareBrSpeciallistServiceImpl extends GenericServiceImpl<CreareBrSpeciallistInfo, String> implements CreareBrSpeciallistService{
	
	@Autowired
	CreareBrSpeciallistInfoDao creareBrSpeciallistInfoDao;

	@Override
	public void saveSpeciallistInfo(SpecialListDto dto){
		CreareBrSpeciallistInfo info = new CreareBrSpeciallistInfo();
		try {
			List<DegreeDto> degreeList = dto.getDegreeList();
			for (DegreeDto degreeDto : degreeList) {
				BeanUtils.copyProperties(info, degreeDto);
				info.setSwiftNo(dto.getSwiftNo());
				creareBrSpeciallistInfoDao.save(info);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
