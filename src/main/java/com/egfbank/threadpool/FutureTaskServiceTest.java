package com.egfbank.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import com.egfbank.threadpool.data.AnalyzeResult;

public class FutureTaskServiceTest {

	public static void main(String[] args) {
		LogAnalyzeService logService = new LogAnalyzeService();
		Callable callable = Executors.callable(logService);
		 FutureTask logTask = new FutureTask(callable);
		 
		
		DataAnalyzeService dataAnalyze = new DataAnalyzeService();
		FutureTask<AnalyzeResult> dataTask = new FutureTask<AnalyzeResult>(dataAnalyze);
		 
		// 获取线程池
		ExecutorService executorService = ThreadPoolExecutorFactory.fixedThreadPoolExecutor(2);
		// Future future = executorService.submit(dataAnalyze); 
		executorService.execute(dataTask);
		
		
		try {
			System.out.println("数据分析 ： "+dataTask.get());
			System.out.println(logTask.get());
			Thread.sleep(Integer.MAX_VALUE);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
