package com.ctc.credit.bairong.api.dto.flag;

import java.util.HashMap;

/**
 * 报告输出标识dto
 * @author danggang
 *
 */
public class FlagDto {

	/** 流水账单**/
	private String swiftNumber;
	
	/** core_key：1(输出成功),0(未匹配上无输出)，99（系统异常）,null（没有选择该报告或输入信息不充足）
	 * core_gid：取值同上**/
	private CoreDto core;
	
	/** 审核记录核查输出标志，取值同上**/
	private String applyLoan;
	
	/** 百融通用评分输出标志，取值同上**/
	private String score;
	
	/** 特殊名单报告输出标志，取值同上**/
	private String specialList;
	
	/** 收支等级报告输出标志，取值同上**/
	private String accountchange;
	
	/** 支付消费报告输出标志，取值同上**/
	private String PayConsumption;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public CoreDto getCore() {
		return core;
	}

	public void setCore(CoreDto core) {
		this.core = core;
	}

	
	public String getApplyLoan() {
		return applyLoan;
	}

	public void setApplyLoan(String applyLoan) {
		this.applyLoan = applyLoan;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getSpecialList() {
		return specialList;
	}

	public void setSpecialList(String specialList) {
		this.specialList = specialList;
	}

	public String getAccountchange() {
		return accountchange;
	}

	public void setAccountchange(String accountchange) {
		this.accountchange = accountchange;
	}

	public String getPayConsumption() {
		return PayConsumption;
	}

	public void setPayConsumption(String payConsumption) {
		PayConsumption = payConsumption;
	}			
}
