package com.egfbank.concurrent.locktest.interrupt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * @author tonny
 * lockInterruptibly():
 * ----能够响应中断，在获取锁的过程可以中断当前线程，Thread.interrupt方法，
 * ----可以中断当前线程获取锁。
 * lock()
 * -----线程在获取锁的过程中，对于当前线程调用Thread.interrupt方法不予理会，
 * -----即线程中断对于lock方法不起作用
 */
class LockInterruptService{
	private Lock lock = new ReentrantLock();
	
	public  void methodA(){
		
		try {
			lock.lockInterruptibly();
			System.out.println("methodA:current thread["+Thread.currentThread().getName()+"] execute!");
			for(int i=0;i<Integer.MAX_VALUE/10;i++){	}
			System.out.println("methodA:current thread["+Thread.currentThread().getName()+"] ended!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
		
	}
	
	public void methodB(){
		lock.lock();
		try{
			System.out.println("methodB:current thread["+Thread.currentThread().getName()+"] execute!");
		}catch(Exception ex){
			
		}finally{
			lock.unlock();
		}
	}
}
/**
 * @author tonny
 *
 */
public class LockInterruptServiceTest {

	 
	public static void main(String[] args) {
		final LockInterruptService service = new LockInterruptService();
		Runnable ruunable = new Runnable(){

			public void run() {
				service.methodA();
			}
			
		};
		Thread ta = new Thread(ruunable);
		ta.setName("A");
		ta.start();
		ta.interrupt();
		/******************************/
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/******************************/
		Thread tb = new Thread(ruunable);
		tb.setName("B");
		tb.start();
	}

}
