package com.ctc.credit.lakala.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "LAKALA_APPLY_BLKLIST")
public class LklApplyBlkList {
	
	
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	@Column(name = "CREATE_DATE")
	private Date createDate;
	
	@Column(name = "CREATE_USER")
	private String createUser;
	
	@Column(name = "UPDATE_DATE")
	private Date updateDate;
	
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "EXCEPTION_CODE")
	private String exceptionCode;
	
	@Column(name = "EXCEPTION_MSG")
	private String exceptionMsg;
	
	@Column(name = "RQ_GMSFHM")
	private String rqGmsfhm;
	
	@Column(name = "RQ_XM")
	private String rqXm;
	
	@Column(name = "RQ_EMAIL")
	private String rqEmail;
	
	@Column(name = "RQ_IP")
	private String rqIp;
	
	@Column(name = "RQ_YHKH")
	private String rqYhkh;
	
	@Column(name = "RQ_SJHM")
	private String rqSjhm;
	
	@Column(name = "RQ_GDDH")
	private String rqGddh;
	
	@Column(name = "RP_DWCOUNT")
	private String rpDwCount;
	
	@Column(name = "RP_SCCOUNT")
	private String rpScCount;
	
	@Column(name = "RP_NEWDATE")
	private String rpNewDate;
	
	@Column(name = "RP_HMDSJ")
	private String rpHmdsj;
	
	@Column(name = "RP_HMDSJBZ")
	private String rpHmdsjBz;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public String getExceptionCode() {
		return exceptionCode;
	}

	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}

	public String getExceptionMsg() {
		return exceptionMsg;
	}

	public void setExceptionMsg(String exceptionMsg) {
		this.exceptionMsg = exceptionMsg;
	}

	public String getRqGmsfhm() {
		return rqGmsfhm;
	}

	public void setRqGmsfhm(String rqGmsfhm) {
		this.rqGmsfhm = rqGmsfhm;
	}

	public String getRqXm() {
		return rqXm;
	}

	public void setRqXm(String rqXm) {
		this.rqXm = rqXm;
	}

	public String getRqEmail() {
		return rqEmail;
	}

	public void setRqEmail(String rqEmail) {
		this.rqEmail = rqEmail;
	}

	public String getRqIp() {
		return rqIp;
	}

	public void setRqIp(String rqIp) {
		this.rqIp = rqIp;
	}

	public String getRqYhkh() {
		return rqYhkh;
	}

	public void setRqYhkh(String rqYhkh) {
		this.rqYhkh = rqYhkh;
	}

	public String getRqSjhm() {
		return rqSjhm;
	}

	public void setRqSjhm(String rqSjhm) {
		this.rqSjhm = rqSjhm;
	}

	public String getRqGddh() {
		return rqGddh;
	}

	public void setRqGddh(String rqGddh) {
		this.rqGddh = rqGddh;
	}

	public String getRpDwCount() {
		return rpDwCount;
	}

	public void setRpDwCount(String rpDwCount) {
		this.rpDwCount = rpDwCount;
	}

	public String getRpScCount() {
		return rpScCount;
	}

	public void setRpScCount(String rpScCount) {
		this.rpScCount = rpScCount;
	}

	public String getRpNewDate() {
		return rpNewDate;
	}

	public void setRpNewDate(String rpNewDate) {
		this.rpNewDate = rpNewDate;
	}

	public String getRpHmdsj() {
		return rpHmdsj;
	}

	public void setRpHmdsj(String rpHmdsj) {
		this.rpHmdsj = rpHmdsj;
	}

	public String getRpHmdsjBz() {
		return rpHmdsjBz;
	}

	public void setRpHmdsjBz(String rpHmdsjBz) {
		this.rpHmdsjBz = rpHmdsjBz;
	}
	
	
}
