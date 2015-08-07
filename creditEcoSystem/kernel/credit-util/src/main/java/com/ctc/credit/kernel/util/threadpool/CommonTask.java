package com.ctc.credit.kernel.util.threadpool;

import java.util.concurrent.Callable;

public class CommonTask implements Callable<Object>{
	
	private Object paraObj;
	
	public CommonTask(Object ob) {
		super();
		this.paraObj = ob;
	}

	@Override
	public Object call() throws Exception {
		
		return null;
	}
	
}
