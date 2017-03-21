/* ====================================================================
 * 
 * <http://www.topsuntech.org/>.
 */
package com.linjia.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.CopyUtils;

/**
 * 常用的工具类
 * 
 * <p>
 * <a href="Tools.java.html">View Source</a>
 * </p>
 * 
 * @see com.topsuntech.gUnit.gEU_util.tools.Tools
 * @author <a href="mailto:yangqingxiang@topsuntech.com">YangQingXiang</a>
 * @since 1.0
 * @version $Id: Tools.java,v 1.2 2009/11/18 06:18:48 yaojianwei Exp $Revision:
 *          1.2 $
 * 
 */
public class Tools {

	public static final String DEFAULT_PATTERN = "yyyy-MM-dd";

	public static final String NUMBER_PATTERN = "0.00";

	/**
	 * 数字对应的汉字
	 */
	private static final String[] chinese = { "〇", "一", "二", "三", "四", "五",
			"六", "七", "八", "九", "十", "十一", "十二", "十三", "十四", "十五", "十六", "十七",
			"十八", "十九", "二十", "二十一", "二十二", "二十三", "二十四", "二十五", "二十六", "二十七",
			"二十八", "二十九", "三十", "三十一" };

	/**
	 * 整体转换模式
	 */
	public static final int WHOLE = 1;

	/**
	 * 单独转换模式
	 */
	public static final int SEPARATE = 2;

	/**
	 * 得到系统时间的String类型
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getSysteDateStr(String pattern) {
		return getDateStr(null, pattern);
	}

	/**
	 * 将DATE类型转成String类型,pattern默认为yyyy-MM-dd
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateStr(Date date, String pattern) {
		if (date == null)
			date = new Date();
		if (pattern == null)
			pattern = DEFAULT_PATTERN;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.format(date);
	}

	public static Date getDateByStr(String dateStr, String pattern)
			throws ParseException {
		if (dateStr == null || dateStr.equals(""))
			return new Date();
		if (pattern == null)
			pattern = DEFAULT_PATTERN;
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.parse(dateStr);
	}

	/**
	 * 把字符串转化成日期类型，如果字符串为空或者不是日期格式，则返回NULL
	 * 
	 * @param dateStr
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return Date
	 * @throws ParseException
	 */
	//	
	public static Date str2Date(String dateStr, String pattern)
			throws ParseException {
		Date date = null;
		if (isEmpty(dateStr))
			return date;
		try {
			// pattern为空，侧为一个常量
			if (isEmpty(pattern))
				pattern = DEFAULT_PATTERN;
			// SimpleDateFormat 允许以为日期-时间格式化选择任何用户指定的方式启动的具体类
			SimpleDateFormat formater = new SimpleDateFormat(pattern);
			date = formater.parse(dateStr);
		} catch (Exception e) {
			// Logger.warn("把“" + dateStr + "”从字符串转成Date型失败！");
		}
		return date;
	}

	/**
	 * 功能描述：判断对象是否为空或空串，如果为空则返回“true”，不为空返回“false”<br>
	 * 
	 * @param object
	 *            要判断的对象
	 * @return boolean
	 */
	public static boolean isEmpty(String object) {
		// 如果为空或空字符串
		if (object == null || object.trim().length() == 0)
			return true;
		return false;
	}

	/**
	 * 功能描述：判断对象是否为空或空串，如果为空则返回“true”，不为空返回“false”<br>
	 * 
	 * @param object
	 *            要判断的对象
	 * @return boolean
	 */
	public static boolean isEmpty(Number object) {
		// 如果为空或空字符串
		if (object == null || object.toString().length() == 0)
			return true;
		return false;
	}

	/**
	 * 判断对象是否为空或0，如果为空则返回“true”，不为空返回“false”<br>
	 * 
	 * @param object
	 *            要判断的对象
	 * @return boolean
	 */
	public static boolean isEmptyId(Number object) {
		if (object == null || object.longValue() <= 0)
			return true;
		return false;
	}

	/**
	 * 功能描述：判断对象是否为空或空串，如果为空则返回“true”，不为空返回“false”<br>
	 * 
	 * @param object
	 *            要判断的对象
	 * @return boolean
	 */
	public static boolean isEmpty(Collection object) {
		// 如果为NULL或级数大小为0
		if (object == null || object.size() == 0)
			return true;
		return false;
	}

