package com.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestHarness {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("Enter your regex:");
			String regex = s.next();
			Pattern pattern = Pattern.compile(regex);
			System.out.println("Enter input string to search: ");
			String str = s.next();
			Matcher matcher = pattern.matcher(str);
			boolean found = false;
			while (matcher.find()) {
				System.out.println("I found the text :"+matcher.group()+"\r\n starting at index: "+ matcher.start()
						+ "and ending at index:"+ matcher.end());
				found = true;
			}
			if (!found) {
				System.out.println("No match found.%n");
			}
		}
	}
}
