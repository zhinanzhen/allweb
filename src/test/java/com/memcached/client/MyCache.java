package com.memcached.client;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

/**
 * 
 * http://blog.csdn.net/seelye/article/details/8511073
 * 
 * 基于java_memcached-release_2.6.3
 * @author xxn
 * @date 2016年6月2日  下午9:03:10
 */
public class MyCache {
	public static void main(String[] args) {  
        MemCachedClient client=new MemCachedClient();  
        String [] addr ={"127.0.0.1:11211"};  
        Integer [] weights = {3};  
        SockIOPool pool = SockIOPool.getInstance();  
        pool.setServers(addr);//设置连接池可用的cache服务器列表，server 的构成形式如上。
        pool.setWeights(weights);//设置连接池可用cache服务器的权重，和server数组的位置一一对应。
        pool.setInitConn(5);// 设置开始每个cache服务器的可用连接数
        pool.setMinConn(5); // 设置每个服务器最少的可用连接数
        pool.setMaxConn(200);  //设置每个服务器最大的可用连接数
        pool.setMaxIdle(1000*30*30);//设置连接池的最长等待时间
        pool.setMaintSleep(30);  
        pool.setNagle(false);
        pool.setSocketTO(30);  
        pool.setSocketConnectTO(0);  
        pool.initialize();
          
//      String [] s  =pool.getServers();  
//        client.setCompressEnable(true);  
//        client.setCompressThreshold(1000*1024);  
          
//      将数据放入缓存  
        client.set("test2","test2");  
          
//      将数据放入缓存,并设置失效时间  
        Date date=new Date(2000000);  
        client.set("test1","test1", date);
        
//        TestBean bean=new TestBean();  
//        bean.setName("name1");  
//        bean.setAge(25);  
//        client.add("bean1", bean);  
        
//      删除缓存数据  
//      client.delete("test1");  
          
//      获取缓存数据  
        String str =(String)client.get("test1");  
        System.out.println("get:"+str);
        System.out.println("get:"+((TestBean)client.get("bean1")).getName());
    }  
}
