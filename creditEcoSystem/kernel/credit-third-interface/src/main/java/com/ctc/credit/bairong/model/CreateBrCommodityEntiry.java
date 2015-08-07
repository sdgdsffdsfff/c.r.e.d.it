package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：商品评估实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_COMMODIT_INFO")
public class CreateBrCommodityEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = -3172019286928097436L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**统计月份*/
	private String month;
	
	/**商品类型*/
	private String merchandiseType;
	
	/**当前类目下的总浏览次数*/
	private String visits;
	
	/**当前类目下的总消费次数*/
	private String no;
	
	/**当前类目下的总消费金额*/
	private String pay;
	
	/**最大单月消费金额（过去12个月（不含当月）*/
	private String maxPay;
	
	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	@Column(name = "MONTH",length=255)
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Column(name = "MERCHANDISE_TYPE",length=255)
	public String getMerchandiseType() {
		return merchandiseType;
	}

	public void setMerchandiseType(String merchandiseType) {
		this.merchandiseType = merchandiseType;
	}

	@Column(name = "VISITS",length=255)
	public String getVisits() {
		return visits;
	}

	public void setVisits(String visits) {
		this.visits = visits;
	}

	@Column(name = "NO",length=255)
	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	@Column(name = "PAY",length=255)
	public String getPay() {
		return pay;
	}

	public void setPay(String pay) {
		this.pay = pay;
	}

	@Column(name = "MAX_PAY",length=255)
	public String getMaxPay() {
		return maxPay;
	}

	public void setMaxPay(String maxPay) {
		this.maxPay = maxPay;
	}

}
