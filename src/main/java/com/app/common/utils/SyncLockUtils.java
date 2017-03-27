package com.app.common.utils;


public class SyncLockUtils {
	
	/**
	 * 在timeout时间内，不断尝试获取锁
	 * @param key 账户主键
	 * @param timeout 失效时间，单位是：分
	 * @return
	 */
	public static boolean getLock(String key,int timeout){
		return SyncLock.getInstance().getLock(key, timeout);
	}
	public static boolean getLockTime(String key,int timeout,int sleepTime){
		return SyncLock.getInstance().getLock(key, timeout, sleepTime);
	}
	/**
	 * 释放锁
	 * @param key
	 */
	public static void releaseLock(String key){
		SyncLock.getInstance().releaseLock(key);
	}

}
