package com.nt.entity;

import lombok.Data;

@Data
public class Employee extends Person{
	private String desg;
	private Double sal;
	private Integer dept;
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", sal=" + sal + ", dept=" + dept + "]"+super.toString();
	}
    
}
