package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreareBrAccoutChangeEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreareBrAccoutChangeEntiryDao extends GenericDao<CreareBrAccoutChangeEntiry,String>{
	
	public void saveAccountChangeList(ArrayList<CreareBrAccoutChangeEntiry> lists);
}
