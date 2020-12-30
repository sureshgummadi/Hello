package com.app.model;

public class EmployeeA {

	private String name;
	private int salary;
	
	public EmployeeA(String name, int salary) {
		super();
		
		this.name = name;
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		int hashCode = 0;
		hashCode=salary*20;
		hashCode=hashCode+name.hashCode();
		return hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof EmployeeA)
		{
			EmployeeA em=(EmployeeA)obj;
			return (em.name.equals(this.name) && em.name==this.name);
		}else {
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	
}
