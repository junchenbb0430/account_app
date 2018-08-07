package com.egfbank.framework.kafka.producer;



import org.apache.kafka.clients.producer.ProducerRecord;

import com.egfbank.framework.kafka.message.MessageSendResult;


/**
 * 
 * @author tonny
 *
 */
public interface EgfBankKafkaProducerService<K,V> {

	
	public MessageSendResult sendSyncMessages(ProducerRecord<K,V> producerData);
	
	public MessageSendResult sendAsyncMessages(ProducerRecord<K,V> producerData);
}
