package com.ratanit.java8;

public class Employee {

	private Integer eid;
	private String ename;
	private double esal;
	int age;

	public Employee(Integer eid, String ename, double esal, int age) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", age=" + age + "]";
	}

	public Integer getEid() {
		return eid;
	}

	public void setEid(Integer eid) {
		this.eid = eid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getEsal() {
		return esal;
	}

	public void setEsal(double esal) {
		this.esal = esal;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

//	Custom Filter method

	public boolean salaryCheck() {

		return this.esal > 25000;
	}

	public boolean nameCheck() {
		return this.ename.startsWith("A");
	}

	public double addSalary() {
		return this.esal + 500;
	}
}
