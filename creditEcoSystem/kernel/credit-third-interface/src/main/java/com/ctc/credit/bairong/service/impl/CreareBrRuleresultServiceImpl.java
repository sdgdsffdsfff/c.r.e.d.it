/**
 * 
 */
package com.ctc.credit.bairong.service.impl;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.bairong.api.dto.RuleResultDto;
import com.ctc.credit.bairong.dao.CreareBrRuleresultInfoDao;
import com.ctc.credit.bairong.model.CreareBrRuleresultInfo;
import com.ctc.credit.bairong.service.CreareBrRuleresultService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

/**
 * @author Chengang
 * 2015年8月3日 下午3:55:12 
 */
@Service
@Transactional
public class CreareBrRuleresultServiceImpl extends GenericServiceImpl<CreareBrRuleresultInfo, String> implements CreareBrRuleresultService {

	@Autowired
	CreareBrRuleresultInfoDao creareBrRuleresultInfoDao;
	
	@Override
	public void saveRuleresultInfo(RuleResultDto dto) {
		CreareBrRuleresultInfo info = new CreareBrRuleresultInfo();
		try {
			BeanUtils.copyProperties(info, dto);
			creareBrRuleresultInfoDao.save(info);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
