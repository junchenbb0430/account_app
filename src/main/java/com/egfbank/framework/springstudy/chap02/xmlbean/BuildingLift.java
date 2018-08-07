package com.egfbank.framework.springstudy.chap02.xmlbean;

import org.springframework.stereotype.Component;


public class BuildingLift {

	private int liftNum;
	
	private int weight;

	public int getLiftNum() {
		return liftNum;
	}

	public void setLiftNum(int liftNum) {
		this.liftNum = liftNum;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "liftNum="+this.liftNum+",wight="+this.weight;
	}
	
	
}
