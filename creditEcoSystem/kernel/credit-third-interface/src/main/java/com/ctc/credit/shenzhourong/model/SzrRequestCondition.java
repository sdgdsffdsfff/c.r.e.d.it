/**
 * 
 */
package com.ctc.credit.shenzhourong.model;

import com.ctc.credit.shenzhourong.api.dto.SzrRequestDto;

/**
 * @author Chengang
 * 2015年7月27日 下午1:46:02 
 */
public class SzrRequestCondition {
	private String queryType;//查询类型
	private String applyNo;//查询单号
	private String sourceId;//来源业务系统
	private SzrRequestDto dto;
	
	
	public String getQueryType() {
		return queryType;
	}
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}
	public String getApplyNo() {
		return applyNo;
	}
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}
	public String getSourceId() {
		return sourceId;
	}
	public void setSourceId(String sourceId) {
		this.sourceId = sourceId;
	}
	public SzrRequestDto getDto() {
		return dto;
	}
	public void setDto(SzrRequestDto dto) {
		this.dto = dto;
	}
	
	
}
