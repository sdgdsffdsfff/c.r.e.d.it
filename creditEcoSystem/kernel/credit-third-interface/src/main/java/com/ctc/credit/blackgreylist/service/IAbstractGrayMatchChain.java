package com.ctc.credit.blackgreylist.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.constant.GrayListEnum;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;

public abstract class IAbstractGrayMatchChain {
	
	protected IAbstractGrayMatchChain nextChain;
	
	public abstract List<Map<String,Object>> doMatch(HandleRequest requestInfo);
	

	public IAbstractGrayMatchChain getNextChain() {
		return nextChain;
	}

	public void setNextChain(IAbstractGrayMatchChain nextChain) {
		this.nextChain = nextChain;
	}
	
	
	
}
