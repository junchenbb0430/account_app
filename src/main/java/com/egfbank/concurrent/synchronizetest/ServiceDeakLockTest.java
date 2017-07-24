package com.egfbank.concurrent.synchronizetest;
/**
 * 
 * @author tonny
 * 死锁发生的条件是,两个线程A,B:
 * --其中A已经持有锁lock1,同时想再持有锁lock2;
 * --线程B持有锁lock2,同时想再持有锁lock1;
 * --两个线程A,B再持有各自锁的同时又想再去获取对方持有的锁，容易造成死锁
 */
class ServiceDeadLock{
	// 锁lock1
	private Object lock1 = new Object();
	// 锁lock2
	private Object lock2 = new Object();
	
	public void methodA(){
		synchronized(lock1){
			System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]  holds lock1... ");
			try {
				Thread.sleep(10000);
				System.out.println("methodA:task1 执行完毕");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]尝试获取锁loc2...");
			synchronized(lock2){
				System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]  holds lock2... ");
				try {
					Thread.sleep(10000);
					System.out.println("methodA:task2 执行完毕");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]释放锁lock2");
		}
		System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]释放锁lock1");
	}
	
	public void methodB(){
		synchronized(lock2){
			System.out.println("methodB:当前线程["+Thread.currentThread().getName()+"]  holds lock2... ");
			try {
				Thread.sleep(10000);
				System.out.println("methodB:task2 执行完毕");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("methodB:当前线程["+Thread.currentThread().getName()+"]尝试获取锁loc1...");
			synchronized(lock1){
				System.out.println("methodB:当前线程["+Thread.currentThread().getName()+"]  holds lock1... ");
				try {
					Thread.sleep(10000);
					System.out.println("methodB:task1执行完毕");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]释放锁lock1");
		}
		System.out.println("methodA:当前线程["+Thread.currentThread().getName()+"]释放锁lock2");
	}
	
}

public class ServiceDeakLockTest {

	public static void main(String[] args) {
		ServiceDeadLock serviceLock = new ServiceDeadLock();
		ServiceDeadLockThreadA  threadA = new ServiceDeadLockThreadA(serviceLock);
		ServiceDeadLockThreadB  threadB = new ServiceDeadLockThreadB(serviceLock);
		threadA.start();
		threadB.start();
	}
}

class ServiceDeadLockThreadA extends Thread{
	private ServiceDeadLock serviceLock;

	public ServiceDeadLockThreadA(ServiceDeadLock serviceLock) {
		super();
		this.serviceLock = serviceLock;
	}
	
	public void run(){
		serviceLock.methodA();
	}
	
}

class ServiceDeadLockThreadB extends Thread{
	private ServiceDeadLock serviceLock;

	public ServiceDeadLockThreadB(ServiceDeadLock serviceLock) {
		super();
		this.serviceLock = serviceLock;
	}
	
	public void run(){
		serviceLock.methodB();
	}
}

