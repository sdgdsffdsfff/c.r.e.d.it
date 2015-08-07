package com.ctc.credit.kernel.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class BeanUtil {

	public final static int GET_METHOD = 0;
	public final static int SET_METHOD = 1;
	
	/**
	 * bean的copy
	 * 
	 * @param srcBean
	 *            源javabean(bean的属性若为null并且target属性为null或空, 不会将目标bean的对应属性覆盖)
	 * @param targetBean
	 *            目标javabean
	 * @return
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static <T> T beanCopy(T srcBean, T targetBean)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		if (srcBean == null || targetBean == null)
			return null;
		Method[] srcGetMethods = methodFilter(srcBean.getClass().getMethods()
				, GET_METHOD);
		for (Method getMethod : srcGetMethods) {
			
			Object o = getMethod.invoke(srcBean);
			if (o == null)
				continue;
			Method setMethod = targetBean.getClass().getMethod(
					getMethod.getName().replaceFirst("get", "set"),
					getMethod.getReturnType());
			setMethod.invoke(targetBean, o);
		}
		return targetBean;
	}
	
	/**
	 * 依据目标bean选择性copy
	 * 
	 * @param srcBean
	 * @param targetBean
	 * @return
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public static <T> T beanCopyByTarget(T srcBean, T targetBean)
			throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, SecurityException, NoSuchMethodException {
		if (srcBean == null || targetBean == null)
			return null;
		Method[] targetGetMethods = methodFilter(targetBean.getClass().getMethods()
				, GET_METHOD);
		for (Method getMethod : targetGetMethods) {
			Method srcGetMethod = srcBean.getClass().getMethod(
					getMethod.getName(),
					getMethod.getParameterTypes());
			Object o = srcGetMethod.invoke(srcBean);
			if (o == null)
				continue;
			Method setMethod = targetBean.getClass().getMethod(
					getMethod.getName().replaceFirst("get", "set"),
					getMethod.getReturnType());
			try {
				setMethod.invoke(targetBean, o);
			} catch (Exception e) {
				System.out.println(setMethod.getName());
				e.printStackTrace();
			}
			
		}
		return targetBean;
	}
	
	private static Method[] methodFilter(Method[] methods, final int methodType) {
		if (methods == null || methods.length == 0)
			return null;
		List<Method> methodList = new ArrayList<Method>();
		if (methodType == GET_METHOD) {
			for (Method method : methods) {
				if (method.getName().startsWith("get")
						&& !method.getName().contains("getSerialVersionUID")) {
					if (method.getModifiers() == Modifier.PUBLIC)
						methodList.add(method);
				}
			}
		} else if (methodType == SET_METHOD) {
			for (Method method : methods) {
				if (method.getName().startsWith("set")
						&& !method.getName().contains("setSerialVersionUID")) {
					if (method.getModifiers() == Modifier.PUBLIC)
						methodList.add(method);
				}
			}
		}
		return methodList.toArray(new Method[] {});
	}
	
}
