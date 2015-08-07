package com.ctc.credit.blackgreylist.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "CREDIT_BLKGRAYLIST_SEARCH_LOG")
public class CreditBlkgraylistSearchLogEntity {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	@Column(name = "APPLY_NO")
	private String applyNo;
	
	@Column(name = "APPLY_INFO")
	private String applyInfo;
	
	@Column(name = "SEARCH_TYPE")
	private Integer searchType;
	
	@Column(name = "IS_MATCHED")
	private String isMatch;
	
	@Column(name = "MATCHED_ROLE_INFO")
	private String matchedRoleInfo;
	
	@Column(name = "MATCHED_INFO")	
	private String matchedInfo;

	@Column(name = "TIGGE_SOURCE")
	private String tiggerSource;
	
	@Column(name = "CREATE_TIME")
	private String createTime;

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

	public String getApplyInfo() {
		return applyInfo;
	}

	public void setApplyInfo(String applyInfo) {
		this.applyInfo = applyInfo;
	}

	public Integer getSearchType() {
		return searchType;
	}

	public void setSearchType(Integer searchType) {
		this.searchType = searchType;
	}

	public String getIsMatch() {
		return isMatch;
	}

	public void setIsMatch(String isMatch) {
		this.isMatch = isMatch;
	}

	public String getMatchedRoleInfo() {
		return matchedRoleInfo;
	}

	public void setMatchedRoleInfo(String matchedRoleInfo) {
		this.matchedRoleInfo = matchedRoleInfo;
	}

	public String getMatchedInfo() {
		return matchedInfo;
	}

	public void setMatchedInfo(String matchedInfo) {
		this.matchedInfo = matchedInfo;
	}

	public String getTiggerSource() {
		return tiggerSource;
	}

	public void setTiggerSource(String tiggerSource) {
		this.tiggerSource = tiggerSource;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
