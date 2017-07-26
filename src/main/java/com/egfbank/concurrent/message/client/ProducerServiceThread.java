package com.egfbank.concurrent.message.client;

import com.egfbank.concurrent.message.producer.ProducerService;
 
public class ProducerServiceThread implements Runnable {

	private ProducerService service;
	
	public ProducerServiceThread(ProducerService service) {
		super();
		this.service = service;
	}
	public void run() {
		service.putMessage("hello");

	}

}
