package com.egfbank.framework.springstudy.chap02.setter.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.egfbank.framework.springstudy.chap02.setter.PassengerPlane;
import com.egfbank.framework.springstudy.chap02.setter.Plane;

public class PlaneTest {

	public static void main(String[] args) {
		String beanXml = "config/spring/spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
		Plane plane = context.getBean(PassengerPlane.class);
		plane.fly();
	}

}
