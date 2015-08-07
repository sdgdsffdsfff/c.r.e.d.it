package com.ctc.credit.antifraud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "antifraud_apply_info")
public class AntiFraudRequestAndReponse extends AbstractCreditEntity {
	
	private static final long serialVersionUID = 6096350791636585101L;

	public AntiFraudRequestAndReponse() {
		super();
		this.fraudCheckStatus = "0";
		this.reponseCode = "0";
	}

	/** 申请单号 **/
	private String applyCode;
	
	/** 来源系统 **/
	private String sourceSys;
	
	/** 请求类型  0-实时查询 1-批量查询 **/
	private String queryType;
	
	/** 申请人姓名 **/
	private String name;
	
	/** 申请人证件号码 **/
	private String idCard;
	
	/** 请求json **/
	private String requestJson;
	
	/** 是否跑完反欺诈规则 0:否；1：是 **/
	private String fraudCheckStatus;
	
	/** 响应码  反欺诈 0:未命中；1：命中；2：异常**/
	private String reponseCode;
	
	/** 响应信息 **/
	private String reponseMsg;
	
	/** 响应json **/
	private String reponseJson;

	/**
	 * @return the applyCode
	 */
	@Column(name="apply_code",length=50)
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * @param applyCode the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * @return the name
	 */
	@Column(name="name",length=100)
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idCard
	 */
	@Column(name="idcard",length=20)
	public String getIdCard() {
		return idCard;
	}

	/**
	 * @param idCard the idCard to set
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * @return the requestJson
	 */
	@Column(name="request_json",length=4000)
	public String getRequestJson() {
		return requestJson;
	}

	/**
	 * @param requestJson the requestJson to set
	 */
	public void setRequestJson(String requestJson) {
		this.requestJson = requestJson;
	}

	/**
	 * @return the fraudCheckStatus
	 */
	@Column(name="fraud_check_status",length=1)
	public String getFraudCheckStatus() {
		return fraudCheckStatus;
	}

	/**
	 * @param fraudCheckStatus the fraudCheckStatus to set
	 */
	public void setFraudCheckStatus(String fraudCheckStatus) {
		this.fraudCheckStatus = fraudCheckStatus;
	}

	/**
	 * @return the reponseCode
	 */
	@Column(name="reponse_code",length=1)
	public String getReponseCode() {
		return reponseCode;
	}

	/**
	 * @param reponseCode the reponseCode to set
	 */
	public void setReponseCode(String reponseCode) {
		this.reponseCode = reponseCode;
	}

	/**
	 * @return the reponseMsg
	 */
	@Column(name="reponse_msg",length=500)
	public String getReponseMsg() {
		return reponseMsg;
	}

	/**
	 * @param reponseMsg the reponseMsg to set
	 */
	public void setReponseMsg(String reponseMsg) {
		this.reponseMsg = reponseMsg;
	}

	/**
	 * @return the reponseJson
	 */
	@Column(name="reponse_json",length=4000)
	public String getReponseJson() {
		return reponseJson;
	}

	/**
	 * @param reponseJson the reponseJson to set
	 */
	public void setReponseJson(String reponseJson) {
		this.reponseJson = reponseJson;
	}

	/**
	 * @return the sourceSys
	 */
	@Column(name="source_sys",length=1)
	public String getSourceSys() {
		return sourceSys;
	}

	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(String sourceSys) {
		this.sourceSys = sourceSys;
	}

	/**
	 * @return the queryType
	 */
	@Column(name="query_type",length=1)
	public String getQueryType() {
		return queryType;
	}

	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	
}
