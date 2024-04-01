package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PersonDetails {
	private Integer pid;
	private String pname;
	private String addrs;
	private List<String> nickNames;
	private List<String> friends;
	private Set<Long> contactNumbers;
	private Map<String,Long> idDetails;
}
