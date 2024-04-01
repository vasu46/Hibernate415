package com.nt.entity;

import lombok.Data;

@Data
public class SpecialProduct {
	private Integer pid;
	private String pname;
	private double price;
	private double qty;
	
	public SpecialProduct() {
		System.out.println("0-Param Constructor::");
	}

}
