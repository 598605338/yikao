package com.linjia.tools;

/**
 * 日期处理类

 */

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.log4j.Logger;

public final class DateComFunc {

	static Logger logger = Logger.getLogger(DateComFunc.class.getName());
    
	/** 
	 * 获得与date相差day天的日期格式为yyyy-MM-dd HH:mm:ss 
	 * @param date 
	 * @param day 
	 * @return 
	 */
	public static String getDay(Date date, long day, String pattern) {
		try {
			Date t1 = new Date(DateComFunc.strToDate(DateComFunc.formatDate(date, "yyyy-MM-dd"), "yyyy-MM-dd").getTime() + (long)86400000 * day);
			return formatDate(t1, pattern);
		} catch (Exception ex) {

		}
		return "";
	}

	/**
	 * 获得今天之后某天的字符串 ,格式为1970-01-01
	 */
	public static String getDay(int day) {
		try {
			Date t1 = new Date(DateComFunc.strToDate(DateComFunc.formatDate(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd").getTime() + (long)86400000 * day);
			return formatDate(t1, "yyyy-MM-dd");
		} catch (Exception ex) {

		}
		return "";
	}

	/**
	 * turn date into string
	 * 
	 * @param dDate
	 *            Date 日期
	 * @param sFormat
	 *            String Format串
	 * 
	 * @return String
	 */
	public static String formatDate(Date dDate, String sFormat) {
		String tmp = "";
		try {
			if (dDate != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(sFormat);
				String dateString = formatter.format(dDate);
				tmp = dateString;
			} else
				tmp = "";
		} catch (Exception ex) {
			logger.error("Date" + dDate + "to String is error");
		}
		return tmp;
	}

	public static String formatDate(java.sql.Timestamp dDate, String sFormat) {
		String tmp = "";
		try {
			if (dDate != null) {
				SimpleDateFormat formatter = new SimpleDateFormat(sFormat);

				String dateString = formatter.format(convertTimestampDate(dDate));
				tmp = dateString;
			} else
				tmp = "";
		} catch (Exception ex) {
			logger.error("Date" + dDate + "to String is error");
		}
		return tmp;
	}

	/**
	 * turn the string with date format to date
	 * 
	 * @param s String
	 * @param pattern String
	 * @param locale 
	 * @return Date
	 */
	public static Date strToDate(String s, String pattern, Locale locale) {
		if (s == null || s.equals(""))
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern, locale);
		Date date1 = null;
		try {
			Date theDate = formatter.parse(s);
			Date date = theDate;
			return date;
		} catch (Exception ex) {
			logger.error("String " + s + " to data is error", ex);
		}
		return date1;
	}

	/**
	 * turn the string with date format to date
	 * 
	 * @param s
	 *            String
	 * @param pattern
	 *            String
	 * @return Date
	 */
	public static Date strToDate(String s, String pattern) {
		if (s == null || s.equals(""))
			return null;
		SimpleDateFormat formatter = new SimpleDateFormat(pattern);
		Date date1 = null;
		try {
			Date theDate = formatter.parse(s);
			Date date = theDate;
			return date;
		} catch (Exception ex) {
			logger.error("String " + s + " to data is error", ex);
		}
		return date1;
	}

	/**
	 * turn the string with date format to Timestamp
	 * 
	 * @param s
	 *            String
	 * @param pattern
	 *            String
	 * @return Date
	 */
	public static java.sql.Timestamp strToTimestamp(String s, String pattern) {
		if (s == null || s.equals(""))
			return null;
		Date d = strToDate(s, pattern);
		return new java.sql.Timestamp(d.getTime());
	}

	/**
	 * judge if the year is leap year
	 * 
	 * @param year
	 *            int
	 * @return boolean
	 */
	public static boolean isLeap(int year) {

		boolean div4 = year % 4 == 0;
		boolean div100 = year % 100 == 0;
		boolean div400 = year % 400 == 0;
		return div4 && (!div100 || div400);
	}

	/**
	 * get the week number for date
	 * 
	 * @param vDate
	 *            Date
	 * @return int
	 */
	public static int getWeek(Date vDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(vDate);
		int week = cal.get(3);
		return week;

	}

	/**
	 * get the week day for date
	 * 
	 * @param d
	 *            Date
	 * @return int
	 */
	public static int getWeekDay(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		return cal.get(7);
	}

	/**
	 * get the TimeZOne of server
	 * 
	 * @return String
	 */
	public static String getServerTimeZone() {

		Calendar cal = Calendar.getInstance();
		TimeZone tz = cal.getTimeZone();
		return tz.getID();

	}

	/**
	 * get the date with normal format
	 * 
	 * @param year
	 *            int
	 * @param month
	 *            int
	 * @param date
	 *            int
	 * @return Date
	 */
	public static Date getDate(int year, int month, int date) {
		Calendar cal = Calendar.getInstance();
		cal.set(year, month, date);
		return new Date(cal.getTime().getTime());
	}

	/**
	 * get the diffrence between two date
	 * 
	 * @param date1
	 *            Date
	 * @param date2
	 *            Date
	 * @return long
	 */
	public static long dateDiff(Date date1, Date date2) {
		long date1ms = date1.getTime();
		long date2ms = date2.getTime();
		return date2ms - date1ms;
	}

	public static long dateDiff(java.sql.Timestamp date1, java.sql.Timestamp date2) {
		long date1ms = date1.getTime();
		long date2ms = date2.getTime();
		return date2ms - date1ms;
	}
	
	/**
	 * get the year for now
	 * 
	 * @return int
	 */
	public static int getYear() {
		Calendar Cal = Calendar.getInstance();
		return Cal.get(Calendar.YEAR);
	}

	/**
	 * get the year for input date
	 * 
	 * @param inputDate
	 *            Date
	 * @return int
	 */
	public static int getYear(Date inputDate) {
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(inputDate);

		return Cal.get(Calendar.YEAR);
	}

	/**
	 * get the month for now
	 * 
	 * @return int
	 */
	public static int getMonth() {
		Calendar Cal = Calendar.getInstance();
		return (Cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * get the month for input date
	 * 
	 * @param inputDate
	 *            Date
	 * @return int
	 */
	public static int getMonth(Date inputDate) {
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(inputDate);
		return (Cal.get(Calendar.MONTH) + 1);
	}

	/**
	 * get the day for now
	 * 
	 * @return int
	 */
	public static int getDay() {
		Calendar Cal = Calendar.getInstance();
		return Cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * get the day for input Date
	 * 
	 * @param inputDate
	 *            Date
	 * @return int
	 */
	public static int getDay(Date inputDate) {
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(inputDate);
		return Cal.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * get the hour for now
	 * 
	 * @return int
	 */
	public static int getHour() {
		Calendar Cal = Calendar.getInstance();
		return Cal.get(Calendar.HOUR_OF_DAY);
	}

	public static int getHour(Date inputDate) {
		if (inputDate == null)
			return 0;
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(inputDate);
		return Cal.get(Calendar.HOUR_OF_DAY);
	}

	public static Date getHourDate(Date inputDate) {
		if (inputDate == null)
			return null;
		Calendar calIn = Calendar.getInstance();
        calIn.setTime(inputDate);

		Calendar cal = Calendar.getInstance();
		cal.set(calIn.get(Calendar.YEAR), calIn.get(Calendar.MONTH), calIn.get(Calendar.DATE), 
                calIn.get(Calendar.HOUR_OF_DAY), 0, 0);
		return new Date(cal.getTime().getTime());
	}
	
	/**
	 * 获取指定小时的时间
	 * 
	 * @return Date
	 */
	public static Date getSpecifyHourDate(Date inputDate, int hour) {
		if (inputDate == null)
			return null;
		Calendar calIn = Calendar.getInstance();
		calIn.setTime(inputDate);
		
		Calendar cal = Calendar.getInstance();
		cal.set(calIn.get(Calendar.YEAR), calIn.get(Calendar.MONTH), calIn.get(Calendar.DATE), 
				hour, 0, 0);
		
		//将毫秒值设置成0
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * turn today to long format with yymmdd
	 * 
	 * @return long
	 */
	public static long to6DigNumber() {
		Calendar Cal = Calendar.getInstance();
		long result = 0L;
		result = getYear() % 100 * 10000L + getMonth() * 100L + getDay();
		return result;

	}

	/**
	 * turn tinput date to long format with yymmdd
	 * 
	 * @param inputDate
	 *            Date
	 * @return long
	 */
	public static long to6DigNumber(Date inputDate) {
		Calendar Cal = Calendar.getInstance();
		Cal.setTime(inputDate);
		long result = 0L;
		result = getYear() % 100 * 10000L + getMonth() * 100L + getDay();
		return result;

	}

	// ====================Adjust a date=============================================

	/**
	 * add many hour to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbHour
	 *            long
	 * @return Date
	 */
	public static Date addHour(Date dDate, long iNbHour) {

		long datems = dDate.getTime();
		long hourMs = iNbHour * (long) 60 * (long) 60 * (long) 1000;
		long newDateMs = datems + hourMs;
		Date result = new Date(newDateMs);
		return result;

	}

	/**
	 * add many minute to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbMinute
	 *            long
	 * @return Date
	 */
	public static Date addMinute(Date dDate, long iNbMinute) {

		long datems = dDate.getTime();
		long minuteMs = iNbMinute * (long) 60 * (long) 1000;
		long newDateMs = datems + minuteMs;
		Date result = new Date(newDateMs);
		return result;

	}

	/**
	 * add many month to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbMonth
	 *            int
	 * @return Date
	 */
	public static Date addMonth(Date dDate, int iNbMonth) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(dDate);
		int month = cal.get(2);
		month += iNbMonth;
		int year = month / 12;
		month %= 12;
		cal.set(2, month);
		if (year != 0) {
			int oldYear = cal.get(1);
			cal.set(1, year + oldYear);
		}
		return cal.getTime();
	}

	/**
	 * add many day to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbDay
	 *            long
	 * @return Date
	 */
	public static Date addDay(Date dDate, long iNbDay) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dDate);
		cal.add(5, (int) iNbDay);
		Date result = cal.getTime();
		return result;

	}

	/**
	 * add many second to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbSecond
	 *            long
	 * @return Date
	 */
	public static Date addSecond(Date dDate, long iNbSecond) {

		long datems = dDate.getTime();
		long secondms = iNbSecond * (long) 1000;
		long newDateMs = datems + secondms;
		Date result = new Date(newDateMs);
		return result;

	}

	/**
	 * add many year to a date varible
	 * 
	 * @param dDate
	 *            Date
	 * @param iNbYear
	 *            int
	 * @return Date
	 */
	public static Date addYear(Date dDate, int iNbYear) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dDate);
		int oldYear = cal.get(1);
		cal.set(1, iNbYear + oldYear);
		return cal.getTime();

	}

	/**
	 * Converts java.util.Date to java.sql.Date.
	 * 
	 * @param date
	 *            Date java.util.Date that wanted be converted.
	 * @return Date that has been converted.
	 */
	public static java.sql.Date converlUtilDate(Date date) {
		if (date == null)
			return null;
		java.sql.Date sqlDate = null;
		sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}

	public static java.sql.Timestamp converlUtilTimestamp(Date date) {
		if (date == null)
			return null;
		java.sql.Timestamp sqlDate = null;
		sqlDate = new java.sql.Timestamp(date.getTime());
		return sqlDate;
	}

	/**
	 * Converts java.sql.Date to java.util.Date.
	 * 
	 * @param date
	 *            java.sql.Date that wanted be converted.
	 * @return java.util.Date that has been converted.
	 */
	public static Date convertSqlDate(java.sql.Date date) {
		if (date == null)
			return null;
		Date utilDate = null;
		utilDate = new Date(date.getTime());
		return utilDate;
	}

	public static Date convertTimestampDate(java.sql.Timestamp date) {
		if (date == null)
			return null;
		Date utilDate = null;
		utilDate = new Date(date.getTime());
		return utilDate;
	}

	/**
	 * turn date into string
	 * 
	 * @param dt
	 *            Date
	 * @param format
	 *            String
	 * @return String
	 */
	public static String getDateFormat(Date dt, String format) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
		String ret = sdf.format(cal.getTime());
		return ret;
	}

	/**
	 * 取系统时间
	 * 
	 * @return Date
	 */
	public static Date getSysDay() {
		Calendar Cal = Calendar.getInstance();
		return Cal.getTime();
	}

	public static String dateDiffStr(Date date1, Date date2) throws Exception {
		String result = "";
		long date1ms = date1.getTime();
		long date2ms = date2.getTime();
		long ms = date2ms - date1ms;
		return getTimes(ms / 1000);
	}

	public static String getTimes(long second) throws Exception {
		if (second == 0) {
			return "";
		}
		String result = "";
		long h = second / 3600;
		long m = (second - h * 3600) / 60;
		long s = second - h * 3600 - m * 60;
		result = StringUtils.addLeftChar(String.valueOf(h), 2, "0") + ":" + StringUtils.addLeftChar(String.valueOf(m), 2, "0") + ":"
				+ StringUtils.addLeftChar(String.valueOf(s), 2, "0");
		return result;
	}

	public static String getTimes(int second) throws Exception {
		if (second == 0) {
			return "";
		}
		String result = "";
		long h = second / 3600;
		long m = (second - h * 3600) / 60;
		long s = second - h * 3600 - m * 60;
		result = StringUtils.addLeftChar(String.valueOf(h), 2, "0") + ":" + StringUtils.addLeftChar(String.valueOf(m), 2, "0") + ":"
				+ StringUtils.addLeftChar(String.valueOf(s), 2, "0");
		return result;
	}

	public static String getTimes(BigDecimal obj) throws Exception {
		if (obj == null)
			return "";
		long second = obj.longValue();
		return getTimes(second);
	}

	public static String getTimes(String obj) throws Exception {
		if (obj == null || obj.equals(""))
			return "";
		long second = (new Long(obj)).longValue();
		return getTimes(second);
	}

	public static String getTimes(Long obj) throws Exception {
		if (obj == null)
			return "";
		long second = obj.longValue();
		return getTimes(second);
	}

	public static String getTimes(Integer obj) throws Exception {
		if (obj == null)
			return "";
		long second = obj.longValue();
		return getTimes(second);
	}

	// public static int getAgeByBirthday(Date birthday) {
	// Date d = new Date();
	// if (birthday == null) {
	// return 0;
	// }
	// int intResult = 0;
	// intResult = d.getYear() - birthday.getYear();
	// return intResult;
	// }

	public static Date toCDT(String ts, String format) {
		if (ts == null || ts.trim().equals("")) {
			return null;
		}
		Date date = null;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			date = sdf.parse(ts);
		} catch (ParseException ex) {
		}
		return date;
	}
	
