package com.egfbank.mq.producer;

import com.egfbank.mq.message.EgfMessage;
import com.egfbank.mq.message.EgfSendResult;

public interface EgfBankMQProducer {
	
	EgfSendResult  sendMessage(String topicName,String tag,EgfMessage message);
}
