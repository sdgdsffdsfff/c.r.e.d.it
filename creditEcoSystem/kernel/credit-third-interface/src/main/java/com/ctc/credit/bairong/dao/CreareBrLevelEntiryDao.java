package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreareBrLevelEntiry;
import com.ctc.credit.bairong.model.CreateBrCommodityEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreareBrLevelEntiryDao extends GenericDao<CreareBrLevelEntiry, String>{
	public void saveLevleList(ArrayList<CreareBrLevelEntiry> lists);
}
