package com.ctc.credit.bairong.api.dto.consumption;

public class EvaluationContentDto {

	/**当前类目下的总浏览次数**/
	private String visits;
	
	/**当前类目下的总消费次数**/
	private String number;
	
	/**当前类目下的总消费金额**/
	private String pay;
	
	/**最大单月消费金额（过去12个月（不含当月））**/
	private String maxpay;

	public String getVisits() {
		return visits;
	}

	public void setVisits(String visits) {
		this.visits = visits;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	public String getMaxpay() {
		return maxpay;
	}

	public void setMaxpay(String maxpay) {
		this.maxpay = maxpay;
	}
	
	
}
