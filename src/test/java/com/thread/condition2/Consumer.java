package com.thread.condition2;

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
        synchronized (goods){
            for (int i = 0; i < 10; i++) {
                if(!goods.getFlag()){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(goods);
                goods.setFlag(Boolean.FALSE);
                goods.notify();
            }
        }
    }
}
