package com.app.common.utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** 
 * @Description: 针对账户进行加锁、释放锁操作。
 */
public class SyncLock {
	
	private SyncLock(){};
	//单例
	private static SyncLock syncLock = new SyncLock();
	//内存空间，存储锁对象
	private static ConcurrentHashMap<String,LockBean> syncMap = new ConcurrentHashMap<String,LockBean>();
	//读写锁
	private static ReadWriteLock realLock = new ReentrantReadWriteLock();
	//最长锁定时长5分钟
	private static long lockTimeOut = 300000;
	//默认获取锁超时时间 1 次
	private static int defaultGetLockTime = 1;
	//默认间隔时间 100毫秒
	private static int defaultSleepTime = 100;
	
	public static SyncLock getInstance(){
		return syncLock;
	}
	
	//内存回收线程
	static{
		ThreadPoolUtils.execute(new Runnable() {
			@Override
			public void run() {
				while(true){
					realLock.writeLock().lock();
					for(Map.Entry<String , LockBean> entry:syncMap.entrySet()){
						LockBean lockBean = entry.getValue();
						Date start = DateUtils.parse(lockBean.getLockTime(), DateUtils._YYYYMMDDHHMMSS_STR);
						if((System.currentTimeMillis()-start.getTime())>lockBean.getTimeout()){
							syncMap.remove(entry.getKey());
						}
					}
					realLock.writeLock().unlock();
					try {
						Thread.sleep(60000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}
	 
	/**
	 * 获得锁
	 * @param key
	 * @return
	 */
	private boolean getCurrentLock(String key){
		//获取锁对象
		realLock.writeLock().lock();
		LockBean lockBean = syncMap.get(key);
		//处理锁对象，当所对象不为空时，超出最长锁定时间解锁，没有超出最长锁定时间，返回获取锁失败
		if(lockBean!=null){
			Date start = DateUtils.parse(lockBean.getLockTime(), DateUtils._YYYYMMDDHHMMSS_STR);
			if((System.currentTimeMillis()-start.getTime())>lockBean.getTimeout()){
				syncMap.remove(key);
			}else{
				realLock.writeLock().unlock();
				return false;
			}
		}
		//创建对象锁，锁定对象
		lockBean = new LockBean(key, DateUtils.getNowTime(),lockTimeOut);
		syncMap.put(key, lockBean);
		realLock.writeLock().unlock();
		return true;
	}
	
	/**
	 * 释放锁
	 * @param key
	 */
	public boolean releaseLock(String key){
		realLock.writeLock().lock();
		LockBean  lockBean = syncMap.remove(key);
		realLock.writeLock().unlock();
		return lockBean != null ? true : false;
	}
	
	/**
	 * 在timeout时间内，不断尝试获取锁
	 * @param key 账户主键
	 * @param timeout 失效时间，单位是：次数
	 * @return
	 */
	public boolean getLock(String key) {
		return getLock(key, defaultGetLockTime, defaultSleepTime);
	}
	public boolean getLock(String key,int timeout) {
		return getLock(key, timeout, defaultSleepTime);
	}
	public boolean getLock(String key,int timeout,int sleepTime) {
		int sec = 0;
		if(timeout < 0){
			timeout = defaultGetLockTime;
		}
		if(sleepTime < 0){
			sleepTime = defaultSleepTime;
		}
		System.out.println("当前线程："+Thread.currentThread().getName()+"  timeout:"+timeout);
		
		while (true) {
			if(sec < timeout){
				boolean lock = this.getCurrentLock(key);
				System.out.println("当前线程："+Thread.currentThread().getName()+"sec:"+sec+"获取锁："+lock);
				if(lock){
					return true;
				}
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return false;
				}
				sec++;
				continue;
			}
			return false;
		}
	}
	
	public static void main(String[] args){
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean lock = SyncLock.getInstance().getLock("123",4);
				try {
					 if(lock){
						 System.out.println(Thread.currentThread().getName()+ " : 获得锁");
					 }else{
						 System.out.println(Thread.currentThread().getName()+ " : 未获得锁");
					 }
					 Thread.sleep(1000);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					System.out.println(Thread.currentThread().getName()+ " : 当前锁状态"+lock);
					if(lock){
						System.out.println(Thread.currentThread().getName()+ " : 释放锁"+ SyncLock.getInstance().releaseLock("123"));
						
					}
					
				}
				
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				boolean lock = SyncLock.getInstance().getLock("123",4);
				try {
					 if(lock){
						 System.out.println(Thread.currentThread().getName()+ " : 获得锁");
					 }else{
						 System.out.println(Thread.currentThread().getName()+ " : 未获得锁");
					 }
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally{
					System.out.println(Thread.currentThread().getName()+ " : 当前锁状态"+lock);
					if(lock){
						System.out.println(Thread.currentThread().getName()+ " : 释放锁"+ SyncLock.getInstance().releaseLock("123"));
					}
					
				}
				
			}
		}).start();
	}
	
	
	static class LockBean implements Serializable{
		
		/**
		 * UID
		 */
		private static final long serialVersionUID = -5502965549865608747L;

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
}
