package com.egfbank.framework.springstudy.chap02.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarTest {

	public static void main(String[] args) {
		String beanXml = "config/spring/spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
		BMWCar car = context.getBean(BMWCar.class);
		car.run();
	}

}
