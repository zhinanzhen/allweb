package com.memcached;

import java.io.IOException;
import java.net.InetSocketAddress;

import net.spy.memcached.CASResponse;
import net.spy.memcached.CASValue;
import net.spy.memcached.MemcachedClient;

public class CASTest {
	private static MemcachedClient client;
	static {
		try {
			client = new MemcachedClient(new InetSocketAddress("127.0.0.1",11211));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		client.set("number", 7845, 1);

		CASTest testObj = new CASTest();
		for (int i = 0; i < 10; i++) {
			testObj.new ThreadTest("Thread-" + (i + 1)).start();
		}
	}

	private class ThreadTest extends Thread {
		private MemcachedClient client;

		ThreadTest(String name) {
			try {
				client = new MemcachedClient(new InetSocketAddress("127.0.0.1",
						11211));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			int i = 0;
			int success = 0;
			while (i < 10) {
				i++;
				CASValue<Object> uniqueValue = client.gets("number");
				CASResponse response = client.cas("number",uniqueValue.getCas(),
						(Integer) uniqueValue.getValue() + 1);

				if (response.toString().equals("OK")) {
					success++;
				}
				System.out.println(Thread.currentThread().getName() + " " + i
						+ " time " + " update oldValue : " + uniqueValue
						+ " , result : " + response);
			}
			if (success < 10) {
				System.out.println(Thread.currentThread().getName()
						+ " unsuccessful times : " + (10 - success));
			}
		}
	}
}
