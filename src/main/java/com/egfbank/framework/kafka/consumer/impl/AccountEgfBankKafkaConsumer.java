package com.egfbank.framework.kafka.consumer.impl;

import java.util.List;
import java.util.Set;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.common.TopicPartition;

import com.egfbank.framework.kafka.consumer.AbstractEgfBankKafkaConsumerService;
import com.egfbank.framework.kafka.message.MessageConsumerResult;

public class AccountEgfBankKafkaConsumer<K,V> extends
		AbstractEgfBankKafkaConsumerService<K, V> {

	/**
	 * 每一个partition一个具体的线程去处理,根据每一个partition
	 */
	@Override
	public void dealWithBusinessData(MessageConsumerResult<K, V> messageResult) {
		ConsumerRecords<K,V> consumerRecords = messageResult.getConsumerRecords();
		Set<TopicPartition> topicPartitions = consumerRecords.partitions();
		for(TopicPartition partition:topicPartitions){
			List<ConsumerRecord<K,V>> partitionRecords = consumerRecords.records(partition);
			// TODO 修改为线程池方式
			new Thread(new AccountPartitionConsumer<K,V>(partitionRecords,this.getConsumer())).start();
			
		} 
	}
		
	public static void main(String[] args){															
		String topicName = "egf-payment";
		AbstractEgfBankKafkaConsumerService<String,String> accountConsumer = new AccountEgfBankKafkaConsumer<String,String>();
		accountConsumer.setTopicName(topicName);
		accountConsumer.setConsumerTimeOut(10);
		accountConsumer.consumerMessageByTopic();
	}

}
