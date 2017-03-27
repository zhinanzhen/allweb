package com.app.common.utils;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 验证工具类
 * @author: wangjinping
 * @version: 1.0
 */
public class ValidateUtils {
	
    // 加权因字数
	private static final int[] WI = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
	
	// 代码
	private static final char[] CODE = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

	/**
	 * 检查身份证是否合法
	 * @param card 身份证号码
	 * @return 是/否
	 */
	public static boolean isIdCard(String card) {
		if(card.length() == 15 && Pattern.matches("^\\d{15}$", card)) {
			card = card15$18(card);
		}
		if(card.length() == 18 && isDate(card)) {
			card = card.toUpperCase();
			if(Pattern.matches("^\\d{17}[xX]|\\d{18}$", card)) {
				char[] chars = card.toCharArray();
				int si = 0;
				for(int i = 0; i < 17; i++) {
					si += (chars[i] - '0') * WI[i];
				}
				return chars[17] == CODE[si % 11];
			}
			return false;
		}
		return false;
	}
	
	private static boolean isDate(String card) {
		String y = card.substring(6, 10);
		String m = card.substring(10, 12);
		String d = card.substring(12, 14);
		String date = y + "-" + m + "-" + d;
		Pattern p = Pattern.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		return p.matcher(date).matches();
	}
	 
	/**
	 * 身份证15位转18位
	 * @param $15 15位身份证号码
	 * @return 18位身份证号码
	 */
	public static String card15$18(String $15) {
		try {
			if($15.length() == 15){
				int si = 0;
				StringBuffer $18 = new StringBuffer();
				$18.append($15.substring(0, 6));
				$18.append("19");
				$18.append($15.substring(6, 15));
				for(int i = 0; i < 17; i++) { 
					si += ($18.charAt(i) - '0') * WI[i]; 
				}
				$18.append(CODE[si % 11]);
				return $18.toString();
			}
		} catch (Exception ex) {
			return null;
		}
		return $15;
	}

