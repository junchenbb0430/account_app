package com.egfbank.framework.kafka.test;

import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.egfbank.framework.kafka.KafkaUtil;
import com.egfbank.framework.utils.EgfDateUtils;

public class LowerLevelProducerTest<K,V> {

	
	 
	public Future<RecordMetadata> syncSendKafkaMessage(String topicName,K key,V value){
		Producer producer = KafkaUtil.createProducer();
		ProducerRecord<K,V> record = new ProducerRecord(topicName,key,value);
		Future<RecordMetadata> future = producer.send(record);
		return future;
	}
	
	
	public Future<RecordMetadata> asyncSendKafkaMessage(String topicName,K key,V value){
		Producer<K,V> producer = KafkaUtil.createProducer();
		ProducerRecord<K,V> record = new ProducerRecord(topicName,key,value);
		Future<RecordMetadata> future = producer.send(record, new Callback(){

			public void onCompletion(RecordMetadata metadata,
					Exception exception) {
				 
			}
			
		});
		 return future;
	}
	
	public static void main(String[] args) {
		String topicName = "egf-account";
		LowerLevelProducerTest producerManager = new LowerLevelProducerTest();
		 Future<RecordMetadata> recordMetada = null;
		for(int i=1;i<20;i++){
			String key = EgfDateUtils.formateCurrentDate();
			recordMetada = producerManager.syncSendKafkaMessage(topicName,key,key+"_"+i); 
			System.out.println(recordMetada); 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	 
	}

}
