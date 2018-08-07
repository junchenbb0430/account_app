package com.egfbank.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorFactory {

	/**
	 * 固定线数的线程池，即
	 * coreSize==num
	 * maximumSize==num
	 * BlockingQueue:LinkedBlockingQueue
	 * @return
	 */
	public static ExecutorService  fixedThreadPoolExecutor(int num){
		return Executors.newFixedThreadPool(num,Executors.defaultThreadFactory() );
	}
	/**
	 * 单个线程的线程池
	 * @return
	 */
	public static ExecutorService singleThreadPoolExecutor(){
		return Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
	}
	 
	/***
	 * 
	 * @param coreSize
	 * @param maximumSize
	 * @param keepAliveTime
	 * @param unit
	 * @param workQueue
	 * @param threadFactory
	 * @param handler
	 * @return
	 */
	public static  ExecutorService ThreadPoolExecutor(int coreSize,int maximumSize,long keepAliveTime,
            TimeUnit unit,BlockingQueue<Runnable> workQueue,ThreadFactory threadFactory,
            RejectedExecutionHandler handler){
		ExecutorService executor = new ThreadPoolExecutor(coreSize,maximumSize,keepAliveTime,unit,
									workQueue,threadFactory,handler);
		
		return executor;
	}
}
