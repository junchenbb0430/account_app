package com.egfbank.framework.springstudy.chap02.xmlbean;

import java.util.Map;

public class House {

	private String floorName;
	
	private int houseNum;
	
	private Map<String, Room> roomMap;
	
	public House(Map<String, Room> roomMap){
		this.roomMap = roomMap;
	}

	public String getFloorName() {
		return floorName;
	}

	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}

	public int getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(int houseNum) {
		this.houseNum = houseNum;
	}

	public Map<String, Room> getRoomMap() {
		return roomMap;
	}

	public void setRoomMap(Map<String, Room> roomMap) {
		this.roomMap = roomMap;
	}
	
	
}
