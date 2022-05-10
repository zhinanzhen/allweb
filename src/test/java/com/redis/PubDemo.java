package com.redis;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @ClassName PubDemo
 * @Description
 * @Author xiangnan.xu
 * @DATE 2017/11/23 18:24
 */
public class PubDemo {
    public static void main(String[] args) {
        // 替换成你的reids地址和端口
        String redisIp = "192.168.50.162";
        int reidsPort = 6379;
        JedisPool jedisPool = new JedisPool(new JedisPoolConfig(), redisIp, reidsPort,1000,"password");
        System.out.println(String.format("redis pool is starting, redis ip %s, redis port %d", redisIp, reidsPort));

//        SubThread subThread = new SubThread(jedisPool);
//        subThread.start();

        Publisher publisher = new Publisher(jedisPool);
        publisher.start();
    }
}
