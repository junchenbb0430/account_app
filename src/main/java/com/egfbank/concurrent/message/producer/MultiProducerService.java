package com.egfbank.concurrent.message.producer;

import java.util.concurrent.locks.Condition;

import com.egfbank.concurrent.message.MessageBlockMechanism;
import com.egfbank.concurrent.message.broker.MessageBrokerService;

public class MultiProducerService extends ProducerService {

	@Override
	public void producerMessage(Condition condition ,String msg){
		MessageBrokerService.newInstance().putMessage(msg);
		// 设置consumer获取消息标识
		MessageBlockMechanism.setProduceConsumeFlag(false);
		condition.signalAll();
	}
}
