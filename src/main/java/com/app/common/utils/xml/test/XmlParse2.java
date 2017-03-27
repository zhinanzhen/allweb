package com.app.common.utils.xml.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

public class XmlParse2 {
	public static void main(String[] args) throws IOException {
		File file = new File("D:/abx.txt");
		File file2 = new File("D:/abx22.txt");
		
		InputStream inputStrean = new FileInputStream(file);
		byte [] b = new byte[1024];
		OutputStream outputStream = new FileOutputStream(file2);
		int index ;
		while((index = inputStrean.read(b)) != -1){
			outputStream.write(b,0,index);
			outputStream.flush();
		}
		inputStrean.skip(0);
		System.out.println(inputStrean.available());
		Reader inReader = new InputStreamReader(inputStrean,"ISO-8859-1");
		BufferedReader reader = new BufferedReader(inReader);
		String  thisLine = null;
		while ((thisLine = reader.readLine()) != null) {
			System.out.println(thisLine);
		}
		reader.close();
		inReader.close();
		inputStrean.close();
	}
}
