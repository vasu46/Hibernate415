
package com.nt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgrammerProjectInfo {
	//Has-A property
	private ProgrammerProjectId id;
	private String programmerName ;
	private String projectName;
	private double salary;
	private double budget;
	

}
