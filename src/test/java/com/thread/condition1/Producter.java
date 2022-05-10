package com.thread.condition1;

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
        goods.getLock().lock();
        try {
            for (int i = 0; i < 10; i++) {
                Condition productCondition = goods.getProductCondition();
                Condition consumerCondition = goods.getConsumerCondition();
                if(goods.getFlag()){
                    try {
                        productCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                goods.setName("name" + i);
                goods.setAddr("addr:" + i);
                System.out.println("生产：" + goods);
                goods.setFlag(Boolean.TRUE);
                consumerCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            goods.getLock().unlock();
        }
    }
}
