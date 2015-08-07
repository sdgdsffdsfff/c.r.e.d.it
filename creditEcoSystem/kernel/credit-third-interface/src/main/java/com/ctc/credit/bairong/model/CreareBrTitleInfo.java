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
 * 2015年8月3日 下午4:00:07 
 */
@Entity
@Table(name = "BAIRONG_TITLE_INFO")
public class CreareBrTitleInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -8097911074845780749L;
	
	/** 流水号 **/
	private String swiftNo;
	
	/** 企业主/高管标识:0（无），1（小微企业主），2（企业高管） **/
	private String title;

	@Column(name = "SWIFT_NUMBER")
	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	@Column(name = "TITLE")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
