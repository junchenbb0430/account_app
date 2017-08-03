package com.egfbank.concurrent.locktest;
/**
 * @author tonny
 *
 */
public class LockSerivceTest {

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final LockNonFairOrFairService service = new LockNonFairOrFairService();
		Runnable runnable = new Runnable(){

			public void run() {
				System.out.println("当前线程["+Thread.currentThread().getName()+"]已经运行! ");
				 service.methodA();
			}
			
		};
		Thread[] threadArray = new Thread[10];
		for(int i=0;i<10;i++){
			threadArray[i] = new Thread(runnable);
		}
		for(int i=0;i<10;i++){
			threadArray[i].start();
		}
	}

}
