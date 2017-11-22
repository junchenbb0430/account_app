package com.egfbank.concurrent.jdkutils;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;

import com.egfbank.threadpool.ThreadPoolExecutorFactory;
/**
 * 
 * @author tonny
 *  Exchange是用于两个线程之间协作的工具类，主要是提供一个同步点，线程达到这个同步点之后，交换彼此的数据。
 */
public class ExchangerTest {

	public static void main(String[] args) {
		// 1. 创建线程池
		ExecutorService executorService = ThreadPoolExecutorFactory.fixedThreadPoolExecutor(2);
		// 2.创建线程交换数据
		final Exchanger<String> changer = new Exchanger<String>();
		executorService.execute(new Runnable(){

			public void run() {
				 String flowSerial = "银行流水A";
				 try {
					changer.exchange(flowSerial);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		executorService.execute(new Runnable(){

			public void run() {
				 String flowSerialB = "银行流水BB";
				 
				 try {
					String flowSerialA = changer.exchange(flowSerialB);
					System.out.println(flowSerialA.equals(flowSerialB)+",线程A录入数据 ："+flowSerialA+
							", 线程B录入数据 ："+flowSerialB);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
	}

}
