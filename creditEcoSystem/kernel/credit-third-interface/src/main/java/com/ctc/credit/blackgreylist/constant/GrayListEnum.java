package com.ctc.credit.blackgreylist.constant;

public enum GrayListEnum {
	SuspectedFraudA("疑似欺诈客户灰名单A",1,"身份证号码||手机号码||住宅地址||住宅电话||单位名称||单位地址||单位电话"),
	SuspectedFraudB("疑似欺诈客户灰名单B",2,"身份证号码||手机号码||住宅地址||住宅电话"),
	SuspectedFraudC("疑似欺诈客户灰名单C",3,"单位名称||单位地址||单位电话"),
	SuspectedFraudD("疑似欺诈客户灰名单D",4,"手机号码||住宅电话"),
	IdentityLeakage("身份泄露客户灰名单",5,"身份证号"),
	InterbankBusinessDepartment("营业部同业灰名单",6,"身份证号/姓名+地区"),
	TimeoutTrunToGrey("关注电话黑名单超时转灰",7,"手机号码||住宅电话"),
	IllegalSalesPersonnelIntoPieces("违规销售人员进件客户灰名单",8,"销售人员姓名+营业部所在城市");
	
	private String grayListName;
	private int blackPriority;
	private String glistRole;
	
	private GrayListEnum(String grayListName,int blackPriority,String glistRole){
		this.grayListName = grayListName;
		this.blackPriority = blackPriority;
		this.glistRole = glistRole;
	}
	
	public String getGrayListName(){
		return grayListName;
	}
	
	public int getBlackPriority(){
		return blackPriority;
	}
	
	public String getGlistRole(){
		return glistRole;
	}
}
