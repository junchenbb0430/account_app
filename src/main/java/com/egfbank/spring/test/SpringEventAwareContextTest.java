package com.egfbank.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.spring.AccountServiceContext;

public class SpringEventAwareContextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/config/spring-event-study.xml");
		context.start();
		AccountServiceContext service = context.getBean(AccountServiceContext.class);
		System.out.println(service.getServiceName());
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
