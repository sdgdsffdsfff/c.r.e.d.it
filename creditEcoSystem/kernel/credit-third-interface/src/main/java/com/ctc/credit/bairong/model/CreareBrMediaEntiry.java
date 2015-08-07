package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
@Entity
@Table(name = "BAIRONG_MEDIA_INFO")
public class CreareBrMediaEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = -9095531290835757017L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**过去的几个月*/
	private String months;
	
	/**商品类型*/
	private String commType;
	
	/**当前类目下的总浏览天数*/
	private String visitdays;

	@Column(name = "SWIFT_MUNBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	
	@Column(name = "PASS_MONTH",length=255)
	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}
	
	@Column(name = "COMM_TYPE",length=255)
	public String getCommType() {
		return commType;
	}

	public void setCommType(String commType) {
		this.commType = commType;
	}

	@Column(name = "VISITDAYS",length=255)
	public String getVisitdays() {
		return visitdays;
	}

	public void setVisitdays(String visitdays) {
		this.visitdays = visitdays;
	}
	
	

}
