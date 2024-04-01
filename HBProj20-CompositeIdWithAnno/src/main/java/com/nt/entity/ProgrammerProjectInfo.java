
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="PROGRAMER_PROJECT_INFO1")
public class ProgrammerProjectInfo {
	//Has-A property
	@EmbeddedId
	private ProgrammerProjectId id;
	@Column(name="PRGMR_NAME",length=20)
	private String programmerName ;
	@Column(name="PROJ_NMAE",length=20)
	private String projectName;
	@Column(name="SALARY")
	private double salary;
	@Column(name="BUDGET")
	private double budget;
	

}
