package com.foundation.jvm.jol;

import org.openjdk.jol.info.ClassLayout;

/**
 * @ClassName JolSamle
 * @Description  打印对象头、类型指针、对齐填充、大小等信息
 * @Author xuxiangnan
 * @Date 2022/5/15 17:03
 */
public class JolDemo {
    public static void main(String[] args) {
        final ClassLayout classLayout = ClassLayout.parseInstance(new Object());
        System.out.println(classLayout.toPrintable());

        final ClassLayout classLayout1 = ClassLayout.parseInstance(new Object[]{});
        System.out.println(classLayout1.toPrintable());

        final ClassLayout classLayout2 = ClassLayout.parseInstance(new A());
        System.out.println(classLayout2.toPrintable());


    }
}

class A{
    private String name;
    private int a;
    private Object o = new Object();
    private boolean b;
}
