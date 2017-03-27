package com.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

public class RegexTest extends TestCase {
	private static final Logger log = Logger.getLogger(RegexTest.class);
	public void test_1(){
		//将给定的正则表达式编译到模式中
		Pattern pattern = Pattern.compile("^[+]?(([1-9]\\d*[.]?)|(0.))(\\d{0,2})?$");
		System.out.println(pattern.pattern());
		log.info(pattern.flags());
		Matcher matcher = pattern.matcher("3.44");
		System.out.println(matcher.matches());
		// 等价于上面的 Pattern.compile  --  pattern.matcher  --   matcher.matches()
		System.out.println(Pattern.matches("^[+]?(([1-9]\\d*[.]?)|(0.))(\\d{0,2})?$", "3.44"));
	}
	public void test_2(){
		Pattern pattern = Pattern.compile("re\b");
		String[] split = pattern.split("how old are you");
		for (String string : split) {
			System.out.println(string);
		}
	}
	
	public void test_3(){
		String str1 = "A pencil and 4444 a dream can take you anywhere.";
		String str2 = "It is during our darkest moments 455 w 4666 that we must focus to see the light.";
		String regex = "(.*)(\\d+)(.*)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str2);
		if(matcher.find()){
			for (int i = 0; i < matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}
}
