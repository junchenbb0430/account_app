package com.egfbank.concurrent.jdkutils;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;

import com.egfbank.threadpool.ThreadPoolExecutorFactory;

/**
 * 1. CyclicBarrier主要是用来设置一组屏障，当前线程到达这个屏障时进行阻塞。当最后线程执行到屏障时，
 * 解除屏障。先前阻塞的所有线程再正式运行。
 * 2. CyclicBarrier的构造函数中可以指定优先执行的线程CyclicBarrier barrier = new CyclicBarrier(counter,Runnable);
 * @author tonny
 *
 */
public class CyclicBarrierTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankSalaryService service = new BankSalaryService();
		service.calculateSalary();
	}

}


/**
 * 模拟4个线程分别执行计算每个部门的员工薪水，然后计算完成之后，主线程汇总计算所有部门人员薪水。
 * @descritpion
 * @author lijunshi
 * @date 2018年8月7日
 */
class  BankSalaryService implements Runnable{
	
	// this指当所有线程达到屏障点后，自动触发当前执行的方法，即主线程中run方法
	private CyclicBarrier  barrier = new CyclicBarrier(5,this);
	
	private ExecutorService  executorService =  ThreadPoolExecutorFactory.fixedThreadPoolExecutor(5);
	 
	// 存储各个部门的薪水
	private ConcurrentHashMap<String,Integer>  salaryMap = new ConcurrentHashMap<String,Integer>();
	
	public void calculateSalary() {
		
		for(int i=0;i<5;i++) {
			executorService.execute(new Runnable() {
				@Override
				public void run() {
					 salaryMap.putIfAbsent(Thread.currentThread().getName(),1);
					 try {
						 System.out.println("***当前部门薪水计算完毕!***");
						barrier.await();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (BrokenBarrierException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
		}
		executorService.shutdown();
		
	}
	
	@Override
	public void run() {
		
		 
		 System.out.println("***到达屏障执行点，开始执行本线程中的方法***");
		 int totalSalary =0;
		 for(  Map.Entry<String,Integer> entry:salaryMap.entrySet()) {
			 totalSalary+=entry.getValue();
		 }
		 System.out.println("公司所有部门薪资开支为:"+totalSalary);
		
	}
	
}
