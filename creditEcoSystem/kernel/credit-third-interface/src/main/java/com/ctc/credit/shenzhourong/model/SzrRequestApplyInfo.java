/**
 * 
 */
package com.ctc.credit.shenzhourong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Chengang
 * 2015年7月29日 上午9:29:25 
 */
@Entity
@Table(name = "SZR_REQUEST_APPLY_INFO")
public class SzrRequestApplyInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;//主键ID
	
	@Column(name = "APPLY_NO")
	private String applyNo;//申请编号
	
	@Column(name="SERVICE_CODE")
	private String serviceCode;//服务编码
	
	@Column(name="IDNO")
	private String IdNo;//身份证号
	
	@Column(name="NAME")
	private String Name;//姓名
	
	@Column(name="IDTYPE")
	private String IdType;//证件类型
	
	@Column(name="MOBILE")
	private String mobile;//手机
	
	@Column(name="SOURCE_ID")
	private String sourceId;//来源业务系统
	
	@Column(name="CREATE_DATE")
	private String createDate;//日期
	
	@Column(name="QUERY_TYPE")
	private String queryType;//查询类型
	
	@Column(name="RESULT")
	private String result;//查询结果
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getApplyNo() {
		return applyNo;
	}

	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getIdNo() {
		return IdNo;
	}

	public void setIdNo(String idNo) {
		IdNo = idNo;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getIdType() {
		return IdType;
	}

	public void setIdType(String idType) {
		IdType = idType;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getSourceId() {
		return sourceId;
	}

	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getQueryType() {
		return queryType;
	}

	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
}
