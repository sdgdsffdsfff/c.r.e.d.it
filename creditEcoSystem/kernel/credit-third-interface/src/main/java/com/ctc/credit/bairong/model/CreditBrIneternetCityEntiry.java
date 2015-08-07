package com.ctc.credit.bairong.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：上网信息核查
 * @author danggang
 * city:地级市（国家&省市&地级市）
 * lastweekdays:过去一周上网天数（自然周:周一到周日，按周更新）
 * totaldays:累计上网天数（按天更新）
 * lasttime:最近一次上网时间（按天更新）
 */
@Entity
@Table(name = "BAIRONG_INTERNET_CITY_INFO")
public class CreditBrIneternetCityEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = -9157560166145145155L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**city地级市（国家&省市&地级市）*/
	private String city;
	
	/**lastweekdays过去一周上网天数（自然周:周一到周日，按周更新）*/
	private String lastweekdays;
	
	/**totaldays累计上网天数（按天更新)*/
	private String totaldays;
	
	/**lasttime最近一次上网时间（按天更新）*/
	private Date lasttime;
	
	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	
	@Column(name = "CITY",length=255)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "LAST_WEEK_DAYS",length=1)
	public String getLastweekdays() {
		return lastweekdays;
	}

	public void setLastweekdays(String lastweekdays) {
		this.lastweekdays = lastweekdays;
	}
	
	@Column(name = "TOTALDAYS",length=255)
	public String getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(String totaldays) {
		this.totaldays = totaldays;
	}

	@Column(name = "LAST_TIME")
	public Date getLasttime() {
		return lasttime;
	}

	public void setLasttime(Date lasttime) {
		this.lasttime = lasttime;
	}
	
	

}
