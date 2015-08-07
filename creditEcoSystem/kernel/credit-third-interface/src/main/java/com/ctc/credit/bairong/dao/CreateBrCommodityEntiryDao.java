package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreateBrCommodityEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreateBrCommodityEntiryDao  extends GenericDao<CreateBrCommodityEntiry, String>{

	public void saveCommdityList(ArrayList<CreateBrCommodityEntiry> lists);
}
