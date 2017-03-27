package com.app.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

/**
 * @create 2007-7-9
 */
@SuppressWarnings("restriction")
public class StringUtil {
	/**
	 * use to add zero behand the code which length is less then length.
	 * 
	 * @param oldStr
	 *            String 原字符串
	 * @param length
	 *            int 指定长度
	 * @return String 新字符串
	 */
	public static String addZero(String oldStr, int length) {
		String newStr = "";
		newStr = oldStr;

		while (newStr.length() < length) {
			newStr = "0" + newStr;
		}
		return newStr;
	}

	/**
	 * 将NULL的对象转换为空串
	 * 
	 * @param obj：要转换的对象
	 * @return
	 */
	public static Object null2blank(Object obj) {
		if (obj == null)
			return "";
		else
			return obj;
	}

	/**
	 * 将NULL的字符串转换为空串
	 * 
	 * @param str：要转换的字符串
	 * @return
	 */
	public static String null2Zero(Object str) {
		if (str == null||"".equals(str))
			return "0";
		else
			return str.toString();
	}
	/**
     * 将NULL或""的字符串转换为0
     * 
     * @param str：要转换的字符串
     * @return
     */
    public static String null2blank(String str) {
        if (str == null)
            return "";
        else
            return str;
    }
	private static String temp = "";

	/**
	 * 同String replaceAll(String str1, String str2)
	 * 
	 * @param str：要操作的串
	 * @param oldStr：原串
	 * @param newStr：替换串
	 * @return
	 */
	public static String replaceAll(String str, String oldStr, String newStr) {
		int index = str.indexOf(oldStr);
		if (index < 0) {
			return temp + str;
		} else {
			String first = str.substring(0, index);
			// String second = str.substring(index, index + oldStr.length());
			String third = str.substring(index + oldStr.length());

			// String rtVal = first + newStr + third;
			temp += first + newStr;
			return replaceAll(third, oldStr, newStr);
		}
	}

