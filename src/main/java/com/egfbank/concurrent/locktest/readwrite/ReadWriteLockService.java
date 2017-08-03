package com.egfbank.concurrent.locktest.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author tonny
 * 读写锁:interface : ReadWriteLock <<-- ReentrantReadWriteLock
 * ReentrantReadWriteLock内部定义了ReadLock,WriteLock两个内部类
 * 读写锁ReadWriteLock对于两个线程有如下情况：
 * ----读读锁异步执行
 * ----写写多互斥
 * ----读写锁互斥
 * ----写读锁互斥
 */
public class ReadWriteLockService {

	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private void readLock(){
		try {
		// 共享读锁不互斥
		lock.readLock().lock();
		System.out.println("当前线程["+Thread.currentThread().getName()+"]获得执行锁！,"
				+ "执行时间 "+System.currentTimeMillis());
		
			Thread.sleep(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.readLock().unlock();
		}
		
	}
	
	public void writeLock(){
		lock.writeLock().lock();
		try{
			System.out.println("当前线程["+Thread.currentThread().getName()+"]获得writelock！,"
					+ "执行时间 "+System.currentTimeMillis());
			
				Thread.sleep(5*1000);
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.writeLock().unlock();
		}
	}
	
	public  static void main(String[] args){
		final ReadWriteLockService lockService = new ReadWriteLockService();
		Thread ta = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				lockService.readLock();
			}		
		});
		Thread tb = new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				lockService.readLock();
			}
			
		});
		ta.start();
		tb.start();
		/***********************************************/
		Thread tc = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				lockService.writeLock();;
			}		
		});
		Thread td = new Thread(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				lockService.writeLock();
			}
			
		});
		tc.start();
		td.start();
	}
}
