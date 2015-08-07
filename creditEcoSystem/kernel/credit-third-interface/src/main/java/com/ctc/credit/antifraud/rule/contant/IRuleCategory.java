/**
 * 
 */
package com.ctc.credit.antifraud.rule.contant;

/**
 * @author sunny
 *
 */
public enum IRuleCategory {
	
	IRule200003("200003","申请人的入职年月晚于出生年月，但入职年份减去出生年份的差值小于18",RuleType.LogicCheck,true,0),
	IRule200004("200004","申请人宅址与单址所在城市不同",RuleType.LogicCheck,true,1),
	IRule200005("200005","申请人的单位电话与其工作证明人的固定电话相同，申请人的工作部门与其工作证明人的工作部门不相同",RuleType.LogicCheck,true,2),
	IRule200006("200006","新薪贷、精英贷产品借款人可认定工资大于20000",RuleType.LogicCheck,true,3),
	IRule200025("200025","申请人身份证号码的倒数第二位与其配偶身份证号码的倒数第二位（性别校验码）同为奇数或同为偶数",RuleType.LogicCheck,true,4),
	IRule300001("300001","证件号码不同，申请人手机号码与系统中已有申请人手机号码相同，且大于等于1",RuleType.HistoryCheck,true,5),
	IRule300002("300002","证件号码不同，申请人电子邮箱与系统中已有申请人电子邮箱相同，且大于等于1",RuleType.HistoryCheck,true,6),
	IRule300003("300003","180天内，证件号码不同，工作证明人姓名不同，工作证明人手机号码相同，且大于等于1",RuleType.HistoryCheck,true,7),
	IRule300004("300004","一年内，证件号码不同，工作证明人手机号码相同，且大于等于3",RuleType.HistoryCheck,true,8),
	IRule300005("300005","180天内，证件号码不同，申请人单电和系统中已有申请人宅电相同，且单位名称不同，且大于等于1",RuleType.HistoryCheck,true,9),
	IRule300006("300006","180天内，证件号码不同，家庭联系人姓名不同，家庭联系人手机号码相同，且大于等于1",RuleType.HistoryCheck,true,10),
	IRule300007("300007","一年内，证件号码不同，家庭联系人手机号码相同，且大于等于3",RuleType.HistoryCheck,true,11),
	IRule300009("300009","180天内，证件号码不同，其他联系人姓名不同，其他联系人手机号码相同，且大于等于1",RuleType.HistoryCheck,true,12),
	IRule300010("300010","一年内，证件号码不同，其他联系人手机号码相同，且大于等于3",RuleType.HistoryCheck,true,13),
	IRule300012("300012","证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,14),
	IRule300013("300013","证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,15),
	IRule300014("300014","证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,16),
	IRule300015("300015","证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,17),
	IRule300016("300016","证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,18),
	IRule300017("300017","证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,19),
	IRule300018("300018","一年内，证件号码相同，本次进件手机号码、单位电话和住宅电话与前次进件均不同",RuleType.HistoryCheck,true,20),
	IRule300022("300022","一年内，证件号码相同，本次进件手机号码、单位电话与前次进件均不同",RuleType.HistoryCheck,true,21),
	IRule300023("300023","一年内，证件号码相同，本次进件手机号码、住宅电话与前次进件均不同",RuleType.HistoryCheck,true,22),
	IRule300025("300025","一年内，证件号码相同，本次进件手机号码、单位名称与前次进件均不同",RuleType.HistoryCheck,true,23),
	IRule300026("300026","一年内，证件号码相同，本次进件手机号码、单位地址与前次进件均不同",RuleType.HistoryCheck,true,24),
	IRule300027("300027","一年内，证件号码相同，本次进件手机号码、住宅地址与前次进件均不同",RuleType.HistoryCheck,true,25),
	IRule300028("300028","证件号码不同，申请人的房产地址与系统中已有申请人的房产地址相同，且大于等于1",RuleType.HistoryCheck,true,26),
	IRule300029("300029","一年内，证件号码相同，本次进件住宅电话、住宅地址与前次进件均不同",RuleType.HistoryCheck,true,27),
	IRule300030("300030","一年内，证件号码相同，本次进件住宅电话、单位名称与前次进件均不同",RuleType.HistoryCheck,true,28),
	IRule300031("300031","一年内，证件号码相同，本次进件住宅电话、单位电话与前次进件均不同",RuleType.HistoryCheck,true,29),
	IRule300032("300032","180天内，证件号码不同，申请人宅电和系统中已有申请人单电相同，且单位名称不同，且大于等于1",RuleType.HistoryCheck,true,30),
	IRule300033("300033","证件号码不同，单位电话相同，单位名称前八个字不同，且大于等于1",RuleType.HistoryCheck,true,31),
	IRule300034("300034","证件号码不同，住宅电话相同，住宅地址不同，且大于等于1",RuleType.HistoryCheck,true,32),
	IRule300035("300035","证件号码不同，住宅地址相同，且大于等于1",RuleType.HistoryCheck,true,33),
	IRule300036("300036","证件号码不同，单位电话相同，工作证明人单位电话相同，且大于等于2",RuleType.HistoryCheck,true,34),
	IRule300037("300037","证件号码不同，住宅电话相同，且大于等于1",RuleType.HistoryCheck,true,35),
	IRule300038("300038","证件号码不同，工作证明人手机号码相同，单位名称前八个字不同，且大于等于1",RuleType.HistoryCheck,true,36),
	IRule300039("300039","证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,37),
	IRule300040("300040","证件号码不同，申请人手机号码与系统中已有申请人的其它联系人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,38),
	IRule300041("300041","证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1",RuleType.HistoryCheck,true,39),
	IRule300042("300042","一年内，证件号码相同，本次进件住宅电话、单位地址与前次进件均不同",RuleType.HistoryCheck,true,40),
	IRule300043("300043","一年内，证件号码相同，本次进件单位电话、住宅地址与前次进件均不同",RuleType.HistoryCheck,true,41),
	IRule300044("300044","一年内，证件号码相同，本次进件单位电话、单位名称与前次进件均不同",RuleType.HistoryCheck,true,42),
	IRule300045("300045","一年内，证件号码相同，本次进件单位电话、单位地址与前次进件均不同",RuleType.HistoryCheck,true,43),
	IRule300046("300046","一年内，证件号码相同，本次进件住宅地址、单位名称与前次进件均不同",RuleType.HistoryCheck,true,44),
	IRule300047("300047","一年内，证件号码相同，本次进件住宅地址、单位地址与前次进件均不同",RuleType.HistoryCheck,true,45),
	IRule300048("300048","一年内，证件号码相同，本次进件单位名称、单位地址与前次进件均不同",RuleType.HistoryCheck,true,46),
	IRule300049("300049","证件号码不同，申请人的配偶身份证号码与系统中已有申请人的配偶身份证号码相同，且大于等于1",RuleType.HistoryCheck,true,47),
	IRule300050("300050","证件号码不同，申请人的配偶手机号码与系统中已有申请人的配偶手机号码相同，且大于等于1",RuleType.HistoryCheck,true,48),
	IRule300051("300051","证件号码不同，单位地址相同，单位名称前八个字不同，且大于等于1",RuleType.HistoryCheck,true,49),
	IRule300052("300052","申请人的身份证号码与系统中已有申请人的配偶身份证号码相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,50),
	IRule300053("300053","申请人的手机号码与系统中已有申请人的配偶手机号码相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,51),
	IRule300054("300054","申请人与系统中已有客户为父母-子女关系，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,52),
	IRule300055("300055","申请人与系统中已有客户为子女-父母关系，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,53),
	IRule300056("300056","申请人的姓名和手机号码与系统中已有申请人的家庭联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,54),
	IRule300057("300057","申请人的姓名和手机号码与系统中已有申请人的其他联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,55),
	IRule300058("300058","证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,56),
	IRule300059("300059","申请人的姓名和手机号码与系统中已有申请人的工作证明人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,57),
	IRule300060("300060","申请人的姓名与系统中已有申请人的工作证明人姓名相同，且已有申请人的姓名与申请人的工作证明人姓名相同，且已有申请人当前逾期大于等于5天",RuleType.HistoryCheck,true,58),
	IRule300061("300061","证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名相同，且大于等于1",RuleType.HistoryCheck,true,59),
	IRule300062("300062","证件号码不同，申请人手机号码与系统中已有申请人的其他联系人号码相同，且姓名相同，且大于等于1",RuleType.HistoryCheck,true,60),
	IRule300063("300063","证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名相同，且大于等于1",RuleType.HistoryCheck,true,61),
	IRule300064("300064","一年内，信薪贷、信优贷产品借款人可认定工资较前一次申请时增长30%以上",RuleType.HistoryCheck,true,62),
	IRule300065("300065","借款人身份证号与系统中已有申请人相同，但姓名不同",RuleType.HistoryCheck,true,63),
	IRule600001("600001","一年内，证件号码不同，申请人的单位电话与系统中已有申请人的单位电话相同，且大于等于1",RuleType.AntiGroupApply,true,64),
	IRule600002("600002","一年内，证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且等于1",RuleType.AntiGroupApply,true,65),
	IRule600003("600003","一年内，证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且大于等于2",RuleType.AntiGroupApply,true,66),
	IRule700001("700001","同一车辆识别代号（VIN码）不同发动机号码",RuleType.CarTypeInfo,false,67),
	IRule700002("700002","同一车辆识别代号（VIN码）不同号牌号码",RuleType.CarTypeInfo,false,68),
	IRule700003("700003","同一发动机号码不同号牌号码",RuleType.CarTypeInfo,false,69),
	IRule700004("700004","同一发动机号码不同车辆识别代号（VIN码）",RuleType.CarTypeInfo,false,70),
	IRule700005("700005","同一号牌号码不同车辆识别代号（VIN码）",RuleType.CarTypeInfo,false,71),
	IRule700006("700006","同一号牌号码不同发动机号码",RuleType.CarTypeInfo,false,72),
	IRule700007("700007","180天内，不同申请人同一车辆识别代号（VIN码）进件大于等于2件",RuleType.CarTypeInfo,false,73),
	IRule700008("700008","180天内，不同申请人同一发动机号码进件大于等于2件",RuleType.CarTypeInfo,false,74),
	IRule700009("700009","180天内，不同申请人同一号牌号码（车牌号）进件大于等于2件",RuleType.CarTypeInfo,false,75);
	
	private String ruleNo;
	private String ruleDesc;
	private RuleType ruleType;
	private Boolean runState;
	private int runOrder;
	
	private IRuleCategory(String ruleNo, String ruleDesc, RuleType ruleType,Boolean runState,int runOrder) {
		this.ruleNo = ruleNo;
		this.ruleDesc = ruleDesc;
		this.ruleType = ruleType;
		this.runState = runState;
		this.runOrder = runOrder;
	}
	
	/**
	 * @return the ruleNo
	 */
	public String getRuleNo() {
		return ruleNo;
	}
	/**
	 * @param ruleNo the ruleNo to set
	 */
	public void setRuleNo(String ruleNo) {
		this.ruleNo = ruleNo;
	}
	/**
	 * @return the ruleDesc
	 */
	public String getRuleDesc() {
		return ruleDesc;
	}
	/**
	 * @param ruleDesc the ruleDesc to set
	 */
	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}
	/**
	 * @return the ruleType
	 */
	public RuleType getRuleType() {
		return ruleType;
	}
	/**
	 * @param ruleType the ruleType to set
	 */
	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}
	
	public enum RuleType{
		
		LogicCheck("0","自身逻辑检查"),
		HistoryCheck("1","历史数据对比"),
		AntiGroupApply("2","防集体进件"),
		CarTypeInfo("3","车贷类规则");
		
		private String value;
		private String desc;

		private RuleType(String value,String desc) {
			this.value = value;
			this.desc = desc;
		}

		/**
		 * @return the value
		 */
		public String getValue() {
			return value;
		}

		/**
		 * @param value the value to set
		 */
		public void setValue(String value) {
			this.value = value;
		}

		/**
		 * @return the desc
		 */
		public String getDesc() {
			return desc;
		}

		/**
		 * @param desc the desc to set
		 */
		public void setDesc(String desc) {
			this.desc = desc;
		}
	}

	/**
	 * @return the runState
	 */
	public Boolean getRunState() {
		return runState;
	}

	/**
	 * @param runState the runState to set
	 */
	public void setRunState(Boolean runState) {
		this.runState = runState;
	}

	/**
	 * @return the runOrder
	 */
	public int getRunOrder() {
		return runOrder;
	}

	/**
	 * @param runOrder the runOrder to set
	 */
	public void setRunOrder(int runOrder) {
		this.runOrder = runOrder;
	}
		
}
