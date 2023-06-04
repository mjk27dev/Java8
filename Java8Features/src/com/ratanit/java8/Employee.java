package com.ratanit.java8;

public class Employee {

	private Integer eid;
	private String ename;
	private double esal;

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

	public Employee(Integer eid, String ename, double esal) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.esal = esal;
	}

	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", esal=" + esal + "]";
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
