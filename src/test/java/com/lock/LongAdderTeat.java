package com.lock;

import java.util.concurrent.atomic.LongAdder;

/**
 * @ClassName LongAdderTeat
 * @Description
 * @Author xuxiangnan
 * @Date 2018/11/6 16:00
 */
public class LongAdderTeat {
    public static void main(String[] args) {
        LongAdder adder = new LongAdder();
        System.out.println("默认构造器：" + adder);
        //自增
        adder.increment();
        System.out.println("increment():自增----" + adder);
    }
}
