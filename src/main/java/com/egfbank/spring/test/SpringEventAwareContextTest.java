package com.egfbank.spring.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.spring.AccountServiceContext;
import com.egfbank.spring.Person;
import com.egfbank.spring.event.AccountCalculateEvent;
import com.egfbank.spring.event.AccountEventPublisher;

public class SpringEventAwareContextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath*:/config/spring-context.xml");
		 
		AccountServiceContext service = context.getBean(AccountServiceContext.class);
		System.out.println(service.getServiceName());
		Person p = context.getBean(Person.class);
		AccountEventPublisher publisher = context.getBean(AccountEventPublisher.class);
		AccountCalculateEvent event = new AccountCalculateEvent("account_calculate");
		publisher.publishEvent(event);
		try {
			Thread.sleep(Integer.MAX_VALUE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}

}
