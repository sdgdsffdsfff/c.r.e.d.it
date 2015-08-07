package com.ctc.credit.kernel.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.i18n.LocaleContextHolder;


public class DateUtil {
	
    private static Log log = LogFactory.getLog(DateUtil.class);
    public static final String TIME_PATTERN = "HH:mm:ss";
    public static final String DATE_TIME_MS_PATTERN = "yyyy-MM-dd HH:mm:ss.S";
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_YYYYMMDD_PATTERN = "yyyyMMdd";
    public static final String TIME_HHMM_PATTERN = "HH:mm";
    public static final String TIME_HHMM_PATTERN2 = "HHmm";
    public static final String DATE_TIME_NO_HORI_PATTERN = "yyyyMMdd HH:mm:ss";
    public static final String DATE_TIME_NO_SPACE_PATTERN = "yyyyMMddHHmmss";
    public static final String DATE_TIME_PLAYBILL_PATTERN = "yyyyMMdd HH:mm";
    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_ENGLISH_FORMAT = "EEE MMM dd HH:mm:ss zzz yyyy";
    

    
    public static final SimpleDateFormat timeFormat = new SimpleDateFormat(DATE_TIME_MS_PATTERN);
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_PATTERN);
    public static final SimpleDateFormat yyyyMMdd = new SimpleDateFormat(DATE_YYYYMMDD_PATTERN);
    public static final SimpleDateFormat HHmm = new SimpleDateFormat(TIME_HHMM_PATTERN);
    public static final SimpleDateFormat HHmm2 = new SimpleDateFormat(TIME_HHMM_PATTERN2);
    public static final SimpleDateFormat yyyyMMddHHmmss = new SimpleDateFormat(DATE_TIME_NO_HORI_PATTERN);
    public static final SimpleDateFormat yyyyMMddHHmmssFile = new SimpleDateFormat(DATE_TIME_NO_SPACE_PATTERN);
    public static final SimpleDateFormat PLAYBILL_TIME_PATTERN = new SimpleDateFormat(DATE_TIME_PLAYBILL_PATTERN);
    public static final SimpleDateFormat ENGLISH_SDF = new SimpleDateFormat(DATE_ENGLISH_FORMAT,Locale.ENGLISH);
    
    
    
    private static Map<String, SimpleDateFormat> patternFormatMap;
    
    public static Map<String, SimpleDateFormat> getInstance(){
    	
    	if(patternFormatMap ==null){
    		
    		patternFormatMap = new HashMap<String, SimpleDateFormat>();
    		patternFormatMap.put(DATE_TIME_MS_PATTERN, timeFormat);
    		patternFormatMap.put(DATE_TIME_PATTERN, dateFormat);
    		patternFormatMap.put(DATE_YYYYMMDD_PATTERN, yyyyMMdd);
    		patternFormatMap.put(TIME_HHMM_PATTERN, HHmm);
    		patternFormatMap.put(TIME_HHMM_PATTERN2, HHmm2);
    		patternFormatMap.put(DATE_TIME_NO_HORI_PATTERN, yyyyMMddHHmmss);
    		patternFormatMap.put(DATE_TIME_NO_SPACE_PATTERN, yyyyMMddHHmmssFile);
    		patternFormatMap.put(DATE_TIME_PLAYBILL_PATTERN, PLAYBILL_TIME_PATTERN);
    		patternFormatMap.put(DATE_ENGLISH_FORMAT, ENGLISH_SDF);
    		
    	}
    	return patternFormatMap;
    	
    } 
       
    
   
    public static String formatDate(String pattern, Date adate){
    	
    	SimpleDateFormat sdf = DateUtil.getInstance().get(pattern);
    	
    	if(sdf==null){
    		
    		sdf = new SimpleDateFormat(pattern);
    		DateUtil.getInstance().put(pattern, sdf);
    	}
    	
    	return sdf.format(adate);
    } 

    
    public static Date parseDate(String pattern, String dateStr){
    	
    	SimpleDateFormat sdf = DateUtil.getInstance().get(pattern);
    	
    	if(sdf==null){
    		
    		sdf = new SimpleDateFormat(pattern);
    		DateUtil.getInstance().put(pattern, sdf);
    	}
    	
    	try {
			return sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
    } 
    
    
	/**
	 * 计算时间的起始时间
	 * */
	private final static String BASIC_DATE = "2000-01-01 00:00:00";

    /**
     * Checkstyle rule: utility classes should not have public constructor
     */
    private DateUtil() {
    }
    
    /**
     * 把日期字符串yyyy-MM-dd HH:mm:ss转换成HH:mm形式
     */
    public static String strToString(String date){
    	if(date == null || "".equals(date)){
    		return date;
    	}
    	String temp="";
    	try{
    		Date dateStr = dateFormat.parse(date);
    		temp = HHmm.format(dateStr);
    	}catch(Exception ex){
    		log.debug(ex.getStackTrace());
    	}
    	return temp;
    }
    
    public static String dateToString(Date date){
    	SimpleDateFormat df;
        String returnValue = "";
        if (date != null) {
            df = new SimpleDateFormat(DATE_FORMAT);
            returnValue = df.format(date);
        }

        return (returnValue);
    }

    /**
     * Return default datePattern (MM/dd/yyyy)
     * @return a string representing the date pattern on the UI
     */
    public static String getDatePattern() {
        Locale locale = LocaleContextHolder.getLocale();
        String defaultDatePattern;
        try {
            defaultDatePattern = ResourceBundle.getBundle("ApplicationResources", locale)
                .getString("date.format");
        } catch (MissingResourceException mse) {
            defaultDatePattern = "yyyy-MM-dd";
        }

        return defaultDatePattern;
    }

    public static String getDateTimePattern() {
        return DateUtil.getDatePattern() + " HH:mm:ss.S";
    }

    /**
     * This method attempts to convert an Oracle-formatted date
     * in the form dd-MMM-yyyy to mm/dd/yyyy.
     *
     * @param aDate date from database as a string
     * @return formatted string for the ui
     */
    public static String getDate(Date aDate) {
        SimpleDateFormat df;
        String returnValue = "";

        if (aDate != null) {
            df = new SimpleDateFormat(getDatePattern());
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param strDate a string representation of a date
     * @return a converted Date object
     * @see java.text.SimpleDateFormat
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String aMask, String strDate)
      throws ParseException {
        SimpleDateFormat df;
        Date date;
        df = new SimpleDateFormat(aMask);

        if (log.isDebugEnabled()) {
            log.debug("converting '" + strDate + "' to date with mask '" + aMask + "'");
        }

        try {
            date = df.parse(strDate);
        } catch (ParseException pe) {
            //log.error("ParseException: " + pe);
            throw new ParseException(pe.getMessage(), pe.getErrorOffset());
        }

        return (date);
    }

    /**
     * This method returns the current date time in the format:
     * MM/dd/yyyy HH:MM a
     *
     * @param theTime the current time
     * @return the current date/time
     */
    public static String getTimeNow(Date theTime) {
        return getDateTime(TIME_PATTERN, theTime);
    }

    /**
     * This method returns the current date in the format: MM/dd/yyyy
     * 
     * @return the current date
     * @throws ParseException when String doesn't match the expected format
     */
    public static Calendar getToday() throws ParseException {
        Date today = new Date();
        SimpleDateFormat df = new SimpleDateFormat(getDatePattern());

        // This seems like quite a hack (date -> string -> date),
        // but it works ;-)
        String todayAsString = df.format(today);
        Calendar cal = new GregorianCalendar();
        cal.setTime(convertStringToDate(todayAsString));

        return cal;
    }

    /**
     * This method generates a string representation of a date's date/time
     * in the format you specify on input
     *
     * @param aMask the date pattern the string is in
     * @param aDate a date object
     * @return a formatted string representation of the date
     * 
     * @see java.text.SimpleDateFormat
     */
    public static String getDateTime(String aMask, Date aDate) {
        SimpleDateFormat df = null;
        String returnValue = "";

        if (aDate == null) {
            log.error("aDate is null!");
        } else {
            df = new SimpleDateFormat(aMask);
            returnValue = df.format(aDate);
        }

        return (returnValue);
    }

    /**
     * This method generates a string representation of a date based
     * on the System Property 'dateFormat'
     * in the format you specify on input
     * 
     * @param aDate A date to convert
     * @return a string representation of the date
     */
    public static String convertDateToString(Date aDate) {
        return getDateTime(getDatePattern(), aDate);
    }

    /**
     * This method converts a String to a date using the datePattern
     * 
     * @param strDate the date to convert (in format MM/dd/yyyy)
     * @return a date object
     * @throws ParseException when String doesn't match the expected format
     */
    public static Date convertStringToDate(String strDate){
        Date aDate = null;
        if(strDate == null){
        	return null;
        }
        try {
            if (log.isDebugEnabled()) {
                log.debug("converting date with pattern: " + getDatePattern());
            }

            aDate = convertStringToDate(getDatePattern(), strDate);
        } catch (ParseException pe) {
            log.error("Could not convert '" + strDate + "' to a date, throwing exception");
            pe.printStackTrace();
        }
        return aDate;
    }
    
    public static java.sql.Date convertDateToSqlDate(Date date){
    	return new java.sql.Date(date.getTime());
	}
    
    public static java.sql.Timestamp convertDateToTimestamp(Date date){
    	return new java.sql.Timestamp(date.getTime());
	}
    
    
    public static String getNowTime(Date date) {
    	if (date==null){
    		return "";
    	}
		return timeFormat.format(date);
	}
    
    public static String getDateTime(String sdate) {
    	try{
    	java.sql.Timestamp date =stringToTimestamp(sdate);
    		return dateFormat.format(date);
    	}catch(Exception e){
    		return sdate;
    	}
	}
    
    public static java.sql.Timestamp stringToTimestamp(String timestampStr) {  
    	if (timestampStr == null || timestampStr.length() < 1)  
    	return null;  
    	return java.sql.Timestamp.valueOf(timestampStr);  
    }  
    /**
     *根据日期计算出所在周的日期，并返回大小为7的数组 
     * @param date
     * @return
     */
    public static  String[] getWholeWeekByDate(Date date){
		String[] ss = new String[7];
		Calendar calendar = Calendar.getInstance();
		for (int i=0,j=2;i<6&&j<8;i++,j++){
		     calendar.setTime(date);
		     calendar.setFirstDayOfWeek(Calendar.MONDAY); 
		     calendar.set(Calendar.DAY_OF_WEEK, j);
		     ss[i] =  getFormatDate(calendar.getTime());
		}
	    calendar.setTime(date);
	    calendar.setFirstDayOfWeek(Calendar.MONDAY); 
	    calendar.set(Calendar.DAY_OF_WEEK, calendar.getFirstDayOfWeek() + 6); 
		ss[6]= getFormatDate(calendar.getTime());
		return ss;
	}
    
    /**
     * 返回格式 yyyyMMdd的日期格式
     * @param d
     * @return
     */
    public static String getFormatDate(Date d) {
    	return yyyyMMdd.format(d);
    }
    public static String getHHmm2(Date d) {
    	return HHmm2.format(d);
    }
    
    public static Date getDateByString(String pattern) throws ParseException {
    	return yyyyMMdd.parse(pattern);
    }
   
    public static Date getPlayBillTimeByPattern(String date) throws ParseException {
    	return PLAYBILL_TIME_PATTERN.parse(date);
    }
    
    
	public static String getNowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String nowTime = df.format(date);
		return nowTime;
	}
	
	/**
	 * @return 当前标准日期yyyyMMddHHmmss
	 */
	public static String getNowTimeNumber() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String nowTime = df.format(date);
		return nowTime;
	}
	
	/**
	 * 获取从2000年1月1日 00:00:00开始到指定日期的秒数
	 * 
	 * @param 日期
	 * @return long
	 */
	public static Long getSeconds(Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
		Date basicDate = formatter.parse(BASIC_DATE, new ParsePosition(0));
		long secLong = (date.getTime() - basicDate.getTime()) / 1000L;
		return secLong;
	}

	/**
	 * 获取从2000年1月1日 00:00:00开始到指定日期的秒数
	 * 
	 * @param 日期
	 * @param 日期格式
	 *            例如：yyyy-MM-dd HH:mm:ss
	 * @return long
	 */
	public static Long getSeconds(String dateStr, String df) {
		if (dateStr == null || "".equals(dateStr)) {
			return null;
		}
		if (df == null || "".equals(df)) {
			df = DATE_FORMAT;
		}
		SimpleDateFormat formatter = new SimpleDateFormat(df);
		Date date = formatter.parse(dateStr, new ParsePosition(0));
		return getSeconds(date);
	}
	
	   /**
     * 返回格式 yyyyMMdd的日期格式
     * @param d
     * @return
     */

    public static Date getDateByStringyyyyMMddHHmmss(String pattern) throws ParseException {
    	return yyyyMMddHHmmssFile.parse(pattern);
    }
   

    
    public static Date getFormatDateByEnglishSDF(String s) {
    	try {
			return ENGLISH_SDF.parse(s);
		} catch (ParseException e) {
			log.error("",e);
			return null;
		}
    }
    
    public static String getFormatDateByyyyyMMddHHmmssFile(Date d) {
    	return yyyyMMddHHmmssFile.format(d);
    }
    public static String formateStrDate(String d) {
    		Date formateDate = null;
			try {
				formateDate = dateFormat.parse(d);
				String dateStr = getFormatDateByyyyyMMddHHmmssFile(formateDate);
				return dateStr;
			} catch (ParseException e) {
				e.printStackTrace();
			}
    		return null;
    }
    
    public static Date getMaxDate(Date dt){
    	Date ret = null;
    	if(dt != null){
    		ret = parseDate(DATE_TIME_PATTERN,formatDate("yyyy-MM-dd 23:59:59",dt));
    	}
    	return ret;
    }
    
    public static Date getMinDate(Date dt){
    	Date ret = null;
    	if(dt != null){
    		ret = parseDate(DATE_TIME_PATTERN,formatDate("yyyy-MM-dd 00:00:00",dt));
    	}
    	return ret;
    }
    public static void main(String[] a){
    	//DateUtil da = new DateUtil();
    	 //da.parseDate(DATE_TIME_PATTERN,"Mon Apr 11 18:09:36 CST 2011");
    	String curTime = new Timestamp(System.currentTimeMillis()).toString();
    	System.out.println(curTime);
    }
    
}
