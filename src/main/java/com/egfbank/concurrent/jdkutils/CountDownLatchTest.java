package com.egfbank.concurrent.jdkutils;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch：通过await和countDown方法组合进行并发控制
 * 				await方法要先于执行，即要在countDown方法执行之前执行。
 * 				await方法主要是阻塞当前执行线程，如果await方法不设置超时参数，则会一直阻塞下去。
 * 				countDown方法执行一次，CountDown计数器就要减1。直至到计数器为0.
 * @descritpion
 * @author lijunshi
 * @date 2018年8月7日
 */
public class CountDownLatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountDownLatch  startSignal= new CountDownLatch(5);
		 
		for(int i=0;i<5;i++) {
			Thread thread = new Thread(new WorkRunnable(startSignal));
			thread.start();
			startSignal.countDown();
			doOtherWokr(thread);
		
			 
		}
		System.out.println("*****Main 线程  执行完毕！******");
	}

	
	private static void doOtherWokr(Thread t) {
		System.out.println(t.currentThread().getName()+"--->又一项工作完成了!");
	}
}





class WorkRunnable implements Runnable{

	private CountDownLatch  startSignal;
	
	 
	
	public WorkRunnable(CountDownLatch startSignal) {
		super();
		this.startSignal = startSignal;
	}

	 

	@Override
	public void run() {
		try {
			// await方法阻塞当前执行线程，一直会则当前线程
			// await(timeout)，超时时间结束，当前线程不会再阻塞
			startSignal.await();
			this.doWork();		 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void doWork() {
		System.out.println(Thread.currentThread().getName()+"--->execut work");
	}
	
}
