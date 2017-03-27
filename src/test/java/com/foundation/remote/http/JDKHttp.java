package com.foundation.remote.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class JDKHttp {
	public static void get() throws Exception {
		URL url = new URL("https://www.baidu.com/");
		URLConnection urlConnection = url.openConnection(); // 打开连接
		BufferedReader br = new BufferedReader(new InputStreamReader(
				urlConnection.getInputStream(), "utf-8")); // 获取输入流
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
		}

		System.out.println(sb.toString());
	}

	public static void post() throws IOException {

		URL url = new URL("https://www.baidu.com/");
		HttpURLConnection httpURLConnection = (HttpURLConnection) url
				.openConnection();

		httpURLConnection.setDoInput(true);
		httpURLConnection.setDoOutput(true); // 设置该连接是可以输出的
		httpURLConnection.setRequestMethod("POST"); // 设置请求方式
		httpURLConnection.setRequestProperty("charset", "utf-8");

		PrintWriter pw = new PrintWriter(new BufferedOutputStream(
				httpURLConnection.getOutputStream()));
		pw.write("name=welcome"); // 向连接中输出数据（相当于发送数据给服务器）
		pw.write("&age=14");
		pw.flush();
		pw.close();

		BufferedReader br = new BufferedReader(new InputStreamReader(
				httpURLConnection.getInputStream(), "utf-8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while ((line = br.readLine()) != null) { // 读取数据
			sb.append(line + "\n");
		}

		System.out.println(sb.toString());
	}
	
	public static void main(String[] args) throws Exception {
		get();
	}
}
