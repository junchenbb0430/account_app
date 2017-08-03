package com.egfbank.concurrent.locktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tonny
 *
 */
public class LockNonFairOrFairService {
	
	private Lock lock;

	public LockNonFairOrFairService(boolean isFair) {
		super();
		lock = new ReentrantLock(isFair);
	}
	
	public LockNonFairOrFairService() {
		super();
		lock = new ReentrantLock(false);
	}
	
	public void methodA(){
		lock.lock();
		try{
			System.out.println("线程  "+Thread.currentThread().getName()+" 获得了执行锁!");
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
}

 
