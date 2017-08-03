package com.egfbank.concurrent.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class PausableThreadPoolExecutor extends ThreadPoolExecutor {

	private ReentrantLock reenLock = new ReentrantLock();
	
	public PausableThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
			long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 System.out.println(Runtime.getRuntime().availableProcessors());
	}

}
