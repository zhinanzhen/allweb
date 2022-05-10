package com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName SplitTaskUtil
 * @Description list 任务拆分
 * @Author xiangnan.xu
 * @DATE 2017/4/26 14:27
 */
public class SplitTaskUtil {
    /**
     *
     * @param orig 需要转换的集合
     * @param rule 转换规则
     * @param <T> 返回泛型
     * @param <E> 需要转换的泛型
     * @return
     * @throws ExecutionException
     * @throws InterruptedException
     */
    public static <T,E> List<T> splitListTask(List<E> orig , Rule<T,E> rule) throws ExecutionException, InterruptedException {
        int size = 500;
        // 需要返回的数据
        List<T> lts = new ArrayList<>(orig.size());
        if(orig.size() < size){
            for (E e : orig) {
                lts.add(rule.convert(e));
            }
            return lts;
        }
        // 数据差分成一个子任务数据
        List<List<E>> subTaskList = new ArrayList<>();
        for(int i = 0 ; i < orig.size() ; i = i + size){
            subTaskList.add(orig.subList( i , Math.min(i + size , orig.size())));
        }

        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // 保存futureTask任务
        List<FutureTask<List<T>>> tasklist = new ArrayList<FutureTask<List<T>>>();
        for (List<E> le : subTaskList) {
            FutureTask<List<T>> futureTasks = new FutureTask<List<T>>(new Callable<List<T>>() {
                @Override
                public List<T> call() throws Exception {
                    List<T> lt = new ArrayList(le.size());
                    for (E e : le) {
                        lt.add(rule.convert(e));
                    }
                    return lt;
                }
            });
            executorService.submit(futureTasks);
            tasklist.add(futureTasks);
        }
        // 处理合并结果集
        for (FutureTask<List<T>> futureTask : tasklist) {
            lts.addAll(futureTask.get());
        }
        executorService.shutdown();
        System.out.println("continue");
        return lts;
    }
    public static <T,E> List<T> splitListTask2(List<E> orig , Rule<T,E> rule) throws ExecutionException, InterruptedException {
        int size = 500;
        // 需要返回的 数据
        List<T> lts = new ArrayList<>(orig.size());
        if(orig.size() < size){
            for (E e : orig) {
                lts.add(rule.convert(e));
            }
            return lts;
        }
        // 数据差分成一个子任务数据
        List<List<E>> subTaskList = new ArrayList<>();
        for(int i = 0 ; i < orig.size() ; i = i + size){
            subTaskList.add(orig.subList( i , Math.min(i + size , orig.size())));
        }

        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        // 保存futureTask任务
        List<Future<List<T>>> tasklist = new ArrayList<Future<List<T>>>();
        for (List<E> le : subTaskList) {
            Future<List<T>> future = executorService.submit(new Callable<List<T>>() {
                @Override
                public List<T> call() throws Exception {
                    List<T> lt = new ArrayList(le.size());
                    for (E e : le) {
                        lt.add(rule.convert(e));
                    }
                    return lt;
                }
            });
            tasklist.add(future);
        }
        // 处理合并结果集
        for (Future<List<T>> futureTask : tasklist) {
            lts.addAll(futureTask.get());
        }
        executorService.shutdown();
        System.out.println("continue");
        return lts;
    }


    public static <T,E> List<T> splitListTask3(List<E> orig , Rule<T,E> rule) throws ExecutionException, InterruptedException {
        int size = 500;
        // 需 要返回的数据
        List<T> lts = new ArrayList<>(orig.size());
        if(orig.size() < size){
            for (E e : orig) {
                lts.add(rule.convert(e));
            }
            return lts;
        }
        // 数据差分成一 个子任务数据
        List<List<E>> subTaskList = new ArrayList<>();

        for(int i = 0 ; i < orig.size() ; i = i + size){

            subTaskList.add(orig.subList( i , Math.min(i + size , orig.size())));
        }

        // 构建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService<List<T>> ecs = new ExecutorCompletionService<List<T>>(executorService);
        for (List<E> le : subTaskList) {
            ecs.submit(new Callable<List<T>>() {
                @Override
                public List<T> call() throws Exception {
                    List<T> lt = new ArrayList(le.size());
                    for (E e : le) {
                        lt.add(rule.convert(e));
                    }
                    return lt;
                }
            });
        }
        // 处理合并结果集
        for(int i = 0 ; i < subTaskList.size() ; i++){
            lts.addAll(ecs.take().get());
        }
        executorService.shutdown();
        System.out.println("continue");
        return lts;
    }
}