package com.egfbank.framework.springstudy.chap02.javacode;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BenzCar implements Car {

	@Bean
	public Engine startEngine(){
		return new Engine();
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
