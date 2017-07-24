package com.egfbank.rpc.server;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RpcServerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName= "classpath:config/rpc-producer-context.xml";
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(fileName);
		context.start();
		try {
			Thread.sleep(1000*3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("end!");
	}

}
