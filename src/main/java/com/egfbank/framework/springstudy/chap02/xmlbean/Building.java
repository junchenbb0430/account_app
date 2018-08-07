package com.egfbank.framework.springstudy.chap02.xmlbean;

import java.util.List;

public class Building {

	private String addresss;
	private String buildingName;	
	private List<String> floorNames;
	private List<House>  houses;
	private BuildingLift buildingLift;
	
	public Building(String address,String buildingName,List<House> houses,
			List<String>floorNames){
		this.addresss = address;
		this.buildingName= buildingName;
		this.houses = houses;
		this.floorNames = floorNames;
	}
	
 
	
	public String getAddresss() {
		return addresss;
	}

	public void setAddresss(String addresss) {
		this.addresss = addresss;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public BuildingLift getBuildingLift() {
		return buildingLift;
	}

	public void setBuildingLift(BuildingLift buildingLift) {
		this.buildingLift = buildingLift;
	}

	public List<String> getFloorNames() {
		return floorNames;
	}

	public void setFloorNames(List<String> floorNames) {
		this.floorNames = floorNames;
	}

	public List<House> getHouses() {
		return houses;
	}

	public void setHouses(List<House> houses) {
		this.houses = houses;
	}

	 
	
}
