package com.thread.condition2;

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
            synchronized (goods){
                if(goods.getFlag()){
                    try {
                        goods.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                goods.setName("name" + i);
                goods.setAddr("addr:" + i);
                goods.setFlag(Boolean.TRUE);
                goods.notify();
            }
        }
    }
}
