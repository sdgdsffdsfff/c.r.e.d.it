package com.ctc.credit.kernel.util.hessian;

import java.net.MalformedURLException;

import org.apache.commons.lang.StringUtils;

import com.caucho.hessian.client.HessianProxyFactory;

/**
 * Hessian工具类
 * 
 * @author sunny
 *
 */
public class HessianUtil {

	/** 饿汉单例模式 **/
	private static final HessianProxyFactory factory = new HessianProxyFactory();

	/**
	 * 通过Hessian工厂获取Hessian接口的工具方法
	 * 
	 * @param clazz
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getInterFaceProxy(Class<T> clazz, String url)
			throws Exception {
		if (null == clazz || StringUtils.isEmpty(url)) {
			throw new RuntimeException("参数不完整或者参数缺失！");
		}
		T t = null;
		try {
			t = (T) factory.create(clazz, url);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return t;
	}

}
