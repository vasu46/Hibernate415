package com.nit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MOVIE_INFO")
@Data
public class Movie {
	@Id
	@Column(name="MID")
	private Integer mid;
	
	@Column(name="MNAME")
	private String mname;
	
	@Column(name="HERO")
	private String hero;
	
	@Column(name="BUDGET")
	private Float budget;
	

}
