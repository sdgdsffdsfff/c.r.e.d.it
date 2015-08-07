package com.ctc.credit.blackgreylist.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 属性与表和字段的映射
 * @author sunny
 * @date 2014年11月11日 下午4:19:41
 * @description todo
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD,
		java.lang.annotation.ElementType.FIELD })
@Inherited
public @interface XlsWrite {
	/**
	 * 排序
	 * @return
	 */
	public abstract int order() default 0;
}