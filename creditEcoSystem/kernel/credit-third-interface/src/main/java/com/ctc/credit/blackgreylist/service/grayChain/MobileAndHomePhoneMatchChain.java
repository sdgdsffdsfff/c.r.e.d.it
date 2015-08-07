package com.ctc.credit.blackgreylist.service.grayChain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IAbstractGrayMatchChain;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;


/**
 * 匹配灰名单 B 类型
 * @author zhangwenjun
 *
 */
@Component
public class MobileAndHomePhoneMatchChain  extends IAbstractGrayMatchChain {
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	private List<Map<String,Object>> result;
	
	@Override
	public List<Map<String, Object>> doMatch(HandleRequest requestInfo) {
		result = new ArrayList<Map<String,Object>>();
		// TODO Auto-generated method stub
		List<Map<String,Object>> matchResult = blkgrayListRoleServiceImpl.matchMobileAndHomePhone(requestInfo.getMobile(),requestInfo.getPhone());
		Map<String,Object> pTemp = null;
		
		
		//如果匹配到了则合并数据
		Map<String,String> matchInfo = new HashMap<String,String>();
		for(Map<String,Object> mr  : matchResult){
			String info = matchInfo.get(mr.get("TIGGER_SOURCE").toString());
			matchInfo.put(mr.get("TIGGER_SOURCE").toString()+"_"+mr.get("PRIORITY").toString(), (info == null?"":info+" ")+mr.get("TIGGER_INFO"));
		}
		
		for(String key : matchInfo.keySet()){
			Map<String,Object> mm = new HashMap<String,Object>();
			mm.put("glistInfo", matchInfo.get(key));
			mm.put("glistTrigger", key.split("_")[0]);
			if("4".equals(key.split("_")[1])){
				mm.put("glistName", "疑似欺诈客户灰名单D");
			}else{
				mm.put("glistName", "关注电话黑名单超时转灰");
			}
				mm.put("glistRole", "手机号码||住宅电话");
			result.add(mm);
		}
		
		
		//如果没有下一级,直接返回结果
		if(this.getNextChain() == null){
			return result;
		}else{
			result.addAll(this.getNextChain().doMatch(requestInfo));
		}
		
		
		return result;
	}
}
