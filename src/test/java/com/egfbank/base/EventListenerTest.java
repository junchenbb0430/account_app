package com.egfbank.base;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.egfbank.spring.event.AccountCalculateEvent;
import com.egfbank.spring.event.AccountEventPublisher;

public class EventListenerTest extends BaseTest {

	@Autowired
	private AccountEventPublisher  publisher;
	
	@Test
	public void testEvent() {
		
		publisher.publishEvent(new AccountCalculateEvent("dddd"));
		System.out.println(publisher);
	}
}
