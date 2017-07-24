package com.egfbank.concurrent.locktest;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionServiceTest {

	public static void main(String[] args) {
		ConditionService service = new ConditionService();
//		ThreadConditionWaitTimedA threadA = new ThreadConditionWaitTimedA(service);
//		threadA.start();
		ThreadConditionWaitA threadWait = new ThreadConditionWaitA(service);
		threadWait.start();
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		ThreadConditionSignalA threadSignal = new ThreadConditionSignalA(service);
		threadSignal.start();
	}
	
}

/**
 * 
 * @author tonny
 * Condition中的await方法，必须先获得对象的监视器，才能执行。
 * 获得对象监视器的方式主要有synchronized，lock两种方式.
 * Condition采用lock方式获取对象锁监视器，才可以正确执行
 */
class ConditionService{
	 
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	public  void methodFixedtimeA(){
		try {
			lock.lock();
			System.out.println("****execute begin,currentTime="+System.currentTimeMillis());
			 
			condition.await(5000,TimeUnit.MILLISECONDS);
			System.out.println("***execute end!,currentTime="+System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public  void methodWaitA(){
		try {
			lock.lock();
			long beginTime = System.currentTimeMillis();
			System.out.println("current thread Name = "+Thread.currentThread().getName()+" execute begin,currentTime="+beginTime);
			condition.await();
			long endTime = System.currentTimeMillis();
			System.out.println("current thread Name = "+Thread.currentThread().getName()+",acquire lock agin,execute end!,totalTime="+(endTime-beginTime));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	
	public void sinalMethodA(){
		try{
			lock.lock();
			System.out.println("current thread Name = "+Thread.currentThread().getName()+",acquire lock,sinal other thread ****");
			Thread.sleep(10000);
			condition.signal();
			System.out.println("current thread Name = "+Thread.currentThread().getName()+",signal execute end!****"); 
		}catch(Exception e){
			
		}finally{
			lock.unlock();
		}
	}
}

class ThreadConditionWaitTimedA extends Thread{
	private ConditionService service ;

	public ThreadConditionWaitTimedA(ConditionService service) {
		super();
		this.service = service;
	}
	
	public void run(){
		service.methodFixedtimeA();
	}
}

class ThreadConditionWaitA extends Thread{
	private ConditionService service ;

	public ThreadConditionWaitA(ConditionService service) {
		super();
		this.service = service;
	}
	
	public void run(){
		service.methodWaitA();
		 
	}
}
class ThreadConditionSignalA extends Thread{
	private ConditionService service ;

	public ThreadConditionSignalA(ConditionService service) {
		super();
		this.service = service;
	}
	
	public void run(){
		service.sinalMethodA();
		 
	}
}


