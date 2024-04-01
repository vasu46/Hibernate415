package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Entity;

import lombok.Data;

@Data
@Entity
public class Person implements Serializable{
	private Integer pid;
	private String pname;
	private String paddrs;
	private JobDetails details;
	

}
