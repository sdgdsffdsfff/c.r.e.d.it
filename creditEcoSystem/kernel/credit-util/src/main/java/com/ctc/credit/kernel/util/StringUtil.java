package com.ctc.credit.kernel.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.ctc.credit.kernel.util.DateUtil;
import com.ctc.credit.kernel.util.MD5;

public class StringUtil {

	private static final Class collection = Collection.class;
	private static final Class iterator = Iterator.class;
	private static final Class map = Map.class;

	/**
	 * 判断是否为合法的日期时间字符串
	 * 
	 * @param str_input
	 * @return boolean;符合为true,不符合为false
	 */
	public static boolean isDate(String str_input, String rDateFormat) {
		if (!isNull(str_input)) {
			SimpleDateFormat formatter = new SimpleDateFormat(rDateFormat);
			formatter.setLenient(false);
			try {
				formatter.format(formatter.parse(str_input));
			} catch (Exception e) {
				return false;
			}
			return true;
		}
		return false;
	}

	public static boolean isNull(String str) {
		if (str == null)
			return true;
		else
			return false;
	}

	public static boolean isNullStr(String str) {
		if (str == null || str.equals(""))
			return true;
		else
			return false;
	}

	// 将NULL转换成空字符串
	public static String null2Str(Object value) {
		return value == null || "null".equals(value.toString()) ? "" : value
				.toString();
	}

	// 将NULL转换成空字符串
	public static Date null2Date(Object value) {
		if (value == null || "".equals(value.toString()) || "null".equals(value.toString())) {
			return null;
		}
		return strToDateTime(String.valueOf(value));
	}

	public static String null2Str(String value) {
		return value == null || "null".equals(value) ? "" : value.trim();
	}

	public static String nullToString(String value) {
		return value == null || "null".equals(value) ? "" : value.trim();
	}

	public static String nullToString(Object value) {
		return value == null ? "" : value.toString();
	}

	public static Long nullToLong(Object value) {
		return value == null || "null".equals(value.toString()) ? 0L
				: stringToLong(value.toString());
	}

	public static Integer nullToInteger(Object value) {
		return value == null || "null".equals(value.toString()) ? 0
				: stringToInteger(value.toString());
	}

	public static Boolean nullToBoolean(Object value) {
		if (value == null || "null".equals(value.toString()))
			return false;
		if ("1".equals(value.toString().trim())
				|| "true".equalsIgnoreCase(value.toString().trim()))
			return true;
		return false;
	}

	public static Long stringToLong(String value) {
		Long l;
		value = nullToString(value);
		if ("".equals(value)) {
			l = 0L;
		} else {
			try {
				l = Long.valueOf(value);

			} catch (Exception e) {
				l = 0L;
			}
		}
		return l;
	}

	public static Integer stringToInteger(String value) {
		Integer l;
		value = nullToString(value);
		if ("".equals(value)) {
			l = 0;
		} else {
			try {
				l = Integer.valueOf(value);

			} catch (Exception e) {
				l = 0;
			}
		}
		return l;
	}

	public static List<Long> stringToLongArray(String value) throws Exception {
		List<Long> ls = new ArrayList<Long>();
		if (value == null || "".equals(value)) {
			return ls;
		}

		try {
			String[] ids = value.split(",");
			for (int i = 0; i < ids.length; i++) {
				ls.add(Long.parseLong(ids[i]));
			}
		} catch (Exception e) {
			throw e;
		}
		return ls;
	}

	public static Long stringToLong(Object value) {
		Long l;
		value = nullToString(value);
		if ("".equals(value)) {
			l = 0L;
		} else {
			try {
				l = Long.valueOf(value.toString());
			} catch (Exception e) {
				l = 0L;
			}
		}
		return l;
	}

	/**
	 * 判断字符串是否是整数
	 */
	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static int parseInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNumber(String value) {
		return isInteger(value) || isDouble(value);
	}

