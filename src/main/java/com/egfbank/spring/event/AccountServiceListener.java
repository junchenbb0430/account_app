package com.egfbank.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * @descritpion  监听器实现ApplicationListener，针对哪个具体的事件进行监听。
 *               必须事先发布事件，即发生事件，才能监听。
 * @author lijunshi
 * @param <E>
 * @date 2018年7月9日
 */
@Service
public class AccountServiceListener implements ApplicationListener<AccountCalculateEvent> {

	/****
	 * 观察监听AccountCalculateEvent事件
	 */
	@Override
	public void onApplicationEvent(AccountCalculateEvent event) {
		// TODO Auto-generated method stub
		System.out.println("观察到该事件发生的内容为 ： "+event.getMessage());
	}

}
