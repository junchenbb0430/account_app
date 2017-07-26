package com.egfbank.concurrent.message.client;

import com.egfbank.concurrent.message.consumer.ConsumerService;
/**
 * 
 * @author 
 *
 */
public class ConsumerServiceThread implements Runnable {

	private ConsumerService service;
	
	public ConsumerServiceThread(ConsumerService service) {
		super();
		this.service = service;
	}
	
	public void run() {
		service.consumeMessage();
	}

}
