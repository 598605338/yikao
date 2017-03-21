package com.linjia.tools;

import java.awt.Color;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.TimeZone;

/**
 * Utility class to peform common String manipulation algorithms.
 */
public class StringUtils {

	public static void main(String[] args) {

	}

	/**
	 * 格式化字符串，是null返回"",不是null返回str.trim()
	 * 
	 * @param str
	 * @return String
	 */
	public static String changNull(String str) {
		if (str == null)
			str = "";
		else
			str = str.trim();
		return str;
	}

	/**
	 * 格式化字符串，是null返回期望值exp,不是null返回str.trim()
	 * 
	 * @param str
	 * @param exp
	 * @return String
	 */
	public static String changNull(String str, String exp) {
		if (str == null)
			str = exp;
		else
			str = str.trim();
		return str;
	}

	/**
	 * 格式化字符串，是null或""返回期望值exp,不是返回str.trim()
	 * 
	 * @param str
	 * @param exp
	 * @return String
	 */
	public static String chanNullAndBlank(String str, String exp) {
		if ("".equals(changNull(str)))
			str = exp;
		else
			str = str.trim();
		return str;
	}

	/**
	 * 格式化字符串，是null返回期html的空格,即&nbsp;,不是null返回str.trim()
	 * 
	 * @param str
	 * @param exp
	 * @return String
	 */
	public static String changHTMLNull(String str) {
		if (str == null || "".equals(str.trim()))
			str = "&nbsp;";
		else
			str = str.trim();
		return str;
	}

	/**
	 * 格式化字符串，是null返回"",不是null返回str
	 * 
	 * @param str
	 * @param exp
	 * @return String
	 */
	public static String changNullNotTrim(String str) {
		if (str == null)
			str = "";
		return str;
	}

	/**
	 * 格式化字符串，是null返回期html的空格,即&nbsp;,不是null返回str
	 * 
	 * @param str
	 * @param exp
	 * @return String
	 */
	public static String changHTMLNullNotTrim(String str) {
		if (str == null)
			str = "&nbsp;";
		return str;
	}

