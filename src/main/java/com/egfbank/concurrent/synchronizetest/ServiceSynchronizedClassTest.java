package com.egfbank.concurrent.synchronizetest;

/**
 * 
 * @author tonny
 *  类锁有两种方式<p>
 *  ----第一种：synchronized static void method() 修饰静态方法
 *  ----第二种：synchronized(.class)
 *  类锁对所有的对象实例都是同步阻塞的，这一点跟多线程必须使用同一个对象实例阻塞不同。
 *  类锁和对象锁是两个不同的锁，对象锁是针对每个实例，类锁其实是对Class对象加锁，因为每个java类只有一个Class类对象，
 *  但是可以同时拥有多个实例。
 *  类锁和对象锁是不同的锁，同时使用即可不影响执行效率又不会同步阻塞
 */
class ServiceSynchronizedClass {
	
	
	public static synchronized void   methodA(){
		System.out.println(".....static methodA execute begin!.....");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(".....static methodA execute end!.....");
	}
	
	public static synchronized void   methodB(){
		System.out.println(".....static methodB execute begin!.....");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(".....static methodB execute end!.....");
	}
	public  synchronized void   methodC(){
		System.out.println(".....normal  methodC execute begin!.....");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".....normal methodC execute end!.....");
	}
	
	public void methodD(){
		synchronized(ServiceSynchronizedClass.class){
			System.out.println(".....methodD【class block】  execute begin!.....");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println(".....methodD【class block】 execute end!.....");
		}
	}
}


public class ServiceSynchronizedClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServiceSynchronizedClass serviceClass = new ServiceSynchronizedClass();
		ServiceSynchronizedClass serviceClass2 = new ServiceSynchronizedClass();
		ServiceClassThreadA threadA = new ServiceClassThreadA(serviceClass);
		ServiceClassThreadB threadB = new ServiceClassThreadB(serviceClass2);
		ServiceClassThreadC threadC = new ServiceClassThreadC(serviceClass);
		ServiceClassThreadD threadD = new ServiceClassThreadD(serviceClass);
		threadA.start();
		threadB.start();
		threadC.start();
		threadD.start();
	}

}

class ServiceClassThreadA extends Thread{
	
	private ServiceSynchronizedClass service;

	public ServiceClassThreadA(ServiceSynchronizedClass service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodA();
	}
		
}

class ServiceClassThreadB extends Thread{
	
	private ServiceSynchronizedClass service;

	public ServiceClassThreadB(ServiceSynchronizedClass service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodB();
	}
		
}

class ServiceClassThreadC extends Thread{
	
	private ServiceSynchronizedClass service;

	public ServiceClassThreadC(ServiceSynchronizedClass service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodC();
	}
		
}
class ServiceClassThreadD extends Thread{
	
	private ServiceSynchronizedClass service;

	public ServiceClassThreadD(ServiceSynchronizedClass service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodD();
	}
		
}
