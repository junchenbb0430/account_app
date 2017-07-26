package com.egfbank.concurrent.message.test;

import com.egfbank.concurrent.message.client.ConsumerServiceThread;
import com.egfbank.concurrent.message.client.ProducerServiceThread;
import com.egfbank.concurrent.message.consumer.ConsumerService;
import com.egfbank.concurrent.message.producer.MultiProducerService;
import com.egfbank.concurrent.message.producer.ProducerService;

public class ProducerConsumerMultiTest {

	public static void main(String[] args) {
		ProducerService producer = new MultiProducerService();
		ConsumerService consumer = new ConsumerService();
		for(int i=0;i<10;i++){
			Thread t1 = new Thread(new ProducerServiceThread(producer));
			Thread t2 = new Thread(new ConsumerServiceThread(consumer));
			t1.start();
			t2.start();
		}
	}
}
