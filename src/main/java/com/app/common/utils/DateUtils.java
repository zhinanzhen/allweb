package com.app.common.utils;

import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateUtils {

	public static final String _YYYYMMDDHHMMSSSS_STR = "yyyyMMddHHmmssSS";
	public static final String _YYYYMMDDHHMMSS_STR = "yyyyMMddHHmmss";
	public static final String _YYYYMMDD_STR = "yyyyMMdd";
	public static final String _YYYYMM_STR = "yyyyMM";
	public static final String _YYYY_STR = "yyyy";

	public static final String YYYYMMDDHHMMSS_STR1 = "yyyy-MM-dd HH:mm:ss";
	public static final String _YYYYMMDD_STR1 = "yyyy-MM-dd";

	public static final String _DEFAULT_FROMAT = "yyyyMMdd";// 默认时间格式

	public static final int _DEFAULT_DAYS = 0;

	public static String countDate(String sdate, int days, String dateFormat) throws ParseException {
		if (ValidateUtils.isEmpty(sdate) || ValidateUtils.isEmpty(dateFormat)) {
			// 不处理直接返回
			return sdate;
		}
		// 1.转换日期格式 (string -> java.util.date)
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = sdf.parse(sdate);

		// 2.设置日历时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.DAY_OF_MONTH, days);// 取当前日期的前几天

		// 通过格式化输出日期
		return sdf.format(cal.getTime());
	}

	/**
	 * 判断时间是否过期
	 * 
	 * @param srcTime
	 *            : 源时间
	 * @param days
	 *            : 几天之后
	 * @return
	 */
	public static boolean isOverdue(String srcTime, int days) {

		if (ValidateUtils.isEmpty(srcTime)) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar cd = Calendar.getInstance();

		try {
			cd.setTime(sdf.parse(srcTime));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cd.add(Calendar.DATE, days);

		String endate = sdf.format(cd.getTime());
		System.out.println(" limit: " + sdf.format(cd.getTime()));

		Date now = new Date();
		String today = sdf.format(now);

		int _today = Integer.parseInt(today);
		int _endate = Integer.parseInt(endate);
		if (_today >= _endate) {
			System.out.println("已到期");
			return true;
		} else {
			System.out.println("还没到期");
			return false;
		}
	}

	/**
	 * 计算日期差
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static int countDaysBetween(Calendar d1, Calendar d2) {
		if (d1.after(d2)) { // swap dates so that d1 is start and d2 is end
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		int days = d2.get(java.util.Calendar.DAY_OF_YEAR) - d1.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = d2.get(java.util.Calendar.YEAR);
		if (d1.get(java.util.Calendar.YEAR) != y2) {
			d1 = (java.util.Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				d1.add(java.util.Calendar.YEAR, 1);
			} while (d1.get(java.util.Calendar.YEAR) != y2);
		}
		return days;
	}

	public static long dateDiff(String startTime, String endTime, String format) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
		long diff;
		long day = 0;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(endTime).getTime() - sd.parse(startTime).getTime();
			day = diff / nd;// 计算差多少天

		} catch (ParseException e) {
			e.printStackTrace();
		}
		return day;
	}
	/**
	 * @Description 计算两个日期谁大
	 * @param @param FristTime
	 * @param @param SecondTime
	 * @param @param format
	 * @param @return    参数
	 * @return long    返回类型
	 * @throws
	 */
	public static int whoBig(String FristTime, String SecondTime, String format) {
		// 按照传入的格式生成一个simpledateformate对象
		SimpleDateFormat sd = new SimpleDateFormat(format);
		long diff = 0;
		try {
			// 获得两个时间的毫秒时间差异
			diff = sd.parse(FristTime).getTime() - sd.parse(SecondTime).getTime();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		if(diff > 0){
			return 1;
		}else if(diff == 0){
			return 0;
		}else{
			return -1;
		}
	}
	/**
	 * @Description 日期增加天数
	 * @param @param FristTime
	 * @param @param SecondTime
	 * @param @param format
	 * @param @return    参数
	 * @return long    返回类型
	 * @throws
	 */
	public static String addDays(String OneTime, int days, String format) {
		
		java.util.Calendar Cal = java.util.Calendar.getInstance();
		DateFormat df = new SimpleDateFormat(format);
		try {
			Cal.setTime(df.parse(OneTime));
			Cal.add(Calendar.DATE, days); //

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return df.format(Cal.getTime());
	}
	
	
	
	/**
	 * 计算日期差
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * @throws ParseException
	 */
	public static int countDaysBetween(String sdate, String edate, String dateFormat) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date dateStart = sdf.parse(sdate);
		Date dateEnd = sdf.parse(edate);
		Calendar startCal = Calendar.getInstance();
		Calendar endCal = Calendar.getInstance();
		startCal.setTime(dateStart);
		endCal.setTime(dateEnd);
		return countDaysBetween(startCal, endCal);
	}

	/**
	 * 得到当前日期字符串yyyyMMdd
	 * 
	 * @return String
	 */

	public static String getNowDate() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMdd");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到当前时间字符串yyyyMMddHHmmss
	 * 
	 * @return String
	 */
	public static String getNowTime() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到当前时间字符串yyyyMM
	 * 
	 * @return String
	 */
	public static String getNowMouth() {
		return getNowMouth("yyyyMM");
	}

	public static String getNowMouth(String pattern) {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat(pattern);
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到当前时间字符串yyyy
	 * 
	 * @return String
	 */
	public static String getNowYeer() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 得到当前时间字符串yyyyMMddHHmmssSS 毫秒级别
	 * 
	 * @return String
	 */
	public static String getNowTimeInMillis() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmssSS");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 返回格式为"yyyyMMddHHmmssSS"的唯一当前时间
	 */
	public synchronized static String uniqueTime() {
		Date date = new Date();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");
		return sdf.format(date);
	}

	public static boolean isRegularDate(String str_input, String rDateFormat) {
		if (str_input != null && !"".equals(str_input)) {
			SimpleDateFormat formatter = new SimpleDateFormat(rDateFormat);
			formatter.setLenient(false);
			try {
				formatter.format(formatter.parse(str_input));
			} catch (Exception e) {
				return false;
			}
			return true;
		} else {
			return false;
		}

	}

	public static boolean isDate(String str_input, String rDateFormat) {

		if (ValidateUtils.isEmpty(str_input) || ValidateUtils.isEmpty(rDateFormat)) {
			return false;
		}
		String datePattern1 = "";
		if ("yyyyMMdd".equals(rDateFormat)) {
			datePattern1 = "\\d{4}\\d{2}\\d{2}";
		} else if ("yyyy-MM-dd".equals(rDateFormat)) {
			datePattern1 = "\\d{4}-\\d{2}-\\d{2}";
		} else {
			datePattern1 = "\\d{4}\\d{2}\\d{2}";
		}
		String datePattern2 = "^((\\d{2}(([02468][048])|([13579][26]))"
				+ "[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|"
				+ "(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?("
				+ "(((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?"
				+ "((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		if ((str_input != null)) {
			Pattern pattern = Pattern.compile(datePattern1);
			Matcher match = pattern.matcher(str_input);
			if (match.matches()) {
				pattern = Pattern.compile(datePattern2);
				match = pattern.matcher(str_input);
				return match.matches();
			} else {
				return false;
			}
		}
		return false;

	}

	public static String getDateStr(String dateStr) throws RuntimeException {
		try {
			if (ValidateUtils.isEmpty(dateStr)) {
				return dateStr;
			}
			SimpleDateFormat sdf_s = new SimpleDateFormat("yyyyMMdd");
			SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd");
			Date date = sdf_s.parse(dateStr);
			// 通过格式化输出日期
			return sdf_d.format(date);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("日期格式化失败！");
		}
	}

	/**
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static String getDateStrOther(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat sdf_s = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyyMMdd");
		Date date = sdf_s.parse(dateStr);
		// 通过格式化输出日期
		return sdf_d.format(date);
	}

	public static String getMouthStr(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat sdf_s = new SimpleDateFormat("yyyyMM");
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM");
		Date date = sdf_s.parse(dateStr);
		// 通过格式化输出日期
		return sdf_d.format(date);
	}

	public static String getTimeStr(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat sdf_s = new SimpleDateFormat("yyyyMMddHHmmss");
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = sdf_s.parse(dateStr);
		// 通过格式化输出日期
		return sdf_d.format(date);
	}

	public static String getTime14Str(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat sdf_s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = sdf_s.parse(dateStr);
		// 通过格式化输出日期
		return sdf_d.format(date);
	}

	public static String getTimeToDate(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		dateStr = dateStr.substring(0, 8);
		SimpleDateFormat sdf_s = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf_d = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf_s.parse(dateStr);
		// 通过格式化输出日期
		return sdf_d.format(date);
	}

	/**
	 * 功能：将YYYY-MM-dd格式转化为YYYYMMDD格式
	 * 
	 * @param dateStr
	 *            待转换的日期字符串
	 * @return 已YYYYMMDD格式返回
	 * @throws ParseException
	 */
	public static String dateFormat(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat to = new SimpleDateFormat("yyyyMMdd");
		return to.format(from.parse(dateStr));
	}
	/**
	 * 任意两种格式之间的日期格式化
	 * @param date	需格式化的日期
	 * @param sourcePatten	原来的日期格式
	 * @param targetPatten	目标格式
	 * @return
	 * @throws ParseException
	 * String
	 */
	public static String dateFormat(String date,String sourcePatten,String targetPatten){
		if(ValidateUtils.isEmpty(date)){
			return date;
		}
		Format from = new SimpleDateFormat(sourcePatten);
		Format to = new SimpleDateFormat(targetPatten); 
		try {
			return to.format(from.parseObject(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return date;
		}
	}
	/**
	 * 功能：将YYYY-MM格式转化为YYYYMM格式
	 * 
	 * @param dateStr
	 *            待转换的日期字符串
	 * @return 已YYYYMMDD格式返回
	 * @throws ParseException
	 */
	public static String mouthFormat(String dateStr) throws ParseException {
		if (ValidateUtils.isEmpty(dateStr)) {
			return dateStr;
		}
		SimpleDateFormat from = new SimpleDateFormat("yyyy-MM");
		SimpleDateFormat to = new SimpleDateFormat("yyyyMM");
		return to.format(from.parse(dateStr));
	}

	/**
	 * @return 返回："yyyy-MM-dd hh:mm:ss"格式的当前时间
	 */
	public static String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	/**
	 * @return 返回："yyyyMMddHHmmss"格式的当前时间
	 */
	public static String getCurrentTimeNotSlipt() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/**
	 * 获取当前时间几天后的时间
	 * 
	 * @param data
	 * @return
	 */
	public static String getDateAdd(int data) {
		java.util.Calendar Cal = java.util.Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		Cal.add(Calendar.DATE, data); //

		return df.format(Cal.getTime());
	}

	/**
	 * 获取当前时间几天前的日期
	 * 
	 * @param data
	 * @return
	 */
	public static String getDateSub(int data) {
		java.util.Calendar Cal = java.util.Calendar.getInstance();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");

		Cal.add(Calendar.DATE, data); //

		return df.format(Cal.getTime());
	}

	/**
	 * 计算两个月之间的差值
	 * 
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static int getMonthDiffer(String beginTime, String endTime) {
		int difMonth = 0;
		int beginYear = Integer.parseInt(beginTime.substring(0, 4));
		int beginMonth = Integer.parseInt(beginTime.replace("-", "").substring(4, 6));

		int endYear = Integer.parseInt(endTime.substring(0, 4));
		int endMonth = Integer.parseInt(endTime.replace("-", "").substring(4, 6));
		difMonth = (endYear - beginYear) * 12 + (endMonth - beginMonth);
		return difMonth;
	}

	/**
	 * 取得当前日期的前一个月
	 * 
	 * @return
	 */
	public static String getBeforeMonth() {

		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		// 取得上月时间
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		// 设置为上个月
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1);
		return df.format(calendar.getTime());
	}

	/**
	 * 取得当前日期的前N个月
	 * 
	 * @return
	 */
	public static String getBeforeMonth(int month) {

		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");
		// 取得上月时间
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		// 设置为N个月
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - month);
		return df.format(calendar.getTime());
	}

	/**
	 * 取得当前日期的后N个月
	 * 
	 * @return
	 */
	public static String getAfterMonth(int month) {

		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		// 取得上月时间
		java.util.Calendar calendar = java.util.Calendar.getInstance();
		calendar.setTime(new java.util.Date());
		// 设置为N个月
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + month);
		return df.format(calendar.getTime());
	}

	public static String getMonthAdd(String sdate, int month) throws ParseException {
		// 设置日期格式
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date date = df.parse(sdate);
		// 2.设置日历时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		cal.add(Calendar.MONTH, -month);// 取当前日期的前几天
		return df.format(cal.getTime());
	}

	public static void main(String[] args) throws ParseException {
//		String c = getMonthAdd("20140101", 12);
//		System.out.println(c);
//		int ds = getMonthDiffer("20130627", "20140301");
//		int a = countDaysBetween("201403", "201403", "yyyyMMdd");
//		System.out.println(ds);
//		System.out.println(a);
		
		System.out.println(DateUtils.countDaysBetween("20141222","20151111","yyyyMMdd"));
		System.out.println(DateUtils.addDays("20150302",30,"yyyyMMdd"));
		
		
	}

	public static int bettwenDay(String date1, String date2) {
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			long to = df.parse(date1).getTime();
			long from = df.parse(date2).getTime();
			return (int) ((to - from) / (1000 * 60 * 60 * 24));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("");
		}
	}

	/**
	 * 获得当前日期之前或之后第几个月的日期（格式：yyyyMMdd）
	 * 
	 * @param flag
	 *            INT型整数，-1代表之前，1代表之后。
	 * @return
	 */
	public static String getMonth(int flag) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, flag);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String targetDate = sdf.format(cal.getTime());
		return targetDate;
	}

	/**
	 * 获得当前日期之前或之后第几天的日期（格式：yyyyMMdd）
	 * 
	 * @param flag
	 *            INT型整数，-1代表之前，1代表之后。
	 * @return
	 */
	public static String getDate(int flag) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, flag);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String targetDate = sdf.format(cal.getTime());
		return targetDate;
	}

	/**
	 * 获得当前日期之前或之后第几周的日期（格式：yyyyMMdd）
	 * 
	 * @param flag
	 *            INT型整数，-1代表之前，1代表之后。
	 * @return
	 */
	public static String getWeek(int flag) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.WEDNESDAY, flag);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String targetDate = sdf.format(cal.getTime());
		return targetDate;
	}

	/**
	 * 得到当前月份，格式：9 或 10
	 * 
	 * @return String
	 */
	public static String getCurrentMouth() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		String currentMonth = cal.get(Calendar.MONTH) + 1 + "";
		return currentMonth;
	}

	/**
	 * @return 返回："yyyyMMddHHmmss"格式的当前时间
	 */
	public synchronized static String getCurrentTimeMode1() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(date);
	}

	/**
	 * 得到当前日期字符串yyyy-MM-dd
	 * 
	 * @return String
	 */
	public static String getNowDateFmt() {
		Date nowTime = new Date();
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");
		String sysDate = time.format(nowTime);
		return sysDate;
	}

	/**
	 * 获得当前日期之前或之后第几个月的日期（格式：yyyy-MM-dd）
	 * 
	 * @param flag
	 *            INT型整数，-1代表之前，1代表之后。
	 * @return
	 */
	public static String getMonthByFmt(int flag) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.MONTH, flag);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String targetDate = sdf.format(cal.getTime());
		return targetDate;
	}

	
	/**
	 * 
	 * @功能描述：将时间格式化不包含日期
	 * @developer：常广伟
	 * @date：2015年9月28日 下午3:33:32
	 * @param time
	 * @return
	 * @throws ParseException
	 * String
	 */
	public static String getTimeToFmt(String time)throws ParseException  {
		SimpleDateFormat sdf_d = new SimpleDateFormat("HHmmss");
		SimpleDateFormat sdf_s = new SimpleDateFormat("HH:mm:ss");
		Date  date = sdf_d.parse(time);
		// 通过格式化输出日期
		return sdf_s.format(date);
	}
	
	public static Date parse(String source,String pattern){
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
