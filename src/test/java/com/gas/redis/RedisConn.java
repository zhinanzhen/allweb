package com.gas.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisConn
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/9/10 10:47
 */
public class RedisConn {
    public static void main(String[] args) {
        Jedis redis = new Jedis("192.168.50.162");
        redis.set("msg","123");
        System.out.println(redis.get("msg"));

    }
}
