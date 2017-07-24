package com.egfbank.concurrent.locktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReetrantLockServiceTest {

	public static void main(String[] args) {
		ReentrantLockService service =new ReentrantLockService();
		ThreadReentrantLockA threadA = new ThreadReentrantLockA(service);
		threadA.setName("AA");
		ThreadReentrantLockA threadB = new ThreadReentrantLockA(service);
		threadB.setName("BB");
		threadA.start();
		threadB.start();
	}

}

/**
 * ReentrantLock效果跟synchronized效果是一个道理，都是可以做到同步资源效果
 * 但是，ReentrantLock可以比synchronized更为灵活
 * @author tonny
 *
 */
class ReentrantLockService{
	private int counter=0;
	private Lock lock = new ReentrantLock();
	
	public void methodA(){
		lock.lock();
		try {
		for(int i=0;i<5;i++){
			System.out.println("current Thread Name = "+Thread.currentThread().getName()+",i = "+i);
			Thread.sleep(2000);
			counter ++;
		  }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void methodB(){
		lock.lock();
		try {
		for(int i=0;i<5;i++){
			System.out.println("current Thread Name = "+Thread.currentThread().getName()+",i = "+i);
			Thread.sleep(3000);
			counter ++;
		  }
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}

class ThreadReentrantLockA extends Thread{
	private ReentrantLockService service;

	public ThreadReentrantLockA(ReentrantLockService service) {
		super();
		this.service = service;
	}
	
	public void run(){
		service.methodA();
		System.out.println("counter = "+service.getCounter());
	}
}

class ThreadReentrantLockB extends Thread{
	private ReentrantLockService service;

	public ThreadReentrantLockB(ReentrantLockService service) {
		super();
		this.service = service;
	}
	
	public void run(){
		service.methodB();
		System.out.println("counter = "+service.getCounter());
	}
}