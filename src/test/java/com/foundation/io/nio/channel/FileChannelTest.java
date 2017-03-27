package com.foundation.io.nio.channel;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 1. 从FileInputStream获取Channel 
 * 2. 创建Buffer 
 * 3. 将数据从Channel读取到Buffer中
 * @author xxn
 * @date 2016年4月21日  下午7:14:04
 */
public class FileChannelTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("d:\\haha.txt");
		FileChannel channel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		channel.read(buffer);
		buffer.flip();
		System.out.println(buffer.limit());
		System.out.println(buffer.position());
		while (buffer.remaining() > 0) {
			byte b = buffer.get();
			System.out.print((char)b);
		}
		fis.close();
	}
}
