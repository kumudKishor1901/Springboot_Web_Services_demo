package com.rest.webservices.versioning;

public class PersonV1 {
	private String name ;
	
	PersonV1(){}
	public PersonV1(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
