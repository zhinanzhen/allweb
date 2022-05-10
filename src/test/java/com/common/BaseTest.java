package com.common;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @ClassName BaseTest
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/5/6 22:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class BaseTest {
    @Test
    public void test(){
        System.out.println(11);
    }
}
