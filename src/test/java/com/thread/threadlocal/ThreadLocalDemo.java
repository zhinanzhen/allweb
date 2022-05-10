package com.thread.threadlocal;

/**
 * @ClassName ThreadLocalDemo
 * @Description
 * @Author xuxiangnan
 * @Date 2021/9/30 9:55
 */
public class ThreadLocalDemo {
    static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocal.get());
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("eee");
                threadLocal.set("eee2");
                System.out.println(threadLocal.get());
            }
        }).start();
    }
}
