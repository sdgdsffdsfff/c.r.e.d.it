package com.ctc.credit.qianhai.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.blackgreylist.pojo.HandleRequest;

public interface QianHaiConsumerService {
	

	/**
	 * 调用远端接口
	 * 
	 * @param handleRequests
	 * @return
	 */
	public Map<HandleRequest, Boolean> doExecuteRemoteService(List<HandleRequest> handleRequests);
	
	/**
	 * 调用远端接口单个查询条件
	 * 
	 * @param handleRequests
	 * @return
	 */
	public Boolean doExecuteSingleRemoteService(HandleRequest handleRequest);
}
