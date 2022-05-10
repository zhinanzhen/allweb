package com.concurrent.base;

/**
 * @ClassName AtomicBase
 * @Description
 * @Author xuxiangnan
 * @Date 2019/5/8 10:01
 */
public class AtomicBase {
    int Aa;
    int AA;

    AtomicBase(int a ){

    }

    public static void main(String[] args) {
        Class<AtomicBase> atomicBaseClass = AtomicBase.class;

        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
