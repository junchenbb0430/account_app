package com.egfbank.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * @descritpion
 * @author lijunshi
 * @date 2018年7月9日
 */

public class AccountCalculateEvent extends ApplicationEvent {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 9131680114640762866L;

	private  String message;
	
	public AccountCalculateEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
