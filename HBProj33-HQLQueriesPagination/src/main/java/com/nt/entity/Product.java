package com.nt.entity;



import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name="PRODUCT")
@Entity

public class Product {
	@Id
	@GeneratedValue
	@Column(name="PID")
	private Integer pid;
	@Column(name="PNAME")
	private String pname;
	@Column(name="PRICE")
	private double price;
	@Column(name="QTY")
	private double qty;
	
	public Product() {
		System.out.println("0-Param Constructor::"+this.hashCode());
	}

}
