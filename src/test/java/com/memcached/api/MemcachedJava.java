package com.memcached.api;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Map;
import java.util.Map.Entry;

import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

public class MemcachedJava {
	public static void main(String[] args) {
		try {
			InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 11211);
			MemcachedClient client = new MemcachedClient(socketAddress);
			/*System.out.println(client.set("xxn", 500, "memcached").isDone());
			System.out.println(client.get("xxn"));
			
			System.out.println(client.add("xxn1", 500, "memcached1").isDone());
			System.out.println(client.get("xxn1"));
			
			CASValue<Object> value = client.gets("xxn");
			long castToken = value.getCas();
			
			System.out.println(client.cas("xxn", castToken, "hahahahha34"));
			System.out.println(client.gets("xxn"));
			
			/*System.out.println(client.set("num", 500, "2").isDone());
			System.out.println(client.get("num"));
			
			System.out.println(client.incr("num", 6));
			System.out.println(client.get("num"));*/
			
			Map<SocketAddress, Map<String, String>> stats = client.getStats();
			
			Map<String, String> map = stats.get(socketAddress);
			
			for (Entry<String, String> entry : map.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
