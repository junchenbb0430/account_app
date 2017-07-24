package com.egfbank.concurrent.message.consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.egfbank.concurrent.message.MessageBlockMechanism;
import com.egfbank.concurrent.message.broker.MessageBrokerService;

/**
 * 消费者服务,主要是消费者线程调用该服务去消费生产者生产的消息，
 * (或者从broker中获取消息)
 * @author tonny
 *
 */
public class ConsumerService {
	 
	public String consumeMessage(){
		Lock lock = MessageBlockMechanism.getLock();
		Condition condition = MessageBlockMechanism.getLockCondition();
		String message = null;
		try {
		System.out.println("consumer : -->"+condition+",flag = "+MessageBlockMechanism.isProduceConsumeFlag());
		//获取对象锁
		lock.lock();
		System.out.println("***consumer begin executing.....");
		if(MessageBlockMechanism.isProduceConsumeFlag()){
			System.out.println("consumer will wait");
			condition.await();
		}
		
		if(!MessageBlockMechanism.isProduceConsumeFlag()){
			
			 message = MessageBrokerService.newInstance().getMessage();
			// 设置consumer获取消息标识
			MessageBlockMechanism.setProduceConsumeFlag(true);
				condition.signal();
			System.out.println("***consumer  execute  end!.....");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
			System.out.println("***producer release lock ***");
		}
		return message;
	}
}
