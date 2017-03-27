package com.foundation.io.system;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			// 一次创建PrintStream输出流
			fis = new FileInputStream(RedirectOut.class.getResource("RedirectIn.class").getPath());
			// 将标准输出重定向到pis输入流
			System.setIn(fis);
			// 使用System.in创建Scanner对象,用于获取标准输入
			Scanner sc = new Scanner(System.in);
			// 增加下面一行将只把回车作为分隔符
			sc.useDelimiter("\n");
			// 判断是否还有下一个输入项
			while (sc.hasNext()) {
				// 输出输入项
				System.out.println("键盘输入的内容是:" + sc.next());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
