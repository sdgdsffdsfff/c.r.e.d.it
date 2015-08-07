package com.ctc.credit.bairong.api.dto.internet;

import java.util.Date;

public class InternetStatisticsDto {

	/** 过去一周上网天数（自然周:周一到周日，按周更新）**/
	private String lastweekdays;
	
	/** 累计上网天数（按天更新）**/
	private String totaldays;
	
	/**lasttime:最近一次上网时间（按天更新)*/
	private String lasttime;

	public String getLastweekdays() {
		return lastweekdays;
	}

	public void setLastweekdays(String lastweekdays) {
		this.lastweekdays = lastweekdays;
	}

	public String getTotaldays() {
		return totaldays;
	}

	public void setTotaldays(String totaldays) {
		this.totaldays = totaldays;
	}

	public String getLasttime() {
		return lasttime;
	}

	public void setLasttime(String lasttime) {
		this.lasttime = lasttime;
	}

	
	
	
}
