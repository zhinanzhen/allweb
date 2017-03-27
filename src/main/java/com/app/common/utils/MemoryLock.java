package com.app.common.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 内存锁
 * @author xxn
 * @date 2015年12月1日  下午3:38:24
 */
public class MemoryLock {
	//内存空间
	private static Map<Integer, LockBean> objects = new ConcurrentHashMap<Integer, LockBean>();
	//读写锁
	private static ReadWriteLock realLock = new ReentrantReadWriteLock();
	//默认锁定时长
	private static long lockTimeOut = 300000;
	
	//内存回收线程
	static{
		ThreadPoolUtils.execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					realLock.writeLock().lock();
					for(Map.Entry<Integer , LockBean> entry:objects.entrySet()){
						LockBean lockBean = entry.getValue();
						Date start = DateUtils.parse(lockBean.getLockTime(), DateUtils._YYYYMMDDHHMMSS_STR);
						if((System.currentTimeMillis()-start.getTime())>lockBean.getTimeout()){
							objects.remove(entry.getKey());
						}
					}
					realLock.writeLock().unlock();
					try {
						Thread.sleep(200000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	
	/**
	 * 锁定字符串
	 * @param seri
	 * @return
	 * boolean
	 */
	public static boolean lock(String seri){
		return lock(seri, lockTimeOut);
	}
	
	/**
	 * 锁定字符串
	 * @param seri
	 * @param timeout	自定义锁定时长
	 * @return
	 * boolean
	 */
	public static boolean lock(String seri,long timeout){
		if(seri == null) return false;
		realLock.readLock().lock();
		LockBean obj = objects.get(seri.hashCode());
		realLock.readLock().unlock();
		
		if(obj!=null){
			Date start = DateUtils.parse(obj.getLockTime(), DateUtils._YYYYMMDDHHMMSS_STR);
			if((System.currentTimeMillis()-start.getTime())>obj.getTimeout()){
				realLock.writeLock().lock();
				objects.remove(seri.hashCode());
				realLock.writeLock().unlock();
			}else{
				return false;
			}
		}
		obj = new LockBean(seri, DateUtils.getNowTime(),timeout);
		realLock.writeLock().lock();
		objects.put(seri.hashCode(), obj);
		realLock.writeLock().unlock();
		return true;
	}
	
	/**
	 * 解锁
	 * @param seri
	 * @return
	 * boolean
	 */
	public static boolean unlock(String seri){
		if(seri == null){
			return false;
		}
		realLock.writeLock().lock();
		objects.remove(seri.hashCode());
		realLock.writeLock().unlock();
		return true;
	}
	
	static class LockBean{
		
		private Serializable bean;
		
		private String lockTime;
		
		private long timeout;

		public LockBean(Serializable bean, String lockTime,long timeout) {
			this.bean = bean;
			this.lockTime = lockTime;
			this.timeout = timeout;
		}

		public Serializable getBean() {
			return bean;
		}

		public void setBean(Serializable bean) {
			this.bean = bean;
		}

		public String getLockTime() {
			return lockTime;
		}

		public void setLockTime(String lockTime) {
			this.lockTime = lockTime;
		}

		public long getTimeout() {
			return timeout;
		}

		public void setTimeout(long timeout) {
			this.timeout = timeout;
		}
		
	}
	
	public static void main(String[] args){
		String str = "aaaa";
		System.out.println(lock(str));
		System.out.println(lock(str));
	}
}
