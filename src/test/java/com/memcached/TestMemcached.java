package com.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.MemcachedClient;

public class TestMemcached {
	public static void main(String[] args) throws IOException {
		/*MemcachedClient cache = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
		for (int i = 1; i < 10; i++) {
			cache.set("T0001" + i, 3600, new User(i + ""));
		}
		User myObject = (User) cache.get("T00011");
		System.out.println("Get object from mem :" + myObject);*/
		MemcachedClient client = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
//		client.set("key1", 1, 345);
		Object object = client.get("foo");
		System.out.println(object);
	}
}
