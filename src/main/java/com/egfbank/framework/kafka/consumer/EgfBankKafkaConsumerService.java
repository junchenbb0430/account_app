package com.egfbank.framework.kafka.consumer;


public interface EgfBankKafkaConsumerService<K,V> {
	
	 public void consumerMessage(String topicName,int partition);
	 
	 public void consumerMessageByTopic();
}
