package com.egfbank.framework.springstudy.chap02.xmlbean;

import java.util.Set;

public class Room {

	private int area;
	
	private Set<String> seatName;
	
	public Room(Set<String> seatName){
		this.seatName = seatName;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public Set<String> getSeatName() {
		return seatName;
	}

	public void setSeatName(Set<String> seatName) {
		this.seatName = seatName;
	}
	
	
}
