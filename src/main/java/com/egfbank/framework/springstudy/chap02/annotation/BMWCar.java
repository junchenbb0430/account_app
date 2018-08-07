package com.egfbank.framework.springstudy.chap02.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.egfbank.framework.springstudy.chap02.javacode.Car;

@Component("bmwCar")
public class BMWCar implements Car {

	@Autowired
	private CarMiddlePanel carMiddlePanel;
	
	
	
	public CarMiddlePanel getCarMiddlePanel() {
		return carMiddlePanel;
	}



	public void setCarMiddlePanel(CarMiddlePanel carMiddlePanel) {
		this.carMiddlePanel = carMiddlePanel;
	}



	public void run() {
		 System.out.println("汽车开动");
	}

}
