package com.ctc.credit.shenzhourong.service;

import com.ctc.credit.shenzhourong.model.SzrRequestCondition;

/**
 * 神州融接口service
 * @author Chengang
 * 2015年7月23日 下午2:06:32 
 */
public interface CreditSzrService {
	
	/**
	 * 黑名单
	 * @author Chengang
	 * @param dto
	 * @return
	 */
	public String doExecuteBlkListRemote(SzrRequestCondition requestCondition);
	
	/**
	 * 信用评分
	 * @author Chengang
	 * @param requestCondition
	 * @return
	 */
	public String doExecuteCreditPointRemote(SzrRequestCondition requestCondition);

}
