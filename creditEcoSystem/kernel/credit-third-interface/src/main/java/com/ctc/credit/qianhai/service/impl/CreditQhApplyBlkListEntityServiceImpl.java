package com.ctc.credit.qianhai.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.qianhai.dao.CreditQhBlkListEntityDao;
import com.ctc.credit.qianhai.model.CreditQhApplyBlkListEntity;
import com.ctc.credit.qianhai.service.CreditQhApplyBlkListEntityService;

@Service
@Transactional
public class CreditQhApplyBlkListEntityServiceImpl extends
		GenericServiceImpl<CreditQhApplyBlkListEntity, String> implements
		CreditQhApplyBlkListEntityService {

	@Resource(name="creditQhBlkListEntityDaoImpl")
	private CreditQhBlkListEntityDao creditQhBlkListEntityDao;
	
	
}
