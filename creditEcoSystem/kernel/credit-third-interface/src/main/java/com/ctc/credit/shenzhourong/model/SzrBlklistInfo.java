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
 * 2015年7月23日 下午5:33:57 
 */
@Entity
@Table(name = "SZR_BLKLIST_INFO")
public class SzrBlklistInfo {
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;//自动生成记录编号
	
	@Column(name = "APPLY_NO")
	private String applyNo;//申请编号
	
	@Column(name = "NAME")
	private String name;//姓名
	
	@Column(name = "IDNO")
	private String idNo;//证件号
	
	@Column(name = "IDTYPE")
	private String idType;//证件类别
	
	@Column(name = "GRADE")
	private String grade;//黑名单等级
	
	@Column(name = "GRADE_DESC")
	private String gradeDesc;//黑名单登记描述
	
	@Column(name = "SOURCEID")
	private String sourceId;//来源
	
	@Column(name = "CREATE_DATE")
	private String createDate;//创建日期
	
	
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdNo() {
		return idNo;
	}
	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}
	public String getIdType() {
		return idType;
	}
	public void setIdType(String idType) {
		this.idType = idType;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getGradeDesc() {
		return gradeDesc;
	}
	public void setGradeDesc(String gradeDesc) {
		this.gradeDesc = gradeDesc;
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

}
