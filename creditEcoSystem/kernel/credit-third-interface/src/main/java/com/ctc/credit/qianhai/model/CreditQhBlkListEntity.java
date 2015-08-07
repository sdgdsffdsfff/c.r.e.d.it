package com.ctc.credit.qianhai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "QH_BLKLIST_DATA")
public class CreditQhBlkListEntity extends AbstractCreditEntity{

	private static final long serialVersionUID = -467823648772563357L;
	
	/** 申请Id **/
	private String applyId;
	
	/** 证件号码 **/
	private String idNo;
	
	/** 证件类型 **/
	private String idType;
	
	/** 主体名称 **/
	private String name;
	
	/** 序列号 **/
	private String seqNo;
	
	/** 来源代码 **/
	private String sourceId;
	
	/** 查询严重等级 **/
	private String gradeQuery;
	
	/** 业务发生时间 **/
	private String dataBuildTime;
	
	/** 查询数据状态 **/
	private String state;
	
	/** 金额范围 **/
	private String moneyBound;
	
	/** 数据状态 **/
	private String dataStatus;
	
	/** 预留字段1 **/
	private String reservedFiled1;
	
	/** 预留字段2 **/
	private String reservedFiled2;
	
	/** 预留字段3 **/
	private String reservedFiled3;
	
	/** 预留字段4 **/
	private String reservedFiled4;
	
	/** 预留字段5 **/
	private String reservedFiled5;
	
	/** 错误代码 **/
	private String erCode;
	
	/** 错误信息 **/
	private String erMsg;

	/**
	 * @return the idNo
	 */
	@Column(name = "ID_NO",length=64)
	public String getIdNo() {
		return idNo;
	}

	/**
	 * @param idNo the idNo to set
	 */
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}

	/**
	 * @return the idType
	 */
	@Column(name = "ID_TYPE",length=1)
	public String getIdType() {
		return idType;
	}

	/**
	 * @param idType the idType to set
	 */
	public void setIdType(String idType) {
		this.idType = idType;
	}


	/**
	 * @return the name
	 */
	@Column(name = "NAME",length=128)
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
	 * @return the seqNo
	 */
	@Column(name = "SEQ_NO",length=24)
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the sourceId
	 */
	@Column(name = "SOURCE_ID",length=2)
	public String getSourceId() {
		return sourceId;
	}

	/**
	 * @param sourceId the sourceId to set
	 */
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}

	/**
	 * @return the gradeQuery
	 */
	@Column(name = "GRADE_QUERY",length=2)
	public String getGradeQuery() {
		return gradeQuery;
	}

	/**
	 * @param gradeQuery the gradeQuery to set
	 */
	public void setGradeQuery(String gradeQuery) {
		this.gradeQuery = gradeQuery;
	}

	/**
	 * @return the dataBuildTime
	 */
	@Column(name = "DATA_BUILD_TIME",length=24)
	public String getDataBuildTime() {
		return dataBuildTime;
	}

	/**
	 * @param dataBuildTime the dataBuildTime to set
	 */
	public void setDataBuildTime(String dataBuildTime) {
		this.dataBuildTime = dataBuildTime;
	}

	/**
	 * @return the state
	 */
	@Column(name = "STATE",length=1)
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}


	/**
	 * @return the moneyBound
	 */
	@Column(name = "MONEY_BOUND",length=2)
	public String getMoneyBound() {
		return moneyBound;
	}

	/**
	 * @param moneyBound the moneyBound to set
	 */
	public void setMoneyBound(String moneyBound) {
		this.moneyBound = moneyBound;
	}

	/**
	 * @return the dataStatus
	 */
	@Column(name = "DATA_STATUS",length=2)
	public String getDataStatus() {
		return dataStatus;
	}

	/**
	 * @param dataStatus the dataStatus to set
	 */
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus;
	}

	/**
	 * @return the reservedFiled1
	 */
	@Column(name = "RESERVED_FILED1",length=2)
	public String getReservedFiled1() {
		return reservedFiled1;
	}

	/**
	 * @param reservedFiled1 the reservedFiled1 to set
	 */
	public void setReservedFiled1(String reservedFiled1) {
		this.reservedFiled1 = reservedFiled1;
	}

	/**
	 * @return the reservedFiled2
	 */
	@Column(name = "RESERVED_FILED2",length=2)
	public String getReservedFiled2() {
		return reservedFiled2;
	}

	/**
	 * @param reservedFiled2 the reservedFiled2 to set
	 */
	public void setReservedFiled2(String reservedFiled2) {
		this.reservedFiled2 = reservedFiled2;
	}

	/**
	 * @return the reservedFiled3
	 */
	@Column(name = "RESERVED_FILED3",length=2)
	public String getReservedFiled3() {
		return reservedFiled3;
	}

	/**
	 * @param reservedFiled3 the reservedFiled3 to set
	 */
	public void setReservedFiled3(String reservedFiled3) {
		this.reservedFiled3 = reservedFiled3;
	}

	/**
	 * @return the reservedFiled4
	 */
	@Column(name = "RESERVED_FILED4",length=2)
	public String getReservedFiled4() {
		return reservedFiled4;
	}

	/**
	 * @param reservedFiled4 the reservedFiled4 to set
	 */
	public void setReservedFiled4(String reservedFiled4) {
		this.reservedFiled4 = reservedFiled4;
	}

	/**
	 * @return the reservedFiled5
	 */
	@Column(name = "RESERVED_FILED5",length=2)
	public String getReservedFiled5() {
		return reservedFiled5;
	}

	/**
	 * @param reservedFiled5 the reservedFiled5 to set
	 */
	public void setReservedFiled5(String reservedFiled5) {
		this.reservedFiled5 = reservedFiled5;
	}

	/**
	 * @return the applyId
	 */
	@Column(name = "APPLY_ID",length=255)
	public String getApplyId() {
		return applyId;
	}

	/**
	 * @param applyId the applyId to set
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/**
	 * @return the erCode
	 */
	@Column(name = "ER_CODE",length=255)
	public String getErCode() {
		return erCode;
	}

	/**
	 * @param erCode the erCode to set
	 */
	public void setErCode(String erCode) {
		this.erCode = erCode;
	}

	/**
	 * @return the erMsg
	 */
	@Column(name = "ER_MSG",length=255)
	public String getErMsg() {
		return erMsg;
	}

	/**
	 * @param erMsg the erMsg to set
	 */
	public void setErMsg(String erMsg) {
		this.erMsg = erMsg;
	}
	
}
