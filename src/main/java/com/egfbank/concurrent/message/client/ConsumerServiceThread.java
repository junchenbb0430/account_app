package com.egfbank.concurrent.message.client;

import com.egfbank.concurrent.message.consumer.ConsumerService;

public class ConsumerServiceThread implements Runnable {

	private ConsumerService service;
	
	
	
	public ConsumerServiceThread(ConsumerService service) {
		super();
		this.service = service;
	}



	public void run() {
		System.out.println(service.consumeMessage());
	}

}
