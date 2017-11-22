package com.egfbank.concurrent.jdkutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import com.egfbank.threadpool.ThreadPoolExecutorFactory;

public class SemaphoreTest {

	private static int  THREAD_COUNTER = 30;
	public static void main(String[] args) {
		
		// 1. 固定线程数的线程池
		ExecutorService executorService = ThreadPoolExecutorFactory.fixedThreadPoolExecutor(THREAD_COUNTER);
		// 2. 创建信号量-最多允许10个线程同时并发执行
		final Semaphore semaphore = new Semaphore(10);
		// 3. 执行任务
		for(int i=0;i<THREAD_COUNTER;i++){
			
			executorService.execute(new Runnable(){
				
				public void run() {
					 try {
						 semaphore.acquire(); 
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
					System.out.println("线程名称 ： "+Thread.currentThread().getName()+" save data!" );
					 semaphore.release();
				}
				
			});
		 
		}
		executorService.shutdown();
//		try {
//			Thread.sleep(Integer.MAX_VALUE);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