	/**
	 * 将数组转为指定分割符分割的字符串
	 * 
	 * @param strs：数组
	 * @param delim：分割符
	 * @return
	 */
	public static String array2String(String[] strs, String delim) {
		if (strs == null || strs.length < 1)
			return "";
		if (delim == null)
			delim = ",";

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i] + delim);
		}

		String str = sb.toString();
		return str.substring(0, str.length() - delim.length());
	}

	public static String changEncode(String html) {
		if (html == null) {
			html = "";
		}
		StringBuffer sb = new StringBuffer(html.length() + html.length() / 4);
		for (int i = 0; i < html.length(); i++) {
			char ch = html.charAt(i);
			switch (ch) {
			case '\n':
				sb.append("<br>");
				break;
			case '<':
				sb.append("&lt;");
				break;
			case '>':
				sb.append("&gt;");
				break;
			case ' ':
				sb.append("&nbsp;");
				break;
			default:
				sb.append(ch);
			}
		}
		String value = sb.toString();
		return value;
	}

	/**
	 * 字符串是否是整数
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if (!isNum.matches()) {
			return false;
		}
		return true;
	}

	/**
	 * 将空串转换为NULL的字符串
	 * 
	 * @param str：要转换的字符串
	 * @return
	 */
	public static String blank2null(String str) {
		if (str != null && str.trim().length() == 0)
			return null;
		else
			return str;
	}

	public static Date StrToDate(String args) {
		Date date1 = null;
		try {
			date1 = Date.valueOf(args);
			return date1;
		} catch (ParseException e) {
			return null;
		}

	}
	
	public static String lpadStr(String str,int length,String padStr){
		String desStr = "";
		if(str==null||"".equals(str)){
			for(int i = 0; i < length; ++i){
				desStr += padStr;
			}
			return desStr;
		}
		else if(str.length()>=length){
			desStr = str.substring(0, length);
			return desStr;
		}
		else{
			desStr = str;
			for(int i = 0; i < length-str.length(); ++i){
				desStr = padStr+desStr;
			}
			return desStr;
		}
	}
	
	public static void main(String[] args){
//		String dnValue = "CN=041@@4065697402A@00000002, OU=Enterprises, OU=HXB, O=CFCA Operation CA2, C=CN";
//		String userVodnValue = "CN=041@@4065697402A@00000002, OU=Enterprises, OU=HXB, O=CFCA Operation CA2, C=CN";
//		System.out.println(dnValue.equals(userVodnValue));
	}
	
	
	/**
	 * 功能：判断字符串是否为空串或空值
	 * @param targetStr
	 * @return 返回：非空返回true，否则为false。
	 */
	public static boolean isNull(String targetStr){
		if (targetStr==null||"".equals(targetStr)) {
			return true;
		}
		return false;
	}
	
	
	
	/**
	 * 功能：判断字符串是否为空串或空值
	 * @param targetStr
	 * @return 返回：非空返回true，否则为false。
	 */
	public static boolean notNull(String targetStr){
		if (targetStr==null||"".equals(targetStr)) {
			return false;
		}
		return true;
	}
	
	
	
	
	/**
	 * 功能：判断字符串是否为0
	 * @param str
	 * @return
	 */
	public static boolean isZero(String str){
		str = str==null?"1":str;
		BigDecimal decimal = new BigDecimal(str);
		return decimal.compareTo(new BigDecimal(0))==0?true:false;
	}

	
	
	
	/**
	 * 功能：判断字符串是否不为0
	 * @param str
	 * @return
	 */
	public static boolean isNotZero(String str){
		BigDecimal decimal = new BigDecimal(str);
		return decimal.compareTo(new BigDecimal(0))==0?false:true;
	}
	
	
	
	/**
	 * 功能：求两个数的合
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String addFen(String str1 , String str2){
		return new BigDecimal(str1).add(new BigDecimal(str2)).toBigInteger().toString();
	}
	
	
	

	/**
	 * 功能：求两个数的合
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String addYuan(String str1 , String str2){
		return new BigDecimal(str1).add(new BigDecimal(str2)).toString();
	}

	
	/**
	 * 比较两个字符串金额，第一个是否比第二个大。
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean whoBig(String str1, String str2){
		BigDecimal b1 = new BigDecimal(str1);
		BigDecimal b2 = new BigDecimal(str2);
		return b1.compareTo(b2)>0?true:false;
	}
	
	
	
	
	/**
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static String calcCha(String str1, String str2){
		BigDecimal b1 = new BigDecimal(str1);
		BigDecimal b2 = new BigDecimal(str2);
		return b1.subtract(b2).toString();
	}
	
	
	
	/**
	 * 解码GET方法传递的参数
	 * @param param
	 * @return
	 */
	public static String decodeForGetRequest(String param){
		try {
			return new String(param.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	
	
	
	/**
	 * 获得千分位格式的金额
	 * @param str
	 * @return
	 */
	public static String getStringToQfw(String amount){
		return DecimalFormat.getNumberInstance().format(new BigDecimal(amount));
	}
	
	/**
	 * 字符串转换为空串
	 * 
	 * @param str：要转换的字符串
	 * @return
	 */
	public static String stringToTrim(Object str) {
		if (str == null||"".equals(str))
			return "";
		else
			return str.toString().trim();
	}
	
	/**
	 * 
	 * @功能描述：DNvalue转为接口识别的DN值
	 * @developer：常广伟
	 * @date：2015年9月8日 下午5:39:09
	 * @param dnValue
	 * @return
	 * String
	 */
	public static String dnValueTOLower(String dnValue){
		if(ValidateUtils.isEmpty(dnValue)){
			return null;
		}
		return   dnValue.replaceAll("CN=", "cn=").replaceAll("OU=", "ou=").replaceAll("O=", "o=").replaceAll("C=", "c=").replaceAll(", ", ",");
	}
}
