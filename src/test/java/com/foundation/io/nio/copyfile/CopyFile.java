package com.foundation.io.nio.copyfile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {
	public static void main(String[] args) {
		FileInputStream ins = null;
		FileOutputStream out = null;
		try {
			ins = new FileInputStream("d:/haha.txt");
			out = new FileOutputStream("d:/abx.txt");
			FileChannel inChannel = ins.getChannel();
			FileChannel outChannel = out.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			while(inChannel.read(buffer) != -1){
				// read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
				buffer.flip();
				outChannel.write(buffer);
				buffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				ins.close();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
