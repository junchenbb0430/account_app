package com.egfbank.concurrent.synchronizetest;
/**
 * 
 * @author tonny
 *	验证synchronized(anyObject)同一个对象锁：使用任意数据类型作为锁对象时，最关键的就是多个线程是否同时持有同一个锁对象
 *  采用同一个对象obj作为synchronized(obj)也能实现.
 *  synchronized(this)和synchronized(obj)获得了两个不同的对象锁，
 *  两个方法中分别使用它们加锁，是达不到加锁的效果！
 *  使用synchronized(obj)既能做到同步效果，还能解决部分死锁问题。使用俩不同的对象obj。
 *  synchronized(obj1);  synchronized(obj2);
 */
 class ServiceSynchronizedObject {
	
	private Object obj = new Object();
	
	public void methodA(){
		synchronized(obj){
			System.out.println(".....methodA execute begin....");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("....methodA execute end!....");
		}
	}
	
	public  void methodB(){
		synchronized(obj){
			System.out.println(".....methodB execute begin....");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(".....methodB execute end!....");
		}
	}
	
	public void methodC(){
		synchronized(this){
			System.out.println("...methodC execute.....");
		}
	}
}
public class ServiceSynchronizedObjectTest{
	
	public  static void main(String[] args){
		ServiceSynchronizedObject service = new ServiceSynchronizedObject();
		ServiceObjectThreadA threadA = new ServiceObjectThreadA(service);
		ServiceObjectThreadB threadB = new ServiceObjectThreadB(service);
		ServiceObjectThreadC threadC = new ServiceObjectThreadC(service);
		threadA.start();
		threadB.start();
		threadC.start();
	}
}

class ServiceObjectThreadA extends Thread{
	
	private ServiceSynchronizedObject service;

	public ServiceObjectThreadA(ServiceSynchronizedObject service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodA();
	}
	
}

class ServiceObjectThreadB extends Thread{
	
	private ServiceSynchronizedObject service;

	public ServiceObjectThreadB(ServiceSynchronizedObject service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodB();
	}
		
}

class ServiceObjectThreadC extends Thread{
	
	private ServiceSynchronizedObject service;

	public ServiceObjectThreadC(ServiceSynchronizedObject service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodC();
	}
}
	

