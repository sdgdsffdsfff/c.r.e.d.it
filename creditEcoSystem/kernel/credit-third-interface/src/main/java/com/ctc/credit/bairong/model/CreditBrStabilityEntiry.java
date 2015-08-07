package com.ctc.credit.bairong.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：稳定性评估实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_STABLIITY_INFO")
public class CreditBrStabilityEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = -9159682379948575969L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**百融该key值数量*/
	private String idNo;
	
	/**百融该key值数量*/
	private String cellNo;
	
	/**匹配成功的cell在百融库中出现的最早时间*/
	private String cellFirsttime;
	
	/**百融该key值数量*/
	private String nameNo;
	
	/**百融该key值数量*/
	private String mailNo;
	
	/**百融该key值数量*/
	private String telNo;
	
	/**百融该key值数量*/
	private String addrNo;

	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}	
	@Column(name = "ID_NO",length=255)
	public String getIdNo() {
		return idNo;
	}

	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	@Column(name = "CELL_NO",length=255)
	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
		
	@Column(name = "CELL_FIRST_TIME",length=255)
	public String getCellFirsttime() {
		return cellFirsttime;
	}

	public void setCellFirsttime(String cellFirsttime) {
		this.cellFirsttime = cellFirsttime;
	}

	@Column(name = "NAME_NO",length=255)
	public String getNameNo() {
		return nameNo;
	}

	public void setNameNo(String nameNo) {
		this.nameNo = nameNo;
	}
	@Column(name = "MAIL_NO",length=255)
	public String getMailNo() {
		return mailNo;
	}

	public void setMailNo(String mailNo) {
		this.mailNo = mailNo;
	}
	@Column(name = "TEL_NO",length=255)
	public String getTelNo() {
		return telNo;
	}

	public void setTelNo(String telNo) {
		this.telNo = telNo;
	}
	@Column(name = "ADDR_NO",length=255)
	public String getAddrNo() {
		return addrNo;
	}

	public void setAddrNo(String addrNo) {
		this.addrNo = addrNo;
	}
	
	

}
