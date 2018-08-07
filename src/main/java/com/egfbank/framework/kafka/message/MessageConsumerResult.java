package com.egfbank.framework.kafka.message;

import java.io.Serializable;

import org.apache.kafka.clients.consumer.ConsumerRecords;

public class MessageConsumerResult<K,V> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8788758435544423444L;
	
	private ConsumerRecords<K,V> consumerRecords;

	public ConsumerRecords<K, V> getConsumerRecords() {
		return consumerRecords;
	}

	public void setConsumerRecords(ConsumerRecords<K, V> consumerRecords) {
		this.consumerRecords = consumerRecords;
	}
	
	

}