	/** 判断是否为时间 * */
	public static boolean isDate(String value) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			sdf.parse(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * 
	 * 中文转换--文章换行的转换
	 * 
	 * @param str
	 * 
	 * @return
	 */

	public static String getText(String str) {
		if (str == null)
			return ("");
		if (str.equals(""))
			return ("");
		// 建立一个StringBuffer来处理输入数据
		StringBuffer buf = new StringBuffer(str.length() + 6);
		char ch = '\n';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\r') {
				buf.append(" ");
			} else if (ch == '\n') {
				buf.append(" ");
			} else if (ch == '\t') {
				buf.append("    ");
			} else if (ch == ' ') {
				buf.append(" ");
			} else if (ch == '\'') {
				buf.append("\\'");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	// 清除特殊字符
	public static String getescapeText(String str) {
		if (str == null)
			return ("");
		if (str.equals(""))
			return ("");
		// 建立一个StringBuffer来处理输入数据
		StringBuffer buf = new StringBuffer(str.length() + 6);
		char ch = '\n';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\r') {
				buf.append("");
			} else if (ch == '\n') {
				buf.append("");
			} else if (ch == '\t') {
				buf.append("");
			} else if (ch == ' ') {
				buf.append("");
			} else if (ch == '\'') {
				buf.append("");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	/**
	 * 清除所有特殊字符，只保留中英文字符和数字
	 * 
	 * @param str
	 * @return
	 */
	public static String getEscapeText(String str) {
		try {
			String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			return m.replaceAll("");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 清除所有特殊字符，只保留中英文字符和数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEscapeText(String str) {
		boolean flag = false;
		try {
			String regEx = "[`~!@#$%^&*()+=|{}':;',…\\[\\].<>/?~！@#￥%…&*（）——+|{}【】‘；：”“’。，、？]";
			Pattern p = Pattern.compile(regEx);
			Matcher m = p.matcher(str);
			if (m.find())
				flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 判断字符串中是否包含除中英文字符和数字外的特殊字符，包含返回true
	 * 
	 * @param str
	 * @return
	 */
	public static boolean haveEscapeText(String str) {
		if (str.replaceAll("[\u4e00-\u9fa5]*[a-z]*[A-Z]*\\d*-*_*\\s*", "")
				.length() == 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 
	 * 根据转义列表对字符串进行转义(escape)。
	 * 
	 * @param source
	 *            待转义的字符串
	 * 
	 * @param escapeCharMap
	 *            转义列表
	 * 
	 * @return 转义后的字符串
	 */

	public static String escapeCharacter(String source, HashMap escapeCharMap) {

		if (source == null || source.length() == 0) {

			return source;

		}

		if (escapeCharMap.size() == 0) {

			return source;

		}

		StringBuffer sb = new StringBuffer(source.length() + 100);

		StringCharacterIterator sci = new StringCharacterIterator(source);

		for (char c = sci.first();

		c != StringCharacterIterator.DONE;

		c = sci.next()) {

			String character = String.valueOf(c);

			if (escapeCharMap.containsKey(character)) {

				character = (String) escapeCharMap.get(character);

			}

			sb.append(character);

		}

		return sb.toString();

	}

	/**
	 * 
	 * 中文转换--文章换行的转换
	 * 
	 * @param str
	 * 
	 * @return
	 */

	public static String changeEnter(String str) {
		if (str == null)
			return ("");
		if (str.equals(""))
			return ("");
		// 建立一个StringBuffer来处理输入数据
		StringBuffer buf = new StringBuffer(str.length() + 6);
		char ch = '\n';
		for (int i = 0; i < str.length(); i++) {
			ch = str.charAt(i);
			if (ch == '\r') {
				buf.append("|");
			} else if (ch == '\n') {
				buf.append("|");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	// 截掉url左边的一级目录名,如/wap/news/index.xml -> /news/index.xml
	public static String trimLeftNode(String str) {
		if (str == null)
			return "";

		if (str.startsWith("/")) {
			int ind = str.indexOf("/", 1);
			if (ind > 0)
				return str.substring(ind);
		}
		return str;
	}

	public static String generatedUrl(int pageType, List<String> sourceList,
			String nodestr, int maxint) {
		List<String> nodeList = new ArrayList<String>();
		Random rmd = new Random();
		String rstr = "";
		Set<String> cpSet = new HashSet<String>();
		Set<Integer> distNum = new HashSet<Integer>();
		Set<String> distCp = new HashSet<String>();
		for (int i = 0; i < sourceList.size(); i++) {
			String tmpstr = sourceList.get(i);
			if (getSpstr(tmpstr, 1).equals(nodestr)) {
				nodeList.add(tmpstr);
				cpSet.add(getSpstr(tmpstr, 3));
			}
		}
		if (nodeList.size() > maxint) {
			for (int i = 0; i < maxint;) {
				int tmpint = rmd.nextInt(nodeList.size());
				String tmpstr = nodeList.get(tmpint);
				if ((distCp.add(getSpstr(tmpstr, 3)) || distCp.size() >= cpSet
						.size()) && distNum.add(tmpint)) {
					rstr += "<a href='" + getSpstr(tmpstr, 4) + "'>"
							+ getSpstr(tmpstr, 2) + "</a><br/>";
					i++;
				}
			}
		} else {
			for (int i = 0; i < nodeList.size(); i++) {
				String tmpstr = nodeList.get(i);
				rstr += "<a href='" + getSpstr(tmpstr, 4) + "'>"
						+ getSpstr(tmpstr, 2) + "</a><br/>";
			}
		}
		return rstr;
	}

	public static String getSpstr(String spstr, int level) {
		String rstr = "";
		for (int i = 0; i < level; i++) {
			if (spstr.indexOf("|*") == -1) {
				rstr = spstr;
				return rstr;
			} else {
				rstr = spstr.substring(0, spstr.indexOf("|*"));
			}
			spstr = spstr.substring(spstr.indexOf("|*") + 2, spstr.length());
		}
		return rstr;
	}

	public static String toString(Object obj) {
		try {
			return obj.toString();
		} catch (Exception e) {
			return "";
		}
	}

	public static String getEncrypt(String mobile, String pid) {
		StringBuffer buf = new StringBuffer();
		buf.append(mobile);
		buf.append(pid);
		buf.append("MDN2000");
		// buf.append(CmsConstants.SYSTEMCONFIG.get("PORTAL_MDN"));//"MDN2000"
		String md5String = buf.toString();
		MD5 md5 = new MD5();
		byte[] byteone = md5String.getBytes();
		return md5.md5Str(byteone, 0, byteone.length);
	}

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			'8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	/**
	 * 把byte[]数组转换成十六进制字符串表示形式
	 * 
	 * @param tmp
	 *            要转换的byte[]
	 * @return 十六进制字符串表示形式
	 */
	public static String byteToHexString(byte[] tmp) {
		if (tmp == null) {
			throw new NullPointerException();
		}
		int len = tmp.length;
		char str[] = new char[len * 2];
		int i = 0;
		for (byte b : tmp) {
			str[i * 2] = hexDigits[b >>> 4 & 0xf]; // 取字节中高 4 位的数字转换,
			str[i * 2 + 1] = hexDigits[b & 0xf]; // 取字节中低 4 位的数字转换
			i++;
		}
		return new String(str);
	}

	/**
	 * 得到一个Long值的指定长度的字符串形式
	 * 
	 * @param l
	 * @param len
	 * @return
	 */
	public static String getStringByAppointLen(Long l, int len) {
		return getStringByAppointLen(l.toString(), len, true);
	}

	/**
	 * 得到一个Integer值的指定长度的字符串形式 NOTE: 不足的前面添'0'
	 * 
	 * @param i
	 * @param len
	 * @return
	 */
	public static String getStringByAppointLen(Integer i, int len) {
		return getStringByAppointLen(i.toString(), len, true);
	}

	/**
	 * 得到一个String值的指定长度的字符串形式 NOTE: 不足的前面添'0'
	 * 
	 * @param s
	 * @param len
	 * @param cutHead
	 *            当s的长度大于len时，截取方式：true,截掉头部；否则从截掉尾部
	 *            例如getStringByAppointLen("12345",3,true) ---> "345"
	 * @return
	 */
	public static String getStringByAppointLen(String s, int len,
			boolean cutHead) {
		if (s == null || len <= 0) {
			s = "";
		}
		if (len > s.length()) {
			int size = len - s.length();
			StringBuffer sb = new StringBuffer();
			while (size-- > 0) {
				sb.append("0");
			}
			sb.append(s);
			return sb.toString();
		} else if (len == s.length()) {
			return s;
		} else {
			if (cutHead) {
				return s.substring(s.length() - len, s.length());
			} else {
				return s.substring(0, len);
			}
		}
	}

	/**
	 * 通过ID生成存储路径
	 * 
	 * @param id
	 * @return
	 */
	public static String getFileDirPathById(Long id) {
		String s = StringUtil.getStringByAppointLen(id, 12);
		StringBuffer sb = new StringBuffer();
		sb.append(s.substring(0, 3)).append("/").append(s.substring(3, 6))
				.append("/").append(s.substring(6, 9)).append("/")
				.append(s.substring(9, 12)).append("/");
		return sb.toString();
	}

	public static Boolean string2Boolean(String str) {
		try {
			if ("0".equals(str))
				return Boolean.FALSE;
			else if ("1".equals(str))
				return Boolean.TRUE;
			else if ("false".equalsIgnoreCase(str))
				return Boolean.FALSE;
			else if ("true".equalsIgnoreCase(str))
				return Boolean.TRUE;
		} catch (Exception e) {
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	public static String longArrayToString(List<Long> value) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (value == null || value.size() == 0)
			return null;

		try {
			for (Iterator<Long> it = value.iterator(); it.hasNext();) {
				sb.append(it.next());
				if (it.hasNext())
					sb.append(",");
			}
		} catch (Exception e) {
			throw e;
		}
		return sb.toString();
	}

	public static String longArray2String(List<Long> value) throws Exception {
		StringBuffer sb = new StringBuffer();
		if (value == null || value.size() == 0)
			return null;

		try {
			for (Iterator<Long> it = value.iterator(); it.hasNext();) {
				sb.append("'" + it.next() + "'");
				if (it.hasNext())
					sb.append(",");
			}
		} catch (Exception e) {
			throw e;
		}
		return sb.toString();
	}

	public static Long nullToCloneLong(Object value) {
		return value == null || isNumber(value.toString()) == false ? null
				: stringToLong(value.toString());
	}

	public static String trimSqlIds(String ids) {
		String tmpIds = ids;
		if (tmpIds != null && !"".equals(tmpIds)) {
			if (tmpIds.endsWith(","))
				tmpIds = tmpIds.substring(0, tmpIds.length() - 1);
			if (tmpIds.startsWith(","))
				tmpIds = tmpIds.substring(1, tmpIds.length());
		} else
			tmpIds = "";
		return tmpIds;
	}

	/**
	 * 判断是否数字
	 * 
	 * @param str
	 *            判断目标字符串
	 * @return 如果是，返回真
	 * @create by szq at 2009-8-12
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!"".equals(str) && isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断是否小数
	 * 
	 * @param str
	 *            判断目标字符串
	 * @return 如果是，返回真
	 * @create by szq at 2009-8-12
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("[0-9,//.]*");
		Matcher isNum = pattern.matcher(str);
		if (isNum.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 判断属期格式是否有效
	 * 
	 * @param period
	 * @create by szq at 2009-8-19
	 */
	public static boolean validPeriod(String period) {
		if (period == null || period.length() != 6 || !isNumeric(period)
				|| Integer.parseInt(period.substring(4)) < 1
				|| Integer.parseInt(period.substring(4)) > 12) {
			throw new RuntimeException("请输入正确的年月时间格式(200912)");
		}
		return true;
	}

	/**
	 * 判断属期格式是否有效
	 * 
	 * @param period
	 * @create by szq at 2009-8-19
	 */
	public static boolean validPeriodNoExc(String period) {
		boolean ret = true;
		if (period == null || period.length() != 6 || !isNumeric(period)
				|| Integer.parseInt(period.substring(4)) < 1
				|| Integer.parseInt(period.substring(4)) > 12) {
			ret = false;
		}
		return ret;
	}

	/**
	 * 将字符串转成整
	 * 
	 * @param intStr
	 * @return
	 * @create by szq at 2009-11-26
	 */
	public static Integer strToInt(String intStr) {
		Integer ret = 0;
		if (intStr != null) {
			intStr = intStr.trim();
			int index = intStr.indexOf(".");
			if (index > 0) {
				intStr = intStr.substring(0, index);
			}
			if (intStr.equals("") || intStr.equals("undefined")) {
				return 0;
			}
			if (!isNumeric(intStr)) {
				return 0;
			}

			ret = Integer.parseInt(intStr);
		}
		return ret;
	}

	/**
	 * 将字符串转成整
	 * 
	 * @param intStr
	 *            待转化的字符串
	 * @return
	 * @create by szq at 2009-11-26
	 */
	public static Integer strToIntNoExc(String intStr) {
		Integer ret = 0;
		if (intStr != null) {
			intStr = intStr.trim();
			int index = intStr.indexOf(".");
			if (index > 0) {
				intStr = intStr.substring(0, index);
			}
			if (intStr.equals("") || intStr.equals("undefined")) {
				return 0;
			}
			if (isNumeric(intStr)) {
				ret = Integer.parseInt(intStr);
			}
		}
		return ret;
	}

	/**
	 * 将字符串转成整
	 * 
	 * @param intStr
	 *            待转化的字符串
	 * @return
	 * @create by szq at 2009-11-26
	 */
	public static int strToInteger(String intStr) {
		Integer ret = 0;
		if (intStr != null) {
			intStr = intStr.trim();
			int index = intStr.indexOf(".");
			if (index > 0) {
				intStr = intStr.substring(0, index);
			}
			if (isNumeric(intStr)) {
				ret = Integer.parseInt(intStr);
			}
		}
		return ret;
	}

	public static Double strToDouble(String doubleStr) {
		if (doubleStr != null) {
			doubleStr = doubleStr.trim();
		} else {
			return 0.0;
		}
		Double ret = 0.0;
		if (!"".equals(doubleStr) && isDouble(doubleStr)) {
			ret = Double.parseDouble(doubleStr);
		}
		return ret;
	}

	/**
	 * 左补方法
	 * 
	 * @param str
	 *            原始数据
	 * @param strSize
	 *            目标长度
	 * @param li
	 *            补位标识
	 * @param encode
	 *            编码类型 如 UTF-8,GBK
	 * @return
	 */
	public static String leftPad(String str, int strSize, String li,
			String encode) {
		String res = "";
		try {
			int c = str.getBytes(encode).length;
			int a = strSize - c;
			for (int i = 0; i < a; i++) {
				res += li;
			}
			res = res + str;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return res;
	}

	public final static boolean isEmpty(Object obj) {
		if (obj == null)
			return true;
		if (iterator.isInstance(obj)) {
			return !((Iterator) obj).hasNext();
		} else {
			return getSize(obj) <= 0;
		}
	}

	public final static int getSize(Object obj) {

		if (isCollection(obj)) {
			if (collection.isInstance(obj)) {
				return ((Collection) obj).size();
			} else if (iterator.isInstance(obj)) {
				int i = 0;
				for (Iterator it = (Iterator) obj; it.hasNext();) {
					i++;
					it.next();
				}
				return i;
			} else if (map.isInstance(obj)) {
				return ((Map) obj).size();
			} else if (obj.getClass().isArray()) {
				return (Array.getLength(obj));
			}
		}
		return 0;
	}

	public final static boolean isCollection(Object col) {
		return col == null ? false : (collection.isInstance(col)
				|| iterator.isInstance(col) || map.isInstance(col) || col
				.getClass().isArray());
	}

	/**
	 * 检查对象是否为空
	 * 
	 * @param obj
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		if (obj == null) {
			return true;
		} else if (String.class.isInstance(obj)) {
			return isNull((String) obj);
		} else {
			return false;
		}
	}

	/**
	 * 安全方法,如果对象为空或空字符串，将其转化为指定的值
	 * 
	 * @param str
	 *            ：要转换的对象
	 * @param value
	 *            ：转换的值
	 * @return String
	 */
	public static String getDefault(String str, String value) {
		return isNull(str) ? value : str;
	}

	/**
	 * 三元运算符计算，当str1等于str2时，方法返回str3,否则返回str4 getDefault
	 * 
	 * @param str1
	 * @param str2
	 * @param str3
	 * @param str4
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String getDefault(String str1, String str2, String str3,
			String str4) {
		return equals(str1, str2) ? str3 : str4;
	}

	/**
	 * 安全方法,将一个字符串转换为一个数字 converStringToInt
	 * 
	 * @param str
	 *            ,要转换的字符串
	 * @param defNum
	 *            ,默认返回值
	 * @return int
	 * @exception
	 * @since 1.0.0
	 */
	public static int getDefaultToInt(String str, int defNum) {
		if (isNull(str))
			return defNum;
		int result = defNum;
		try {
			result = Integer.valueOf(str).intValue();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}


	/**
	 * 检查两个字符串是否相等
	 * 
	 * @param txt1
	 * @param txt2
	 * @param flag
	 *            : 1.true(忽略大小写) 2.false(大小写敏感)
	 * @return boolean
	 */
	public static boolean equals(String txt1, String txt2, boolean isIgnoreCase) {
		if (txt1 == null || txt2 == null) {
			return false;
		}
		if (txt1.equals(txt2))
			return true;
		if (isIgnoreCase) {
			txt1 = txt1.toLowerCase(Locale.getDefault());
			txt2 = txt2.toLowerCase(Locale.getDefault());
		}
		return txt1.intern() == txt2.intern();
	}

	/**
	 * 检查两个字符串是否相等
	 * 
	 * @param txt1
	 * @param txt2
	 * @return boolean
	 */
	public static boolean equals(String txt1, String txt2) {
		return equals(txt1, txt2, false);
	}

	/**
	 * 从一个文件路径中获取文件名称 getFileName
	 * 
	 * @param filePath
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String getFileName(String filePath) {
		int position1 = filePath.lastIndexOf("\\");
		int position2 = filePath.lastIndexOf("/");
		if (position1 != -1 && position1 > position2) {
			return filePath.substring(position1 + 1);
		} else if (position2 != -1 && position2 > position1) {
			return filePath.substring(position2 + 1);
		} else {
			return filePath;
		}
	}

	/**
	 * 为文件路径拼接一个文件分隔符 concatSeparator
	 * 
	 * @param filePath
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String concatSeparator(String filePath) {
		if (!isNull(filePath)) {
			filePath += (filePath.lastIndexOf(File.separator) == filePath
					.length() - 1) ? "" : File.separator;
		}
		return filePath;
	}

	/**
	 * 获取文件扩展名 getExtensionName
	 * 
	 * @param file
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String getExtensionName(File file) {
		String fileName = file.getName();
		if (fileName.indexOf(".") != -1) {
			int beginIndex = fileName.lastIndexOf(".");
			return fileName.substring(beginIndex == fileName.length() ? 0
					: beginIndex + 1, fileName.length());
		} else {
			return fileName;
		}
	}

	/**
	 * 将一个字符串转型为该字符串字面量类型 castStr
	 * 
	 * @param clazz
	 * @param obj
	 * @return Object
	 * @exception
	 * @since 1.0.0
	 */
	public static Object castStr(Class<?> clazz, String obj) {
		if (clazz.toString().equals("int") || clazz.equals(Integer.class)) {
			return Integer.valueOf(obj);
		} else if (clazz.toString().equals("long") || clazz.equals(Long.class)) {
			return Long.valueOf(obj);
		} else if (clazz.toString().equals("float")
				|| clazz.equals(Float.class)) {
			return Float.valueOf(obj);
		} else if (clazz.toString().equals("double")
				|| clazz.equals(Double.class)) {
			return Double.valueOf(obj);
		} else if (clazz.equals(Class.class)) {
			return clazz.toString();
		} else {
			return obj;
		}
	}

	/**
	 * 将一个字符串数组转换为一个字符串 getRangeStr
	 * 
	 * @param arr
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String getRangeStr(String[] arr) {
		return getRangeStr(arr, "(", ")");
	}

	/**
	 * 将一个字符串数组转换为一个字符串 getRangeStr
	 * 
	 * @param idList
	 * @param str1
	 * @param str2
	 * @return String
	 * @exception
	 * @since 1.0.0
	 */
	public static String getRangeStr(String[] arr, String str1, String str2) {
		return Arrays.toString(arr).replaceAll("\\[", getDefault(str1, ""))
				.replaceAll("\\]", getDefault(str2, ""));
	}

	public static Date strToDateTime(String str) {
		try {
			return DateUtil.convertStringToDate("yyyy-MM-dd HH:mm:ss", str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date strToDate(String str) {
		try {
			return DateUtil.convertStringToDate("yyyy-MM-dd", str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	public static Date strToDate(String str,String format) {
		try {
			if(format == null){
				format = "yyyy-MM-dd";
			}
			return DateUtil.convertStringToDate(format, str);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String join(Collection collection) {
		return StringUtils.join(collection, ",");
	}

	public static String join(Collection collection, String separator) {
		return StringUtils.join(collection, separator);
	}

	public static String join(Object[] array, String separator) {
		return StringUtils.join(array, separator);
	}
	
	public static String join(Object[] array) {
		return StringUtils.join(array, ",");
	}
	
	/** 
     * 格式化金额         
     * @param money 要格式化的金额,单位:分 
     * @param len 
     * @return 
     */  
    public static String formatMoney(Long money) {
    	return formatMoney(money, 2);
    }
	/** 
     * 格式化金额         
     * @param money 要格式化的金额,单位:分 
     * @param len 
     * @return 
     */  
    public static String formatMoney(Long money, int len)   
    {  
    	if(money == null){
    		return "";
    	}
        NumberFormat formater = null;  
        if (len == 0) {  
            formater = new DecimalFormat("###,###");  
        } else {  
            StringBuffer buff = new StringBuffer();  
            buff.append("###,##0.");  
            for (int i = 0; i < len; i++) {  
                buff.append("0");  
            }  
            formater = new DecimalFormat(buff.toString());  
        }  
        String result = formater.format((double)money/100);  
        return result;  
    } 
    
    /** 
     * 格式化金额         
     * @param money 要格式化的金额,单位:分 
     * @param len 
     * @return 
     */  
    public static String formatMoneyWan(Long money)   
    {  
    	if(money == null){
    		return "";
    	}
        if(money >= 1000000){
        	return formatMoney(money/10000,0);
        }
        if(money >= 10000){
        	return formatMoney(money/10000,2);
        }else{
        	return formatMoney(money/10000,4);
        }
    } 
    /** 
     * 格式化金额         
     * @param money 要格式化的金额,单位:分 
     * @param len 
     * @return 
     */  
    public static String formatMoneyRmb(Long money){
    	return formatMoneyRmb(money,2);
    }
    /** 
     * 格式化金额         
     * @param money 要格式化的金额,单位:分 
     * @param len 
     * @return 
     */  
    public static String formatMoneyRmb(Long money, int len)   
    {  
    	if(money == null){
    		return "0.00";
    	}
        NumberFormat formater = null;  
        if (len == 0) {  
            formater = new DecimalFormat("#");  
        } else {  
            StringBuffer buff = new StringBuffer();  
            buff.append("#.");  
            for (int i = 0; i < len; i++) {  
                buff.append("#");  
            }  
            formater = new DecimalFormat(buff.toString());  
        }  
        if(money.longValue() < 1000000){
          return formater.format((double)money/100);  
        }
        if(money.longValue() < 10000000000l){
            return formater.format((double)money/1000000l) + "万";  
        }
        return formater.format((double)money/10000000000l) + "亿"; 
    }  
	/** 
     * 格式化金额         
     * @param s 
     * @param len 
     * @return 
     */  
    public static String formatMoney(String s, int len)   
    {  
        if (s == null || s.length() < 1) {  
            return "";  
        }  
        NumberFormat formater = null;  
        double num = Double.parseDouble(s);  
        if (len == 0) {  
            formater = new DecimalFormat("###,###");  
  
        } else {  
            StringBuffer buff = new StringBuffer();  
            buff.append("###,###.");  
            for (int i = 0; i < len; i++) {  
                buff.append("#");  
            }  
            formater = new DecimalFormat(buff.toString());  
        }  
        String result = formater.format(num);  
        return result;  
    }  
    
    /**
     * 计算两个日期的时间差
     * @param from 开始时间
     * @param to 结束时间
     * @return
     */
    public static String dateTimeDiff(Date from ,Date to){
    	String result = null;
		long t = (to.getTime() - from.getTime()) / 1000;
		if (t >= 86400) {
			result = t / 86400 + "天";
			t = t % 86400;
			result += t / 3600 + "小时" + t % 3600 / 60 + "分";

		} else if (t >= 3600) {
			result = t / 3600 + "小时";
			t = t % 3600;
			result += t / 60 + "分" + t % 60 + "秒";
		} else if (t >= 60) {
			result = t / 60 + "分" + t % 60 + "秒";
		}else {
			result = t + "秒";
		}
		return result ;
    }
    
    public static Integer dateDiff(String from ,String to){
    	Date dateFrom = strToDate(from,"yyyyMMdd");
    	Date dateTo = strToDate(to,"yyyyMMdd");
    	return new Long(((dateFrom.getTime()-dateTo.getTime()+1000000)/(3600*24*1000))).intValue();
    }
    
    /**
     * 将天数转化为月年
     * @param day
     * @return
     */
    public static String dayformat(int day){
    	String result = null;
    	if(day < 30){
    		result =  day + "天";
    	}else {
    		int month = day/30;
    		day = day%30;
    		if(day > 7 && day <= 22){
    			result = String.valueOf(month) + ".5个月";
    		}else if(day > 22){
    			result = String.valueOf(month+1) + "个月";
    		}else{
    			result = String.valueOf(month) + "个月";
    		}
    	}
		return result ;
    }
    
    public static String dayToMonth(Integer day){
    	String result = null;
    	if( day <= 22){
    		result =  "0.5" ;
    	}else {
    		int month = day/30;
    		day = day%30;
    		if(day > 7 && day <= 22 ){
    			result = String.valueOf(month) + ".5";
    		}else if(day > 22){
    			result = String.valueOf(month+1);
    		}else{
    			result = String.valueOf(month);
    		}
    	}
		return result ;
    }
    /**
     * 将时间转化字符串
     */
    public static String dateTimeToString(Date dt){
    	return dateToString(dt,"yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 将日期转化为字符串,格式为yyyy-MM-dd
     * @param dt 目标日期
     * @return
     */
    public static String dateToString(Date dt){
    	return dateToString(dt,null);
    }
    /**
     * 将日期转化为字符串
     * @param dt 目标日期
     * @param format 转化结果,默认为yyyy-MM-dd
     * @return
     */
    public static String dateToString(Date dt,String format){
    	if(dt == null){
    		return "";
    	}
    	if(format == null){
    		format = "yyyy-MM-dd";
    	}
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(dt);
    }
    
    /**
     * 将分转化为元
     * @return
     */
    public static String fenToYuan(long money){
    	DecimalFormat formater = new DecimalFormat("#.##");  
    	return formater.format((double)money/100);
    }
    /**
     * 获取指定秒数的时间
     * @param second
     * @return
     */
    public static Date getRecentTime(Integer second) {
    	Calendar ca = Calendar.getInstance();
    	ca.add(Calendar.SECOND, -1*second);
		return ca.getTime();
	}
    
    /**
     * 获取指定秒数的时间
     * @param second
     * @return
     */
    public static String hiddenUserName(String userName) {
    	if(userName == null || userName.length() < 4){
    		return "";
    	}
		return userName.substring(0,2) + "****" + userName.substring(userName.length()-2);
	}
    
	/**
	 * 手机号验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) { 
		Pattern p = null;
		Matcher m = null;
		boolean b = false; 
		p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches(); 
		return b;
	}
	/**
	 * 电话号码验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isPhone(String str) { 
		Pattern p1 = null,p2 = null;
		Matcher m = null;
		boolean b = false;  
		p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的
		p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的
		if(str.length() >9)
		{	m = p1.matcher(str);
 		    b = m.matches();  
		}else{
			m = p2.matcher(str);
 			b = m.matches(); 
		}  
		return b;
	}
	/**
	 * 手机或者电话号码验证
	 * 
	 * @param  str
	 * @return 验证通过返回true
	 */
	public static boolean isMobileOrPhone(String str){
		return isPhone(str) || isMobile(str);
	}
	
	/**
	 * 将yyyyMMdd的日期格式转化为yyyy-MM-dd
	 * @param dateStr
	 * @return
	 */
	public static String formatDate(String dateStr){
		if(dateStr != null && dateStr.length() == 8){
			dateStr = dateStr.substring(0,4) + "-" + dateStr.substring(4,6) + "-" + dateStr.substring(6);
		}
		return dateStr;
	}
	/**
	 * 将yyyyMMdd的日期格式转化为yyyy-MM-dd
	 * @param numerator 分子
	 * @param denominator 分母
	 * @return
	 */
	public static String formatPercent(long numerator ,long denominator){
		float num= (float)numerator/denominator;  
    	DecimalFormat df = new DecimalFormat("#.##%");//格式化小数  
    	String result = df.format(num);
    	if(result.equals("100%") && numerator < denominator ){
    		result = "99.99%";
    	}
    	return result;
	}
	/**
	 * 将yyyyMMdd的日期格式转化为yyyy-MM-dd
	 * @param numerator 分子
	 * @param denominator 分母
	 * @return
	 */
	public static String formatPercentNum(long numerator ,long denominator){
		float num= (float)numerator*100/denominator;  
    	DecimalFormat df = new DecimalFormat("#.##");//格式化小数  
    	String result = df.format(num);
    	if(result.equals("100") && numerator < denominator ){
    		result = "99.99";
    	}
    	return result;
	}
	
	/** 
     * 格式化利率       
     * @param money 要格式化的利率,单位:分万之一 
     * @param len 
     * @return 
     */  
    public static String formatRate(Long rate)   
    {  
        NumberFormat formater = null;  
        formater = new DecimalFormat("##.##");  
        String result = formater.format((double)rate/100);  
        return result;  
    }  
    
    public static Boolean equals(Object obj1,Object obj2){
		if(obj1 == null && obj2 != null){
			return false;
		}
		if(obj1 != null && obj2 == null){
			return false;
		}
		if(obj1 == null && obj2 == null){
			return true;
		}
		if (obj1.getClass() != obj2.getClass())
			return false;
		else if (String.class.isInstance(obj1)) {
			return equals((String) obj1, (String) obj2);
		} else
			return obj1.equals(obj2);
	}
    
    public static int getIntervalDays(Date fDate, Date oDate) {

        if (null == fDate || null == oDate) {

            return -1;

        }

        long intervalMilli = oDate.getTime()-fDate.getTime();

        return (int) (intervalMilli / (24 * 60 * 60 * 1000));

     }
    
    public static int daysOfTwo(Date fDate, Date oDate) {

        Calendar aCalendar = Calendar.getInstance();

        aCalendar.setTime(fDate);

        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);

        aCalendar.setTime(oDate);

        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);

        return day2-day1;
     }
    
    /** 
     * 获得距离特定日期特定天数的日期 
     * @param date  给定的日期 
     * @param days  差距天数 
     * @param format  日期格式化 
     * @return 
     */  
    public static String getAddDaysDate(String date,int days){  
       return getAddDaysDate(null,date,days);
    }  
    
    /** 
     * 获得距离特定日期特定天数的日期 
     * @param date  给定的日期 
     * @param days  差距天数 
     * @param format  日期格式化 
     * @return 
     */  
    public static String getAddDaysDate(String format,String date,int days){  
        if(StringUtil.isNullStr(format)){  
            format = "yyyyMMdd" ;  
        }  
        SimpleDateFormat sdf = new SimpleDateFormat(format.toString()) ;  
        if(StringUtil.isNullStr(date)){  
            date = sdf.format(new Date()) ;  
        }  
        Calendar calendar = Calendar.getInstance() ;  
        try {  
            calendar.setTime(sdf.parse(date)) ;  
        } catch (java.text.ParseException e) {  
            e.printStackTrace();  
        }  
        calendar.add(calendar.DATE,days) ;  
        return sdf.format(calendar.getTime()) ;  
    }  
    
    public static String subString(String text, int length, String endWith) {        
        int textLength = text.length();  
        int byteLength = 0;  
        StringBuffer returnStr =  new StringBuffer();  
        for(int i = 0; i<textLength && byteLength < length*2; i++){  
            String str_i = text.substring(i, i+1);   
            if(str_i.getBytes().length == 1){//英文  
                byteLength++;  
            }else{//中文  
                byteLength += 2 ;  
            }  
            returnStr.append(str_i);  
        }  
        try {  
            if(byteLength<text.getBytes("GBK").length){//getBytes("GBK")每个汉字长2，getBytes("UTF-8")每个汉字长度为3  
                returnStr.append(endWith);  
            }  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        }  
        return returnStr.toString();  
    }  
    
    public static String hiddenCardId(String cardId) {
		if (cardId != null && cardId.length() >= 15) {
			if(cardId.length() == 18){
				cardId = cardId.substring(0, 3) + "***" + cardId.substring(6, 14) + "**" + cardId.substring(cardId.length() - 2);
			}
			else if(cardId.length() == 15){
				cardId = cardId.substring(0, 3) + "***" + cardId.substring(6, 12) + "**" + cardId.substring(cardId.length() - 1);
			}
		}
		return cardId;
	}
    /**
     * 将2014-02-01 13:22:22格式日期转化为20140201132222日期
     * @param dateStr
     * @return
     */
    public static String shortDateTimeStr(String dateStr){
		if(dateStr != null){
			dateStr = dateStr.replaceAll("-| |:", "");
		}
		return dateStr;
	}
    
    /**
     * 将20140201132222格式日期转化为2014-02-01 13:22:22日期
     * @param dateStr
     * @return
     */
    public static String formatDateTimeStr(String dateStr){
		if(dateStr != null && dateStr.length() == 14){
			dateStr = dateStr.substring(0,4) + "-" + dateStr.substring(4,6)+ "-" + dateStr.substring(6,8) + " " + dateStr.substring(8,10)
				+ ":" + dateStr.substring(10,12) + ":" + dateStr.substring(12,14);
		}
		return dateStr;
	}
    
    public static boolean equalsWithoutStr(String s1,String s2,String replaceStr,String aftStr){
    	String ss1 = s1.replaceAll(replaceStr, aftStr);
    	String ss2 = s2.replaceAll(replaceStr, aftStr);
    	return ss1.equals(ss2);
    }
    
    public static void main(String[] args) {
    	System.out.println(dateDiff("20150216","20141223"));
	}
	
}
