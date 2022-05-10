package com.java8.defaultstatic;

import java.util.function.Supplier;

/**
 * @ClassName DefaulableFactory
 * @Description
 * @Author xuxiangnan
 * @Date 2019/4/19 14:13
 */
public interface DefaulableFactory {
    static Defaulable create(Supplier<Defaulable> supplier){
        return supplier.get();
    }
}
