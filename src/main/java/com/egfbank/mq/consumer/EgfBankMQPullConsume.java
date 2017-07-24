package com.egfbank.mq.consumer;

import com.egfbank.mq.consumer.status.EgfConsumeStatus;

public interface EgfBankMQPullConsume {

	public void consumeMessage(String topic,String tag);
}
