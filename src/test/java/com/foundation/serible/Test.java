package com.foundation.serible;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Test {
	//对person实例序列化
	public static void serilizable(Person person, String writePath) throws IOException{
			FileOutputStream fileOutputStream = new FileOutputStream(new File(writePath));
			ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
			outputStream.writeObject(person);
			outputStream.close();
		}
		
		//反序列化
		public static Person unSerilizable(String filePath) throws ClassNotFoundException, IOException{
			FileInputStream fileInputStream = new FileInputStream(new File(filePath));
			ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
			Person person = (Person_Serible) inputStream.readObject();
			inputStream.close();
			return person;
		}
		
		public static void main(String[] args) {
			Person person = new Person_Serible();
			person.setName("zhangsan");
			person.setAge(15);
			
			try {
				Test.serilizable(person, "D:\\person.txt");//序列化为磁盘文件
				Person person2 = Test.unSerilizable("D:\\person.txt");//从磁盘文件读出来序列化文件
				System.out.println(person2.getName() + "\t" + person2.getAge());
			}  catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
}
