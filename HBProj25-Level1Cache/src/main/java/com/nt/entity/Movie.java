package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
@Table(name="MOVIE_INFO")
public class Movie {
	@Id
	@Column(name="MID")
	private Integer mid;
	
	@Column(name="MNAME",length=20)
	private  String mname;
	
	@Column(name="HERO",length=20)
	private String hero;
	
	@Column(name="BUDGET")
	private Float budget;
	
	public Movie() {
		System.out.println("Movie::0-param constructor"+this.getClass());
	}
	
	

}
