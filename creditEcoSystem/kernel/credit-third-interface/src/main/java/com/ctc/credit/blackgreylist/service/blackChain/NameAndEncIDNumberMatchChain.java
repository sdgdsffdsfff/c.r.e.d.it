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
public class NameAndEncIDNumberMatchChain extends IAbstractBlackMatchChain {
	
	@Autowired
	private IBlkgrayListRoleService blkgrayListRoleServiceImpl;
	
	private Map<String,Object> result;
	
	@Override
	public Map<String, Object> doMatch(HandleRequest requestInfo) {
		result = null;
		if(requestInfo.getCardNo() == null || requestInfo.getCustomerName() == null){
			return this.getNextChain().doMatch(requestInfo);
		}
		// TODO Auto-generated method stub
		List<Map<String,Object>> matchResult = blkgrayListRoleServiceImpl.matchNameAndEncIdNumber(requestInfo.getCustomerName(),requestInfo.getCardNo());
		Map<String,Object> pTemp = null;
		
		//如果没有下一级,直接返回结果
		if(this.getNextChain() == null){
			return matchResult.get(0);
		}
		
		//如果没有匹配到则直接返回后面的匹配结果
		if(matchResult == null || matchResult.isEmpty()){
			result =  this.getNextChain().doMatch(requestInfo);
		}else{
			//如果匹配到了需要比较规则优先级
			for(Map<String,Object> mr : matchResult){
				char[] idNumber = (mr.get("TIGGER_INFO")+"").toCharArray();
				char[] yphone = requestInfo.getCardNo().toCharArray();
				boolean isMatch = false;
				
				//匹配模糊身份证号码
				for(int i = 0 ; i < idNumber.length ; i ++){
					if(idNumber[i] != '*' && idNumber[i] != '*'){
						if(idNumber[i] == yphone[i]){
							isMatch = true;
						}else{
							isMatch = false;
							break;
						}
					}else{
						continue;
					}
				}
				
				if(isMatch){
					result = mr;
					result.put("TIGGER_INFO",result.get("TIGGER_INFO")+" "+requestInfo.getCustomerName());
					break;
				}
				
				//匹配结束
				
			}
			
		}
		return result;
	}

}
