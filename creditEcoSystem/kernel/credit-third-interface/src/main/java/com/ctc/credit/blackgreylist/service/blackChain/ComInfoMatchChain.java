package com.ctc.credit.blackgreylist.service.blackChain;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IAbstractBlackMatchChain;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;


@Component
public class ComInfoMatchChain  extends IAbstractBlackMatchChain {
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	private Map<String,Object> result;
	
	@Override
	public Map<String, Object> doMatch(HandleRequest requestInfo) {
		result = null;
		// TODO Auto-generated method stub
		List<Map<String,Object>> matchResult = blkgrayListRoleServiceImpl.matchCompanyInfo(requestInfo.getCompanyAddressDetail(),requestInfo.getCompanyName(),requestInfo.getCompanyPhone());
//		Map<String,Object> pTemp = null;
		
		
		//如果没有下一级,直接返回结果
		if(this.getNextChain() == null){
			return matchResult.get(0);
		}
		
		//如果没有匹配到则直接返回后面的匹配结果
		if(matchResult == null || matchResult.isEmpty()){
			result =  this.getNextChain().doMatch(requestInfo);
		}else{
			//如果匹配到了需要比较规则优先级
			Map<String,Object> matchInfo = matchResult.get(0);
//			Integer priority = Integer.parseInt(matchInfo.get("priority") == null ? "999" :matchInfo.get("priority")+"");
			
			result = matchInfo;
			
//					如果匹配到应该是最有选择
//					//规则判断如果优先级小于三 则没有必要判断其他规则.直接返回结果
//					if(priority != 12){
//						pTemp = this.getNextChain().doMatch(requestInfo);
//						if(Integer.parseInt(pTemp.get("priority")+"") < priority){
//							result = pTemp;
//						}
//					}
			
		}
		
		
		return result;
	}
}
