package com.ctc.credit.lakala.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.lakala.model.LklApplyBlkList;
import com.ctc.credit.lakala.service.ILklApplyBlkListService;

@Service
@Transactional
public class LklApplyBlkListServiceImpl extends
		GenericServiceImpl<LklApplyBlkList, String> implements
		ILklApplyBlkListService {

}
