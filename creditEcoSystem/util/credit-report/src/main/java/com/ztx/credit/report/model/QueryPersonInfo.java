package com.ztx.credit.report.model;

/**
 * 被查询者信息
 * 
 * @author xucy
 *
 */
public class QueryPersonInfo {
	private String name;
	private String idType;
	private String iDNumber;
	private String operator;
	private String queryReason;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getiDNumber() {
		return iDNumber;
	}

	public void setiDNumber(String iDNumber) {
		this.iDNumber = iDNumber;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public String getQueryReason() {
		return queryReason;
	}

	public void setQueryReason(String queryReason) {
		this.queryReason = queryReason;
	}

	@Override
	public String toString() {
		return "QueryPersonInfo [name=" + name + ", idType=" + idType
				+ ", iDNumber=" + iDNumber + ", operator=" + operator
				+ ", queryReason=" + queryReason + "]";
	}

}
