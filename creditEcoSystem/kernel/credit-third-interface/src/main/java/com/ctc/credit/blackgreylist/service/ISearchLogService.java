package com.ctc.credit.blackgreylist.service;

import java.util.Map;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistSearchLogEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.kernel.base.GenericService;

public interface ISearchLogService extends GenericService<CreditBlkgraylistSearchLogEntity, String>{
	public void saveBlackSearchLog(String dangerInfo,HandleRequest hr, Map<String,Object> result,String trigger_source);
	
	public void saveGraykSearchLog(String dangerInfo,HandleRequest hr, Map<String,Object> result);
}
