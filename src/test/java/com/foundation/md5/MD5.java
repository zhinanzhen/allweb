package com.foundation.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5 {
	public static final String encryptMD5(byte[] source) {
		byte[] resByteArray;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.reset();
			md.update(source);
			resByteArray = md.digest();
			StringBuffer sb = new StringBuffer(resByteArray.length << 1);
			for (int i = 0; i < resByteArray.length; i++) {
				String digit = Integer.toHexString(0xFF & resByteArray[i]);
				if (digit.length() == 1) {
					digit = '0' + digit;
				}
				sb.append(digit);
			}
			return sb.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
		}
		return null;
	}
	public static void main(String[] args) {
		String encryptMD5 = encryptMD5("sdfsdfsdf".getBytes());
		System.out.println(encryptMD5);
	}
}
