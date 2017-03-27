package com.foundation.io.nio.buffer;

import java.nio.IntBuffer;

/**
 * 缓冲区实际上是一个容器对象，更直接的说，其实就是一个数组，在NIO库中，所有数据都是用缓冲区处理的。
 * 在读取数据时，它是直接读到缓冲区中的； 
 * 在写入数据时，它也是写入到缓冲区中的；
 * 任何时候访问 NIO 中的数据，都是将它放到缓冲区中。
 * 而在面向流I/O系统中，所有数据都是直接写入或者直接将数据读取到Stream对象中。
 * @author xxn
 * @date 2016年4月21日  下午7:05:27
 */
public class IntBufferTest {
	public static void main(String[] args) {
		IntBuffer buffer = IntBuffer.allocate(10);//分配新的 int 缓冲区
		for (int i = 0; i < buffer.capacity(); i++) {
			int j = 2*(i+1);
			buffer.put(j);//相对 put 方法
		}
		System.out.println(buffer.position());//测试指针在最后位置
		buffer.flip();//反转此缓冲区--将指针指向开始位置
		buffer.position(8);
		while(buffer.hasRemaining()){
			System.out.println(buffer.position() + ":" + buffer.get() + " ");
		}
	}
}
