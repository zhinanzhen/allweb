package com.foundation.jvm.escapeanalysis;

import com.app.showpic.register.bean.User;

/**
 * @ClassName AllotOnStack
 * @Description
 * 栈上分配，标量替换
 * 少量GC
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * 发生大量GC
 * -Xmx15m -Xms15m -XX:-DoEscapeAnalysis -XX:+PrintGC -XX:+EliminateAllocations
 * -Xmx15m -Xms15m -XX:+DoEscapeAnalysis -XX:+PrintGC -XX:-EliminateAllocations
 * @Author xuxiangnan
 * @Date 2022/5/16 15:47
 */
public class AllotOnStack {
    public static void main(String[] args) throws Exception{
        for (int i = 0; i < 100000000; i++) {
            allot();
        }
    }

    private static void allot() throws Exception{
        User user = new User();
        user.setUserId(2);
        user.setEmail("eeeeeeeeeeeeeeeeeeee");
        Thread.sleep(10);
    }
}
