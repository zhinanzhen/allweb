package com.thread.condition;

import java.util.concurrent.locks.Condition;

/**
 * @ClassName Consumer
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/2 16:34
 */
public class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("消费" + goods);
        }
    }
}
