package com.nt.entity;

import lombok.Data;

@Data
public class Product {
	private Integer pid;
	private String pname;
	private Float price;
	private Float qty;
	
	private String status;
	
	 public void setStatus(String status) {
		 this.status=status;	 
	 }
	 public String getStatus() {
		 return status;
	 }

}
