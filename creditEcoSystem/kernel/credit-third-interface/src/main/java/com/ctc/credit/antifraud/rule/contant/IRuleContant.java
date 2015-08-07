package com.ctc.credit.antifraud.rule.contant;

public class IRuleContant {
	
	/** 规则方法前缀 **/
	public static final String RULEMETHODPRE_STR ="rule";

	
	//联系人与申请人关系
	/** 关系-父母 **/
	public static final String CON_RELATION_PARENT ="1";
	
	/** 关系-子女 **/
	public static final String CON_RELATION_CHILD ="2";
	
	/** 关系-工作证明人 **/
	public static final String CON_RELATION_PROVER ="3";
	
	/** 关系-其他亲属联系人 **/
	public static final String CON_RELATION_OTHERFAMILY ="4";
	
	/** 关系-其他 **/
	public static final String CON_RELATION_OTHER ="9";
	
	/** 信薪贷、信优贷产品  **/
	public static final String XXD_XYD_CODES ="0000|0001|0005|0008|0010|0033|0042|0045";
}
