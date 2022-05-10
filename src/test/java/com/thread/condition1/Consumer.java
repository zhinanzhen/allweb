package com.thread.condition1;

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
            goods.getLock().lock();
            try {
                Condition consumerCondition = goods.getConsumerCondition();
                Condition productCondition = goods.getProductCondition();
                if(!goods.getFlag()){
                    try {
                        consumerCondition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("消费" + goods);
                goods.setFlag(Boolean.FALSE);
                productCondition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                goods.getLock().unlock();
            }
        }
    }
}
