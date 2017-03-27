package com.memcached.client;

import com.alisoft.xplatform.asf.cache.ICacheManager;
import com.alisoft.xplatform.asf.cache.IMemcachedCache;
import com.alisoft.xplatform.asf.cache.memcached.CacheUtil;
import com.alisoft.xplatform.asf.cache.memcached.MemcachedCacheManager;

/**
 * alisoft-xplatform-asf-cache-2.5.1
 * 
 * @author xxn
 * @date 2016年6月3日  下午3:07:14
 */
public class ClientTest {
	 public static void main(String[] args) {
	        ICacheManager<IMemcachedCache> manager = CacheUtil.getCacheManager(IMemcachedCache.class,MemcachedCacheManager.class.getName());  
	        manager.setConfigFile("memcached.xml");  
	        manager.start();
	        try {
	            IMemcachedCache cache = manager.getCache("mclient_0");  
	            cache.put("key", "value");
	            
	            TestBean bean=new TestBean();  
	            bean.setName("name1");  
	            bean.setAge(25);  
	            cache.put("bean1", bean);
	            
	            System.out.println(cache.get("key"));
	            System.out.println("get:"+((TestBean)cache.get("bean1")).getName());
	        } finally {
	            manager.stop();  
	        }
	    }  
}
