package com.thinkinginjava.thirteen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPattern {
	public static void main(String[] args) {
		Pattern compile = Pattern.compile("\\S");
		Matcher matcher = compile.matcher("sdfsdf");
		String replaceAll = matcher.replaceAll("=!");
		System.out.println("replaceAll : " + replaceAll);
		boolean b1 = matcher.matches();
		System.out.println(b1);
		
		boolean b2 = Pattern.matches("a*", "abc");
		System.out.println(b2);
		
		
		
		System.out.println("------------------------");
		compile = Pattern.compile("(\\d+,)(\\d+)");
		String s = "123,456-34,345";
		Matcher m = compile.matcher(s);
		while (m.find()) {
			System.out.println(m.group()+":" + m.group(1) + ":" + m.group(2));
		}
		System.out.println(m.groupCount());
		
	}
}