	/**
	 * gbk转utf8
	 * 
	 * @param str
	 * @return String
	 */
	public static String gbkToUTF8(String str) {
		if (str == null)
			str = "";
		else {
			try {
				str = new String(str.getBytes("GBK"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				return str;
			}
		}
		return str;
	}

	/**
	 * Initialization lock for the whole class. Init's only happen once per
	 * class load so this shouldn't be a bottleneck.
	 */
	private static Object initLock = new Object();


	/**
	 * Replaces all instances of oldString with newString in line.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replace(String line, String oldString, String newString) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line with the added
	 * feature that matches of newString in oldString ignore case.
	 * 
	 * @param line
	 *            the String to search to perform replacements on
	 * @param oldString
	 *            the String that should be replaced by newString
	 * @param newString
	 *            the String that will replace all instances of oldString
	 * 
	 * @return a String will all instances of oldString replaced by newString
	 */
	public static final String replaceIgnoreCase(String line, String oldString, String newString) {
		if (line == null) {
			return null;
		}
		String lcLine = line.toLowerCase();
		String lcOldString = oldString.toLowerCase();
		int i = 0;
		if ((i = lcLine.indexOf(lcOldString, i)) >= 0) {
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = lcLine.indexOf(lcOldString, i)) > 0) {
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			return buf.toString();
		}
		return line;
	}

	/**
	 * Replaces all instances of oldString with newString in line. The count
	 * Integer is updated with number of replaces.
	 * 
	 * @param line
	 *            String the String that should be replaced by newString
	 * @param oldString
	 *            String
	 * @param newString
	 *            String the String that will replace all instances of oldString
	 * @param count
	 *            int[]
	 * @return String a String will all instances of oldString replaced by
	 *         newString
	 */
	public static final String replace(String line, String oldString, String newString, int[] count) {
		if (line == null) {
			return null;
		}
		int i = 0;
		if ((i = line.indexOf(oldString, i)) >= 0) {
			int counter = 0;
			counter++;
			char[] line2 = line.toCharArray();
			char[] newString2 = newString.toCharArray();
			int oLength = oldString.length();
			StringBuffer buf = new StringBuffer(line2.length);
			buf.append(line2, 0, i).append(newString2);
			i += oLength;
			int j = i;
			while ((i = line.indexOf(oldString, i)) > 0) {
				counter++;
				buf.append(line2, j, i - j).append(newString2);
				i += oLength;
				j = i;
			}
			buf.append(line2, j, line2.length - j);
			count[0] = counter;
			return buf.toString();
		}
		return line;
	}

	/**
	 * This method takes a string which may contain HTML tags (ie, &lt;b&gt;,
	 * &lt;table&gt;, etc) and converts the '&lt'' and '&gt;' characters to
	 * their HTML escape sequences.
	 * 
	 * @param input
	 *            the text to be converted.
	 * @return the input string with the characters '&lt;' and '&gt;' replaced
	 *         with their HTML escape sequences.
	 */
	public static final String escapeHTMLTags(String input) {
		// Check if the string is null or zero length -- if so, return
		// what was sent in.
		if (input == null || input.length() == 0) {
			// return input;
			input = "";
		}
		// Use a StringBuffer in lieu of String concatenation -- it is
		// much more efficient this way.
		StringBuffer buf = new StringBuffer(input.length());
		char ch = ' ';
		for (int i = 0; i < input.length(); i++) {
			ch = input.charAt(i);
			if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	public static final String unescapeFromHTML(String input) {
		input = replace(input, "&lt;", "<");
		input = replace(input, "&gt;", ">");
		return input;
	}

	public static final String unNewLine(String input) {
		return StringUtils.replace(StringUtils.replace(input, "<BR>", "\r\n"), "<BR>", "\n");
	}

	/**
	 * Converts a line of text into an array of lower case words. Words are
	 * delimited by the following characters: , .\r\n:/\+
	 * <p>
	 * In the future, this method should be changed to use a
	 * BreakIterator.wordInstance(). That class offers much more fexibility.
	 * 
	 * @param text
	 *            a String of text to convert into an array of words
	 * @return text broken up into an array of words.
	 */
	public static final String[] toLowerCaseWordArray(String text) {
		if (text == null || text.length() == 0) {
			return new String[0];
		}
		StringTokenizer tokens = new StringTokenizer(text, " ,\r\n.:/\\+");
		String[] words = new String[tokens.countTokens()];
		for (int i = 0; i < words.length; i++) {
			words[i] = tokens.nextToken().toLowerCase();
		}
		return words;
	}

	/**
	 * A list of some of the most common words. For searching and indexing, we
	 * often want to filter out these words since they just confuse searches.
	 * The list was not created scientifically so may be incomplete :)
	 */
	private static final String[] commonWords = new String[] { "a", "and", "as", "at", "be", "do",
			"i", "if", "in", "is", "it", "so", "the", "to" };
	private static Map commonWordsMap = null;

	/**
	 * Returns a new String array with some of the most common English words
	 * removed. The specific words removed are: a, and, as, at, be, do, i, if,
	 * in, is, it, so, the, to
	 * 
	 * @param words
	 *            String[]
	 * @return String[]
	 */
	public static final String[] removeCommonWords(String[] words) {
		// See if common words map has been initialized. We don't statically
		// initialize it to save some memory. Even though this a small savings,
		// it adds up with hundreds of classes being loaded.
		if (commonWordsMap == null) {
			synchronized (initLock) {
				if (commonWordsMap == null) {
					commonWordsMap = new HashMap();
					for (int i = 0; i < commonWords.length; i++) {
						commonWordsMap.put(commonWords[i], commonWords[i]);
					}
				}
			}
		}
		// Now, add all words that aren't in the common map to results
		ArrayList results = new ArrayList(words.length);
		for (int i = 0; i < words.length; i++) {
			if (!commonWordsMap.containsKey(words[i])) {
				results.add(words[i]);
			}
		}
		return (String[]) results.toArray(new String[results.size()]);
	}

	/**
	 * Pseudo-random number generator object for use with randomString(). The
	 * Random class is not considered to be cryptographically secure, so only
	 * use these random Strings for low to medium security applications.
	 */
	private static Random randGen = null;

	/**
	 * Array of numbers and letters of mixed case. Numbers appear in the list
	 * twice so that there is a more equal chance that a number will be picked.
	 * We can use the array to get a random number or letter by picking a random
	 * array index.
	 */
	private static char[] numbersAndLetters = null;

	/**
	 * Returns a random String of numbers and letters of the specified length.
	 * The method uses the Random class that is built-in to Java which is
	 * suitable for low to medium grade security uses. This means that the
	 * output is only pseudo random, i.e., each number is mathematically
	 * generated so is not truly random.
	 * <p>
	 * 
	 * For every character in the returned String, there is an equal chance that
	 * it will be a letter or number. If a letter, there is an equal chance that
	 * it will be lower or upper case.
	 * <p>
	 * 
	 * The specified length must be at least one. If not, the method will return
	 * null.
	 * 
	 * @param length
	 *            the desired length of the random String to return.
	 * @return a random String of numbers and letters of the specified length.
	 */
	public static final String randomString(int length) {
		if (length < 1) {
			return null;
		}
		// Init of pseudo random number generator.
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					// Also initialize the numbersAndLetters array
					numbersAndLetters = ("0123456789abcdefghijklmnopqrstuvwxyz"
							+ "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ").toCharArray();
				}
			}
		}
		// Create a char buffer to put random letters and numbers in.
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(71)];
		}
		return new String(randBuffer);
	}

	public static final String random16String(int length) {
		if (length < 1) {
			return null;
		}
		// Init of pseudo random number generator.
		if (randGen == null) {
			synchronized (initLock) {
				if (randGen == null) {
					randGen = new Random();
					// Also initialize the numbersAndLetters array
					numbersAndLetters = ("0123456789ABCDEF").toCharArray();
				}
			}
		}
		// Create a char buffer to put random letters and numbers in.
		char[] randBuffer = new char[length];
		for (int i = 0; i < randBuffer.length; i++) {
			randBuffer[i] = numbersAndLetters[randGen.nextInt(15)];
		}
		return new String(randBuffer);
	}

	/**
	 * Intelligently chops a String at a word boundary (whitespace) that occurs
	 * at the specified index in the argument or before. However, if there is a
	 * newline character before <code>length</code>, the String will be chopped
	 * there. If no newline or whitespace is found in <code>string</code> up to
	 * the index <code>length</code>, the String will chopped at
	 * <code>length</code>.
	 * <p>
	 * For example, chopAtWord("This is a nice String", 10) will return
	 * "This is a" which is the first word boundary less than or equal to 10
	 * characters into the original String.
	 * 
	 * @param string
	 *            the String to chop.
	 * @param length
	 *            the index in <code>string</code> to start looking for a
	 *            whitespace boundary at.
	 * @return a substring of <code>string</code> whose length is less than or
	 *         equal to <code>length</code>, and that is chopped at whitespace.
	 */
	public static final String chopAtWord(String string, int length) {
		if (string == null) {
			return string;
		}

		char[] charArray = string.toCharArray();
		int sLength = string.length();
		if (length < sLength) {
			sLength = length;
		}

		// First check if there is a newline character before length; if so,
		// chop word there.
		for (int i = 0; i < sLength - 1; i++) {
			// Windows
			if (charArray[i] == '\r' && charArray[i + 1] == '\n') {
				return string.substring(0, i);
			}
			// Unix
			else if (charArray[i] == '\n') {
				return string.substring(0, i);
			}
		}
		// Also check boundary case of Unix newline
		if (charArray[sLength - 1] == '\n') {
			return string.substring(0, sLength - 1);
		}

		// Done checking for newline, now see if the total string is less than
		// the specified chop point.
		if (string.length() < length) {
			return string;
		}

		// No newline, so chop at the first whitespace.
		for (int i = length - 1; i > 0; i--) {
			if (charArray[i] == ' ') {
				return string.substring(0, i).trim();
			}
		}

		// Did not find word boundary so return original String chopped at
		// specified length.
		return string.substring(0, length);
	}

	/**
	 * Highlights words in a string. Words matching ignores case. The actual
	 * higlighting method is specified with the start and end higlight tags.
	 * Those might be beginning and ending HTML bold tags, or anything else.
	 * 
	 * @param string
	 *            the String to highlight words in.
	 * @param words
	 *            an array of words that should be highlighted in the string.
	 * @param startHighlight
	 *            the tag that should be inserted to start highlighting.
	 * @param endHighlight
	 *            the tag that should be inserted to end highlighting.
	 * @return a new String with the specified words highlighted.
	 */
	public static final String highlightWords(String string, String[] words, String startHighlight,
			String endHighlight) {
		if (string == null || words == null || startHighlight == null || endHighlight == null) {
			return null;
		}

		// Iterate through each word.
		for (int x = 0; x < words.length; x++) {
			// we want to ignore case.
			String lcString = string.toLowerCase();
			// using a char [] is more efficient
			char[] string2 = string.toCharArray();
			String word = words[x].toLowerCase();

			// perform specialized replace logic
			int i = 0;
			if ((i = lcString.indexOf(word, i)) >= 0) {
				int oLength = word.length();
				StringBuffer buf = new StringBuffer(string2.length);

				// we only want to highlight distinct words and not parts of
				// larger words. The method used below mostly solves this. There
				// are a few cases where it doesn't, but it's close enough.
				boolean startSpace = false;
				char startChar = ' ';
				if (i - 1 > 0) {
					startChar = string2[i - 1];
					if (!Character.isLetter(startChar)) {
						startSpace = true;
					}
				}
				boolean endSpace = false;
				char endChar = ' ';
				if (i + oLength < string2.length) {
					endChar = string2[i + oLength];
					if (!Character.isLetter(endChar)) {
						endSpace = true;
					}
				}
				if ((startSpace && endSpace) || (i == 0 && endSpace)) {
					buf.append(string2, 0, i);
					if (startSpace && startChar == ' ') {
						buf.append(startChar);
					}
					buf.append(startHighlight);
					buf.append(string2, i, oLength).append(endHighlight);
					if (endSpace && endChar == ' ') {
						buf.append(endChar);
					}
				} else {
					buf.append(string2, 0, i);
					buf.append(string2, i, oLength);
				}

				i += oLength;
				int j = i;
				while ((i = lcString.indexOf(word, i)) > 0) {
					startSpace = false;
					startChar = string2[i - 1];
					if (!Character.isLetter(startChar)) {
						startSpace = true;
					}

					endSpace = false;
					if (i + oLength < string2.length) {
						endChar = string2[i + oLength];
						if (!Character.isLetter(endChar)) {
							endSpace = true;
						}
					}
					if ((startSpace && endSpace) || i + oLength == string2.length) {
						buf.append(string2, j, i - j);
						if (startSpace && startChar == ' ') {
							buf.append(startChar);
						}
						buf.append(startHighlight);
						buf.append(string2, i, oLength).append(endHighlight);
						if (endSpace && endChar == ' ') {
							buf.append(endChar);
						}
					} else {
						buf.append(string2, j, i - j);
						buf.append(string2, i, oLength);
					}
					i += oLength;
					j = i;
				}
				buf.append(string2, j, string2.length - j);
				string = buf.toString();
			}
		}
		return string;
	}

	/**
	 * Escapes all necessary characters in the String so that it can be used in
	 * an XML doc.
	 * 
	 * @param string
	 *            the string to escape.
	 * @return the string with appropriate characters escaped.
	 */
	public static final String escapeForXML(String string) {
		// Check if the string is null or zero length -- if so, return
		// what was sent in.
		if (string == null || string.length() == 0) {
			return string;
		}
		char[] sArray = string.toCharArray();
		StringBuffer buf = new StringBuffer(sArray.length);
		char ch;
		for (int i = 0; i < sArray.length; i++) {
			ch = sArray[i];
			if (ch == '<') {
				buf.append("&lt;");
			} else if (ch == '>') {
				buf.append("&gt;");
			} else if (ch == '"') {
				buf.append("&quot;");
			} else if (ch == '&') {
				buf.append("&amp;");
			} else {
				buf.append(ch);
			}
		}
		return buf.toString();
	}

	/**
	 * Unescapes the String by converting XML escape sequences back into normal
	 * characters.
	 * 
	 * @param string
	 *            the string to unescape.
	 * @return the string with appropriate characters unescaped.
	 */
	public static final String unescapeFromXML(String string) {
		string = replace(string, "&lt;", "<");
		string = replace(string, "&gt;", ">");
		string = replace(string, "&quot;", "\"");
		return replace(string, "&amp;", "&");
	}

	/**
	 * \u93CD规\u5D41\u93BB\u612A\u7DF5\u9428\u52EC\u7223绀虹\uE0C1
	 * 锛\u5C7D\u578E\u9353插\u74E7绗\uFE3F覆\u9286?
	 * 
	 * 
	 * @param str
	 *            String
	 * @param delim
	 *            String
	 * @return String[]
	 */
	public static final String[] explodeString(String str, String delim) {
		if (str == null || str.trim().equals("")) {
			String[] retstr = null;
			// String[] retstr = new String[1];
			// retstr[0] = "";

			return retstr;
		}
		StringTokenizer st = new StringTokenizer(str, delim);
		String[] retstr = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			retstr[i] = st.nextToken();
			i++;
		}
		if (i == 0) {
			retstr[0] = str;
		}
		return retstr;
	}

	public static final String[] explodeString_eei(String str, String delim) {
		if (str == null || str.trim().equals("")) {
			String[] retstr = null;
			// String[] retstr = new String[1];
			// retstr[0] = "";

			return retstr;
		}
		// StringTokenizer st = new StringTokenizer(str, delim);
		// String[] retstr = new String[st.countTokens()];
		// int i = 0;
		// while (st.hasMoreTokens()) {
		// retstr[i] = st.nextToken();
		// i++;
		// }
		// if (i == 0) {
		// retstr[0] = str;
		// }

		String[] retstr = str.split(delim);
		if (retstr != null && retstr.length == 1) {
			retstr[0] = str;
		}

		return retstr;
	}

	public static final String[] explodeString(String str, String delim, boolean returnDelims) {
		if (str == null || str.equals("")) {
			String[] retstr = null;
			// String[] retstr = new String[1];
			// retstr[0] = "";

			return retstr;
		}
		StringTokenizer st = new StringTokenizer(str, delim, returnDelims);
		String[] retstr = new String[st.countTokens()];
		int i = 0;
		while (st.hasMoreTokens()) {
			retstr[i] = st.nextToken();
			i++;
		}
		if (i == 0) {
			retstr[0] = str;
		}
		return retstr;
	}

	public static final Map explodeStringMap(String str, String delim) {
		Map map = new HashMap();
		if (str == null || str.equals("")) {
			return map;
		}
		StringTokenizer st = new StringTokenizer(str, delim);
		int i = 0;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			map.put(s, s);
			i++;
		}
		if (i == 0) {
			map.put(str, str);
		}
		return map;
	}

	public static final List explodeStringList(String str, String delim) {
		List list = new ArrayList();
		if (str == null || str.equals("")) {
			return list;
		}
		StringTokenizer st = new StringTokenizer(str, delim);
		int i = 0;
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			list.add(s);
			i++;
		}
		if (i == 0) {
			list.add(str);
		}
		return list;
	}

	// 比较两字符串，格式：1;1;1;,
	public void compareStr(String oldstr, String newstr) {

		Map oldmap = StringUtils.explodeStringMap(oldstr, ";");
		Map newmap = StringUtils.explodeStringMap(newstr, ";");

		if (oldmap != null && oldmap.size() > 0) {
			if (newmap != null && newmap.size() > 0) {
				Iterator iterator = oldmap.keySet().iterator();
				while (iterator.hasNext()) {
					Object property = (Object) iterator.next();
					if (!newmap.containsKey(property)) { // 新的不包含旧的，为删除
					// deleteNetInfo();
					}
				}
			} else { // 新的为null
				// 没有不变
			}
		}
		if (newmap != null && newmap.size() > 0) {
			if (oldmap != null && oldmap.size() > 0) {
				Iterator iterator = newmap.keySet().iterator();
				while (iterator.hasNext()) {
					Object property = (Object) iterator.next();
					if (!oldmap.containsKey(property)) { // 旧的没有新的，为新增
					// newNetInfo();
					}
				}
			} else { // oldmap==null
			// newNetInfo();
			}
		}
	}

	/**
	 * \u93B6\u5994rcStr涓\uE160\u6B91escapeStr\u9358绘\u5E00
	 * 渚\u5B2A\uE6E7锛\u6B5FscapeStr("aaaa--bb--cc","--");
	 * 灏\u55DA\u7E51\u9365?aaaabbcc"
	 * 
	 * @param srcStr
	 *            String
	 * @param escapeStr
	 *            String
	 * @return String
	 */
	public static final String escapeStr(String srcStr, String escapeStr) {
		StringBuffer newStrBuf = new StringBuffer();
		int startIndex = 0;
		int endIndex = 0;
		while ((endIndex = srcStr.indexOf(escapeStr, startIndex)) > 0) {
			newStrBuf.append(srcStr.substring(startIndex, endIndex));
			startIndex = endIndex + escapeStr.length();
		}
		newStrBuf.append(srcStr.substring(startIndex));
		return newStrBuf.toString();
	}

	/**
	 * 
	 * @param oldStr
	 *            String
	 * @return String
	 */
	public static final String nullToStr(String oldStr) {
		if (oldStr == null || "null".equals(oldStr)) {

			return "";
		}
		return oldStr.trim();
	}

	public static final String nullToHTMLStr(String oldStr) {
		if (oldStr == null || "null".equals(oldStr)) {

			return "&nbsp;";
		}
		return oldStr.trim();
	}

	/**
	 * 
	 * @param oldDate
	 *            Date
	 * @param sFormat
	 *            String
	 * @return String
	 */
	public static final String nullToStr(Date oldDate, String sFormat) {
		if (oldDate == null) {
			return "";
		} else {
			return DateComFunc.getDateFormat(oldDate, sFormat);
		}

	}

	/**
	 * 
	 * @param oldData
	 *            BigDecimal
	 * @return String
	 */
	public static final String nullToStr(BigDecimal oldData) {
		if (oldData == null) {
			return "";
		} else {
			return oldData.toString().trim();
		}

	}

	/**
	 * 
	 * @param oldData
	 *            long
	 * @return String
	 */
	public static final String nullToStr(long oldData) {
		return new Long(oldData).toString().trim();
	}

	/**
	 * 
	 * @param oldData
	 *            int
	 * @return String
	 */
	public static final String nullToStr(int oldData) {
		return new Integer(oldData).toString().trim();
	}

	/**
	 * 
	 * @param oldData
	 *            double
	 * @return String
	 */
	public static final String nullToStr(double oldData) {
		return new Double(oldData).toString().trim();
	}

	/**
	 * 
	 * @param oldData
	 *            Integer
	 * @return String
	 */
	public static final String nullToStr(Integer oldData) {
		if (oldData == null) {
			return "";
		} else {
			return oldData.toString().trim();
		}

	}

	/**
	 * 
	 * @param oldData
	 *            Double
	 * @return String
	 */
	public static final String nullToStr(Double oldData) {
		if (oldData == null) {
			return "";
		} else {
			return oldData.toString().trim();
		}

	}

	/**
	 * 
	 * @param oldData
	 *            Object
	 * @return String
	 */
	public static final String nullToStr(Object oldData) {
		if (oldData == null) {
			return "";
		} else {
			return oldData.toString().trim();
		}

	}

	public static final String nullToStr(Object oldData, String defaultstr) {
		if (oldData == null || oldData.equals("0")) {
			return defaultstr;
		} else {
			return oldData.toString().trim();
		}

	}

	/**
	 * \u93C3ユ\u6E61杞\uE100\u5BF2\u93B4\u612C\u74E7绗\uFE3F覆
	 * 
	 * @param currdate
	 *            Date
	 * @return String
	 */
	public static final String dateToString(java.util.Date currdate) {
		String returnDate = "";
		try {
			java.text.SimpleDateFormat simple = new java.text.SimpleDateFormat("yyyy-MM-dd");
			if (currdate == null)
				return returnDate;
			else
				returnDate = simple.format(currdate);
		} catch (Exception ex) {

		}
		return returnDate;

	}

	/**
	 * 
	 * @param currdate
	 *            Date
	 * @return String
	 */
	public static final String timesToString(java.util.Date currdate) {
		String returnDate = "";
		try {
			java.text.SimpleDateFormat simple = new java.text.SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			if (currdate == null)
				return returnDate;
			else
				returnDate = simple.format(currdate);
		} catch (Exception ex) {

		}
		return returnDate;

	}

	/**
	 * 
	 * @param oldData
	 *            String
	 * @param len
	 *            int
	 * @return String
	 */
	public static final String LenToString(String oldData, int len) {
		String result = "";
		if (oldData == null)
			oldData = "";
		result = oldData;
		for (int i = 0; i < (len - oldData.length()); i++) {
			result = "0" + result;
		}
		return result;
	}

	/**
	 * 
	 * 浜х\u6553\u9366\u256Ftart\u935C\u5B94nd涔\u5B2E\u68FF\u9428\u5235um涓\uE048
	 * \u6BA2\u93C8烘\u66A3\u93C1帮\u7D1D杩\u65BF\u6D16\u934A间腑\u9286?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-7-30 8:50:23)
	 * 
	 * @return java.util.Hashtable
	 * @param start
	 *            int 璧峰\uE750\u9410?
	 * 
	 * 
	 * @param end
	 *            int 缁\u64B4\u6F6B\u9410?
	 * 
	 * 
	 * @param num
	 *            int \u9422\u71B8\u579A涓\uE045\u669F
	 */
	public String randomStr(int start, int end, int num) {
		String result = "";
		for (int i = 0; i < num; i++) {
			double sru = Math.random() * end;
			int tag = Math.round((float) sru);
			if (tag < start) {
				i--;
			} else {
				result = result + tag;
			}
		}
		return result;
	}

	public static Color getRandColor() {
		Map map = StringUtils.random(0, 255, 3);

		return new Color(((Integer) map.get(new Integer(0))).intValue(),
				((Integer) map.get(new Integer(1))).intValue(),
				((Integer) map.get(new Integer(2))).intValue());
	}

	/**
	 * 杈\u64B3\u56ADUTF8
	 * 
	 * @param s
	 *            String
	 * @return String
	 */
	public static String toUTF8String(String s) {
		StringBuffer sb = new StringBuffer();
		if (s == null)
			return "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					// System.out.println(ex);
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0) {
						k += 256;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param s0
	 *            String
	 * @return String
	 */
	public static String convHTML(String s0) {
		String s = s0;
		if (s.indexOf("<br>") != -1 || s.indexOf("<p>") != -1 || s.indexOf("<font") != -1)
			return s;
		s = replace(s, "\n", "<br>");
		s = replace(s, "  ", "\u9286\u20AC");
		s = replace(s, " ", "&nbsp");
		return s;
	}

	/**
	 * 
	 * @param moto
	 *            String
	 * @return String
	 */
	public static String convertToAvoidGarbage(String moto) {
		String moto2 = null;
		try {
			// moto2 = new String( moto.getBytes("ISO8859-1"),"MS932");
			// moto2 = moto ;
			moto2 = new String(moto.getBytes("ISO8859-1"), "GBK");
		} catch (Exception e) {

		}

		return moto2;
	}

	public static String convertToUTF8(String moto) {
		String moto2 = null;
		try {
			moto2 = new String(moto.getBytes("ISO8859-1"), "UTF-8");
		} catch (Exception e) {

		}

		return moto2;
	}

	/**
	 * 
	 * @param num
	 *            BigDecimal
	 * @return Long
	 */
	public static Long BigDecimalToLong(BigDecimal num) {
		if (num == null) {
			return null;
		} else {
			return new Long(num.longValue());
		}
	}

	public static Long IntegerToLong(Integer num) {
		if (num == null) {
			return null;
		} else {
			return new Long(num.longValue());
		}
	}

    public static Float BigDecimalToFloat(BigDecimal num) {
        if (num == null) {
            return null;
        } else {
            return new Float(num.floatValue());
        }
    }

	public static Integer LongToInteger(Long num) {
		if (num == null) {
			return null;
		} else {
			return new Integer(num.intValue());
		}
	}

	public static long BigDecimalTolong(BigDecimal num) {
		if (num == null) {
			return 0;
		} else {
			return num.longValue();
		}
	}

	public static Integer BigDecimalToInteger(BigDecimal num) {
		if (num == null) {
			return null;
		} else {
			return new Integer(num.intValue());
		}
	}

	public static long IntegerTolong(Integer num) {
		if (num == null) {
			return 0;
		} else {
			return num.longValue();
		}
	}

	public static Double BigDecimalToDouble(BigDecimal num) {
		if (num == null) {
			return null;
		} else {
			return new Double(num.doubleValue());
		}
	}

	public static double BigDecimalTodouble(BigDecimal num) {
		if (num == null) {
			return 0;
		} else {
			return num.doubleValue();
		}
	}

	/**
	 * 
	 * @param map
	 *            Map
	 * @param key
	 *            String
	 * @param value
	 *            String
	 * @return boolean
	 */
	public static boolean isEqual(Map map, String key, String value) {
		if (map == null)
			return false;
		if (map.get(key) == null)
			return false;
		if (((String) map.get(key)).equals(value)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param str
	 *            String
	 * @return Long
	 */
	public static Long strToLong(String str) {
		if (str == null || str.equals(""))
			return null;

		return new Long(str);
	}

	public static long longValue(Long l) {
		if (l == null)
			return 0;

		return l.longValue();
	}

	/**
	 * 
	 * @param str
	 *            String
	 * @return Integer
	 */
	public static Integer strToInteger(String str) {
		if (str == null || str.equals(""))
			return null;
		return new Integer(str);
	}

	public static Double strToDouble(String str) {
		if (str == null || str.equals(""))
			return null;

		return new Double(str);
	}

	public static Float strToFloat(String str) {
		if (str == null || str.equals(""))
			return null;

		return new Float(str);
	}

	/**
	 * 
	 * @param str
	 *            String[]
	 * @param escapeStr
	 *            String
	 * @return String
	 */
	public static String explodeArray(String[] str, String escapeStr) {
		if (str == null)
			return null;
		if (str.length == 0)
			return "";
		String result = "";
		for (int i = 0; i < str.length; i++) {
			result = result + str[i] + escapeStr;
		}
		result = result.substring(0, result.length() - escapeStr.length());
		return result;

	}
	
    public static String explodeList(List list, String escapeStr) {
        if (list == null)return null;
        if (list.size() == 0)return "";
        String result = "";
        for (int i = 0; i < list.size(); i++){
            result = result + String.valueOf(list.get(i)) + escapeStr;
        }
        result = result.substring(0, result.length() - escapeStr.length());
        return result;
    }

	/**
	 * \u9359\u6828\u68E9\u93C8\u71B6\u7BA3\u935A\u5DD2\u9428\u52EC\u68E9\u93C8\u712Cyyy
	 * -MM-dd HH:mm:ss\u9286?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.String
	 * @param java
	 *            .util.Date
	 * @param java
	 *            .lang.Integer
	 */
	public static String getLaterNDate(Date dt, int intDays) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(dt);
		cal.add(java.util.Calendar.DAY_OF_YEAR, intDays);
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String ret = sdf.format(cal.getTime());
		return ret;
	}

	/**
	 * 灏\u54B2ate杞\uE101\u5D32涓\u7BE0tring\u9286?
	 * 
	 * 
	 * @return java.lang.String
	 * @param java
	 *            .util.Date
	 * @param java
	 *            .lang.String
	 */

	public static String getDateFormat(Date dt, String format) {
		String ret = "";
		if (dt == null) {
			ret = "";
		} else {
			Calendar cal = Calendar.getInstance();
			cal.setTime(dt);
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(format);
			ret = sdf.format(cal.getTime());

		}
		return ret;
	}

	/**
	 * \u93B7煎\u608E\u93C1扮\u7C8D\u9286?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.String
	 * @param param
	 *            java.lang.String[]
	 * @param param
	 *            java.lang.String
	 */
	public static String join_array(String[] param, String spilt) {
		String rentunstring;
		StringBuffer tempstr = new StringBuffer();
		int len = param.length;
		for (int i = 0; i < len - 1; i++) {
			tempstr.append(param[i]);
			tempstr.append(spilt);
		}
		tempstr.append(param[len - 1]);
		rentunstring = tempstr.toString();
		return rentunstring;
	}

	/**
	 * 浜х\u6553\u9366\u256Ftart\u935C\u5B94nd涔\u5B2E\u68FF\u9428\u5235um涓\uE048
	 * \u6BA2\u93C8烘\u66A3\u93C1帮\u7D1D杩\u65BF\u6D16\u934A煎\u74E8\u9366
	 * \u2109ashtable涓\uE15C\u20AC?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-7-30 8:50:23)
	 * 
	 * @return java.util.Hashtable
	 * @param start
	 *            int 璧峰\uE750\u9410?
	 * 
	 * 
	 * @param end
	 *            int 缁\u64B4\u6F6B\u9410?
	 * 
	 * 
	 * @param num
	 *            int \u9422\u71B8\u579A涓\uE045\u669F
	 */
	public static HashMap random(int start, int end, int num) {
		HashMap randomHash = new HashMap();
		for (int i = 0; i < num; i++) {
			double sru = Math.random() * end;
			int tag = Math.round((float) sru);
			if (tag < start) {
				i--;
			} else {
				randomHash.put(new Integer(i), new Integer(tag));
			}
		}
		return randomHash;
	}

	/**
	 * \u93C7挎\u5D32瀛\u6943\uE0C1涓蹭腑\u9428\u52EB\u74D9瀛\u6943\uE0C1涓?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-10-10 13:50:21)
	 * 
	 * @return java.lang.String
	 * @param param
	 *            java.lang.String \u9358\u71B7\u74E7绗\uFE3F覆
	 * @param param1
	 *            java.lang.String
	 *            \u95C7\u20AC瑕\u4F79\u6D5B\u93B9㈢\u6B91瀛\u612C\u74E7绗\uFE3F覆
	 * @param param2
	 *            java.lang.String
	 *            灏\u55DA\uE766\u93C7挎\u5D32\u93B4\u612E\u6B91瀛\u612C\u74E7绗
	 *            \uFE3F覆
	 * @exception java.lang.Exception
	 *                寮\u509A父璇存\u69D1\u9286?
	 */
	public static String replaceString(String param, String param1, String param2)
			throws java.lang.Exception {
		String returnString = "";
		try {
			if (param != null && param1 != null && param2 != null && !param.equalsIgnoreCase("")
					&& !param1.equalsIgnoreCase("") && !param2.equalsIgnoreCase("")) {
				int intLen = param.length(); // \u9358\u71B7\u74E7绗\uFE3F覆\u95C0垮害
				int intLenSrc = param1.length(); // \u95C7\u20AC瑕\u4F79\u6D5B\u93B9㈢\u6B91瀛\u612C\u74E7绗\uFE3F覆\u95C0垮害
				int intPoint = 0; // 褰\u64B3\u58A0浣\u5D87疆
				while (intPoint < param.length()) {
					if ((intPoint + intLenSrc) <= param.length() && intPoint < param.length()) {
						String compareString = param.substring(intPoint, intPoint + intLenSrc);
						if (compareString.equalsIgnoreCase(param1)) {
							returnString = returnString + param2;
							intPoint = intPoint + param1.length();
						} else {
							returnString = returnString + param.charAt(intPoint);
							intPoint++;
						}
					} else if ((intPoint + intLenSrc) > param.length() && intPoint < param.length()) {
						returnString = returnString + param.charAt(intPoint);
						intPoint++;
					} else if ((intPoint + intLenSrc) > param.length()) {
						break;
					}
				}
			}

		} catch (java.lang.Exception ex) {
			return ex.toString();
		}
		return returnString;
	}

	/**
	 * 姝ゅ\uE629\u93BB\u6391\u53C6\u93C2规\u7876璇存\u69D1
	 * \u93B7\u55D7\u578E瀛\u693E覆\u9352版\u669F缁\u52F6\u7D1D\u9352\u55D7\u58CA绗
	 * \uFE41\uE1EC浣跨\u6564,.绛?涓\u5D88\u5158浣跨\u6564涓\uE15F\u6783绗\uFE40
	 * \u5F7F浣\u6EC0负\u9352\u55D7\u58CA绗
	 * \uFE40\u5F7F锛\u5C83\u7E51\u9365\u6FF0ashtable
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-7-10 14:50:31)
	 * 
	 * @param fieldsru java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u7DDF\u93B7\u55D7\u578E瀛\u6943
	 *        \uE0C1涓?
	 * 
	 * 
	 * @param tag java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u578E\u9353茬\uE0C1
	 *        杩\u65BF\u6D16Hashtable
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 * 
	 * 
	 * @exception java.io.IOException 寮\u509A父璇存\u69D1\u9286?
	 */
	public static Hashtable spilt(String fieldsru, String tag) {
		Hashtable returnarray = new Hashtable();
		char dot = tag.charAt(0);
		String field;
		field = fieldsru + dot;
		int num = 0;
		int field_len = field.length();
		for (int i = 0; i < field_len; i++) {
			if (field.charAt(i) == dot) {
				num++;
			}
		}
		int begin = 0;
		int end;
		for (int j = 0; j < num; j++) {
			end = field.indexOf(dot, begin);
			returnarray.put(new Integer(j), field.substring(begin, end));
			begin = end + 1;
		}
		return returnarray;
	}

	/**
	 * \u93B7\u55D7\u578E瀛\u693E覆\u9352版\u669F缁\u52F6\u7D1D\u9352\u55D7\u58CA绗
	 * \uFE41\uE1EC浣跨\u6564,.绛?涓\u5D88\u5158浣跨\u6564涓\uE15F\u6783绗\uFE40
	 * \u5F7F浣\u6EC0负\u9352\u55D7\u58CA绗
	 * \uFE40\u5F7F锛\u5C83\u7E51\u9365\u6FFBtring[]
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-7-10 14:50:31)
	 * 
	 * @param fieldsru java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u7DDF\u93B7\u55D7\u578E瀛\u6943
	 *        \uE0C1涓?
	 * 
	 * 
	 * @param tag java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u578E\u9353茬\uE0C1
	 *        杩\u65BF\u6D16String[]
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 * 
	 * 
	 * @exception java.io.IOException 寮\u509A父璇存\u69D1\u9286?
	 */
	public static String[] spilt_str(String fieldsru, String tag) {
		// Hashtable returnarray = new Hashtable();
		char dot = tag.charAt(0);
		String field;
		field = fieldsru + dot;
		int num = 0;
		int field_len = field.length();
		for (int i = 0; i < field_len; i++) {
			if (field.charAt(i) == dot) {
				num++;
			}
		}
		String[] returnarray = new String[num];
		int begin = 0;
		int end;
		for (int j = 0; j < num; j++) {
			end = field.indexOf(dot, begin);
			returnarray[j] = field.substring(begin, end);
			// returnarray.put(new Integer(j), field.substring(begin, end));
			begin = end + 1;
		}

		return returnarray;
	}

	/**
	 * public String[] SplitString(String fieldsru, String tag)
	 * \u93B7\u55D7\u578E瀛\u693E覆\u9352版\u669F缁\u52F6\u7D1D\u9352\u55D7\u58CA绗
	 * \uFE40\u5F72浣跨\u6564澶\u6C2B釜瀛\u6943\uE0C1\u93B4\u682C\u20AC\u546C腑\u93C2?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @param fieldsru java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u7DDF\u93B7\u55D7\u578E瀛\u6943
	 *        \uE0C1涓?
	 * 
	 * 
	 * @param tag java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u578E\u9353茬\uE0C1
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 * 
	 * 
	 * @exception java.io.IOException 寮\u509A父璇存\u69D1\u9286?
	 */
	public static String[] SplitString(String fieldsru, String tag) {
		try {
			int dot_len = tag.length(); // \u947E峰\u7DF1\u9352\u55D7\u58CA绗\uFE3E\u6B91\u95C0垮害
			int str_len = fieldsru.length(); // 瀛\u6943\uE0C1涓查\u66B1搴?

			String tempStr = fieldsru + tag;
			int num = 0;
			for (int i = 0; i < str_len; i++) {
				int point = i + dot_len;
				if (point < str_len) {
					String temp = fieldsru.substring(i, point);
					if (temp.equalsIgnoreCase(tag)) {
						num++;
					}
				}
			}
			num = num + 1;
			String[] returnarray = new String[num];
			int begin = 0;
			int end = fieldsru.indexOf(tag);
			for (int i = 0; i < num; i++) {
				end = tempStr.indexOf(tag, begin);
				returnarray[i] = tempStr.substring(begin, end);
				begin = end + dot_len;
			}
			return returnarray;
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}
		return null;
	}

	/**
	 * public int SplitStringNum(String fieldsru, String tag)
	 * \u93B7\u55D7\u578E瀛\u693E覆\u9352版\u669F缁\u52F6\u7D1D\u9352\u55D7\u58CA绗
	 * \uFE40\u5F72浣跨\u6564澶\u6C2B釜瀛\u6943\uE0C1\u93B4\u682C\u20AC\u546C腑\u93C2?
	 * 杩\u65BF\u6D16\u95C0垮害 \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @param fieldsru java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u7DDF\u93B7\u55D7\u578E瀛\u6943
	 *        \uE0C1涓?
	 * 
	 * 
	 * @param tag java.lang.String
	 *        杈\u64B3\u53C6\u9359\u509B\u669F锛\u6C2C\u578E\u9353茬\uE0C1
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 * 
	 * 
	 * @exception java.io.IOException 寮\u509A父璇存\u69D1\u9286?
	 */

	public static int SplitStringNum(String fieldsru, String tag) {
		try {
			int dot_len = tag.length(); // \u947E峰\u7DF1\u9352\u55D7\u58CA绗\uFE3E\u6B91\u95C0垮害
			int str_len = fieldsru.length(); // 瀛\u6943\uE0C1涓查\u66B1搴?

			String tempStr = fieldsru + tag;
			int num = 0;
			for (int i = 0; i < str_len; i++) {
				int point = i + dot_len;
				if (point < str_len) {
					String temp = fieldsru.substring(i, point);
					if (temp.equalsIgnoreCase(tag)) {
						num++;
					}
				}
			}
			num = num + 1;
			return num;
		} catch (java.lang.Exception e) {
			// System.out.println(e.getMessage());
		}
		return 0;
	}

	/**
	 * public String gettime(int time_zone) throws Exception
	 * \u947E峰\u5F47褰\u64B3\u58A0\u93C3堕\u68FF锛\u582C\u7D1A\u93C3堕\u68FF\u93CD煎\u7D21
	 * 锛\u5762m/dd/yyyy hh:mm:ss pm锛\u590A\u5F2C\u93C1颁负\u93C3跺\u5C2F
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?2001-10-22 10:11:48)
	 * 
	 * @return java.lang.String
	 * @param java.lang.Integer \u93C3跺\u5C2F
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 */

	public static String gettime(int time_zone) throws Exception {
		String nowtime = "";
		try {
			if (time_zone > 0) {
				time_zone = time_zone - 1;
			} else if (time_zone < 0) {
				time_zone = time_zone + 1;
			}
			String[] ids = TimeZone.getAvailableIDs(time_zone * 60 * 60 * 1000);
			SimpleTimeZone pdt = new SimpleTimeZone(time_zone * 60 * 60 * 1000, ids[0]);
			pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
			pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

			Calendar calendar = new GregorianCalendar(pdt);
			Date trialTime = new Date();
			calendar.setTime(trialTime);
			String now_year = new Integer(calendar.get(Calendar.YEAR)).toString();
			String now_month = new Integer(calendar.get(Calendar.MONTH) + 1).toString();
			if (now_month.length() == 1) {
				now_month = "0" + now_month;
			}
			String now_date = new Integer(calendar.get(Calendar.DATE)).toString();
			if (now_date.length() == 1) {
				now_date = "0" + now_date;
			}
			int am_pm = calendar.get(Calendar.AM_PM);
			String now_hour = new Integer(calendar.get(Calendar.HOUR)).toString();
			if (am_pm == 1) {
				int intnow_hour = Integer.parseInt(now_hour) + 12;
				now_hour = (new Integer(intnow_hour)).toString();
			} else {
			}
			if (now_hour.length() == 1) {
				now_hour = "0" + now_hour;
			}

			String now_MINUTE = new Integer(calendar.get(Calendar.MINUTE)).toString();
			if (now_MINUTE.length() == 1) {
				now_MINUTE = "0" + now_MINUTE;
			}
			String now_SECOND = new Integer(calendar.get(Calendar.SECOND)).toString();
			if (now_SECOND.length() == 1) {
				now_SECOND = "0" + now_SECOND;
			}
			String str_AMPM = "";
			// \u9352ゆ\u67C7涓\u5A42\u5D0D杩\u6A3B\u69F8涓\u5B2A\u5D0D
			if (am_pm == 0) {
				str_AMPM = "AM";
			} else if (am_pm == 1) {
				str_AMPM = "PM";
			}
			nowtime = now_month + "/" + now_date + "/" + now_year + " " + now_hour + ":"
					+ now_MINUTE + ":" + now_SECOND + " " + str_AMPM;
		} catch (Exception ex) {
			throw ex;
		}
		return nowtime;
	}

	/**
	 * public String[] hashToArray(Hashtable param)throws Exception
	 * 灏\u54B9ASHTABLE\u9350\u546D\uE190杞\uE100\u53C6\u93C1扮\u7C8D
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.String[]
	 * @param java.util.Hashtable
	 * @exception java.lang.Exception 寮\u509A父璇存\u69D1\u9286?
	 */
	public static String[] hashToArray(Hashtable param) throws Exception {
		if (param.size() == 0) {
			return null;
		}
		String[] return_array = new String[param.size()];
		try {
			int param_size = param.size();
			Enumeration enumKeys = param.keys(); // 灏\u5504ashtable杞\uE101\u5D32涓烘\u7047涓剧被\u9368?

			for (int i = 0; enumKeys.hasMoreElements(); i++) {
				Object temp = enumKeys.nextElement();
				return_array[i] = (String) param.get(temp);
			}
		} catch (Exception ex) {
			throw ex;
		}
		return return_array;
	}

	/**
	 * public long getDays(Date sd,Date ed)
	 * \u9359\u6827\u7DF1涓や釜\u93C3ユ\u6E61\u9428\u52ED\u6D49\u95C5\u65BFぉ\u93C1?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.Long
	 * @param java.util.Date
	 * @param java.util.Date
	 */
	public static long getDays(Date sd, Date ed) {
		return ((ed.getTime() - sd.getTime()) / (3600 * 24 * 1000));
	}

	/**
	 * public String addChar(String s1 ,int ilength ,String s2)
	 * \u9366ㄥ\u5F47寰\u6940\u74E7绗\uFE3F覆\u9359冲\u59DE涓?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.String
	 * @param java.lang.String
	 * @param java.lang.Integer涓\uE045\u669F
	 * @param java.lang.String
	 */
	public static String addChar(String s1, int ilength, String s2) throws Exception {
		try {
			String sreturn = s1.trim();
			byte[] tmpbyte = s1.trim().getBytes("GBK");
			// s1 = new String(tmpbyte);
			int ilength_old = tmpbyte.length;
			if (ilength_old < ilength) {
				for (int i = 1; i <= ilength - ilength_old; i++) {
					sreturn = sreturn + s2;
				}
			}
			return sreturn;
		} catch (Exception e) {
			throw e;
		}
	}

	public static String delChar(String s1, int ilength) throws Exception {
		try {
			String sreturn = s1.trim();
			byte[] tmpbyte = s1.trim().getBytes("GBK");
			byte[] tmpbytenew = new byte[ilength];
			int ilength_old = tmpbyte.length;
			if (ilength_old > ilength) {
				for (int i = 0; i < ilength; i++) {
					tmpbytenew[i] = tmpbyte[i];
				}
				sreturn = new String(tmpbytenew);
			}
			return sreturn;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * public String addLeftChar(String s1 ,int ilength ,String s2)
	 * \u9366ㄥ\u5F47寰\u6940\u74E7绗\uFE3F覆宸\uFE40\u59DE涓?
	 * 
	 * 
	 * \u9352\u6D98缓\u93C3ユ\u6E61锛?
	 * 
	 * 
	 * @return java.lang.String
	 * @param java.lang.String
	 * @param java.lang.Integer涓\uE045\u669F
	 * @param java.lang.String
	 */
	public static String addLeftChar(String s1, int ilength, String s2) throws Exception {
		try {
			String sreturn = s1.trim();
			byte[] tmpbyte = s1.trim().getBytes("GBK");
			s1 = new String(tmpbyte);
			int ilength_old = tmpbyte.length;
			if (ilength_old < ilength) {
				for (int i = 1; i <= ilength - ilength_old; i++) {
					sreturn = s2 + sreturn;
				}
			}
			return sreturn;
		} catch (Exception e) {
			throw e;
		}
	}

	/**
	 * 灏\u55D7\u74E7绗\uFE3F覆杞\uE101\u5D32涓哄\u757E\u95C0夸覆
	 * 
	 * @param sSend String 涓?
	 * 
	 * 
	 * @param iDesiredLength int 瀹\u6C36\u66B1
	 * @param iOperationType int 琛ラ\u7D88
	 * @param iFoldOperation int \u93CD煎\u7D21\u9356\u6827\u74E7涓?
	 * 
	 * 
	 * @return String
	 */
	public static String standardChar(String sSend, int iDesiredLength, int iOperationType,
			int iFoldOperation) {
		String sSubString, sRemain, sReturn, sEmptyChar;
		boolean bKeepCheck;
		int iLeftChar, i, iLength;
		sReturn = "";
		sRemain = sSend;
		bKeepCheck = true;
		while (bKeepCheck) {
			if ((sRemain.length()) > iDesiredLength) {
				switch (iFoldOperation) {
				case 1:
					sSubString = sRemain.substring(0, iDesiredLength - 1);
					sRemain = sRemain.substring(0, iDesiredLength + 1 - 1);
					if (sReturn.equals(""))
						sReturn = sSubString;
					else
						sReturn = sReturn + "~r" + sSubString;
				case 0:
					sReturn = sRemain;
					bKeepCheck = false;
				}
			} else {
				switch (iOperationType) {
				case 0:
					if (sReturn.equals(""))
						sReturn = sRemain;
					else
						sReturn = sReturn + "~r" + sRemain;
				case 1:
					iLength = sRemain.length();
					iLeftChar = iDesiredLength - iLength;
					sEmptyChar = "";
					for (i = 1; i <= iLeftChar; i++) { // 缂哄\u5691浣\u5D88ˉ\u9351\u72B1\u7D85绌烘\u7278
						sEmptyChar = sEmptyChar + " ";
					}
					sRemain = sRemain.substring(0, 2 - 1) + sEmptyChar
							+ sRemain.substring(0, 3 - 1);
					if (sReturn.equals(""))
						sReturn = sRemain;
					else
						sReturn = sReturn + "~r" + sRemain;
				}
				bKeepCheck = false;
			}
		}
		return sReturn;
	}

	public static String MinuteToHour(long iMinute) {
		String sReturn = "";
		long iHourReturn = 0, iMinuteReturn = 0;
		String sHourReturn = "00", sMinuteReturn = "00";
		iHourReturn = iMinute / 60;
		iMinuteReturn = iMinute - iHourReturn * 60;
		if (new Long(iHourReturn).toString().length() < 2)
			sHourReturn = "0" + (new Long(iHourReturn).toString());
		else
			sHourReturn = (new Long(iHourReturn).toString());
		if (new Long(iMinuteReturn).toString().length() < 2)
			sMinuteReturn = "0" + (new Long(iMinuteReturn).toString());
		else
			sMinuteReturn = (new Long(iMinuteReturn).toString());
		sReturn = sHourReturn + ":" + sMinuteReturn;
		if (sReturn.equals("00:00"))
			sReturn = "";
		return sReturn;
	}

	public static int wf_getherecounts(String sLocationsendA) {
		int i = 0, iLen = 0, iCountA = 0;
		String s = "";
		iLen = sLocationsendA.length();
		iCountA = 0;
		for (i = 1; i <= iLen; i++) {
			s = sLocationsendA.substring(i - 1, i);
			if (s.equals("L") || s.equals("R"))
				iCountA++;

		}
		return iCountA;
	}

	public static String addFormat(String str) {
		if (str != null && !str.equals("")) {
			if (!str.substring(0, 1).equals(",")) {
				str = "," + str;
			}
			if (!str.substring(str.length() - 1, str.length()).equals(",")) {
				str = str + ",";
			}
		}
		return str;
	}

    public static final Integer parseInteger(Object oldData) {
        if (oldData == null||"".equals(String.valueOf(oldData).trim())) {
            return null;
        } else {
            return new Integer(String.valueOf(oldData).trim());
        }

    }
    public static final Long parseLong(Object oldData) {
       if (oldData == null||"".equals(String.valueOf(oldData).trim())) {
           return null;
       } else {
           return new Long(String.valueOf(oldData).trim());
       }

    }


    public static String explodeArrayString(String[] str, String escapeStr,String strflag) {
        if (str == null)return null;
        if (str.length == 0)return "";
        String result = "";
        for (int i = 0; i < str.length; i++) {
            result = result + strflag+str[i]+strflag + escapeStr;
        }
        result = result.substring(0, result.length() - escapeStr.length());
        return result;

    }

	public static String formatLinker(String linker) {
		if (linker == null) {
			return "";
		}
		try {
			linker = linker.substring(0, linker.length() - 3);
			linker = linker.substring(0, 4) + "-" + linker.substring(4, 6) + "-"
					+ linker.substring(6, 8) + " " + linker.substring(8, 10) + ":"
					+ linker.substring(10, 12) + ":" + linker.substring(12, 14);
			return linker;
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 删除最后一个逗号
	 * 
	 * @param value 值
	 * @return 去掉最后一个逗号的值
	 */
	public static String deleteLastChar(String inputValue, char tempChar) {
		if (inputValue == null) {
			return inputValue;
		}
		StringBuffer value = new StringBuffer(inputValue);
		if (value != null && value.length() > 0 && value.charAt(value.length() - 1) == tempChar) {
			value.deleteCharAt(value.length() - 1);
		}
		return value.toString();
	}

	public static String formatSqlInStr(String inputValue) {
		if (inputValue == null || inputValue.trim().length() == 0) {
			return inputValue;
		}

		String[] ids = inputValue.split(",");
		StringBuffer idBuf = new StringBuffer();
		for (int i = 0; i < ids.length; i++) {
			idBuf.append("'");
			idBuf.append(ids[i]);
			idBuf.append("',");

		}

		return "(" + deleteLastChar(idBuf.toString(), ',') + ")";
	}

   public static final String replaceOutString(String outstring) {
       outstring = StringUtils.replace(outstring,","," ");
       outstring = StringUtils.replace(outstring,"\r\n"," ");
       outstring = StringUtils.replace(outstring,"\""," ");
       outstring = StringUtils.replace(outstring,"\t"," ");

       return outstring;
    }
   public static final String replace0(Object obj){
       if(obj==null||"0".equals(String.valueOf(obj))){
           return "-";
       }
       return String.valueOf(obj);
   }

}
