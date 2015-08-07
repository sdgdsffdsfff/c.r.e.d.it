package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreareBrOnlineEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreareBrOnlineEntiryDao extends GenericDao<CreareBrOnlineEntiry,String>{
	
	public void saveOnlineList(ArrayList<CreareBrOnlineEntiry> lists);
	
}
