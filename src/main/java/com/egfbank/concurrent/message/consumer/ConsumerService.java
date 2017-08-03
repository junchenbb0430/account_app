package com.egfbank.concurrent.message.consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.egfbank.concurrent.message.broker.MessageBrokerService;

/**
 * 消费者服务,主要是消费者线程调用该服务去消费生产者生产的消息，
 * (或者从broker中获取消息)
 * @author tonny
 *
 */
public class ConsumerService {
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition(); 
	
	public String consumeMessage(){
		
		String message = null;
		try {
		//获取对象锁
		lock.lock();	 
		if(MessageBrokerService.newInstance().getCapacity()==0){	 
			condition.await();
		}
		 
		if(MessageBrokerService.newInstance().getCapacity()>0){		
			 message = MessageBrokerService.newInstance().getMessage();
			 System.out.println("consumer当前线程["+Thread.currentThread().getName()+"] 消费消息 :"+message);
			 // 设置consumer获取消息标识
			 
				condition.signalAll(); 
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock(); 
		}
		return message;
	}
}
