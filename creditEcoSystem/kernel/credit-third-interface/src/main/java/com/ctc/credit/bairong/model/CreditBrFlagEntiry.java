package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：报告输出标识实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_FLAG_INFO")
public class CreditBrFlagEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 140047199688234578L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**通过key值查询核心报告输出标志：1(输出成功),0(未匹配上无输出)，99（系统异常）,null（没有选择该报告或输入信息不充足）*/
	private String coreKey;
	
	/**通过gid值查询核心报告输出标志：数据同上*/
	
	private String coreGid;
	
	/**审核记录核查输出标志：数据同上*/
	private String al;
	
	/**百融通用评分输出标志：数据同上*/
	private String score;
	
	/**特殊名单报告输出标志：数据同上*/
	private String sl;
	
	/**收支等级报告输出标志：数据同上*/
	private String ac;
	
	/**支出消费报告输出标志：数据同上*/
	private String pc;
	
	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	
	
	@Column(name = "CORE_KEY",length=2)
	public String getCoreKey() {
		return coreKey;
	}

	public void setCoreKey(String coreKey) {
		this.coreKey = coreKey;
	}
	@Column(name = "CORE_GID",length=2)
	public String getCoreGid() {
		return coreGid;
	}

	public void setCoreGid(String coreGid) {
		this.coreGid = coreGid;
	}

	@Column(name = "AL",length=2)
	public String getAl() {
		return al;
	}

	public void setAl(String al) {
		this.al = al;
	}
	
	@Column(name = "SCORE",length=2)
	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	@Column(name = "SL",length=2)
	public String getSl() {
		return sl;
	}

	public void setSl(String sl) {
		this.sl = sl;
	}

	@Column(name = "AC",length=2)
	public String getAc() {
		return ac;
	}

	public void setAc(String ac) {
		this.ac = ac;
	}
	@Column(name = "PC",length=2)
	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}
	
	

}
