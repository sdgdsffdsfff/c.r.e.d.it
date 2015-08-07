package com.ctc.credit.kernel.commoninter.category;

import net.sf.json.JSONObject;

import com.ctc.credit.api.service.CreditApiService;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;
import com.ctc.credit.kernel.model.pengyuan.ResultEntity;

/**
 * 通用接口抽象接口
 * 
 * @author sunny
 *
 */
public interface CommonInterface {
	
	
	/**
	 * 接口调用前的处理动作
	 */
	public void doBefore(CreditApiService creditApiService);
	
	/**
	 * 执行接口动作</br>
	 * 每个具体的实现必须重写该方法
	 * 
	 * @throws Exception 
	 */
	public JSONObject executeService(ResultEntity resultEntity,QueryConditionEntity queryConditionEntity) throws Exception;
	
	/**
	 * 接口调用后的处理动作
	 */
	public void doAfter();
	
}
