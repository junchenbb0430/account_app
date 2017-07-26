package com.egfbank.concurrent.message.producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.egfbank.concurrent.message.MessageBlockMechanism;

/**
 * 生产者服务，可以有多个生产者线程调用生产者服务
 * 去生产消息
 * @author tonny
 * 生产者produce消息时，消费者通知生产者，消息已经被消费 了。
 */
public abstract class ProducerService {	
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	/**
	 * 生产消息的服务
	 */
	public void putMessage(String msg){	
		 
		try {
		//获取对象锁
		lock.lock(); 
		if(!MessageBlockMechanism.isProduceConsumeFlag()){		 
			condition.await();
		}
		if(MessageBlockMechanism.isProduceConsumeFlag()){
			producerMessage(condition,msg);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock(); 
		}
	}
	 
	public abstract void producerMessage(Condition condition,String msg);
}
