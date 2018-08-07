package com.egfbank.framework.kafka.test;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.TopicPartition;

import com.egfbank.framework.kafka.KafkaUtil;
import com.egfbank.framework.utils.FileService;

public class LowerLevelConsumerTest {

	 
	private static String TOPIC_NAME = "egf-payment";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Consumer consumer = KafkaUtil.createConsumer();
		// 订阅topic
		List topics = Arrays.asList(TOPIC_NAME);
		consumer.subscribe(topics);
		TopicPartition partionOne = new TopicPartition(TOPIC_NAME,0);
		TopicPartition partionTwo = new TopicPartition(TOPIC_NAME,1);
		TopicPartition partionThree = new TopicPartition(TOPIC_NAME,2);
		List<TopicPartition> partitions = Arrays.asList(partionOne,partionTwo,partionThree);
		 
		//consumer.assign(partitions);
		while(true){
			ConsumerRecords<String,String> records = consumer.poll(1000); 
			 
			consumer.seekToBeginning(partitions); 
			for(ConsumerRecord<String,String> record:records){
				String content = "topic =["+record.topic()+"],from partition ="+record.partition()+",offset=["+record.offset()+"],"
						+ "key=["+record.key()+"],value =["+record.value()+"]";
				FileService.writeIntoFile(content);
				
				System.out.println(content);
			}
			 
			consumer.commitSync();
		}
	}	

}
