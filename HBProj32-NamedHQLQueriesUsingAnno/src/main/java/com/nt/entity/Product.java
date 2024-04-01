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
@NamedQuery(name="HQL_GET_PRODUCTS_BY_PRICE_RANGE",
            query="from Product where price>=:min and price<=:max")
@NamedQuery(name="INCREASE_PRODUCT_PRICE_BY_PRICE_RANGE",
             query="update Product set price=price+:newValue where price>=:range")
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
