package com.society.mainteananceMgmt.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MainteanceInfo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int id;
	
	@NotNull
	private String owner;
	
	@NotNull
	private String issue;
	
	@NotNull
	private String issueStatus;
	
	@NotNull
	private String assignedTo;
	

}
