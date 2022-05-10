package com.concurrent;

/**
 * @ClassName Rule
 * @Description 任务拆分，数据转换规则
 * @Author xiangnan.xu
 * @DATE 2017/4/26 15:11
 */
public interface Rule<T,E> {
    T  convert(E e);
}