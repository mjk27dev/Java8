package com.ratanit.java8;

import java.util.List;

public class EmployeeFlatMap {

	String name;
	List<Long> phones;
	public EmployeeFlatMap(String name, List<Long> phones) {
		super();
		this.name = name;
		this.phones = phones;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getPhones() {
		return phones;
	}
	public void setPhones(List<Long> phones) {
		this.phones = phones;
	}
	
}
