package com.egfbank.concurrent.message.test;

import com.egfbank.concurrent.message.client.ConsumerServiceThread;
import com.egfbank.concurrent.message.client.ProducerServiceThread;
import com.egfbank.concurrent.message.consumer.ConsumerService;
import com.egfbank.concurrent.message.producer.ProducerService;
import com.egfbank.concurrent.message.producer.SingleProducerService;

public class ProducerConsumerOne2OneTest {

	public static void main(String[] args) {
		
		ProducerService producer = new SingleProducerService();
		ConsumerService consumer = new ConsumerService();
		 
		Thread t1 = new Thread(new ProducerServiceThread(producer));
		Thread t2 = new Thread(new ConsumerServiceThread(consumer));
		t1.start();
		t2.start();
	}

}
