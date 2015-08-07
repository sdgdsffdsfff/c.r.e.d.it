package com.ctc.credit.qianhai.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.qianhai.model.CreditQhBlkListEntity;
import com.ctc.credit.qianhai.service.CreditQhBlkListEntityService;

@Service
@Transactional
public class CreditQhBlkListEntityServiceImpl extends GenericServiceImpl<CreditQhBlkListEntity, String> implements
		CreditQhBlkListEntityService {

}
