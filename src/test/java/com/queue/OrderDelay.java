package com.queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName OrderDelay
 * @Description
 * @Author xuxiangnan
 * @Date 2021/9/9 9:09
 */
public class OrderDelay implements Delayed {
    private String orderId;
    private long timeout;

    public OrderDelay(String orderId, long timeout) {
        this.orderId = orderId;
        this.timeout = timeout + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if(o == this){
            return 0;
        }
        OrderDelay orderDelay = (OrderDelay)o;
        long d = getDelay(TimeUnit.NANOSECONDS) - orderDelay.getDelay(TimeUnit.NANOSECONDS);
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }

    void print(){
        System.out.println(orderId+"编号的订单要删除啦。。。。");
    }
}
