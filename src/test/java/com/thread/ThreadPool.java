package com.thread;

import org.tuckey.web.filters.urlrewrite.Run;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName ThreadPool
 * @Description 1、线程池管理器，2、工作线程，3、任务接口，4、任务队列
 * 线程池类，线程管理器：创建线程，执行任务，销毁线程，获取线程基本信息
 * @Author xuxiangnan
 * @Date 2019/5/7 11:57
 */
public class ThreadPool {
    private static final int default_worker_num = 5;
    private static int worker_num;
    private WorkThread[] workThreads;

    private List<Runnable> taskQueue = new LinkedList<Runnable>();

    private ThreadPool(int workerNum){
        workThreads = new WorkThread[workerNum];
        for (int i=0; i < workerNum; i++){
            workThreads[i] = new WorkThread();
            workThreads[i].start();
        }
    }

    private static class SingletonPool{
        private static final ThreadPool threadPool = new ThreadPool(ThreadPool.worker_num);
    }

    public static ThreadPool getThreadPool(int workerNum){
        if(workerNum > 0){
            ThreadPool.worker_num = workerNum;
        }else{
            ThreadPool.worker_num = default_worker_num;
        }
        return SingletonPool.threadPool;
    }

    public void execute(Runnable task){
        synchronized (taskQueue){
            taskQueue.add(task);
            taskQueue.notify();
        }
    }

    public void execute(Runnable[] task){
        synchronized (taskQueue){
            for (int i = 0; i < task.length; i++) {
                taskQueue.add(task[i]);
            }
            taskQueue.notify();
        }
    }

    public void desrotry(){
        while (!taskQueue.isEmpty()) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < workThreads.length; i++) {
            workThreads[i].stopWorker();
            workThreads[i] = null;
        }
        taskQueue.clear();
    }

    public int getWorkerNum(){
        return worker_num;
    }

    public int getTaskQueueSize(){
        return taskQueue.size();
    }

    @Override
    public String toString() {
        return "WorkThread number:" + worker_num + "  wait task number:" + getTaskQueueSize();
    }

    /**
     * 工作线程
     */
    private class WorkThread extends Thread {
        private boolean isRunning = true;

        @Override
        public void run() {
            Runnable runnable = null;
            while (isRunning){
                synchronized (taskQueue){
                    while (isRunning && taskQueue.isEmpty()) {
                        try {
                            taskQueue.wait(20);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if (!taskQueue.isEmpty()) {
                        runnable = taskQueue.remove(0);
                    }
                }
                if (runnable != null) {
                    runnable.run();
                }
                runnable = null;
            }
        }

        public void stopWorker(){
            isRunning = false;
        }
    }

    public static void main(String[] args) {
        ThreadPool threadPool = ThreadPool.getThreadPool(3);
        threadPool.execute(new Runnable[]{new Task(),new Task(),new Task()});
        threadPool.execute(new Runnable[]{new Task(),new Task(),new Task()});
        System.out.println(threadPool);
        threadPool.desrotry();
        System.out.println(threadPool);
    }

    static class Task implements Runnable {
        private static volatile int i = 1;
        @Override
        public void run() {
            System.out.println("任务 " + (i++) + " 完成");
        }
    }
}
