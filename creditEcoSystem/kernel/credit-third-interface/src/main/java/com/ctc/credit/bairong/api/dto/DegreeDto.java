/**
 * 
 */
package com.ctc.credit.bairong.api.dto;

/**
 * @author Chengang
 * 2015年8月4日 上午11:36:06 
 */
public class DegreeDto {
	/** 大类型（gid或id或cell） **/
	private String type;
	
	/** 命中类型 **/
	private String key;
	
	/** 命中阶层 **/
	private String degree;
	
	/** 数量 **/
	private String number;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
