package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="HB_COMP_PERSON")
public class Person implements Serializable{
	@Column(name="PID")
	@GeneratedValue
	private Integer pid;
	@Column(name="PNAME",length=20)
	private String pname;
	@Column(name="ADDRS")
	private String paddrs;
	@Embedded
	private JobDetails details;
	

}
