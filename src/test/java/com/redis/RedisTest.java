package com.redis;

import redis.clients.jedis.Jedis;

/**
 * @ClassName RedisTest
 * @Description
 * @Author xuxiangnan
 * @Date 2018/7/18 16:35
 */
public class RedisTest {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        try {
            Jedis jedis = new Jedis("106.14.161.165",6379);
            String name = jedis.get("name");
            System.out.println(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        jedis.set("we","123");
        //查看服务是否运行
//        System.out.println("服务正在运行: "+jedis.ping());
    }
}
