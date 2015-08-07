package com.ctc.credit.kernel.constants;

/**
 * 鹏元常量类
 * @author sunny
 *
 */
public class PyConstants {
	
	/** 正常有数据返回  **/
	public static final String PY_RECODE_001 = "001";
	
	/** 正常无数据返回  **/
	public static final String PY_RECODE_002 = "002";
	
	/** 参数不完整 **/
	public static final String PY_RECODE_003 = "003";
	
	/** 请求超时  **/
	public static final String PY_RECODE_004 = "004";
	
	/** 网络异常  **/
	public static final String PY_RECODE_005 = "005";
	
	/** 其他  **/
	public static final String PY_RECODE_006 = "006";
	
	
	/** 电话正查  **/
	public static final String PY_QUERYTYPE_90035 = "PY90035";
	
	/** 电话反查  **/
	public static final String PY_QUERYTYPE_21603 = "PY21603";
	
	/** 法人核查  **/
	public static final String PY_QUERYTYPE_21303 = "PY21303";
	
	/** 查询类型不能为空  **/
	public static final String PY_REMSG_TP1 = "查询类型不能为空";
	
	/** 查询源不能为空  **/
	public static final String PY_REMSG_TP2 = "查询源不能为空";
	
	/** 查询参数不能为空  **/
	public static final String PY_REMSG_TP3 = "查询参数不能为空";
	
	/** 查询参数[sendCode]不能为空  **/
	public static final String PY_REMSG_TP3_1 = "查询参数[sendCode]不能为空";
	
	/** 查询参数[applyNo]不能为空  **/
	public static final String PY_REMSG_TP3_2 = "查询参数[applyNo]不能为空";
	
	/** 查询参数[corpName]不能为空  **/
	public static final String PY_REMSG_TP3_3 = "查询参数[corpName]不能为空";
	
	/** 查询参数[telephone]不能为空  **/
	public static final String PY_REMSG_TP3_4 = "查询参数[telephone]不能为空";
	
	/** 查询参数[idType]不能为空  **/
	public static final String PY_REMSG_TP3_5 = "查询参数[idType]不能为空";
	
	/** 查询参数[personName]不能为空  **/
	public static final String PY_REMSG_TP3_6 = "查询参数[personName]不能为空";
	
	/** 查询参数[idNumber]不能为空  **/
	public static final String PY_REMSG_TP3_7 = "查询参数[idNumber]不能为空";
	
	/** 查询参数[queryType]尚未定义  **/
	public static final String PY_REMSG_TP3_8 = "查询参数[queryType]不能为空";
	
	/** 查询鹏元成功但无数据返回  **/
	public static final String PY_REMSG_TP4 = "查询鹏元成功但无数据返回";
	
	/** 查询鹏元成功但无数据返回  **/
	public static final String PY_REMSG_TP4_1 = "查询征信本地成功但无数据返回";
	
	/** 鹏元接口服务地址名  **/
	public static final String PY_CONFIG_SERVICE_URL= "PY_SERVICE_URL";
	
	/** 鹏元接口服务地址名  **/
	public static final String PY_HESSIAN_TIMEOUT= "PY_HESSIAN_TIMEOUT";
	
	/** 鹏元接口服务方法名  **/
	public static final String PY_SERVICE_METHOD_NAME= "PY_SERVICE_METHOD_NAME";
	
	/** 鹏元接口服务实现类名称  **/
	public static final String PY_SERVICEIMPL_CLASS_NAME= "PY_SERVICE_METHOD_NAME";
	
	/** 电话正查超时时间  **/
	public static final String PY90035_QUERY_DAYS= "PY90035_QUERY_DAYS";
	
	/** 电话反查超时时间  **/
	public static final String PY21603_QUERY_DAYS= "PY21603_QUERY_DAYS";
	
	/** 法人核查超时时间  **/
	public static final String PY21303_QUERY_DAYS= "PY21303_QUERY_DAYS";
	
	/** 鹏元查询local 和远端的强制标示 0：查询本地，1：查询远端，2或无：按正常流程  **/
	public static final String PY_QUERY_FLAG= "PY_QUERY_FLAG";
	
	/** 查询local  **/
	public static final String PY_QUERY_STATUS_LOCAL= "0";
	
	/** 查询remote  **/
	public static final String PY_QUERY_STATUS_REMOTE= "1";
	
	/** 查询 默认在没有超时时，现查local后查remote,否则查远端  **/
	public static final String PY_QUERY_STATUS_NORMAL= "2";

}
