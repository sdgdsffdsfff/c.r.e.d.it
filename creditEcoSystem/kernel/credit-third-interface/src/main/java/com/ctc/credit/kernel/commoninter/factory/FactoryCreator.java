package com.ctc.credit.kernel.commoninter.factory;

import java.net.MalformedURLException;

import com.ctc.credit.kernel.commoninter.category.CommonInterface;
import com.ctc.credit.kernel.model.pengyuan.QueryConditionEntity;

/**
 * 鹏元、聚鑫利等接口的抽象工厂接口</br> 以后其他第三方接口可统一在此添加
 * 
 * @author sunny
 * 
 */
public abstract class FactoryCreator {
	
	public FactoryCreator(){};
	
	/**
	 * 创建鹏元接口
	 * 
	 * @param <T>
	 * 
	 * @param queryConditionEntity
	 * @return
	 * @throws MalformedURLException 
	 */
	public abstract <T> CommonInterface createPyService(String beanName)
			throws MalformedURLException;

}
