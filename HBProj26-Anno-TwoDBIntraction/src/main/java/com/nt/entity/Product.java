package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="PID")
	private Integer pid;
	@Column(name="PNAME",length=20)
	private String pname;
	@Column(name="PRICE")
	private Double price;
	@Column(name="qty")
	private Float qty;

}
