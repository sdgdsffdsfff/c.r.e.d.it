package com.ctc.credit.kernel.commoninter.factory;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;

import com.ctc.credit.common.SpringContextHelper;

public class ServiceFactoryTools {
	
	@Resource
	SpringContextHelper contextHelper;
	
	private static FactoryCreator instance;
	 
	/**
	 * 通用接口service的工厂获取方法
	 * @param clazz
	 * @return
	 */
	public static synchronized <T> FactoryCreator getServiceCreateFactory(String factoryName) {
		if (instance == null)
		    instance = (FactoryCreator) SpringContextHelper.getBean(factoryName);
		return instance;
	}
}
