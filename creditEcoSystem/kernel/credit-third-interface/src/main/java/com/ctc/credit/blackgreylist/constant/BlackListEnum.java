package com.ctc.credit.blackgreylist.constant;

public enum BlackListEnum{
	CustomerFraud("欺诈客户黑名单",1,"02QZ"),
	TheInternalBadCustomers("内部不良客户黑名单",2,"02NB"),
	DepartmentFeedbackPeer("营业部反馈同行黑名单",3,"02YY"),
	FrenchOpenFail("人法网失信黑名单",4,"02RF"),
	NetworkCustomer("网络客户黑名单",5,"02WL"),
	TheInternalBusinessDepartmentRefused("内部营业部拒绝黑名单",6,"02NY"),
	BadHabitsOfCustomers("不良嗜好客户黑名单",7,"02BL"),
	FamilyOppositionLoanCustomers("家人反对贷款客户黑名单",8,"02JR"),
	MaliciousCustomerComplaints("恶意投诉客户黑名单",9,"02EY"),
	BadUnits("不良单位黑名单",10,"02LD"),
	TheCollapseOfTheFactory("倒闭工厂黑名单",11,"02DB"),
	OnThePhoneBlacklist("关注电话黑名单",12,"02DH"),
	InternalStaff("内部员工黑名单",13,"02YG"),
	OutsideCreditList("外部征信黑名单",14,"02ZX");
	
	private String blackListName;
	private int blackPriority;
	private String rejectCode;
	
	private BlackListEnum(String blackListName,int blackPriority,String rejectCode){
		this.blackListName = blackListName;
		this.blackPriority = blackPriority; 
		this.rejectCode = rejectCode;
	}
	
	public String getRejectCode(){
		return rejectCode;
	}
	
	public String getBlackListName(){
		return blackListName;
	}
	
	public int getBlackPriority(){
		return blackPriority;
	}
}
