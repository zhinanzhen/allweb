package com.java8.defaultstatic;

import com.foundation.io.nio.serverclient.NioServer;

/**
 * @ClassName OverridableImpl
 * @Description
 * @Author xuxiangnan
 * @Date 2019/4/19 14:14
 */
public class OverridableImpl implements Defaulable {
    @Override
    public void test() {
        System.out.println("22222222222222222");
//        NioServer
    }
}