	/**
	 * 判断是否为整数
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		return pattern.matcher(str).matches();
	}
	
	/**
	 * 判断是否为有效的金额字段，支持正负表示'+'、'-'
	 * @param str 传入的字符串
	 * @return 是整数返回true,否则返回false
	 */
	public static boolean isValidMoney(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?\\d+(\\.\\d{1,2})?$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为浮点数，包括double和float
	 * @param str 传入的字符串
	 * @return 是浮点数返回true,否则返回false
	 */
	public static boolean isDouble(String str) {
		Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否符合Email样式.
	 * @param str 传入的字符串
	 * @return 是Email样式返回true,否则返回false
	 */
	public static boolean isEmail(String str) {
		Pattern pattern = Pattern.compile("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断输入的字符串是否为纯汉字
	 * @param str 传入的字符窜
	 * @return 如果是纯汉字返回true,否则返回false
	 */
	public static boolean isChinese(String str) {
		Pattern pattern = Pattern.compile("[\u0391-\uFFE5]+$");
		return pattern.matcher(str).matches();
	}

	/**
	 * 判断是否为质数
	 * @param x
	 * @return
	 */
	public static boolean isPrime(int x) {
		if (x <= 7) {
			if (x == 2 || x == 3 || x == 5 || x == 7)
				return true;
		}
		int c = 7;
		if (x % 2 == 0)
			return false;
		if (x % 3 == 0)
			return false;
		if (x % 5 == 0)
			return false;
		int end = (int) Math.sqrt(x);
		while (c <= end) {
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 4;
			if (x % c == 0) {
				return false;
			}
			c += 6;
			if (x % c == 0) {
				return false;
			}
			c += 2;
			if (x % c == 0) {
				return false;
			}
			c += 6;
		}
		return true;
	}

	/**
	 * 判断是不是合法手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]{9}$");
		return pattern.matcher(mobile).matches();
	}
	
	/**
	 * 是否为座机 (010-66571346)
	 * @param phone
	 * @return
	 */
	public static boolean isPhone(String phone) {
		Pattern pattern = Pattern.compile("^0[0-9]{2,3}[-|－][0-9]{7,8}([-|－][0-9]{1,4})?$");
		return pattern.matcher(phone).matches();
	}
	
	/**
	 * 是否为邮编
	 * @param phone
	 * @return
	 */
	public static boolean isPost(String post) {
		Pattern pattern = Pattern.compile("^[0-9]{6}$");
		return pattern.matcher(post).matches();
	}
	/**
	 * 是否为url
	 * @param url
	 * @return
	 */
	public static boolean isURL(String url) {
		Pattern pattern = Pattern.compile("^(https?|ftp):\\/\\/(((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:)*@)?(((\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d|[1-9]\\d|1\\d\\d|2[0-4]\\d|25[0-5]))|((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?)(:\\d*)?)(\\/((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)+(\\/(([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)*)*)?)?(\\?((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|[\\uE000-\\uF8FF]|\\/|\\?)*)?(\\#((([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(%[\\da-f]{2})|[!\\$&'\\(\\)\\*\\+,;=]|:|@)|\\/|\\?)*)?$");
		return pattern.matcher(url).matches();
	}
	
	/**
	 * 是否为合法IP地址
	 * @param ip
	 * @return
	 */
	public static boolean isIP(String ip) {
		Pattern pattern = Pattern.compile("^(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])$");
		return pattern.matcher(ip).matches();
	}
	
	/**
	 * 是否为合法MAC地址，验证十六进制格式
	 * @param mac
	 * @return
	 */
	public static boolean isMac(String mac) {
		Pattern pattern = Pattern.compile("^([0-9a-fA-F]{2})(([\\s:-][0-9a-fA-F]{2}){5})$");
		return pattern.matcher(mac).matches();
	}
	
	/**
	 * 是否为合法的银行卡号
	 * @param bankCard 银行卡号
	 * @return
	 */
	/*public static boolean isBankCard(String bankCard) {
		if(!StringUtils.isBlank(bankCard)) {
			String nonCheckCodeCardId = bankCard.substring(0, bankCard.length() - 1);
			if (nonCheckCodeCardId.matches("\\d+")) {
				char[] chs = nonCheckCodeCardId.toCharArray();
				int luhmSum = 0;
				for (int i = chs.length - 1, j = 0; i >= 0; i--, j++) {
					int k = chs[i] - '0';
					if (j % 2 == 0) {
						k *= 2;
						k = k / 10 + k % 10;
					}
					luhmSum += k;
				}
				char b = (luhmSum % 10 == 0) ? '0' : (char) ((10 - luhmSum % 10) + '0');
				return bankCard.charAt(bankCard.length() - 1) == b;
			}
		}
		return false;
	}*/

	/**
	 * 检查字符串长度是否小于最小长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param minLength
	 *            最小长度
	 * @param message
	 *            异常信息
	 */
	public static void checkStrMinLength(String str, Integer minLength,
			String message) {
		if (str.trim().length() < minLength) {
			throw new IllegalArgumentException(message);
		}
	}

	/**
	 * 检查字符串是否大于最大长度
	 * 
	 * @param str
	 *            待检查的字符串
	 * @param maxLength
	 *            最大长度
	 * @param message
	 *            异常信息
	 */
	public static void checkStrMaxLength(String str, Integer maxLength,
			String message) {
		if (str.trim().length() > maxLength) {
			throw new IllegalArgumentException(message);
		}
	}
	
	
	/**
	 * 验证对象是否为空
	 * @param obj 被验证的对象
	 * @param message 异常信息
	 */
	public static void checkNotNull(Object obj, String message) {
		if (obj == null){
			throw new IllegalArgumentException(message);
		}
	}
	
	
	/**
	 * 验证对象是否为NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
	 * @param obj 被验证的对象
	 * @param message 异常信息
	 */
	@SuppressWarnings("rawtypes")
	public static void checkNotEmpty(Object obj, String message) {
		if (obj == null){
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof String && obj.toString().trim().length()==0){
			throw new IllegalArgumentException(message);
		}
		if (obj.getClass().isArray() && Array.getLength(obj)==0){
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof Collection && ((Collection)obj).isEmpty()){
			throw new IllegalArgumentException(message);
		}
		if (obj instanceof Map && ((Map)obj).isEmpty()){
			throw new IllegalArgumentException(message);
		}
	}
	
	/**
	 * 判断参数否非空
	 * @param obj
	 * @param message
	 * @return
	 */
	public static boolean isNull(Object obj){
		if (obj == null){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断参数是否非NULL,空字符串，空数组，空的Collection或Map(只有空格的字符串也认为是空串)
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isEmpty(Object obj){
		if (obj == null){
			return true;
		}
		if (obj instanceof String && obj.toString().trim().length()==0){
			return true;
		}
		if (obj.getClass().isArray() && Array.getLength(obj)==0){
			return true;
		}
		if (obj instanceof Collection && ((Collection)obj).isEmpty()){
			return true;
		}
		if (obj instanceof Map && ((Map)obj).isEmpty()){
			return true;
		}
		return false;
	}
	
	public static boolean isDateStringValid(String date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);//"yyyy-MM-DD"
		// 输入对象不为空
		try {
			sdf.parse(date);
			return true;
		} catch (java.text.ParseException e) {
			return false;
		}
	}

	
	
	/**
	 * 判断对象是否不为空
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isNotEmpty(Object obj){
		if (obj == null){
			return false;
		}
		if (obj instanceof String && obj.toString().trim().length()==0){
			return false;
		}
		if (obj.getClass().isArray() && Array.getLength(obj)==0){
			return false;
		}
		if (obj instanceof Collection && ((Collection)obj).isEmpty()){
			return false;
		}
		if (obj instanceof Map && ((Map)obj).isEmpty()){
			return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
//		System.out.println(isDateStringValid("20141105", "yyyyMMdd"));
//		System.out.println(isValidMoney("--122"));
//		System.out.println(isValidMoney("++122"));
		
		System.out.println(isDouble("122.01"));
	}
}
