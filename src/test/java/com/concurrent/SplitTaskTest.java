package com.concurrent;

import com.sun.tools.ws.wsdl.document.Output;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName SplitTaskTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/5/6 22:11
 */
public class SplitTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Long> list = new ArrayList<Long>();
        for(long i = 0 ; i < 100000 ; i++){
            list.add(i);
        }
        System.out.println("start");
        long start = System.currentTimeMillis();
        List<String> list1 = SplitTaskUtil.splitListTask2(list, new Rule<String, Long>() {
            @Override
            public String convert(Long aLong) {
                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(new File("D:\\123.txt"),true);
                    for (int i = 0; i < 100; i++) {
                        outputStream.write((Thread.currentThread().getName() + i).getBytes());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
                    try {
                        if(outputStream != null){
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return String.valueOf(aLong);
            }
        });
        System.out.println(list1.size());
        System.out.println(System.currentTimeMillis() - start);
    }

}
