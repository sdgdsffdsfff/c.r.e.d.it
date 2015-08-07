package com.ctc.credit.kernel.base;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeUtil {

	/**
	 * 获得一天的开始时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfDay(Date date) {
		if (date == null)
			return null;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * 获得一天的结束时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndOfDay(Date date) {
		if (date == null)
			return null;

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);

		return cal.getTime();
	}

	/**
	 * 把yyyy-MM-dd格式的字符串解析成Date
	 * 
	 * @param day
	 * @return
	 */
	public static Date parseDayDate(String day) {
		if (day == null)
			return null;
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = df.parse(day);
		} catch (ParseException e) {
		}
		return date;
	}

	/**
	 * 把Date格式成yyyy-MM-dd HH:mm:ss格式的字符串
	 * 
	 * @param day
	 * @return
	 */
	public static String formatDate(Date date) {
		if (date == null)
			return "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	
	

	/**
	 * 把Date格式成yyyy-MM-dd格式的字符串
	 * 
	 * @param day
	 * @return
	 */
	public static String format2Date(Date date) {
		if (date == null)
			return "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(date);
	}
	
	/**
	 * 把Date格式成yyyy年MM月dd日格式的字符串
	 * 
	 * @param day
	 * @return
	 */
	public static String format2DateCN(Date date) {
		if (date == null)
			return "";

		SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
		return df.format(date);
	}

	/**
	 * 比较时间，判断是否已经结束
	 * 
	 * @param date
	 *            格式：yyyy-MM-dd 00:00:00 ,用于与当前时间比较
	 * @return true : 已经结束，else 未结束
	 */
	public static boolean isFinish(Date date) {
		boolean isFinish = false;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		long currentDay = cal.getTimeInMillis();
		if ((date != null) && (date.getTime() < currentDay)) {
			isFinish = true;
		}
		return isFinish;
	}

	public static Date parseString2Date(String dateStr) {
		if (dateStr == null)
			return null;
		Date date = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 获得某个日期所在月的第一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeginOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		return cal.getTime();
	}

	/**
	 * 获得某个日期所在月的最后一天
	 * 
	 * @param date
	 * @return
	 */
	public static Date getEndOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);
		cal.set(Calendar.DATE, 1);
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 999);
		return cal.getTime();
	}
	
	/**
	 * 比较两个日期的大小
	 * 
	 * @param date
	 * @return 
	 * date>date2 re>0;
	 * date=date2 re=0;
	 * date<date2 re<0;
	 */
	public static long compareDate(Date date,Date date2) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		long l1 = c.getTimeInMillis();

		c.setTime(date2);
		long l2 = c.getTimeInMillis();

		long betweenSecond = (l1 - l2) / 1000;
		return betweenSecond;
	}
	
	/**
	 * 计算两个日期间的天数
	 * 
	 * @param smallDate
	 * @param bigDate
	 * @return
	 */
	public static int calculateDaysBetween(Date smallDate, Date bigDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(smallDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l1 = c.getTimeInMillis();

		c.setTime(bigDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l2 = c.getTimeInMillis();

		long betweenDays = (l2 - l1) / (1000 * 60 * 60 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}
	
	/**
	 * 计算两个日期间的年数
	 * 
	 * @param smallDate
	 * @param bigDate
	 * @return
	 */
	public static int calculateYearsBetween(Date smallDate, Date bigDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(smallDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		int cys = c.get(Calendar.YEAR);

		c.setTime(bigDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		int cym = c.get(Calendar.YEAR);

		return cym-cys;
	}
	
	public static void main(String[] args) {
		Date small = parseString2Date("1998-07-30 00:00:00");
		Date big = parseString2Date("2000-07-30 00:00:00");
		int year = calculateYearsBetween(small,big);
		System.out.println(year);
	}
	
}