	/**
	 * 取得分隔后值
	 * 
	 * @param string
	 *            值
	 * @param flag
	 *            标记
	 * @return String[] 值数组
	 */
	public static String[] stringToKenizer(String string, String flag) {
		StringTokenizer token = new StringTokenizer(string, flag);
		int len = token.countTokens();
		String[] result = new String[len];
		for (int k = 0; k < len; k++) {
			result[k] = token.nextToken();
		}
		return result;
	}

	/**
	 * 判断当前数组中，是否存在某对象值
	 * 
	 * @param array
	 *            数组
	 * @param value
	 *            对象值
	 * @return boolean 存在为TRUE，否则为FALSE
	 */
	public static boolean judgeExist(String[] array, String value) {
		boolean bExist = false;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals(value)) {
				bExist = true;
				break;
			}
		}
		return bExist;
	}

	/**
	 * 得到指定天数后的日期,如果时间为空,则返回当前系统时间后指定天数的日期
	 * 
	 * @param ori
	 * @param dayNum
	 * @return
	 */
	public static Date addDays(Date ori, Long dayNum) {
		ori = ori == null ? new Date() : ori;
		return new Date(ori.getTime() + TIME_OF_ONE_DAY * (dayNum.longValue()));
	}

	public static Date aa(Date ori, int monthNum) {
		Long dayNum = new Long(0);
		while (monthNum != 0) {
			if (ori.getMonth() == 2) {
				if (ori.getYear() % 4 == 0 || ori.getYear() % 400 == 0) {//闰年
					dayNum+=29;
				}else{
					dayNum+=28;
				}
			} else if (ori.getMonth() == 1 || ori.getMonth() == 3
					 || ori.getMonth() == 5
					|| ori.getMonth() == 7 || ori.getMonth() == 8
					|| ori.getMonth() == 10 || ori.getMonth() == 12) {
				dayNum+=31;
			} else {
				dayNum+=30;
			}
			--monthNum;
		}
		return subDays(ori, dayNum);
	}

	public static Date subDays(Date ori, Long dayNum) {
		ori = ori == null ? new Date() : ori;
		return new Date(ori.getTime() - TIME_OF_ONE_DAY * (dayNum.longValue()));
	}

	public static long getDaysBetweenTwoDate(Date start, Date end) {
		return ((end.getTime() - start.getTime()) / TIME_OF_ONE_DAY);
	}

	/**
	 * 一天的毫秒数
	 */
	public static long TIME_OF_ONE_DAY = 24 * 60 * 60 * 1000;

	/**
	 * 取得一个全由数字组成的随机字符串
	 * 
	 * @return String
	 */
	public static String getRandomStrNum() {
		String now = getSysteDateStr("yyyyMMddHHmmss");
		int random = (int) (Math.random() * 1000);
		return now + random;
	}

	/**
	 * 把文件保存到硬盘上<br>
	 * 如果指定路径不存在，则会自动创建路径<br>
	 * 如果文件存在，则会覆盖原来的文件<br>
	 * 
	 * @param input
	 *            InputStream
	 * @param path
	 *            保存路径
	 * @param fileName
	 *            文件名称
	 * @throws IOException
	 */
	public static void saveFileToDisk(InputStream input, String path,
			String fileName) throws IOException {
		File file = new File(path);
		if (!file.isDirectory())
			file.mkdirs();
		OutputStream output = new FileOutputStream(path + fileName);
		CopyUtils.copy(input, output);
		output.close();
		input.close();
	}

	/**
	 * 把字符串转成Long
	 * 
	 * @param val
	 * @return Long
	 */
	public static Long str2Long(String val) {
		Long value = null;
		try {
			value = Long.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Long型失败！");
		}
		return value;
	}

	/**
	 * 把字符串转成Double
	 * 
	 * @param val
	 * @return Double
	 */
	public static Double str2Double(String val) {
		Double value = null;
		try {
			value = Double.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Long型失败！");
		}
		return value;
	}

	/**
	 * 把对象转成String
	 * 
	 * @param val
	 * @return String
	 */
	public static String obj2Str(Object val) {
		String value = null;
		try {
			value = val.toString();
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从对象转成String型失败！");
		}
		return value;
	}

	/**
	 * 把字符串转成Integer
	 * 
	 * @param val
	 * @return Integer
	 */
	public static Integer str2Integer(String val) {
		Integer value = null;
		try {
			value = Integer.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Integer型失败！");
		}
		return value;
	}

	/**
	 * 把字符串转成Short
	 * 
	 * @param val
	 * @return Short
	 */
	public static Short str2Short(String val) {
		Short value = null;
		try {
			value = Short.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Long型失败！");
		}
		return value;
	}

	/**
	 * 把字符串转成Float
	 * 
	 * @param val
	 * @return Float
	 */
	public static Float str2Float(String val) {
		Float value = null;
		try {
			value = Float.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Long型失败！");
		}
		return value;
	}

	/**
	 * 把字符串转成Byte
	 * 
	 * @param val
	 * @return Byte
	 */
	public static Byte str2Byte(String val) {
		Byte value = null;
		try {
			value = Byte.valueOf(val);
		} catch (Exception e) {
			// Logger.warn("把“" + val + "”从字符串转成Long型失败！");
		}
		return value;
	}

	/**
	 * 對Double类型四舍五入
	 * 
	 * @param value
	 * @param num
	 *            保留几位小数
	 * @return
	 */
	public static Double rounding(Double value, int num) {
		double temp = Math.pow(10, num);
		if (value != null) {
			return new Double((Math.round(temp * value.doubleValue())) / temp);
		}
		return null;
	}

	public static double discard(double value, int num) {
		String r = Double.toString(value);
		int p = -1;
		if ((p = r.indexOf(".")) != -1 && r.length() > p + num + 1) {
			r = r.substring(0, p + num + 1);
		}
		return Double.parseDouble(r);
	}

	public static void main(String[] args) {
	}

	/**
	 * 取年份
	 * 
	 * @param date
	 * @return int
	 */
	public static int getYear(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 * 取月份
	 * 
	 * @param date
	 * @return int
	 */
	public static int getMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 取日
	 * 
	 * @param date
	 * @return int
	 */
	public static int getDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 格式化数值
	 * 
	 * @param number
	 *            数值
	 * @param pattern
	 *            格式
	 * @return String
	 */
	public static String formatNumber(Number number, String pattern) {

		if (number == null)
			return null;

		// 判断格式是否为空
		if (isEmpty(pattern)) {
			pattern = NUMBER_PATTERN;
		}

		// 格式化数字
		DecimalFormat formater = new DecimalFormat(pattern);
		return formater.format(number);
	}

	/**
	 * 格式化查询SQL字段值
	 * 
	 * @param fieldValue
	 *            字段值
	 * @return String 返回值
	 */
	public static String formatSQLValue(String fieldValue) {
		if (isEmpty(fieldValue))
			return fieldValue;
		return fieldValue.replaceAll("'", "''");
	}

	/**
	 * 根据正则表达式替换字符串 如果字符串或正则表达式为空，则不做替换 如果要替换成的字符串为NULL，则转成空字符串
	 * 
	 * @param string
	 *            字符串
	 * @param regEx
	 *            正则表达式
	 * @param substr
	 *            要替换成的字符串
	 * @param caseFlg
	 *            是否区分大小写
	 * @return String 结果
	 */
	public static String replaceAllByExp(String string, String regEx,
			String substr, boolean caseFlg) {

		// 如果字符串或正则表达式为空，则不做替换
		if (Tools.isEmpty(string) || Tools.isEmpty(regEx)) {
			return string;
		}

		// 如果要替换成的字符串为NULL，则转成空字符串
		if (Tools.isEmpty(substr)) {
			substr = "";
		}

		Pattern pattern = null;
		if (caseFlg) {
			pattern = Pattern.compile(regEx);
		} else {
			// 设置成不区分大小写
			pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		}

		// 用表达式来匹配字符串
		Matcher matcher = pattern.matcher(string);

		// 执行全部替换
		return matcher.replaceAll(substr);
	}

	/**
	 * 把阿拉伯数字转换成中文数字
	 * 
	 * @param number
	 *            数字字符串
	 * @param mode
	 *            转换模式
	 * @return String
	 */
	public static String number2Chinese(String number, int mode) {
		int index = Integer.parseInt(number);
		if (mode == WHOLE && index < chinese.length) {
			return chinese[index];
		} else if (mode == SEPARATE) {
			StringBuffer sbNum = new StringBuffer();
			for (int i = 0; i < number.length(); i++) {
				index = Integer.parseInt(String.valueOf(number.charAt(i)));
				sbNum.append(chinese[index]);
			}
			return sbNum.toString();
		}
		return null;
	}

	/**
	 * 转换日期为汉字格式日期
	 * 
	 * @param yearFrom
	 *            开始年份
	 * @param monthFrom
	 *            开始月份
	 * @param yearTo
	 *            结束年份
	 * @param monthTo
	 *            结束月分
	 * @return String 日期字符串
	 */
	public static String toChineseDate(String yearFrom, String monthFrom,
			String yearTo, String monthTo) {

		int yearF = Integer.parseInt(yearFrom);
		int monthF = Integer.parseInt(monthFrom);
		int yearT = Integer.parseInt(yearTo);
		int monthT = Integer.parseInt(monthTo);
		StringBuffer sbDate = new StringBuffer();

		if (yearF == yearT) {
			sbDate.append(number2Chinese(yearFrom, SEPARATE)).append("年");
			if (monthF == 1 && monthT == 3) {
				sbDate.append("第一季度");
			} else if (monthF == 4 && monthT == 6) {
				sbDate.append("第二季度");
			} else if (monthF == 7 && monthT == 9) {
				sbDate.append("第三季度");
			} else if (monthF == 10 && monthT == 12) {
				sbDate.append("第四季度");
			} else if (monthF == 1 && monthT == 6) {
				sbDate.append("上半年");
			} else if (monthF == 7 && monthT == 12) {
				sbDate.append("下半年");
			} else if (monthF == 1 && monthT == 12) {
				sbDate.append("度");
			} else if (monthF == monthT) {
				sbDate.append(number2Chinese(monthFrom, WHOLE)).append("月");
			} else {
				sbDate.append(number2Chinese(monthFrom, WHOLE)).append("月至");
				sbDate.append(number2Chinese(monthTo, WHOLE)).append("月");
			}
		} else {
			sbDate.append(number2Chinese(yearFrom, SEPARATE)).append("年");
			sbDate.append(number2Chinese(monthFrom, WHOLE)).append("月至");
			sbDate.append(number2Chinese(yearTo, SEPARATE)).append("年");
			sbDate.append(number2Chinese(monthTo, WHOLE)).append("月");
		}
		return sbDate.toString();
	}

	public static Double subDouble(Double d, int index) {
		if (d != null) {
			String tmp = d.toString();
			int pointIndex = tmp.indexOf(".");
			if (tmp.substring(pointIndex).length() > index) {
				return new Double(tmp.substring(0, pointIndex + index + 1));
			} else {
				return d;
			}
		}
		return null;
	}

	public static String formatDateComparer(String property) {
		return "to_char(" + property + ",'yyyy-MM-dd')";
	}

	/**
	 * 对字符串，进行后处理
	 * 
	 * @param strs
	 *            字符串
	 * @param character
	 *            符号: ',' ，'|'等
	 * @return 去除前后的符号
	 */
	public static String afterString(String strs, String character) {
		if (strs.substring(0, 1).equals(character))
			strs = strs.substring(1, strs.length());
		if (strs.substring(strs.length() - 1, strs.length()).equals(character))
			strs = strs.substring(0, strs.length() - 1);

		return strs;
	}

	/**
	 * 从结果集构建VO
	 * 
	 * @param rs
	 * @param visualObject
	 * @throws SQLException
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public static void buildVisualObjectFromResultSet(ResultSet rs,
			Object visualObject) throws SQLException, SQLException,
			InvocationTargetException, IllegalAccessException {
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 1; i <= metaData.getColumnCount(); i++) {
			buildVisualObject(visualObject, rs, metaData.getColumnName(i),
					metaData.getColumnTypeName(i));
		}
	}

	/**
	 * 构建实例对象
	 * 
	 * @param visualObject
	 * @param rs
	 * @param columnName
	 * @param columnTypeName
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private static void buildVisualObject(Object visualObject, ResultSet rs,
			String columnName, String columnTypeName) throws SQLException,
			InvocationTargetException, IllegalAccessException {
		if (visualObject == null)
			return;
		if (columnName == null || "".equals(columnName.trim()))
			return;

		// 根据reflect开始构建vo
		setProperty(visualObject, rs, columnName, columnTypeName);
	}

	/**
	 * 设置属性
	 * 
	 * @param visualObject
	 * @param rs
	 * @param columnName
	 * @param columnTypeName
	 * @throws SQLException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	private static void setProperty(Object visualObject, ResultSet rs,
			String columnName, String columnTypeName) throws SQLException,
			InvocationTargetException, IllegalAccessException {
		Class<?> cls = visualObject.getClass();
		String setPropertyNameMethod = setPropertyNameMethod(columnName);
		Method method = getMethodByName(cls, setPropertyNameMethod);
		// 如果vo中含有set方法，则继续执行
		if (method != null) {
			// 获取参数类型名
			String parameterType = method.getParameterTypes()[0]
					.getSimpleName();

			// 数字型
			if ("NUMBER".equalsIgnoreCase(columnTypeName)) {
				if ("Long".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Long(rs
								.getLong(columnName)) });
				}

				if ("Short".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Short(rs
								.getShort(columnName)) });
				}

				if ("Double".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Double(
								rs.getDouble(columnName)) });
				}

				if ("Float".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Double(
								rs.getFloat(columnName)) });
				}

				if ("Byte".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { new Byte(rs
								.getByte(columnName)) });
				}

				if ("Boolean".equals(parameterType)) {
					if (rs.getObject(columnName) != null) {
						if (new Integer(rs.getInt(columnName)).intValue() > 0)
							method.invoke(visualObject,
									new Object[] { new Boolean(true) });
						else
							method.invoke(visualObject,
									new Object[] { new Boolean(false) });
					}
				}
			}

			// 字符型
			if ("VARCHAR2".equalsIgnoreCase(columnTypeName)) {
				if ("String".equals(parameterType)) {
					if (rs.getString(columnName) != null)
						method.invoke(visualObject, new Object[] { rs
								.getString(columnName) });
				}

				if ("Boolean".equals(parameterType)) {
					if (rs.getString(columnName) != null
							&& !"".equals(rs.getString(columnName).trim())) {
						if ("true".equalsIgnoreCase(rs.getString(columnName)))
							method.invoke(visualObject,
									new Object[] { new Boolean(true) });
						else if ("false".equalsIgnoreCase(rs
								.getString(columnName)))
							method.invoke(visualObject,
									new Object[] { new Boolean(false) });
					}
				}
			}

			// 日期型
			if ("DATE".equalsIgnoreCase(columnTypeName)) {
				if ("Date".equals(parameterType)) {
					if (rs.getObject(columnName) != null)
						method.invoke(visualObject, new Object[] { rs
								.getDate(columnName) });
				}
			}
		}
	}

	/**
	 * 判断vo中是否含有对应的方法
	 * 
	 * @param cls
	 * @param setPropertyNameMethod
	 * @return
	 */
	private static Method getMethodByName(Class<?> cls,
			String setPropertyNameMethod) {
		if (setPropertyNameMethod == null
				|| "".equals(setPropertyNameMethod.trim()))
			return null;
		Method[] methods = cls.getDeclaredMethods();
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().equals(setPropertyNameMethod))
				return methods[i];
		}
		return null;
	}

	/**
	 * 获取set方法
	 * 
	 * @param columnName
	 * @return
	 */
	private static String setPropertyNameMethod(String columnName) {
		if (columnName.indexOf("_") == -1) {
			return "set"
					+ getFirstLetter(columnName).toUpperCase()
					+ columnName.substring(1, columnName.length())
							.toLowerCase();
		}

		String[] columnNames = columnName.split("_");
		String property = "";
		for (int i = 0; i < columnNames.length; i++) {
			property += getFirstLetter(columnNames[i]).toUpperCase()
					+ columnNames[i].substring(1, columnNames[i].length())
							.toLowerCase();
		}
		return "set" + property;
	}

	/**
	 * 获取第一个字母
	 * 
	 * @param str
	 * @return
	 */
	private static String getFirstLetter(String str) {
		if (str == null || "".equals(str.trim()))
			return null;
		return str.substring(0, 1);
	}
	
	/**
	 * 字符串数组转字符串
	 * 
	 * @param strArr
	 * @return
	 */
	public static final String strArray2Str(String[] strArr) {
		   StringBuffer strB = new StringBuffer();
		   for(int i=0; i<strArr.length; i++){
			   if(i != strArr.length-1){
				   strB.append(strArr[i]).append(",");
			   }else{
				   strB.append(strArr[i]);
			   }
		   }
		   return strB.toString();
	   }
	   /**
	 * 判断是否是-1
	 * @param dateStr
	 * @param pattern
	 * @return
	 * @throws ParseException
	 */
	public static Long getValueByLong(Long LongValue)
	throws ParseException {
		if (LongValue == null || LongValue.equals("") || LongValue == -1 || LongValue == 0){
			return null;
		}else{
			return LongValue;
		}
	}

	/**
	 * 将DATE类型转成String类型,pattern默认为yyyy-MM-dd
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static Date getDateStrNotNull(String dateStr, String pattern) throws ParseException{
		if (dateStr == null || dateStr.equals("")){
			return null;
		}
		if (pattern == null){
			pattern = DEFAULT_PATTERN;
		}
		SimpleDateFormat formater = new SimpleDateFormat(pattern);
		return formater.parse(dateStr);
	}
	
}