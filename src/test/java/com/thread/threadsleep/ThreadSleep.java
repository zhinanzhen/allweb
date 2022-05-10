package com.thread.threadsleep;

/**
 * @ClassName ThreadSleep
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/1 19:56
 */
public class ThreadSleep {
    public static void main(String[] args) {
        String ab = "abc";
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ab){
                    for(int i=0; i< 20; i++){
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        });
        thread.setName("线程1");
        thread.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ab){
                    for(int i=0; i< 20; i++){
                        System.out.println(Thread.currentThread().getName()+ ":" + i);
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        thread2.setName("线程2");
        thread2.start();

        for(int i=0; i< 20; i++){
            System.out.println(Thread.currentThread().getName()+ ":" + i);
        }
    }
}
