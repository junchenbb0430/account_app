package com.egfbank.concurrent.message.producer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

import com.egfbank.concurrent.message.MessageBlockMechanism;
import com.egfbank.concurrent.message.broker.MessageBrokerService;

/**
 * 生产者服务，可以有多个生产者线程调用生产者服务
 * 去生产消息
 * @author tonny
 * 生产者produce消息时，消费者通知生产者，消息已经被消费 了。
 */
public class ProducerService {
 
	
	
	/**
	 * 生产消息的服务
	 */
	public void produceSingleMessage(String msg){
		
		Lock lock = MessageBlockMechanism.getLock();
		Condition condition = MessageBlockMechanism.getLockCondition();
		try {
		 
		//获取对象锁
		lock.lock();
		 
		if(!MessageBlockMechanism.isProduceConsumeFlag()){
			 
			condition.await();
		}	
		if(MessageBlockMechanism.isProduceConsumeFlag()){
			MessageBrokerService.newInstance().putMessage(msg);
			// 设置consumer获取消息标识
			MessageBlockMechanism.setProduceConsumeFlag(false);
				condition.signal();
				System.out.println("***producer  execute  end!.....");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			lock.unlock();
		}
	}
	 
}
