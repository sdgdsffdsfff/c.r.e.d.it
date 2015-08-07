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
 * 2015年8月3日 下午3:45:54 
 */
@Entity
@Table(name = "BAIRONG_RULERESULT_INFO")
public class CreareBrRuleresultInfo extends AbstractCreditEntity {

	private static final long serialVersionUID = -7747707085255465652L;
	
	/** 流水号 **/
	private String swiftNo;
	
	/** 1-7项子策略 **/
	private String R101;
	private String R102;
	private String R103;
	private String R104;
	private String R105;
	private String R106;
	private String R107;

	@Column(name = "SWIFT_NUMBER")
	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	@Column(name = "R101")
	public String getR101() {
		return R101;
	}

	public void setR101(String r101) {
		R101 = r101;
	}

	@Column(name = "R102")
	public String getR102() {
		return R102;
	}

	public void setR102(String r102) {
		R102 = r102;
	}

	@Column(name = "R103")
	public String getR103() {
		return R103;
	}

	public void setR103(String r103) {
		R103 = r103;
	}

	@Column(name = "R104")
	public String getR104() {
		return R104;
	}

	public void setR104(String r104) {
		R104 = r104;
	}

	@Column(name = "R105")
	public String getR105() {
		return R105;
	}

	public void setR105(String r105) {
		R105 = r105;
	}

	@Column(name = "R106")
	public String getR106() {
		return R106;
	}

	public void setR106(String r106) {
		R106 = r106;
	}

	@Column(name = "R107")
	public String getR107() {
		return R107;
	}

	public void setR107(String r107) {
		R107 = r107;
	}
	
}
