package com.egfbank.framework.kafka.consumer.impl;

import java.util.List;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import com.egfbank.framework.kafka.consumer.biz.AccountMessageService;
import com.egfbank.framework.kafka.message.EgfBankMessage;

public   class AccountPartitionConsumer<K,V> implements Runnable {

	private List<ConsumerRecord<K,V>>  partitionRecords;
	
	private Consumer<K,V> consumer;
	
	private AccountMessageService accountService;
	
	public AccountPartitionConsumer( List<ConsumerRecord<K,V>>  partitionRecords,Consumer consumer){
		this.partitionRecords = partitionRecords;
		this.consumer = consumer;
	}
	
	public void run() {
		 for(ConsumerRecord<K,V> record:partitionRecords){
			 EgfBankMessage egfBankMessage = new EgfBankMessage();
			 egfBankMessage.setKey(record.key());
			 egfBankMessage.setValue(record.value());
			 egfBankMessage.setTopicName(record.topic());
			 egfBankMessage.setPartition(record.partition());
			 accountService.handleAccountMessage(egfBankMessage);
			 System.out.println("receive message from [topic = "+record.topic()+"],[partition ="+record.partition()+
						"],[offset="+record.offset()+"],[key="+record.key()+"],[value="+record.value()+"]");
		 }
		 consumer.commitSync();
		 try {
			Thread.sleep(2*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}

}
