/**
 * 
 */
package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

/**
 * @author Chengang
 * 2015年8月3日 下午3:10:56 
 */
@Entity
@Table(name = "BAIRONG_SCORE_INFO")
public class CreareBrScoreInfo extends AbstractCreditEntity{
	private static final long serialVersionUID = 3489765173260301697L;
	/** 流水号 **/
	private String swiftNo;
	/** 百融通用信用评分 评分取值范围[300,1000]，分数越高，客户信用越好 **/
	private String brCreditPoint;
	
	@Column(name = "SWIFT_NUMBER")
	public String getSwiftNo() {
		return swiftNo;
	}
	
	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}
	
	@Column(name = "BR_CREDIT_POINT")
	public String getBrCreditPoint() {
		return brCreditPoint;
	}
	
	public void setBrCreditPoint(String brCreditPoint) {
		this.brCreditPoint = brCreditPoint;
	}
	
}
