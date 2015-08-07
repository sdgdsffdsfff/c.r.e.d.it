package com.ctc.credit.antifraud.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.ctc.credit.antifraud.rule.contant.IRuleCategory;

/**
 * 规则配置信息
 * 
 * @author sunny
 * @date 2015年06月23日 下午15:19:41
 * @description todo
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ java.lang.annotation.ElementType.METHOD,
		java.lang.annotation.ElementType.FIELD })
@Inherited
public @interface RuleConfig {
	
	
	public abstract IRuleCategory ruleCategory();
	
	/**
	 * 排序
	 * @return
	 */
	public abstract int order() default 0;
}
