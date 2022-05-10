package com.thread.condition1;

import lombok.Data;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Goods
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/2 16:33
 */
@Data
public class Goods {
    private String name;
    private String addr;
    // true 可以消费 false 不可消费
    private Boolean flag = Boolean.FALSE;

    private Lock lock = new ReentrantLock();
    private Condition productCondition = lock.newCondition();
    private Condition consumerCondition = lock.newCondition();

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
