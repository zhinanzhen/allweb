package com.thread.condition2;

/**
 * @ClassName ConditionTest
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/2 17:03
 */
public class ConditionTest {
    public static void main(String[] args) {
        Goods goods = new Goods();
        // 生产
        Producter producter = new Producter(goods);
        Thread threadProducter = new Thread(producter);
        // 消费
        Consumer consumer = new Consumer(goods);
        Thread threadConsumer = new Thread(consumer);

        threadProducter.start();
        threadConsumer.start();

    }
}
