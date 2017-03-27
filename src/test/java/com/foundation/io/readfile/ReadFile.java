package com.foundation.io.readfile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadFile {
	/**
	 * io
	 */
	public static void readFileIo(){
		File file = new File("D://bean.txt");
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            int tempbyte;
            byte[] arr = new byte[1024];
            while ((tempbyte = in.read(arr)) != -1) {
                System.out.write(arr,0,tempbyte);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
	}
	
	/**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
    public static void readFileByLines() {
        File file = new File("D://bean.txt");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
    /**
     * 随机读取文件内容
     */
    public static void readFileByRandomAccess() {
        RandomAccessFile randomFile = null;
        try {
            System.out.println("随机读取一段文件内容：");
            // 打开一个随机访问文件流，按只读方式
            randomFile = new RandomAccessFile("D://bean.txt", "r");
            // 文件长度，字节数
            long fileLength = randomFile.length();
            // 读文件的起始位置
            int beginIndex = (fileLength > 4) ? 4 : 0;
            // 将读文件的开始位置移到beginIndex位置。
            randomFile.seek(beginIndex);
            byte[] bytes = new byte[10];
            int byteread = 0;
            // 一次读10个字节，如果文件内容不足10个字节，则读剩下的字节。
            // 将一次读取的字节数赋给byteread
            while ((byteread = randomFile.read(bytes)) != -1) {
                System.out.write(bytes, 0, byteread);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomFile != null) {
                try {
                    randomFile.close();
                } catch (IOException e1) {
                }
            }
        }
    }

	/**
	 * nio
	 */
	public static void readFileNio(){
		FileInputStream fin = null;
		FileChannel fc = null;
		try {
			fin = new FileInputStream(ReadFile.class.getResource("readandshow.txt").getPath());
			fc = fin.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			System.out.write(buffer.array(),0,fc.read(buffer));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(fin != null){
					fin.close();
				}
				if(fc != null){
					fc.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws IOException {
//		readFileIo();
		readFileNio();
//		readFileByLines();
//		readFileByRandomAccess();
		System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
		System.out.println(ReadFile.class.getClassLoader().getResource(""));
		
		File f = new File(ReadFile.class.getResource("").getPath()); 
		System.out.println(f); 
		
	}
}
