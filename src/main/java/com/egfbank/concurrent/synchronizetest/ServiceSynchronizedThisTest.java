package com.egfbank.concurrent.synchronizetest;

/**
 * 
 * @author tonny
 * 为了验证synchronized(this)是指当前对象
 * 如果this是当前对象，则线程A执行方法methodA时，
 * 线程B执行methodB需要等待线程A释放锁
 */
 class ServiceSynchronizedThis {

	public void methodA(){
		synchronized(this){
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
	
	
	public synchronized void methodB(){
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
 
public class ServiceSynchronizedThisTest{
	
	public  static void main(String[] args){
		ServiceSynchronizedThis service = new ServiceSynchronizedThis();
		ServiceThreadA threadA = new ServiceThreadA(service);
		SerivceThreadB threadB = new SerivceThreadB(service);
		threadA.start();
		threadB.start();
	}
	
	
}

class ServiceThreadA extends Thread{
	
	private ServiceSynchronizedThis service;

	public ServiceThreadA(ServiceSynchronizedThis service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodA();
	}
	
}

class SerivceThreadB extends Thread{
	
	private ServiceSynchronizedThis service;

	public SerivceThreadB(ServiceSynchronizedThis service) {
		super();
		this.service = service;
	}
	public void run(){
		service.methodB();
	}
	
}

