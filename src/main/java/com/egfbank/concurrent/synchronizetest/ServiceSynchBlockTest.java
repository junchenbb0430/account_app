package com.egfbank.concurrent.synchronizetest;

public class ServiceSynchBlockTest {

	public static void main(String[] args){
		final ServiceSynchBlock service  = new ServiceSynchBlock();
		Thread t1 = new Thread(new Runnable(){

			public void run() {
				service.serviceMethod();
			}});
		t1.start();
		Thread t2 = new Thread(new Runnable(){

			public void run() {
				// TODO Auto-generated method stub
				service.serviceMethod();
			}});
		t2.start();
	}
}

class ServiceSynchBlock{
	
	private String data1;
	
	private String data2;
	
	public void serviceMethod(){
		System.out.println("begin task : "+Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String currentData1 = "长时间执行任务后，返回当前处理线程名称 1 threadName = "+Thread.currentThread().getName();
		String currentData2 = "长时间执行任务后，返回当前处理线程名称 2 threadName = "+Thread.currentThread().getName();
		synchronized(this){
			this.data1 = currentData1;
			this.data2 = currentData2;
			System.out.println(Thread.currentThread().getName()+"-->"+this.data1);
			System.out.println(Thread.currentThread().getName()+"-->"+this.data2);
		}
		System.out.println("end!"+Thread.currentThread().getName());
		
	}
}
