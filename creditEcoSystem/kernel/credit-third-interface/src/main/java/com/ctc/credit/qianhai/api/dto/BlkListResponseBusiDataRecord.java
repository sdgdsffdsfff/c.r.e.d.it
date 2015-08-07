package com.ctc.credit.qianhai.api.dto;

/**
 * 请求报文业务数据记录
 * @author sunny
 *
 */
public class BlkListResponseBusiDataRecord {
	
	/** 证件号码 **/
	private String idNo;
	
	/** 证件类型 **/
	private String idType;
	
	/** 查询原因 **/
	private String reasonCode;
	
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
	
	/** 错误代码 **/
	private String erCode;
	
	/** 错误信息 **/
	private String erMsg;
	
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
	
	
	
	/**
	 * @return the idNo
	 */
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
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}

	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}

	/**
	 * @return the name
	 */
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
	 * @return the erCode
	 */
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
	public String getErMsg() {
		return erMsg;
	}

	/**
	 * @param erMsg the erMsg to set
	 */
	public void setErMsg(String erMsg) {
		this.erMsg = erMsg;
	}

	/**
	 * @return the moneyBound
	 */
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
	public String getReservedFiled5() {
		return reservedFiled5;
	}

	/**
	 * @param reservedFiled5 the reservedFiled5 to set
	 */
	public void setReservedFiled5(String reservedFiled5) {
		this.reservedFiled5 = reservedFiled5;
	}

}
