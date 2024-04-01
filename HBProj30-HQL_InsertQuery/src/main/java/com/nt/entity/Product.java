package com.nt.entity;

import lombok.Data;

@Data
public class Product {
	private Integer pid;
	private String pname;
	private double price;
	private double qty;
	
	public Product() {
		System.out.println("0-Param Constructor::");
	}

}
