package com.egfbank.concurrent.jdkutils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

import com.egfbank.threadpool.ThreadPoolExecutorFactory;

public class SemaphoreTest {

	private static int  THREAD_COUNTER = 28;
	public static void main(String[] args) {
		
		BankCardApplyService bankCardService = new BankCardApplyService();
		String flowNumber="apply";
		for(int i=0;i<50;i++) {
			 Thread t = new Thread(new BankCardServiceThread(bankCardService,flowNumber+"_"+i));
			 t.start();
		}
		
//		// 1. 固定线程数的线程池
//		ExecutorService executorService = ThreadPoolExecutorFactory.fixedThreadPoolExecutor(THREAD_COUNTER);
//		// 2. 创建信号量-最多允许10个线程同时并发执行
//		final Semaphore semaphore = new Semaphore(10);
//		// 3. 执行任务
//		for(int i=0;i<THREAD_COUNTER;i++){
//			
//			executorService.execute(new Runnable(){
//				
//				public void run() {
//					 try {
//						 semaphore.acquire(); 
//						 System.out.println("线程名称 ： "+Thread.currentThread().getName()+" save data!" );
//						} catch (Exception e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					
//					
//					 semaphore.release();
//				}
//				
//			});
//		 System.out.println("***************");
//		}
//		executorService.shutdown();
 
	}

}

class BankCardServiceThread implements Runnable{
	private BankCardApplyService  applyService;
	
	private String flowNum;
	public BankCardServiceThread(BankCardApplyService applyService,String flowNumber) {
		super();
		this.applyService = applyService;
		this.flowNum = flowNumber;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		applyService.applyCard(flowNum);
	}
	
}

class BankCardApplyService{
	private final Semaphore semaphore = new Semaphore(10);
	
	// 1. 固定线程数的线程池
	private static ExecutorService executorService = ThreadPoolExecutorFactory.fixedThreadPoolExecutor(5);
	
	public void applyCard(String flowNumber) {
		
		int permit = semaphore.availablePermits();
		
		if(permit>0) {
			executorService.execute(new Runnable() {

				@Override
				public void run() {
					try {
						semaphore.acquire();
						 System.out.println(Thread.currentThread().getName()+"--->"+flowNumber+"---->execute finished！");
						Thread.sleep(3*1000);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						 semaphore.release();
					}
					
				}
				
			});
			 
		}else {
			System.out.println(flowNumber+"放入阻塞队列中，等待调用***");
		}
		
	}
	
}
