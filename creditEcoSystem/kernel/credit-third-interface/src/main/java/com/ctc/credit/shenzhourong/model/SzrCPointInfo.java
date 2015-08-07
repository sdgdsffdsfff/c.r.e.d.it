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
 * 2015年7月28日 上午11:04:51 
 */
@Entity
@Table(name = "SZR_CPOINT_INFO")
public class SzrCPointInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;//自动生成记录编号
	
	@Column(name = "APPLY_NO")
	private String applyNo;//申请编号
	
	@Column(name = "MOBILE")
	private String mobile;
	@Column(name = "SCORE")
	private String score;
	@Column(name = "TAG1")
	private String tag1;
	@Column(name = "TAG2")
	private String tag2;
	@Column(name = "TAG3")
	private String tag3;
	@Column(name = "CREATE_DATE")
	private String createDate;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	public String getTag3() {
		return tag3;
	}
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	

	
}
