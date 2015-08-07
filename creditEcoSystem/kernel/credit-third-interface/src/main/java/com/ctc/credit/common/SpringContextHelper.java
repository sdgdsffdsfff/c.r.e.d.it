package com.ctc.credit.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Context 工具类
 * @author sunny
 *
 */
@Component
public class SpringContextHelper implements ApplicationContextAware {

	private static ApplicationContext context;
	//注释
	/**
	 * 提供一个接口，获取容器中的Bean实例，根据名称获取
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context = context;
	}
}
