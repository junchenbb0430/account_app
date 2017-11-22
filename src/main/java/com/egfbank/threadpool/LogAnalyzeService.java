package com.egfbank.threadpool;



public class LogAnalyzeService implements Runnable {

	public void run() {
		 try {
			System.out.println("****日志分析开始******");
			Thread.sleep(20*1000);
			
			System.out.println("****日志分析完成******");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
