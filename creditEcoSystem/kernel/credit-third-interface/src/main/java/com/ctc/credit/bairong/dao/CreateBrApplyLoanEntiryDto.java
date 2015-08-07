package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreateBrApplyLoanEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreateBrApplyLoanEntiryDto extends GenericDao<CreateBrApplyLoanEntiry,String>{

	public void saveApplyList(ArrayList<CreateBrApplyLoanEntiry> lists);
}
