package com.lock;

/**
 * @ClassName SyncTest
 * @Description
 * @Author xuxiangnan
 * @Date 2018/11/5 18:19
 */
public class SyncTest {
    public synchronized void add() {
        System.out.println("test add");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void sub(){
        System.out.println("test sub");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.sub();
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                syncTest.add();
            }
        });
        thread.start();
        thread2.start();
    }
}
