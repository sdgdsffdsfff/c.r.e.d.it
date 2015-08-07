package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

/**
 * 百融：身份信息核查表
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_AUTHENTICATION_INFO")
public class CreditBrAuthenticationEntity extends AbstractCreditEntity{

	private static final long serialVersionUID = 2795865251370932777L;
	
	/**流水账单*/
	private String swiftNumber;
	/** id:1（匹配成功）0（匹配失败)*/	
	private String userId;
	
	/** cell:1（匹配成功）0（匹配失败)*/	
	private String cell;
	
	/** mail:1（匹配成功）0（匹配失败)*/	
	private String mail;
	
	/** keyRrelation:由三位0/1字符组成，表示匹配成功的核心key值（id、cell、mail）之间的关系；
	 * 第一位表示id和cell之间的关联关系，1为有关联，0为没有关联；
	 * 第二位表示id和mail的关系，取值同上；
	 * 第三位表示cell和mail之间的关系，取值同上
	 */	
	private String keyRrelation;
	
	/** name:1（匹配成功）0（匹配失败)*/	
	private String name;
	
	/** telBiz:1（匹配成功）0（匹配失败)*/	
	private String telBiz;
	
	/** telHome:1（匹配成功）0（匹配失败)*/	
	private String telHome;
	
	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	@Column(name = "USER_ID",length=1)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Column(name = "CELL",length=1)
	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}
	
	@Column(name = "MAIL",length=1)
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "KEY_RELATION",length=3)
	public String getKeyRrelation() {
		return keyRrelation;
	}

	public void setKeyRrelation(String keyRrelation) {
		this.keyRrelation = keyRrelation;
	}
	
	@Column(name = "NAME",length=1)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "TEL_BIZ",length=1)
	public String getTelBiz() {
		return telBiz;
	}

	public void setTelBiz(String telBiz) {
		this.telBiz = telBiz;
	}
	
	@Column(name = "TEL_HOME",length=1)
	public String getTelHome() {
		return telHome;
	}

	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}	
	
}
