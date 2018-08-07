package com.egfbank.framework.springstudy.chap02.xmlbean;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {

	public static void main(String[] args) {
		String beanXml = "config/spring/spring-config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(beanXml);
		Building building = context.getBean(Building.class);
		System.out.println(building.getAddresss()+","+building.getBuildingName()
				+","+building.getBuildingLift().toString());
		for(House house:building.getHouses()){
			System.out.println(house.getFloorName()+","+house.getHouseNum());
			 Set<Map.Entry<String, Room>> rooms = house.getRoomMap().entrySet();
			 for(Map.Entry<String, Room> r:rooms){
				 System.out.println("房间号："+r.getKey()+",房间面积大小："+r.getValue().getArea());
			 } 
		}
		for(String name:building.getFloorNames()){
			System.out.println(name);
		}
	}

}
