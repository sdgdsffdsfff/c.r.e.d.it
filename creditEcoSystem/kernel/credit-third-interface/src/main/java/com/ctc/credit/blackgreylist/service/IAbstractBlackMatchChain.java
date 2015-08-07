package com.ctc.credit.blackgreylist.service;

import java.util.Map;

import com.ctc.credit.blackgreylist.pojo.HandleRequest;

public abstract class IAbstractBlackMatchChain {
	
	protected IAbstractBlackMatchChain nextChain;
	
	public abstract Map<String,Object> doMatch(HandleRequest requestInfo);
	

	public IAbstractBlackMatchChain getNextChain() {
		return nextChain;
	}

	public void setNextChain(IAbstractBlackMatchChain nextChain) {
		this.nextChain = nextChain;
	}
	
	
	
}