	//计算两个date1与date2之间相差的时间,以字符串输出
	public static String diffTime(Date date1, Date date2) {
		long nd = 1000*24*60*60;//一天的毫秒数
		long nh = 1000*60*60;//一小时的毫秒数
		long nm = 1000*60;//一分钟的毫秒数
		long ns = 1000;//一秒钟的毫秒数
		long date1ms = date1.getTime();
		long date2ms = date2.getTime();
		long diff=date1ms-date2ms;
		long day = diff/nd;//计算差多少天
		long hour = diff%nd/nh;//计算差多少小时
		long min = diff%nd%nh/nm;//计算差多少分钟
		long sec = diff%nd%nh%nm/ns;//计算差多少秒
//		输出结果
		String diffTime=day+"天"+hour+":"+min+":"+sec;
		return diffTime;
	}
	
	/**
	 * 比较两个时间的大小
	 * 
	 * @return 
	 * -1(d1小于d2); 0(d1等于d2); 1(d1大于d2) 
	 */
	public static int compareDate(Date d1,Date d2) {
		int r = 0;
		long t1 = d1.getTime(); 
		long t2 = d2.getTime(); 
		if(t1 < t2){
			r = -1;
		}else if(t1 > t2){
			r = 1;
		}
		return r;
	}

	/**
	 * 时间戳转日期
	 * 
	 * @return 
	 */
	public static Date timestampToDate(Long time) {
		Date date = null;
		if(time==null){
			return date;
		}
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sd = sdf.format(new Date(time));
			date=sdf.parse(sd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
