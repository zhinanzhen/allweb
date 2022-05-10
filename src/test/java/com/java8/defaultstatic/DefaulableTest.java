package com.java8.defaultstatic;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName DefaulableTest
 * @Description
 * @Author xuxiangnan
 * @Date 2019/4/19 14:16
 */
public class DefaulableTest {
    public static void main(String[] args) {
        Defaulable defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable);

        defaulable = DefaulableFactory.create(DefaultableImpl::new);
        System.out.println(defaulable);

        List<Defaulable> defaulables = Arrays.asList(defaulable);

        defaulables.forEach(DefaulableTest::forEa);
    }

    public static void forEa(Defaulable defaulables){
    }
}


