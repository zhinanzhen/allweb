package com.thread.condition;

import java.util.concurrent.locks.Condition;

/**
 * @ClassName Producter
 * @Description
 * @Author xuxiangnan
 * @Date 2021/6/2 16:34
 */
public class Producter implements Runnable{
    private Goods goods;

    public Producter(Goods goods){
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            goods.setName("name" + i);
            goods.setAddr("addr:" + i);
            System.out.println("生产：" + goods);
        }
    }
}
