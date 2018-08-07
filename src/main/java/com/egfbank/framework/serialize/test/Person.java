package com.egfbank.framework.serialize.test;

public class Person {

	private String  address;
	
	private String name;

	
	
	public Person() {
		super();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person(String name, String address) {
		super();
		this.address = address;
		this.name = name;
	}
	
	
	
}
