package com.egfbank.spring;

import org.springframework.stereotype.Service;

/**
 * @descritpion
 * @author lijunshi
 * @date 2018年7月9日
 */
@Service
public class Person {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
