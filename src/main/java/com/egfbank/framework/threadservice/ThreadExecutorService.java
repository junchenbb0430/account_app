package com.egfbank.framework.threadservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadExecutorService {
	
	public static ExecutorService createExecutor(){
		/**
		 * coreSize:核心线程池大小
		 * maximumPoolSize：最大线程池大小
         * keepAliveTime：线程存活时间
         * TimeUnit unit：线程存活时间单位
         * BlockingQueue<Runnable> workQueue：队列
         * ThreadFactory threadFactory：线程工厂
		 */
		ExecutorService executor = new ThreadPoolExecutor(15,30,10*1000,TimeUnit.MILLISECONDS
				,new LinkedBlockingQueue<Runnable>(),Executors.defaultThreadFactory());
		return executor;
	}
	
	public static void main(String[] args){
		
	}
}
