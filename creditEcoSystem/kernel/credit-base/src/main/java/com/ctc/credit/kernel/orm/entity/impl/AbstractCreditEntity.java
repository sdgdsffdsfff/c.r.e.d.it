package com.ctc.credit.kernel.orm.entity.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.RandomStringUtils;

import com.ctc.credit.kernel.orm.entity.CreditEntity;

@MappedSuperclass
public class AbstractCreditEntity implements CreditEntity {

	private static final long serialVersionUID = 1L;

	/** 系统编号 **/
	private String id;

	/** 创建者 **/
	private String createUser;

	/** 创建日期 **/
	private Date createDate;

	/** 更新者 **/
	private String updateUser;

	/** 更新日期 **/
	private Date updateDate;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID", length = 32, nullable = false)
	public String getId() {
		if (id != null)
			return id;
		id = RandomStringUtils.randomAlphanumeric(32);
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the createUser
	 */
	@Column(name = "CREATE_USER", length = 100)
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser
	 *            the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the createDate
	 */
	@Column(name = "CREATE_DATE")
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateUser
	 */
	@Column(name = "UPDATE_USER", length = 100)
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser
	 *            the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the updateDate
	 */
	@Column(name = "UPDATE_DATE")
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate
	 *            the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
