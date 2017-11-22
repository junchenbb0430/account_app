package com.egfbank.threadpool;

import java.util.concurrent.Callable;

import com.egfbank.threadpool.data.AnalyzeResult;
 
public class DataAnalyzeService  implements Callable<AnalyzeResult> {

	 
	public AnalyzeResult call() throws Exception {
		System.out.println("----数据分析开始-----");
		 
		Thread.sleep(3*1000); 
		AnalyzeResult analyzeResult = new AnalyzeResult();
		analyzeResult.calculate();
		System.out.println("----数据分析结束-----");
		return analyzeResult;
	}

}
