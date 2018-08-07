package com.egfbank.framework.springstudy.chap02.setter;

import org.springframework.beans.factory.annotation.Autowired;

public class PassengerPlane implements Plane {

	private String planeName;
	@Autowired 
	private Engine engine;
	
	public void fly() {
		 System.out.println("飞机名称："+this.getPlaneName()+",发动机型号："+this.getEngine().getTypeNo());
	}
	
	public String getPlaneName() {
		return planeName;
	}
	
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	
}
