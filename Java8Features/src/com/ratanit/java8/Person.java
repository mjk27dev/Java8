package com.ratanit.java8;

/**
 * @author Manoj Kumar
 *
 */
public class Person {

	public String name;
	public int age;
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	
	public int newAge() {
		return this.age+2;
	}
 }
