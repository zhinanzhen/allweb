package com.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName SubDemo2
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/11/23 18:54
 */
public class SubDemo2 {
    public static void main(String[] args) {
        String redisIp = "192.168.50.162";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort,1000,"password");
        Subscriber subscriber = new Subscriber();
        while(true){
            System.out.println("go.........................start");
            Jedis jedis = null;
            try {
                jedis = jedisPool.getResource();
                jedis.subscribe(subscriber, "mychannel");
            } catch (Exception e) {
                System.out.println(String.format("subsrcibe channel error, %s", e));
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
            System.out.println("go.........................end");
        }
    }
}
