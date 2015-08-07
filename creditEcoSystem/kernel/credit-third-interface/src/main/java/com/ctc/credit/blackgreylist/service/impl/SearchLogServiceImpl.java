package com.ctc.credit.blackgreylist.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.dao.ISearchLogDao;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistSearchLogEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.ISearchLogService;
import com.ctc.credit.kernel.base.GenericServiceImpl;


@Service
@Transactional
public class SearchLogServiceImpl extends GenericServiceImpl<CreditBlkgraylistSearchLogEntity, String>
implements ISearchLogService{

	@Autowired
	ISearchLogDao searchLogHibernate;
		
	@Override
	public void saveBlackSearchLog(String dangerInfo, HandleRequest hr,
			Map<String, Object> result,String trigger_source) {
		// TODO Auto-generated method stub
		Date today = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CreditBlkgraylistSearchLogEntity csle = new CreditBlkgraylistSearchLogEntity();
		csle.setApplyNo(hr.getApplyCode());
		csle.setApplyInfo(dangerInfo);
		csle.setCreateTime(sdf.format(today));
		csle.setIsMatch(result.get("status").toString());
		csle.setMatchedInfo(result.get("rejectTigger").toString());
		csle.setMatchedRoleInfo(result.get("rejectInfo").toString());
		csle.setSearchType(0);
		csle.setTiggerSource(trigger_source);
		
		searchLogHibernate.saveSearchLog(csle);
	}

	@Override
	public void saveGraykSearchLog(String dangerInfo, HandleRequest hr,
			Map<String, Object> result) {
		// TODO Auto-generated method stub
		Date today = new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CreditBlkgraylistSearchLogEntity csle = new CreditBlkgraylistSearchLogEntity();
		csle.setApplyNo(hr.getApplyCode());
		csle.setApplyInfo(dangerInfo);
		csle.setCreateTime(sdf.format(today));
		csle.setIsMatch(result.get("status").toString());
		csle.setSearchType(1);
		
//		String info = result.get("greyListInfo").toString();
		
		JSONObject mapObject  = JSONObject.fromObject(result);
		JSONArray jarray = mapObject.getJSONArray("greyListInfo");
		
		if(jarray.size() == 0 ){
			searchLogHibernate.saveSearchLog(csle);
		}else{
			for(int i = 0 ; i < jarray.size() ; i ++){
				JSONObject jo = (JSONObject)jarray.get(i);
				csle.setMatchedInfo(jo.getString("glistInfo"));
				csle.setMatchedRoleInfo(jo.getString("glistName"));
				csle.setTiggerSource(jo.getString("glistTrigger"));
				searchLogHibernate.saveSearchLog(csle);
			}
		}
		
	}

}
