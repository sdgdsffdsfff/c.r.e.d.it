/**
 * 
 */
package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javassist.SerialVersionUID;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

/**
 * @author Chengang
 * 2015年8月3日 下午2:28:55 
 */
@Entity
@Table(name = "BAIRONG_SPECIALLIST_INFO")
public class CreareBrSpeciallistInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -26132190671410019L;
	
	/** 流水号 **/
	private String swiftNo;
	/** （银行和非银）信贷申请次数 **/
	private String dnumber;
	/** 关联阶层 **/
	private String degree;
	
	/** 大类型（gid或id或cell） **/
	private String type;
	
	/** 命中类型 **/
	private String key;
	
	@Column(name = "SWIFT_NUMBER")
	public String getSwiftNo() {
		return swiftNo;
	}
	
	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}
	
	@Column(name = "DNUMBER")
	public String getDnumber() {
		return dnumber;
	}
	
	public void setDnumber(String dnumber) {
		this.dnumber = dnumber;
	}
	
	@Column(name = "DEGREE")
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}

	@Column(name = "TYPE")
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "KEY")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
	
}
