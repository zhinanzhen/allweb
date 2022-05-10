package com.lock;

import com.foundation.Person;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @ClassName AtomicIntegerFieldUpdaterTest
 * @Description
 * @Author xuxiangnan
 * @Date 2018/11/6 14:26
 */
public class AtomicIntegerFieldUpdaterTest {
    private static Class<Person> cls;
    public static void main(String[] args) {
        // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicIntegerFieldUpdater<Person> mAtoLong = AtomicIntegerFieldUpdater.newUpdater(Person.class, "id");
    }
}
