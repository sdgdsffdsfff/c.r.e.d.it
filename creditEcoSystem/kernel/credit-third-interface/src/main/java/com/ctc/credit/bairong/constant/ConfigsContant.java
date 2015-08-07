package com.ctc.credit.bairong.constant;

import org.apache.log4j.Logger;


public class ConfigsContant {
	
private static Logger logger = Logger.getLogger(ConfigsContant.class);
	
	
	//======================登录======================//

	/**用户名**/
	public static final String NAME = "zhongtengxin";
	
	/**密码**/
	public static final String PASSWORD = "zhongtengxin";
	
	/**tokenid**/
	public static final String TOKENID = "tokenid";
	
	/**code**/
	public static final String CODE = "code";
	
	/**swift_number 流水号**/
	public static final String SWIFT_NUMBER = "swift_number";
	
	/**身份信息核查**/
	public static final String AUTHENTICATION = "Authentication";
	
	
	/**匹配成功的核心tel_home:值**/
	public static final String TEL_HOME = "tel_home";
	
	/**资产评估**/
	public static final String ASSETS = "Assets";
	
	
	/**Internet**/
	public static final String INTERNET = "Internet";
	
	/**CITY**/
	public static final String CITY = "city";
	
	
	//======================位置信息======================//	
	/**位置信息核查**/
	public static final String LOCATION = "Location";
	
	//======================商品消费评估======================//
	/**稳定性评估**/
	public static final String FLAG = "Flag";
	
	//======================稳定性评估======================//	
	/**稳定性评估**/
	public static final String STABILITY = "Stability";
	
	//======================商品消费评估======================//	
	/**商品消费评估**/
	public static final String CONSUMPTION = "Consumption";
	
	//======================申请信息核查======================//	
	/**申请信息核查**/
	public static final String APPLYLOAN = "ApplyLoan";
	
	
	//======================线上行为评估======================//	
	/**线上行为评估**/
	public static final String ONLINE = "Online";
	
	//======================特殊名单评估======================//	
	/**特殊名单评估**/
	public static final String SPECIALLIST = "SpecialList";
	
	//======================百融评分======================//	
	/**百融评分**/
	public static final String SCORE = "Score";
	
	//======================百融策略规则（拒绝规则）======================//	
	/**百融策略规则（拒绝规则）**/
	public static final String RULERESULT = "RuleResult";
	
	//======================企业主/高管标示======================//	
	/**企业主/高管标示**/
	public static final String TITLE = "Title";
	
	//======================收支等级评估======================//	
	/**收支等级评估**/
	public static final String ACCOUNTCHANGE = "Accountchange";	
	
	
	//======================百融评级======================//	
	/**百融评级**/
	public static final String RATING = "Rating";	

	//======================媒体阅览评估======================//	
	/**媒体阅览评估**/
	public static final String MEDIA = "Media";	
	
	//======================品牌兴趣评估======================//	
	/**品牌兴趣评估**/
	public static final String BRAND = "Brand";

	//======================系统的响应值======================//

	/**操作成功**/
	public static final String SUCCESSFUL_OPERATION = "00";
	
	/**商户不存在**/
	public static final String MERCHANTS_NOT_EXIST = "100004";
	
	/**登录密码不正确**/
	public static final String LOGIN_PASSWORD_ERROR = "100005";

}
