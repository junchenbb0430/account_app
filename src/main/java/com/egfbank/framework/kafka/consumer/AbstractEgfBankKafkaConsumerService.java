/**
 * 
 */
package com.egfbank.framework.kafka.consumer;

import java.util.Arrays;
import java.util.List;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;

import com.egfbank.framework.kafka.KafkaUtil;
import com.egfbank.framework.kafka.MessageStatus;
import com.egfbank.framework.kafka.message.MessageConsumerResult;

/**
 * @author tonny
 *
 */
public abstract class AbstractEgfBankKafkaConsumerService<K,V> implements
		EgfBankKafkaConsumerService<K,V> {

	private long consumerTimeOut; 
	
	private String topicName;
	
	private Consumer<K,V> consumer ;
	
	public void init(){
		// 创建consumer需要优化改造
		consumer =  KafkaUtil.createConsumer();
	}
	
	public AbstractEgfBankKafkaConsumerService(){
		init();
	}
	
	
	public void consumerMessage(String topicName, int partition) {
		// TODO Auto-generated method stub

	}

	public void  consumerMessageByTopic() {
		
		consumer.subscribe(Arrays.asList(topicName));
		while(true){
			ConsumerRecords<K,V> records = consumer.poll(consumerTimeOut);
			MessageConsumerResult<K,V> messageResult = new MessageConsumerResult<K,V>();  
			messageResult.setConsumerRecords(records);
			dealWithBusinessData(messageResult); 
		} 
		
		
	}
	
	/**
	 * @param messageResult
	 * @return
	 */
	public abstract void dealWithBusinessData(MessageConsumerResult<K,V> messageResult);
	
	public void setConsumerTimeOut(long consumerTimeOut) {
		this.consumerTimeOut = consumerTimeOut;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	public Consumer<K, V> getConsumer() {
		return consumer;
	}

	 
}
