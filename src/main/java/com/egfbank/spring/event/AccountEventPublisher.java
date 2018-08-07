package com.egfbank.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

/**
 * @descritpion
 * @author lijunshi
 * @date 2018年7月9日
 */
 @Service
public class AccountEventPublisher implements ApplicationEventPublisher {

	/**
	 * 
	 */
	@Override
	public void publishEvent(ApplicationEvent event) {
		System.out.println("execute*************************88");
		AccountCalculateEvent  accountEvent =(AccountCalculateEvent)event;
		accountEvent.setMessage("发布事件，看看谁在监听！");
	}

	/**
	 * 
	 */
	@Override
	public void publishEvent(Object event) {
		// TODO Auto-generated method stub

	}

}
