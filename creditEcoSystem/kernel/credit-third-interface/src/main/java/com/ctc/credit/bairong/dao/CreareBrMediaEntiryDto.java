package com.ctc.credit.bairong.dao;

import java.util.ArrayList;

import com.ctc.credit.bairong.model.CreareBrMediaEntiry;
import com.ctc.credit.kernel.base.GenericDao;

public interface CreareBrMediaEntiryDto extends GenericDao<CreareBrMediaEntiry,String>{
	public void saveMediaList(ArrayList<CreareBrMediaEntiry> lists);
}
