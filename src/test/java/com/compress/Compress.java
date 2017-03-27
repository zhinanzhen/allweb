package com.compress;

public class Compress {
	public static String tempString = "001002003004005006007008009010011012013014015016017018019020021022023024025026027028029030031032033034035036037038039040041042043044045046047048049050051052053054055056057058059060061062063064065066067068069070071072073074075076077078079080081082083084085086087088089090091092093094095096097098099100101102103104105106107108109110111112113114115116117118119120121122123124125126127128";

	public static void main(String[] args) {
		System.out.println("压缩前字符串内容：" + tempString);
		System.out.println("压缩前字符串大小:" + tempString.length());
		System.out.println("-------------------------------------------");
		String resultString = compactString(tempString);
		System.out.println("压缩后字符串内容：" + resultString);
		System.out.println("压缩后字符串大小：" + resultString.length());
		System.out.println("-------------------------------------------");
		String convertString = decompressionString(resultString);
		System.out.println("解压后字符串内容：" + convertString);
		System.out.println("解压后字符串大小：" + convertString.length());
	}

	/**
	 * 通过接口compactString()的压缩方式进行解压
	 * 
	 * @param tempString
	 * @return
	 */
	public static String decompressionString(String tempString) {
		char[] tempBytes = tempString.toCharArray();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < tempBytes.length; i++) {
			char c = tempBytes[i];
			char firstCharacter = (char) (c >>> 8);
			char secondCharacter = (char) ((byte) c);
			sb.append(firstCharacter);
			if (secondCharacter != 0)
				sb.append(secondCharacter);
		}
		return sb.toString();
	}

	/**
	 * 对需要进行压缩的字符串进行压缩，返回一个相对较小的字符串
	 * 
	 * @param tempString
	 * @return
	 */
	public static String compactString(String tempString) {
		StringBuffer sb = new StringBuffer();
		byte[] tempBytes = tempString.getBytes();
		for (int i = 0; i < tempBytes.length; i += 2) {
			char firstCharacter = (char) tempBytes[i];
			char secondCharacter = 0;
			if (i + 1 < tempBytes.length)
				secondCharacter = (char) tempBytes[i + 1];
			firstCharacter <<= 8;
			sb.append((char) (firstCharacter + secondCharacter));
		}
		return sb.toString();
	}

}
