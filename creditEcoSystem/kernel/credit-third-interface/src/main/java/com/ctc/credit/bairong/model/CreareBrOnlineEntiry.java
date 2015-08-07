package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：线上行为评估实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_ONLINE_INFO")
public class CreareBrOnlineEntiry extends AbstractCreditEntity{
	
	private static final long serialVersionUID = 383067131200338559L;
	
	/**流水账单*/
	private String swiftNumber;
	
	private String nodeOne;
	
	private String nodeTwo;
	
	/**过去一周上网天数（自然周:周一到周日，按周更新）*/
	private String lastweekdays;
	
	/**累计上网天数（按天更新）*/
	private String totaldays;
	
	/**最近一次上网时间（按天更新）*/
	private String lasttime;

	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	
	@Column(name = "NODE_ONE",length=255)
	public String getNodeOne() {
		return nodeOne;
	}

	public void setNodeOne(String nodeOne) {
		this.nodeOne = nodeOne;
	}
	
	@Column(name = "NODE_TWO",length=255)
	public String getNodeTwo() {
		return nodeTwo;
	}

	public void setNodeTwo(String nodeTwo) {
		this.nodeTwo = nodeTwo;
	}

	@Column(name = "LAST_WEEK_DAYS",length=255)
	public String getLastweekdays() {
		return lastweekdays;
	}

	public void setLastweekdays(String lastweekdays) {
		this.lastweekdays = lastweekdays;
	}
	
	@Column(name = "TOTAL_DAYA",length=255)
	public String getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(String totaldays) {
		this.totaldays = totaldays;
	}

	@Column(name = "LAST_TIME")
	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}
	
	

}
