package com.compress.zlib;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

/**
 * http://snowolf.iteye.com/blog/465433
 * @author xxn
 * @date 2016年8月5日  上午10:33:09
 */
public class ZLibUtilsTest {
	@Test
	public final void testBytes() {
		System.err.println("字节压缩／解压缩测试");
		String inputStr = "001002003004005006007008009010011012013014015016017018019020021022023024025026027028029030031032033034035036037038039040041042043044045046047048049050051052053054055056057058059060061062063064065066067068069070071072073074075076077078079080081082083084085086087088089090091092093094095096097098099100101102103104105106107108109110111112113114115116117118119120121122123124125126127128";
		System.err.println("输入字符串:\t" + inputStr);
		byte[] input = inputStr.getBytes();
		System.err.println("输入字节长度:\t" + input.length);

		byte[] data = ZLibUtils.compress(input);
		System.err.println("压缩后字节长度:\t" + data.length);

		byte[] output = ZLibUtils.decompress(data);
		System.err.println("解压缩后字节长度:\t" + output.length);
		String outputStr = new String(output);
		System.err.println("输出字符串:\t" + outputStr);

		assertEquals(inputStr, outputStr);
	}

	@Test
	public final void testFile() {
		String filename = "zlib";
		File file = new File(filename);
		System.err.println("文件压缩／解压缩测试");
		String inputStr = "snowolf@zlex.org;dongliang@zlex.org;zlex.dongliang@zlex.org";
		System.err.println("输入字符串:\t" + inputStr);
		byte[] input = inputStr.getBytes();
		System.err.println("输入字节长度:\t" + input.length);

		try {

			FileOutputStream fos = new FileOutputStream(file);
			ZLibUtils.compress(input, fos);
			fos.close();
			System.err.println("压缩后字节长度:\t" + file.length());
		} catch (Exception e) {
			fail(e.getMessage());
		}

		byte[] output = null;

		try {
			FileInputStream fis = new FileInputStream(file);
			output = ZLibUtils.decompress(fis);
			fis.close();

		} catch (Exception e) {
			fail(e.getMessage());
		}
		System.err.println("解压缩后字节长度:\t" + output.length);
		String outputStr = new String(output);
		System.err.println("输出字符串:\t" + outputStr);

		assertEquals(inputStr, outputStr);
	}
}
